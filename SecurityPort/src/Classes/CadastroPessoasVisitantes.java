/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.Blob;
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
public class CadastroPessoasVisitantes {

    private Integer codigo_cadastro_pessoa_visitante;
    private Integer codigo_pessoa_usuario;
    private Integer codigo_tipo_acesso_visitante;
    private String nome_visitante;
    private String rg;
    private String tipo_visitante;
    private String empresa;
    private Date data_cadastro;
    private Blob foto;
    private String observacao;

    public Integer getCodigo_cadastro_pessoa_visitante() {
        return codigo_cadastro_pessoa_visitante;
    }

    public void setCodigo_cadastro_pessoa_visitante(Integer codigo_cadastro_pessoa_visitante) {
        this.codigo_cadastro_pessoa_visitante = codigo_cadastro_pessoa_visitante;
    }

    public Integer getCodigo_pessoa_usuario() {
        return codigo_pessoa_usuario;
    }

    public void setCodigo_pessoa_usuario(Integer codigo_pessoa_usuario) {
        this.codigo_pessoa_usuario = codigo_pessoa_usuario;
    }

    public Integer getCodigo_tipo_acesso_visitante() {
        return codigo_tipo_acesso_visitante;
    }

    public void setCodigo_tipo_acesso_visitante(Integer codigo_tipo_acesso_visitante) {
        this.codigo_tipo_acesso_visitante = codigo_tipo_acesso_visitante;
    }

    public String getNome_visitante() {
        return nome_visitante;
    }

    public void setNome_visitante(String nome_visitante) {
        this.nome_visitante = nome_visitante;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTipo_visitante() {
        return tipo_visitante;
    }

    public void setTipo_visitante(String tipo_visitante) {
        this.tipo_visitante = tipo_visitante;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO cadastro_pessoas_visitante  "
                    + " 	(CODIGO_CADASTRO_PESSOA_VISITANTE, "
                    + " 	CODIGO_PESSOA_USUARIO,           "
                    + " 	CODIGO_TIPO_ACESSO_VISITANTE,           "
                    + " 	NOME_VISITANTE,                  "
                    + " 	RG,                  "
                    + " 	TIPO_VISITANTE,                  "
                    + " 	EMPRESA,                  "
                    + " 	DATA_CADASTRO,                  "
                    + " 	FOTO,                  "
                    + " 	OBSERVACAO                  "
                    + " 	)                       "
                    + " 	VALUES "
                    + " 	(null,     "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oDataCadastro = null;
            if (getData_cadastro() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oDataCadastro = oDatOut.format(getData_cadastro());
            }

            stmt.setInt(1, getCodigo_pessoa_usuario());
            stmt.setInt(2, getCodigo_tipo_acesso_visitante());
            stmt.setString(3, getNome_visitante());
            stmt.setString(4, getRg());
            stmt.setString(5, getTipo_visitante());
            stmt.setString(6, getEmpresa());
            stmt.setString(7, oDataCadastro);
            stmt.setBlob(8, getFoto());
            stmt.setString(9, getObservacao());

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
            comando = "SELECT C.*, T.*, U.NOME_USUARIO "
                    + "FROM cadastro_pessoas_visitante C, tipo_acesso_visitante T, usuarios U "
                    + "WHERE C.CODIGO_CADASTRO_PESSOA_VISITANTE  = C.CODIGO_CADASTRO_PESSOA_VISITANTE "
                    + "AND C.CODIGO_TIPO_ACESSO_VISITANTE = T.CODIGO_TIPO_ACESSO_VISITANTE "
                    + "AND C.CODIGO_PESSOA_USUARIO = U.CODIGO_PESSOA_USUARIO ";

            int quantParam = 0;

            if (getCodigo_cadastro_pessoa_visitante()!= null) {
                comando = comando + " AND C.CODIGO_CADASTRO_PESSOA_VISITANTE  = ? ";
            }
            if (getNome_visitante()!= null) {
                comando = comando + "AND C.NOME_VISITANTE like ? ";
            }
            if (getRg()!= null) {
                comando = comando + "AND C.RG LIKE ? ";
            }

            comando = comando + " order by C.CODIGO_CADASTRO_PESSOA_VISITANTE ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodigo_cadastro_pessoa_visitante()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_cadastro_pessoa_visitante());
            }
            if (getNome_visitante()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, getNome_visitante()+ "%");
            }
            if (getRg()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, getRg()+ "%");
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
            String comando = "UPDATE cadastro_pessoas_visitante "
                    + " 	SET "
                    + " 	CODIGO_TIPO_ACESSO_VISITANTE = ?,   "
                    + " 	CODIGO_PESSOA_USUARIO = ?,          "
                    + " 	NOME_VISITANTE = ?,                 "
                    + " 	RG = ?,                             "
                    + " 	TIPO_VISITANTE = ?,                 "
                    + " 	EMPRESA = ?,                        "
                    + " 	DATA_CADASTRO = ?,                  "
                    + " 	FOTO = ?,                           "
                    + " 	OBSERVACAO = ?                      "
                    + " 	WHERE "
                    + " 	CODIGO_CADASTRO_PESSOA_VISITANTE = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            
            String oDataCadastro = null;
            if (getData_cadastro() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oDataCadastro = oDatOut.format(getData_cadastro());
            }

            stmt.setInt(1, getCodigo_tipo_acesso_visitante());
            stmt.setInt(2, getCodigo_pessoa_usuario());
            stmt.setString(3, getNome_visitante());
            stmt.setString(4, getRg());
            stmt.setString(5, getTipo_visitante());
            stmt.setString(6, getEmpresa());
            stmt.setString(7, oDataCadastro);
            stmt.setBlob(8, getFoto());
            stmt.setString(9, getObservacao());
            stmt.setInt(10, getCodigo_cadastro_pessoa_visitante());

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
                    = " DELETE FROM cadastro_pessoas_visitante  "
                    + " 	WHERE "
                    + " 	CODIGO_CADASTRO_PESSOA_VISITANTE = ?  ";

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            //Formatar data Prevista

            stmt.setInt(1, getCodigo_cadastro_pessoa_visitante());

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
