package DAO;

import com.mysql.jdbc.Statement;
import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tassyosantana
 */

public class ClienteDAO {
  private Conexao conexao;
  private Statement statement;

  public ClienteDAO() throws SQLException, ClassNotFoundException{
    conexao = new Conexao();
    try{
      statement = (Statement) conexao.getConn().createStatement();
    } catch (SQLException  ex) {
      throw ex;
    }
  }

  public List<Cliente> lista() throws SQLException {
    List<Cliente> listaClientes = new ArrayList<Cliente>();
    try{
      ResultSet rs = statement.executeQuery("select * from clientes order by nome");
      while (rs.next()) {
        Cliente cliente = new Cliente();
        cliente.setCodCli(rs.getInt("codcli"));
        cliente.setNome(rs.getString("nome"));
        cliente.setBonus(rs.getFloat("bonus"));
        cliente.setPerfil(rs.getString("perfil"));
        cliente.setStatus(rs.getString("status"));
        listaClientes.add(cliente);
      }
    
    } catch (SQLException e){
      e.printStackTrace();
    } finally {
      conexao.fecharConexao();
    }

    return listaClientes;
  }

}
