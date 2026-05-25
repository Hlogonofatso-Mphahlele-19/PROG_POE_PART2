
package chatapplication;

import java.util.Scanner;

public class Chatapplication {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("   REgister Account   ");
        
        System.out.print("Enter your first name: ");
        String firstName = kb.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = kb.nextLine();
        
        System.out.print("Enter your username: ");
        String username = kb.nextLine();
        
        System.out.print("Enter your password: ");
        String password = kb.nextLine();
        
        System.out.print("Enter your South African cellphone number (+27 followed by 9 numbers): ");
        String saCellNumber = kb.nextLine();
        
        
        Login user = new Login(username, password, saCellNumber);
        String registrationResult = user.registerUSer();
        System.out.println("\n" + registrationResult);
        
        if (registrationResult.equals("User registered successfully")) {
            System.out.println("=== Login ===");
            
            System.out.print("Enter username: ");
            String loginUser = kb.nextLine();
            
            System.out.print("Enter password: ");
            String loginPass = kb.nextLine();
            
            boolean success = user.loginUser( loginUser, loginPass);
            System.out.println(user.returnLoginStatus(success, firstName, lastName));
            
        }     
        
        if (success) {
            System.out.println("\nWelcome to QuickChat");
            
            System.out.print("How many messages would u like to sent");
            int numOfMessages =kb.nextInt();
            kb.nextLine();
            
            int count = 0;
            while (true) {
                System.out.println("/nMenu:");
                System.out.println("1) Send Message");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quot");
                System.out.print("Choose an option: ");
                int optionChoice = kb.nextInt();
                kb.nextLine();
                   
                if(optionChoice == 1) {
                    if(count < numOfMessages) {
                        System.out.print("Enter recipient number: ");
                        String recipient = kb.nextLine();
                        
                        System.out.print("Enter message: ");
                        String messageText = kb.nextLine();
                        
                        Message msg = new Message(recipient, messageText);
                        
                        System.out.println(msg.checkRecipientCell());
                        System.out.println(msg.validateMessageLength());
                        
                        System.out.println("Choose an option: 1) Send Message 2) Discard Message");
                        int action = kb.nextInt();
                        kb.nextLine();
                        System.out.println(msg.sendMessage(action));
                        
                        if(action == 1) {
                            System.out.println(msg.toString());
                        }
                        
                        count++;
                    } else {
                        System.out.println("You've reached the maximum limit of the message u can send");
                    }
                } else if (optionChoice == 2) {
                    System.out.println("Coming soon");
                } else if (optionChoice == 3) {
                    System.out.println("Total Messages sent: ");
                    break;
                } else {
                    System.out.println("Invalid option. Try agin");
                }
            }
        }
        kb.close();
       
    }
    
}
