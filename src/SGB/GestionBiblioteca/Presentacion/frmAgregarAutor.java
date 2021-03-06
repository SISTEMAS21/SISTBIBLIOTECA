package SGB.GestionBiblioteca.Presentacion;

import SGB.GestionBiblioteca.Entidades.Autor;
import SGB.GestionBiblioteca.LogicaNegocio.AutorLN;
import Util.Util;
import Util.mdlGeneral;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class frmAgregarAutor extends javax.swing.JDialog {
    private String[] columnas = {"Id","N°","Código","Nombre","Ap.Paterno","Ap.Materno"};
    private Integer fila = 0;

    public frmAgregarAutor() {
        super(new JDialog(),true);

        initComponents();
        
        Util.InicializarContenedor(this.getContentPane());

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);

        Util.AplicarIcono(this);

        Util.AplicarEncabezado(this,lblEncabezado,"Encabezado","AutorEs","Permite mantener un registro actualizado de los Autores");

        Util.AplicarSubencabezado(this,lblSubencabezado,"Subencabezado","Mantenimiento");

        tblAutores.setModel(new mdlGeneral(columnas));

        Integer[] anchos = {0,40,100,180,100,100};
        Integer[] alineaciones = {JLabel.LEFT,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER};
        String[] formatos = {"Cadena","Cadena","Cadena","Cadena","Cadena","Cadena"};
        String[] modos = {"Normal","Normal","Normal","Normal","Normal","Normal"};

        Util.AplicarEstilos(tblAutores,anchos,alineaciones,formatos,modos);

        Buscar();
    }

    private List aVector(List<Autor> lista) {
        List datos = new ArrayList();
        Object[] newdata;

        for(int i = 0; i < lista.size(); i++) {
            newdata = new Object[6];

            newdata[0] = lista.get(i).getIdautor();
            newdata[1] = (i + 1);
            newdata[2] = lista.get(i).getCodautor();
            newdata[3] = lista.get(i).getNomautor();
            newdata[4] = lista.get(i).getApepatautor();
            newdata[5] = lista.get(i).getApematautor();

            datos.add(newdata);
        }

        return datos;
    }

    private void ListarAutors() throws Exception {
        try {
            AutorLN categoriaLN = new AutorLN();
            ((mdlGeneral)(tblAutores.getModel())).setData(aVector(categoriaLN.ConsultarAutores(txtNombre.getText().trim().toUpperCase())));

            if(((mdlGeneral)(tblAutores.getModel())).getRowCount() > 0) {
                tblAutores.changeSelection(fila,0,false,false);
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
        tblAutores = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
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

        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoresMouseClicked(evt);
            }
        });
        tblAutores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAutoresKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAutoresKeyReleased(evt);
            }
        });
        spTemas.setViewportView(tblAutores);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spTemas))
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
                .addComponent(spTemas, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar.jpg"))); // NOI18N
        btnAgregar.setMnemonic(new Character('M'));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
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
                    .addComponent(pnlDetalle, 0, 499, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(btnAgregar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoresMouseClicked
        try {
            if(evt.getClickCount() == 1) {
                fila = tblAutores.getSelectedRow();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Siscategoria",JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_tblAutoresMouseClicked

    private void tblAutoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAutoresKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_UP && tblAutores.getSelectedRow() == 0) {
            txtNombre.requestFocus();
        }
}//GEN-LAST:event_tblAutoresKeyPressed

    private void tblAutoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAutoresKeyReleased
        fila = tblAutores.getSelectedRow();
}//GEN-LAST:event_tblAutoresKeyReleased

    private void Buscar() {
        try {
            if(Util.EsExpresionGeneralPermitida(txtNombre.getText().trim().toUpperCase())) {
                fila = 0;
                ListarAutors();
            }
            else {
                if(((mdlGeneral)(tblAutores.getModel())).getRowCount() > 0) {
                    ((mdlGeneral)(tblAutores.getModel())).removeData();
                }
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Siscategoria",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblAutores.requestFocus();
        }
        else {
            Buscar();
        }
}//GEN-LAST:event_txtNombreKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
}//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int filaseleccionada;
        
        try{
            filaseleccionada= tblAutores.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
            }else{
                if(JOptionPane.showConfirmDialog(null,"¿Desea agregar el Autor?","Mensaje del Siscategoria",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String codigo=(((mdlGeneral)(tblAutores.getModel())).getValueAt(tblAutores.getSelectedRow(),0));
                    String nombre=(((mdlGeneral)(tblAutores.getModel())).getValueAt(tblAutores.getSelectedRow(),3));
                    frmLibro.txtCodigoAutor.setText(codigo);
                    frmLibro.txtAutor.setText(nombre);
                    //frmLibro.txtCodigo.setText(GenerarCodigo());
                    JOptionPane.showMessageDialog(null,"Autor agregado correctamente","Mensaje del Siscategoria",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                
            }
            if(((mdlGeneral)(tblAutores.getModel())).getRowCount() > 0) {
                tblAutores.requestFocus();
            }
            else {
                txtNombre.requestFocus();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Siscategoria",JOptionPane.ERROR_MESSAGE);
        }     
}//GEN-LAST:event_btnAgregarActionPerformed
//        private String GenerarCodigo(){
//            String nombre=(((mdlGeneral)(tblAutors.getModel())).getValueAt(tblAutors.getSelectedRow(),3));
//            String codigo = nombre.substring(0,3)+"-";
//            for (int i = 0; i <= 5; i++) {
//                int num = (int)((Math.random()*(5))+2);
//                codigo = codigo + num;
//            }
//            return codigo;
//        }
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregar.doClick();
        }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnCerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCerrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCerrar.doClick();
        }
    }//GEN-LAST:event_btnCerrarKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JScrollPane spTemas;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}