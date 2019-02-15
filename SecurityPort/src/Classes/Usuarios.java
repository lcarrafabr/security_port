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
public class Usuarios {

    protected Integer codigo_pessoa_usuario;
    protected String nome_usuario;
    protected String senha;
    protected String nivel_acesso;

    public Integer getCodigo_pessoa_usuario() {
        return codigo_pessoa_usuario;
    }

    public void setCodigo_pessoa_usuario(Integer codigo_pessoa_usuario) {
        this.codigo_pessoa_usuario = codigo_pessoa_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO usuarios  "
                    + " 	(CODIGO_PESSOA_USUARIO, "
                    + " 	NOME_USUARIO,           "
                    + " 	SENHA,                  "
                    + " 	NIVEL_ACESSO            "
                    + " 	)                       "
                    + " 	VALUES "
                    + " 	(?,     "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setInt(1, getCodigo_pessoa_usuario());
            stmt.setString(2, getNome_usuario());
            stmt.setString(3, getSenha());
            stmt.setString(4, getNivel_acesso());

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
            comando = "SELECT P.NOME_PESSOA, U.* "
                    + "FROM pessoas P, usuarios U "
                    + "WHERE U.CODIGO_PESSOA_USUARIO = P.CODIGO_PESSOA ";

            int quantParam = 0;

            if (getCodigo_pessoa_usuario() != null) {
                comando = comando + " AND U.CODIGO_PESSOA_USUARIO  = ? ";
            }
            if (getNome_usuario() != null) {
                comando = comando + "AND U.NOME_USUARIO like ? ";
            }

            comando = comando + " order by U.CODIGO_PESSOA_USUARIO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodigo_pessoa_usuario() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_pessoa_usuario());
            }
            if (getNome_usuario() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, getNome_usuario() + "%");
            }

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
            String comando = "UPDATE usuarios "
                    + " 	SET "
                    + " 	CODIGO_PESSOA_USUARIO = ?,     "
                    + " 	NOME_USUARIO = ?,           "
                    + " 	SENHA = ?,                        "
                    + " 	NIVEL_ACESSO = ?            "
                    + " 	WHERE "
                    + " 	CODIGO_PESSOA_USUARIO = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setInt(1, getCodigo_pessoa_usuario());
            stmt.setString(2, getNome_usuario());
            stmt.setString(3, getSenha());
            stmt.setString(4, getNivel_acesso());
            stmt.setInt(5, getCodigo_pessoa_usuario());

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
                    = " DELETE FROM usuarios  "
                    + " 	WHERE "
                    + " 	CODIGO_PESSOA_USUARIO = ?  ";

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            //Formatar data Prevista

            stmt.setInt(1, getCodigo_pessoa_usuario());

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

}
