/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.user;

import pizzashop.order.Pizza;

public class UserProfile {
    private String userName;
    private UserFavorites userFavorites;

    public UserProfile(String userName) {
        this.userName = userName;
        this.userFavorites = new UserFavorites();
        System.out.println("Welcome, " + userName + "! Your profile has been created.");
    }

    public void addFavorite(Pizza pizza) {
        userFavorites.addFavorite(pizza);
    }

    public void displayFavorites() {
        userFavorites.displayFavorites();
    }

    public Pizza reorderFavorite(int index) {
        return userFavorites.reorderFavorite(index);
    }
}

