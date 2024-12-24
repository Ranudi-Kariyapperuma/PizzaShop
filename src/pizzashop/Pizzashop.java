/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pizzashop;

import java.util.Arrays;
import java.util.Scanner;
import pizzashop.decorator.ExtraToppingDecorator;
import pizzashop.decorator.SpecialPackagingDecorator;
import pizzashop.order.Pizza;
import pizzashop.order.PizzaBuilder;
import pizzashop.order.Order;
import pizzashop.payment.CreditCardPayment;
import pizzashop.payment.LoyaltyProgramDecorator;
import pizzashop.feedback.FeedbackCommand;
import pizzashop.payment.DebitCardPayment;
import pizzashop.payment.PaymentStrategy;
import pizzashop.user.UserProfile;
import pizzashop.promotion.SeasonalPromotion;
import pizzashop.notification.NotificationService; 

/**
 *
 * @author HP
 */
public class Pizzashop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

          Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Shop!");

        // User Profile Creation
        System.out.println("\nEnter your name:");
        String userName = scanner.nextLine();
        UserProfile user = new UserProfile(userName);

        // 3.1 Pizza Customization
        System.out.println("\nLet's customize your pizza:");
        System.out.println("Choose your crust: (1) Thin Crust (2) Thick Crust");
        String crust = scanner.nextInt() == 1 ? "Thin Crust" : "Thick Crust";

        System.out.println("Choose your sauce: (1) Tomato (2) Barbecue");
        String sauce = scanner.nextInt() == 1 ? "Tomato" : "Barbecue";

        System.out.println("Choose your cheese: (1) Mozzarella (2) Cheddar");
        String cheese = scanner.nextInt() == 1 ? "Mozzarella" : "Cheddar";

        System.out.println("Choose your toppings: (1) Olives & Mushrooms (2) Pepperoni & Jalapenos");
        String toppings = scanner.nextInt() == 1 ? "Olives & Mushrooms" : "Pepperoni & Jalapenos";

        // Create pizza using builder pattern
        Pizza pizza = new PizzaBuilder()
                .setName("Custom Pizza")
                .setCrust(crust)
                .setSauce(sauce)
                .setCheese(cheese)
                .setToppings(Arrays.asList(toppings.split("&")))  // Using multiple toppings
                .build();

       // Display the initial pizza order
        System.out.println("Your initial pizza order:");
        pizza.displayOrder();

        // Ask the user if they want extra toppings
System.out.println("\nDo you want to add extra toppings? (1) Yes (2) No");
String choice = scanner.nextLine().trim();

// Process the user's choice for extra toppings
while (true) {
    if (choice.equals("1")) {
        System.out.print("Enter the extra topping: ");
        String extraTopping = scanner.nextLine().trim();
        pizza = new ExtraToppingDecorator(pizza, extraTopping);
        System.out.println("Extra topping added: " + extraTopping);
        break; // Exit the loop after valid input
    } else if (choice.equals("2")) {
        System.out.println("No extra toppings added.");
        break; // Exit the loop after valid input
    } else {
        choice = scanner.nextLine().trim();// Ask again if invalid input is entered
    }
}

// Ask the user if they want special packaging
System.out.println("\nDo you want special packaging? (1) Yes (2) No");
choice = scanner.nextLine().trim();

// Process the user's choice for special packaging
  while (true) {
    if (choice.equals("1")) {
        System.out.print("Enter the packaging type: ");
        String packagingType = scanner.nextLine().trim();
        pizza = new SpecialPackagingDecorator(pizza, packagingType);
        System.out.println("Special packaging added: " + packagingType);
        break; // Exit the loop after valid input
    } else if (choice.equals("2")) {
        System.out.println("No special packaging selected.");
        break; // Exit the loop after valid input
    } else {
        System.out.println("Invalid input. Please enter '1' for Yes or '2' for No.");
        System.out.println("\nDo you want special packaging? (1) Yes (2) No");
        choice = scanner.nextLine().trim(); // Ask again if invalid input is entered
    }
}

        System.out.println("\nYour final pizza order:");
        pizza.displayOrder();
        
        // 3.2 Ordering Process
        System.out.println("\nDo you want to save this pizza as your favorite? (1) Yes (2) No");
        if (scanner.nextInt() == 1) {
            user.addFavorite(pizza);
        }

        // 3.3 User Profiles and Favorites
        System.out.println("\nYour favorites:");
        user.displayFavorites();

        // Reorder a favorite pizza or exit
        System.out.println("\nWould you like to reorder one of your favorite pizzas? (1) Yes (2) No");
        int reorderChoice = scanner.nextInt();
        Pizza reorderedPizza = null;

        if (reorderChoice == 1) {
            System.out.println("\nEnter the number of the favorite pizza to reorder:");
            int favoriteChoice = scanner.nextInt();
            reorderedPizza = user.reorderFavorite(favoriteChoice);

            if (reorderedPizza != null) {
                System.out.println("\nReordered Pizza:");
                reorderedPizza.displayOrder();
            } else {
                System.out.println("Invalid favorite pizza choice. Please try again.");
            }
        } else {
            // If the user chooses "No", display the custom pizza instead
            System.out.println("\nYour order is:");
            pizza.displayOrder();
        }

        // 3.4 Real-Time Order Tracking (using State Pattern and Observe Patten)
        System.out.println("\nProcessing your order...");
                Order order = new Order(reorderedPizza, 1);
                
                // Creating NotificationService (Observer)
                NotificationService notificationService = new NotificationService();

                // Add observer to the order
                order.addObserver(notificationService);

                // Transition: Order Placed to Prepared
                order.updateState();  // This will print: "Order is placed. Now preparing..." this is state
                notificationService.updateStatus("Your order is now being prepared!");  // Notify the user

                // Transition: Order Prepared to Delivered
                order.updateState();  // This will print: "Order is prepared. Now delivering..." this is state
                notificationService.updateStatus("Your order is now being delivered!");  // Notify the user

                // Display the order details after all state transitions
                order.displayOrder();

        // 3.5 Payment and Loyalty Program
        System.out.println("\nChoose payment method:");
        System.out.println("(1) Credit Card");
        System.out.println("(2) Debit Card");

        int paymentChoice = scanner.nextInt();
        PaymentStrategy payment = null;
        if (paymentChoice == 1) {
            payment = new CreditCardPayment();
        } else if (paymentChoice == 2) {
            payment = new DebitCardPayment();
        } else {
            System.out.println("Invalid choice. Defaulting to Credit Card.");
            payment = new CreditCardPayment();
        }

        LoyaltyProgramDecorator loyaltyPayment = new LoyaltyProgramDecorator(payment);
        loyaltyPayment.pay(25.0); 

        // 3.6 Seasonal Promotions
        System.out.println("\nChecking for promotions...");
        SeasonalPromotion promotion = new SeasonalPromotion();
        promotion.applyPromotion();

        // 3.7 Feedback and Ratings
        System.out.println("\nDo you want to leave feedback? (1) Yes (2) No");
        if (scanner.nextInt() == 1) {
            scanner.nextLine(); 
            System.out.println("Enter your feedback:");
            String feedbackText = scanner.nextLine();
            FeedbackCommand feedback = new FeedbackCommand(feedbackText);
            feedback.execute();
        }

        System.out.println("\nThank you for visiting the Pizza Shop!");
        scanner.close();
    }
}
