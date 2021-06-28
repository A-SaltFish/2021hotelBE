package com.rainng.coursesystem.service;

import com.rainng.coursesystem.dao.mapper.CustomerLoginMapper;
import com.rainng.coursesystem.model.entity.CustomerLogin;
import com.rainng.coursesystem.model.vo.CustomerLoginVo;
import com.rainng.coursesystem.model.vo.CustomerLoginVoToCustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private CustomerLoginMapper customerLoginMapper;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 给前端输入的邮箱发送验证码
     * @param customer_email
     * @param session
     * @return
     */

    public boolean sendMimeMail(String customer_email,HttpSession session){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("验证码邮件");//主题
            //生成随机数
            String code = randomCode();

            //将随机数放置到session中
            session.setAttribute("customer_email",customer_email);
            session.setAttribute("code",code);

            mailMessage.setText("您收到的验证码是："+code);//内容

            mailMessage.setTo(customer_email);//发给谁

            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 随机生成六位数验证码
     * @return String code
     */
    private String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /**
     * 检验验证码是否一致
     * @param  customerLoginVo
     * @param  session
     */

    public boolean registered(CustomerLoginVo customerLoginVo, HttpSession session){
        System.out.println("regist called");
        //获取session中的验证信息
//        String customer_email = (String) session.getAttribute("customer_email");
        String code = (String) session.getAttribute("code");

        String customer_email = customerLoginVo.getCustomer_email();

        System.out.println(customer_email);

        //获取表单中的提交的验证信息
        String voCode = customerLoginVo.getCode();
        System.out.println(voCode);
        System.out.println(code);
        //如果email数据为空，或者不一致，注册失败
        if (customer_email == null || customer_email.isEmpty()){
            System.out.println("quit1");
            //return "error,请重新注册";
            return false;
        }
        if (!code.equals(voCode)){
            System.out.println("quit2");
            //return "error,请重新注册";
            return false;
        }

        //保存数据
        CustomerLogin customerLogin = CustomerLoginVoToCustomerLogin.toUser(customerLoginVo);

        //将数据写入数据库
        System.out.println("写入数据库");
        System.out.println(customerLogin);
        customerLoginMapper.insertUser(customerLogin);
        System.out.println("写入完毕");
        //跳转成功页面
        return true;
    }

    /**
     * 通过输入email查询password，然后比较两个password，如果一样，登录成功
     * @return
     */

    public boolean loginIn(String customer_email, String customer_password){
        System.out.println(customer_email);
        System.out.println(customer_password);
        CustomerLogin customerLogin = customerLoginMapper.queryByEmail(customer_email);
        if(customerLogin ==null)
            System.out.println("空");
        else{
            if(!customerLogin.getCustomer_password().equals(customer_password))
                return false;
        }
        System.out.println("登录成功:数据库密码是："+ customerLogin.getCustomer_password());
            return true;
    }

}


