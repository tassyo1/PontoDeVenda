
package DAO;
import Model.Venda;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
  
  public String insereVendaAtualizaEstoque(Venda venda) throws SQLException{
       try {
         conexao.autoCommit(false);

         String query1 ="update produtos set qtd_estoque = qtd_estoque - "+ venda.getQtdVenda()+
                                   " where codprod = "+venda.getCodProd().toString()+ ""; 

         String query2 = "insert into vendas values( "+
                                            venda.getCodCli()+" , "+
                                            venda.getCodProd()+" , "+
                                            venda.getCodLocal()+" , "+
                                            venda.getQtdVenda()+" , "+
                                            venda.getValorTotal()+" , "+
                                            " now())";

         statement.executeUpdate(query1);
         statement.executeUpdate(query2);
         
         conexao.commit();
         
         
         return "";
        } catch (SQLException e) {
          conexao.rollback();
          return e.getMessage();
        
        } finally {
            conexao.fecharConexao();        
        }
  }
  
  public List<Venda> listaItensVendidos(Integer codCli) throws SQLException{
       List<Venda> lista = new ArrayList<Venda>();
      try{
      ResultSet rs = statement.executeQuery("select descricao, qtd_venda, preco_unitario,"
              + " valor_total, data_venda  from vendas a, produtos b, clientes c "
              + " where a.codprod = b.codprod and c.codcli = "+codCli);
      while (rs.next()) {
        Venda venda = new Venda();
        venda.setDescricao(rs.getString("descricao"));
        venda.setQtdVenda(rs.getInt("qtd_venda"));
        venda.setPreco_unitario(rs.getFloat("preco_unitario"));
        venda.setValorTotal(rs.getFloat("valor_total"));
        venda.setDataVenda(rs.getTimestamp("data_venda"));
        lista.add(venda);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      conexao.fecharConexao();
    }
    return lista;
  }
  
  public String deletaVendaAtualizaEstoque(Venda venda, Boolean devolve) throws SQLException{
       try {
         conexao.autoCommit(false);

         String query1 ="update produtos set qtd_estoque = qtd_estoque + "+ venda.getQtdVenda()+
                                   " where codprod = "+venda.getCodProd().toString()+ ""; 

         String query2 = "delete vendas where codcli ="+venda.getCodCli()+
                 " and data_venda = "+venda.getDataVenda();
         
         String query3 = "update clientes set bonus = bonus + 100 where codcli = "+
                 venda.getCodCli();

         statement.executeUpdate(query1);
         statement.executeUpdate(query2);
         if(devolve)
             statement.executeUpdate(query3);
        
         
         conexao.commit();
         
         
         return "";
        } catch (SQLException e) {
          conexao.rollback();
          return e.getMessage();
        
        } finally {
            conexao.fecharConexao();        
        }
  }
  
  public Venda buscaVendaDelecao(Integer codCli, Integer codProd, Timestamp data) throws SQLException{
      Venda venda = new Venda();
      try{
      ResultSet rs = statement.executeQuery("select * from "
              + " vendas where codcli = "+codCli + " and codprod = "+
              codProd+ " and data_agendada ="+data);
      while (rs.next()){
          venda.setCodCli(rs.getInt("codcli"));
          venda.setCodLocal(rs.getInt("codlocal"));
          venda.setCodProd(rs.getInt("codprod"));
          venda.setQtdVenda(rs.getInt("qtd_venda"));
          venda.setValorTotal(rs.getFloat("valor_total"));
          venda.setDataVenda(rs.getTimestamp("data_venda"));    
      }
      
      } catch (SQLException e){
          e.printStackTrace();  
      } finally{
        conexao.fecharConexao();
      }
      return venda; 
    }
  
}
