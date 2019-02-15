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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Pessoas {
    
    
    private Integer codigo_pessoa;
    private String nome_pessoa;
    private String status;
    private Date data_cadastro;

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO pessoas  "+
" 	(CODIGO_PESSOA,    "+
" 	NOME_PESSOA,       "+
" 	DATA_CADASTRO,     "+
" 	STATUS             "+
" 	)                  "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataCadastro = null;
        if (getData_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataCadastro = oDatOut.format(getData_cadastro());
        }

        stmt.setString(1, getNome_pessoa());
        stmt.setString(2, oDataCadastro);
        stmt.setString(3, getStatus());

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
                    "from pessoas "+
                    "where CODIGO_PESSOA = CODIGO_PESSOA ";
                    

            int quantParam = 0;


           
           if (getNome_pessoa() != null) {
                comando = comando + "AND NOME_PESSOA like ? ";
            }
           if (getCodigo_pessoa()!= null){
               comando = comando + " AND CODIGO_PESSOA = ? ";
            }
           if (getStatus()!= null) {
                comando = comando + "AND STATUS = ? ";
            }           

            comando = comando + " order by CODIGO_PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            
           if (getNome_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_pessoa()+"%");
           }
           if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }
           if (getStatus()!= null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getStatus());
            }

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

        String comando = "UPDATE pessoas "+
" 	SET "+
" 	NOME_PESSOA = ?,    "+
" 	DATA_CADASTRO = ?,  "+
" 	STATUS = ?          "+
" 	WHERE "+
" 	CODIGO_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataCadastro = null;
        if (getData_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataCadastro = oDatOut.format(getData_cadastro());
        }

        stmt.setString(1, getNome_pessoa());
        stmt.setString(2, oDataCadastro);
        stmt.setString(3, getStatus());
        stmt.setInt(4, getCodigo_pessoa());

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

" DELETE FROM pessoas  "+
" 	WHERE "+
" 	CODIGO_PESSOA = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_pessoa());


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
