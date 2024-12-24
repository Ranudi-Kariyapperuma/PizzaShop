/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.decorator;

import pizzashop.order.Pizza;

public class SpecialPackagingDecorator extends PizzaDecorator {
    private String packagingType;

    public SpecialPackagingDecorator(Pizza pizza, String packagingType) {
        super(pizza);
        this.packagingType = packagingType;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();  
        System.out.println("Adding special packaging: " + packagingType);
    }
}
