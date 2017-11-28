
package model.validador.produto;


import exceptions.ProdutoException;
import model.produto.Produto;


//Validador Produto
public class ValidadorProduto {
    public static void validar (Produto produto) throws ProdutoException{
        //Realiza validações
      if (produto == null) {
            throw new ProdutoException("Não foi informado um Produto");
        }
      if(produto.getModelo() == null || "".equals(produto.getModelo())){
          throw new ProdutoException("Por favor informe o modelo "+
                  " do produto");
      }
          if (produto.getGenero() == null || "".equals(produto.getGenero())
                || (!produto.getGenero().equals("Masculino"))
                && !produto.getGenero().equals("Feminino")
                && !produto.getGenero().equals("Outros")) {
            throw new ProdutoException("Por favor informe o "
                    + " Genero do produto");
        }
      
      if(produto.getTamanho() == null || "".equals(produto.getTamanho())){
          throw new ProdutoException("Por favor informe o tamanho "+
                  " do produto");
      }
     
      if(produto.getMarca() == null || "".equals(produto.getMarca())){
          throw new ProdutoException("Por favor informe a marca "+
                  " do produto");   
      }
      if(produto.getCor() == null || "".equals(produto.getCor())){
          throw new ProdutoException("Por favor informe a cor "+
                  " do produto");   
      }
      if(produto.getPreco() == null || "".equals(produto.getPreco()) || produto.getPreco() > 0){
          throw new ProdutoException("Por favor informe o preço "+
                  " do produto");   
      }
      
    }
    
    
}
