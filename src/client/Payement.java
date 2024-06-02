
package client;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BIG-INFOPHONE
 */
public final class Payement extends javax.swing.JFrame {
    
    DefaultTableModel model;
    

    
    
    
    public Payement() {
        
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        
        initComponents();
        initPatientTable();
         loadPatientData();
         
        

         
    }
    
    
  private void initPatientTable() {
        model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // Only the checkbox column is editable
            }
        };

        model.addColumn("ID");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Date_naissance");
        model.addColumn("Sexe");
        model.addColumn("Email");
        model.addColumn("Num_telephone");

        patient_table.setModel(model);
    }
  




   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        minimize = new javax.swing.JButton();
        colse = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        gererpatients = new javax.swing.JButton();
        gererdossier = new javax.swing.JButton();
        gererrndv = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        gererbilan = new javax.swing.JButton();
        gerercaisse = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patient_table = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        totale = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuickLab");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimize.setBackground(new java.awt.Color(0, 0, 0));
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-minimize-30.png"))); // NOI18N
        minimize.setBorder(null);
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        jPanel2.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1820, 0, 40, 40));
        minimize.setFocusPainted(false);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setOpaque(true);

        minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minimize.setBackground(new Color(20,20,20)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimize.setBackground(new Color(0, 0,0)); // Original color when mouse not hovering
            }
        });

        colse.setBackground(new java.awt.Color(0, 0, 0));
        colse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-close-30.png"))); // NOI18N
        colse.setBorder(null);
        colse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colseActionPerformed(evt);
            }
        });
        jPanel2.add(colse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 0, 40, 40));
        colse.setFocusPainted(false);
        colse.setBorderPainted(false);
        colse.setContentAreaFilled(false);
        colse.setOpaque(true);

        colse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colse.setBackground(new Color(20,20,20)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                colse.setBackground(new Color(0, 0,0)); // Original color when mouse not hovering
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("QuickLab");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 40));

        jPanel4.setBackground(new java.awt.Color(0, 98, 166));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gererpatients.setBackground(new java.awt.Color(0, 105, 170));
        gererpatients.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gererpatients.setForeground(new java.awt.Color(255, 255, 255));
        gererpatients.setText("Gérer Patients");
        gererpatients.setToolTipText("");
        gererpatients.setBorder(null);
        gererpatients.setBorderPainted(false);
        gererpatients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gererpatients.setDoubleBuffered(true);
        gererpatients.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gererpatients.setIconTextGap(50);
        gererpatients.setName(""); // NOI18N
        gererpatients.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gererpatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererpatientsActionPerformed(evt);
            }
        });
        jPanel4.add(gererpatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 320, 70));
        gererpatients.setFocusPainted(false);
        gererpatients.setBorderPainted(false);
        gererpatients.setContentAreaFilled(false);
        gererpatients.setOpaque(true);

        gererpatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gererpatients.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gererpatients.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
            }
        });

        gererdossier.setBackground(new java.awt.Color(0, 105, 170));
        gererdossier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gererdossier.setForeground(new java.awt.Color(255, 255, 255));
        gererdossier.setText("Gérer Dossier Patients");
        gererdossier.setBorder(null);
        gererdossier.setBorderPainted(false);
        gererdossier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gererdossier.setDoubleBuffered(true);
        gererdossier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gererdossier.setIconTextGap(50);
        gererdossier.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gererdossier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererdossierActionPerformed(evt);
            }
        });
        jPanel4.add(gererdossier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 320, 70));
        gererdossier.setFocusPainted(false);
        gererdossier.setBorderPainted(false);
        gererdossier.setContentAreaFilled(false);
        gererdossier.setOpaque(true);

        gererdossier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gererdossier.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gererdossier.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
            }
        });

        gererrndv.setBackground(new java.awt.Color(0, 105, 170));
        gererrndv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gererrndv.setForeground(new java.awt.Color(255, 255, 255));
        gererrndv.setText("Gérer Rendez-Vous");
        gererrndv.setBorder(null);
        gererrndv.setBorderPainted(false);
        gererrndv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gererrndv.setDoubleBuffered(true);
        gererrndv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gererrndv.setIconTextGap(50);
        gererrndv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gererrndv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererrndvActionPerformed(evt);
            }
        });
        jPanel4.add(gererrndv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 320, 70));
        gererrndv.setFocusPainted(false);
        gererrndv.setBorderPainted(false);
        gererrndv.setContentAreaFilled(false);
        gererrndv.setOpaque(true);

        gererrndv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gererrndv.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gererrndv.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
            }
        });

        home.setBackground(new java.awt.Color(0, 105, 170));
        home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Accueil");
        home.setToolTipText("");
        home.setBorder(null);
        home.setBorderPainted(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setDoubleBuffered(true);
        home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        home.setIconTextGap(50);
        home.setName(""); // NOI18N
        home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel4.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 320, 70));
        home.setFocusPainted(false);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setOpaque(true);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(new Color(0,105,170)); // Original color when mouse not hovering
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Receptionniste");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 16));
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 320, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-user-100.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, 150, 150));

        gererbilan.setBackground(new java.awt.Color(0, 105, 170));
        gererbilan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gererbilan.setForeground(new java.awt.Color(255, 255, 255));
        gererbilan.setText("Gérer Les Bilans");
        gererbilan.setBorder(null);
        gererbilan.setBorderPainted(false);
        gererbilan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gererbilan.setDoubleBuffered(true);
        gererbilan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gererbilan.setIconTextGap(50);
        gererbilan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gererbilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererbilanActionPerformed(evt);
            }
        });
        jPanel4.add(gererbilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 320, 70));
        gererbilan.setFocusPainted(false);
        gererbilan.setBorderPainted(false);
        gererbilan.setContentAreaFilled(false);
        gererbilan.setOpaque(true);

        gererbilan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gererbilan.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gererbilan.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
            }
        });

        gerercaisse.setBackground(new java.awt.Color(0, 120, 200));
        gerercaisse.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gerercaisse.setForeground(new java.awt.Color(255, 255, 255));
        gerercaisse.setText("Gérer La Caisse");
        gerercaisse.setBorder(null);
        gerercaisse.setBorderPainted(false);
        gerercaisse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gerercaisse.setDoubleBuffered(true);
        gerercaisse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gerercaisse.setIconTextGap(50);
        gerercaisse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gerercaisse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerercaisseActionPerformed(evt);
            }
        });
        jPanel4.add(gerercaisse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 320, 70));
        gerercaisse.setFocusPainted(false);
        gerercaisse.setBorderPainted(false);
        gerercaisse.setContentAreaFilled(false);
        gerercaisse.setOpaque(true);

        gerercaisse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gerercaisse.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gerercaisse.setBackground(new Color(0, 120, 200)); // Original color when mouse not hovering
            }
        });

        logout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(0, 115, 194));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-log-out-30.png"))); // NOI18N
        logout.setText("Déconnexion");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setDoubleBuffered(true);
        logout.setIconTextGap(5);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel4.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 901, 220, 60));
        logout.setFocusPainted(false);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setOpaque(true);
        logout.setBackground(new Color(255, 255, 255)); // Set default background to white

        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setBackground(new Color(240,240,240)); // Change to light gray on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
            }
        });

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patient_table.setAutoCreateRowSorter(true);
        patient_table.setBackground(new java.awt.Color(213, 234, 255));
        patient_table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        patient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        patient_table.setFillsViewportHeight(true);
        patient_table.setFocusCycleRoot(true);
        patient_table.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(patient_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 950, 500));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-cash-register-55.png"))); // NOI18N
        jLabel14.setText("Gérer La Caisse");
        jLabel14.setIconTextGap(20);
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 680, 60));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel15.setText("Choisissez un patient et entrez le montant total payé");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        valider.setBackground(new java.awt.Color(0, 115, 194));
        valider.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        valider.setForeground(new java.awt.Color(255, 255, 255));
        valider.setText("Valider");
        valider.setBorder(null);
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        jPanel1.add(valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 340, 70));
        valider.setFocusPainted(false);
        valider.setBorderPainted(false);
        valider.setContentAreaFilled(false);
        valider.setOpaque(true);
        valider.setBackground(new Color(0, 115, 194)); // Set default background to white

        valider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                valider.setBackground(new Color(23,142,224)); // Change to light gray on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                valider.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
            }
        });

        totale.setBackground(new java.awt.Color(213, 234, 255));
        totale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totale.setBorder(null);
        jPanel1.add(totale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 340, 50));
        totale.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel2.setText("Montant total payé:");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 340, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 1600, 1000));

    setSize(new java.awt.Dimension(1920, 1040));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
    try {
            // Get the total revenue from the 'totale' text field
            double totalRevenue = Double.parseDouble(totale.getText().trim());

            // Get the selected patient ID from the table
            int selectedRow = patient_table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a patient.", "No Patient Selected", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int id_patient = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
 
            // Send the total revenue and patient ID to the server
            Client.sendDailyRevenueCalculationRequest(id_patient, totalRevenue);
            JOptionPane.showMessageDialog(null, "Payement avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            
            
            
            patient_table.clearSelection();
            clearInputFields();
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for total: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the total.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error sending revenue to server: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error communicating with server.", "Communication Error", JOptionPane.ERROR_MESSAGE);
        }
        
             
        
    }//GEN-LAST:event_validerActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setExtendedState(getExtendedState() | Gérer_Analyse_Medicale.ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void colseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colseActionPerformed

        System.exit(0);
    }//GEN-LAST:event_colseActionPerformed

    private void gererpatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererpatientsActionPerformed
        smoothTransition("client.Ajouter_Patient", 1000);
    }//GEN-LAST:event_gererpatientsActionPerformed

    private void gererdossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererdossierActionPerformed
        smoothTransition("client.Dossier", 1000);
    }//GEN-LAST:event_gererdossierActionPerformed

    private void gererrndvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererrndvActionPerformed
        smoothTransition("client.Rendez_vous", 1000);
    }//GEN-LAST:event_gererrndvActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        smoothTransition("client.Receptionniste", 1000);
    }//GEN-LAST:event_homeActionPerformed

    private void gererbilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererbilanActionPerformed
        smoothTransition("client.Gérer_Bilan", 1000);
    }//GEN-LAST:event_gererbilanActionPerformed

    private void gerercaisseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerercaisseActionPerformed
        smoothTransition("client.Payement", 1000);
    }//GEN-LAST:event_gerercaisseActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    
    
    
    private void loadPatientData() {
    String patientData = Client.fetchPatientData(); // Fetch data from server
    if (patientData == null) {
        System.out.println("Failed to receive data from the server.");
        return;
    }

    if (patientData.equals("No Patient found")) {
        System.out.println("No Patient found on the server.");
        return;
    }

    String[] patientEntries = patientData.split(";");
    for (String entry : patientEntries) {
        String[] dataParts = entry.split(":");
        if (dataParts.length == 7) {
            Object[] rowData = new Object[8];
            System.arraycopy(dataParts, 0, rowData, 0, 7);
            rowData[7] = Boolean.FALSE; // Initialize the checkbox to unchecked
            model.addRow(rowData);
        } else {
            System.out.println("Received patient data in an unexpected format: " + entry);
        }
    }
}
    
    
      private void clearInputFields() {
    totale.setText("");
    
      }   
      
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
    
    
private void smoothTransition(String windowName, int delayMilliseconds, Object... constructorArgs) {
    // Initialize the Timer outside the EventQueue.invokeLater call
    Timer timer = new Timer(delayMilliseconds, null);

    java.awt.EventQueue.invokeLater(() -> {
        try {
            // Dynamically create an instance of the specified window class
            Class<?> clazz = Class.forName(windowName);
            // Determine parameter types from constructorArgs
            Class<?>[] parameterTypes = new Class<?>[constructorArgs.length];
            for (int i = 0; i < constructorArgs.length; i++) {
                parameterTypes[i] = constructorArgs[i].getClass();
            }
            java.awt.Window window = (java.awt.Window) clazz.getDeclaredConstructor(parameterTypes).newInstance(constructorArgs);
            
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
            java.util.logging.Logger.getLogger(Payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colse;
    private javax.swing.JButton gererbilan;
    private javax.swing.JButton gerercaisse;
    private javax.swing.JButton gererdossier;
    private javax.swing.JButton gererpatients;
    private javax.swing.JButton gererrndv;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton minimize;
    private javax.swing.JTable patient_table;
    private javax.swing.JTextField totale;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
