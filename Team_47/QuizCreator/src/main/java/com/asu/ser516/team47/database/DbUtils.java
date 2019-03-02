package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
    public static void closeConnections(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) { rs.close();}
            if (stmt != null) { stmt.close();}
            if (conn != null) { conn.close();}
        } catch (Exception e) { e.printStackTrace(); }
    }
}
