/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotrmi;

import chatbotrmi.translate.Translate;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author roy
 */
public class ChatBotRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("translate", new Translate());
            System.out.println("server berhasil dijalankan");
        } catch (RemoteException re) {
            System.err.println("server rmi gagal dijalankan");
            System.err.println(re.getMessage());
        }
    }
    
}
