package com.util;

import java.sql.*;

public class DBUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://localhost;database=test";
        username = "sa";
        password = "123456";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
