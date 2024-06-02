/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author loukmane04
 */
public class Ajouter_Compte extends javax.swing.JFrame {
    DefaultTableModel model;
    
    /**
     * Creates new form Ajouter_Comte
     */
    public Ajouter_Compte() {
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        initComponents();
        obligatoire.setVisible(false);
        obligatoire1.setVisible(false);
        obligatoire2.setVisible(false);
        obligatoire3.setVisible(false);
        obligatoire4.setVisible(false);
        obligatoire5.setVisible(false);
        obligatoire6.setVisible(false);
        obligatoire7.setVisible(false);
        
        initTable();
        loadUserData();
        attachMouseListener();
        hidemodifydeletebutton();
    }
    
    
    private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Date de naissance");
        model.addColumn("Sexe");
        model.addColumn("Email");
        model.addColumn("Numéro de téléphone");
        model.addColumn("Mot de passe");
        jTable2.setModel(model);
    }
    
     private void attachMouseListener() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameMousePressed(evt);
            }
        });
    }

    private void frameMousePressed(java.awt.event.MouseEvent evt) {
        // Check if the source of the event is not jTable2 and not jButton1
        if (evt.getSource() != jTable2 && evt.getSource() != ajouter) {
            ajouter.setVisible(true);
            hidemodifydeletebutton();
        }
    }
    private void hidemodifydeletebutton(){
        modifier.setVisible(false);
        supprimer.setVisible(false);
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        mp = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        dn = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        nt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        sexe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        obligatoire7 = new javax.swing.JLabel();
        obligatoire = new javax.swing.JLabel();
        obligatoire1 = new javax.swing.JLabel();
        obligatoire2 = new javax.swing.JLabel();
        obligatoire3 = new javax.swing.JLabel();
        obligatoire4 = new javax.swing.JLabel();
        obligatoire5 = new javax.swing.JLabel();
        obligatoire6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        minimize = new javax.swing.JButton();
        colse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuickLab");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nom");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Prénom");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Date de naissance");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Sexe");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, 16));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Numéro de téléphone");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 710, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Mot de Passe");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, -1));

        ajouter.setBackground(new java.awt.Color(0, 115, 194));
        ajouter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setText("Ajouter");
        ajouter.setBorder(null);
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 820, 340, 70));
        ajouter.setFocusPainted(false);
        ajouter.setBorderPainted(false);
        ajouter.setContentAreaFilled(false);
        ajouter.setOpaque(true);
        ajouter.setBackground(new Color(0, 115, 194)); // Set default background to white

        ajouter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ajouter.setBackground(new Color(23,142,224)); // Change to light gray on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ajouter.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
            }
        });

        mp.setBackground(new java.awt.Color(213, 234, 255));
        mp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mp.setBorder(null);
        jPanel1.add(mp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 340, 40));
        mp.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    nom.setBackground(new java.awt.Color(213, 234, 255));
    nom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    nom.setBorder(null);
    jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 340, 40));
    nom.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

prenom.setBackground(new java.awt.Color(213, 234, 255));
prenom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
prenom.setBorder(null);
jPanel1.add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 340, 40));
prenom.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
    BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    dn.setBackground(new java.awt.Color(213, 234, 255));
    dn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    dn.setBorder(null);
    jPanel1.add(dn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 340, 40));
    dn.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

email.setBackground(new java.awt.Color(213, 234, 255));
email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
email.setBorder(null);
email.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        emailActionPerformed(evt);
    }
    });
    jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, 340, 40));
    email.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

nt.setBackground(new java.awt.Color(213, 234, 255));
nt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
nt.setBorder(null);
nt.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        ntActionPerformed(evt);
    }
    });
    jPanel1.add(nt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 740, 340, 40));
    nt.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
jLabel8.setText("Rôle");
jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

role.setBackground(new java.awt.Color(213, 234, 255));
role.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Role", "medecin", "biologiste", "receptionniste" }));
role.setBorder(null);
role.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
role.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        roleActionPerformed(evt);
    }
    });
    jPanel1.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 150, 40));

    sexe.setBackground(new java.awt.Color(213, 234, 255));
    sexe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexe", "M", "F" }));
    sexe.setBorder(null);
    sexe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jPanel1.add(sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 150, 40));

    jTable2.setAutoCreateRowSorter(true);
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
    jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jTable2.setFillsViewportHeight(true);
    jTable2.setFocusCycleRoot(true);
    jTable2.setFocusTraversalPolicy(null);
    jTable2.setFocusTraversalPolicyProvider(true);
    jTable2.setGridColor(new java.awt.Color(213, 234, 255));
    jTable2.setSelectionBackground(new java.awt.Color(0, 115, 194));
    jTable2.setShowGrid(true);
    jTable2.setSurrendersFocusOnKeystroke(true);
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
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

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 870, 530));

    modifier.setBackground(new java.awt.Color(0, 115, 194));
    modifier.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    modifier.setForeground(new java.awt.Color(255, 255, 255));
    modifier.setText("Modifier");
    modifier.setBorder(null);
    modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            modifierActionPerformed(evt);
        }
    });
    jPanel1.add(modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 820, 340, 70));
    modifier.setFocusPainted(false);
    modifier.setBorderPainted(false);
    modifier.setContentAreaFilled(false);
    modifier.setOpaque(true);
    modifier.setBackground(new Color(0, 115, 194)); // Set default background to white

    modifier.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            modifier.setBackground(new Color(23,142,224)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            modifier.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
        }
    });

    supprimer.setBackground(new java.awt.Color(0, 115, 194));
    supprimer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    supprimer.setForeground(new java.awt.Color(255, 255, 255));
    supprimer.setText("Supprimer");
    supprimer.setBorder(null);
    supprimer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            supprimerActionPerformed(evt);
        }
    });
    jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 800, 340, 70));
    supprimer.setFocusPainted(false);
    supprimer.setBorderPainted(false);
    supprimer.setContentAreaFilled(false);
    supprimer.setOpaque(true);
    supprimer.setBackground(new Color(0, 115, 194)); // Set default background to white

    supprimer.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            supprimer.setBackground(new Color(23,142,224)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            supprimer.setBackground(new Color(0, 115, 194)); // Revert to white when not hovered
        }
    });

    jLabel14.setBackground(new java.awt.Color(255, 255, 255));
    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-add-user-55.png"))); // NOI18N
    jLabel14.setText("Gérer Les Comptes Des Employés");
    jLabel14.setIconTextGap(20);
    jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 680, 60));

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
    jLabel15.setText("Les Informations Du Compte");
    jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

    obligatoire7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire7.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire7.setText("*");
    jPanel1.add(obligatoire7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 10, -1));

    obligatoire.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire.setText("*");
    jPanel1.add(obligatoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 10, -1));

    obligatoire1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire1.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire1.setText("*");
    jPanel1.add(obligatoire1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 10, -1));

    obligatoire2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire2.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire2.setText("*");
    jPanel1.add(obligatoire2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 10, -1));

    obligatoire3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire3.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire3.setText("*");
    jPanel1.add(obligatoire3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 10, -1));

    obligatoire4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire4.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire4.setText("*");
    jPanel1.add(obligatoire4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 10, -1));

    obligatoire5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire5.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire5.setText("*");
    jPanel1.add(obligatoire5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 710, 10, -1));

    obligatoire6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    obligatoire6.setForeground(new java.awt.Color(204, 0, 0));
    obligatoire6.setText("*");
    jPanel1.add(obligatoire6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 10, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

    jPanel4.setBackground(new java.awt.Color(0, 98, 166));
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jButton4.setForeground(new java.awt.Color(0, 115, 194));
    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-log-out-30.png"))); // NOI18N
    jButton4.setText("Déconnexion");
    jButton4.setBorder(null);
    jButton4.setBorderPainted(false);
    jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton4.setDoubleBuffered(true);
    jButton4.setIconTextGap(5);
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 901, 220, 60));
    jButton4.setFocusPainted(false);
    jButton4.setBorderPainted(false);
    jButton4.setContentAreaFilled(false);
    jButton4.setOpaque(true);
    jButton4.setBackground(new Color(255, 255, 255)); // Set default background to white

    jButton4.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            jButton4.setBackground(new Color(240,240,240)); // Change to light gray on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jButton4.setBackground(new Color(255, 255, 255)); // Revert to white when not hovered
        }
    });

    jButton5.setBackground(new java.awt.Color(0, 120, 200));
    jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jButton5.setForeground(new java.awt.Color(255, 255, 255));
    jButton5.setText("Gérer Les Employés");
    jButton5.setToolTipText("");
    jButton5.setBorder(null);
    jButton5.setBorderPainted(false);
    jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton5.setDoubleBuffered(true);
    jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton5.setIconTextGap(50);
    jButton5.setName(""); // NOI18N
    jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 320, 70));
    jButton5.setFocusPainted(false);
    jButton5.setBorderPainted(false);
    jButton5.setContentAreaFilled(false);
    jButton5.setOpaque(true);

    jButton5.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            jButton5.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jButton5.setBackground(new Color(0, 120, 200)); // Original color when mouse not hovering
        }
    });

    jButton6.setBackground(new java.awt.Color(0, 105, 170));
    jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jButton6.setForeground(new java.awt.Color(255, 255, 255));
    jButton6.setText("Gérer le Stock");
    jButton6.setBorder(null);
    jButton6.setBorderPainted(false);
    jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton6.setDoubleBuffered(true);
    jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton6.setIconTextGap(50);
    jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 320, 70));
    jButton6.setFocusPainted(false);
    jButton6.setBorderPainted(false);
    jButton6.setContentAreaFilled(false);
    jButton6.setOpaque(true);

    jButton6.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            jButton6.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jButton6.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
        }
    });

    jButton7.setBackground(new java.awt.Color(0, 105, 170));
    jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Consulter Les Revunus");
    jButton7.setBorder(null);
    jButton7.setBorderPainted(false);
    jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton7.setDoubleBuffered(true);
    jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton7.setIconTextGap(50);
    jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 320, 70));
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
            jButton7.setBackground(new Color(0, 105, 170)); // Original color when mouse not hovering
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
    jPanel4.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 320, 70));
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
    jLabel12.setText("Gérant");
    jLabel12.setMaximumSize(new java.awt.Dimension(100, 16));
    jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 320, -1));

    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-user-100.png"))); // NOI18N
    jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, 150, 150));

    getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 1000));

    jPanel2.setBackground(new java.awt.Color(0, 0, 0));
    jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(255, 255, 255));
    jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel16.setText("QuickLab");
    jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 40));

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

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 40));

    setSize(new java.awt.Dimension(1920, 1040));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
                                                
       String nomValue = nom.getText();
        String prenomValue = prenom.getText();
        String dnValue = dn.getText();
        String sexeValue = sexe.getSelectedItem().toString();
        String emailValue = email.getText();
        String ntValue = nt.getText();
        String mpValue = mp.getText();
        String roleValue = role.getSelectedItem().toString();
        
    if (nomValue.trim().isEmpty()) {
        
        obligatoire.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire.setVisible(false);
        
    }
    if (prenomValue.trim().isEmpty()) {
        
        obligatoire1.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire1.setVisible(false);
        
    }
    if (dnValue.trim().isEmpty()) {
        
        obligatoire2.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire2.setVisible(false);
        
    }
    if (sexe.getSelectedIndex() == 0) {
        
        obligatoire3.setVisible(true);
        // Stop further execution if nom is empty
    }
    if (emailValue.trim().isEmpty()) {
        
        obligatoire4.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire4.setVisible(false);
        
    }
    if (ntValue.trim().isEmpty()) {
        
        obligatoire5.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire5.setVisible(false);
        
    }
    if (mpValue.trim().isEmpty()) {
        
        obligatoire6.setVisible(true);
         // Stop further execution if nom is empty
    }else{
         obligatoire6.setVisible(false);
        
    }
    if (role.getSelectedIndex() == 0) {
        
        obligatoire7.setVisible(true);
         // Stop further execution if nom is empty
    }
    
    //////////////////////////////////////////////not empty///////////////////////////////////////////////////////////////////
   
    if (sexe.getSelectedIndex()>0 ) {
        
        obligatoire3.setVisible(false);
        // Stop further execution if nom is empty
    }
 
    if (role.getSelectedIndex() >0 ) {
        
        obligatoire7.setVisible(false);
         // Stop further execution if nom is empty
    }
    
    /////////////////////////////////////////////role test /////////////////////////////////////////////////////////////////////
    
       if(roleValue.equals("medecin") && !nomValue.trim().isEmpty() && !prenomValue.trim().isEmpty() && !dnValue.trim().isEmpty() && sexe.getSelectedIndex() >0  && !emailValue.trim().isEmpty() && !ntValue.trim().isEmpty() &&!mpValue.trim().isEmpty()   ) {
           JOptionPane.showMessageDialog(null, "Médecin ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            
        }
         
         if(roleValue.equals("biologiste") ) {
           
            JOptionPane.showMessageDialog(null, "biologiste ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }
         
         if(roleValue.equals("receptionniste") ) {
           
            JOptionPane.showMessageDialog(null, "receptionniste ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }
        
  
      ///////////////////////////////////////////// /////////////////////////////////////////////////////////////////////
         if(!nomValue.trim().isEmpty() && !prenomValue.trim().isEmpty() && !dnValue.trim().isEmpty() && sexe.getSelectedIndex() >0  && !emailValue.trim().isEmpty() && !ntValue.trim().isEmpty() &&!mpValue.trim().isEmpty() && role.getSelectedIndex() >0   ){
            
        Client.sendUserInfo(nomValue, prenomValue, dnValue, sexeValue, emailValue, ntValue, mpValue, roleValue);
        
         // Update the user in the table model by adding a new row
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
         model.addRow(new Object[]{nomValue, prenomValue, dnValue, sexeValue, emailValue, ntValue, mpValue});
         
         
          // Clear the input fields after adding the user to the table
           clearInputFields();
        
        
         }

    }//GEN-LAST:event_ajouterActionPerformed
  
    private void clearInputFields() {
    nom.setText("");
    prenom.setText("");
    dn.setText("");
    sexe.setSelectedIndex(0); // Assuming the first item is the default
    email.setText("");
    nt.setText("");
    mp.setText("");
    role.setSelectedIndex(0); // Assuming the first item is the default
}
    
    private void loadUserData() {
    String userData = Client.fetchUserData(); // Fetch user data from the server
    if (userData != null && !userData.equals("No user found")) {
        // Assuming each user's data is separated by a newline character
        String[] userEntries = userData.split(";");
        for (String entry : userEntries) {
            String[] dataParts = entry.split(":");
            if (dataParts.length >= 7) {
                model.addRow(dataParts); // Update the table model directly
            } else {
                System.out.println("Received user data in an unexpected format");
            }
        }
    } else {
        System.out.println("No data received or user not found");
    }
}

    
    private void ntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        //@ by Yahya Mati
        int i = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        nom.setText(model.getValueAt(i, 0).toString());
        prenom.setText(model.getValueAt(i, 1).toString());
        dn.setText(model.getValueAt(i, 2).toString());
        nt.setText(model.getValueAt(i, 5).toString());
        email.setText(model.getValueAt(i, 4).toString());
        sexe.setSelectedItem(model.getValueAt(i, 3));
        mp.setText(model.getValueAt(i, 6).toString());
        
        // Hide the OK button when a row is selected
        ajouter.setVisible(false);
        modifier.setVisible(true);
        supprimer.setVisible(true);
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
            int selectedRow = jTable2.getSelectedRow();
    if (selectedRow >= 0) {
        String nomValue = nom.getText();
        String prenomValue = prenom.getText();
        String dnValue = dn.getText();
        String sexeValue = sexe.getSelectedItem().toString();
        String emailValue = email.getText(); // Email is the unique identifier
        String ntValue = nt.getText();
        String mpValue = mp.getText();
        String roleValue =  role.getSelectedItem().toString();
        
        
         if(!nomValue.trim().isEmpty() && !prenomValue.trim().isEmpty() && !dnValue.trim().isEmpty() && sexe.getSelectedIndex() >0  && !emailValue.trim().isEmpty() && !ntValue.trim().isEmpty() &&!mpValue.trim().isEmpty()   ){
            
       
        Client.updateUser(nomValue, prenomValue, dnValue, sexeValue, emailValue, ntValue, mpValue,roleValue);
        
         JOptionPane.showMessageDialog(null, "Utilisateur Modifier avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
       
         // Update the user in the table model
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setValueAt(nomValue, selectedRow, 0);
        model.setValueAt(prenomValue, selectedRow, 1);
        model.setValueAt(dnValue, selectedRow, 2);
        model.setValueAt(sexeValue, selectedRow, 3);
        model.setValueAt(emailValue, selectedRow, 4);
        model.setValueAt(ntValue, selectedRow, 5);
        model.setValueAt(mpValue, selectedRow, 6);
        
         
         
          // Clear the input fields after adding the user to the table
          
           jTable2.clearSelection();
           clearInputFields();
        
        
         }

        
    } else {
        JOptionPane.showMessageDialog(this, "No user selected", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
         int selectedRow = jTable2.getSelectedRow();
    if (selectedRow >= 0) {
        String email = model.getValueAt(selectedRow, 4).toString();  // Assuming email is the unique identifier and is in column 4
        Client.deleteUser(email);
        model.removeRow(selectedRow);  // Optionally remove the row from the table view
        clearInputFields();
        throw new RuntimeException("User could not be added");
    } else {
        JOptionPane.showMessageDialog(this, "No user selected", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_supprimerActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        smoothTransition("client.Ajouter_Compte", 1000);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        smoothTransition("client.Produit", 1000);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        java.awt.EventQueue.invokeLater(() -> {
            //new Gerant().setVisible(true);
            //setVisible(false);
            smoothTransition("client.Gerant", 1000);
        });
    }//GEN-LAST:event_homeActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setExtendedState(getExtendedState() | Gérer_Analyse_Medicale.ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void colseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colseActionPerformed

        System.exit(0);
    }//GEN-LAST:event_colseActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(Ajouter_Compte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Compte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Compte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Compte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ajouter_Compte().setVisible(true);
        });
    }
    
  
     
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton colse;
    private javax.swing.JTextField dn;
    private javax.swing.JTextField email;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton minimize;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField mp;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nt;
    private javax.swing.JLabel obligatoire;
    private javax.swing.JLabel obligatoire1;
    private javax.swing.JLabel obligatoire2;
    private javax.swing.JLabel obligatoire3;
    private javax.swing.JLabel obligatoire4;
    private javax.swing.JLabel obligatoire5;
    private javax.swing.JLabel obligatoire6;
    private javax.swing.JLabel obligatoire7;
    private javax.swing.JTextField prenom;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> sexe;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
