package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

/**
 *
 * @author tassyosantana
 */
public class Conexao {
 
  private String driver = "com.mysql.jdbc.Driver";
  private String URL = "jdbc:mysql://localhost:3306/ponto_de_venda_development";
  private String USER = "root";
  private Connection conn;

  public Conexao() throws SQLException, ClassNotFoundException{
    try{
      Class.forName(driver);
      conn = (Connection) DriverManager.getConnection(URL, USER,"");
    }catch (SQLException | ClassNotFoundException e) {
      throw e;
    }
  }

  public Connection getConn(){
    return conn;    
  }

  public void fecharConexao() throws SQLException{
    try {
      conn.close();
    }catch (SQLException e){
      throw e;
    }
  }
}
