/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Biologiste1 extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form Biologiste
     */
    public Biologiste1() {
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        initComponents();
        initAnlyseTable();
        inserer.setVisible(false);
        jScrollPane1.setVisible(false);
    }
    
    
    private void initAnlyseTable() {
    model = new DefaultTableModel();  // Initialize the class attribute, not a local variable
    model.addColumn("Nom ");
    model.addColumn("prix");
    model.addColumn("norme");
    analyse_table.setModel(model);
}
    
    
    
    public void displayAnalysisResultsAsPDF(String patientId, List<String[]> analysisWithResults) {
    try {
        Path path = Paths.get(System.getProperty("user.home"), "Desktop", patientId + "_AnalysisResults.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path.toString()));
        document.open();

        // Clinic logo and name
        String logoPath = "path/to/logo.jpg"; // Ensure the correct path is set
        Image logo = Image.getInstance(logoPath);
        logo.scaleToFit(140, 100);
        logo.setAbsolutePosition(50, 750); // Adjust these values as needed
        document.add(logo);

        Font clinicNameFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(0, 102, 204));
        Paragraph clinicName = new Paragraph("QUICK LAB", clinicNameFont);
        clinicName.setAlignment(Element.ALIGN_CENTER);
        document.add(clinicName);

        // Invoice header
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.BLACK);
        Paragraph header = new Paragraph("ANALYSIS RESULTS INVOICE", headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setSpacingBefore(20);
        document.add(header);

        // Patient ID
        Font patientFont = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
        Paragraph patientInfo = new Paragraph("Patient ID: " + patientId, patientFont);
        patientInfo.setSpacingBefore(10);
        patientInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(patientInfo);

        // Table for analysis details
        PdfPTable table = new PdfPTable(new float[] {4, 2});
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);
        addTableHeader(table, new String[] {"Analysis ID", "Result"});
        fillTableWithData(table, analysisWithResults);
        document.add(table);

        // Contact information and social media icons
        String contactDetails = "Contact: +00 123456789 | email@example.com | Address: Street City, Country";
        Paragraph contactInfo = new Paragraph(contactDetails, new Font(Font.FontFamily.HELVETICA, 10));
        contactInfo.setAlignment(Element.ALIGN_CENTER);
        contactInfo.setSpacingBefore(15);
        document.add(contactInfo);

        PdfPTable socialTable = new PdfPTable(3); // Three social media icons
        socialTable.setWidthPercentage(20);
        socialTable.setSpacingBefore(5);

        String[] iconsPaths = {"path/to/facebook.png", "path/to/twitter.png", "path/to/instagram.png"};
        for (String iconPath : iconsPaths) {
            Image icon = Image.getInstance(iconPath);
            icon.scaleToFit(15, 15);
            PdfPCell iconCell = new PdfPCell(icon, true);
            iconCell.setBorder(PdfPCell.NO_BORDER);
            iconCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            socialTable.addCell(iconCell);
        }
        document.add(socialTable);

        document.close();

        // Open the PDF if desktop support is available
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(path.toString()));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to create PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addTableHeader(PdfPTable table, String[] headers) {
    PdfPCell cell;
    for (String header : headers) {
        cell = new PdfPCell(new Phrase(header, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE)));
        cell.setBackgroundColor(new BaseColor(0, 102, 204));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(8);
        table.addCell(cell);
    }
}

private void fillTableWithData(PdfPTable table, List<String[]> data) {
    PdfPCell cell;
    for (String[] item : data) {
        cell = new PdfPCell(new Phrase(item[0]));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(item[1]));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        table.addCell(cell);
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ajouter = new javax.swing.JToggleButton();
        récupérer = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        codeechnentillion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        analyse_table = new javax.swing.JTable();
        inserer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuickLab");
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Biologiste");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 16));
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 320, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerant icons/icons8-user-100.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, 150, 150));

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

        ajouter.setBackground(new java.awt.Color(0, 115, 194));
        ajouter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setText("Ajouter les résultats");
        ajouter.setBorder(null);
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 340, 70));
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

        récupérer.setBackground(new java.awt.Color(0, 115, 194));
        récupérer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        récupérer.setForeground(new java.awt.Color(255, 255, 255));
        récupérer.setText("Récupérer les analyses ");
        récupérer.setBorder(null);
        récupérer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                récupérerActionPerformed(evt);
            }
        });
        jPanel1.add(récupérer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 340, 70));
        récupérer.setFocusPainted(false);
        récupérer.setBorderPainted(false);
        récupérer.setContentAreaFilled(false);
        récupérer.setOpaque(true);

        récupérer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                récupérer.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
            }

            @Override
            public void mouseExited(MouseEvent e) {
                récupérer.setBackground(new Color(0, 115, 194)); // Original color when mouse not hovering
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Inserer Code d'échnentillion :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, 47));

        codeechnentillion.setBackground(new java.awt.Color(213, 234, 255));
        codeechnentillion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codeechnentillion.setBorder(null);
        codeechnentillion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeechnentillionActionPerformed(evt);
            }
        });
        jPanel1.add(codeechnentillion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 340, 50));
        codeechnentillion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    analyse_table.setBackground(new java.awt.Color(213, 234, 255));
    analyse_table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    analyse_table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3"
        }
    ));
    analyse_table.setFillsViewportHeight(true);
    analyse_table.setFocusCycleRoot(true);
    analyse_table.setFocusTraversalPolicyProvider(true);
    analyse_table.setGridColor(new java.awt.Color(213, 234, 255));
    analyse_table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            analyse_tableMouseReleased(evt);
        }
    });
    jScrollPane1.setViewportView(analyse_table);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 850, 400));

    inserer.setBackground(new java.awt.Color(0, 115, 194));
    inserer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    inserer.setForeground(new java.awt.Color(255, 255, 255));
    inserer.setText("Inserer  les résultats");
    inserer.setBorder(null);
    inserer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            insererActionPerformed(evt);
        }
    });
    jPanel1.add(inserer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 870, 340, 70));
    inserer.setFocusPainted(false);
    inserer.setBorderPainted(false);
    inserer.setContentAreaFilled(false);
    inserer.setOpaque(true);

    inserer.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            inserer.setBackground(new Color(23,142,224)); // Darker blue when mouse hovers
        }

        @Override
        public void mouseExited(MouseEvent e) {
            inserer.setBackground(new Color(0, 115, 194)); // Original color when mouse not hovering
        }
    });

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 1600, 1000));

    setSize(new java.awt.Dimension(1920, 1040));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
          // Check if the "resultat" column already exists
    boolean columnExists = false;
    for (int i = 0; i < model.getColumnCount(); i++) {
        if (model.getColumnName(i).equals("Resultat")) {
            columnExists = true;
            break;
        }
    }

    // Add the "resultat" column if it does not exist
    if (!columnExists) {
        model.addColumn("Resultat");
    } else {
        JOptionPane.showMessageDialog(this, "Column 'Resultat' already exists.");
    }
    inserer.setVisible(true);
    //ajouter.setVisible(false);
    }//GEN-LAST:event_ajouterActionPerformed


    private void récupérerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_récupérerActionPerformed
      jScrollPane1.setVisible(true);
    // Extract the entered code from the text field
    String enteredCode = codeechnentillion.getText().trim();

    // Initialize a list to store the recovered analysis IDs
    List<String> analysisIds = new ArrayList<>();
    // Assuming code structure is consistent with previously generated codes:
    // e.g., A code like: "ABM19920515-20230501-123,456,789"
    // Split by "-" to separate the code and analysis IDs
    if (enteredCode.contains("-")) {
        String[] parts = enteredCode.split("-");
        if (parts.length > 1) {
            String idsPart = parts[1];
            String[] ids = idsPart.split(",");
            for (String id : ids) {
                analysisIds.add(id);
            }
        }
    }

    // Display the recovered analysis IDs
      // Display the recovered analysis IDs
    if (!analysisIds.isEmpty()) {
        loadAnalyseData(String.join(",", analysisIds));
    
    }if (!enteredCode.contains("-")){
        JOptionPane.showMessageDialog(this, "No analysis IDs were found in the entered code.");
    }

        
        
    }//GEN-LAST:event_récupérerActionPerformed
    private void loadAnalyseData(String analysisIds) {
    String analyseData = Client.fetchAnalyseApplicableData(analysisIds); // Fetch user data from the server
    if (analyseData != null && !analyseData.equals("No Analyse found")) {
        System.out.println(analyseData);
        // Assuming each user's data is separated by a semicolon
        String[] analyseEntries = analyseData.split(";");

        for (String entry : analyseEntries) {
            String[] dataParts = entry.split(":");
            if (dataParts.length >= 3) {
                Object[] rowData = new Object[5];
                for (int i = 0; i < 3; i++) {
                    rowData[i] = dataParts[i];
                }
                rowData[4] = Boolean.FALSE; // Initialize the checkbox to unchecked
                model.addRow(rowData); // Update the table model directly
            } else {
                System.out.println("Received analyse data in an unexpected format: " + entry);
            }
        }
    } else {
        System.out.println("No data received or analyse not found");
    }
}

    private void codeechnentillionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeechnentillionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeechnentillionActionPerformed

    private void analyse_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analyse_tableMouseReleased

    }//GEN-LAST:event_analyse_tableMouseReleased

    private void insererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insererActionPerformed
                                               
    // Extract the entered code from the text field
    String enteredCode = codeechnentillion.getText().trim();

    // Initialize a list to store the recovered analysis IDs
    List<String> analysisIds = new ArrayList<>();
    String patientId = "";

    // Use regex to extract the patient ID (initial digits)
    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^(\\d+)").matcher(enteredCode);
    if (matcher.find()) {
        patientId = matcher.group(1);
    }

    // Assuming code structure is consistent with previously generated codes:
    // e.g., A code like: "12ABM19920515-20230501-123,456,789"
    // Split by "-" to separate the code and analysis IDs
    if (enteredCode.contains("-")) {
        String[] parts = enteredCode.split("-");
        if (parts.length > 1) {
            String idsPart = parts[1];
            String[] ids = idsPart.split(",");
            for (String id : ids) {
                analysisIds.add(id);
            }
        }
    }

    // Check if analysis IDs were found in the entered code
    if (!analysisIds.isEmpty()) {
        // Fetch the analysis data for the recovered IDs
        String analyseData = Client.fetchAnalyseApplicableData(String.join(",", analysisIds));
        if (analyseData != null && !analyseData.equals("No Analyse found")) {
            // loadAnalyseData(analyseData);

            // Gather all results from the 4th column of the table
            List<String> results = new ArrayList<>();
            for (int row = 0; row < model.getRowCount(); row++) {
                Object result = model.getValueAt(row, 3);  // 4th column (index 3)
                results.add((String) result);  // Assuming results are strings
            }

            // Combine analysis IDs with their corresponding results
            List<String> analysisWithResults = new ArrayList<>();
            for (int i = 0; i < analysisIds.size(); i++) {
                String id = analysisIds.get(i);
                String result = i < results.size() ? results.get(i) : "No Result";
                analysisWithResults.add(id + ":" + result);
            }

            // Create a combined message including the patient ID
            String message = "PatientID/" + patientId + "/;" + String.join(";", analysisWithResults);
            System.out.println(message);
            // Send the combined data to the client
            Client.sendAnalysisResult(message);
            
            
        } else {
            JOptionPane.showMessageDialog(this, "No analysis data found for the provided IDs.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "No analysis IDs were found in the entered code.");
    }
    }//GEN-LAST:event_insererActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setExtendedState(getExtendedState() | Gérer_Analyse_Medicale.ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void colseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colseActionPerformed

        System.exit(0);
    }//GEN-LAST:event_colseActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(Biologiste1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biologiste1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biologiste1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biologiste1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biologiste1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ajouter;
    private javax.swing.JTable analyse_table;
    private javax.swing.JTextField codeechnentillion;
    private javax.swing.JButton colse;
    private javax.swing.JButton inserer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton minimize;
    private javax.swing.JToggleButton récupérer;
    // End of variables declaration//GEN-END:variables
}
