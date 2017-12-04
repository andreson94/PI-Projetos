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
                + "WHERE (codproduto=?)";
       
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
                
                Produto produto = new Produto();
                produto.setCod_produto(result.getLong("codproduto"));
                produto.setModelo(result.getString("modelo"));
                produto.setTamanho(result.getString("tamanho"));
                produto.setMarca(result.getString("marca"));
                produto.setCor(result.getString("cor"));
                produto.setGenero(result.getString("genero"));
                produto.setPreco(result.getFloat("preco"));
               
                
                
                listaProdutos.add(produto);
            }
        } finally {
            
            if (result != null && !result.isClosed()) {
                result.close();
            }
           
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return listaProdutos;
    }
      public static List<Produto> procurar(Long valor)
            throws SQLException, Exception {
     
        String sql = "SELECT * FROM produto WHERE (modelo=? AND enabled=?)";

       
        List<Produto> listaProduto = null;
        
        Connection connection = null;
       
        PreparedStatement preparedStatement = null;
        
        ResultSet result = null;
        try {
           
            connection = ConnectionUtils.getConnection();
           
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setLong(1, valor);
            preparedStatement.setBoolean(2, true);
            
           
            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                
                if (listaProduto == null) {
                    listaProduto = new ArrayList<Produto>();
                }
               
                Produto produto = new Produto();
                produto.setCod_produto(result.getLong("codproduto"));
                produto.setModelo(result.getString("modelo"));
                produto.setTamanho(result.getString("tamanho"));
                produto.setMarca(result.getString("marca"));
                produto.setCor(result.getString("cor"));
                produto.setGenero(result.getString("genero"));
                produto.setPreco(result.getFloat("preco"));
               
              
                listaProduto.add(produto);
            }
        } finally {
            
            if (result != null && !result.isClosed()) {
                result.close();
            }
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return listaProduto;
    }
         public static Produto obter(Long CodProduto)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM produto WHERE (codproduto=? AND enabled=?)";

       
        Connection connection = null;
      
        PreparedStatement preparedStatement = null;
       
        ResultSet result = null;
        try {
            
            connection = ConnectionUtils.getConnection();
           
            preparedStatement = connection.prepareStatement(sql);
          
            preparedStatement.setLong(1, CodProduto);
            preparedStatement.setBoolean(2, true);
            
            
            result = preparedStatement.executeQuery();
            
             
            if (result.next()) {                
               
                Produto produto = new Produto();
                produto.setCod_produto(result.getLong("codproduto"));
                produto.setModelo(result.getString("modelo"));
                produto.setTamanho(result.getString("tamanho"));
                produto.setMarca(result.getString("marca"));
                produto.setCor(result.getString("cor"));
                produto.setGenero(result.getString("genero"));
                produto.setPreco(result.getFloat("preco"));
                
                
                
                return produto;
            }            
        } finally {
            
            if (result != null && !result.isClosed()) {
                result.close();
            }
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }       

        
        return null;
    }
      
         
     }
    

