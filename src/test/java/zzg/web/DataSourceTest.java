package zzg.web;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhenguo
 * on 2018/6/22
 * info:
 */

public class DataSourceTest {

    public static void main(String [] a){

        process();
    }
    /**
     * 加载驱动
     * */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * */
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true";
        String username = "root";
        String password = "newstart2017";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 获取statement对象，操作数据库，处理返回结果
     * */
    public static void process() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user";
        try {
            ps = con.prepareStatement(sql);
            if (ps.execute()) {
                rs = ps.getResultSet();
            } else {
                int i = ps.getUpdateCount();
            }
            printResultSet( rs );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }
    }

    /**
     * 处理返回结果集
     * */
    public static void printResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            StringBuffer b = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    b.append(meta.getColumnName(i) + "=");
                    b.append(rs.getString(i) + "/t");
                }
                b.append("/n");
            }
            System.out.print(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     * */
    public static void close(ResultSet rs, Statement stm, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stm != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
