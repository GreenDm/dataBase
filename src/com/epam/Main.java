package com.epam;

import java.sql.*;

/**
 * Created by m18 on 11.04.2016.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            //Statement
            Statement statement = connection.createStatement();//1.
            ResultSet rS = statement.executeQuery("SELECT* FROM BOOK WHERE NAME='Kobzar'");//2.
            while (rS.next()){
              String name =  rS.getString("name");
                int year =  rS.getInt("year");
                System.out.println(name + " "+ year);

            }
            //PreparedStatement
            String str = "select* from book where name=?";//1.
            PreparedStatement ps = connection.prepareStatement(str);//2
            ps.setString(1,"Kobzar");//3
            ResultSet rs = ps.executeQuery();//4
            while (rs.next()){
                String name =  rs.getString("name");
                int year =  rs.getInt("year");
                System.out.println(name + " "+ year);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
