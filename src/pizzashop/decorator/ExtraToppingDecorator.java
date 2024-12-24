/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.decorator;

import pizzashop.order.Pizza;

public class ExtraToppingDecorator extends PizzaDecorator {
    private String extraTopping;

    public ExtraToppingDecorator(Pizza pizza, String extraTopping) {
        super(pizza);  // Pass the pizza instance to the decorator
        this.extraTopping = extraTopping;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();  // Call the base pizza's display method
        System.out.println("Adding extra topping: " + extraTopping);
    }
}
