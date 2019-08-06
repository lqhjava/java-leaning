package com.ming;

import com.ming.vo.Employee;
import com.sun.rowset.internal.Row;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class SpringJDBCTest {

    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;

    @Before
    public void testInit(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDataBase(){
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void testUpdate(){
        int flag = 0;
        //获取jdbc模板
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String strSql = "update employee set employeeName=? where employeeId=?";
        try {
            flag = jdbcTemplate.update(strSql,"YYY",1);
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "insert into employee (employeeName,departNum) values (?,?)";
            List<Object[]> objList = new ArrayList<Object[]>();
            objList.add(new Object[]{"UUU",1});
            objList.add(new Object[]{"RRR",2});
            objList.add(new Object[]{"TTT",3});
            jdbcTemplate.batchUpdate(strSql,objList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        int flag = 0;
        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "delete from employee where employeeId = ?";
            flag = jdbcTemplate.update(strSql,11);
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testSelect(){

        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "select * from employee where employeeId = ?";
            RowMapper rowMapper = new BeanPropertyRowMapper(Employee.class);
            Employee employee = (Employee) jdbcTemplate.queryForObject(strSql,rowMapper,3);
            System.out.println(employee);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
