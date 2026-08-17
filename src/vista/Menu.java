package vista;

/**
 *
 * @author Edwis Jimenez
 */
public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    /**
     * Creates new form Menu
     */
    public Menu() {
        //Se inicializan los componentes
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AFAppIcon.png")).getImage());
        setTitle("AstraFly 1.0.0");
        
        //Se agregan los diferentes frames del programa 
        contentPanel.add(new vista.PanelesAdmin.PanelReservasAdmin(), "Administrar Reservas");
        contentPanel.add(new vista.PanelesAdmin.PanelUsuariosAdmin(), "Administrar Usuarios");
        contentPanel.add(new vista.PanelesAdmin.PanelVuelosAdmin(), "Administrar Vuelos");
        contentPanel.add(new vista.PanelAcercaDe(), "Acerca De");
        
        java.awt.CardLayout cardLayout = (java.awt.CardLayout) contentPanel.getLayout();
 
        sVGVuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sVGVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Vuelos");
                lblSectionTxt.setText("Administrar Vuelos");
                
                selectFrVuelos.setVisible(true);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
        lblVuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Vuelos");
                lblSectionTxt.setText("Administrar Vuelos");
                
                selectFrVuelos.setVisible(true);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
 
        sVGReservasEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sVGReservasEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Reservas");
                lblSectionTxt.setText("Administrar Reservas");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(true);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
        lblReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Reservas");
                lblSectionTxt.setText("Administrar Reservas");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(true);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
 
        sVGUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sVGUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Usuarios");
                lblSectionTxt.setText("Administrar Usuarios");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(true);
                selectFrAcercaDe.setVisible(false);
            }
        });
        lblUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Usuarios");
                lblSectionTxt.setText("Administrar Usuarios");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(true);
                selectFrAcercaDe.setVisible(false);
            }
        });
 
        sVGAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sVGAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Acerca De");
                lblSectionTxt.setText("Acerca De");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(true);
            }
        });
        lblAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Acerca De");
                lblSectionTxt.setText("Acerca De");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(true);
            }
        });
 
        sVGSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sVGSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.exit(0);
            }
        });
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.exit(0);
            }
        });
 
        vuelosPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vuelosPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Vuelos");
                lblSectionTxt.setText("Administrar Vuelos");
                
                selectFrVuelos.setVisible(true);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
        reservasPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservasPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Reservas");
                lblSectionTxt.setText("Administrar Reservas");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(true);
                selectFrUsuarios.setVisible(false);
                selectFrAcercaDe.setVisible(false);
            }
        });
        usuariosPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuariosPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(contentPanel, "Administrar Usuarios");
                lblSectionTxt.setText("Administrar Usuarios");
                
                selectFrVuelos.setVisible(false);
                selectFrReservas.setVisible(false);
                selectFrUsuarios.setVisible(true);
                selectFrAcercaDe.setVisible(false);
            }
        });

        
        inicio.setImage("/vista/imagenes/AdminAFMenuImage.png");//se le asigna una imagen al menu de inicio
        
        //Botones cuadrados del menu de inicio
        inicio.setBlur(vuelosPanel3);
        inicio.setBlur(reservasPanel3);
        inicio.setBlur(usuariosPanel5);
        
        this.setLocationRelativeTo(null);//centrar el form
        
        //Se le asigna imagenes/iconos a los diferentes labels
        AstraFlyIcon1.setSvgImage("vista/imagenes/AstraFlyIconInSVG(1).svg", 200, 150);
        
        sVGVuelos.setSvgImage("vista/imagenes/airplane-svgrepo-com.svg", 35, 35);
        sVGReservasEdit.setSvgImage("vista/imagenes/calendar-lines-pen-svgrepo-com.svg", 30, 30);
        sVGUsuarios.setSvgImage("vista/imagenes/user-pen-alt-1-svgrepo-com.svg", 30, 30);
        sVGAcercaDe.setSvgImage("vista/imagenes/info-svgrepo-com.svg", 30, 30);
        sVGSalir.setSvgImage("vista/imagenes/power-symbol-svgrepo-com.svg", 30, 30);
        
        sVGVuelos5.setSvgImage("vista/imagenes/airplane-svgrepo-com.svg", 60, 60);
        sVGReservas5.setSvgImage("vista/imagenes/calendar-lines-pen-svgrepo-com.svg", 45, 45);
        sVGUsuarios7.setSvgImage("vista/imagenes/users-svgrepo-com.svg", 70, 70);
        
        selectFrVuelos.setArc(10);
        selectFrReservas.setArc(10);
        selectFrUsuarios.setArc(10);
        selectFrAcercaDe.setArc(10);
        
        selectFrVuelos.setVisible(false);
        selectFrReservas.setVisible(false);
        selectFrUsuarios.setVisible(false);
        selectFrAcercaDe.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        AstraFlyIcon1 = new swing.SVGImage();
        sVGVuelos = new swing.SVGImage();
        lblVuelos = new javax.swing.JLabel();
        sVGReservasEdit = new swing.SVGImage();
        lblReservas = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        sVGAcercaDe = new swing.SVGImage();
        sVGUsuarios = new swing.SVGImage();
        lblUsuarios = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        sVGSalir = new swing.SVGImage();
        selectFrAcercaDe = new swing.Button();
        selectFrVuelos = new swing.Button();
        selectFrReservas = new swing.Button();
        selectFrUsuarios = new swing.Button();
        lblSectionTxt = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        inicio = new login.Background();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        vuelosPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        sVGVuelos5 = new swing.SVGImage();
        reservasPanel3 = new javax.swing.JPanel();
        sVGReservas5 = new swing.SVGImage();
        jLabel29 = new javax.swing.JLabel();
        usuariosPanel5 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        sVGUsuarios7 = new swing.SVGImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(0, 17, 37));

        jPanel2.setBackground(new java.awt.Color(0, 10, 25));
        jPanel2.setForeground(new java.awt.Color(0, 17, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(AstraFlyIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 20, 160, 70));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 169, -1));
        jPanel2.add(sVGVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 96, 32, 50));

        lblVuelos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVuelos.setForeground(new java.awt.Color(255, 255, 255));
        lblVuelos.setText("Vuelos");
        jPanel2.add(lblVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 107, -1, -1));
        jPanel2.add(sVGReservasEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 164, 33, 50));

        lblReservas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblReservas.setForeground(new java.awt.Color(255, 255, 255));
        lblReservas.setText("Reservas");
        jPanel2.add(lblReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 175, -1, -1));

        lblAcercaDe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        lblAcercaDe.setText("Acerca de");
        jPanel2.add(lblAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 311, -1, -1));
        jPanel2.add(sVGAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 300, 32, 50));
        jPanel2.add(sVGUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 232, 32, 50));

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarios.setText("Usuarios");
        jPanel2.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 243, -1, -1));

        lblSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setText("Salir");
        jPanel2.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 380, -1, -1));
        jPanel2.add(sVGSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 368, 32, 50));
        jPanel2.add(selectFrAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, 70));
        jPanel2.add(selectFrVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 60));
        jPanel2.add(selectFrReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 60));
        jPanel2.add(selectFrUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 70));

        lblSectionTxt.setBackground(new java.awt.Color(255, 255, 255));
        lblSectionTxt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblSectionTxt.setForeground(new java.awt.Color(255, 255, 255));
        lblSectionTxt.setText("Menú Principal");

        contentPanel.setOpaque(false);
        contentPanel.setLayout(new java.awt.CardLayout());

        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("de vuelos y reservas");
        inicio.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Controla toda la operación");
        inicio.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Todo lo que necesitas en un solo lugar");
        inicio.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        vuelosPanel3.setOpaque(false);
        vuelosPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Administrar Vuelos");
        vuelosPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));
        vuelosPanel3.add(sVGVuelos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 15, 60, 60));

        inicio.add(vuelosPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 160, 120));

        reservasPanel3.setOpaque(false);
        reservasPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        reservasPanel3.add(sVGReservas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 12, 60, 60));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Administrar Reservas");
        reservasPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 70, 140, 30));

        inicio.add(reservasPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 160, 120));

        usuariosPanel5.setOpaque(false);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Administrar Usuarios");

        javax.swing.GroupLayout usuariosPanel5Layout = new javax.swing.GroupLayout(usuariosPanel5);
        usuariosPanel5.setLayout(usuariosPanel5Layout);
        usuariosPanel5Layout.setHorizontalGroup(
            usuariosPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(sVGUsuarios7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuariosPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        usuariosPanel5Layout.setVerticalGroup(
            usuariosPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGUsuarios7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        inicio.add(usuariosPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        contentPanel.add(inicio, "card2");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSectionTxt)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSectionTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.SVGImage AstraFlyIcon1;
    private javax.swing.JPanel contentPanel;
    private login.Background inicio;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblReservas;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblSectionTxt;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JLabel lblVuelos;
    private javax.swing.JPanel reservasPanel3;
    private swing.SVGImage sVGAcercaDe;
    private swing.SVGImage sVGReservas5;
    private swing.SVGImage sVGReservasEdit;
    private swing.SVGImage sVGSalir;
    private swing.SVGImage sVGUsuarios;
    private swing.SVGImage sVGUsuarios7;
    private swing.SVGImage sVGVuelos;
    private swing.SVGImage sVGVuelos5;
    private swing.Button selectFrAcercaDe;
    private swing.Button selectFrReservas;
    private swing.Button selectFrUsuarios;
    private swing.Button selectFrVuelos;
    private javax.swing.JPanel usuariosPanel5;
    private javax.swing.JPanel vuelosPanel3;
    // End of variables declaration//GEN-END:variables
}
