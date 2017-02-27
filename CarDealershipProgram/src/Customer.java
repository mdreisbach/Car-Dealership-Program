//Made by Miles and Kyle

public class Customer {
	private String name;
	private String address;
	private String customerID;
	private int accountNumber;
	private String phoneNumber;
 
	// Constructor
	public Customer(String n, String ad, String id, int ac, String pn) {
		name = n;
		address = ad;
		customerID = id;
		accountNumber = ac;
		phoneNumber = pn;
	}

	// Getters and Setters below
	public String getName() {
		return name;
	}

	public String setname(String name) {
		this.name = name;
		return this.name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return customerID;
	}

	public void setcustomerID(String id) {
		customerID = id;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int ac) {
		accountNumber = ac;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String number) {
		phoneNumber = number;
	}

}
