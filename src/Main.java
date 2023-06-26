import java.sql.*;
public class Main {
    //We need mysql-connector-java for loading the driver
    //IntelliJ : File->Project Structure->modules->+->from maven->search fr mysql-connector-java and download to lib
 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver is Deprecated
 static final String DB_URL= "jdbc:mysql://localhost:3306/school";
 static final String username = "root";
 static final String password = "";
    public static void main(String[] args)throws SQLException {
        Connection con =null;
        Statement st=null;
        String sql;
        ResultSet rs=null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, username, password);
            st=con.createStatement();
            sql = "Select * from student";
            String sql2 = "update student set name='Jitesh' where id=1 ";
            rs = st.executeQuery(sql);
           while(rs.next()){
                System.out.println(rs.getString(2) + rs.getInt(1));
            }
           st.execute(sql2);

        } catch (Exception e) {
            System.out.println(e);
           // throw new RuntimeException(e);
        }
        }
    }
