/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.decorator;

import pizzashop.order.Pizza;

public abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        super(pizza.crust, pizza.sauce, pizza.cheese, pizza.toppings, pizza.name);
        this.pizza = pizza;
    }

    @Override
    public void displayOrder() {
        pizza.displayOrder();  // Delegating the call to the base pizza
    }
}
