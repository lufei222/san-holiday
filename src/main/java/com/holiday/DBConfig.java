package com.holiday;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 数据库连接配置文件
 */
public class DBConfig {

    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/kaoqin?serverTimezone=GMT%2B8&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    static final String user ="root";
    static final String password="root";
    
    static Connection conn = null;
    ResultSet res = null;

    static DBConfig db = new DBConfig();

    public DBConfig(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connnectDB_load_jdbc_success");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("装载 JDBC/ODBC 驱动程序失败。" );
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("无法连接数据库" );
            e.printStackTrace();
        }
    }
    public static void connnectDB() {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("connnectDB_load_jdbc_success");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                  System.err.println("装载 JDBC/ODBC 驱动程序失败。" );  
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.err.println("无法连接数据库" ); 
                e.printStackTrace();
            }
    }

    // 查询
    public ResultSet select(String sql, String str[]) {
        connnectDB();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

        // 增删修改
    public int AddU(String sql, String str[]) {
        int a = 0;
        connnectDB();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

    // 增删修改
    public static int batchInsert(List<LinkedHashMap<String, String>> list, String sql) {
        int a = 0;
//        connnectDB();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            int size = list.size();
            for(int i=0;i<size;i++){
                LinkedHashMap<String, String> map = list.get(i);
                int index =1;
                for (Map.Entry<String,String> entity : map.entrySet()) {
                    st.setString(index, entity.getValue());
                    index++;
                }
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

    public int execSql(String sql) {
        int a = 0;
//        connnectDB();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }


    public static List<LinkedHashMap<String, Object>> getListFromDb(String tableName) {
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        try {
            String sql="select * from " + tableName;
            ResultSet rs= db.select(sql, null);
            while (rs.next()) {
                LinkedHashMap<String,Object> resultMap = new LinkedHashMap<String,Object>();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    resultMap.put(metaData.getColumnName(i), rs.getString(i));
                }
                list.add(resultMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<LinkedHashMap<String, Object>> getListSql(String sql) {
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        try {
            ResultSet rs=db.select(sql, null);
            while (rs.next()) {
                LinkedHashMap<String,Object> resultMap = new LinkedHashMap<String,Object>();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    resultMap.put(metaData.getColumnLabel(i), rs.getString(i));
                }
                list.add(resultMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
