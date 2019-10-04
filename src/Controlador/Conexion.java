/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.istack.internal.logging.Logger;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author USER-PC
 */
public class Conexion {

    String url_base = "BaseProductos";
    Connection conexion = null;
    Statement stm = null;
    PreparedStatement stm2 = null;

    private ArrayList<String> lista_id = new ArrayList<String>();
    private ArrayList<String> lista_nombre = new ArrayList<String>();

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url_base);
            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException ex) {
            System.out.println("Conexion fallida: " + ex);
        }
    }

    public void cerrar_sesion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class).log(Level.SEVERE, null, ex);
        }
    }

    public void createBD() {

        try {
            conectar();

            stm = conexion.createStatement();

            String sql = "CREATE TABLE productos"
                    + "(id_producto INTEGER PRIMARY KEY autoincrement,"
                    + "nombre_producto VARCHAR(50) NOT NULL UNIQUE,"
                    + "categoria_producto VARCHAR(50) NOT NULL,"
                    + "costo_producto DOUBLE NOT NULL,"
                    + "costo_normal DOUBLE NOT NULL)";

            stm.executeUpdate(sql);
            stm.close();

            cerrar_sesion();

        } catch (SQLException e) {
            System.out.println("No se pudo crear la base de datos");
        }
    }

    public void insertarDatos(String nombre_producto, String categoria_prodcuto, double costo_producto, double costo_normal) {

        try {
            conectar();

            stm = conexion.createStatement();

            String sql = "INSERT INTO productos (id_producto,nombre_producto, categoria_producto, costo_producto, costo_normal) "
                    + "VALUES(NULL,'" + nombre_producto + "', '" + categoria_prodcuto
                    + "', '" + costo_producto + "', '" + costo_normal + "')";

            stm.executeUpdate(sql);

            stm.close();

            cerrar_sesion();

        } catch (SQLException e) {
            System.out.println("No se pudo registrar el producto");
        }

    }

    public String[][] tablaProductos() {

        lista_id.clear();

        lista_nombre.clear();

        String productos[][] = null;

        try {
            conectar();

            stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                lista_id.add(String.valueOf(rs.getInt("id_producto")));
                lista_nombre.add(rs.getString("nombre_producto"));
            }

            productos = new String[lista_id.size()][2];

            for (int i = 0; i < lista_id.size(); i++) {
                productos[i][0] = lista_id.get(i);
                productos[i][1] = lista_nombre.get(i);
            }

            rs.close();

            stm.close();

            cerrar_sesion();

        } catch (SQLException e) {
            System.out.println("No se pudo sacar los resultados de la tabla productos");
        }

        return productos;
    }

    public String[] datosProducto(String id) {

        String datos[] = new String[4];

        try {
            conectar();

            stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                if (id.equals(rs.getString("id_producto"))) {
                    datos[0] = rs.getString("nombre_producto");
                    datos[1] = rs.getString("categoria_producto");
                    datos[2] = rs.getString("costo_producto");
                    datos[3] = rs.getString("costo_normal");
                }
            }

        } catch (SQLException e) {
            System.out.println("No pude obtener los datos de la tabla productos");
        }

        return datos;
    }

    public void actualizarDatos(int id_producto, String nombre_producto, String categoria_producto, double costo_producto,
            double costo_normal) {
        try {
            conectar();

            String sql = "UPDATE productos SET nombre_producto = ?, categoria_producto = ?, "
                    + "costo_producto = ?, costo_normal = ? WHERE id_producto = " + id_producto;

            stm2 = conexion.prepareStatement(sql);

            stm2.setString(1, nombre_producto);
            stm2.setString(2, categoria_producto);
            stm2.setDouble(3, costo_producto);
            stm2.setDouble(4, costo_normal);

            stm2.executeUpdate();

            stm.close();

            cerrar_sesion();

        } catch (SQLException e) {
            System.out.println("No se pudieron actualizar los datos");
            e.printStackTrace();
        }
    }

    public void eliminarDatos(int id_producto) {
        try {
            conectar();

            stm = conexion.createStatement();

            String sql = "DELETE FROM productos WHERE id_producto = " + id_producto;

            stm.executeUpdate(sql);

            stm.close();

            cerrar_sesion();

        } catch (SQLException e) {
            System.out.println("No se puedo borrar el dato");
        }
    }

    public void crearPDF() {
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Cotizacion.pdf"));

            Image header = Image.getInstance("src/imagenes/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato creado por DGDBAND Systems ® \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Productos registrados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre del producto");
            tabla.addCell("Categoria");
            tabla.addCell("Costo del producto");
            tabla.addCell("Costo normal");

            try {
                conectar();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {

                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());

                    documento.add(tabla);
                }

            } catch (SQLException | DocumentException e) {

            }
            documento.close();
            JOptionPane.showMessageDialog(null, "PDF creado");

        } catch (FileNotFoundException | DocumentException | HeadlessException e) {

        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

    public void crearPDFCotizacion(int contar, String[] Cantidad, String[] Descripcion, String[] PrecioUnitario, String[] Importe) {
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Cotizacion.pdf"));

            Image header = Image.getInstance("src/imagenes/lonegros.png");
            header.scaleToFit(200, 100);
            
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\"LOS NEGROS\"");

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.setFont(FontFactory.getFont("Tahoma", 8, Font.ITALIC, BaseColor.BLACK));
            parrafo2.add("-MATERIALES PARA CONSTRUCCIÓN-");

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.setFont(FontFactory.getFont("Tahoma", 8, Font.NORMAL, BaseColor.BLACK));
            parrafo3.add("ADOLFO JIMENEZ HERNANDEZ\nRFC: JIHA751112A12\n\n");

            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo4.setFont(FontFactory.getFont("Tahoma", 8, Font.NORMAL, BaseColor.BLACK));
            parrafo4.add("Calle Acción Nacional #10 por final de Calle Ecuador y\nCalle Corte,"
                    + " Ampliación Polvorin II, C.P. 24060,\n San Francisco de Campeche, Campeche."
                    + "\nTel. 144-03-65    Cel. 981-170-5364\n\n");

            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo5.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo5.add("COTIZACIÓN");

            Paragraph parrafo6 = new Paragraph();
            parrafo6.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo6.setFont(FontFactory.getFont("Tahoma", 8, Font.ITALIC, BaseColor.DARK_GRAY));
            parrafo6.add("San Francisco de Campeche, Campeche, a 26 de Junio del 2019.\n\n");

            Paragraph parrafo7 = new Paragraph();
            parrafo7.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo7.setFont(FontFactory.getFont("Tahoma", 8, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo7.add("Receptor: \n");

            Paragraph parrafo8 = new Paragraph();
            parrafo7.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo7.setFont(FontFactory.getFont("Tahoma", 8, Font.NORMAL, BaseColor.DARK_GRAY));
            parrafo7.add("TUBOS Y TUBOS, S.A. DE C.V.\n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(parrafo2);
            documento.add(parrafo3);
            documento.add(parrafo4);
            documento.add(parrafo5);
            documento.add(parrafo6);
            documento.add(parrafo7);
            documento.add(parrafo8);

            PdfPTable tabla = new PdfPTable(5);

            Paragraph cantidad = new Paragraph();
            cantidad.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            cantidad.add("CANTIDAD");

            Paragraph descripcion = new Paragraph();
            descripcion.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            descripcion.add("DESCRIPCION");

            Paragraph precio = new Paragraph();
            precio.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            precio.add("PRECIO\nUNITARIO");

            Paragraph importe = new Paragraph();
            importe.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            importe.add("IMPORTE");

            PdfPCell celda1 = new PdfPCell(cantidad);
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(celda1);

            PdfPCell celda2 = new PdfPCell(descripcion);
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2.setColspan(2);
            tabla.addCell(celda2);

            PdfPCell celda3 = new PdfPCell(precio);
            celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(celda3);

            PdfPCell celda4 = new PdfPCell(importe);
            celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(celda4);

            double suma = 0;

            for (int i = 0; i < contar; i++) {
                PdfPCell celda5 = new PdfPCell(new Paragraph(Cantidad[i]));
                celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda5.setPadding(10);
                tabla.addCell(celda5);

                PdfPCell celda6 = new PdfPCell(new Paragraph(Descripcion[i]));
                celda6.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda6.setPadding(10);
                celda6.setColspan(2);
                tabla.addCell(celda6);

                PdfPCell celda7 = new PdfPCell(new Paragraph(PrecioUnitario[i]));
                celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda7.setPadding(10);
                tabla.addCell(celda7);

                PdfPCell celda8 = new PdfPCell(new Paragraph(Importe[i]));
                celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda8.setPadding(10);
                tabla.addCell(celda8);

                suma = suma + Double.parseDouble(Importe[i]);
            }

            tabla.setWidthPercentage(100f);

            documento.add(tabla);

            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            double iva = suma * 0.16;

            double Total = suma + iva;

            PdfPTable tablaTotal = new PdfPTable(2);
            tablaTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);

            Paragraph subtotal = new Paragraph();
            subtotal.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            subtotal.add("SUBTOTAL");

            Paragraph num_subtotal = new Paragraph();
            num_subtotal.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            num_subtotal.add("$ " + String.valueOf(suma));

            Paragraph IVA = new Paragraph();
            IVA.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            IVA.add("IVA");

            Paragraph num_iva = new Paragraph();
            num_iva.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            num_iva.add("$ " + String.valueOf(iva));

            Paragraph total = new Paragraph();
            total.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            total.add("TOTAL");

            Paragraph num_total = new Paragraph();
            num_total.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            num_total.add("$ " + String.valueOf(Total));

            PdfPCell celda9 = new PdfPCell(subtotal);
            celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda9.setPadding(10);
            tablaTotal.addCell(celda9);

            PdfPCell celda10 = new PdfPCell(num_subtotal);
            celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda10.setPadding(10);
            tablaTotal.addCell(celda10);

            PdfPCell celda11 = new PdfPCell(IVA);
            celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda11.setPadding(10);
            tablaTotal.addCell(celda11);

            PdfPCell celda12 = new PdfPCell(num_iva);
            celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda12.setPadding(10);
            tablaTotal.addCell(celda12);

            PdfPCell celda13 = new PdfPCell(total);
            celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda13.setPadding(10);
            tablaTotal.addCell(celda13);

            PdfPCell celda14 = new PdfPCell(num_total);
            celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda14.setPadding(10);
            tablaTotal.addCell(celda14);
            
            tablaTotal.setWidthPercentage(50f);

            documento.add(tablaTotal);

            Paragraph parrafo9 = new Paragraph();
            parrafo9.add("\n\n\n\n");

            Paragraph parrafo10 = new Paragraph();
            parrafo10.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo10.setFont(FontFactory.getFont("Tahoma", 8, Font.NORMAL, BaseColor.DARK_GRAY));
            parrafo10.add("_______________________________\n");

            Paragraph parrafo11 = new Paragraph();
            parrafo11.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo11.setFont(FontFactory.getFont("Tahoma", 8, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo11.add("ADOLFO JIMENEZ HERNANDEZ\n");

            documento.add(parrafo9);
            documento.add(parrafo10);
            documento.add(parrafo11);

            documento.close();
            JOptionPane.showMessageDialog(null, "PDF creado");

        } catch (FileNotFoundException | DocumentException | HeadlessException e) {

        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

    public void comboCategoria(JComboBox combo) {

        try {
            conectar();

            stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT DISTINCT categoria_producto FROM productos");

            while (rs.next()) {
                combo.addItem(rs.getString("categoria_producto"));
            }

        } catch (SQLException e) {
            System.out.println("No pude obtener los datos de la tabla productos");
        }

    }

    public void comboProductos(JComboBox combo, String categoria_productos) {
        combo.removeAllItems();

        try {
            conectar();

            stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT nombre_producto FROM productos WHERE categoria_producto=\"" + categoria_productos + "\"");

            while (rs.next()) {
                combo.addItem(rs.getString("nombre_producto"));
            }

        } catch (SQLException e) {
            System.out.println("No pude obtener los datos de la tabla productos \n" + e);
        }
    }

    public String buscarCostoProducto(String nombre_producto) {
        String costo = null;

        try {
            conectar();

            stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery("SELECT costo_producto FROM productos WHERE nombre_producto=\"" + nombre_producto + "\"");

            while (rs.next()) {
                costo = rs.getString("costo_producto");
            }

        } catch (SQLException e) {
            System.out.println("No pude obtener los datos de la tabla productos \n" + e);
        }

        return costo;
    }
}
