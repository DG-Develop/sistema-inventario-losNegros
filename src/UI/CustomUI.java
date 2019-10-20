/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CustomUI extends BasicComboBoxUI {

    private ImageIcon espacio = new ImageIcon(getClass().getResource("/imagenes/banner.png"));
    private Color morado = new Color(62, 37, 69);
    
    public static ComboBoxUI createUI(JComponent c) {
        return new CustomUI();
    }
    
    @Override
    protected JButton createArrowButton() {
        BasicArrowButton basicArrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, //Direccion de la flecha
                Color.WHITE, //Color de fondo
                new Color(130, 7, 7),//sombra
                new Color(130, 7, 7),//darkShadow
                Color.WHITE //highlight
        );
        //se quita el efecto 3d del boton, sombra y darkShadow no se aplican 
        basicArrowButton.setBorder(BorderFactory.createLineBorder(morado, 2));
        basicArrowButton.setContentAreaFilled(false);
        return basicArrowButton;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(morado);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    //Pinta los items
    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(morado);
                if (isSelected) {
                    setBackground(morado);
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(new Color(70, 70, 70));
                }
                if (index != -1) {
                    setIcon(espacio);
                }
                return this;
            }
        };
    }
}
