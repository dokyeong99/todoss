package com.playdata.todos.config;

import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
    private final String url = "jdbc:mysql://localhost:3306/todos" +
            "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String username = "root";
    private final String password = "1q2w3e4r!!";

    public java.sql.Connection getJdbc() {
        java.sql.Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
//        System.out.println("연동 성공");
        }
        return conn;
    }
}