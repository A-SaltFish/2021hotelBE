package com.rainng.coursesystem.dao.mapper;


import com.rainng.coursesystem.model.entity.CustomerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
    @Insert("insert into ht_customer(customer_name,customer_password,customer_email,customer_tel) values(#{customer_name},#{customer_password},#{customer_email},#{customer_tel})" )
    int insertcustomer(CustomerEntity customer);

    @Select("select customer_id,customer_name from ht_customer where customer_name = #{customer_name} and customer_password = #{customer_password}")
    CustomerEntity login(String customer_name,String customer_password);

    @Select("select customer_email from ht_customer where customer_email = #{customer_email}")
    CustomerEntity findemail(String customer_email);

    @Select("select customer_name from ht_customer where customer_name = #{customer_name}")
    CustomerEntity findname(String customer_name);
}