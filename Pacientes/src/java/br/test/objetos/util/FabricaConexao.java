
package br.test.objetos.util;

import br.test.objetos.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaConexao {
    private static Connection conexao;
    private static final String URL_CONEXAO="jdbc:mysql://localhost/pacientes";
    private static final String USUARIO="root";
    private static final String SENHA="root";
    
    public static Connection getConexao() throws ErroSistema{
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.print("ok");
                conexao = DriverManager.getConnection(URL_CONEXAO,USUARIO,SENHA);
                
            } catch (SQLException ex) {
                throw new ErroSistema("Erro - Não foi possivel conectar ao banco de dados!", ex);
            } catch (ClassNotFoundException ex) {
              throw new ErroSistema("Erro - O driver do banco de dados não foi encontrado!", ex);
            }
        }
        return conexao;
    }
    public static void fecharConexao() throws ErroSistema{
        if(conexao!=null){
            try {
                conexao.close();
                conexao=null;
            } catch (SQLException ex) {
                 throw new ErroSistema("Erro - Ao fechar conexao com o banco de dados", ex);
            }
        }
    }
    
}


