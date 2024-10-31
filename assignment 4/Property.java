public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;

	// Constructors
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}

	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	// Getters
	public String getCity() { return city; }
	public String getOwner() { return owner; }
	public String getPropertyName() { return propertyName; }
	public double getRentAmount() { return rentAmount; }
	public Plot getPlot() { return plot; }

	// Setters
	public void setCity(String city) { this.city = city; }
	public void setOwner(String owner) { this.owner = owner; }
	public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
	public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

	public void setPlot(int x, int y, int width, int depth) {
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
	}

	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
