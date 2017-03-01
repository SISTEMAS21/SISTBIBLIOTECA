package SGB.GestionBiblioteca.Presentacion;


import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.LogicaNegocio.CategoriaLN;
import Util.Util;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class frmCategoria extends javax.swing.JDialog {
    private Categoria categoria;
    private String modo;

    public frmCategoria(Categoria categoria, String modo) {
        super(new JDialog(),true);

        initComponents();

        this.categoria = categoria;
        this.modo = modo;

        Util.InicializarContenedor(this.getContentPane());

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);

        Util.AplicarIcono(this);

        Util.AplicarEncabezado(this,lblEncabezado,"Encabezado","Categoria","Permite registrar o actualizar los datos de una categoria");

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
            categoria = new Categoria();
        }
        else if(modo.equals("Ver") || modo.equals("Modificar")) {
            if(categoria != null) {
                txtCodigo.setText(categoria.getCodcat());
                txtNombre.setText(categoria.getNomcat());
            }
            else {
                JOptionPane.showMessageDialog(null,"Se debe indicar la Categoria","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);

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
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");
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

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(lblSubencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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
            .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 196, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try  {
            if(JOptionPane.showConfirmDialog(null,"¿Desea registrar la Categoria?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(txtNombre.getText().trim().toUpperCase().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la Categoria","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

               if(txtNombre.getText().trim().toUpperCase().length() > 50) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Categoria (Máximo 50 caracteres)","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

               if(!Util.EsExpresionGeneralPermitida(txtNombre.getText().trim().toUpperCase())) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la Categoria (Expresión general permitida)","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

                categoria.setCodcat(modo.equals("Nuevo")?null:txtCodigo.getText().trim().toUpperCase());
                categoria.setNomcat(txtNombre.getText().trim().toUpperCase());

                CategoriaLN categoriaLN = new CategoriaLN();

                Categoria categoriaEncontrado = categoriaLN.ConsultarCategoria(categoria);

                if(categoriaEncontrado != null) {
                    JOptionPane.showMessageDialog(null,"El código y el nombre deben ser únicos","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtCodigo.requestFocus();
                    return;
                }

                if(modo.equals("Nuevo")) {
                    categoriaLN.RegistrarCategoria(categoria);
                }
                else {
                    categoriaLN.ModificarCategoria(categoria);
                }

                JOptionPane.showMessageDialog(null,"Categoria registrada correctamente","Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}