/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzashop.feedback;

public class FeedbackCommand {
    private String feedback;

    public FeedbackCommand(String feedback) {
        this.feedback = feedback;
    }

    public void execute() {
        System.out.println("Thank you for your feedback: \"" + feedback + "\"");
    }
}

