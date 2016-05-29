
package Model;

/**
 *
 * @author tassyosantana
 */
public class Produto {
   private Integer codProd;
   private Integer codLocal;
   private String descricao;
   private Integer qtdEstoque;
   private Float precoUnitario;

   public Integer getCodProd(){
     return this.codProd;
   }

   public void setCodProd(Integer codProd){
     this.codProd = codProd;
   }

   public Integer getcodLocal(){
      return this.codLocal;
   }

   public void setCodLocal(Integer codLocal){
     this.codLocal = codLocal;
   }

   public String getDescricao(){
     return this.descricao;
   }

   public void setDescricao(String descricao){
     this.descricao = descricao;
   }

   public Integer getQtdEstoque(){
     return this.qtdEstoque;
   }

   public void setQtdEstoque(Integer qtdEstoque){
     this.qtdEstoque = qtdEstoque;
   }

   public Float getPrecoUnitario(){
     return this.precoUnitario;
   }

   public void setPrecoUnitario(Float precoUnitario){
     this.precoUnitario = precoUnitario;
   }

}
