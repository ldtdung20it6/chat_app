/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.dung.form;

import com.dung.component.Item_People;
import com.dung.model.Model_User_Account;
import com.dung.swing.ScrollBar;
import event.EventMenuLeft;
import event.PublicEvent;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author TRUNG DUNG
 */
public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;

    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for (Model_User_Account d : users) {
                    userAccount.add(d);
                    menuList.add(new Item_People(d), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        showMessage();
    }

    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (Model_User_Account d : userAccount) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showGroup() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.dung.component.MenuButton();
        menuGroup = new com.dung.component.MenuButton();
        menuBox = new com.dung.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setBorder(null);
        menuMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/message_selected.png"))); // NOI18N
        menuMessage.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/message_selected.png"))); // NOI18N
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setBorder(null);
        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/group.png"))); // NOI18N
        menuGroup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/group_selected.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setBorder(null);
        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/box.png"))); // NOI18N
        menuBox.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dung/icon/box_selected.png"))); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        // TODO add your handling code here:
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            menuBox.setSelected(false);
            showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        // TODO add your handling code here:
        if (!menuGroup.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            menuBox.setSelected(false);
            showGroup();
        }
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        // TODO add your handling code here:
        if (!menuBox.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(false);
            menuBox.setSelected(true);
            showBox();
        }
    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private com.dung.component.MenuButton menuBox;
    private com.dung.component.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private com.dung.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
