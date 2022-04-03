package connection;

import java.sql.*;

public class DataBaseConnection{
    private final String DBDriver ="com.mysql.jdbc.Driver";
    private final String DBURL ="jdbc:mysql://localhost:3306/dao";
    private final String DBUSER ="root";
    private final String DBPASSWORD ="123456";
    private Connection conn = null;
//������
    public DataBaseConnection(){
       try{
           Class.forName(DBDriver);
           conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
           }
        catch(Exception e){  }
                                 }

//�������
public Connection getConnection(){
return this.conn; }

//�ر�����
public void close() throws SQLException{
    this.conn.close(); }
} 
