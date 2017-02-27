//Made by Miles and Kyle
//CSC 210
//5.10.16
//Christopher Pascucci

import java.util.List;
import java.util.Scanner;

public class DealershipProgram {

	public static void main(String[] args) {
		Scanner kbdScanner = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		SalesAssociate employee = null;
		
		boolean continueLoop = true;
		do {
			
			if (employee == null) {
				do {
					System.out.print("Please enter your associate id: ");
					String id = kbdScanner.next();
					employee = CarDealershipSystem.checkAssociate(id);
				} while (employee == null);

				do {
					System.out.print("Please enter your associate pass: ");
					String pass = kbdScanner.nextLine();

					if (employee.getPassword().equals(pass))
						break;
				} while (true);
			}

			System.out.println("Please enter a number to complete one of the following action(1-7): ");
			System.out.println("1) Search inventory");
			System.out.println("2) Remove cars from inventory");
			System.out.println("3) Add cars to inventory");
			System.out.println("4) Record transaction");
			System.out.println("5) View sold cars");
			System.out.println("6) View total sales");
			System.out.println("7) Exit");

			int option = kbdScanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Please enter the make: ");
				String CarModel = input.nextLine().trim();
				System.out.println("Enter the model: ");
				String CarMake = input.nextLine();

				List<Car> matched = CarDealershipSystem.FindCars(CarMake,
						CarModel);

				if (matched.isEmpty()) {
					System.out
							.println("No cars with that precedent were found.");
				} else {
					System.out.println("List of matched cars: ");
				}
				for (Car car : matched) {
					System.out.println("\tVin: " + car.getVin() + ", Model: "
							+ car.getModel() + ", Color: " + car.getColor()
							+ ", Make: " + car.getMake() + ", Year: "
							+ car.getYear() + ", Price: " + car.getPrice());
				}
				break;

			case 2:

				Car car = null;
				do {
					System.out
							.print("Enter the VIN Number of the car you are removing: ");
					String vin = input.nextLine();
					car = CarDealershipSystem.getCar(vin);
					if (car == null)
						System.out.println("Car cannot be found: ");
				} while (car == null);
				
				CarDealershipSystem.removeCar(car);
				break;

			case 3:
				System.out.print("Enter a car VIN Number: ");
				String Vin = input.nextLine();
				System.out.print("Enter the car model: ");
				String Model = input.nextLine();
				System.out.print("Enter the car color: ");
				String color = input.nextLine();
				System.out.print("Enter the car make: ");
				String Make = input.nextLine();
				System.out.print("Enter the car's year: ");
				int year = input.nextInt();
				System.out.print("Enter the cars' price: ");
				double price = input.nextDouble();

				Car newCar = new Car(Make, Model, year, color, Vin, price);
				Car anotherCar = new Car (Make, Model, year, color, Vin, price);
				CarDealershipSystem.setCar(newCar, anotherCar);
				break;

			case 4:
				System.out.println("Enter a VIN Number for the car being sold: ");
				String vin = input.nextLine();
				car = CarDealershipSystem.getCar(vin);

				System.out.print("Please enter the customer's name: ");
				String name = input.nextLine();

				System.out.print("Please enter the customer's address: ");
				String address = input.nextLine();
				System.out.print("Please enter the customer's account number: ");
				int acn = input.nextInt();
				System.out.print("Please enter the customer's phone number: ");
				String phoneNumber = input.nextLine();

				String id = null;
				Customer customer = new Customer(name, address, id, acn,phoneNumber);

				CarDealershipSystem.transactionCollection(car, employee,
						customer);
				break;

			case 5:
				List<Car> soldCars = CarDealershipSystem.getSoldCars();

				System.out.println("Cars Sold: ");

				for (Car c : soldCars) {
					System.out.println("Vin: " + c.getVin() + ", Model: "
							+ c.getModel() + ", Color: " + c.getColor()
							+ ", Make: " + c.getMake() + ", Year: "
							+ c.getYear() + ", Price: " + c.getPrice());
				}
				break;

			case 6:
				int total = 0;
				for (SalesAssociate s : CarDealershipSystem.people) {
					System.out.println(s.getName() + ", " + s.gettotalSales());
					total += s.gettotalSales();
				}

				System.out.println("Total cars sold:" + total);
				break;

			case 7:
				System.out.println("Thank you for shopping!");
				continueLoop = false;
				System.exit(0);
			default:
				continueLoop = false;
			}

		} while (continueLoop);

		kbdScanner.close();
	}
}