/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Cargos {
    
    
    private Integer codigo_cargo;
    private String nome_cargo;
    private String tipo_cargo;

    public Integer getCodigo_cargo() {
        return codigo_cargo;
    }

    public void setCodigo_cargo(Integer codigo_cargo) {
        this.codigo_cargo = codigo_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }

    public String getTipo_cargo() {
        return tipo_cargo;
    }

    public void setTipo_cargo(String tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO cargos  "+
" 	(CODIGO_CARGO,  "+
" 	NOME_CARGO,     "+
" 	TIPO_CARGO      "+
" 	)               "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setString(1, getNome_cargo());
        stmt.setString(2, getTipo_cargo());

        stmt.execute();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public ResultSet getConsultar(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select * " +
                    "from cargos "+
                    "where CODIGO_CARGO = CODIGO_CARGO ";
                    

            int quantParam = 0;


           
           if (getCodigo_cargo()!= null){
               comando = comando + " AND CODIGO_CARGO  = ? ";
            }
           if (getTipo_cargo()!= null){
               comando = comando + " AND TIPO_CARGO  = ? ";
            }
//           if (getStatus()!= null) {
//                comando = comando + "AND STATUS = ? ";
//            }           

            comando = comando + " order by CODIGO_CARGO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            
           if (getCodigo_cargo()!= null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_cargo());
            }
           if (getTipo_cargo()!= null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo_cargo());
            }
//           if (getStatus()!= null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getStatus());
//            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE cargos "+
" 	SET "+
" 	NOME_CARGO = ?,     "+
" 	TIPO_CARGO = ?      "+
" 	WHERE "+
" 	CODIGO_CARGO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setString(1, getNome_cargo());
        stmt.setString(2, getTipo_cargo());
        stmt.setInt(3, getCodigo_cargo());

        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM cargos  "+
" 	WHERE "+
" 	CODIGO_CARGO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_cargo());


        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
    
    
}
