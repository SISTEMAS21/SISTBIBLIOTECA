package SGB.GestionBiblioteca.Presentacion;


import SGB.GestionBiblioteca.Entidades.Autor;
import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.Entidades.Libro;
import SGB.GestionBiblioteca.LogicaNegocio.LibroLN;
import Util.Util;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class frmLibro extends javax.swing.JDialog {
    private Libro libro;
    private String modo;

    public frmLibro(Libro libro, String modo) {
        super(new JDialog(),true);

        initComponents();

        this.libro = libro;
        this.modo = modo;

        Util.InicializarContenedor(this.getContentPane());

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);

        Util.AplicarIcono(this);

        Util.AplicarEncabezado(this,lblEncabezado,"Encabezado","Libro","Permite registrar o actualizar los datos de un libro");

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
//        txtCodigoCategoria.setVisible(false);
//        txtCodigoAutor.setVisible(false);
    }  

    
    private void InicializarFormulario() {
        Util.InicializarContenedor(pnlDetalle);

        if(modo.equals("Nuevo")) {
            libro = new Libro();
        }
        else if(modo.equals("Ver") || modo.equals("Modificar")) {
            if(libro != null) {
                txtCodigo.setText(libro.getCodlibro());
                txtNombre.setText(libro.getNomlibro());
                txtNumpag.setText(libro.getNumpag().toString());
                txtEdicion.setText(libro.getEdicion().toString());
                txtGenero.setText(libro.getGenero());
                txtCodigoCategoria.setText(libro.getOcategoria().getIdcat().toString());
                txtCategoria.setText(libro.getOcategoria().getNomcat());
                txtCodigoAutor.setText(libro.getOautor().getIdautor().toString());
                txtAutor.setText(libro.getOautor().getNomautor());
            }
            else {
                JOptionPane.showMessageDialog(null,"Se debe indicar el Libro","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);

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
        lnlNumpag = new javax.swing.JLabel();
        txtNumpag = new javax.swing.JTextField();
        lblEdicion = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtCodigoCategoria = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        lblCategoria1 = new javax.swing.JLabel();
        txtCodigoAutor = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        btnBuscarAutor = new javax.swing.JButton();
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

        lnlNumpag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lnlNumpag.setText("Num. Paginas");

        txtNumpag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNumpag.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumpagFocusGained(evt);
            }
        });
        txtNumpag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumpagKeyPressed(evt);
            }
        });

        lblEdicion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEdicion.setText("Edición");

        txtEdicion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtEdicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdicionFocusGained(evt);
            }
        });
        txtEdicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdicionKeyPressed(evt);
            }
        });

        txtGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtGenero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGeneroFocusGained(evt);
            }
        });
        txtGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGeneroKeyPressed(evt);
            }
        });

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGenero.setText("Genero");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCategoria.setText("Categoria");

        txtCodigoCategoria.setEditable(false);
        txtCodigoCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCodigoCategoria.setEnabled(false);
        txtCodigoCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoCategoriaKeyPressed(evt);
            }
        });

        txtCategoria.setEditable(false);
        txtCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCategoriaFocusGained(evt);
            }
        });
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
            }
        });

        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btnBuscarCategoria.setText("Buscar");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        lblCategoria1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCategoria1.setText("Autor");

        txtCodigoAutor.setEditable(false);
        txtCodigoAutor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCodigoAutor.setEnabled(false);
        txtCodigoAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoAutorKeyPressed(evt);
            }
        });

        txtAutor.setEditable(false);
        txtAutor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAutorFocusGained(evt);
            }
        });
        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAutorKeyPressed(evt);
            }
        });

        btnBuscarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btnBuscarAutor.setText("Buscar");
        btnBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutorActionPerformed(evt);
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
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(lnlNumpag, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumpag, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(lblEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlDetalleLayout.createSequentialGroup()
                                    .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGenero))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetalleLayout.createSequentialGroup()
                                    .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCodigo)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCategoria))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(lblCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarAutor)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(lblSubencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCategoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnlNumpag, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumpag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if(JOptionPane.showConfirmDialog(null,"¿Desea registrar el Libro?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(txtNombre.getText().trim().toUpperCase().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Libro","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

                if(txtAutor.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del AutorS","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtAutor.requestFocus();
                    return;
                }    
                
//               if(txtNombre.getText().trim().toUpperCase().length() > 50) {
//                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Libro (Máximo 50 caracteres)","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
//                    txtNombre.requestFocus();
//                    return;
//                }

               if(!Util.EsExpresionGeneralPermitida(txtNombre.getText().trim().toUpperCase())) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del Libro (Expresión general permitida)","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }

                libro.setCodlibro(modo.equals("Nuevo")?null:txtCodigo.getText().trim().toUpperCase());
                libro.setCodlibro(txtCodigo.getText());
                libro.setNomlibro(txtNombre.getText().trim().toUpperCase());
                libro.setNumpag(Integer.parseInt(txtNumpag.getText().trim().toUpperCase()));
                libro.setEdicion(Integer.parseInt(txtEdicion.getText().trim().toUpperCase()));
                libro.setGenero(txtGenero.getText().trim().toUpperCase());
                libro.setOcategoria(new Categoria(Integer.parseInt(txtCodigoCategoria.getText().trim().toUpperCase())));
                libro.setOautor(new Autor(Integer.parseInt(txtCodigoAutor.getText().trim().toUpperCase())));
                
                LibroLN libroLN = new LibroLN();

                Libro libroEncontrado = libroLN.ConsultarLibro(libro);

                if(libroEncontrado != null) {
                    JOptionPane.showMessageDialog(null,"El código y el nombre deben ser únicos","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtCodigo.requestFocus();
                    return;
                }

                if(modo.equals("Nuevo")) {
                    libroLN.RegistrarLibro(libro);
                }
                else {
                    libroLN.ModificarLibro(libro);
                }

                JOptionPane.showMessageDialog(null,"Libro registrado correctamente","Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE);

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

    private void txtNumpagFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumpagFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumpagFocusGained

    private void txtNumpagKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumpagKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumpagKeyPressed

    private void txtEdicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdicionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicionFocusGained

    private void txtEdicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdicionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicionKeyPressed

    private void txtGeneroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGeneroFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroFocusGained

    private void txtGeneroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroKeyPressed

    private void txtCodigoCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCategoriaKeyPressed

    private void txtCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoriaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaFocusGained

    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaKeyPressed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        frmAgregarCategoria ofrmAgregarCategoria = new frmAgregarCategoria();
        ofrmAgregarCategoria.setVisible(true);
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void txtCodigoAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoAutorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoAutorKeyPressed

    private void txtAutorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorFocusGained

    private void txtAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorKeyPressed

    private void btnBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutorActionPerformed
        frmAgregarAutor ofrmAgregarAutor = new frmAgregarAutor();
        ofrmAgregarAutor.setVisible(true);
    }//GEN-LAST:event_btnBuscarAutorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategoria1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JLabel lnlNumpag;
    private javax.swing.JPanel pnlDetalle;
    public static javax.swing.JTextField txtAutor;
    public static javax.swing.JTextField txtCategoria;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtCodigoAutor;
    public static javax.swing.JTextField txtCodigoCategoria;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumpag;
    // End of variables declaration//GEN-END:variables
}