//Made by Miles and Kyle

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CarDealershipSystem {

	public static ArrayList<Car> cars = new ArrayList<Car>();
	public static ArrayList<SalesAssociate> people = new ArrayList<SalesAssociate>();
	public static ArrayList<Transaction> trades = new ArrayList<Transaction>();

	public static SalesAssociate getAssociate(String id) {
		for (SalesAssociate s : people) {
			if (s.getId().equals(id))
				return s;
		}
		return null;
	}

	// 1st bullet point
	public static ArrayList<Car> FindCars(String make, String model) {

		ArrayList<Car> foundCar = new ArrayList<Car>();
		foundCar.clear();
		for (Car car : carCollection()) {
			if (car.getModel().equals(model) && car.getMake().equals(make))
				foundCar.add(car);
		}
		return foundCar;
	}

	// 2nd bullet point
	public static ArrayList<Car> carCollection() {
		String file = "cars.txt";
		Scanner reader = null;

		try {
			reader = new Scanner(new FileReader(file));

			while (reader.hasNext()) {
				String nextLine = reader.nextLine();
				String[] parse = nextLine.split(",");

				String vin = parse[0];
				String make = parse[1];
				String model = parse[2];
				String color = parse[3];
				int year = Integer.parseInt(parse[4]);
				double price = Double.parseDouble(parse[5]);

				cars.add(new Car(make, model, year, color, vin, price));
			}

			reader.close(); // closes the stream
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file!");
			System.exit(0);
		}
		return cars;
	}

	// 3rd bullet point
	public static ArrayList<SalesAssociate> employeeCollection() {
		String file = "employees.txt";
		Scanner reader = null;

		try {
			reader = new Scanner(new FileReader(file));
			while (reader.hasNext()) {
				String nextLine = reader.nextLine();
				String[] split = nextLine.split(",");

				String name = split[0];
				String address = split[1];
				double sales = Double.parseDouble(split[2]);
				String id = split[3];
				String pass = split[4];

				people.add(new SalesAssociate(name, address, sales, id, pass));
			}
			reader.close(); // closes the stream
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file!");
			System.exit(0);
		}
		return people;
	}

	// 4th bullet point
	public static void transactionCollection(Car car, SalesAssociate employee,
			Customer person) {
		String date = "", time = "";
		SimpleDateFormat mdyDate = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat hmTime = new SimpleDateFormat("hh:mm a");
		Calendar c = Calendar.getInstance();
		time = hmTime.format(c.getTime());
		date = mdyDate.format(c.getTime());
		Transaction transaction = new Transaction(person, car, employee, date + time);
		trades.add(transaction);
	}

	// 5th bullet point
	public static void addNewTransactions(Transaction transaction) {
		Calendar c = Calendar.getInstance();

		try {
			File file = new File("./transactions.txt");

			if (!file.exists())
				file.createNewFile();

			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file,
					true));

			String output = transaction.getDate() + ","
					+ c.getTime().toString() + "," + transaction.getCustomer()
					+ "," + transaction.getCar() + ","
					+ transaction.getEmployee();

			fileWriter.write(output);

			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
		}
	}

	// 6th bullet point
	public void addCars(Car car) {

		cars.add(car);

		try {
			String file = "./cars.txt";

			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file,
					true));

			for (Car c : cars) {
				String output = c.getMake() + "," + c.getModel() + ","
						+ c.getYear() + "," + "," + c.getColor()
						+ "," + c.getVin();

				fileWriter.write(output);
				fileWriter.flush();
			}

			fileWriter.close();

		} catch (IOException e) {
		}
	}

	// 7th bullet point
	public static void addSAssociates(SalesAssociate employee) {
		people.add(employee);
		try {
			String file = "./employees.txt";

			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file,
					true));

		for (SalesAssociate workers : people){
				
			String output = workers.getName() + "," + workers.getAddress()
					+ "," + workers.gettotalSales() + "," + workers.getId()
					+ "," + workers.getPassword();
			
			fileWriter.write(output);
			fileWriter.flush();
		}
			fileWriter.close();

		} catch (IOException e) {
		}
	}

	public static Car getCar(String vin) {
		for (Car car : carCollection()) {
			if (car.getVin().equals(vin))
				return car;
		}
		return null;
	}

	public static void removeCar(Car vehicle) {
		cars.remove(vehicle);

		try {
			PrintWriter words = new PrintWriter("./cars.txt");
			for (Car car : cars)
				words.println(car.getVin() + "," + car.getMake() + "," + car.getModel() + 
						"," + car.getColor() + "," + car.getYear() + "," + car.getPrice());
			words.close();
			
		} catch (FileNotFoundException e) {
		}
	}

	public static Transaction getTrade(Car car) {
		for (Transaction trade : trades) {
			if (trade.getCar() == car)
				return trade;
		}
		return null;
	}

	public static List<Car> getSoldCars() {
		ArrayList<Car> soldCars = new ArrayList<Car>();
		for (Car car : cars) {
			Transaction transaction = getTrade(car);
			if (transaction == null)
				continue;
			soldCars.add(car);
		}
		return soldCars;
	}

	public static void setCar(Car oldCar, Car newCar) {
		if (oldCar != null && cars.contains(oldCar))
			cars.set(cars.indexOf(oldCar), newCar);
		else
			cars.add(newCar);

		try {
			PrintWriter pWriter = new PrintWriter("./cars.txt");
			for (Car automobile : cars)
				pWriter.println(automobile.getVin() + "," + automobile.getMake() + "," + automobile.getModel() + 
						"," + automobile.getColor() + "," + automobile.getYear() + "," + automobile.getPrice());
			pWriter.close();
		} catch (FileNotFoundException e) {
	}
	}

	public static SalesAssociate checkAssociate(String id) {
		for (SalesAssociate workers : employeeCollection()) {
			if (workers.getId().equalsIgnoreCase(id))
				return workers;
		}
		return null;
	}
}