package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class giúp tạo kết nối tới cơ sở dữ liệu MySQL.
 */
public class ConnectionDriverUtils {

    // URL kết nối tới cơ sở dữ liệu MySQL
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    
    // Tên đăng nhập MySQL
    static final String USER = "root";
    
    // Mật khẩu đăng nhập MySQL
    static final String PASS = "123456";

    /**
     * Phương thức static giúp lấy đối tượng Connection tới database
     * @return Connection nếu kết nối thành công, null nếu có lỗi
     */
    public static Connection getConnection() {
        try {
            // Tạo kết nối tới database với thông tin cấu hình
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            return con;
        } catch (SQLException e) {
            // Nếu có lỗi trong quá trình kết nối, in lỗi ra và trả về null
            e.printStackTrace();
            return null;
        }
    }
}
