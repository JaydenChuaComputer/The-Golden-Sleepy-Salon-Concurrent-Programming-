/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccp_assignment_final;

/**
 *
 * @author User10
 */

// This class represent a customer in the salon
class Customer implements Runnable {

    private String name;
    private Salon salon;

    public Customer(Salon salon) {
        this.salon = salon;
    }

    // Check the name of hairdresser
    public String getName() {
        return name;
    }

    // Set the name of customer
    public final void setName(String name) {
        this.name = name;
    }

    // The main run method of the customer thread
    public void run() {
        enterSalon();
    }

    // Customer starts to do the thing they wanted to do
    public synchronized void enterSalon() {
        salon.addCustomer(this);
    }
}
