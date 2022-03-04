
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		
		// Create snacks
		Snack[] snacks = new Snack[] {
			Snack.of("Pretzels", 1.25),
			Snack.of("Sunchips", 1.50),
			Snack.of("Cheetos", 1.25),
			Snack.of("Reeses", 1.60),
			Snack.of("Doritos", 1.00)
		};
		
		
		System.out.println("Welcome to the virtual vending machine!");
		
		// List out all of the snacks
		for (int i = 0; i < snacks.length; i++) {
			int itemIndex = i + 1;
			System.out.printf("%d: %s\n", itemIndex, snacks[i]);
		}
		
		System.out.println("What snack would you like to buy (enter number)?");

		
		int selectedSnackIndex = userIn.nextInt() - 1;
		
		// Get the price associated with the selected snack and set price equal to it
		Snack selectedSnack = null;
		try {
			selectedSnack = snacks[selectedSnackIndex];
		} catch (Exception e) {
			System.out.println("Invalid selection!");
			System.exit(1);
		}
		
		System.out.println(String.format("%s costs %s", selectedSnack.getName(), selectedSnack.getCostFormatted()));
		
		// Implement money
		
		System.out.println("Sending you your " + selectedSnack.getName() + ".");
		System.out.println("Thank you for your patronage! Come again soon!");
	}

}
