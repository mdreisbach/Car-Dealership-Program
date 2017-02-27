//Made by Miles and Kyle

public class Transaction {
	private String date;
	private String time;
	private double cost;
	private Customer customer;
	private Car car;
	private SalesAssociate employee;

	// Constructor
	public Transaction(Customer customer,
			Car car, SalesAssociate employee, String time) {
		this.customer = customer;
		this.car = car;
		this.employee = employee;
		this.time = time;
	}

	// Getters and Setters below
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public SalesAssociate getEmployee() {
		return employee;
	}

	public void setSalesAssociate(SalesAssociate employee) {
		this.employee = employee;
	}

}
