/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.user;

import pizzashop.order.Pizza;

import java.util.ArrayList;
import java.util.List;

public class UserFavorites {
    private List<Pizza> favoritePizzas;

    public UserFavorites() {
        this.favoritePizzas = new ArrayList<>();
    }

    // Add a pizza to the favorites list
    public void addFavorite(Pizza pizza) {
        favoritePizzas.add(pizza);
        System.out.println("\nPizza added to your favorites!");
    }

    // Display all favorite pizzas
    public void displayFavorites() {
        if (favoritePizzas.isEmpty()) {
            System.out.println("\nNo favorite pizzas saved yet!");
            return;
        }

        System.out.println("\nYour Favorite Pizzas:");
        for (int i = 0; i < favoritePizzas.size(); i++) {
            System.out.println((i + 1) + ". " + favoritePizzas.get(i));
        }
    }

    // Reorder a favorite pizza by index
    public Pizza reorderFavorite(int index) {
        if (index < 1 || index > favoritePizzas.size()) {
            System.out.println("\nInvalid choice! No such favorite exists.");
            return null;
        }
        System.out.println("\nReordering favorite pizza: " + favoritePizzas.get(index - 1));
        return favoritePizzas.get(index - 1);
    }
}


