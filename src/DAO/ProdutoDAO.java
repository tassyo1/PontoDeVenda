package DAO;

import Model.Produto;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tassyosantana
 */
public class ProdutoDAO {

  private Conexao conexao;
  private Statement statement;

  public ProdutoDAO() throws SQLException, ClassNotFoundException{
    conexao = new Conexao();
    try{
      statement = (Statement) conexao.getConn().createStatement();
    } catch (SQLException ex) {
      throw ex;
    }
  }

  
  public List<Produto> lista() throws SQLException{
    List<Produto> listaProduto = new ArrayList<Produto>();
    try{
      ResultSet rs = statement.executeQuery("select * from produtos order by descricao");
      while (rs.next()) {
        Produto produto = new Produto();
        produto.setCodProd(rs.getInt("codprod"));
        produto.setCodLocal(rs.getInt("codlocal"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setQtdEstoque(rs.getInt("qtd_estoque"));
        produto.setPrecoUnitario(rs.getFloat("preco_unitario"));
        listaProduto.add(produto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conexao.fecharConexao();
    }
    return listaProduto;
  }
}
