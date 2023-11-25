/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccp_assignment_final;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User10
 */
public class Salon {

    // Set number of space (sitting and standing) and number of tools (combs and scissors) in the salon
    private final int space = 5;
    private final int gold = 2;

    // Set the queue for space and tools
    LinkedBlockingQueue<Customer> customerSittingQueue = new LinkedBlockingQueue<>(space);
    LinkedBlockingQueue<Customer> customerStandingQueue = new LinkedBlockingQueue<>(space);
    LinkedBlockingQueue<String> goldScissorsQueue = new LinkedBlockingQueue<>(gold);
    LinkedBlockingQueue<String> goldCombQueue = new LinkedBlockingQueue<>(gold);

    public Salon() {
        try {
            // Prepare gold scissors and combs to queue
            goldScissorsQueue.put("Gold Scissors 1");
            goldScissorsQueue.put("Gold Scissors 2");
            goldCombQueue.put("Gold Comb 1");
            goldCombQueue.put("Gold Comb 2");
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Salon: \t\tGold Scissors 1 and Gold Scissors 2 is prepared ready on the shelf.");
        System.out.println(getTime() + "Salon: \t\tGold Comb 1 and Gold Comb 2 is prepared ready on the shelf.");
    }

    public void cutHair(Hairdresser hairdresser) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        Customer customer = null;
        String scissors = null;
        String comb = null;
        Customer movingCustomer = null;

        try {
            // Attempt to get a customer, scissors and comb from queue
            customer = customerSittingQueue.poll();
            scissors = goldScissorsQueue.take();
            comb = goldCombQueue.take();

            // End process if no customer be taken
            if (customer == null) {
                return;
            }

            // Attempt to move a standing customer to sit on chair
            if (!customerStandingQueue.isEmpty()) {
                movingCustomer = customerStandingQueue.poll();

                System.out.println(getTime() + "Customer: \tStanding customer " + movingCustomer.getName() + " "
                        + "found an empty chair.");

                try {
                    TimeUnit.NANOSECONDS.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(getTime() + "Customer: \t" + movingCustomer.getName() + " sit on waiting chair.");

                customerSittingQueue.put(movingCustomer);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Customer attempt to awake hairdresser if hairdresser is sleeping
        if (hairdresser.isSleeping()) {
            System.out.println(getTime() + "Customer: \t" + customer.getName() + " "
                    + "awake " + hairdresser.getName() + ".");
            hairdresser.setSleeping(false);

            try {
                TimeUnit.NANOSECONDS.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " awake.");
        }

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " takes "
                + scissors + " and " + comb + " from the shelf.");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                + "sit on " + hairdresser.getName() + "'s chair.");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + " "
                + "sit on " + hairdresser.getName() + "'s salon chair.");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + " is ready to cut hair now.");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " starts to cut hair for "
                + "" + customer.getName() + ".");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Generate random duration of hairdresser cut hair for customer
        long duration = (long) (Math.random() * 4 + 3);

        // Hairdresser cutting hair for customer
        try {
            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                    + "is cutting hair for " + customer.getName() + ". (0% done)");
            TimeUnit.SECONDS.sleep(duration / 4);
            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                    + "is cutting hair for " + customer.getName() + ". (25% done)");
            TimeUnit.SECONDS.sleep(duration / 4);
            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                    + "is cutting hair for " + customer.getName() + ". (50% done)");
            TimeUnit.SECONDS.sleep(duration / 4);
            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                    + "is cutting hair for " + customer.getName() + ". (75% done)");
            TimeUnit.SECONDS.sleep(duration / 4);
            System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                    + "completed cutting hair for " + customer.getName() + " in " + duration + " seconds.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Scissors and comb is returning back to queue
        try {
            goldScissorsQueue.put(scissors);
            goldCombQueue.put(comb);
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + " "
                + "keeps " + scissors + " and " + comb + " back to the shelf.");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Hairdresser: \t" + hairdresser.getName() + 
                " received payment Rm " + duration * 10 + " from " + customer.getName() + ".");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + 
                " finish cut hair and paid RM " + duration * 10 + " to " + hairdresser.getName() + ".");

        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + " leaves the salon.");
    }

    public void addCustomer(Customer customer) {
        System.out.println(getTime() + "Customer: \t" + customer.getName() + " entering the salon. ");

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hairdresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean addedSitting = false, addedStanding = false;

        // Attempt to add a new customer into sitting queue
        addedSitting = customerSittingQueue.offer(customer);

        if (addedSitting) {
            System.out.println(getTime() + "Customer: \t" + customer.getName() + " found an empty chair.");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(getTime() + "Customer: \t" + customer.getName() + " sit on waiting chair.");
            return;
        }

        // Attempt to add a new customer into standing queue
        addedStanding = customerStandingQueue.offer(customer);

        if (addedStanding) {
            System.out.println(getTime() + "Customer: \t" + customer.getName() + " sees that no more empty chair "
                    + "in the salon.");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(getTime() + "Customer: \t" + customer.getName() + " stands behind the chair.");
            return;
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + " sees that no more space to stand "
                + "in the salon.");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getTime() + "Customer: \t" + customer.getName() + " leaves the salon.");
    }

    // Get time to display at the front of output
    public String getTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "[" + format.format(LocalTime.now()) + "]\t";
    }
}
