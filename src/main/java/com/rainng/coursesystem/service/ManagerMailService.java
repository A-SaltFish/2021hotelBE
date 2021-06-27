//package com.rainng.coursesystem.service;
//
//
//import com.rainng.coursesystem.dao.mapper.ManagerLoginMapper;
//import com.rainng.coursesystem.model.entity.CustomerLogin;
//import com.rainng.coursesystem.model.entity.ManagerLogin;
//import com.rainng.coursesystem.model.vo.CustomerLoginVo;
//import com.rainng.coursesystem.model.vo.CustomerLoginVoToCustomerLogin;
//import com.rainng.coursesystem.model.vo.ManagerLoginVo;
//import com.rainng.coursesystem.model.vo.ManagerLoginVoToManagerLogin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//import java.util.Random;
//
//@Service
//public class ManagerMailService {
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private ManagerLoginMapper managerLoginMapper;
//
//    @Value("${spring.mail.username}")
//    private String from;
//
//    /**
//     * 给前端输入的邮箱发送验证码
//     * @param manager_email
//     * @param session
//     * @return
//     */
//
//    public boolean sendMimeMail(String manager_email, HttpSession session){
//        try{
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setSubject("验证码邮件");//主题
//            //生成随机数
//            String code = randomCode();
//
//            session.setAttribute("manager_email",manager_email);
//            session.setAttribute("code",code);
//
//            mailMessage.setText("收到的验证码是："+code);//内容
//
//            mailMessage.setTo(manager_email);//发给谁
//
//            mailMessage.setFrom(from);//你自己的邮箱
//
//            mailSender.send(mailMessage);//发送
//
//            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//    private String randomCode() {
//        StringBuilder str = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            str.append(random.nextInt(10));
//        }
//        return str.toString();
//    }
//
//
//
//    public boolean mgregistered(ManagerLoginVo managerLoginVo, HttpSession session){
//        //获取session中的验证信息
//        String manager_email = (String) session.getAttribute("manager_email");
//        String code = (String) session.getAttribute("code");
//
//        String voCode = managerLoginVo.getCode();
//
//
//        if (manager_email == null || manager_email.isEmpty()){
//
//            return false;
//        }
//        if (!code.equals(voCode)){
//
//            return false;
//        }
//
//        //保存数据
//        ManagerLogin managerLogin = ManagerLoginVoToManagerLogin.toManager(managerLoginVo);
//
//        //将数据写入数据库
////        System.out.println("写入数据库");
////        System.out.println(managerLogin);
//        managerLoginMapper.insertManager(managerLogin);
//        System.out.println("写入完毕");
//        //跳转成功页面
//        return true;
//    }
//
//    /**
//     * 通过输入email查询password，然后比较两个password，如果一样，登录成功
//     * @return
//     */
//
//    public boolean loginIn(String manager_email, String manager_password){
//        System.out.println(manager_email);
//        System.out.println(manager_password);
//       ManagerLogin managerLogin = managerLoginMapper.queryByEmail(manager_email);
//        if(managerLogin ==null)
//            System.out.println("空");
//        else{
//            if(!managerLogin.getManager_password().equals(manager_password))
//                return false;
//        }
//        System.out.println("登录成功:数据库密码是："+ managerLogin.getManager_password());
//        return true;
//    }
//}
