
package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.InvocationTargetException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;





public class Dossier extends javax.swing.JFrame {
DefaultTableModel model;
   
    public Dossier() {
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        initComponents();
        initTable();
        loadPatientData();
        obligatoire.setVisible(false);
        obligatoire1.setVisible(false);
        obligatoire2.setVisible(false);
        obligatoire3.setVisible(false);
        obligatoire4.setVisible(false);
        obligatoire5.setVisible(false);
        
        jScrollPane2.setVisible(false);
        jTable3.setVisible(false);
        
        jPanel4.setVisible(true);  
        
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);        
        rech1.setVisible(false);
        find1.setVisible(false);
    }
    
    public Dossier(String medecin) {
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        initComponents();
        initTable();
        loadPatientData();  
        jPanel4.setVisible(false);
        jPanel6.setVisible(true);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        
        obligatoire.setVisible(false);
        obligatoire1.setVisible(false);
        obligatoire2.setVisible(false);
        obligatoire3.setVisible(false);
        obligatoire4.setVisible(false);
        obligatoire5.setVisible(false);
        
        adresse_clinique.setVisible(false);
        information_assurance.setVisible(false);
        nom_medecin.setVisible(false);
        numero_assurance.setVisible(false);
        numero_urgence.setVisible(false);
        
        jScrollPane1.setVisible(false);
        jTable2.setVisible(false);
        
        jPanel3.setVisible(false);
        rech.setVisible(false);
        find.setVisible(false);        
        
        save.setVisible(false);

    
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
        jTable2.setModel(model);
        jTable3.setModel(model);
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


   
   private void clearInputFields() {
    rech.setText("");
    numero_urgence.setText("");     
    numero_assurance.setText("");
    information_assurance.setText("");
    nom_medecin.setText("");
    telephone_medecin.setText("");
    adresse_clinique.setText("");
   
   
}
        
      
private void performSearchAndUpdateTable(String firstName, String lastName) {



    model.setRowCount(0);

    // Fetch the search data
    String searchData = Client.searchPatientByName(firstName, lastName);
    if (searchData == null || searchData.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No patients found with the provided search terms.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Split and process each row of data
    String[] rows = searchData.split(";");
    for (String row : rows) {
        // Split each column of data
        String[] data = row.split(":");

        // Ensure there is data for each column
        if (data.length == 7) { // Assuming there are 7 columns
            Object[] tableRow = new Object[7];
            tableRow[0] = data[0]; // ID
            tableRow[1] = data[1]; // First Name
            tableRow[2] = data[2]; // Last Name
            tableRow[3] = data[3]; // Date of Birth
            tableRow[4] = data[4]; // Gender
            tableRow[5] = data[5]; // Email
            tableRow[6] = data[6]; // Phone Number

            // Add the row to the designated table model
            model.addRow(tableRow);
        }
    }
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
        numero_urgence = new javax.swing.JTextField();
        numero_assurance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        afficher = new javax.swing.JButton();
        information_assurance = new javax.swing.JTextField();
        nom_medecin = new javax.swing.JTextField();
        telephone_medecin = new javax.swing.JTextField();
        adresse_clinique = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        obligatoire5 = new javax.swing.JLabel();
        obligatoire = new javax.swing.JLabel();
        obligatoire1 = new javax.swing.JLabel();
        obligatoire2 = new javax.swing.JLabel();
        obligatoire3 = new javax.swing.JLabel();
        obligatoire4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rech = new javax.swing.JTextField();
        find = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        rech1 = new javax.swing.JTextField();
        find1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        analyse = new javax.swing.JButton();
        stock = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        home1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        logout1 = new javax.swing.JButton();

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

        gererdossier.setBackground(new java.awt.Color(0, 120, 200));
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
                gererdossier.setBackground(new Color(0, 120, 200)); // Original color when mouse not hovering
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
                home.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
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
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero_urgence.setBackground(new java.awt.Color(213, 234, 255));
        numero_urgence.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numero_urgence.setBorder(null);
        jPanel1.add(numero_urgence, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 340, 40));
        numero_urgence.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    numero_assurance.setBackground(new java.awt.Color(213, 234, 255));
    numero_assurance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    numero_assurance.setBorder(null);
    jPanel1.add(numero_assurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 340, 40));
    numero_assurance.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
jLabel1.setText("Numéro de téléphone d'urgence");
jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
jLabel2.setText("N° d'assurance");
jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

save.setBackground(new java.awt.Color(0, 115, 194));
save.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
save.setForeground(new java.awt.Color(255, 255, 255));
save.setText("Enregistrer");
save.setBorder(null);
save.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveActionPerformed(evt);
    }
    });
    jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 810, 340, 70));
    save.setFocusPainted(false);
    save.setBorderPainted(false);
    save.setContentAreaFilled(false);
    save.setOpaque(true);
    save.setBackground(new Color(0, 115, 194)); // Set default background to white

    save.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            save.setBackground(new Color(23,142,224)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            save.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
        }
    });

    afficher.setBackground(new java.awt.Color(0, 115, 194));
    afficher.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    afficher.setForeground(new java.awt.Color(255, 255, 255));
    afficher.setText("Afficher");
    afficher.setBorder(null);
    afficher.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            afficherActionPerformed(evt);
        }
    });
    jPanel1.add(afficher, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 810, 340, 70));
    afficher.setFocusPainted(false);
    afficher.setBorderPainted(false);
    afficher.setContentAreaFilled(false);
    afficher.setOpaque(true);
    afficher.setBackground(new Color(0, 115, 194)); // Set default background to white

    afficher.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            afficher.setBackground(new Color(23,142,224)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            afficher.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
        }
    });

    information_assurance.setBackground(new java.awt.Color(213, 234, 255));
    information_assurance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    information_assurance.setBorder(null);
    jPanel1.add(information_assurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 340, 40));
    information_assurance.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

nom_medecin.setBackground(new java.awt.Color(213, 234, 255));
nom_medecin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
nom_medecin.setBorder(null);
jPanel1.add(nom_medecin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 340, 40));
nom_medecin.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
    BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    telephone_medecin.setBackground(new java.awt.Color(213, 234, 255));
    telephone_medecin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    telephone_medecin.setBorder(null);
    jPanel1.add(telephone_medecin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 340, 40));
    telephone_medecin.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

adresse_clinique.setBackground(new java.awt.Color(213, 234, 255));
adresse_clinique.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
adresse_clinique.setBorder(null);
jPanel1.add(adresse_clinique, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 710, 340, 40));
adresse_clinique.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
    BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel3.setText("Informations d'assurance");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel4.setText("Nom du médecin");
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel5.setText("Téléphone");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, -1, -1));

    jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel6.setText("Adresse de la clinique médicale");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 680, -1, -1));

    jScrollPane1.setBackground(new java.awt.Color(213, 234, 255));
    jScrollPane1.setBorder(null);
    jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

    jTable2.setAutoCreateRowSorter(true);
    jTable2.setBackground(new java.awt.Color(213, 234, 255));
    jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    jTable2.setFillsViewportHeight(true);
    jTable2.setFocusCycleRoot(true);
    jTable2.setFocusTraversalPolicyProvider(true);
    jTable2.setGridColor(new java.awt.Color(213, 234, 255));
    jTable2.setSelectionBackground(new java.awt.Color(0, 115, 194));
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jTable2MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jTable2MouseReleased(evt);
        }
    });
    jScrollPane1.setViewportView(jTable2);
    jTable2.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font for body
    jTable2.setBackground(new Color(213, 234, 255)); // Background color for body
    jTable2.setRowHeight(25);
    jTable2.setSelectionBackground(new Color(0, 115, 194)); // Selection background color
    jTable2.setSelectionForeground(Color.BLACK); // Selection text color

    // Header styling
    JTableHeader header = jTable2.getTableHeader();
    header.setBackground(new Color(0, 115, 194)); // Background color for header
    header.setForeground(Color.BLACK); // Text color for header
    header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Font for header

    // Centering header text
    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

    // Custom cell rendering for body
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    centerRenderer.setBackground(new Color(213, 234, 255));
    jTable2.setDefaultRenderer(Object.class, centerRenderer);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 910, 440));

    obligatoire5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire5.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire5.setText("*");
    jPanel1.add(obligatoire5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 10, -1));

    obligatoire.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire.setText("*");
    jPanel1.add(obligatoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 10, -1));

    obligatoire1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire1.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire1.setText("*");
    jPanel1.add(obligatoire1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 10, -1));

    obligatoire2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire2.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire2.setText("*");
    jPanel1.add(obligatoire2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 10, -1));

    obligatoire3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire3.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire3.setText("*");
    jPanel1.add(obligatoire3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 10, -1));

    obligatoire4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire4.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire4.setText("*");
    jPanel1.add(obligatoire4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 590, 10, -1));

    jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel8.setText("Le Dossier Medical de Patient");
    jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 740, 42));

    jLabel15.setBackground(new java.awt.Color(255, 255, 255));
    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-user-folder-55.png"))); // NOI18N
    jLabel15.setText("Gestion des dossiers patients");
    jLabel15.setIconTextGap(20);
    jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 680, 60));

    jPanel3.setBackground(new java.awt.Color(213, 234, 255));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    rech.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    rech.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    rech.setBorder(null);
    jPanel3.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 300, 40));
    rech.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

find.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-search-client-25.png"))); // NOI18N
find.setText("RECHERCHER");
find.setBorder(null);
find.setIconTextGap(10);
find.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        findActionPerformed(evt);
    }
    });
    jPanel3.add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 180, 40));
    find.setFocusPainted(false);
    find.setBorderPainted(false);
    find.setContentAreaFilled(false);
    find.setOpaque(true);
    find.setBackground(new Color(255, 255, 255)); // Set default background to white

    find.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            find.setBackground(new Color(240,240,240)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            find.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
        }
    });

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 710, 910, 60));

    jScrollPane2.setBackground(new java.awt.Color(213, 234, 255));
    jScrollPane2.setBorder(null);
    jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

    jTable3.setAutoCreateRowSorter(true);
    jTable3.setBackground(new java.awt.Color(213, 234, 255));
    jTable3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jTable3.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    jTable3.setFillsViewportHeight(true);
    jTable3.setFocusCycleRoot(true);
    jTable3.setFocusTraversalPolicyProvider(true);
    jTable3.setGridColor(new java.awt.Color(213, 234, 255));
    jTable3.setSelectionBackground(new java.awt.Color(0, 115, 194));
    jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jTable3MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jTable3MouseReleased(evt);
        }
    });
    jScrollPane2.setViewportView(jTable3);
    jTable3.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font for body
    jTable3.setBackground(new Color(213, 234, 255)); // Background color for body
    jTable3.setRowHeight(25);
    jTable3.setSelectionBackground(new Color(0, 115, 194)); // Selection background color
    jTable3.setSelectionForeground(Color.BLACK); // Selection text color

    // Header styling
    header.setBackground(new Color(0, 115, 194)); // Background color for header
    header.setForeground(Color.BLACK); // Text color for header
    header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Font for header

    // Centering header text
    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

    // Custom cell rendering for body

    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    centerRenderer.setBackground(new Color(213, 234, 255));
    jTable3.setDefaultRenderer(Object.class, centerRenderer);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 1400, 440));

    jPanel5.setBackground(new java.awt.Color(213, 234, 255));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    rech1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    rech1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    rech1.setBorder(null);
    jPanel5.add(rech1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 380, 40));
    rech1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

find1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
find1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-search-client-25.png"))); // NOI18N
find1.setText("RECHERCHER");
find1.setBorder(null);
find1.setIconTextGap(10);
find1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        find1ActionPerformed(evt);
    }
    });
    jPanel5.add(find1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 180, 40));
    find1.setFocusPainted(false);
    find1.setBorderPainted(false);
    find1.setContentAreaFilled(false);
    find1.setOpaque(true);
    find1.setBackground(new Color(255, 255, 255)); // Set default background to white

    find1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            find1.setBackground(new Color(240,240,240)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            find1.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
        }
    });

    jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, 1400, 60));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 1600, 1000));

    jPanel6.setBackground(new java.awt.Color(0, 98, 166));
    jPanel6.setPreferredSize(new java.awt.Dimension(320, 1000));
    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    analyse.setBackground(new java.awt.Color(0, 105, 170));
    analyse.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    analyse.setForeground(new java.awt.Color(255, 255, 255));
    analyse.setText("Gestion d'analyse");
    analyse.setToolTipText("");
    analyse.setBorder(null);
    analyse.setBorderPainted(false);
    analyse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    analyse.setDoubleBuffered(true);
    analyse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    analyse.setIconTextGap(50);
    analyse.setName(""); // NOI18N
    analyse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    analyse.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            analyseActionPerformed(evt);
        }
    });
    jPanel6.add(analyse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 320, 70));
    analyse.setFocusPainted(false);
    analyse.setBorderPainted(false);
    analyse.setContentAreaFilled(false);
    analyse.setOpaque(true);

    analyse.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            analyse.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            analyse.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
        }
    });

    stock.setBackground(new java.awt.Color(0, 105, 170));
    stock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    stock.setForeground(new java.awt.Color(255, 255, 255));
    stock.setText("Verifier l'état de Stock");
    stock.setBorder(null);
    stock.setBorderPainted(false);
    stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    stock.setDoubleBuffered(true);
    stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    stock.setIconTextGap(50);
    stock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    stock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            stockActionPerformed(evt);
        }
    });
    jPanel6.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 320, 70));
    stock.setFocusPainted(false);
    stock.setBorderPainted(false);
    stock.setContentAreaFilled(false);
    stock.setOpaque(true);

    stock.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            stock.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            stock.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
        }
    });

    jButton7.setBackground(new java.awt.Color(0, 120, 200));
    jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Consulter Dossier Patient");
    jButton7.setBorder(null);
    jButton7.setBorderPainted(false);
    jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton7.setDoubleBuffered(true);
    jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton7.setIconTextGap(50);
    jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 320, 70));
    jButton7.setFocusPainted(false);
    jButton7.setBorderPainted(false);
    jButton7.setContentAreaFilled(false);
    jButton7.setOpaque(true);

    jButton7.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            jButton7.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jButton7.setBackground(new Color(0,120,200)); // Original color when mouse not hovering
        }
    });

    home1.setBackground(new java.awt.Color(0, 105, 170));
    home1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    home1.setForeground(new java.awt.Color(255, 255, 255));
    home1.setText("Accueil");
    home1.setToolTipText("");
    home1.setBorder(null);
    home1.setBorderPainted(false);
    home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    home1.setDoubleBuffered(true);
    home1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    home1.setIconTextGap(50);
    home1.setName(""); // NOI18N
    home1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    home1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            home1ActionPerformed(evt);
        }
    });
    jPanel6.add(home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 320, 70));
    home1.setFocusPainted(false);
    home1.setBorderPainted(false);
    home1.setContentAreaFilled(false);
    home1.setOpaque(true);

    home1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            home1.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home1.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
        }
    });

    jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("Médecin");
    jLabel9.setMaximumSize(new java.awt.Dimension(100, 16));
    jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 320, -1));

    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-user-100.png"))); // NOI18N
    jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, 150, 150));

    logout1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    logout1.setForeground(new java.awt.Color(0, 115, 194));
    logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-log-out-30.png"))); // NOI18N
    logout1.setText("Déconnexion");
    logout1.setBorder(null);
    logout1.setBorderPainted(false);
    logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    logout1.setDoubleBuffered(true);
    logout1.setIconTextGap(5);
    logout1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            logout1ActionPerformed(evt);
        }
    });
    jPanel6.add(logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 901, 220, 60));
    logout1.setFocusPainted(false);
    logout1.setBorderPainted(false);
    logout1.setContentAreaFilled(false);
    logout1.setOpaque(true);
    logout1.setBackground(new Color(255, 255, 255)); // Set default background to white

    logout1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            logout1.setBackground(new Color(240,240,240)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            logout1.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
        }
    });

    getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 1000));

    setSize(new java.awt.Dimension(1920, 1040));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
                                      
    int selectedRow = jTable2.getSelectedRow();
if (selectedRow >= 0) {
    int id_patient = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());
    String nom_patient = jTable2.getValueAt(selectedRow, 1).toString();
    String prenom_patient = jTable2.getValueAt(selectedRow, 2).toString();
    String date_naissance_patient = jTable2.getValueAt(selectedRow, 3).toString();
    String sexe = jTable2.getValueAt(selectedRow, 4).toString();
    String email_patient = jTable2.getValueAt(selectedRow, 5).toString();
    String num_telephone_patient = jTable2.getValueAt(selectedRow, 6).toString();
      
    // Additional info
    String num_telephone_urgence = numero_urgence.getText();
    String info_assurance = numero_assurance.getText();
    String num_assurance = information_assurance.getText();
    String medecin = nom_medecin.getText();
    String tel_medecin = telephone_medecin.getText();
    String clinique_adresse = adresse_clinique.getText();

    String filename = "UserInfo.pdf";
    
      if (num_telephone_urgence.trim().isEmpty()) {
        
        obligatoire.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire.setVisible(false);
        
    }
    if (info_assurance.trim().isEmpty()) {
        
        obligatoire1.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire1.setVisible(false);
        
    }
    if (num_assurance.trim().isEmpty()) {
        
        obligatoire2.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire2.setVisible(false);
        
    }
     if (medecin.trim().isEmpty()) {
        
        obligatoire3.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire3.setVisible(false);
        
    }
   
    if (tel_medecin.trim().isEmpty()) {
        
        obligatoire4.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire4.setVisible(false);
        
    }
    if (clinique_adresse.trim().isEmpty()) {
        
        obligatoire5.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire5.setVisible(false);
        
    }

    try {
        
         if(!num_telephone_urgence.trim().isEmpty() && !info_assurance.trim().isEmpty() && !num_assurance.trim().isEmpty() && !medecin.trim().isEmpty()  && !tel_medecin.trim().isEmpty() && !clinique_adresse.trim().isEmpty()   ){
          //createPdf(filename,  id_patient,  nom_patient,  prenom_patient,  date_naissance_patient,  sexe,  email_patient,  num_telephone_patient,  num_telephone_urgence,  info_assurance,  num_assurance,  medecin,  tel_medecin,  clinique_adresse);
         Client.storePatientPdf(id_patient, nom_patient, prenom_patient, date_naissance_patient, sexe, email_patient, num_telephone_patient, num_telephone_urgence, info_assurance, num_assurance, medecin, tel_medecin, clinique_adresse);
          JOptionPane.showMessageDialog(null, "Dossier a été sauvegardé avec succès.", "Dossier Sauvegardé", JOptionPane.INFORMATION_MESSAGE);
          jTable2.clearSelection();
          clearInputFields();
         }
       
    } catch (Exception ex) {
        Logger.getLogger(Dossier.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error processing PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un patient dans le tableau.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
}
    
   

    }//GEN-LAST:event_saveActionPerformed

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherActionPerformed
  int selectedRow = jTable2.getSelectedRow();
int selectedRow1 = jTable3.getSelectedRow();
int patientId; // Declare 'patientId' here to avoid redefinition in the same scope

if (selectedRow >= 0) {
    // Convert view index to model index if a sorter is used
    int modelRow = jTable2.convertRowIndexToModel(selectedRow);
    patientId = Integer.parseInt(jTable2.getValueAt(modelRow, 0).toString());

    // Run the download in a separate thread to avoid blocking the UI
    new Thread(() -> {
        Client.requestPdfDownload(patientId);
    }).start();

    // Optionally clear the selection in the table
    jTable2.clearSelection();
} else if (selectedRow1 >= 0) {
    // Convert view index to model index if a sorter is used
    int modelRow1 = jTable3.convertRowIndexToModel(selectedRow1);
    patientId = Integer.parseInt(jTable3.getValueAt(modelRow1, 0).toString());

    // Run the download in a separate thread to avoid blocking the UI
    new Thread(() -> {
        Client.requestPdfDownload(patientId);
    }).start();

    // Optionally clear the selection in the table
    jTable3.clearSelection();
}


    }//GEN-LAST:event_afficherActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MousePressed

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

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed

        // Get the full search term and split it to obtain first name and last name
        String searchTerm = rech.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both first name and last name.", "No Search Term", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] names = searchTerm.split("\\s+" ,2);  // Splits the string into parts by whitespace
        if (names.length < 2) {
            JOptionPane.showMessageDialog(this, "Please enter both first name and last name separated by space.", "Incomplete Data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        

        // Assuming the first part is the first name and the second part is the last name
        String firstName = names[0];
        String lastName = names[1];

        // Perform the search and update the table
        performSearchAndUpdateTable(firstName, lastName);
        clearInputFields();
    }//GEN-LAST:event_findActionPerformed

    private void find1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find1ActionPerformed
            // Get the full search term and split it to obtain first name and last name
        String searchTerm = rech1.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both first name and last name.", "No Search Term", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] names = searchTerm.split("\\s+" ,2);  // Splits the string into parts by whitespace
        if (names.length < 2) {
            JOptionPane.showMessageDialog(this, "Please enter both first name and last name separated by space.", "Incomplete Data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        

        // Assuming the first part is the first name and the second part is the last name
        String firstName = names[0];
        String lastName = names[1];

        // Perform the search and update the table
        performSearchAndUpdateTable(firstName, lastName);
        clearInputFields();
    }//GEN-LAST:event_find1ActionPerformed

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MousePressed

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseReleased

    private void analyseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseActionPerformed
        smoothTransition("client.Gérer_Analyse_Medicale", 1000);
    }//GEN-LAST:event_analyseActionPerformed

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        smoothTransition("client.Produit", 1000, "medecin");
    }//GEN-LAST:event_stockActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        smoothTransition("client.Dossier", 1000, "medecin");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1ActionPerformed

        java.awt.EventQueue.invokeLater(() -> {
            //new Gerant().setVisible(true);
            //setVisible(false);
            smoothTransition("client.Medecin", 1000);
        });
    }//GEN-LAST:event_home1ActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logout1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
       model.setRowCount(0);
        loadPatientData();
    }//GEN-LAST:event_jPanel1MouseClicked


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
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Dossier.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
}    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dossier().setVisible(true);
            }
        });
    }
    
   
    
    

    
    
    






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse_clinique;
    private javax.swing.JButton afficher;
    private javax.swing.JButton analyse;
    private javax.swing.JButton colse;
    private javax.swing.JButton find;
    private javax.swing.JButton find1;
    private javax.swing.JButton gererbilan;
    private javax.swing.JButton gerercaisse;
    private javax.swing.JButton gererdossier;
    private javax.swing.JButton gererpatients;
    private javax.swing.JButton gererrndv;
    private javax.swing.JButton home;
    private javax.swing.JButton home1;
    private javax.swing.JTextField information_assurance;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JButton minimize;
    private javax.swing.JTextField nom_medecin;
    private javax.swing.JTextField numero_assurance;
    private javax.swing.JTextField numero_urgence;
    private javax.swing.JLabel obligatoire;
    private javax.swing.JLabel obligatoire1;
    private javax.swing.JLabel obligatoire2;
    private javax.swing.JLabel obligatoire3;
    private javax.swing.JLabel obligatoire4;
    private javax.swing.JLabel obligatoire5;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField rech1;
    private javax.swing.JButton save;
    private javax.swing.JButton stock;
    private javax.swing.JTextField telephone_medecin;
    // End of variables declaration//GEN-END:variables
}
