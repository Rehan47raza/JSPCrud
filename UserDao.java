package com.dao;


import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.bean.User;  
public class UserDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
    	System.out.println(oracle.jdbc.driver.OracleDriver.BUILD_DATE);
        System.out.println(Class.class.desiredAssertionStatus());
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        con=DriverManager.getConnection("jdbc:oracle:thin:@INGNRGPILPHP01:1521:ORCLILP","aja185core","aja185core");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into register_1190848(id,name,password,email,sex,country) values(?,?,?,?,?,?)");
        ps.setInt(1,u.getId()); 
        ps.setString(2,u.getName());  
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getEmail());  
        ps.setString(5,u.getSex());  
        ps.setString(6,u.getCountry());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update register_1190848 set name=?,password=?,email=?,sex=?,country=? where id=?");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());  
        ps.setString(3,u.getEmail());  
        ps.setString(4,u.getSex());  
        ps.setString(5,u.getCountry());  
        ps.setInt(6,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from register_1190848 where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllRecords(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register_1190848");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setSex(rs.getString("sex"));  
            u.setCountry(rs.getString("country"));  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register_1190848 where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setSex(rs.getString("sex"));  
            u.setCountry(rs.getString("country"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  
