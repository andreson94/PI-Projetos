/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class TelaPrincipal extends javax.swing.JFrame {
    
    
    public TelaPrincipal() {
        initComponents();
    }

    public void returnToTitle(){
        CardLayout card = (CardLayout) panelPrincipal.getLayout();
        card.show(panelPrincipal,"telaPrincipal");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        telaPrincipal = new javax.swing.JPanel() {
            private Image image;
            {
                try {
                    image = ImageIO.read(new File("src/Imagens/logo3.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        BarraMenu = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        itemCadastroClientes = new javax.swing.JMenuItem();
        itemConsultarClientes = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        itemCadastrarProduto = new javax.swing.JMenuItem();
        itemPesquisarProduto = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        itemLançamentos = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        itemConsultarRelatorio = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        panelPrincipal.setLayout(new java.awt.CardLayout());

        telaPrincipal.setPreferredSize(new java.awt.Dimension(600, 700));

        javax.swing.GroupLayout telaPrincipalLayout = new javax.swing.GroupLayout(telaPrincipal);
        telaPrincipal.setLayout(telaPrincipalLayout);
        telaPrincipalLayout.setHorizontalGroup(
            telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        telaPrincipalLayout.setVerticalGroup(
            telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );

        panelPrincipal.add(telaPrincipal, "telaPrincipal");

        menuClientes.setText("Clientes");

        itemCadastroClientes.setText("Cadastrar");
        itemCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastroClientesActionPerformed(evt);
            }
        });
        menuClientes.add(itemCadastroClientes);
        itemCadastroClientes.getAccessibleContext().setAccessibleName("tela1");

        itemConsultarClientes.setText("Consultar");
        itemConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarClientesActionPerformed(evt);
            }
        });
        menuClientes.add(itemConsultarClientes);
        itemConsultarClientes.getAccessibleContext().setAccessibleName("tela2");

        BarraMenu.add(menuClientes);

        menuProdutos.setText("Produtos");

        itemCadastrarProduto.setText("Cadastrar");
        itemCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(itemCadastrarProduto);

        itemPesquisarProduto.setText("Consultar");
        itemPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPesquisarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(itemPesquisarProduto);

        BarraMenu.add(menuProdutos);

        menuVendas.setText("Vendas");
        menuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendasActionPerformed(evt);
            }
        });

        itemLançamentos.setText("Lançamentos");
        itemLançamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLançamentosActionPerformed(evt);
            }
        });
        menuVendas.add(itemLançamentos);

        BarraMenu.add(menuVendas);

        menuRelatorio.setText("Relatório");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });

        itemConsultarRelatorio.setText("Consultar");
        itemConsultarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(itemConsultarRelatorio);

        BarraMenu.add(menuRelatorio);

        jMenu1.setText("Sair");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        BarraMenu.add(jMenu1);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastroClientesActionPerformed
        CardLayout cadastro = (CardLayout) panelPrincipal.getLayout();
        cadastro.show(panelPrincipal, "cadastrarClientes");
    }//GEN-LAST:event_itemCadastroClientesActionPerformed

    private void itemConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarClientesActionPerformed
         CardLayout consulta = (CardLayout) panelPrincipal.getLayout();
        consulta.show(panelPrincipal, "consultarClientes");
    }//GEN-LAST:event_itemConsultarClientesActionPerformed

    private void itemCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarProdutoActionPerformed
         CardLayout cadastro = (CardLayout) panelPrincipal.getLayout();
        cadastro.show(panelPrincipal, "cadastrarProdutos");
    }//GEN-LAST:event_itemCadastrarProdutoActionPerformed

    private void itemPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPesquisarProdutoActionPerformed
         CardLayout consulta = (CardLayout) panelPrincipal.getLayout();
        consulta.show(panelPrincipal, "consultarProdutos");
    }//GEN-LAST:event_itemPesquisarProdutoActionPerformed

    private void menuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendasActionPerformed
    }//GEN-LAST:event_menuVendasActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void itemLançamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLançamentosActionPerformed
        CardLayout lancamentos = (CardLayout) panelPrincipal.getLayout();
        lancamentos.show(panelPrincipal, "vendaProdutos");
    }//GEN-LAST:event_itemLançamentosActionPerformed

    private void itemConsultarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarRelatorioActionPerformed
        CardLayout consulta = (CardLayout) panelPrincipal.getLayout();
        consulta.show(panelPrincipal, "relatorio");
    }//GEN-LAST:event_itemConsultarRelatorioActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        System.exit(0);
                
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenuItem itemCadastrarProduto;
    private javax.swing.JMenuItem itemCadastroClientes;
    private javax.swing.JMenuItem itemConsultarClientes;
    private javax.swing.JMenuItem itemConsultarRelatorio;
    private javax.swing.JMenuItem itemLançamentos;
    private javax.swing.JMenuItem itemPesquisarProduto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuVendas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel telaPrincipal;
    // End of variables declaration//GEN-END:variables

}
