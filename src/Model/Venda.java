/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ClienteDAO;
import DAO.DescontoDAO;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author tassyosantana
 */
public class Venda {
  private Integer codCli;
  private Integer codProd;
  private Integer codLocal;
  private Integer qtdVenda;
  private Float valorTotal;
  private Date dataVenda;

  public Integer getCodCli(){
    return this.codCli;
  }

  public void setCodCli(Integer codCli ){
    this.codCli = codCli ;
  }

  public Integer getCodProd(){
    return this.codProd;
  }

  public void setCodProd(Integer codProd ){
    this.codProd = codProd ;
  }

  public Integer getCodLocal(){
    return this.codLocal;
  }

  public void setCodLocal(Integer codLocal ){
    this.codLocal = codLocal ;
  }
  public Integer getQtdVenda(){
    return this.qtdVenda;
  }

  public void setQtdVenda(Integer qtdVenda ){
    this.qtdVenda = qtdVenda;
  }

  public Float getValorTotal(){
    return this.valorTotal;
  }

  public void setValorTotal(Float valorTotal){
    this.valorTotal = valorTotal ;
  }

  public Date getDataVenda(){
    return this.dataVenda;
  }

  public void setDataVenda(Date dataVenda){
    this.dataVenda = dataVenda ;
  }
  
  public Float calculaTotal( Float preco){
      this.valorTotal = this.valorTotal +(this.qtdVenda * preco);
      return this.valorTotal;
  }
  
  public Float calculaDesconto1() throws SQLException, ClassNotFoundException{
      ClienteDAO clienteDAO = new ClienteDAO();
      Float bonus = clienteDAO.buscaBonus(this.codCli);
      
      if (bonus >= 100){
        DescontoDAO descontoDAO = new DescontoDAO();
        Integer percentual = descontoDAO.buscaPercentual(this.codProd, this.qtdVenda);
        if (percentual > 0){
            this.valorTotal = this.valorTotal - (this.valorTotal - percentual/100);
            clienteDAO.atualizaBonus(bonus, this.codCli);
        }
      }
      return this.valorTotal;
  }
}
