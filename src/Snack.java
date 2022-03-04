
public class Snack {
	private String name;
	private double cost;
	
	public Snack(String name, double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}
	
	public String getCostFormatted() {
		return String.format("$%.2f", cost);
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("%s: $%.2f", name, cost);
	}
	
	public static Snack of(String name, double cost) {
		return new Snack(name, cost);
	}
}
