
package Telas;

import exceptions.ProdutoException;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.produto.Produto;
import service.produto.ServicoProduto;


public class ConsultarProdutos extends javax.swing.JPanel {

   //Vai Guarda a ultima consulta feita
    Long ultima_consulta;
   
    public ConsultarProdutos() {
        initComponents();
    }
    
     public boolean Atualizacao() throws ProdutoException, Exception {
        //Realiza a pesquisa do produto com o resultado a ultima consulta feita. 
        //para atualizar a lista
        List<Produto> resultado = ServicoProduto.
                procurarProduto(ultima_consulta);

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) Tabela_Produtos.getModel();
        //Indica que a tabela deve excluir todos seus conteúdo.
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso.
        model.setRowCount(0);

        /*Verifica se não existiram resultados. Caso afirmativo, encerra a
        atualização e indica ao elemento acionador o não sucesso da pesquisa*/
        
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        //Percorre a lista de resultados e os adiciona na tabela
        for (int i = 0; i < resultado.size(); i++) {
           Produto cli = resultado.get(i);
            if (cli != null) {
                Object[] row = new Object[7];
                row[0] = cli.getCod_produto();
                row[1] = cli.getModelo();
                row[2] = cli.getMarca();
                row[3] = cli.getTamanho();
                row[4] = cli.getCor();
                row[5] = cli.getPreco();
                model.addRow(row);
            }
        }

        /*Se chega até aqui, a pesquisa teve sucesso, então
        retornamos "true" para o elemento adicionante, indicando
        que não devem ser exibidas mensagens de erro*/
        
        return true;
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoExcluir = new javax.swing.JButton();
        BarraConsulta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        BotaoCancelar = new javax.swing.JButton();
        jTextField52 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        BotaoConsulta = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabela_Produtos = new javax.swing.JTable();

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        BarraConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarraConsultaActionPerformed(evt);
            }
        });

        jLabel20.setText("Cód. Produto");

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        jLabel64.setText("Modelo:");

        jLabel65.setText("Marca:");

        BotaoConsulta.setText("Consultar");
        BotaoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConsultaActionPerformed(evt);
            }
        });

        Tabela_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modelo", "Marca", "Tamanho", "Cor", "Preço", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Tabela_Produtos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BarraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotaoConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(BotaoConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(BotaoExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(BotaoCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultaActionPerformed
  //Inicializa o sucesso da pesquisa com valor negativo, indicando que
        //a pesquisa de Produtos teve resultado negativo.
        boolean Resultado_Consulta;
        
        /*Grava o campo de pesquisa como a última pesquisa válida. O resultado da
        última pesquisa válida é utilizado na atualização da lista*/
       
        
        
        if (BarraConsulta.getText() != null &&
                !BarraConsulta.getText().equals("")){
            
            try {
                ultima_consulta = Long.parseLong(BarraConsulta.getText());
                
            } catch (Exception e) {
                //Exibe mensagens de erro na fonte de dados e para
                
                JOptionPane.showMessageDialog(this, "Só é possível"
                        + " pesquisar por um valor inteiro válido",
                        "Campo de pesquisa inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else {
            ultima_consulta = null;
        }

        try {
            /*Solicita a atualização da lista com o novo critério
            //de pesquisa (ultima_Pesquisa).*/
          Resultado_Consulta = Atualizacao();
        } catch (Exception e) {
            //Exibe mensagens de erro na fonte de dados e para o processo. 
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Exibe mensagem de erro caso a pesquisa não tenha resultados.
        if (!Resultado_Consulta) {
            JOptionPane.showMessageDialog(this, "A pesquisa não retornou "
                + "resultados ", "Sem resultados",
                JOptionPane.ERROR_MESSAGE);
        }       
    }//GEN-LAST:event_BotaoConsultaActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
         TelaPrincipal tp = (TelaPrincipal) getRootPane().getParent();
        tp.returnToTitle();
        //Cancela a operação e volta para a tela principal.
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
  /*Verifica se há itens selecionados para exclusão.
    Caso negativo, ignora o comando.*/
  
        if (Tabela_Produtos.getSelectedRow() >= 0) {
            
            //Obtém a linha do item selecionado.
            final int row = Tabela_Produtos.getSelectedRow();
            /*Obtém o nome do Produto em questão da linha indicada para exibição,
            de mensagem de confirmação de exclusão utilizando seu codigo.*/
            Long numero = (Long) Tabela_Produtos.getValueAt(row, 0);
            //Mostra uma pequena tela de confirmação de exclusão.
            int resposta = JOptionPane.showConfirmDialog(this,
                "Excluir Produto \"" + numero + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            //Se o valor de resposta for "Sim" para a exclusão
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    //Obtém o ID do produto.
                    Long codigo = (Long) Tabela_Produtos.getValueAt(row, 0);
                    //Solicita ao serviço a exclusão do produto com o ID
                    ServicoProduto.excluirProduto(codigo);
                    //Atualiza a lista após a "exclusão"
                    this.Atualizacao();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                    //Exibe uma mensagem de erro genérica ao usuário.
                    JOptionPane.showMessageDialog(this, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }       
        
          
                                 

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BarraConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarraConsultaActionPerformed
    
    }//GEN-LAST:event_BarraConsultaActionPerformed
   private void Tabela_Produto (java.awt.event.MouseEvent evt) {                                              
        //Verifica se o clique é um clique duplo.      
        if (evt.getClickCount() == 2) {
            try {                
                //Obtém a linha selecionada da Tabela_Produto.
                final int row = Tabela_Produtos.getSelectedRow();
                //Obtém o valor do ID da coluna "ID" da Tabela_Produto.
                Long id = (Long) Tabela_Produtos.getValueAt(row, 0);
                
                /*Com o ID da coluna, chama o serviço  para
                obter o Porduto com dados atualizados do mock*/
                Produto produtos  = ServicoProduto.obterProduto(id);

                /*Cria uma nova instância da tela de edição,
                configura o produto selecionado como elemento a
                er editado e mostra a tela de edição.
                Para exibir a tela, é necessário adicioná-la ao
                componente de desktop.*/
            } catch (Exception e) {
                /*Se ocorrer algum erro técnico, mostra-o no console,
                mas esconde-o do usuário.*/
                e.printStackTrace();
                //Exibe uma mensagem de erro genérica ao usuário.
                JOptionPane.showMessageDialog(this, "Não é possível "
                    + "exibir os detalhes deste produto ",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                            


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarraConsulta;
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoConsulta;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JTable Tabela_Produtos;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    // End of variables declaration//GEN-END:variables
}
