package View;

import DAO.ClienteDAO;
import DAO.LocalidadeDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Localidade;
import Model.Produto;
import Model.Venda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tassyosantana
 */
public class JFramePontoDeVenda extends javax.swing.JFrame {

    public JFramePontoDeVenda() {
        initComponents();
        
        PreencherComboLocalidade();
        PreencherComboProduto();
        PreencherComboCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxLocalidade = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jTextQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextDescricaoProduto = new javax.swing.JTextField();
        jButtonVender = new javax.swing.JButton();
        jButton2Excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTotalCompra = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDV - Ponto de Venda");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(215, 249, 248));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 50, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAIXA LIVRE");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 9, 116));
        jLabel2.setText("Cliente Selecionado:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 9, 116));
        jLabel3.setText("Local de Venda:");
        jLabel3.setToolTipText("");

        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jComboBoxLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLocalidadeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 9, 116));
        jLabel4.setText("Código do Produto:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(28, 9, 116));
        jLabel5.setText("Quantidade:");
        jLabel5.setToolTipText("");

        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(28, 9, 116));
        jLabel6.setText("Descrição do Produto:");
        jLabel6.setToolTipText("");

        jTextDescricaoProduto.setEditable(false);

        jButtonVender.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonVender.setText("Vender");
        jButtonVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVenderActionPerformed(evt);
            }
        });

        jButton2Excluir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2Excluir.setText("Excluir");

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Preço Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableItens);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(28, 9, 116));
        jLabel7.setText("Total da Compra:");
        jLabel7.setToolTipText("");

        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setText("Fechar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBoxCliente, 0, 210, Short.MAX_VALUE)
                                    .addComponent(jComboBoxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)
                                            .addComponent(jComboBoxLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(97, 97, 97))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonVender))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jButton2Excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxProduto.getAccessibleContext().setAccessibleName("");
        jComboBoxProduto.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLocalidadeActionPerformed
       try{
       // Integer cod_local = Integer.parseInt(jComboBoxLocalidade.getSelectedItem().toString().split("--")[1]);
      // PreencherComboProduto(cod_local);
       }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e +"1");
       }
    }//GEN-LAST:event_jComboBoxLocalidadeActionPerformed

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed
      try{
          if (jComboBoxProduto.getItemCount() > 0)
          PreencherTextDescricao(Integer.parseInt(jComboBoxProduto.getSelectedItem().toString()));
      }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e+"2-"+jComboBoxProduto.getItemCount());
       }
      
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jButtonVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVenderActionPerformed
       try{
        String msg = TratarExistenciaProduto();
        if (msg.equals("")){            
           msg = gravarVenda();
           if(msg.equals(""))
               JOptionPane.showMessageDialog(rootPane,"Venda inserida com sucesso");
           else
               JOptionPane.showMessageDialog(rootPane,msg);
        }else{
          JOptionPane.showMessageDialog(rootPane,msg+"");
        }
        }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e+"2.5-");
       }
      
    }//GEN-LAST:event_jButtonVenderActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        try{
            if (jComboBoxCliente.getItemCount() > 0)
            PreencherTableItens(Integer.parseInt(jComboBoxCliente.getSelectedItem().toString().split("--")[1]));
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, "ComboCli--"+e );
       }
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void PreencherTextDescricao(Integer codProd){
        try{
           ProdutoDAO produtoDAO = new ProdutoDAO();
           Produto produto = produtoDAO.buscaProdutoPorCodProduto(codProd);
           jTextDescricaoProduto.setText(produto.getDescricao());
            
        }catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(rootPane, e+"3");
        }
    }
    private void PreencherComboLocalidade(){
        try{
            LocalidadeDAO localidadeDAO = new LocalidadeDAO();
              List<Localidade> listalocalidade = localidadeDAO.lista();
                              
            for (int i = 0; i < listalocalidade.size(); i++) {
              jComboBoxLocalidade.addItem(listalocalidade.get(i).getNome()+
                      "--"+listalocalidade.get(i).getCodLocal());
            }
        }catch(SQLException |ClassNotFoundException e){
          JOptionPane.showMessageDialog(rootPane, e+"4");
      }
    }
    private void PreencherComboProduto() {
      try{
        String descricaoProduto="";
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
       
        List<Produto> listaProdutos = produtoDAO.lista();
          for (int i = 0; i < listaProdutos.size(); i++) {
            jComboBoxProduto.addItem(listaProdutos.get(i).getCodProd().toString());         
            if (i==0 )
                descricaoProduto =listaProdutos.get(i).getDescricao();
          }
          
        jComboBoxProduto.setSelectedIndex(0);
        jTextDescricaoProduto.setText(descricaoProduto);
        
      } catch(SQLException |ClassNotFoundException e){
          JOptionPane.showMessageDialog(rootPane, e+"5");
      }
    }
    private void PreencherComboCliente(){
      try {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaCliente = clienteDAO.lista();
        
        for (int i = 0; i < listaCliente.size();i++){
          jComboBoxCliente.addItem(listaCliente.get(i).getNome()+
                  "--"+listaCliente.get(i).getCodCli()); 
        }
      } catch(SQLException | ClassNotFoundException e ) {
        JOptionPane.showMessageDialog(rootPane, e+"6");
      }
    }
    private void PreencherTableItens(Integer codCli){
        try{
        VendaDAO vendaDAO = new VendaDAO();
        List<Venda> vendas = vendaDAO.listaItensVendidos(codCli);
        jTableItens.setAutoResizeMode(jTableItens.AUTO_RESIZE_OFF);
        //largura das colunas
        jTableItens.getColumnModel().getColumn(0).setPreferredWidth(305);
        jTableItens.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableItens.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableItens.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        //redimensionar false
        jTableItens.getColumnModel().getColumn(0).setResizable(false);
        jTableItens.getColumnModel().getColumn(1).setResizable(false);
        jTableItens.getColumnModel().getColumn(2).setResizable(false);
        jTableItens.getColumnModel().getColumn(3).setResizable(false);
        
        
        
        DefaultTableModel modelo = (DefaultTableModel) jTableItens.getModel();               
        modelo.setNumRows(0);
        for (Venda venda : vendas) {
            modelo.addRow(new Object[]{venda.getDescricao(),venda.getQtdVenda(),venda.getPreco_unitario(),
            venda.getValorTotal()});
        } 
        } catch(SQLException |ClassNotFoundException e){
          JOptionPane.showMessageDialog(rootPane, e+"10");
      }
        
    }
    private String TratarExistenciaProduto(){ 
      try{  
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Integer codProdCombo ;
    
        if (jComboBoxProduto.getItemCount() > 0)
          codProdCombo = Integer.parseInt(jComboBoxProduto.getSelectedItem().toString());
        else
          codProdCombo = null;
      
        Produto produto = produtoDAO.buscaProdutoPorCodProduto(codProdCombo);
        
        if (produto.getCodProd().toString().equals(""))
            return "Produto não encontrado!";
       
        if (jTextQuantidade.getText().equals("") || jTextQuantidade.getText().equals("0")) 
            return "Quantidade não informada ou igual a zero!";  
          
        if (produto.getQtdEstoque() < Integer.parseInt(jTextQuantidade.getText()))
            return "Produto sem estoque!";
        
      }catch(SQLException | ClassNotFoundException e ) {
        return e.toString();
      }   
      return "";
    }

    private String gravarVenda(){
        try{ 
            VendaDAO vendaDAO = new VendaDAO();
            Venda venda = new Venda();
            venda.setCodCli(Integer.parseInt(jComboBoxCliente.getSelectedItem().toString().split("--")[1]));
            venda.setCodProd(Integer.parseInt(jComboBoxProduto.getSelectedItem().toString()));
            venda.setCodLocal(Integer.parseInt(jComboBoxLocalidade.getSelectedItem().toString().split("--")[1]));
            venda.setQtdVenda(Integer.parseInt(jTextQuantidade.getText()));
    
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.buscaProdutoPorCodProduto(venda.getCodProd());
    
            venda.calculaTotal(produto.getPrecoUnitario()); 
            venda.calculaDesconto1();
            venda.calculaDesconto2();
            
            return vendaDAO.atualizaEstoqueInsereVenda(venda);
        }catch(SQLException | ClassNotFoundException e ) {
          JOptionPane.showMessageDialog(rootPane, e+"gravarVenda()");
          return "";
        } 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePontoDeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePontoDeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePontoDeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePontoDeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
                new JFramePontoDeVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2Excluir;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonVender;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxLocalidade;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableItens;
    private javax.swing.JTextField jTextDescricaoProduto;
    private javax.swing.JTextField jTextFieldTotalCompra;
    private javax.swing.JTextField jTextQuantidade;
    // End of variables declaration//GEN-END:variables

}
