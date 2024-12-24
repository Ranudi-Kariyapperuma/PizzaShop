/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.notification;

public class NotificationService implements NotificationObserver {

    private String orderStatus;//oredr

    @Override
    public void notifyOrderStatusChange(String orderStatus) {
        this.orderStatus = orderStatus;
        System.out.println("Notification: " + orderStatus);  // Notify the user about the order status change
    }

    public void updateStatus(String status) {
        notifyOrderStatusChange(status); // Using notifyOrderStatusChange for updating status
    }
}

