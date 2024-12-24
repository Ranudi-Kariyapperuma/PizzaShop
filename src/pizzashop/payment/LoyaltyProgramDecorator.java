/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.payment;

public class LoyaltyProgramDecorator implements PaymentStrategy {
    private PaymentStrategy paymentStrategy;

    public LoyaltyProgramDecorator(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(double amount) {
        double discountedAmount = amount * 0.9; // 10% discount for loyalty program
        paymentStrategy.pay(discountedAmount);
        System.out.println("You received a 10% discount through our loyalty program!");
    }
}
