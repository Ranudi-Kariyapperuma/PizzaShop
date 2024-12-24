/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.order;

import pizzashop.notification.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Pizza pizza;
    private int quantity;
    private OrderState currentState;
    private List<NotificationObserver> observers = new ArrayList<>();

    // Default constructor
    public Order() {
        this.currentState = new PlacedState();
    }

    // New constructor for favorite pizza orders
    public Order(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.currentState = new PlacedState();
    }

    // Method to display order details
    public void displayOrder() {
        if (pizza != null) {
            System.out.println("\nOrder Details:");
            pizza.displayOrder();
            System.out.println("Quantity: " + quantity);
        }
    }

    // Update the state of the order
    public void updateState() {
        currentState.next(this);
        notifyObservers();  // Notify observers about the state change
    }

    // Add observer to the list
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    // Remove observer from the list
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about the order status change
    private void notifyObservers() {
        String status = "Order is " + currentState.getClass().getSimpleName();
        for (NotificationObserver observer : observers) {
            observer.notifyOrderStatusChange(status);
        }
    }

    // Getter and Setter for currentState
    public OrderState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }
}
