//Made by Miles and Kyle

public class Car {
	// private class variables
	private  String make;
	private  String model;
	private  int year;
	private  String color;
	private  String vin;
	private  double price;

	// Constructor
	public Car(String m, String mo, int y, String co, String v, double p) {
		make = m;
		model = mo;
		year = y;
		color = co;
		vin = v;
		price = p;
	}

	// Getters and Setters below
	public  String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public  String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public  int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public  String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public  String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public  double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
