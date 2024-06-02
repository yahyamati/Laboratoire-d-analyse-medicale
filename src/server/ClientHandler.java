/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import client.Dossier;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author loukmane04
 * ~ YahyaMati
 * ~ OussamaDev
 */
public class ClientHandler extends Thread{
    
    private final Socket client;
    private final PrintWriter out;
    private final BufferedReader input;
    private final Connection conn; // Database connection

    public ClientHandler(Socket clientSocket, Connection conn)  throws IOException{
        this.client = clientSocket;
        this.conn = conn;    
        out = new PrintWriter(client.getOutputStream(),true);
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

    }

@Override
public void run() {
    try {
        String request;
        while ((request = input.readLine()) != null) {
            switch (request.split(" ")[0]) {
                case "LOGIN":
                    handleLogin(request);
                    break;
                case "ADD_USER":
                    handleAjouter(request);
                    break;
                case "DELETE_USER":
                    handleDeleteUser(request);
                    break;
                case "UPDATE_USER":
                    handleUpdateUser(request);
                    break;
                case "GET_USER_DATA":
                     System.out.println("10");
                    handleGetUserData();
                    break;
                case "ADD_PRODUCT":
                     System.out.println("11");
                    handleAjouterProduit(request);
                    break;
                case "GET_PRODUCT_DATA":
                    System.out.println("12");
                    handleGetProductData();
                    break;
                case "ADD_PATIENT":
                    handleAjouterPatient(request);
                    break;
                case "GET_PATIENT_DATA":
                    handleGetPatientData();
                    break;
                case "DELETE_PATIENT":
                    handleDeletePatient(request);
                    break;
                case "UPDATE_PATIENT":
                    handleUpdatePatient(request);
                    break;
                case "SEARCH_PATIENT":
                    handleSearchPatientByName(request);
                    break;
                case "ADD_ANALYSE":
                    handleAjouterAnalyse(request);
                    break;
                case "GET_ANALYSE_DATA":
                     handleGetAnalyseData();
                    break;
                case "DELETE_ANALYSE":
                    handleDeleteAnalyse(request);
                    break;
                case "UPDATE_ANALYSE":
                    handleUpdateAnalyse(request);
                    break;
                case "ADD_BILAN/":
                    System.out.println(1);
                     handleAjouterBilan(request);
                    break;
                case "ADD_ECHANILLION":
                    System.out.println(1);
                     handleAjouterEchantillion(request);
                    break;
                case "GET_ANALYSE_APPLICABLE_DATA":
                    System.out.println(1);
                     handleGetAnalyseapplicableData(request);
                    break;
                case "ID_PATIENT_PDF":
                    handleDownloadPdf(request);
                    break;
                    
                case "STORE_PATIENT_PDF":
                    handleStorePatientPdf(request);
                    break;
                case "ADD_RENDEZ_VOUS":
                    System.out.println(1);
                     handleAjouterRendez_vous(request);
                    break;
                    
                case "LOAD_Rendez_vous_DATA":
                    
                     handleGetRendez_voustData();
                    break;
                    
                case "DELETE_RENDEZ_VOUS":
                     handleDelete_Rendez_vous(request);
                    break;
                    
                case "UPDATE_RENDEZ_VOUS":
                    handleUpdateRendez_vous(request);
                    break;
                    
                case "CALCULATE_DAILY_REVENUE":
                    handleCalculateDailyRevenue(request);
                    break;
                case "SEND_ANALYSIS_RESULTS":
                    handleAjouterAnalyseResults(request);
                    break; 
                 case "GET_PAYMENT_DATA":
                    handleGetPaymentData();
                    break;  
                    
                case "GET_REVENUS_DATA":
                    handleGetRevenusData();
                    break;
                default:
                    out.println("Unknown request");
                    System.out.println(request);
                    break;
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (DocumentException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        closeResources();
    }
}


private void closeResources() {
    try {
        if (input != null) input.close();
        if (out != null) out.close();
        if (client != null) client.close();
    } catch (IOException ex) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void handleLogin(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 3) {
        out.println("Invalid login request");
        return;
    }
    
    String email = parts[1];
    String password = parts[2];

    String sql = "SELECT * FROM utilisateur WHERE Email_utilisateur = ? AND Mot_passe = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, email);
        stmt.setString(2, password);
       
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Get the role of the user
                String role = checkUserRole(email);
                out.println("Login successful: " + role);
                System.out.println("User logged in. Role: " + role);
            } else {
                out.println("Login failed");
            }
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}



private String checkUserRole(String email) {
        String role = "Unknown";

        // SQL queries to check if the user is a gerant, medecin, receptioniste, or biologiste
        String gerantQuery = "SELECT * FROM gerant WHERE Email_gerant = ?";
        String medecinQuery = "SELECT * FROM medecin WHERE Email_medecin = ?";
        String receptionisteQuery = "SELECT * FROM receptionniste WHERE Email_receptionniste = ?";
        String biologisteQuery = "SELECT * FROM biologiste WHERE Email_biologiste = ?";
        // I use email because each person has a his own email.
        try {
            // Check if the user is a gerant
            try (PreparedStatement stmt = conn.prepareStatement(gerantQuery)) {
                stmt.setString(1, email);
                //System.out.println(stmt);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    role = "Gerant";
                    return role;
                }
            }

            // Check if the user is a medecin
            try (PreparedStatement stmt = conn.prepareStatement(medecinQuery)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    role = "Medecin";
                    return role;
                }
            }

            // Check if the user is a receptioniste
            try (PreparedStatement stmt = conn.prepareStatement(receptionisteQuery)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    role = "Receptionniste";
                    return role;
                }
            }

            // Check if the user is a biologiste
            try (PreparedStatement stmt = conn.prepareStatement(biologisteQuery)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    role = "Biologiste";
                    return role;
                }
            }
        } catch (SQLException e) {
            // Handle database errors
        }

        return role;
    }   
     
private void handleAjouterProduit(String request) {
 
        String[] parts = request.split(" ");
        if (parts.length < 4) {
            out.println("Invalid user information");
            return;
        }

        String np = parts[1];
        String categorie = parts[2];
        String dp = parts[3];

        // Insert the user information into the database
        String sql = "INSERT INTO produit (Nom_produit, Quantite_produit,Date_peremption) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, np);
            stmt.setString(2, categorie);
            stmt.setString(3, dp);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("Product information stored successfully");
            } else {
                out.println("Failed to store Product information");
            }
            
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
        
    }

private void handleAjouterPatient(String request) {
 
        String[] parts = request.split(" ");
        if (parts.length < 7) {
            out.println("Invalid user information");
            return;
        }

        String nom = parts[1];
        String prenom = parts[2];
        String date = parts[3];
        String sexe = parts[4];
        String email = parts[5];
        String Num = parts[6];

        // Insert the user information into the database
        String sql = "INSERT INTO patient (Nom_patient , Prenom_patient,Date_naissance_patient ,Sexe ,Email_patient,Num_telephone_patient ) VALUES (?, ?, ?,?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, date);
            stmt.setString(4, sexe);
            stmt.setString(5, email);
            stmt.setString(6, Num);
            
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("Patient information stored successfully");
            } else {
                out.println("Failed to store Patient information");
            }
            
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
        
    }

private void handleAjouter(String request) {
 
        String[] parts = request.split(" ");
        if (parts.length < 9) {
            out.println("Invalid user information");
            return;
        }

        String nom = parts[1];
        String prenom = parts[2];
        String dn = parts[3];
        String sexe = parts[4];
        String email = parts[5];
        String nt = parts[6];
        String mp = parts[7];
        String role = parts[8];

        // Insert the user information into the database
        String sql = "INSERT INTO utilisateur (Nom_utilisateur, Prenom_utilisateur, Date_naissance_utilisateur, Sexe, Email_utilisateur, Num_telephone_utilisateur, Mot_passe) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, dn);
            stmt.setString(4, sexe);
            stmt.setString(5, email);
            stmt.setString(6, nt);
            stmt.setString(7, mp);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("User information stored successfully");
            } else {
                out.println("Failed to store user information");
            }

            if(role.equals("biologiste")) {
    
            }
            if(role.equals("receptionniste")) {
    
            }
            
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
        
        if(role.equals("medecin")) {
            
            handleajoutermedcin(request);
        }
        if(role.equals("biologiste")) {
           
             handleajouterbiologiste(request);
        }
        if(role.equals("receptionniste")) {
            
            handleajouterreceptionniste(request);
        }
    }

private void handleajoutermedcin(String request) {
    String[] parts = request.split(" ");
    
    String nom = parts[1];
    String prenom = parts[2];
    String email = parts[5];
    String sql = "INSERT INTO medecin (Nom_medecin, Prenom_medecin, Email_medecin) VALUES (?, ?, ?)";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("Medecin information stored successfully");
            
        } else {
            out.println("Failed to store medecin information");
        } 
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleajouterbiologiste(String request) {
    String[] parts = request.split(" ");
    
    String nom = parts[1];
    String prenom = parts[2];
    String email = parts[5];
    String sql = "INSERT INTO biologiste (Nom_biologiste, Prenom_biologiste, Email_biologiste) VALUES (?, ?, ?)";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("biologiste information stored successfully");
        } else {
            out.println("Failed to store biologiste information");
        } 
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void  handleajouterreceptionniste(String request) {
    String[] parts = request.split(" ");
    
    String nom = parts[1];
    String prenom = parts[2];
    String email = parts[5];
    String sql = "INSERT INTO receptionniste (Nom_receptionniste, Prenom_receptionniste, Email_receptionniste) VALUES (?, ?, ?)";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("biologiste information stored successfully");
        } else {
            out.println("Failed to store biologiste information");
        } 
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleGetUserData() {
    String sql = "SELECT * FROM utilisateur";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder userData = new StringBuilder();
        while (rs.next()) {
            if (userData.length() > 0) userData.append(";");  // Delimit entries
            userData.append(rs.getString("Nom_utilisateur"))
                    .append(":")
                    .append(rs.getString("Prenom_utilisateur"))
                    .append(":")
                    .append(rs.getString("Date_naissance_utilisateur"))
                    .append(":")
                    .append(rs.getString("Sexe"))
                    .append(":")
                    .append(rs.getString("Email_utilisateur"))
                    .append(":")
                    .append(rs.getString("Num_telephone_utilisateur"))
                    .append(":")
                    .append(rs.getString("Mot_passe"));
            
            
        }

        if (userData.length() > 0) {
            out.println(userData.toString());
        } else {
            out.println("No user found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleDeleteUser(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 2) {
        out.println("Invalid delete request");
        return;
    }

    String email = parts[1];
    String currentRole = getCurrentUserRole(email); // Fetch current role before deletion

    // Start by deleting the user from the utilisateur table
    String sql = "DELETE FROM utilisateur WHERE Email_utilisateur = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("User deleted successfully from utilisateur table");
            // Proceed to remove the user from their role-specific table
            removeFromRoleTable(currentRole, email);
        } else {
            out.println("Failed to delete user");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleUpdateUser(String request) {
    System.out.println("Received update request");
    String[] parts = request.split(" ");
    if (parts.length < 9) {  // Expecting 9 parts including the role
        out.println("Invalid update request");
        return;
    }

    // Extract user data from the request
    String nom = parts[1];
    String prenom = parts[2];
    String dn = parts[3];
    String sexe = parts[4];
    String email = parts[5];  // Email as a unique identifier for WHERE clause
    String nt = parts[6];
    String mp = parts[7];
    String newRole = parts[8];  // New role of the user

    // First, retrieve the current role from the database
    String currentRole = getCurrentUserRole(email);

    // SQL command to update user information in the utilisateur table
    String sql = "UPDATE utilisateur SET Nom_utilisateur=?, Prenom_utilisateur=?, Date_naissance_utilisateur=?, Sexe=?, Num_telephone_utilisateur=?, Mot_passe=? WHERE Email_utilisateur=?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, dn);
        stmt.setString(4, sexe);
        stmt.setString(5, nt);
        stmt.setString(6, mp);
        stmt.setString(7, email);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("User updated successfully");
            // Check if role has changed
            if (!currentRole.equalsIgnoreCase(newRole)) {
                // Remove from old role table
                removeFromRoleTable(currentRole, email);
                // Add to new role table
                addToRoleTable(newRole, nom, prenom, email);
            }
        } else {
            out.println("Failed to update user");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private String getCurrentUserRole(String email) {
    String role = "Unknown";
    String[] roleQueries = {
        "SELECT 'Gerant' as role FROM gerant WHERE Email_gerant = ?",
        "SELECT 'Medecin' as role FROM medecin WHERE Email_medecin = ?",
        "SELECT 'Receptionniste' as role FROM receptionniste WHERE Email_receptionniste = ?",
        "SELECT 'Biologiste' as role FROM biologiste WHERE Email_biologiste = ?"
    };

    for (String query : roleQueries) {
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
                break;
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return role;
}

private void removeFromRoleTable(String role, String email) {
    if ("Unknown".equals(role)) {
        return;  // If the role is unknown, no action needed
    }
    String tableName = role.toLowerCase();  // Assumes table names are lowercased roles
    String sql = String.format("DELETE FROM %s WHERE Email_%s = ?", tableName, tableName);
    System.out.println(tableName);
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User removed from " + role + " table.");
        }
    } catch (SQLException e) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void addToRoleTable(String role, String nom, String prenom, String email) {
    String tableName = role.toLowerCase();
    String sql = String.format("INSERT INTO %s (Nom_%s, Prenom_%s, Email_%s) VALUES (?, ?, ?)", tableName, tableName, tableName, tableName);
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User added to " + role + " table.");
        }
    } catch (SQLException e) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleGetProductData() {
    String sql = "SELECT * FROM produit";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder userData = new StringBuilder();
        while (rs.next()) {
            if (userData.length() > 0) userData.append(";");  // Delimit entries
            userData.append(rs.getString("Nom_produit"))
                    .append(":")
                    .append(rs.getString("Quantite_produit"))
                    .append(":")
                    .append(rs.getString("Date_peremption"));
        }
        System.out.println("1");
        System.out.println(userData.toString());
        if (userData.length() > 0) {
            out.println(userData.toString());
        } else {
            out.println("No product found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleGetPatientData() {
    String sql = "SELECT * FROM patient";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder userData = new StringBuilder();
        while (rs.next()) {
            if (userData.length() > 0) userData.append(";");  // Delimit entries
            userData.append(rs.getString("Id_patient"))
                    .append(":")
                    .append(rs.getString("Nom_patient"))
                    .append(":")
                    .append(rs.getString("Prenom_patient"))
                    .append(":")
                    .append(rs.getString("Date_naissance_patient"))
                    .append(":")
                    .append(rs.getString("Sexe"))
                    .append(":")
                    .append(rs.getString("Email_patient"))
                    .append(":")
                    .append(rs.getString("Num_telephone_patient"));
        }
        System.out.println("1");
        System.out.println(userData.toString());
        if (userData.length() > 0) {
            out.println(userData.toString());
        } else {
            out.println("No patient found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleDeletePatient(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 2) {
        out.println("Invalid delete request");
        return;
    }

    String email = parts[1];
    String currentRole = getCurrentUserRole(email); // Fetch current role before deletion

    // Start by deleting the user from the utilisateur table
    String sql = "DELETE FROM patient WHERE Email_patient = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, email);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("Patient deleted successfully from patient table");
            // Proceed to remove the user from their role-specific table
            removeFromRoleTable(currentRole, email);
        } else {
            out.println("Failed to delete patient");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleUpdatePatient(String request) {
    System.out.println("Received update request");
    String[] parts = request.split(" ");
    if (parts.length < 7) {  // Expecting 9 parts including the role
        out.println("Invalid update request");
        return;
    }

    // Extract user data from the request
    String nom = parts[1];
    String prenom = parts[2];
    String date = parts[3];
    String sexe = parts[4];
    String email = parts[5];  // Email as a unique identifier for WHERE clause
    String Num = parts[6];
    

    // SQL command to update user information in the utilisateur table
    String sql = "UPDATE patient SET Nom_patient=?, Prenom_patient=?, Date_naissance_patient=?, Sexe=?, Num_telephone_patient=? WHERE Email_patient=?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, date);
        stmt.setString(4, sexe);
        stmt.setString(6, email);
        stmt.setString(5, Num);
        

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("User updated successfully");
            
            
           
        } else {
            out.println("Failed to update user");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleSearchPatientByName(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 3) {
        out.println("Invalid search request. Usage: SEARCH_PATIENT <first_name> <last_name>");
        return;
    }

    // Trim the name parts to remove any accidental leading or trailing whitespace
    String nom = parts[1].trim();
    String prenom = parts[2].trim();

    String sql = "SELECT * FROM patient WHERE Nom_patient LIKE ? AND Prenom_patient LIKE ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        // Use wildcards to enable partial matching
        stmt.setString(1, "%" + nom + "%");
        stmt.setString(2, "%" + prenom + "%");

        ResultSet rs = stmt.executeQuery();
        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            if (result.length() > 0) result.append(";");  // Delimit entries for multiple results
            result.append(rs.getString("Id_patient")).append(":")
                   .append(rs.getString("Nom_patient")).append(":")
                  .append(rs.getString("Prenom_patient")).append(":")
                  .append(rs.getString("Date_naissance_patient")).append(":")
                  .append(rs.getString("Sexe")).append(":")
                  .append(rs.getString("Email_patient")).append(":")
                  .append(rs.getString("Num_telephone_patient"));
        }
        
        if (result.length() > 0) {
            out.println(result.toString());
            System.out.println("Returned data: " + result); // Optional: for logging purposes
        } else {
            out.println("No patient found with the provided name and surname.");
        }
    } catch (SQLException e) {
        out.println("Database error during the search: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleAjouterAnalyse(String request) {
 
        String[] parts = request.split(" ");
        if (parts.length < 4) {
            out.println("Invalid user information");
            return;
        }

        String nom = parts[1];
        String norme = parts[3];
        String prix = parts[2];

        // Insert the user information into the database
        String sql = "INSERT INTO analyse (Nom_analyse, Prix_analyse,norme) VALUES (?, ?, ?)";
        System.out.println(sql);
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, norme);
            stmt.setString(3, prix);
            System.out.println(sql);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("Product information stored successfully");
            } else {
                out.println("Failed to store Product information");
            }
            
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
        
    }

private void handleGetAnalyseData() {
    String sql = "SELECT * FROM analyse";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder analyseData = new StringBuilder();
        while (rs.next()) {
            if (analyseData.length() > 0) analyseData.append(";");  // Delimit entries
            analyseData.append( 
                    rs.getString("ID_analyse"))
                    .append(":")
                    .append(rs.getString("Nom_analyse"))
                    .append(":")
                    .append(rs.getString("Prix_analyse"))
                    .append(":")
                    .append(rs.getString("norme"));
        }


        if (analyseData.length() > 0) {
            out.println(analyseData.toString());
        } else {
            out.println("No anlayse found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleDeleteAnalyse(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 2) {
        out.println("Invalid delete request");
        return;
    }

    String id = parts[1];
  

    String sql = "DELETE FROM analyse WHERE ID_analyse = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("analyse deleted successfully from utilisateur table");
           
        } else {
            out.println("Failed to delete analyse");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private void handleUpdateAnalyse(String request) {
    System.out.println("Received update request");
    String[] parts = request.split(" ");
    if (parts.length < 4) {  
        out.println("Invalid update request");
        return;
    }

    String id  = parts[1];
    String nom = parts[2];
    String prix = parts[3];
    String norme = parts[4];
 
    

    String sql = "UPDATE analyse SET Nom_analyse=?, Prix_analyse=?, norme=? WHERE ID_analyse=?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nom);
        stmt.setString(2, prix);
        stmt.setString(3, norme);
        stmt.setString(4, id);
 
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("Analyse updated successfully");
            
            
           
        } else {
            out.println("Failed to update analyse");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

public void handleAjouterBilan(String patientInfo) {
    System.out.println("Processing ADD_BILAN request");
    String[] parts = patientInfo.split("/");
    if (parts.length < 7) {
        out.println("Invalid request. Expected format: [Name] [Surname] [DOB] [Sex] [Email] [Phone] [Analyses]");
        return;
    }

    String Nom_patient = parts[1].replace(" ", "");
    String Prenom_patient = parts[2].replace(" ", "");
    String Date_naissance_patient = parts[3].replace(" ", "");
    String Sexe = parts[4].replace(" ", "");
    String Email_patient = parts[5].replace(" ", "");
    String Num_telephone_patient = parts[6].replace(" ", "");
    String[] analyses = parts[7].split(",");
        
    
    try {
        conn.setAutoCommit(false);  // Start transaction

        String insertSql1 = "INSERT INTO bilan (ID_patient) SELECT Id_patient FROM patient WHERE Nom_patient = ? AND Prenom_patient = ? AND Date_naissance_patient = ? AND Sexe = ? AND Email_patient = ? AND Num_telephone_patient = ?";
        System.out.println(insertSql1);
        try (PreparedStatement insertStmt = conn.prepareStatement(insertSql1)) {
            insertStmt.setString(1, Nom_patient);
            insertStmt.setString(2, Prenom_patient);
            insertStmt.setString(3, Date_naissance_patient);
            insertStmt.setString(4, Sexe);
            insertStmt.setString(5, Email_patient);
            insertStmt.setString(6, Num_telephone_patient);
            if (insertStmt.executeUpdate() == 0) {
                out.println("Failed to add bilan.");
                conn.rollback();  // Roll back if bilan addition fails
                return;
            }
        }
      for (String analysis : analyses) {
            System.out.println("mati" + analysis);
            String[] analysisParts = analysis.split(":");
            if (analysisParts.length < 3) {
                continue;  // Skip invalid entries
            }
            String nom_analyse = analysisParts[0].replace(" ", "");
            String prix_analyse = analysisParts[1].replace(" ", "");
            System.out.println("prix"+prix_analyse);
            String norme_analyse = analysisParts[2].replace(" ", "");
            System.out.println("norme "+norme_analyse);
            String insertSql2 = "INSERT INTO résultat (ID_bilan, ID_Analyse) " +
                    "SELECT b.ID_bilan, a.ID_analyse " +
                    "FROM bilan b " +
                    "JOIN analyse a ON a.Nom_analyse = ? AND a.Prix_analyse = ? AND a.norme = ? " +
                    "WHERE b.ID_patient = (SELECT Id_patient FROM patient WHERE Nom_patient = ? AND Prenom_patient = ? AND Date_naissance_patient = ? AND Sexe = ? AND Email_patient = ? AND Num_telephone_patient = ?)";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql2)) {
                insertStmt.setString(1, nom_analyse);
                insertStmt.setString(2, prix_analyse);
                insertStmt.setString(3, norme_analyse);
                insertStmt.setString(4, Nom_patient);
                insertStmt.setString(5, Prenom_patient);
                insertStmt.setString(6, Date_naissance_patient);
                insertStmt.setString(7, Sexe);
                insertStmt.setString(8, Email_patient);
                insertStmt.setString(9, Num_telephone_patient);

                if (insertStmt.executeUpdate() == 0) {
                    out.println("Failed to add result.");
                    conn.rollback();  // Roll back if result addition fails
                    return;
                }
            }
        }

        conn.commit();  // Commit the transaction if all operations succeed
        out.println("Bilan and results added successfully.");
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        try {
            conn.rollback();  // Ensure rollback on any exception
        } catch (SQLException ex) {
            out.println("Failed to rollback: " + ex.getMessage());
        }
    } finally  {
        try {
            conn.setAutoCommit(true);  // Reset auto-commit mode
        } catch (SQLException ex) {
            out.println("Failed to reset auto-commit: " + ex.getMessage());
        }
    }
}



public void handleAjouterEchantillion(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 3) {
        out.println("Invalid echantillion information");
        return;
    }

    String patientId = parts[1];
    String codeechantillion = parts[2];

    String sql = "INSERT INTO echantillion (Id_patient, Code_échantillion) VALUES (?, ?)";
  
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, Integer.parseInt(patientId));
        stmt.setString(2, codeechantillion);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("Echantillion information stored successfully");
        } else {
            out.println("Failed to store echantillion information");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}



private void handleGetAnalyseapplicableData(String request) {
    System.out.println("request: " + request);
    request = request.trim(); // Trim the request string before splitting
    String[] parts = request.split("\\s+"); // Split by any whitespace
    System.out.println("parts: " + Arrays.toString(parts));

    if (parts.length < 2) {
        System.out.println("Invalid request format");
        return;
    }

    System.out.println("part[0]: " + parts[0]);
    System.out.println("part[1]: " + parts[1]);
    
    String[] ids = parts[1].split(",");
    if (ids.length == 0) {
        System.out.println("No IDs provided");
        return;
    }
    System.out.println("ids[0]: " + ids[0]);

    // Build the SQL query with the IN clause
    StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM analyse WHERE ID_analyse IN (");
    for (int i = 0; i < ids.length; i++) {
        sqlBuilder.append("?");
        if (i < ids.length - 1) {
            sqlBuilder.append(",");
        }
    }
    sqlBuilder.append(")");

    String sql = sqlBuilder.toString();
    System.out.println("SQL: " + sql);
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        // Set the placeholders with the actual IDs
        for (int i = 0; i < ids.length; i++) {
            stmt.setString(i + 1, ids[i].trim());
        }

        try (ResultSet rs = stmt.executeQuery()) {
            StringBuilder analyseData = new StringBuilder();
            boolean found = false;
            while (rs.next()) {
                found = true;
                if (analyseData.length() > 0) analyseData.append(";");  // Delimit entries
                analyseData.append(rs.getString("Nom_analyse"))
                           .append(":")
                           .append(rs.getString("Prix_analyse"))
                           .append(":")
                           .append(rs.getString("norme"));
            }

            if (found) {
                out.println(analyseData.toString());
            } else {
                out.println("No analyse found");
            }
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}



private void handleStorePatientPdf(String request) throws DocumentException {
    // Split the request to get the patient details
    String[] parts = request.split(" ", 14);
    if (parts.length < 9) {  // Ensure minimal required fields
        out.println("Invalid patient PDF storage request");
        return;
    }

    try {
        int id_patient = Integer.parseInt(parts[1]);
        String nom_patient = parts[2];
        String prenom_patient = parts[3];
        String date_naissance_patient = parts[4];
        String sexe = parts[5];
        String email_patient = parts[6];
        String num_telephone_patient = parts[7];
        String num_telephone_urgence = parts.length > 8 ? parts[8] : "Unknown";
        String num_assurance = parts.length > 9 ? parts[9] : "Unknown";
        String info_assurance = parts.length > 10 ? parts[10] : "Unknown";
        String medecin = parts.length > 11 ? parts[11] : "Unknown";
        String tel_medecin = parts.length > 12 ? parts[12] : "Unknown";
        String clinique_adresse = parts.length > 13 ? parts[13] : "Unknown";

        String filename = "UserInfo_" + id_patient + "_" + System.currentTimeMillis() + ".pdf";

        createPdf(filename, id_patient, nom_patient, prenom_patient, date_naissance_patient, sexe, email_patient, num_telephone_patient, num_telephone_urgence, info_assurance, num_assurance, medecin, tel_medecin, clinique_adresse);

        storePdf(filename, id_patient);

        out.println("Patient PDF stored successfully");
    } catch (NumberFormatException | DocumentException | FileNotFoundException e) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        out.println("Error in handling STORE_PATIENT_PDF: " + e.getMessage());
    } catch (IOException | SQLException e) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        out.println("Database or IO error: " + e.getMessage());
    }
}




private void createPdf(String filename, int id_patient, String nom_patient, String prenom_patient, String date_naissance_patient, String sexe, String email_patient, String num_telephone_patient, String num_telephone_urgence, String info_assurance, String num_assurance, String medecin, String tel_medecin, String clinique_adresse) throws com.itextpdf.text.DocumentException, FileNotFoundException, IOException {
    com.itextpdf.text.Document document = new com.itextpdf.text.Document();
    PdfWriter.getInstance(document, new FileOutputStream(filename));
    document.open();

    // Define font styles
    Font titleFont = new Font(Font.FontFamily.HELVETICA, 23, Font.BOLD, new BaseColor(1, 58, 223)); // Dark blue
    Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, new BaseColor(1, 58, 223)); // Lighter blue
    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD); // Bold for specific lines
    Font sectionHeaderFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, new BaseColor(1, 58, 223)); // Dark blue for section headers
    Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
   

    // Define custom colors
    BaseColor headerColor = new BaseColor(163, 193, 218); // Darker blue for headers    

      String logoPath = "logo.jpg"; // Ensure you have the correct path
        Image logo = Image.getInstance(logoPath);
        logo.scaleToFit(110, 100);
        logo.setAbsolutePosition(36, 750); // Adjust these values as needed
        document.add(logo);

        com.itextpdf.text.Font clinicNameFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD, new BaseColor(0, 102, 204));
        Paragraph clinicName = new Paragraph("QUICK LAB", clinicNameFont);
        clinicName.setIndentationLeft(80);
        document.add(clinicName);
        
        document.add(new Paragraph("    "));
        
        
        
        
    // Add a blue bar as the title background
    PdfPTable titleTable = new PdfPTable(1);
    titleTable.setWidthPercentage(100);
    PdfPCell cell = new PdfPCell(new Phrase("Dossier médical", titleFont));
    cell.setBackgroundColor(headerColor);
    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell.setPadding(10);
    cell.setBorder(PdfPCell.NO_BORDER);
    titleTable.addCell(cell);

    PdfPCell cell2 = new PdfPCell(new Phrase("personnel", subtitleFont));
    cell2.setBackgroundColor(headerColor);
    cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell2.setPadding(10);
    cell2.setBorder(PdfPCell.NO_BORDER);
    titleTable.addCell(cell2);

    document.add(titleTable);

    // Adding informational lines
    Paragraph infoLine1 = new Paragraph("Garder à jour le dossier ainsi que ceux des membres de votre famille*", boldFont);
    Paragraph infoLine2 = new Paragraph("Apportez-le avec vous à l'occasion d'une consultation médicale.", normalFont);
    document.add(infoLine1);
    document.add(infoLine2);
    document.add(new Paragraph("\n")); // Add some spacing

    // Function to add section headers
    Consumer<String> addSectionHeader = (String text) -> {
        PdfPTable headerTable = new PdfPTable(1);
        headerTable.setWidthPercentage(100);
        PdfPCell headerCell = new PdfPCell(new Phrase(text, sectionHeaderFont));
        headerCell.setBackgroundColor(headerColor);
        headerCell.setPadding(8);
        headerCell.setBorder(PdfPCell.NO_BORDER);
        headerTable.addCell(headerCell);
        try {
            document.add(headerTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    };

    // Function to add content with space below
    Consumer<String[]> addContent = (String[] contents) -> {
        PdfPTable contentTable = new PdfPTable(2);
        contentTable.setWidthPercentage(100);
        for (String content : contents) {
            PdfPCell contentCell = new PdfPCell(new Phrase(content, normalFont));
            contentCell.setBorder(PdfPCell.NO_BORDER);
            contentTable.addCell(contentCell);
        }
        try {
            document.add(contentTable);
            document.add(new Paragraph("\n")); // Adding space after each content section
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    };

    // Add sections and contents
    addSectionHeader.accept("Coordonnées personnelles");
    addContent.accept(new String[]{"Nom:", nom_patient ,
                                   "Prenom:", prenom_patient,
                                   "Date de naissance:", date_naissance_patient,
                                   "Sexe:", sexe,
                                   "Email:", email_patient,
                                   "Téléphone domicile:", num_telephone_patient});

    addSectionHeader.accept("Contact d'urgence");
    addContent.accept(new String[]{"Numéro de téléphone d'urgence:", num_telephone_urgence});

    addSectionHeader.accept("Assurance maladie");
    addContent.accept(new String[]{"N° d'assurance:", num_assurance,
                                   "Informations d'assurance:", info_assurance});

    addSectionHeader.accept("Mon médecin");
    addContent.accept(new String[]{"Nom du médecin:", medecin,
                                   "Téléphone:", tel_medecin,
                                   "Adresse de la clinique médicale:", clinique_adresse});

    document.close();
}






private void storePdf(String filename, int id_patient) throws SQLException, IOException {
    String url = "jdbc:mysql://localhost:3306/laboratoire_d_analyse?useSSL=false";
    String user = "root";
    String password = "";
    String sql = "INSERT INTO dossiers (pdf, id_patient) VALUES (?, ?)";

    File pdfFile = new File(filename);
    if (!pdfFile.exists() || !pdfFile.canRead()) {
        JOptionPane.showMessageDialog(null, "PDF file does not exist or cannot be read", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         FileInputStream input = new FileInputStream(pdfFile)) {

        pstmt.setBinaryStream(1, input, (int) pdfFile.length());  // Set the PDF
        pstmt.setInt(2, id_patient);  // Set the id_patient

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating PDF failed, no rows affected.");
        }

        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long dossierId = generatedKeys.getLong(1);
                //JOptionPane.showMessageDialog(null, "Dossier ID: " + dossierId + " a été sauvegardé avec succès.", "Dossier Sauvegardé", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new SQLException("Creating PDF failed, no ID obtained.");
            }
        }
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Dossier.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Failed to store PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}





private void handleDownloadPdf(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 2) {
        JOptionPane.showMessageDialog(null, "Invalid request for PDF download", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    
        int patientId = Integer.parseInt(parts[1]);
    

    String filePath = "downloadedPDF.pdf";
     System.out.println("Téléchargement du PDF pour le patient ID: " + patientId);

    try {
            // Supposer que Client.downloadPdf soit défini correctement.
            downloadPdf(patientId, filePath);

            System.out.println("Vérification de l'existence du fichier : " + filePath);
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("Le fichier existe, tentative d'ouverture.");
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.out.println("Aucune application de bureau n'est prise en charge pour ouvrir le PDF");
                    //JOptionPane.showMessageDialog(null, "Aucune application de bureau n'est prise en charge pour ouvrir le PDF", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                    System.out.println("Le fichier PDF n'a pas été trouvé.");

                //JOptionPane.showMessageDialog(null, "Le fichier PDF n'a pas été trouvé.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println("1.");
            //Logger.getLogger(Dossier.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture du PDF: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
}



private void downloadPdf(int patientId, String filePath) throws SQLException, IOException {
    String sql = "SELECT pdf FROM dossiers WHERE id_patient = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratoire_d_analyse?useSSL=false", "root", "");
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, patientId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            byte[] fileBytes = rs.getBytes("pdf");
            try (OutputStream targetFile = new FileOutputStream(filePath)) {
                targetFile.write(fileBytes);
            }
        } else {
            throw new FileNotFoundException("Aucun PDF trouvé pour l'ID du patient spécifié.");
        }
    }
}



private void handleAjouterRendez_vous(String request) {
 
        String[] parts = request.split(" ");
        if (parts.length < 4) {
            out.println("Invalid user information");
            return;
        }
        int id_patient = Integer.parseInt(parts[1]);
        String heur = parts[2];
        String date = parts[3];
        

        // Insert the user information into the database
        String sql = "INSERT INTO rendez_vous (Id_patient , Heur_rendez_vous, Date_rendez_vous    ) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            
            stmt.setInt(1, id_patient);  // Set the id_patient
            stmt.setString(2, heur);
            stmt.setString(3, date);
           
            
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("Rendez_vous information stored successfully");
            } else {
                out.println("Failed to store Rendez_vous information");
            }
            
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
        
    }



private void handleGetRendez_voustData() {
    // Jointure SQL pour récupérer les données de patient et de rendez_vous
    String sql = "SELECT p.Nom_patient, p.Prenom_patient,r.Id_rendez_vous ,r.Date_rendez_vous, r.Heur_rendez_vous " +
                 "FROM rendez_vous r " +
                 "JOIN patient p ON r.id_patient = p.ID_patient";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder userData = new StringBuilder();
        while (rs.next()) {
            if (userData.length() > 0) userData.append(";");  // Delimit entries
            userData.append(rs.getString("Id_rendez_vous"))
                    .append(":")
                    .append(rs.getString("Nom_patient"))
                    .append(":")
                    .append(rs.getString("Prenom_patient"))
                    .append(":")
                    .append(rs.getString("Date_rendez_vous"))
                    .append(":")
                    .append(rs.getString("Heur_rendez_vous"));
        }
        
        System.out.println(userData.toString());
        if (userData.length() > 0) {
            out.println(userData.toString());
        } else {
            out.println("No Rendez_vous found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}



private void handleDelete_Rendez_vous(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 2) {
        out.println("Invalid delete request");
        return;
    }

    String date = parts[1];
   

    // Start by deleting the user from the utilisateur table
    String sql = "DELETE FROM rendez_vous WHERE Id_rendez_vous = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, date);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("rendez_vous deleted successfully from Rendez_vous table");
            
        } else {
            out.println("Failed to delete Rendez_vous");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}



private void handleUpdateRendez_vous(String request) {
    System.out.println("Received update request");
    String[] parts = request.split(" ");
    if (parts.length < 4) {  
        out.println("Invalid update request");
        return;
    }

    // Extract user data from the request
    String id = parts[1];
    String heur = parts[2];
    String date = parts[3];
    
    

    // SQL command to update user information in the utilisateur table
    String sql = "UPDATE rendez_vous SET Heur_rendez_vous=?, Date_rendez_vous=? WHERE Id_rendez_vous=?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(3,id);
        stmt.setString(1, heur);
        stmt.setString(2, date);
       
        

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            out.println("User updated successfully");
            
            
           
        } else {
            out.println("Failed to update user");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}








    
 private void handleAjouterAnalyseResults(String request) {
    System.out.println("Received analysis results request: " + request);
    String[] parts = request.split(";");
    if (parts.length < 1) {
        out.println("Invalid analysis results request");
        return;
    }

    // Extract patient ID from the first part
    String patientIdPart = parts[0].trim();
    if (!patientIdPart.startsWith("SEND_ANALYSIS_RESULTS PatientID/")) {
        out.println("Invalid patient ID format");
        return;
    }

    String[] patientId = patientIdPart.split("/");
    System.out.println("Patient ID: " + patientId[1]);

    // Extract the results
    List<String[]> analysisResults = new ArrayList<>();
    for (int i = 1; i < parts.length; i++) {
        String[] resultParts = parts[i].split(":");
        if (resultParts.length == 2) {
            analysisResults.add(resultParts);
        } else {
            out.println("Invalid result format for: " + parts[i]);
        }
    }

    // Find ID_bilan using the patient ID
    String findBilanSql = "SELECT ID_bilan FROM bilan WHERE ID_patient = ?";
    try (PreparedStatement findStmt = conn.prepareStatement(findBilanSql)) {
        findStmt.setString(1, patientId[1]);
        ResultSet rs = findStmt.executeQuery();

        if (!rs.next()) {
            out.println("No bilan found for the provided patient ID");
            return;
        }

        int idBilan = rs.getInt("ID_bilan");

        // Update the results in the results table
        String updateResultSql = "UPDATE résultat SET resultat = ? WHERE ID_bilan = ? AND ID_Analyse = ?";
        try (PreparedStatement updateStmt = conn.prepareStatement(updateResultSql)) {
            for (String[] result : analysisResults) {
                updateStmt.setString(1, result[1]);
                updateStmt.setInt(2, idBilan);
                updateStmt.setString(3, result[0]);
                updateStmt.addBatch();
            }

            int[] rowsAffected = updateStmt.executeBatch();
            out.println("Updated " + rowsAffected.length + " analysis results successfully");

            // Fetch additional details and generate the PDF
            fetchAdditionalDetails(patientId[1], analysisResults);

        } catch (SQLException e) {
            out.println("Database error during update: " + e.getMessage());
        }

    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    }
}

private Map<String, String> fetchAdditionalDetails(String patientId, List<String[]> analysisWithResults) {
    Map<String, String> details = new LinkedHashMap<>();

    try {
        // Fetch patient's full name
        PreparedStatement patientStmt = conn.prepareStatement("SELECT Nom_patient, Prenom_patient FROM patient WHERE Id_patient = ?");
        patientStmt.setString(1, patientId);
        ResultSet patientRs = patientStmt.executeQuery();
        if (patientRs.next()) {
            String nom = patientRs.getString("Nom_patient");
            String prenom = patientRs.getString("Prenom_patient");
            details.put("patientName", nom + " " + prenom);
        } else {
            details.put("error", "No patient found with ID: " + patientId);
            return details;
        }
        patientRs.close();
        patientStmt.close();

        // Fetch analysis names and append results
        for (String[] result : analysisWithResults) {
            PreparedStatement analyseStmt = conn.prepareStatement("SELECT Nom_analyse FROM analyse WHERE ID_analyse = ?");
            analyseStmt.setString(1, result[0]);
            ResultSet analyseRs = analyseStmt.executeQuery();
            if (analyseRs.next()) {
                String nomAnalyse = analyseRs.getString("Nom_analyse");
                details.put(nomAnalyse, result[1]);
            }
            analyseRs.close();
            analyseStmt.close();
        }

        // Call to generate the PDF
        displayAnalysisResultsAsPDF(patientId, analysisWithResults, details);

    } catch (SQLException e) {
        details.put("error", "Database error: " + e.getMessage());
    }
    return details;
}

public void displayAnalysisResultsAsPDF(String patientId, List<String[]> analysisWithResults, Map<String, String> patientDetails) {
    try {
        if (patientDetails.containsKey("error")) {
            JOptionPane.showMessageDialog(null, patientDetails.get("error"), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Path path = Paths.get(System.getProperty("user.home"), "Desktop", patientId + "_AnalysisResults.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path.toString()));
        document.open();

        // Clinic logo and name
        String logoPath = "logo.jpg"; // Ensure the correct path is set
        Image logo = Image.getInstance(logoPath);
        logo.scaleToFit(140, 100);
        logo.setAbsolutePosition(36, 750); // Adjust these values as needed
        document.add(logo);

        Font clinicNameFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(0, 102, 204));
        Paragraph clinicName = new Paragraph("QUICK LAB", clinicNameFont);
        clinicName.setIndentationLeft(80);
        document.add(clinicName);

        // Invoice header
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.BLACK);
        Paragraph header = new Paragraph("ANALYSIS RESULTS INVOICE", headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setSpacingBefore(20);
        document.add(header);

        // Patient details
        Font patientFont = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
        Paragraph patientInfo = new Paragraph("Patient: " + patientDetails.get("patientName"), patientFont);
        patientInfo.setSpacingBefore(10);
        patientInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(patientInfo);

        // Table for analysis details
        PdfPTable table = new PdfPTable(new float[] {4, 2});
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);
        addTableHeader(table, new String[] {"Analysis Name", "Result"});
        fillTableWithData(table, patientDetails);
        document.add(table);

        // Contact information and social media icons
        String contactDetails = "+00 123456789 | QuickLab@example.com | Jijel_Taher - Algeria";
        Paragraph contactInfo = new Paragraph(contactDetails, new Font(Font.FontFamily.HELVETICA, 10));
        contactInfo.setAlignment(Element.ALIGN_CENTER);
        contactInfo.setSpacingBefore(15);
        document.add(contactInfo);

        PdfPTable socialTable = new PdfPTable(3); // Three social media icons
        socialTable.setWidthPercentage(10);
        socialTable.setSpacingBefore(5);

        String[] iconsPaths = {"facebook.png", "twitter.png", "instagram.png"};
        for (String iconPath : iconsPaths) {
            Image icon = Image.getInstance(iconPath);
             icon.scaleToFit(10, 10);
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

private void fillTableWithData(PdfPTable table, Map<String, String> data) {
    PdfPCell cell;
    for (Map.Entry<String, String> entry : data.entrySet()) {
        if (entry.getKey().equals("patientName")) {
            continue; // Skip the patient's name
        }
        cell = new PdfPCell(new Phrase(entry.getKey()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(entry.getValue()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        table.addCell(cell);
    }
}


 
 
 
 

private void handleCalculateDailyRevenue(String request) {
    String[] parts = request.split(" ");
    if (parts.length < 3) {
        out.println("Invalid revenue request");
        return;
    }

    try {
        int id_patient = Integer.parseInt(parts[1]);
        double dailyRevenue = Double.parseDouble(parts[2]);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        String todayDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        int currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        int currentMonthOfYear = cal.get(Calendar.MONTH) + 1;  // Month is zero-based in Calendar

        String sqlPayment = "INSERT INTO payment (Date_payment, Id_patient, Montant_paye) VALUES (?, ?, ?)";
        
        // Updated SQL for revenus1 table with proper week comparison
        String sqlRevenue = "INSERT INTO revenus1 (Date, journee_revenus, semain_revenus, month_revenus, week_of_year, month_of_year) VALUES (?, ?, ?, ?, ?, ?) "
                            + "ON DUPLICATE KEY UPDATE "
                            + "journee_revenus = journee_revenus + ?, "
                            + "semain_revenus = IF(?, semain_revenus + ?, semain_revenus), "  // Corrected condition
                            + "month_revenus = IF(MONTH(Date) = ?, month_revenus + ?, month_revenus)";

        try (PreparedStatement stmtPayment = conn.prepareStatement(sqlPayment);
             PreparedStatement stmtRevenue = conn.prepareStatement(sqlRevenue)) {

            conn.setAutoCommit(false); // Begin transaction

            // Insert into payment table
            stmtPayment.setString(1, todayDate);
            stmtPayment.setInt(2, id_patient);
            stmtPayment.setDouble(3, dailyRevenue);
            stmtPayment.executeUpdate();

            // Insert or update the revenus1 table
            stmtRevenue.setString(1, todayDate);
            stmtRevenue.setDouble(2, dailyRevenue);  // Initialize journee_revenus
            stmtRevenue.setDouble(3, dailyRevenue);  // Initialize semain_revenus
            stmtRevenue.setDouble(4, dailyRevenue);  // Initialize month_revenus
            stmtRevenue.setInt(5, currentWeekOfYear);
            stmtRevenue.setInt(6, currentMonthOfYear);
            stmtRevenue.setDouble(7, dailyRevenue);  // Update journee_revenus
            stmtRevenue.setInt(8, currentWeekOfYear); // Current week for comparison
            stmtRevenue.setDouble(9, dailyRevenue);  // Update semain_revenus
            stmtRevenue.setInt(10, currentMonthOfYear); // Current month for comparison
            stmtRevenue.setDouble(11, dailyRevenue);  // Update month_revenus
            stmtRevenue.executeUpdate();

            conn.commit(); // Commit transaction
            out.println("Daily revenue stored successfully");

        } catch (SQLException e) {
            conn.rollback(); // Rollback transaction on error
            out.println("Database error: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true); // Restore default auto-commit mode
        }
    } catch (NumberFormatException | SQLException e) {
        out.println("Error processing revenue request: " + e.getMessage());
    }
}


  
  
  
 
private void handleGetPaymentData() {
    // SQL joins the payment and patient tables to fetch the required information
    String sql = "SELECT p.Date_payment, pt.Nom_patient, pt.Prenom_patient, p.Montant_paye " +
                 "FROM payment p " +
                 "JOIN patient pt ON p.Id_patient = pt.Id_patient";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder paymentData = new StringBuilder();
        while (rs.next()) {
            if (paymentData.length() > 0) paymentData.append(";");  // Delimit entries
            paymentData.append(rs.getString("Nom_patient"))
                    .append(":")
                    .append(rs.getString("Prenom_patient"))
                    .append(":")
                    .append(rs.getString("Date_payment"))
                     .append(":")    
                    .append(rs.getString("Montant_paye"));
        }
        System.out.println("1");
        System.out.println(paymentData.toString());
        if (paymentData.length() > 0) {
            out.println(paymentData.toString());
        } else {
            out.println("No payment found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}

private void handleGetRevenusData() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new java.util.Date());
    String todayDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    int currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
    int currentMonthOfYear = cal.get(Calendar.MONTH) + 1;  // Month is zero-based in Calendar

    // SQL query to select revenue data for the current day
    String sqlToday = "SELECT journee_revenus FROM revenus1 WHERE Date = ?";
    // SQL query to sum revenue data for the current week
    String sqlWeek = "SELECT SUM(semain_revenus) AS week_total FROM revenus1 WHERE week_of_year = ?";
    // SQL query to sum revenue data for the current month
    String sqlMonth = "SELECT SUM(month_revenus) AS month_total FROM revenus1 WHERE month_of_year = ?";

    try (PreparedStatement stmtToday = conn.prepareStatement(sqlToday);
         PreparedStatement stmtWeek = conn.prepareStatement(sqlWeek);
         PreparedStatement stmtMonth = conn.prepareStatement(sqlMonth)) {

        StringBuilder revenusData = new StringBuilder();

        // Get today's revenue
        stmtToday.setString(1, todayDate);
        try (ResultSet rsToday = stmtToday.executeQuery()) {
            if (rsToday.next()) {
                revenusData.append(rsToday.getDouble("journee_revenus"));
            } else {
                revenusData.append("0.0");  // No data for today
            }
        }

        // Get the total revenue of the current week
        stmtWeek.setInt(1, currentWeekOfYear);
        try (ResultSet rsWeek = stmtWeek.executeQuery()) {
            if (rsWeek.next()) {
                revenusData.append(":").append(rsWeek.getDouble("week_total"));
            } else {
                revenusData.append(":0.0");  // No data for this week
            }
        }

        // Get the total revenue of the current month
        stmtMonth.setInt(1, currentMonthOfYear);
        try (ResultSet rsMonth = stmtMonth.executeQuery()) {
            if (rsMonth.next()) {
                revenusData.append(":").append(rsMonth.getDouble("month_total"));
            } else {
                revenusData.append(":0.0");  // No data for this month
            }
        }

        // Output the revenue data
        System.out.println("Fetched revenue data: " + revenusData.toString());
        if (revenusData.length() > 0) {
            out.println(revenusData.toString());
        } else {
            out.println("No revenue data found");
        }
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
    }
}






private void executeDatabaseQuery(String message) {
        
        String sql = "INSERT INTO messages (content) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, message);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Message inserted into database.");
            } else {
                System.out.println("Failed to insert message into database.");
            }
        } catch (SQLException e) {
        }
    }
    
}

