package model.dao;

//Data Access Object de Cliente. Realiza operações de BD com o cliente. 

import connection.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.cliente.Cliente;

public class DaoCliente {

    //Insere um cliente na tabela "cliente" do banco de dados

    /**
     *
     * @param cliente
     * @throws SQLException
     * @throws Exception
     */
    public static void inserir(Cliente cliente)
            throws SQLException, Exception {
        
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        
        String sql = "INSERT INTO cliente (nome, sobrenome, "
                + "data_nasc, rg, cpf, sexo, estadoCivil,"
                + " email, telefone, cep, endereço, numEnd, complemento,"
                + " bairro, cep, cidade, estado,  enabled) VALUES (?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //Conexão para abertura e fechamento
        
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        
        PreparedStatement preparedStatement = null;
        try {
            
            //Abre uma conexão com o banco de dados
            
            connection = ConnectionUtils.getConnection();
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            Timestamp t = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(3, t);
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setString(6, cliente.getSexo());
            preparedStatement.setString(7, cliente.getEstadoCivil());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getTelefone());
            preparedStatement.setString(10, cliente.getCep());
            preparedStatement.setString(11, cliente.getEndereco());
            preparedStatement.setString(12, cliente.getNumEnd());
            preparedStatement.setString(13, cliente.getComplemento());
            preparedStatement.setString(14, cliente.getCep());
            preparedStatement.setString(15, cliente.getEndereco());
            preparedStatement.setString(16, cliente.getCidade());
            preparedStatement.setString(17, cliente.getEstado());
            preparedStatement.setBoolean(18, true);
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        
        } finally {
        
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    
    public static void atualizar(Cliente cliente)
            throws SQLException, Exception {
    
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        
        String sql = "UPDATE cliente SET nome=?, sobrenome=?, data_nasc=?, rg=?, cpf=?, sexo=?, estadoCivil=?,"
                + " email=?, telefone=?, cep=?, endereço=?, numEnd=?, complemento=?,"
                + " bairro=?, cep=?, cidade=?, estado=?  "
            + "WHERE (cliente_id=?)";
        
        //Conexão para abertura e fechamento
        
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        
        PreparedStatement preparedStatement = null;
        try {
            
            //Abre uma conexão com o banco de dados
            
            connection = ConnectionUtils.getConnection();
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            Timestamp t = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(3, t);
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setString(6, cliente.getSexo());
            preparedStatement.setString(7, cliente.getEstadoCivil());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getTelefone());
            preparedStatement.setString(10, cliente.getCep());
            preparedStatement.setString(11, cliente.getEndereco());
            preparedStatement.setString(12, cliente.getNumEnd());
            preparedStatement.setString(13, cliente.getComplemento());
            preparedStatement.setString(14, cliente.getCep());
            preparedStatement.setString(15, cliente.getEndereco());
            preparedStatement.setString(16, cliente.getCidade());
            preparedStatement.setString(17, cliente.getEstado());
            preparedStatement.setInt(18, cliente.getId());
            
            //Executa o comando no banco de dados
            
            preparedStatement.execute();
        } finally {
            
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    /*Realiza a exclusão lógica de um cliente no BD, com ID fornecido
    *como parâmetro. A exclusão lógica simplesmente "desliga" o
    *cliente, configurando um atributo específico, a ser ignorado
    *em todas as consultas de cliente ("enabled").
    */
    
    public static void excluir(Integer id) throws SQLException, Exception {
        
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        
        String sql = "UPDATE cliente SET enabled=? WHERE (cliente_id=?)";
        
        //Conexão para abertura e fechamento
       
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        
        PreparedStatement preparedStatement = null;
        try {
            
            //Abre uma conexão com o banco de dados
            
            connection = ConnectionUtils.getConnection();
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            
            //Executa o comando no banco de dados
            
            preparedStatement.execute();
        } finally {
            
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Lista todos os clientes da tabela clientes

    /**
     *
     * @return
     * @throws SQLException
     * @throws Exception
     */
    
    public static List<Cliente> listar()
            throws SQLException, Exception {
        
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        
        String sql = "SELECT * FROM cliente WHERE (enabled=?)";  
        
        //Lista de clientes de resultado
        
        List<Cliente> listaClientes = null;
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
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            //Executa a consulta SQL no banco de dados
            
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            
            while (result.next()) {
                
                //Se a lista não foi inicializada, a inicializa
                
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                Date d = new Date(result.getTimestamp("data_nasc").getTime());
                cliente.setDataNasc(d);
                cliente.setSexo(result.getString("rg"));
                cliente.setSexo(result.getString("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("estadoCivil"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("Telefone"));
                cliente.setSexo(result.getString("cep"));
                cliente.setSexo(result.getString("endereco"));
                cliente.setSexo(result.getString("numEnd"));
                cliente.setSexo(result.getString("complemento"));
                cliente.setSexo(result.getString("bairro"));
                cliente.setSexo(result.getString("cidade"));
                cliente.setSexo(result.getString("estado"));
                //Adiciona a instância na lista
                listaClientes.add(cliente);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        
        return listaClientes;
    }

    //Procura um cliente no banco de dados, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    
    public static List<Cliente> procurar(String valor)
            throws SQLException, Exception {
        
        /*Monta a string de consulta de clientes no banco, utilizando
        *o valor passado como parâmetro para busca nas colunas de
        *nome ou sobrenome (através do "LIKE" e ignorando minúsculas
        *ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        *parâmetro). Além disso, também considera apenas os elementos
        *que possuem a coluna de ativação de clientes configurada com
        *o valor correto ("enabled" com "true")
        */
        
        String sql = "SELECT * FROM cliente WHERE ((UPPER(nome) LIKE UPPER(?) "
            + "OR UPPER(cliente.sobrenome) LIKE UPPER(?)) AND enabled=?)";
        
        //Lista de clientes de resultado
        
        List<Cliente> listaClientes = null;
        
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
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setString(1, "%" + valor + "%");
            preparedStatement.setString(2, "%" + valor + "%");
            preparedStatement.setBoolean(3, true);
            
            //Executa a consulta SQL no banco de dados
            
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            
            while (result.next()) {
                
                //Se a lista não foi inicializada, a inicializa
                
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                Date d = new Date(result.getTimestamp("data_nasc").getTime());
                cliente.setDataNasc(d);
                cliente.setSexo(result.getString("rg"));
                cliente.setSexo(result.getString("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("estadoCivil"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("Telefone"));
                cliente.setSexo(result.getString("cep"));
                cliente.setSexo(result.getString("endereco"));
                cliente.setSexo(result.getString("numEnd"));
                cliente.setSexo(result.getString("complemento"));
                cliente.setSexo(result.getString("bairro"));
                cliente.setSexo(result.getString("cidade"));
                cliente.setSexo(result.getString("estado"));
                
                //Adiciona a instância na lista
                
                listaClientes.add(cliente);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        
        return listaClientes;        
    }

    //Obtém uma instância da classe "Cliente" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    
    public static Cliente obter(Integer id)
            throws SQLException, Exception {
        
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        
        String sql = "SELECT * FROM cliente WHERE (cliente_id=? AND enabled=?)";

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
            
            //Cria um statement para execução de instruções SQL
            
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setInt(1, id);            
            preparedStatement.setBoolean(2, true);
            
            //Executa a consulta SQL no banco de dados
            
            result = preparedStatement.executeQuery();
            
            //Verifica se há pelo menos um resultado
            
            if (result.next()) {         
                
                //Cria uma instância de Cliente e popula com os valores do BD
                
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                Date d = new Date(result.getTimestamp("data_nasc").getTime());
                cliente.setDataNasc(d);
                cliente.setSexo(result.getString("rg"));
                cliente.setSexo(result.getString("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setSexo(result.getString("estadoCivil"));
                cliente.setSexo(result.getString("email"));
                cliente.setSexo(result.getString("Telefone"));
                cliente.setSexo(result.getString("cep"));
                cliente.setSexo(result.getString("endereco"));
                cliente.setSexo(result.getString("numEnd"));
                cliente.setSexo(result.getString("complemento"));
                cliente.setSexo(result.getString("bairro"));
                cliente.setSexo(result.getString("cidade"));
                cliente.setSexo(result.getString("estado"));
                
                //Retorna o resultado
                
                return cliente;
            }            
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        
        return null;
    }
}
