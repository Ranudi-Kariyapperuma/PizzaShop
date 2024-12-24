/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.order;

public class PreparedState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Order is prepared. Now delivering...");
        order.setCurrentState(new DeliveredState()); 
    }
}
