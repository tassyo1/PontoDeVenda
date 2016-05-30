
package Model;

/**
 *
 * @author tassyosantana
 */
public class Cliente {
  private Integer codCli;
  private String nome;
  private Float bonus;
  private String perfil;
  private String status;

  public Integer getCodCli(){
    return this.codCli;
  }

  public void setCodCli(Integer codCli){
    this.codCli = codCli;
  }

  public String getNome(){
    return this.nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public Float getBonus(){
    return this.bonus;
  }

  public void setBonus(Float bonus){
    this.bonus = bonus;
  }
  public String getPerfil(){
    return this.perfil;
  }

  public void setPerfil(String perfil){
    this.perfil = perfil;
  } 

  public String getStatus(){
    return this.status;
  }

  public void setStatus(String status){
    this.status = status;
  }
}
