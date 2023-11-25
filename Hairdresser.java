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

// This class represent a hairdresser in the salon
public class Hairdresser implements Runnable {

    private Salon salon;
    private String name;
    private boolean sleeping = true;

    public Hairdresser(Salon salon, String name) {
        this.salon = salon;
        this.name = "Hairdresser " + name;
    }

    // Set the status of sleeping of hairdresser
    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    // Set the name of hairdresser
    public String getName() {
        return name;
    }

    // Check the status of sleeping of hairdresser
    public boolean isSleeping() {
        return sleeping;
    }

    // The main run method of the hairdresser thread
    public void run() {
        System.out.println(salon.getTime() + "Hairdresser: \t" + getName() + " is sleeping on sofa.");

        doingSth();
    }

    // Hairdresser starts to work
    public synchronized void doingSth() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (!salon.customerSittingQueue.isEmpty()) {
            salon.cutHair(this);
        }
        
        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(salon.getTime() + "Hairdresser: \t" + getName() + " "
                + "find that there are no more customer waiting in the salon.");
        
        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(salon.getTime() + "Hairdresser: \t" + getName() + " go to sleep on the sofa. ");
        setSleeping(true);
    }
}
