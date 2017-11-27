

package connetion.sampleSqlExecutor;

import connection.utils.ConnectionUtils;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *Executor de códigos SQL
 */
public class SqlTest {
    //Elemento para armazenamento da conexão
    private static Connection connect = null;
    
    //Método de execução principal
    public static void main(String[] args) {
        //Tratamento de erros de conexão com o banco
        try {
            //Tenta obter uma conexão com o banco
            connect = ConnectionUtils.getConnection();
            JOptionPane.showMessageDialog(null, "Conectado");
            System.out.println("Conectado!");
            
            //SEU COMANDO SQL AQUI!
            
            
        }
        catch(Exception e) {
            //Imprime erros de conexão
            e.printStackTrace();
        }
        finally {
            //Trata erros do fechamento de conexão com o banco de dados
            try {
                //Tenta fechar a conexão com o banco
                connect.close();
            }
            catch(Exception e) {
                //Imprime erros de fechamento de conexão
                e.printStackTrace();
            }
        }
    }
}


