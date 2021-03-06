package SGB.GestionBiblioteca.Presentacion;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import Util.Util;

public class frmPrincipal extends javax.swing.JFrame {
    public frmPrincipal() {
        initComponents();
        
        ImageFondo image=new ImageFondo();
        image.setImage("/Iconos/sistema.jpg");
        setContentPane(image);
        
        GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        grafica.setFullScreenWindow(this);
        
        setVisible(true);
        
//        Util.AplicarIcono(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnuRegistrar = new javax.swing.JMenu();
        mnuCategoria = new javax.swing.JMenuItem();
        mnuCategoria2 = new javax.swing.JMenuItem();
        mnuCategoria1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE GESTION DE BIBLIOTECA\n");

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setToolTipText("SISTEMA DE BIBLIOTECA");
        pnlPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseMoved(evt);
            }
        });

        mnuRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/registro.png"))); // NOI18N
        mnuRegistrar.setText("Registros");

        mnuCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnuCategoria.setText("Categoria");
        mnuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriaActionPerformed(evt);
            }
        });
        mnuRegistrar.add(mnuCategoria);

        mnuCategoria2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mnuCategoria2.setText("Autor");
        mnuCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoria2ActionPerformed(evt);
            }
        });
        mnuRegistrar.add(mnuCategoria2);

        mnuCategoria1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnuCategoria1.setText("Libro");
        mnuCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoria1ActionPerformed(evt);
            }
        });
        mnuRegistrar.add(mnuCategoria1);

        jMenuBar2.add(mnuRegistrar);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/transaccion.png"))); // NOI18N
        jMenu4.setText("Transacciones");
        jMenuBar2.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/consulta.png"))); // NOI18N
        jMenu5.setText("Consultas");
        jMenuBar2.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenuBar2.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/utilitarios.png"))); // NOI18N
        jMenu7.setText("Utilitarios");
        jMenuBar2.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ayuda.png"))); // NOI18N
        jMenu8.setText("Ayuda");
        jMenuBar2.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jMenu9.setText("Salir");
        jMenuBar2.add(jMenu9);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Sistema \"GESTION DE BIBLIOTECA\"");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriaActionPerformed
        frmCategorias ofrmCategorias = new frmCategorias();
        ofrmCategorias.setVisible(true);
    }//GEN-LAST:event_mnuCategoriaActionPerformed

    private void pnlPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseMoved

    }//GEN-LAST:event_pnlPrincipalMouseMoved

    private void mnuCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoria1ActionPerformed
        frmLibros ofrmLibros = new frmLibros();
        ofrmLibros.setVisible(true);
    }//GEN-LAST:event_mnuCategoria1ActionPerformed

    private void mnuCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoria2ActionPerformed
        frmAutores ofrmAutores = new frmAutores();
        ofrmAutores.setVisible(true);
    }//GEN-LAST:event_mnuCategoria2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem mnuCategoria;
    private javax.swing.JMenuItem mnuCategoria1;
    private javax.swing.JMenuItem mnuCategoria2;
    private javax.swing.JMenu mnuRegistrar;
    private javax.swing.JDesktopPane pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
