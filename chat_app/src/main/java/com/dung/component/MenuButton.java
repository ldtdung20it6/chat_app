/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author TRUNG DUNG
 */
public class MenuButton extends JButton {

    public Icon geticon() {
        return icon;
    }

    public void seticon(Icon icon) {
        this.icon = icon;
    }

    public Icon getSelectedIcon() {
        return SelectedIcon;
    }

    public void setSelectedIcon(Icon SelectedIcon) {
        this.SelectedIcon = SelectedIcon;
    }

    private Icon icon;
    private Icon SelectedIcon;

    public MenuButton() {
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public void setSelected(boolean bln) {
        super.setSelected(bln);
        if (bln) {
            setIcon(SelectedIcon);
        } else {
            setIcon(icon);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (isSelected()) {
            grphcs.setColor(new Color(110, 213, 255));
            grphcs.fillRect(0, getHeight() - 3, getWidth(), getHeight());
        }
    }
}
