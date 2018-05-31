package Estadistica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class V_Poisson extends javax.swing.JFrame {
    DefaultListModel lista = new DefaultListModel();
    DefaultListModel lista1 = new DefaultListModel();

    public V_Poisson() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblIngresoValores = new javax.swing.JLabel();
        lblValorμ = new javax.swing.JLabel();
        txtValorM = new javax.swing.JTextField();
        lblRangoProbabilidad = new javax.swing.JLabel();
        txtRangoInferior = new javax.swing.JTextField();
        lblRangoProbabilidad2 = new javax.swing.JLabel();
        txtRangoSuperior = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaX = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaResultado = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnVentanaInicio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("DISTRIBUCIÓN DE PROBABILIDAD DE POISSON");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 10, -1, -1));

        lblIngresoValores.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresoValores.setText("INGRESAR VALORES:");
        getContentPane().add(lblIngresoValores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblValorμ.setForeground(new java.awt.Color(255, 255, 255));
        lblValorμ.setText("VALOR DE μ:");
        getContentPane().add(lblValorμ, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 93, -1, -1));
        getContentPane().add(txtValorM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 60, -1));

        lblRangoProbabilidad.setForeground(new java.awt.Color(255, 255, 255));
        lblRangoProbabilidad.setText("PROBABILIDAD DESDE:");
        getContentPane().add(lblRangoProbabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(txtRangoInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 167, 60, -1));

        lblRangoProbabilidad2.setForeground(new java.awt.Color(255, 255, 255));
        lblRangoProbabilidad2.setText("HASTA");
        getContentPane().add(lblRangoProbabilidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));
        getContentPane().add(txtRangoSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 60, -1));

        btnCalcular.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jScrollPane1.setViewportView(listaX);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 60, 140));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jScrollPane2.setViewportView(listaResultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, 140));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PROBABILIDAD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        btnVentanaInicio.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        btnVentanaInicio.setText("Volver");
        btnVentanaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentanaInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentanaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 6, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wpid-Black-Background-Wood-Clean-black-wallpaper-hd.jpg"))); // NOI18N
        jLabel4.setAlignmentY(0.0F);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-550, -160, 1200, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        Estadistica o = new Estadistica();

        try {
            double Resultado, c1, c2, c3, eu, Resultado1, μ, aux, aux2;
            c1 = Integer.parseInt(txtValorM.getText());
            c2 = Integer.parseInt(txtRangoInferior.getText());
            c3 = Integer.parseInt(txtRangoSuperior.getText());
        
            for(c2=Integer.parseInt(txtRangoInferior.getText()); c2<=c3; c2++){
                Resultado = o.calcularPoisson(c2);
                eu = Math.pow(Math.E,-c1);
                μ = Math.pow(c1, c2);
                Resultado1 = (eu*μ)/Resultado;
                lista.addElement(c2);
                this.listaX.setModel(lista);
                lista1.addElement(Resultado1);
                this.listaResultado.setModel(lista1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Ha ocurrido un error", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnVentanaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentanaInicioActionPerformed
        VentanaInicio vInicio= new VentanaInicio();
        vInicio.setVisible(true);
        vInicio.setSize(575,330);
        vInicio.setResizable(false);
        vInicio.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnVentanaInicioActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnVentanaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIngresoValores;
    private javax.swing.JLabel lblRangoProbabilidad;
    private javax.swing.JLabel lblRangoProbabilidad2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorμ;
    private javax.swing.JList<String> listaResultado;
    private javax.swing.JList<String> listaX;
    private javax.swing.JTextField txtRangoInferior;
    private javax.swing.JTextField txtRangoSuperior;
    private javax.swing.JTextField txtValorM;
    // End of variables declaration//GEN-END:variables
}
