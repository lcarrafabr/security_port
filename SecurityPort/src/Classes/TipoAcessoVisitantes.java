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
public class TipoAcessoVisitantes {

    private Integer codigo_tipo_acesso;
    private String nome_acesso;
    private String cor;
    private String informacao;

    public Integer getCodigo_tipo_acesso() {
        return codigo_tipo_acesso;
    }

    public void setCodigo_tipo_acesso(Integer codigo_tipo_acesso) {
        this.codigo_tipo_acesso = codigo_tipo_acesso;
    }

    public String getNome_acesso() {
        return nome_acesso;
    }

    public void setNome_acesso(String nome_acesso) {
        this.nome_acesso = nome_acesso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO tipo_acesso_visitante  "
                    + " 	(CODIGO_TIPO_ACESSO_VISITANTE,      "
                    + " 	NOME_ACESSO,                        "
                    + " 	COR,                                "
                    + " 	INFORMACAO_ACESSO                          "
                    + " 	) "
                    + " 	VALUES "
                    + " 	(null,  "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setString(1, getNome_acesso());
            stmt.setString(2, getCor());
            stmt.setString(3, getInformacao());

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
            comando = "SELECT * "
                    + "FROM tipo_acesso_visitante "
                    + "WHERE CODIGO_TIPO_ACESSO_VISITANTE = CODIGO_TIPO_ACESSO_VISITANTE ";

            int quantParam = 0;

            if (getCodigo_tipo_acesso() != null) {
                comando = comando + " AND CODIGO_TIPO_ACESSO_VISITANTE  = ? ";
            }
            if (getNome_acesso() != null) {
                comando = comando + "AND NOME_ACESSO like ? ";
            }

            comando = comando + " order by CODIGO_TIPO_ACESSO_VISITANTE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodigo_tipo_acesso() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_tipo_acesso());
            }
            if (getNome_acesso() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, getNome_acesso() + "%");
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
            String comando = "UPDATE tipo_acesso_visitante "
                    + " 	SET "
                    + " 	NOME_ACESSO = ?,        "
                    + " 	COR = ?,                "
                    + " 	INFORMACAO_ACESSO = ?   "
                    + " 	WHERE "
                    + " 	CODIGO_TIPO_ACESSO_VISITANTE = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setString(1, getNome_acesso());
            stmt.setString(2, getCor());
            stmt.setString(3, getInformacao());
            stmt.setInt(4, getCodigo_tipo_acesso());

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
                    = " DELETE FROM tipo_acesso_visitante  "
                    + " 	WHERE "
                    + " 	CODIGO_TIPO_ACESSO_VISITANTE = ?  ";

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            //Formatar data Prevista

            stmt.setInt(1, getCodigo_tipo_acesso());

            stmt.executeUpdate();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            //System.out.println("Transação Concluída");
            JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);

            String mensagem_erro = e.toString();

            String verificador = mensagem_erro.substring(0, 74);

            int contador = verificador.length();
            if (contador == 74
                    && "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException".equals(verificador)) {

                JOptionPane.showMessageDialog(null, "O registro que está tentando excluir já está sendo utilizado em um cadastro de visitantes.\n"
                        + "Por favor, altere os registros de visitantes que utilizam esse item que deseja excluir.\n", "Mensagem do sistema", JOptionPane.WARNING_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
