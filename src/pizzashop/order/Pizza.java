/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.order;

import java.util.List;

public class Pizza {
    public String crust;
    public String sauce;
    public String cheese;
    public List<String> toppings;  // Use List<String> for multiple toppings
    public String name;

    // Constructor
    public Pizza(String crust, String sauce, String cheese, List<String> toppings, String name) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
        this.name = name;
    }

    // Display the pizza order details
    public void displayOrder() {
        System.out.println("\nYour Pizza Order:");
        System.out.println("Name: " + name);
        System.out.println("Crust: " + crust);
        System.out.println("Sauce: " + sauce);
        System.out.println("Cheese: " + cheese);
        System.out.println("Toppings: " + String.join(", ", toppings)); // Join toppings into a string
    }

    // Override toString() for easier representation of Pizza details
    @Override
    public String toString() {
        return "Name: " + name +
               ", Crust: " + crust +
               ", Sauce: " + sauce +
               ", Cheese: " + cheese +
               ", Toppings: " + String.join(", ", toppings);
    }
}


