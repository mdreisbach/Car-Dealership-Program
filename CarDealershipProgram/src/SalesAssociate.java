//Made by Miles and Kyle


public class SalesAssociate {
	private String name;
	private String address;
	private double totalSales;
	private String salesAssociateID;
	private String password;

	// Constructor
	public SalesAssociate(String n, String ad, double sales, String id,
			String pword) {
		name = n;
		address = ad;
		totalSales = sales;
		salesAssociateID = id;
		password = pword;
	}

	// Getters and Setters below
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double gettotalSales() {
		return totalSales;
	}

	public void setTotalSales(double sales) {
		totalSales += sales;
	}

	public String getId() {
		return salesAssociateID;
	}

	public void setSalesAssociateID(String id) {
		salesAssociateID = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pword) {
		password = pword;
	}
}
