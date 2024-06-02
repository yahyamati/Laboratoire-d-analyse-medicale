/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author loukmane04
 * jDoe!2024
 * john.doe@example.com
 */
public class Client {
    
    static final int Server_Port = 9090;
    static final String Server_Ip = "localhost";
    
    public static void main(String[] args) throws IOException {
        
        Login loginframe = new Login();
        loginframe.setVisible(true);
        try (Socket socket = new Socket(Server_Ip,Server_Port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            
            while(true){
                System.out.print("..>");
                String command = keyboard.readLine();
                
                if(command.equals("quit"))break;
                
                out.println(command);
                String server_responde = input.readLine();
                System.out.println("Server : "+server_responde);
                
                   
            }
            
            out.close();
            input.close();
        }
    }
    
     public static void login(String email, String password) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            out.println("LOGIN " + email + " " + password);
            String response = input.readLine();
            
            
            
            
            if (response.startsWith("Login successful. Role: Gerant")) {
                    System.out.println("loukmane "+response);
                    openGerantFrame();
            }
            if (response.startsWith("Login successful. Role: Medecin")) {
                    System.out.println("loukmane "+response);
                    openMedecinFrame();
            }
            if (response.startsWith("Login successful. Role: Biologiste")) {
                    System.out.println("loukmane "+response);
                    openBiologisteFrame();
            }
            if (response.startsWith("Login successful. Role: Receptionniste")) {
                    System.out.println("loukmane "+response);
                    openReceptionnisteFrame();
            }
             
            
            
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
     
    public static void openGerantFrame() {
    // Open Gerant frame
    java.awt.EventQueue.invokeLater(() -> {
        new Gerant().setVisible(true);
    });
     }
    
    public static void openMedecinFrame() {
    // Open Medcin frame
    java.awt.EventQueue.invokeLater(() -> {
        new Medecin().setVisible(true);
    });
     }
    
    public static void openBiologisteFrame() {
    // Open Biologiste frame
    java.awt.EventQueue.invokeLater(() -> {
        new Biologiste1().setVisible(true);
    });
     }
    
    public static void openReceptionnisteFrame() {
    // Open Receptionniste frame
    java.awt.EventQueue.invokeLater(() -> {
        new Receptionniste().setVisible(true);
    });
     }
    

    public static void sendUserInfo(String nom, String prenom, String dn, String sexe, String email, String nt, String mp, String role) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String userInfo = String.format("ADD_USER %s %s %s %s %s %s %s %s", nom, prenom, dn, sexe, email, nt, mp, role);
            out.println(userInfo);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
    
    
    public static String fetchUserData() {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET_USER_DATA");  // Command the server to send back user data

            // Read the response which we assume is formatted as "Nom:Prenom:Email:..."
            String response = input.readLine();
            return response;  // Return the response to the caller
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null;  // Return null in case of error
        }
    }
    
    public static void deleteUser(String email) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
        
        out.println("DELETE_USER " + email);  // Send delete command to server

        String response = input.readLine();
        System.out.println("Server response: " + response);
    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
    
    public static void updateUser(String nom, String prenom, String dn, String sexe, String email, String nt, String mp,String role) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Format the update command and send it to the server
        String updateInfo = String.format("UPDATE_USER %s %s %s %s %s %s %s %s", nom, prenom, dn, sexe, email, nt, mp,role);
        System.out.println(updateInfo);
        out.println(updateInfo);

        // Receive and print the server response
        String response = input.readLine();
        System.out.println("Server response: " + response);

    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
    
    public static void sendProduitInfo(String np, String quantite, String dp) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String produitInfo = String.format("ADD_PRODUCT %s %s %s", np,quantite, dp);
            out.println(produitInfo);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }

     
      
    public static String fetchProductData() {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET_PRODUCT_DATA");  // Command the server to send back user data

            // Read the response which we assume is formatted as "Nom:Prenom:Email:..."
            String response = input.readLine();
            return response;  // Return the response to the caller
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null;  // Return null in case of error
        }
    }
    
    public static void sendPatientInfo(String nom, String prenom, String date,String sexe, String email, String Num) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String patientInfo = String.format("ADD_PATIENT %s %s %s %s %s %s" ,  nom,prenom,date,sexe, email, Num);
            out.println(patientInfo);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
    
    
    public static String fetchPatientData() {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET_PATIENT_DATA");  // Command the server to send back user data

            // Read the response which we assume is formatted as "Nom:Prenom:Email:..."
            String response = input.readLine();
            return response;  // Return the response to the caller
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null;  // Return null in case of error
        }
    }
    
    public static void deletePatient(String email) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
        
        out.println("DELETE_PATIENT " + email);  // Send delete command to server

        String response = input.readLine();
        System.out.println("Server response: " + response);
    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
     
    public static void updatePatient(String nom, String prenom, String date, String sexe, String email, String Num) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Format the update command and send it to the server
        String updateInfo = String.format("UPDATE_PATIENT %s %s %s %s %s %s", nom, prenom, date, sexe, email, Num);
        System.out.println(updateInfo);
        out.println(updateInfo);

        // Receive and print the server response
        String response = input.readLine();
        System.out.println("Server response: " + response);

    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
     
     
    public static String searchPatientByName(String firstName, String lastName) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Format the search command and send it to the server
        String searchCommand = String.format("SEARCH_PATIENT %s %s", firstName, lastName);
        out.println(searchCommand);
        System.out.println("hada wch b3t lserver bch ydir recherche " + searchCommand);

        // Receive and print the server response
        String response = input.readLine();
        System.out.println("Server response: " + response);
        return response;
    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
         return "";
    }
        
   
}
     
    public static void sendAnalyseInfo(String nom, String norme, String prix) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String analyseInfo = String.format("ADD_ANALYSE %s %s %s", nom, norme, prix);
            System.out.println(nom);
            out.println(analyseInfo);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
    
    public static String fetchAnalyseData()  {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET_ANALYSE_DATA");  

            
            String response = input.readLine();
            return response;  
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null; 
        }
    }
    
    public static void deleteAnalyse(String id) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("DELETE_ANALYSE " + id);  // Send delete command to server

            String response = input.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
        }
    
    public static void updateAnalyse(String id,String nom, String prix, String norme) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


            String updateInfo = String.format("UPDATE_ANALYSE %s %s %s %s", id,nom, prix, norme);
            System.out.println(updateInfo);
            out.println(updateInfo);


            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
        }
    
public static void ajouterBilan(String nom, String prenom, String date, String sexe, String email, String num, List<String[]> analyses) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        socket.setKeepAlive(true);

        StringBuilder analysesInfo = new StringBuilder();
        for (String[] analysis : analyses) {
            analysesInfo.append(String.format("%s:%s:%s,", analysis[0], analysis[1], analysis[2]));
        }
        if (analysesInfo.length() > 0) {
            analysesInfo.setLength(analysesInfo.length() - 1);  // Remove the trailing comma
        }


        String patientInfo = String.format("%s/%s/%s/%s/%s/%s/%s", nom, prenom, date, sexe, email, num, analysesInfo.toString());
        System.out.println("analyse: " + analysesInfo.toString().replace(" ", ""));
        String request = String.format("ADD_BILAN/ %s", patientInfo);
        out.println(request);


        String response = input.readLine();
        if (response == null) {
            System.out.println("Server closed the connection unexpectedly.");
        } else {
            System.out.println("Server response: " + response);
        }
    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
}

public static void ajouterechantillion(String patientId, String codeechantillion) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        String analyseInfo = String.format("ADD_ECHANILLION %s %s", patientId, codeechantillion);
        out.println(analyseInfo);

        String response = input.readLine();
        System.out.println("Server response: " + response);

    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
}

public static String fetchAnalyseApplicableData(String analysisIds) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String request = String.format("GET_ANALYSE_APPLICABLE_DATA %s", analysisIds);

            out.println(request);

            String response = input.readLine();
            return response;
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null;
        }
    }

///////////////////////dossier///////////////////////////


      
      


 

    
    

   
 public static void storePatientPdf(int id_patient, String nom_patient, String prenom_patient, String date_naissance_patient, String sexe, String email_patient, String num_telephone_patient, String num_telephone_urgence, String info_assurance, String num_assurance, String medecin, String tel_medecin, String clinique_adresse) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Prepare the data to be sent
        String patientInfo = String.format("STORE_PATIENT_PDF %d %s %s %s %s %s %s %s %s %s %s %s %s", id_patient, nom_patient, prenom_patient, date_naissance_patient, sexe, email_patient, num_telephone_patient, num_telephone_urgence, info_assurance, num_assurance, medecin, tel_medecin, clinique_adresse);
        System.out.println(patientInfo);
        out.println(patientInfo);
        out.flush();

        // Await response from the server
        String serverResponse = in.readLine();
        System.out.println("Server response: " + serverResponse);

    } catch (IOException ex) {
        System.out.println("Error in storePatientPdf: " + ex.getMessage());
        ex.printStackTrace();
    }
}
 
 
 
 
 
 
public static void requestPdfDownload(int patientId) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Prepare the data to be sent
        String patientInfo = String.format("ID_PATIENT_PDF %d ", patientId);
        System.out.println(patientInfo);
        out.println(patientInfo);
        out.flush();

        // Await response from the server
        String serverResponse = in.readLine();
        System.out.println("Server response: " + serverResponse);

    } catch (IOException ex) {
        System.out.println("Error in storePatientPdf: " + ex.getMessage());
        ex.printStackTrace();
    }
}

///////////////////////////////////////////////////////rendez-vous////////////////////////////////////////////



 public static void sendRendez_vousInfo(int id_patient , String heur, String date) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String Rendez_vousIInfo = String.format("ADD_RENDEZ_VOUS %d %s %s " ,id_patient,  heur , date);
            out.println(Rendez_vousIInfo);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
   
   public static String GetlRendez_vousData() {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("LOAD_Rendez_vous_DATA");  // Command the server to send back user data

            // Read the response which we assume is formatted as "Nom:Prenom:Email:..."
            String response = input.readLine();
            return response;  // Return the response to the caller
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            return null;  // Return null in case of error
        }
    }
   
   public static void deleteRendez_vous(String id) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
        
        out.println("DELETE_RENDEZ_VOUS " + id);  // Send delete command to server

        String response = input.readLine();
        System.out.println("Server response: " + response);
    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
   
   
     public static void updateRendez_vous(String id,String heur, String date) {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Format the update command and send it to the server
        String updateInfo = String.format("UPDATE_RENDEZ_VOUS %s %s %s", id,heur, date);
        System.out.println(updateInfo);
        out.println(updateInfo);

        // Receive and print the server response
        String response = input.readLine();
        System.out.println("Server response: " + response);

    } catch (IOException ex) {
        System.out.println("Error connecting to server: " + ex.getMessage());
    }
    }
     
     
 ////////////////////////////////////////////////////////////////////////////////////////////////
     
 
     
       public static void sendDailyRevenueCalculationRequest(int id_patient, double totalRevenue) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Format the data and send it to the server
            String message = String.format("CALCULATE_DAILY_REVENUE %d %.2f", id_patient, totalRevenue);
            out.println(message);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }
      
   
      
public static String fetchPaymentData() {
    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Send the command to the server
        out.println("GET_PAYMENT_DATA");
        System.out.println("Sent request to server: GET_PAYMENT_DATA");

        // Await and read the server's response
        String response = input.readLine();
        if (response != null && !response.isEmpty()) {
            System.out.println("Received response from server.");
            return response;
        } else {
            System.out.println("Server returned an empty or null response.");
            return null;
        }
    } catch (IOException ex) {
        System.out.println("Error connecting to or communicating with the server: " + ex.getMessage());
        ex.printStackTrace();
        return null;
    }
}



 public static String fetchRevenusData() {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send the command to the server to fetch revenue data
            out.println("GET_REVENUS_DATA");

            // Read the server's response
            String response = input.readLine();
            if (response == null || response.isEmpty()) {
                System.out.println("No response or empty response from the server.");
                return null;
            }
            return response;  // Return the response to the caller

        } catch (IOException ex) {
            System.out.println("Error connecting to or communicating with the server: " + ex.getMessage());
            return null;  // Return null in case of error
        }
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public static void  sendAnalysisResult(String message) {
        try (Socket socket = new Socket(Server_Ip, Server_Port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send the analysis data to the server
            out.println("SEND_ANALYSIS_RESULTS " + message);

            // Receive and print the server response
            String response = input.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }

 
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 


 
 public static String fetchPatientAndAnalysisDetails() {
   

    try (Socket socket = new Socket(Server_Ip, Server_Port);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        // Send a general command to fetch all patient and analysis details
        out.println("GET_ALL_PATIENT_ANALYSIS_DETAILS");

        // Read the server's response
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = input.readLine()) != null) {
            response.append(line).append("\n");
        }

        if (response.length() == 0) {
            System.out.println("No response or empty response from the server.");
            return null;
        }
        return response.toString();  // Return the complete response to the caller

    } catch (IOException ex) {
        System.out.println("Error connecting to or communicating with the server: " + ex.getMessage());
        return null;  // Return null in case of error
    }
}


}
