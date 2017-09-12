/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotjavarmiclient;

import common.SaySomething;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.scene.transform.Translate;

/**
 *
 * @author roy
 */
public class ChatBotJavaRMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
 
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SaySomething saySomething1 = (SaySomething) registry.lookup("translate");
            
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            boolean masihChat = true;
            System.out.println("Silahkan mulai chat dengan bot kami");
            while(masihChat){
                String chatFromClient = reader.readLine();
                if(chatFromClient.equals("selesai")){
                    masihChat=false;
                }else{
                     try {
                         System.out.println("Server : "+saySomething1.saySomething(chatFromClient));             
                        
                    } catch (Exception e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                    }
                }                
            }
            System.out.println("Terima kasih telah menggunakan jasa kami");
            
                
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (AccessException ex) {
            ex.printStackTrace();
        } catch (RemoteException re) {
            System.err.println("tak bisa terkoneksi ke server");
        }
    }
    
}
