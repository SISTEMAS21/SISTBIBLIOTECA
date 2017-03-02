package SGB.GestionBiblioteca.Presentacion;


import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.Entidades.Autor;
import SGB.GestionBiblioteca.LogicaNegocio.AutorLN;
import Util.Util;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class frmAutor extends javax.swing.JDialog {
    private Autor autor;
    private String modo;

    public frmAutor(Autor autor, String modo) {
        super(new JDialog(),true);

        initComponents();

        this.autor = autor;
        this.modo = modo;

        Util.InicializarContenedor(this.getContentPane());

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);

        Util.AplicarIcono(this);

        Util.AplicarEncabezado(this,lblEncabezado,"Encabezado","Autor","Permite registrar o actualizar los datos de un autor");

        Util.AplicarSubencabezado(this,lblSubencabezado,"Subencabezado",modo);

        InicializarFormulario();

        if (modo.equals("Nuevo") || modo.equals("Modificar")) {
            Util.HabilitarContenedor(pnlDetalle,true);

            txtNombre.requestFocus();
        }
        else {
            Util.HabilitarContenedor(pnlDetalle,false);

            btnGuardar.setEnabled(false);

            btnCancelar.requestFocus();
        }
    }  

    
    private void InicializarFormulario() {
        Util.InicializarContenedor(pnlDetalle);

        if(modo.equals("Nuevo")) {
            autor = new Autor();
        }
        else if(modo.equals("Ver") || modo.equals("Modificar")) {
            if(autor != null) {
                txtCodigo.setText(autor.getCodautor());
                txtNombre.setText(autor.getNomautor());
                txtApepat.setText(autor.getApepatautor());
                txtApemat.setText(autor.getApematautor());
            }
            else {
                JOptionPane.showMessageDialog(null,"Se debe indicar el Autor","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);

                this.dispose();
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Se debe indicar el modo","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEncabezado = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        lblSubencabezado = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtApepat = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtApemat = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Libro");
        setName(""); // NOI18N
        setResizable(false);

        lblEncabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pnlDetalle.setPreferredSize(new java.awt.Dimension(443, 338));

        lblSubencabezado.setBackground(new java.awt.Color(255, 255, 255));
        lblSubencabezado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSubencabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubencabezado.setText(" ");
        lblSubencabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblSubencabezado.setOpaque(true);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        lblNombre1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre1.setText("Ap. Paterno");

        txtApepat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApepat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApepatFocusGained(evt);
            }
        });
        txtApepat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApepatKeyPressed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre2.setText("Ap. Materno");

        txtApemat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApemat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApematFocusGained(evt);
            }
        });
        txtApemat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApematKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubencabezado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApepat, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApemat, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(lblSubencabezado)
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApepat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApemat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btnGuardar.setMnemonic(new Character('G'));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btnCancelar.setMnemonic(new Character('L'));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try  {
            if(JOptionPane.showConfirmDialog(null,"¿Desea registrar la Autor?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(txtNombre.getText().trim().toUpperCase().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Autor","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

                if(txtApepat.getText().trim().toUpperCase().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el Apellido Paterno del Autor","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtApepat.requestFocus();
                    return;
                }
                
                if(txtApemat.getText().trim().toUpperCase().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el Apellido Materno del Autor","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtApemat.requestFocus();
                    return;
                }
                
                if(txtNombre.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del AutorS","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }    
                


               if(!Util.EsExpresionGeneralPermitida(txtNombre.getText().trim().toUpperCase())) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Autor (Expresión general permitida)","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

                autor.setCodautor(modo.equals("Nuevo")?null:txtCodigo.getText().trim().toUpperCase());
                autor.setNomautor(txtNombre.getText().trim().toUpperCase());
                autor.setApepatautor(txtApepat.getText().trim().toUpperCase());
                autor.setApematautor(txtApemat.getText().trim().toUpperCase());
                
                AutorLN autorLN = new AutorLN();

                Autor autorEncontrado = autorLN.ConsultarAutor(autor);

                if(autorEncontrado != null) {
                    JOptionPane.showMessageDialog(null,"El código y el nombre deben ser únicos","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtCodigo.requestFocus();
                    return;
                }

                if(modo.equals("Nuevo")) {
                    autorLN.RegistrarAutor(autor);
                }
                else {
                    autorLN.ModificarAutor(autor);
                }

                JOptionPane.showMessageDialog(null,"Autor registrado correctamente","Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE);

                this.dispose();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardar.doClick();
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCancelar.doClick();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardar.requestFocus();
        }
}//GEN-LAST:event_txtNombreKeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        txtNombre.selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtApepatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApepatFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApepatFocusGained

    private void txtApepatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApepatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApepatKeyPressed

    private void txtApematFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApematFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApematFocusGained

    private void txtApematKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApematKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApematKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtApemat;
    private javax.swing.JTextField txtApepat;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}