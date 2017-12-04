package model.dao;

import connection.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.produto.Produto;

/**
 *
 * @author andreson.csilva
 */
public class DaoProdutos {
    
    
     public static void inserir(Produto produto)
            throws SQLException, Exception {
         String sql = "INSERT INTO produto (modelo, tamanho, marca, cor, genero, preco, enabled)"
                + " VALUES (?, ?, ?, ?, ?)";
         
         Connection connection = null;
         
         PreparedStatement preparedStatement = null;
          try {
            
            connection = ConnectionUtils.getConnection();
           
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setString(2, produto.getTamanho());
            preparedStatement.setString(3, produto.getMarca());
            preparedStatement.setString(4, produto.getCor());
            preparedStatement.setString(5, produto.getGenero());
            preparedStatement.setFloat (6, produto.getPreco());
            preparedStatement.setBoolean(7, true);
            
            preparedStatement.execute();
        } finally {
           
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
           
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
     public static void atualizar(Produto produto)
            throws SQLException, Exception {
        
        String sql = "UPDATE produto SET modelo=?, tamanho=?, marca=?, cor=?, genero=?, preco=? "
                + "WHERE (produto_id=?)";
       
        Connection connection = null;
       
        PreparedStatement preparedStatement = null;
        try {
           
            connection = ConnectionUtils.getConnection();
          
            preparedStatement = connection.prepareStatement(sql);
           
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setString(2, produto.getTamanho());
            preparedStatement.setString(3, produto.getMarca());
            preparedStatement.setString(4, produto.getCor());
            preparedStatement.setString(5, produto.getGenero());
            preparedStatement.setFloat(6, produto.getPreco());
            preparedStatement.setLong(7, produto.getCod_produto());
            
            
            preparedStatement.execute();
        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
      public static void excluir(Long id) throws SQLException, Exception {
       
        String sql = "UPDATE produto SET enabled=? WHERE (codproduto=?)";
        
        Connection connection = null;
        
        PreparedStatement preparedStatement = null;
        try {
            
            connection = ConnectionUtils.getConnection();
            
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, false);
            preparedStatement.setFloat(2, id);
            
            
            preparedStatement.execute();
        } finally {
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
      public static List<Produto> listar()
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM produto WHERE enabled=?";
        
        List<Produto> listaProdutos = null;
        
        Connection connection = null;
       
        PreparedStatement preparedStatement = null;
     
        ResultSet result = null;
        try {
            
            connection = ConnectionUtils.getConnection();
           
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, true);
            
            
            result = preparedStatement.executeQuery();
           
            while (result.next()) {
                
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância de Quarto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setCod_produto(result.getLong("codproduto"));
                produto.setModelo(result.getString("modelo"));
                produto.setTamanho(result.getString("tamanho"));
                produto.setMarca(result.getString("marca"));
                produto.setCor(result.getString("cor"));
                produto.setGenero(result.getString("genero"));
                produto.setPreco(result.getFloat("preco"));
                produto.setSituacao(result.getString("situacao"));
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de quartos do banco de dados
        return listaProdutos;
    }
      public static List<Produto> procurar(Long valor)
            throws SQLException, Exception {
        //Monta a string de consulta de quartos no banco, utilizando
        //o valor passado como parâmetro para busca na coluna de
        //numero. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de quartos configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM quarto WHERE (numero=? AND enabled=?)";

        //Lista de quartos de resultado
        List<Quarto> listaQuartos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do PreparedStatement
            preparedStatement.setLong(1, valor);
            preparedStatement.setBoolean(2, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaQuartos == null) {
                    listaQuartos = new ArrayList<Quarto>();
                }
                //Cria uma instância de Quarto e popula com os valores do BD
                Quarto quarto = new Quarto();
                quarto.setId(result.getInt("quarto_id"));
                quarto.setNumero(result.getLong("numero"));
                quarto.setAndar(result.getLong("andar"));
                quarto.setTipo(result.getString("tipo"));
                quarto.setSituacao(result.getString("situacao"));
                //Adiciona a instância na lista
                listaQuartos.add(quarto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de quartos do banco de dados
        return listaQuartos;
    }
         
     }
    

