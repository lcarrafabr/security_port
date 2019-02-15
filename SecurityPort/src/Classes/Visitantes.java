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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Visitantes {

    protected Integer codigo_cadastro_visita;
    protected Integer codigo_cadastro_pessoa_visitante;
    protected Integer codigo_pessoa_usuario;
    protected Date data_visita;
    protected String hora_visita;
    protected String local_da_visita;

    public Integer getCodigo_cadastro_visita() {
        return codigo_cadastro_visita;
    }

    public void setCodigo_cadastro_visita(Integer codigo_cadastro_visita) {
        this.codigo_cadastro_visita = codigo_cadastro_visita;
    }

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

    public Date getData_visita() {
        return data_visita;
    }

    public void setData_visita(Date data_visita) {
        this.data_visita = data_visita;
    }

    public String getHora_visita() {
        return hora_visita;
    }

    public void setHora_visita(String hora_visita) {
        this.hora_visita = hora_visita;
    }

    public String getLocal_da_visita() {
        return local_da_visita;
    }

    public void setLocal_da_visita(String local_da_visita) {
        this.local_da_visita = local_da_visita;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO cadastro_de_visitas  "
                    + " 	(CODIGO_CADASTRO_VISITA,            "
                    + " 	CODIGO_CADASTRO_PESSOA_VISITANTE,   "
                    + " 	CODIGO_PESSOA_USUARIO,              "
                    + " 	DATA_VISITA,                        "
                    + " 	HORA_VISITA,                        "
                    + " 	LOCAL_DA_VISITA                     "
                    + " 	)                                   "
                    + " 	VALUES "
                    + " 	(null,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?,  "
                    + " 	?  "
                    + " 	); ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oDataCadastro = null;
            if (getData_visita()!= null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oDataCadastro = oDatOut.format(getData_visita());
            }

            stmt.setInt(1, getCodigo_cadastro_pessoa_visitante());
            stmt.setInt(2, getCodigo_pessoa_usuario());
            stmt.setString(3, oDataCadastro);
            stmt.setString(4, getHora_visita());
            stmt.setString(5, getLocal_da_visita());

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
            comando = "SELECT C.*, V.*, U.NOME_USUARIO, T.* "
                    + "FROM cadastro_de_visitas C, cadastro_pessoas_visitante V, usuarios U, tipo_acesso_visitante T "
                    + "WHERE C.CODIGO_CADASTRO_VISITA = C.CODIGO_CADASTRO_VISITA "
                    + "AND C.CODIGO_CADASTRO_PESSOA_VISITANTE = V.CODIGO_CADASTRO_PESSOA_VISITANTE "
                    + "AND C.CODIGO_PESSOA_USUARIO = U.CODIGO_PESSOA_USUARIO "
                    + "AND V.CODIGO_TIPO_ACESSO_VISITANTE = T.CODIGO_TIPO_ACESSO_VISITANTE ";

            int quantParam = 0;

            if (getCodigo_cadastro_visita()!= null) {
                comando = comando + " AND C.CODIGO_CADASTRO_VISITA  = ? ";
            }
            if (getCodigo_cadastro_pessoa_visitante()!= null) {
                comando = comando + " AND C.CODIGO_CADASTRO_PESSOA_VISITANTE  = ? ";
            }
//            if (getNome_usuario() != null) {
//                comando = comando + "AND U.NOME_USUARIO like ? ";
//            }

            comando = comando + " order by C.CODIGO_CADASTRO_VISITA DESC";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodigo_cadastro_visita()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_cadastro_visita());
            }
            if (getCodigo_cadastro_pessoa_visitante()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCodigo_cadastro_pessoa_visitante());
            }
//            if (getNome_usuario() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, getNome_usuario() + "%");
//            }

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }

}
