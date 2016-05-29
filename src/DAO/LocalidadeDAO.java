
package DAO;

import Model.Localidade;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tassyosantana
 */
public class LocalidadeDAO {
  private Conexao conexao;
  private Statement statement;

  public LocalidadeDAO() throws SQLException, ClassNotFoundException{
    conexao = new Conexao();
    try{
      statement = (Statement) conexao.getConn().createStatement();
    } catch (SQLException  ex) {
      throw ex;
    }
  }

public List<Localidade> lista() throws SQLException{
    List<Localidade> listaLocalidade = new ArrayList<Localidade>();
    try{
      ResultSet rs = statement.executeQuery("select * from localidades order by nome");
      while (rs.next()) {
        Localidade localidade = new Localidade();
        localidade.setCodLocal(rs.getInt("codlocal"));
        localidade.setNome(rs.getString("nome"));
        localidade.setEndereco(rs.getString("endereco"));
        localidade.setTelefone(rs.getString("telefone"));
        listaLocalidade.add(localidade);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      conexao.fecharConexao();
    }
    return listaLocalidade;
  }
}
