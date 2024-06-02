/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BIG-INFOPHONE
 */
public class Rendez_vous extends javax.swing.JFrame {
DefaultTableModel model;
DefaultTableModel model2;   
    public Rendez_vous() {
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        initComponents();
        obligatoire.setVisible(false);
        obligatoire1.setVisible(false);
        initTable();
        initTable2();
        loadPatientData(); 
        loadRoundez_vousData();
    }
    
   private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("id_patient");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Date_naissance");
        model.addColumn("Sexe");
        model.addColumn("Email");
        model.addColumn("Num_telephone");
        jTable1.setModel(model);
    }

    private void initTable2() {
        model2 = new DefaultTableModel();
        model2.addColumn("ID");
        model2.addColumn("Nom");
        model2.addColumn("Prenom");
        model2.addColumn("Date_rendez_vous");
        model2.addColumn("Heur_rendez_vous");
        jTable2.setModel(model2);
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
        jTable1 = new javax.swing.JTable();
        ajouter = new javax.swing.JButton();
        heur = new javax.swing.JComboBox<>();
        date = new javax.swing.JTextField();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        obligatoire = new javax.swing.JLabel();
        obligatoire1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuickLab");
        setMinimumSize(new java.awt.Dimension(1920, 1040));
        setUndecorated(true);
        setResizable(false);
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

        gererrndv.setBackground(new java.awt.Color(0, 120, 200));
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
                gererrndv.setBackground(new Color(0,120,200)); // Original color when mouse not hovering
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

        gerercaisse.setBackground(new java.awt.Color(0, 105, 170));
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
                gerercaisse.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
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

        jTable1.setBackground(new java.awt.Color(213, 234, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setGridColor(new java.awt.Color(0, 115, 194));
        jTable1.setSelectionBackground(new java.awt.Color(0, 115, 194));
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 740, 360));

        ajouter.setBackground(new java.awt.Color(0, 115, 194));
        ajouter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 890, 340, 70));
        ajouter.setFocusPainted(false);
        ajouter.setBorderPainted(false);
        ajouter.setContentAreaFilled(false);
        ajouter.setOpaque(true);

        ajouter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ajouter.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ajouter.setBackground(new Color(0, 115, 194)); // Original color when mouse not hovering
            }
        });

        heur.setBackground(new java.awt.Color(213, 234, 255));
        heur.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        heur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8h", "8h_15min", "8h_30min", "8h_45min", "9h", "9h_15min", "9h_30min", "9h_45min", "10h", "10h_15min", "10h_30min", "10h_45min", "11h", "11h_15min", "11h 30min", "11h_45min", "12h", "12h_15min", "12h_30min", "12h_45min", "13h", "13h_15min", "13h_30min", "13h_45min", "14h", "14h_15min", "14h_30min", "14h_45min", "15h", "15h_15min", "15h_30min", "15h_45min", "16h", "16h_15min", "16h_30min", "16h_45min", "17h", "17h_15min" }));
        heur.setBorder(null);
        heur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heurActionPerformed(evt);
            }
        });
        jPanel1.add(heur, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 340, 40));

        date.setBackground(new java.awt.Color(213, 234, 255));
        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date.setBorder(null);
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 340, 40));
        date.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    modifier.setBackground(new java.awt.Color(0, 115, 194));
    modifier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    modifier.setForeground(new java.awt.Color(255, 255, 255));
    modifier.setText("Modifier");
    modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            modifierActionPerformed(evt);
        }
    });
    jPanel1.add(modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 890, 340, 70));
    modifier.setFocusPainted(false);
    modifier.setBorderPainted(false);
    modifier.setContentAreaFilled(false);
    modifier.setOpaque(true);

    modifier.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            modifier.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            modifier.setBackground(new Color(0, 115, 194)); // Original color when mouse not hovering
        }
    });

    supprimer.setBackground(new java.awt.Color(0, 115, 194));
    supprimer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    supprimer.setForeground(new java.awt.Color(255, 255, 255));
    supprimer.setText("Supprimer");
    supprimer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            supprimerActionPerformed(evt);
        }
    });
    jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 890, 340, 70));
    supprimer.setFocusPainted(false);
    supprimer.setBorderPainted(false);
    supprimer.setContentAreaFilled(false);
    supprimer.setOpaque(true);

    supprimer.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            supprimer.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            supprimer.setBackground(new Color(0, 115, 194)); // Original color when mouse not hovering
        }
    });

    jTable2.setBackground(new java.awt.Color(213, 234, 255));
    jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {},
            {},
            {},
            {}
        },
        new String [] {

        }
    ));
    jTable2.setFillsViewportHeight(true);
    jTable2.setFocusCycleRoot(true);
    jTable2.setFocusTraversalPolicyProvider(true);
    jTable2.setGridColor(new java.awt.Color(0, 115, 194));
    jTable2.setSelectionBackground(new java.awt.Color(0, 115, 194));
    jTable2.setVerifyInputWhenFocusTarget(false);
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jTable2MouseReleased(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 330, 550, 490));

    obligatoire.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire.setText("*");
    jPanel1.add(obligatoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

    obligatoire1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire1.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire1.setText("*");
    jPanel1.add(obligatoire1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 10, -1));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setText("Liste des patients:");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
    jLabel2.setText("Rendez-vous déja pris:");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, -1, -1));

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel3.setText("Date ");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel4.setText("Heure");
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

    jLabel14.setBackground(new java.awt.Color(255, 255, 255));
    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-appointment-scheduling-55.png"))); // NOI18N
    jLabel14.setText("Gérer les Rendez-vous");
    jLabel14.setIconTextGap(20);
    jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 680, 60));

    jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    jLabel9.setText("Choisir les informations de rendez-vous");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 1600, 1000));

    setSize(new java.awt.Dimension(1920, 1040));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
       
         int selectedRow = jTable1.getSelectedRow();
    if (selectedRow >= 0) {
        int id_patient = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());  // Récupération de l'ID du patient
        String heur_rendez_vous = heur.getSelectedItem().toString();
        String date_rendez_vous = date.getText();
        
        
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    if (heur.getSelectedIndex() == 0) {
        
        obligatoire.setVisible(true);
    
    }
    if (date_rendez_vous.trim().isEmpty()) {
        
        obligatoire1.setVisible(true);
     
    }else{
         obligatoire1.setVisible(false);
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    
     if (heur.getSelectedIndex()>0 ) {
        
        obligatoire.setVisible(false);
        // Stop further execution if nom is empty
    }
     
    ////////////////////////////////////////////////////////////////////////////////////////////

 if(!date_rendez_vous.trim().isEmpty() && heur.getSelectedIndex() >0 ){
 
   
        Client.sendRendez_vousInfo( id_patient ,heur_rendez_vous,date_rendez_vous);
        
        JOptionPane.showMessageDialog(null, "Rendez_vous ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
        
        
        loadRoundez_vousData_Quand_ajouter();
        
        
        jTable1.clearSelection();
        clearInputFields();
 }    
      
        
    }else{
    
        JOptionPane.showMessageDialog(null, "Selectionnee un Patient ", "SELECT", JOptionPane.INFORMATION_MESSAGE);
    
    }
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int selectedRow = jTable2.getSelectedRow();
          
    if (selectedRow >= 0) {
      
        String id = model2.getValueAt(selectedRow, 0).toString();  // Assuming email is the unique identifier and is in column 5
        Client.deleteRendez_vous(id);
        JOptionPane.showMessageDialog(null, "Rendez_vous Supprimer avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
        model2.removeRow(selectedRow);  // Optionally remove the row from the table view
        jTable2.clearSelection();
        clearInputFields();
    } else {
        JOptionPane.showMessageDialog(this, "No R selected", "Error", JOptionPane.ERROR_MESSAGE);
         System.out.println("Model is not initialized");
    }                                 

    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow >= 0) {
        
        
        String idValue = model2.getValueAt(selectedRow, 0).toString();
        String heurValue = heur.getSelectedItem().toString();
        String dateValue = date.getText();
       
       if(!dateValue.trim().isEmpty() && heur.getSelectedIndex() >0 ){
       
        Client.updateRendez_vous(idValue,heurValue, dateValue);
        
        JOptionPane.showMessageDialog(null, "Rendez_vous Modifier avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
       
         // Update the user in the table model
  
        model2.setValueAt(heurValue, selectedRow, 4);
        model2.setValueAt(dateValue, selectedRow, 3);
        jTable2.clearSelection();
       
        clearInputFields();
       }
       
        
    } else {
        JOptionPane.showMessageDialog(this, "No Rendez_vous selected", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_modifierActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
         //@ by Yahya Mati
        int i = jTable2.getSelectedRow();
        heur.setSelectedItem(model2.getValueAt(i, 4).toString());
        date.setText(model2.getValueAt(i, 3).toString());
        
    }//GEN-LAST:event_jTable2MouseReleased

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

    private void heurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heurActionPerformed

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
            java.util.logging.Logger.getLogger(Rendez_vous.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rendez_vous.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rendez_vous.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rendez_vous.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rendez_vous().setVisible(true);
            }
        });
    }
    
       private void loadPatientData() {
    String patientData = Client.fetchPatientData(); 
    if (patientData == null) {
        System.out.println("Failed to receive data from the server.");
        return; // Handle no data or connection error.
    }

    if (patientData.equals("No Patient found")) {
        System.out.println("No Patient found on the server.");
        return; // Handle no products found.
    }

    // Assuming each product's data is separated by a semicolon
    String[] patientEntries = patientData.split(";");
    for (String entry : patientEntries) {
        String[] dataParts = entry.split(":");
        // Ensure there are exactly three parts corresponding to the three columns
        if (dataParts.length == 7) {
            SwingUtilities.invokeLater(() -> {
                model.addRow(dataParts); // Update model on the EDT
            });
        } else {
            System.out.println("Received patient data in an unexpected format: " + entry);
        }
    }
}
        private void loadRoundez_vousData() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    String Rendez_vousData = Client.GetlRendez_vousData(); 
    if (Rendez_vousData == null) {
        System.out.println("Failed to receive data from the server.");
        return; // Handle no data or connection error.
    }

    if (Rendez_vousData.equals("No Rendez_vous found")) {
        System.out.println("No Rendez_vous found on the server.");
        return; // Handle no products found.
    }

    // Assuming each product's data is separated by a semicolon
    String[] patientEntries = Rendez_vousData.split(";");
    for (String entry : patientEntries) {
        String[] dataParts = entry.split(":");
        // Ensure there are exactly three parts corresponding to the three columns
        if (dataParts.length == 5) {
            SwingUtilities.invokeLater(() -> {
                model.addRow(dataParts); // Update model on the EDT
            });
        } else {
            System.out.println("Received Rendez_vous data in an unexpected format: " + entry);
        }
    }
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
           
        
        private void loadRoundez_vousData_Quand_ajouter() {

    model2.setRowCount(0); // Efface les données actuelles
    String Rendez_vousData = Client.GetlRendez_vousData(); 
    if (Rendez_vousData == null) {
        System.out.println("Failed to receive data from the server.");
        return; // Handle no data or connection error.
    }

    if (Rendez_vousData.equals("No Rendez_vous found")) {
        System.out.println("No Rendez_vous found on the server.");
        return; // Handle no products found.
    }

    // Assuming each product's data is separated by a semicolon
    String[] patientEntries = Rendez_vousData.split(";");
    for (String entry : patientEntries) {
        String[] dataParts = entry.split(":");
        // Ensure there are exactly three parts corresponding to the three columns
        if (dataParts.length == 5) {
            SwingUtilities.invokeLater(() -> {
                model2.addRow(dataParts); // Update model on the EDT
            });
        } else {
            System.out.println("Received Rendez_vous data in an unexpected format: " + entry);
        }
    }
}
        
        
        
        
        
    private void clearInputFields() {
    heur.setSelectedIndex(0);
    date.setText("");
  
}
       

   
   
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton colse;
    private javax.swing.JTextField date;
    private javax.swing.JButton gererbilan;
    private javax.swing.JButton gerercaisse;
    private javax.swing.JButton gererdossier;
    private javax.swing.JButton gererpatients;
    private javax.swing.JButton gererrndv;
    private javax.swing.JComboBox<String> heur;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton logout;
    private javax.swing.JButton minimize;
    private javax.swing.JButton modifier;
    private javax.swing.JLabel obligatoire;
    private javax.swing.JLabel obligatoire1;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
