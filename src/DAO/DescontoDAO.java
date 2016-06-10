package DAO;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tassyosantana
 */
public class DescontoDAO {
  private Conexao conexao;
  private Statement statement;

  public DescontoDAO() throws SQLException, ClassNotFoundException{
    conexao = new Conexao();
    try{
      statement = (Statement) conexao.getConn().createStatement();
    } catch (SQLException ex) {
      throw ex;
    }
  }
  
  public Integer buscaPercentual(Integer codProd, Integer qtd) throws SQLException{
      Integer percentual=0;
      
      try{
        ResultSet rs = statement.executeQuery("select percentual from descontos "
                + "where codprod = "+codProd + 
                " and qtd_min >= " +qtd+ " and qtd_max <= "+qtd);
        while (rs.next()) {
        
         percentual = rs.getInt("percentual");
              
        }
      } catch (SQLException e){
          e.printStackTrace();
      }finally{
          conexao.fecharConexao();
      }
      return percentual;
  }
  
}
