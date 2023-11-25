/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccp_assignment_final;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User10
 */
public class CustomerGenerator implements Runnable {

    Salon salon;
    private int customerCount = 0;

    public CustomerGenerator(Salon salon) {
        this.salon = salon;
    }

    // The main run method of the customer generator thread
    public void run() {
        while (customerCount < 20) {
            customerCount++;

            Customer customer = new Customer(salon);
            customer.setName("Customer " + customerCount);

            Thread customerThread = new Thread(customer);
            customerThread.start();

            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 3));
            } catch (InterruptedException ex) {
                Logger.getLogger(CustomerGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
