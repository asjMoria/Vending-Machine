
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
		
		// Necessary
		userIn.nextLine();
		
		
		System.out.println(String.format("%s costs %s", selectedSnack.getName(), selectedSnack.getCostFormatted()));
		
		// Implement money
		int acceptedMoney = 0;
		boolean enoughMoney = false;
		while (!enoughMoney)
		{
			System.out.println("Please press \"Enter\" to add a dollar.");
			userIn.nextLine();
			boolean addMoney = (Math.random() * 5) > 1;
			if (addMoney)
			{
				System.out.println("There is now $" + ++acceptedMoney + " in the machine.");
			}
			else
			{
				System.out.println("Couldn't read bill! Please try again.");
			}
			
			if (acceptedMoney > selectedSnack.getCost())
			{
				enoughMoney = true;
			}
		}
		
		System.out.println("You have added sufficient funds.");
		System.out.println("Would you like to proceed with the transaction (y or n)?");
		String in = userIn.nextLine();
		if (in.equals("n"))
		{
			System.exit(1);
		}
		else if (!in.equals("y"))
		{
			System.out.println("Invalid Response! *eats money");
			System.exit(1);
		}
		
		System.out.println("OK! Sending you your " + selectedSnack.getName() + ".");
		
		double error = 0.005;
		double change = acceptedMoney - selectedSnack.getCost();
		int q = (int)((change + error) / 0.25);
		boolean hasQ = q > 0;
		change = change % 0.25;
		int d = (int)((change + error) / 0.10);
		boolean hasD = d > 0;
		change = change % 0.10;
		int n = (int)((change + error) / 0.05);
		boolean hasN = n > 0;
		change = change % 0.05;
		int p = (int)((change + error) / 0.01);
		boolean hasP = p > 0;
		
		String msg = "*Dispenses ";
		if (hasQ)
		{
			msg += q + " quarter";
			
			if (q > 1)
			{
				msg += "s";
			}
		}
		if (hasQ && hasD)
		{
			msg += ", ";
		}
		if (hasD)
		{
			msg += d + " dime";
			
			if (d > 1)
			{
				msg += "s";
			}
		}
		if ((hasQ || hasD) && hasN)
		{
			msg += ", ";
		}
		if (hasN)
		{
			msg += n + " nickel";
			
			if (n > 1)
			{
				msg += "s";
			}
		}
		if ((hasQ || hasD || hasN) && hasP)
		{
			msg += ", ";
		}
		if (hasP)
		{
			msg += p + " penn";
			
			if (p > 1)
			{
				msg += "ies";
			}
			else
			{
				msg += "y";
			}
		}
		msg += ".";
		
		System.out.println("Delivering " + String.format("$%.2f", acceptedMoney - selectedSnack.getCost()) + " in change...");
		System.out.println(msg);
		
		System.out.println("Thank you for your patronage! Come again soon!");
	}

}
