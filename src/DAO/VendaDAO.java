
package DAO;
import Model.Venda;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tassyosantana
 */
public class VendaDAO {
  private Conexao conexao;
  private Statement statement;

  public VendaDAO() throws SQLException, ClassNotFoundException{
    conexao = new Conexao();
    try{
      statement = (Statement) conexao.getConn().createStatement();
    } catch (SQLException ex) {
      throw ex;
    }
  }
  
  public String atualizaEstoqueInsereVenda(Venda venda) throws SQLException{
       try {
         String msg="";
         conexao.autoCommit(false);

         String query1 ="update produtos set qtd_estoque = qtd_estoque - "+ venda.getQtdVenda()+
                                   " where codprod = "+venda.getCodProd().toString()+ ""; 

         String query2 = "insert into vendas values( "+
                                            venda.getCodCli()+" , "+
                                            venda.getCodProd()+" , "+
                                            venda.getCodLocal()+" , "+
                                            venda.getQtdVenda()+" , "+
                                            venda.getValorTotal()+" , "+
                                            " ver como colocar a data!!!)";

         statement.executeUpdate(query1);
         statement.executeUpdate(query2);
         
         conexao.commit();
         
         msg= "Transação OK";
         return msg;
        } catch (SQLException e) {
          conexao.rollback();
          return e.getMessage();
        
        } finally {
            conexao.fecharConexao();        
        }
  }

}
