import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		String selectedSnack;
		double price;
		
		// Create snacks
		
		System.out.println("Welcome to the virtual vending machine!");
		System.out.println("What snack would you like to buy?");
		// List out all of the snacks
		selectedSnack = userIn.nextLine();
		
		// Get the price associated with the selected snack and set price equal to it
		price = 0.0; // Change this 
		System.out.println(selectedSnack + " costs $" + price);
		
		// Implement money
		
		System.out.println("Sending you your " + selectedSnack + ".");
		System.out.println("Thank you for your patronage! Come again soon!");
	}

}
