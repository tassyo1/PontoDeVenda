
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
   private precoUnitario;

   public Integer getCodProd(){
     return this.codProd;
   }

   public void setCodProd(Integer codProd){
     this.codProd = codProd;
   }

}
