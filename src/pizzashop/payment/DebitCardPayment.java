/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.payment;

// DebitCardPayment implements PaymentStrategy interface
public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        // Print a message indicating Debit Card payment processing
        System.out.println("Processing Debit Card payment of $" + amount);

        // Simulate Debit Card payment logic here, like connecting to a banking API
        try {
            // Simulating payment transaction
            System.out.println("Connecting to bank...");
            Thread.sleep(1000); // Simulate delay in processing payment
            System.out.println("Payment successful via Debit Card!");
        } catch (InterruptedException e) {
            System.out.println("Payment process was interrupted.");
        }
    }
}

