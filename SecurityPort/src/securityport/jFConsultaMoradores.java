/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securityport;

import Classes.Apartamentos;
import Classes.ClassConecta;
import Classes.ComboItem;
import Classes.Funcoes;
import Classes.Moradores;
import Classes.Pessoas;
import Classes.Torres;
import com.mysql.jdbc.Blob;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class jFConsultaMoradores extends javax.swing.JFrame {

    /**
     * Creates new form jFConsultaMoradores
     */
    public jFConsultaMoradores() {
        initComponents();
        
        
        JRootPane meurootpane = getRootPane();
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "CONSULTA_MORADORES");
        meurootpane.getRootPane().getActionMap().put("CONSULTA_MORADORES", new AbstractAction("CONSULTA_MORADORES") {

            @Override
            public void actionPerformed(ActionEvent e) {
                novaConsultajButtonActionPerformed(e);
            }
        });

//======================================================================================================================================================   
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeMoradorjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        torrejComboBox = new javax.swing.JComboBox();
        apartamentojComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        consultarjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeMoradoresjTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nomeMoradorConsultajTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        torrejTextField = new javax.swing.JTextField();
        apartamentoConsultajTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ramalConsultajTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        imagemjLabel = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        novaConsultajButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Moradores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 109, 209)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome");

        nomeMoradorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeMoradorjTextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("Torre");

        torrejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torrejComboBoxActionPerformed(evt);
            }
        });

        apartamentojComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartamentojComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Apartamento");

        consultarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscar.png"))); // NOI18N
        consultarjButton.setContentAreaFilled(false);
        consultarjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nomeMoradorjTextField)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(torrejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(apartamentojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeMoradorjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(torrejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apartamentojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarjButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Filtros", jPanel3);

        gradeMoradoresjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id#", "Nome", "Torre/AP", "Ramal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeMoradoresjTable.getTableHeader().setReorderingAllowed(false);
        gradeMoradoresjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeMoradoresjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeMoradoresjTable);
        if (gradeMoradoresjTable.getColumnModel().getColumnCount() > 0) {
            gradeMoradoresjTable.getColumnModel().getColumn(0).setResizable(false);
            gradeMoradoresjTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            gradeMoradoresjTable.getColumnModel().getColumn(1).setResizable(false);
            gradeMoradoresjTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            gradeMoradoresjTable.getColumnModel().getColumn(2).setResizable(false);
            gradeMoradoresjTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            gradeMoradoresjTable.getColumnModel().getColumn(3).setResizable(false);
            gradeMoradoresjTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Nome");

        nomeMoradorConsultajTextField.setEditable(false);

        jLabel5.setText("Torre");

        torrejTextField.setEditable(false);

        apartamentoConsultajTextField.setEditable(false);

        jLabel6.setText("Apartamento");

        jLabel7.setText("Ramal");

        ramalConsultajTextField.setEditable(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 109, 209)));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagemjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagemjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nomeMoradorConsultajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ramalConsultajTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(torrejTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(apartamentoConsultajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeMoradorConsultajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(torrejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(apartamentoConsultajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ramalConsultajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Resultado da consulta", jPanel5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBackground(new java.awt.Color(155, 155, 155));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator2);

        novaConsultajButton.setBackground(new java.awt.Color(155, 155, 155));
        novaConsultajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/clear.png"))); // NOI18N
        novaConsultajButton.setText("Nova Consulta - F2");
        novaConsultajButton.setFocusable(false);
        novaConsultajButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novaConsultajButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        novaConsultajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaConsultajButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(novaConsultajButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conecta = new ClassConecta();

    ComboItem combo_torres;
    ComboItem combo_apartamentos;
    protected int operador = -1;
    protected String nome_morador;
    protected int codigo_click_morador;
    protected int operador_morador;

    private void consultarTorres() {

        Torres oTorre = new Torres();

        ResultSet rs;

        try {
            rs = oTorre.getConsultar(conecta);
            torrejComboBox.removeAllItems();
            while (rs.next()) {
                torrejComboBox.addItem(new ComboItem(rs.getInt("CODIGO_TORRE"), rs.getString("NOME_TORRE")));
            }
            torrejComboBox.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o campo Torres\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void consultarApartamentos() {

        Apartamentos oApartamento = new Apartamentos();

        ResultSet rs;

        try {
            rs = oApartamento.getConsultar(conecta);
            apartamentojComboBox.removeAllItems();
            while (rs.next()) {
                apartamentojComboBox.addItem(new ComboItem(rs.getInt("CODIGO_APARTAMENTO"), rs.getString("NOME_APARTAMENTO")));
            }
            apartamentojComboBox.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o campo Apartamentos\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
    public void getGradeMoradores() throws ParseException {
        //Consultar Moradores
        Moradores oMorador = new Moradores();
        
        if ( nomeMoradorjTextField.getText().length() > 0 ){
            oMorador.setNome_pessoa(nomeMoradorjTextField.getText()+"%");
        }

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"#Id", "Morador", "Torre / Apartamento", "Ramal"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeMoradoresjTable.setModel(modeloTabela);
        gradeMoradoresjTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeMoradoresjTable.getColumnModel().getColumn(1).setPreferredWidth(230);
        gradeMoradoresjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        gradeMoradoresjTable.getColumnModel().getColumn(3).setPreferredWidth(5);

//        gradePessoajTable.setDefaultRenderer(Object.class, new ColorRenderer()); // DEIXA A GRADE ZEBRADA
        try {
            
            
            if(operador == 1){
                oMorador.setCodigo_torre(combo_torres.getId());
            }
            if(operador == 1){
                oMorador.setCodigo_apartamento(combo_apartamentos.getId());
            }
            if(operador_morador == -1){
                
                operador = -1;
                oMorador.setCodigo_pessoa_morador(operador_morador);
            }
//            if(!nome_morador.isEmpty() && operador != -1){
//                oMorador.setNome_pessoa(nome_morador);
//            }
            
            
            
            
//            oMorador.setCodigo_pessoa_morador(recebe_codigo_pessoa);
            resultSet = oMorador.getConsultarMoradores(conecta);
            if (resultSet.getRow() == 1) {
                resultSet.first();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("CODIGO_PESSOA_MORADOR")),
                    resultSet.getString("NOME_PESSOA"),
                    resultSet.getString("NOME_TORRE").concat(" / ").concat(resultSet.getString("NOME_APARTAMENTO")),
                    resultSet.getString("RAMAL")

                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getFieldMorador(int codigo_click_morador) throws ParseException {

        Moradores oMorador = new Moradores();
        ResultSet rs;
        oMorador.setCodigo_pessoa_morador(codigo_click_morador);

        try {
            rs = oMorador.getConsultar(conecta);
            rs.next();

            /**
             * Esse código verifica se existe uma foto cadastrada no banco de
             * dados. Se existir foto pega o arquivo binário e converte em
             * imagem e mostra na tela*
             */
            Blob blob = (Blob) rs.getBlob("FOTO");

            //Se a variável blob for nula não executar esse trecho ou então ira dar erro e o código não seguirá adiante.
            if (blob != null) {

                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;

                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao trazer imagem\n" + e);
                }

                try {
                    ImageIcon icon = new ImageIcon(img);
                    imagemjLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(imagemjLabel.getWidth(), imagemjLabel.getHeight(), Image.SCALE_SMOOTH)));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao trazer imagem 2\n" + e);
                }
            }//***********************Fim da condição IF do verifica blob ******************************************

            //Pegar campos
            ComboItem oTorre = new ComboItem(rs.getInt("CODIGO_TORRE"), rs.getString("NOME_TORRE"));
            torrejTextField.setText(oTorre.toString());
            
            ComboItem oApartamento = new ComboItem(rs.getInt("CODIGO_APARTAMENTO"), rs.getString("NOME_APARTAMENTO"));
            apartamentoConsultajTextField.setText(oApartamento.toString());
            
            nomeMoradorConsultajTextField.setText(rs.getString("NOME_PESSOA"));
            ramalConsultajTextField.setText(String.valueOf(rs.getInt("RAMAL")));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preecher campos\n" + ex, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            ClassConecta.conecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão com o banco de dados.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }

        consultarTorres();
        consultarApartamentos();
        
        operador = -1;
    }//GEN-LAST:event_formWindowOpened

    private void consultarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarjButtonActionPerformed
        // TODO add your handling code here:
//        if(!nomeMoradorjTextField.getText().isEmpty()){
//            nome_morador = nomeMoradorjTextField.getText().trim().toUpperCase();
//        }
        
        
        try {
            getGradeMoradores();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar grade moradores.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consultarjButtonActionPerformed

    private void torrejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torrejComboBoxActionPerformed
        // TODO add your handling code here:
        
        combo_torres = (ComboItem)torrejComboBox.getSelectedItem();
        operador = 1;
    }//GEN-LAST:event_torrejComboBoxActionPerformed

    private void apartamentojComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartamentojComboBoxActionPerformed
        // TODO add your handling code here:
        combo_apartamentos = (ComboItem)apartamentojComboBox.getSelectedItem();
        operador = 1;
    }//GEN-LAST:event_apartamentojComboBoxActionPerformed

    private void nomeMoradorjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeMoradorjTextFieldKeyReleased
        // TODO add your handling code here:
        try {   
                operador = -1;
                Moradores oMorador = new Moradores();
                oMorador.setNome_pessoa(nomeMoradorjTextField.getText());
                operador = -1;
                ResultSet rs = null;
                rs = oMorador.getConsultarMoradores(conecta);
                getGradeMoradores();
            } catch (    ParseException | SQLException ex) {
                Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_nomeMoradorjTextFieldKeyReleased

    private void gradeMoradoresjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeMoradoresjTableMouseClicked
        // TODO add your handling code here:
         codigo_click_morador = Integer.parseInt(gradeMoradoresjTable.getValueAt(gradeMoradoresjTable.getSelectedRow(), 0).toString());  
        try {
            getFieldMorador(codigo_click_morador);
        } catch (ParseException ex) {
            Logger.getLogger(jFMoradores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao pegar dados da grade\n"+ex, "Mensagen do sistema", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_gradeMoradoresjTableMouseClicked

    private void novaConsultajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaConsultajButtonActionPerformed
        // TODO add your handling code here:
        nomeMoradorConsultajTextField.setText("");
        nomeMoradorjTextField.setText("");
        torrejTextField.setText("");
        apartamentoConsultajTextField.setText("");
        ramalConsultajTextField.setText("");
        imagemjLabel.setIcon(null);
        nomeMoradorConsultajTextField.setText("");
        
        operador_morador = -1;
        
        try {
            getGradeMoradores();
        } catch (Exception e) {
        }
        operador_morador = 0;
        
        
        consultarTorres();
        consultarApartamentos();
    }//GEN-LAST:event_novaConsultajButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFConsultaMoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFConsultaMoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFConsultaMoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFConsultaMoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jFConsultaMoradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apartamentoConsultajTextField;
    private javax.swing.JComboBox apartamentojComboBox;
    private javax.swing.JButton consultarjButton;
    private javax.swing.JTable gradeMoradoresjTable;
    private javax.swing.JLabel imagemjLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nomeMoradorConsultajTextField;
    private javax.swing.JTextField nomeMoradorjTextField;
    private javax.swing.JButton novaConsultajButton;
    private javax.swing.JTextField ramalConsultajTextField;
    private javax.swing.JComboBox torrejComboBox;
    private javax.swing.JTextField torrejTextField;
    // End of variables declaration//GEN-END:variables
}