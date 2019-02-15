/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Moradores {
    
    private Integer codigo_pessoa_morador;
    private Integer codigo_torre;
    private Integer codigo_apartamento;
    private Integer codigo_cargo_morador;
    private int ramal;
    private Blob imagem;
    //*************************************
    private String nome_pessoa;
    
    
    
    private int operadorFile;
    private String caminho_imagem;

    public Integer getCodigo_pessoa_morador() {
        return codigo_pessoa_morador;
    }

    public void setCodigo_pessoa_morador(Integer codigo_pessoa_morador) {
        this.codigo_pessoa_morador = codigo_pessoa_morador;
    }

    public Integer getCodigo_torre() {
        return codigo_torre;
    }

    public void setCodigo_torre(Integer codigo_torre) {
        this.codigo_torre = codigo_torre;
    }

    public Integer getCodigo_apartamento() {
        return codigo_apartamento;
    }

    public void setCodigo_apartamento(Integer codigo_apartamento) {
        this.codigo_apartamento = codigo_apartamento;
    }

    public Integer getCodigo_cargo_morador() {
        return codigo_cargo_morador;
    }

    public void setCodigo_cargo_morador(Integer codigo_cargo_morador) {
        this.codigo_cargo_morador = codigo_cargo_morador;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public int getOperadorFile() {
        return operadorFile;
    }

    public void setOperadorFile(int operadorFile) {
        this.operadorFile = operadorFile;
    }

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }
    
    
    
    
    public void setCadastrar() {
        try {

            String comando = "INSERT INTO moradores  "
                    + " 	(CODIGO_PESSOA_MORADOR,     "
                    + " 	CODIGO_APARTAMENTO,            "
                    + " 	CODIGO_TORRE,            "
                    + " 	CODIGO_CARGO_MORADOR,           "
                    + " 	RAMAL,                     "
                    + " 	FOTO                        "
                    + " 	)                           "
                    + " 	VALUES "
                    + " 	(?,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?  "
                    + " 	); ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600 "; // 10 MB
            Statement stSetLimit = ClassConecta.con.createStatement();
            stSetLimit.execute(querySetLimit);
            
            
            FileInputStream fi = null;

            //Caso o operador seja diferente de 0 (zero) fazer o inputStream da imagem.
            if (getOperadorFile() != 0) {

                try {
                    File file = new File(getCaminho_imagem());
                    fi = new FileInputStream(file);

                } catch (Exception e) {
                }
            }
            
            stmt.setInt(1, getCodigo_pessoa_morador());
            stmt.setInt(2, getCodigo_apartamento());
            stmt.setInt(3, getCodigo_torre());
            stmt.setInt(4, getCodigo_cargo_morador());
            stmt.setInt(5, getRamal());
            stmt.setBinaryStream(6, fi);

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

            //System.out.println("Transação Concluída");
            //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public ResultSet getConsultar(ClassConecta conexao) throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "SELECT P.*, T.*, AP.*, M.*, C.* "
                    + "FROM MORADORES M,PESSOAS P, APARTAMENTOS AP, TORRES T, CARGOS C "
                    + "WHERE M.CODIGO_PESSOA_MORADOR = P.CODIGO_PESSOA "
                    + "AND M.CODIGO_TORRE = T.CODIGO_TORRE "
                    + "AND M.CODIGO_APARTAMENTO = AP.CODIGO_APARTAMENTO "
                    + "AND M.CODIGO_CARGO_MORADOR = C.CODIGO_CARGO ";

            int quantParam = 0;

//           
//           if (getCodigo_pessoa()!= null) {
//                comando = comando + "AND NOME_PESSOA like ? ";
//            }
            if (getCodigo_pessoa_morador()!= null) {
                comando = comando + " AND M.CODIGO_PESSOA_MORADOR = ? ";
            }
//           if (getStatus()!= null) {
//                comando = comando + "AND STATUS = ? ";
//            }           

            comando = comando + " order by M.CODIGO_PESSOA_MORADOR ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

//           if (getNome_pessoa() != null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getNome_pessoa()+"%");
//           }
            if (getCodigo_pessoa_morador()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_pessoa_morador());
            }
//           if (getStatus()!= null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getStatus());
//            }

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    
    public void setAlterar(ClassConecta conexao) {

        try {
        //ClassConecta conexao = new ClassConecta();

            //conexao.conecta();
            String comando = "UPDATE moradores "
                    + " 	SET "
                    + " 	CODIGO_APARTAMENTO = ?,         "
                    + " 	CODIGO_TORRE = ?,               "
                    + " 	CODIGO_CARGO_MORADOR = ?,               "
                    + " 	RAMAL = ?,                      "
                    + " 	FOTO = ?                        "
                    + " 	WHERE "
                    + " 	CODIGO_PESSOA_MORADOR = ?   ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            
            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600 "; // 10 MB
            Statement stSetLimit = ClassConecta.con.createStatement();
            stSetLimit.execute(querySetLimit);

            FileInputStream fi = null;

            //Caso o operador seja diferente de 0 (zero) fazer o inputStream da imagem.
            if (getOperadorFile() != 0) {

                try {
                    File file = new File(getCaminho_imagem());
                    fi = new FileInputStream(file);

                } catch (Exception e) {
                }
            }

            stmt.setInt(1, getCodigo_apartamento());
            stmt.setInt(2, getCodigo_torre());
            stmt.setInt(3, getCodigo_cargo_morador());
            stmt.setInt(4, getRamal());
            stmt.setBinaryStream(5, fi);
            stmt.setInt(6, getCodigo_pessoa_morador());

            stmt.executeUpdate();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            System.out.println("Transação Concluída");
            JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void setExcluir(ClassConecta conexao) {

        try {
        //ClassConecta conexao = new ClassConecta();

            //conexao.conecta();
            String comando
                    = " DELETE FROM moradores  "
                    + " 	WHERE "
                    + " 	CODIGO_PESSOA_MORADOR = ?  ";

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            //Formatar data Prevista

            stmt.setInt(1, getCodigo_pessoa_morador());

            stmt.executeUpdate();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            //System.out.println("Transação Concluída");
            JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
//************************************************************************************************************************************************************
    
    
    
    public ResultSet getConsultarMoradores(ClassConecta conexao) throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "SELECT P.*, T.*, AP.*, M.*, C.* "
                    + "FROM MORADORES M,PESSOAS P, APARTAMENTOS AP, TORRES T, CARGOS C "
                    + "WHERE M.CODIGO_PESSOA_MORADOR = P.CODIGO_PESSOA "
                    + "AND M.CODIGO_TORRE = T.CODIGO_TORRE "
                    + "AND M.CODIGO_APARTAMENTO = AP.CODIGO_APARTAMENTO "
                    + "AND M.CODIGO_CARGO_MORADOR = C.CODIGO_CARGO ";

            int quantParam = 0;


            if (getCodigo_pessoa_morador()!= null) {
                comando = comando + " AND M.CODIGO_PESSOA_MORADOR = ? ";
            }
           if (getCodigo_torre()!= null) {
                comando = comando + "AND M.CODIGO_TORRE = ? ";
            }
           if (getCodigo_apartamento()!= null) {
                comando = comando + "AND M.CODIGO_APARTAMENTO = ? ";
            }
           
           if (getNome_pessoa()!= null) {
                comando = comando + "AND P.NOME_PESSOA like ? ";
            }

            comando = comando + " order by M.CODIGO_PESSOA_MORADOR ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_morador()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_pessoa_morador());
            }
           if (getCodigo_torre()!= null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_torre());
            }
           if (getCodigo_apartamento()!= null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_apartamento());
            }
           if (getNome_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_pessoa()+"%");
           }


            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    
}
