/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.order;

public interface OrderObserver {
    void update(String orderStatus);  // Method to notify observers of state changes
}

