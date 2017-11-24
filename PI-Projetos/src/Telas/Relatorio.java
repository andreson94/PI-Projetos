/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Mock.MockCliente;
import Mock.MockVenda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.produto.ServicoProduto;

/**
 *
 * @author andreson.csilva
 */
public class Relatorio extends javax.swing.JPanel {

    /**
     * Creates new form Relatorio
     */
    public Relatorio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textDataInicial = new javax.swing.JFormattedTextField();
        textDataFinal = new javax.swing.JFormattedTextField();
        labelDataInicial = new javax.swing.JLabel();
        labelDataFinal = new javax.swing.JLabel();
        buttonConsultar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRelatorio = new javax.swing.JTable();

        textDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        textDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataInicialActionPerformed(evt);
            }
        });

        textDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        labelDataInicial.setText("Data inicial");

        labelDataFinal.setText("Data Final");

        buttonConsultar.setText("Consultar");
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        tableRelatorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço", "Qnt", "Data", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRelatorio);
        if (tableRelatorio.getColumnModel().getColumnCount() > 0) {
            tableRelatorio.getColumnModel().getColumn(0).setMinWidth(50);
            tableRelatorio.getColumnModel().getColumn(1).setMinWidth(20);
            tableRelatorio.getColumnModel().getColumn(2).setMinWidth(20);
            tableRelatorio.getColumnModel().getColumn(3).setMinWidth(30);
            tableRelatorio.getColumnModel().getColumn(4).setMinWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataInicial)
                            .addComponent(textDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataFinal)
                            .addComponent(textDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addComponent(buttonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataInicial)
                    .addComponent(labelDataFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConsultar)
                    .addComponent(buttonCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
      
        
        //Usa o valor digitado em "Data inicial"
         SimpleDateFormat inicio = new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat fim = new SimpleDateFormat("dd/MM/yyyy");
        try {
            inicio.parse(textDataInicial.getText().toString());
        } catch (Exception e) {
            
        }
        try {
            fim.parse(textDataFinal.getText().toString());
        } catch (Exception e) {
            
        }
        
      
        
        if (!textDataInicial.getText().toString().isEmpty()) {
            try{
                for (int i = 0; i < MockVenda.listar().size(); i++) {
                    if (MockVenda.listar().get(i).getId() == Integer.parseInt(textDataInicial.getText().toString())){
                        String Cliente = MockVenda.listar().get(i).getCliente();

                       
                    }
                }
            }
            catch (Exception ex) {
                 ex.printStackTrace();
            } 
                
           if (!textDataFinal.getText().toString().isEmpty()) {
            try{
                for (int i = 0; i < MockVenda.listar().size(); i++) {
                    if (MockVenda.listar().get(i).getId() == Integer.parseInt(textDataFinal.getText().toString())){
                        String produto = MockVenda.listar().get(i).getProduto();

                        textDataFinal.setText(produto + " " );
                    }
                }
            } catch (Exception ex) {
                 ex.printStackTrace();
            } 
                  
         DefaultTableModel tableRelatorioModel = (DefaultTableModel) tableRelatorio.getModel();
         
           Relatorio relatorio = null;

            long produto;

        try {

            produto = Long.parseLong(textDataInicial.getText());
            produto = Long.parseLong(textDataFinal.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A data informado não condiz com os ");
            return;
        }

           
        try {
            relatorio = ServicoProduto.obterProduto(textDataInicial);
            relatorio = ServicoProduto.obterProduto(textDataFinal);
        } catch (Exception e) {

        } 

        Object[] row = new Object[5];
        //row[0] = relatorio.getProduto();
        //row[1] = relatorio.getPreco();
        //row[2] = relatorio.getQnt();
        //row[3] = relatorio.getData();
        //row[4] = relatorio.getCliente();
        tableRelatorioModel.addRow(row);

        System.out.println("Total de produtos: " + tableRelatorioModel.getRowCount());
       
             
        } 
        }
        
        
    }//GEN-LAST:event_buttonConsultarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        TelaPrincipal tp = (TelaPrincipal)getRootPane().getParent();
        tp.returnToTitle();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void textDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataInicialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JTable tableRelatorio;
    private javax.swing.JFormattedTextField textDataFinal;
    private javax.swing.JFormattedTextField textDataInicial;
    // End of variables declaration//GEN-END:variables
}