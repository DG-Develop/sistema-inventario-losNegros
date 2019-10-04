/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 *
 * @author USER-PC
 */
public class SComboBox extends JComboBox {

    public SComboBox() {
        Dimension dimension = new Dimension(250, 36);
        setPreferredSize(dimension);
        setSize(dimension);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71), 2));
        setUI(CustomUI.createUI(this));
        setVisible(true);
    }
}
