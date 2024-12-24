/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.order;

import java.util.List;

public class PizzaBuilder {
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    private String name;

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder setToppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }

    public PizzaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Pizza build() {
        return new Pizza(crust, sauce, cheese, toppings, name);
    }
}
