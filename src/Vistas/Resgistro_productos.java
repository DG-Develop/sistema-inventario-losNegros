package Vistas;

import Controlador.Conexion;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Resgistro_productos extends javax.swing.JFrame {

    private String nombre_producto = "";
    private String categoria_producto = "";
    private double costo_producto = 0.0;
    private double costo_normal = 0.0;

    private int id_produucto;

    private int x;
    private int y;

    private Conexion con = new Conexion();

    public Resgistro_productos() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarDatosTabla();
        //con.createBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_nombre_producto = new javax.swing.JTextField();
        txt_categoria = new javax.swing.JTextField();
        txt_costo_producto = new javax.swing.JTextField();
        txt_costo_normal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(252, 250, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 40, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 590, 60));

        jPanel1.setBackground(new java.awt.Color(252, 250, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(62, 37, 69)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 37, 69));
        jLabel1.setText("Nombre del producto: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 37, 69));
        jLabel2.setText("Categoría: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(62, 37, 69));
        jLabel3.setText("Costo del producto: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(62, 37, 69));
        jLabel4.setText("Costo normal: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 120, 230, 10));

        txt_nombre_producto.setBackground(new java.awt.Color(252, 250, 246));
        txt_nombre_producto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_nombre_producto.setForeground(new java.awt.Color(153, 153, 153));
        txt_nombre_producto.setBorder(null);
        txt_nombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_productoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nombre_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 230, 40));

        txt_categoria.setBackground(new java.awt.Color(252, 250, 246));
        txt_categoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_categoria.setForeground(new java.awt.Color(153, 153, 153));
        txt_categoria.setBorder(null);
        txt_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoriaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 230, 40));

        txt_costo_producto.setBackground(new java.awt.Color(252, 250, 246));
        txt_costo_producto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_costo_producto.setForeground(new java.awt.Color(155, 155, 155));
        txt_costo_producto.setBorder(null);
        jPanel1.add(txt_costo_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 230, 40));

        txt_costo_normal.setBackground(new java.awt.Color(252, 250, 246));
        txt_costo_normal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_costo_normal.setForeground(new java.awt.Color(155, 155, 155));
        txt_costo_normal.setBorder(null);
        jPanel1.add(txt_costo_normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 230, 40));

        jButton1.setText("Imprimir lista de productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, -1, -1));

        jButton2.setText("Limpiar Campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 180, 230, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 240, 230, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 300, 230, 10));

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(1);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save_126.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/saveclaro.png"))); // NOI18N
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 130, 170));

        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(62, 37, 69));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar_1.png"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setIconTextGap(1);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar_1_126.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarclaro.png"))); // NOI18N
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 120, 180));

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(62, 37, 69));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setIconTextGap(1);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_126.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarclaro.png"))); // NOI18N
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 140, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 0, 610, 666));

        jPanel2.setBackground(new java.awt.Color(252, 250, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(62, 37, 69)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Producto", "Nombre del producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_inventario.setGridColor(new java.awt.Color(62, 37, 69));
        tabla_inventario.setRowHeight(22);
        tabla_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_inventarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_inventario);
        if (tabla_inventario.getColumnModel().getColumnCount() > 0) {
            tabla_inventario.getColumnModel().getColumn(0).setResizable(false);
            tabla_inventario.getColumnModel().getColumn(0).setHeaderValue("Id Producto");
            tabla_inventario.getColumnModel().getColumn(1).setResizable(false);
            tabla_inventario.getColumnModel().getColumn(1).setHeaderValue("Nombre del producto");
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 430, 490));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(62, 37, 69));
        jLabel5.setText("Datos de los productos");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setIconTextGap(1);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar_40.png"))); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresarclaro.png"))); // NOI18N
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 666));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_productoActionPerformed

    private void txt_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoriaActionPerformed

    private void tabla_inventarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_inventarioMousePressed
        int filaSeleccionada = this.tabla_inventario.getSelectedRow();

        try {

            String id = tabla_inventario.getValueAt(filaSeleccionada, 0).toString();

            String[] producto_datos = con.datosProducto(id);

            txt_nombre_producto.setText(producto_datos[0]);
            txt_categoria.setText(producto_datos[1]);
            txt_costo_producto.setText(producto_datos[2]);
            txt_costo_normal.setText(producto_datos[3]);

            setId_produucto(Integer.parseInt(id));

        } catch (Exception e) {
            System.out.println("Error al leer datos de la tabla");
        }

    }//GEN-LAST:event_tabla_inventarioMousePressed

    public int getId_produucto() {
        return id_produucto;
    }

    public void setId_produucto(int id_produucto) {
        this.id_produucto = id_produucto;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //con.crearPDFCotizacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setState(Menu.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir de la apliación?", "Exit", dialog);

        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txt_nombre_producto.getText().toString().isEmpty() || txt_categoria.getText().toString().isEmpty()
                || txt_costo_producto.getText().toString().isEmpty() || txt_costo_normal.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los datos");
        } else {
            nombre_producto = txt_nombre_producto.getText().trim();
            categoria_producto = txt_categoria.getText().trim();
            costo_producto = Double.parseDouble(txt_costo_producto.getText().trim());
            costo_normal = Double.parseDouble(txt_costo_normal.getText().trim());

            con.insertarDatos(nombre_producto, categoria_producto, costo_producto, costo_normal);

            mostrarDatosTabla();
        }
        limpiarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        nombre_producto = txt_nombre_producto.getText().trim();
        categoria_producto = txt_categoria.getText().trim();
        costo_producto = Double.parseDouble(txt_costo_producto.getText().trim());
        costo_normal = Double.parseDouble(txt_costo_normal.getText().trim());

        con.actualizarDatos(getId_produucto(), nombre_producto, categoria_producto, costo_producto, costo_normal);

        mostrarDatosTabla();

        limpiarCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        con.eliminarDatos(getId_produucto());

        mostrarDatosTabla();

        limpiarCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void limpiarCampos() {
        txt_nombre_producto.setText("");
        txt_categoria.setText("");
        txt_costo_producto.setText("");
        txt_costo_normal.setText("");
    }

    public void mostrarDatosTabla() {
        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
                con.tablaProductos(),
                new String[]{
                    "Id Producto", "Nombre del producto"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resgistro_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resgistro_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resgistro_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resgistro_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resgistro_productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tabla_inventario;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_costo_normal;
    private javax.swing.JTextField txt_costo_producto;
    private javax.swing.JTextField txt_nombre_producto;
    // End of variables declaration//GEN-END:variables

}
