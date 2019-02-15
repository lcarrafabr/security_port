/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Luciano Carrafa Benfica
 */

public class ClassConecta {


    /** Creates a new instance of ClassConecta */


    public ClassConecta() {    }

    //Dados conexao banco
    public static String url      = "jdbc:mysql://127.0.0.1:3306/securityportdb";
    public static String driver   = "com.mysql.jdbc.Driver";
    public static String user     = "root";
    public static String pwd      = "root";
    public static String usuario    = "root";


    public static Connection con = null;

    /**
     *
     * @param dominio
     * @throws java.sql.SQLException
     */

    public void setConnection(String dominio) throws SQLException{
         ClassConecta conexao = new ClassConecta();
         ClassConecta.conecta();

        //Pegar dados do dominio solicitado
        Dominios oDominio = new Dominios();
        if (!dominio.isEmpty() ){
          oDominio.setDominio( dominio );
        }

        ResultSet rsDominio;

            rsDominio = oDominio.getConsultar(conexao);
            rsDominio.first();

            url     = rsDominio.getString("url");
            driver  = rsDominio.getString("driver");
            user    = rsDominio.getString("user");
            pwd     = rsDominio.getString("pwd");



    }



    public static Connection conecta(){

        try{

            Class.forName(driver);

            con = DriverManager.getConnection(url, user,pwd);
            //Suas tabelas são MyISAM ou InnoDB? Porque MyISAM não suportam transações.
            //Alter table alterar para InnoDB.
            con.setAutoCommit(false);
        }catch(ClassNotFoundException e){
            do {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Driver não encontrado!\n" + e, "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } while (true);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Erro na Conexão com Banco\n"+ e,"ATENÇÃO",JOptionPane.WARNING_MESSAGE);
}
        System.out.println("Conectado");

        return con;
    }


}
