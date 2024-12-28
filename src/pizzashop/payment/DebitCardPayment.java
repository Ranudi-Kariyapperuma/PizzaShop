/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.payment;


public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        
        System.out.println("Processing Debit Card payment of $" + amount);

    
        try {
            
            System.out.println("Connecting to bank...");
            Thread.sleep(1000); 
            System.out.println("Payment successful via Debit Card!");
        } catch (InterruptedException e) {
            System.out.println("Payment process was interrupted.");
        }
    }
}

