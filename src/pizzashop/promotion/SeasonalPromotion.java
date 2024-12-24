/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.promotion;

public class SeasonalPromotion {
    private PromotionHandler handler;

    public SeasonalPromotion() {
        handler = new WinterPromotion(new SummerPromotion(null));
    }

    public void applyPromotion() {
        handler.handlePromotion();
    }
}

abstract class PromotionHandler {
    protected PromotionHandler next;

    public PromotionHandler(PromotionHandler next) {
        this.next = next;
    }

    public abstract void handlePromotion();
}

class WinterPromotion extends PromotionHandler {
    public WinterPromotion(PromotionHandler next) {
        super(next);
    }

    @Override
    public void handlePromotion() {
        System.out.println("Christmas Promotion: Buy one pizza, get a small one free!");
        if (next != null) next.handlePromotion();
    }
}

class SummerPromotion extends PromotionHandler {
    public SummerPromotion(PromotionHandler next) {
        super(next);
    }

    @Override
    public void handlePromotion() {
        System.out.println("Happy New Year Promotion: 15% off on all orders!");
        if (next != null) next.handlePromotion();
    }
}

