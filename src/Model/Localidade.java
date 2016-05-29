
package Model;

/**
 *
 * @author tassyosantana
 */
public class Localidade {
  private Integer codLocal;
  private String nome;
  private String endereco;
  private String telefone;

  public Integer getCodLocal(){
    return this.codLocal;
  }

  public void setCodLocal(Integer codLocal){
    this.codLocal = codLocal;
  }

  public String getNome(){
    return this.nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getEndereco(){
    return this.endereco;
  }

  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  public String getTelefone(){
    return this.telefone;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }
}
