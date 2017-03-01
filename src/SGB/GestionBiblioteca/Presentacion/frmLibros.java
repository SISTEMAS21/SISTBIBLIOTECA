package SGB.GestionBiblioteca.Presentacion;


import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.LogicaNegocio.CategoriaLN;
import Util.Util;
import Util.mdlGeneral;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmLibros extends javax.swing.JDialog {
    private String[] columnas = {"Id","N°","Código","Nombre"};
    private Integer fila = 0;

    public frmLibros() {
        super(new JDialog(),true);

        initComponents();

        Util.InicializarContenedor(this.getContentPane());

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);

        Util.AplicarIcono(this);

        Util.AplicarEncabezado(this,lblEncabezado,"Encabezado","Categorias","Permite mantener un registro actualizado de las categorias");

        Util.AplicarSubencabezado(this,lblSubencabezado,"Subencabezado","Mantenimiento");

        tblCategorias.setModel(new mdlGeneral(columnas));

        Integer[] anchos = {0,40,50,580};
        Integer[] alineaciones = {JLabel.LEFT,JLabel.CENTER,JLabel.CENTER,JLabel.LEFT};
        String[] formatos = {"Cadena","Cadena","Cadena","Cadena"};
        String[] modos = {"Normal","Normal","Normal","Resaltado"};

        Util.AplicarEstilos(tblCategorias,anchos,alineaciones,formatos,modos);

        Buscar();
    }

    private List aVector(List<Categoria> lista) {
        List datos = new ArrayList();
        Object[] newdata;

        for(int i = 0; i < lista.size(); i++) {
            newdata = new Object[4];

            newdata[0] = lista.get(i).getIdcat();
            newdata[1] = (i + 1);
            newdata[2] = lista.get(i).getCodcat();
            newdata[3] = lista.get(i).getNomcat();

            datos.add(newdata);
        }

        return datos;
    }

    private void ListarCategorias() throws Exception {
        try {
            CategoriaLN categoriaLN = new CategoriaLN();
            ((mdlGeneral)(tblCategorias.getModel())).setData(aVector(categoriaLN.ConsultarCategorias(txtNombre.getText().trim().toUpperCase())));

            if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                tblCategorias.changeSelection(fila,0,false,false);
            }
            else {
                txtNombre.requestFocus();
            }
        }
        catch(Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEncabezado = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        lblSubencabezado = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        spTemas = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categorias");
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

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btnBuscar.setMnemonic(new Character('B'));
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriasMouseClicked(evt);
            }
        });
        tblCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCategoriasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCategoriasKeyReleased(evt);
            }
        });
        spTemas.setViewportView(tblCategorias);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spTemas, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(lblSubencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTemas, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnVer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ver.png"))); // NOI18N
        btnVer.setMnemonic(new Character('V'));
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        btnVer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVerKeyPressed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btnNuevo.setMnemonic(new Character('N'));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btnModificar.setMnemonic(new Character('M'));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setMnemonic(new Character('E'));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        btnCerrar.setMnemonic(new Character('C'));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        btnCerrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCerrarKeyPressed(evt);
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
                    .addComponent(pnlDetalle, 0, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVer)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnCerrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriasMouseClicked
        try {
            if(evt.getClickCount() == 1) {
                fila = tblCategorias.getSelectedRow();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_tblCategoriasMouseClicked

    private void tblCategoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoriasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_UP && tblCategorias.getSelectedRow() == 0) {
            txtNombre.requestFocus();
        }
}//GEN-LAST:event_tblCategoriasKeyPressed

    private void tblCategoriasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoriasKeyReleased
        fila = tblCategorias.getSelectedRow();
}//GEN-LAST:event_tblCategoriasKeyReleased

    private void Buscar() {
        try {
            if(Util.EsExpresionGeneralPermitida(txtNombre.getText().trim().toUpperCase())) {
                fila = 0;
                ListarCategorias();
            }
            else {
                if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                    ((mdlGeneral)(tblCategorias.getModel())).removeData();
                }
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblCategorias.requestFocus();
        }
        else {
            Buscar();
        }
}//GEN-LAST:event_txtNombreKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
}//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        try {
            if(tblCategorias.getSelectedRow() != -1) {
                Integer id = Integer.parseInt(((mdlGeneral)(tblCategorias.getModel())).getValueAt(tblCategorias.getSelectedRow(),0).toString());

                CategoriaLN categoriaLN = new CategoriaLN();
                Categoria tipoServicio = categoriaLN.ConsultarCategoria(id);

                if(tipoServicio != null) {
                    frmCategoria ofrmCategoria = new frmCategoria(tipoServicio,"Ver");
                    ofrmCategoria.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Categoria no registrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Debe seleccionar una Categoria","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }

            if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                tblCategorias.requestFocus();
            }
            else {
                txtNombre.requestFocus();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnVerActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            frmCategoria ofrmCategoria = new frmCategoria(null,"Nuevo");
            ofrmCategoria.setVisible(true);

            ListarCategorias();

            if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                tblCategorias.requestFocus();
            }
            else {
                txtNombre.requestFocus();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if(tblCategorias.getSelectedRow() != -1) {
                Integer id = Integer.parseInt(((mdlGeneral)(tblCategorias.getModel())).getValueAt(tblCategorias.getSelectedRow(),0).toString());

                CategoriaLN categoriaLN = new CategoriaLN();
                Categoria tipoServicio = categoriaLN.ConsultarCategoria(id);

                if(tipoServicio != null) {
                    frmCategoria ofrmCategoria = new frmCategoria(tipoServicio,"Modificar");
                    ofrmCategoria.setVisible(true);

                    ListarCategorias();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Categoria no registrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Debe seleccionar una Categoria","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }

            if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                tblCategorias.requestFocus();
            }
            else {
                txtNombre.requestFocus();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if(tblCategorias.getSelectedRow() != -1) {
                if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar la Categoria?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Integer id = Integer.parseInt(((mdlGeneral)(tblCategorias.getModel())).getValueAt(tblCategorias.getSelectedRow(),0).toString());

                    CategoriaLN categoriaLN = new CategoriaLN();
                    categoriaLN.EliminarCategoria(new Categoria(id));

                    JOptionPane.showMessageDialog(null,"Categoria eliminada correctamente","Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE);

                    if(fila > 0) {
                        fila--;
                    }

                    ListarCategorias();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Debe seleccionar una Categoria","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }

            if(((mdlGeneral)(tblCategorias.getModel())).getRowCount() > 0) {
                tblCategorias.requestFocus();
            }
            else {
                txtNombre.requestFocus();
            }
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se puede eliminar la Categoria","Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnVerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVerKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnVer.doClick();
        }
    }//GEN-LAST:event_btnVerKeyPressed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnNuevo.doClick();
        }
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnModificar.doClick();
        }
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEliminar.doClick();
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnCerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCerrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCerrar.doClick();
        }
    }//GEN-LAST:event_btnCerrarKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JScrollPane spTemas;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}