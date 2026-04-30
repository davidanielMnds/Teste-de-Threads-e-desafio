/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui ;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class PainelFundo extends JPanel{
    private Image imgFundo;
    public PainelFundo(String caminho, int w, int h) {
    
        imgFundo = new ImageIcon(getClass().getResource(caminho))
            .getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(imgFundo, 0, 0, getWidth(), getHeight(), this);
    }
}
