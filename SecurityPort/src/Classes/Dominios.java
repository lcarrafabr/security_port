/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Dominios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer codDominio;
    private String dominio;
    private String url;
    private String driver;
    private String user;
    private String pwd;
    private String ativo;
    private String gestor;
    private String site;
    private String painel;
    private String obs;

    public Dominios() {
    }

    public Dominios(Integer codDominio) {
        this.codDominio = codDominio;
    }

    public Dominios(Integer codDominio, String dominio) {
        this.codDominio = codDominio;
        this.dominio = dominio;
    }

    public Integer getCodDominio() {
        return codDominio;
    }

    public void setCodDominio(Integer codDominio) {
        this.codDominio = codDominio;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPainel() {
        return painel;
    }

    public void setPainel(String painel) {
        this.painel = painel;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public ResultSet getConsultar(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select * " +
                    "from dominios "+
                    "where codDominio = codDominio ";

            int quantParam = 0;

            if (getDominio() != null){
               comando = comando + " AND dominio = ? ";
            }

            if (getCodDominio() != null){
               comando = comando + " AND codDominio = ? ";
            }

//            ClassConecta conexao = new ClassConecta();
//            conexao.conecta();

            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);

            if (getDominio() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getDominio() );

            }

            if (getCodDominio() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodDominio());
            }


        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

    void setCadastrar(ClassConecta conexao){
  try{


        String comando = " INSERT INTO dominios  "+
" 	(codDominio,  "+
" 	dominio,  "+
" 	url,  "+
" 	driver,  "+
" 	USER,  "+
" 	pwd,  "+
" 	ativo,  "+
" 	gestor,  "+
" 	site,  "+
" 	painel,  "+
" 	obs "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	? "+
" 	); ";


        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getDominio());
        stmt.setString(2,getUrl());
        stmt.setString(3, getDriver());
        stmt.setString(4,getUser());
        stmt.setString(5,getPwd());
        stmt.setString(6,getAtivo());
        stmt.setString(7,getGestor());
        stmt.setString(8,getSite());
        stmt.setString(9,getPainel());
        stmt.setString(10,getObs());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }



    void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = " update dominios  "+
" 	set "+

" 	dominio = ? ,  "+
" 	url = ? ,  "+
" 	driver = ? ,  "+
" 	user = ? ,  "+
" 	pwd = ? ,  "+
" 	ativo = ? ,  "+
" 	gestor = ? ,  "+
" 	site = ? ,  "+
" 	painel = ? ,  "+
" 	obs = ? "+
" 	 "+
" 	where "+
" 	codDominio = ? ; ";

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setString(1,getDominio());
        stmt.setString(2,getUrl());
        stmt.setString(3, getDriver());
        stmt.setString(4,getUser());
        stmt.setString(5,getPwd());
        stmt.setString(6,getAtivo());
        stmt.setString(7,getGestor());
        stmt.setString(8,getSite());
        stmt.setString(9,getPainel());
        stmt.setString(10,getObs());
        stmt.setInt(11,getCodDominio());

        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDominio != null ? codDominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dominios)) {
            return false;
        }
        Dominios other = (Dominios) object;
        if ((this.codDominio == null && other.codDominio != null) || (this.codDominio != null && !this.codDominio.equals(other.codDominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "japolo.Dominios[codDominio=" + codDominio + "]";
    }


}
