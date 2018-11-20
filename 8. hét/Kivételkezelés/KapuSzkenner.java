/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kapuszkenner;

/**
 *
 * @author Liliane
 */
public class KapuSzkenner {
    
    public static void main(String[] args) {
        
        for(int i=0; i<1024; ++i)
            
            try {
                
                java.net.Socket socket = new java.net.Socket(args[0], i);
                
                System.out.println(i + " figyeli");
                
                socket.close();
                
            } catch (Exception e) {
                
                System.out.println(i + " nem figyeli");
                
            }
    }
    
}

