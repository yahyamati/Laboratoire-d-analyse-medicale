/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

/**
 *
 * @author loukmane04
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */   
    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        colse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        minimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuickLab Login");
        setMinimumSize(new java.awt.Dimension(1120, 630));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(560, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 630));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bg-login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 115, 194));
        jPanel2.setMinimumSize(new java.awt.Dimension(560, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Connexion");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 560, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Bonjour! Commençons votre journée de travail.");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 180, 570, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 204, 255));
        jLabel18.setText("Email");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 204, 255));
        jLabel14.setText("Mot de passe");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-30.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 60, 40));

        hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-invisible-30.png"))); // NOI18N
        hide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jPanel2.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 60, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-eye-30.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 60, 40));

        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(0, 115, 194));
        LoginBtn.setText("Se connecter");
        LoginBtn.setBorder(null);
        LoginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel2.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 400, 50));
        LoginBtn.setFocusPainted(false);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setContentAreaFilled(false);
        LoginBtn.setOpaque(true);
        LoginBtn.setBackground(new Color(255, 255, 255)); // Set default background to white

        LoginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                LoginBtn.setBackground(new Color(240,240,240)); // Change to light gray on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LoginBtn.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
            }
        });

        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 115, 194));
        email.setActionCommand("<Not Set>");
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 340, 40));
        Color customBlue = new Color(0, 115, 194);

        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel1.requestFocusInWindow();  // Request focus when panel is clicked
            }
        });
        jPanel1.setFocusable(true);  // Make the panel focusable

        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel2.requestFocusInWindow();  // Request focus when panel is clicked
            }
        });
        jPanel2.setFocusable(true);  // Make the panel focusable

        // Set initial properties for email
        email.setBackground(customBlue);
        email.setForeground(Color.WHITE);
        email.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    // Focus listener for email
    //username.addFocusListener(new FocusAdapter() {
        //@Override
        // public void focusGained(FocusEvent e) {
            //   email.setBackground(Color.WHITE);
            //   email.setBorder(BorderFactory.createCompoundBorder(
                //            BorderFactory.createMatteBorder(0, 0, 2, 0, customBlue),
                //           BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        //  }

    //  @Override
    //    public void focusLost(FocusEvent e) {
        //     email.setBackground(customBlue);
        //     email.setForeground(Color.WHITE);
        //     email.setBorder(BorderFactory.createCompoundBorder(
            //             BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
            //              BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    //    }
    //  });

    // Document listener to update text color dynamically
    //  email.getDocument().addDocumentListener(new DocumentListener() {
        //     void updateTextColor() {
            //       if (email.getText().isEmpty()) {
                //          email.setForeground(Color.WHITE);
                //      } else {
                //          email.setForeground(customBlue);
                //      }
            //    }

        //      @Override
        //      public void insertUpdate(DocumentEvent e) {
            //         updateTextColor();
            //    }
        //
        //    @Override
        //    public void removeUpdate(DocumentEvent e) {
            //        updateTextColor();
            //    }

        //    @Override
        //   public void changedUpdate(DocumentEvent e) {
            //       updateTextColor();
            //   }
        //    });

password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
password.setForeground(new java.awt.Color(0, 115, 194));
jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 340, 40));
jPanel1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        jPanel1.requestFocusInWindow();  // Request focus when panel is clicked
    }
    });
    jPanel1.setFocusable(true);  // Make the panel focusable

    jPanel2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            jPanel2.requestFocusInWindow();  // Request focus when panel is clicked
        }
    });
    jPanel2.setFocusable(true);  // Make the panel focusable

    // Set initial properties for email
    password.setBackground(customBlue);
    password.setForeground(Color.WHITE);
    password.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

// Focus listener for email
//    password.addFocusListener(new FocusAdapter() {
    //     @Override
    //      public void focusGained(FocusEvent e) {
        //        password.setBackground(Color.WHITE);
        //         password.setBorder(BorderFactory.createCompoundBorder(
            //                BorderFactory.createMatteBorder(0, 0, 2, 0, customBlue),
            //                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    //       }

    //      @Override
    //      public void focusLost(FocusEvent e) {
        //           password.setBackground(customBlue);
        //        password.setForeground(Color.WHITE);
        //          password.setBorder(BorderFactory.createCompoundBorder(
            //                  BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
            //                   BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    //       }
    //    });

    // Document listener to update text color dynamically
    //     password.getDocument().addDocumentListener(new DocumentListener() {
        //        void updateTextColor() {
            //            if (password.getText().isEmpty()) {
                //                password.setForeground(Color.WHITE);
                //           } else {
                //               password.setForeground(customBlue);
                //          }
            //      }

        //       @Override
        //        public void insertUpdate(DocumentEvent e) {
            //          updateTextColor();
            //       }

        //     @Override
        //     public void removeUpdate(DocumentEvent e) {
            //          updateTextColor();
            //       }

        //       @Override
        //       public void changedUpdate(DocumentEvent e) {
            //           updateTextColor();
            //       }
        //    });

colse.setBackground(new java.awt.Color(0, 115, 194));
colse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-30.png"))); // NOI18N
colse.setBorder(null);
colse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
colse.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        colseActionPerformed(evt);
    }
    });
    jPanel2.add(colse, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 5, 40, 40));
    colse.setFocusPainted(false);
    colse.setBorderPainted(false);
    colse.setContentAreaFilled(false);
    colse.setOpaque(true);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 175, 168));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-attention-20.png"))); // NOI18N
    jLabel1.setText("Email ou mot de passe incorrect.");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 451, 400, 40));
    jLabel1.setVisible(false);

    minimize.setBackground(new java.awt.Color(0, 115, 194));
    minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-minimize-30.png"))); // NOI18N
    minimize.setBorder(null);
    minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    minimize.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            minimizeActionPerformed(evt);
        }
    });
    jPanel2.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 5, 40, 40));
    minimize.setFocusPainted(false);
    minimize.setBorderPainted(false);
    minimize.setContentAreaFilled(false);
    minimize.setOpaque(true);

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 560, 630));

    setSize(new java.awt.Dimension(1120, 630));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked

        password.setEchoChar((char)0);
        hide.setVisible(false);
        hide.setEnabled(false);
        show.setVisible(true);
        show.setEnabled(true);

    }//GEN-LAST:event_hideMouseClicked

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
    String emailv = email.getText().trim();
    String passwordv = new String(password.getPassword()).trim();

    if (!emailv.isEmpty() && !passwordv.isEmpty()) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 9090); // Connect to the server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println("LOGIN " + emailv + " " + passwordv); // Send login details

                String response = in.readLine(); // Read the server response

                SwingUtilities.invokeLater(() -> {
                    if ("Login failed".equals(response)) {
                        jLabel1.setText("Email ou mot de passe incorrect.");
                        jLabel1.setVisible(true); // Show the error label
                    } else if (response.startsWith("Login successful")) {
                        jLabel1.setVisible(false); // Hide the error label if login is successful
                        dispose(); // Close the login form

                        // Ensure the response format is correct before splitting
                        String[] parts = response.split(":");
                        if (parts.length > 1) {
                            String role = parts[1].trim();
                            switch (role) {
                                case "Gerant":                                   
                                    smoothTransition("client.Gerant", 1000);
                                    break;
                                case "Medecin":
                                    smoothTransition("client.Medecin", 1000);
                                    break;
                                case "Receptionniste":
                                    smoothTransition("client.Receptionniste", 1000);
                                    break;
                                case "Biologiste":
                                    smoothTransition("client.Biologiste1", 1000);
                                    break;
                                default:
                                    System.out.println("Role not recognized: " + role);
                            }
                        } else {
                            System.out.println("Invalid response format: " + response);
                        }
                    }
                });

                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                SwingUtilities.invokeLater(() -> {
                    jLabel1.setText("Erreur de réseau. Réessayez."); // Short message for network issues
                    jLabel1.setVisible(true); // Show the error label
                });
            }
        }).start();
    } else {
        jLabel1.setText("Les champs sont vides.");
        jLabel1.setVisible(true);
    }

    }//GEN-LAST:event_LoginBtnActionPerformed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked

        password.setEchoChar((char)8226);
        hide.setVisible(true);
        hide.setEnabled(true);
        show.setVisible(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void colseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colseActionPerformed

        System.exit(0);
    }//GEN-LAST:event_colseActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setExtendedState(getExtendedState() | Gérer_Analyse_Medicale.ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

private void smoothTransition(String windowName, int delayMilliseconds) {
    // Initialize the Timer outside the EventQueue.invokeLater call
    Timer timer = new Timer(delayMilliseconds, null);

    java.awt.EventQueue.invokeLater(() -> {
        try {
            // Dynamically create an instance of the specified window class
            Class<?> clazz = Class.forName(windowName);
            java.awt.Window window = (java.awt.Window) clazz.getDeclaredConstructor().newInstance();
            
            // Make the window visible
            window.setVisible(true);

            // Update the Timer's ActionListener here
            timer.addActionListener((e) -> {
                // Hide the current window after the delay
                setVisible(false);
                
                // Stop the Timer
                timer.stop();
            });

            // Start the Timer
            timer.start();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            // Handle any exceptions
            ex.printStackTrace();
        }
    });
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JButton colse;
    private javax.swing.JTextField email;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton minimize;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel show;
    // End of variables declaration//GEN-END:variables
}
