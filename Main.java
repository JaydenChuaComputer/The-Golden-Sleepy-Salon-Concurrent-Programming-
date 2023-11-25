/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ccp_assignment_final;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User10
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create a new Salon
        Salon salon = new Salon();

        // Create a new customer generator to generate customer with its thread
        CustomerGenerator newCustomer = new CustomerGenerator(salon);
        Thread threadNewCustomer = new Thread(newCustomer);
        threadNewCustomer.start();

        // Create 3 new hairdresser
        Hairdresser hairdresser1 = new Hairdresser(salon, "1");
        Hairdresser hairdresser2 = new Hairdresser(salon, "2");
        Hairdresser hairdresser3 = new Hairdresser(salon, "3");

        // Create hairdresser thread
        Thread threadHairdresser1 = new Thread(hairdresser1);
        Thread threadHairdresser2 = new Thread(hairdresser2);
        Thread threadHairdresser3 = new Thread(hairdresser3);

        // Run hairdresser thread
        threadHairdresser1.start();
        threadHairdresser2.start();
        threadHairdresser3.start();

        // Set alive to be true while hairdresser thread is running
        boolean alive1 = true;
        boolean alive2 = true;
        boolean alive3 = true;

        // Check if hairdresser thread is terminated
        while (alive1 || alive2 || alive3) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            alive1 = threadHairdresser1.getState() != Thread.State.TERMINATED;
            alive2 = threadHairdresser2.getState() != Thread.State.TERMINATED;
            alive3 = threadHairdresser3.getState() != Thread.State.TERMINATED;
        }

        // If hairdresser thread is terminated, salon will close
        System.out.println(salon.getTime() + "Salon:\t\t" + "All customers have left the salon.");
        System.out.println(salon.getTime() + "Salon:\t\t" + "All hairdressers are sleeping.");
        System.out.println(salon.getTime() + "Salon:\t\t" + "Salon Close.");
    }
}
