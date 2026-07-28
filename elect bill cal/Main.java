import java.util.Scanner;

class Customer {
    String name;
    String consumerId;
    int units;

    Customer(String name, String consumerId, int units) {
        this.name = name;
        this.consumerId = consumerId;
        this.units = units;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Calculate electricity bill
    public static double calculateBill(int units) {

        double bill = 0;

        if (units <= 100) {
            bill = units * 1.50;
        }
        else if (units <= 200) {
            bill = (100 * 1.50) + ((units - 100) * 2.50);
        }
        else if (units <= 500) {
            bill = (100 * 1.50)
                    + (100 * 2.50)
                    + ((units - 200) * 4.00);
        }
        else {
            bill = (100 * 1.50)
                    + (100 * 2.50)
                    + (300 * 4.00)
                    + ((units - 500) * 6.00);
        }

        // Fixed Charge
        bill += 100;

        return bill;
    }

    // Print bill
    public static void printBill(Customer customer) {

        double totalBill = calculateBill(customer.units);

        System.out.println("\n==========================================");
        System.out.println("           ELECTRICITY BILL");
        System.out.println("==========================================");
        System.out.println("Customer Name : " + customer.name);
        System.out.println("Consumer ID   : " + customer.consumerId);
        System.out.println("Units Used    : " + customer.units);

        System.out.println("------------------------------------------");

        if (customer.units <= 100) {
            System.out.println("Energy Charge : $" + (customer.units * 1.50));
        } else if (customer.units <= 200) {
            System.out.println("Energy Charge : $" +
                    ((100 * 1.50) + ((customer.units - 100) * 2.50)));
        } else if (customer.units <= 500) {
            System.out.println("Energy Charge : $" +
                    ((100 * 1.50) +
                    (100 * 2.50) +
                    ((customer.units - 200) * 4.00)));
        } else {
            System.out.println("Energy Charge : $" +
                    ((100 * 1.50) +
                    (100 * 2.50) +
                    (300 * 4.00) +
                    ((customer.units - 500) * 6.00)));
        }

        System.out.println("Fixed Charge  : $100");
        System.out.println("------------------------------------------");
        System.out.printf("TOTAL BILL    : $%.2f%n", totalBill);
        System.out.println("==========================================");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===================================");
            System.out.println(" ELECTRICITY BILL CALCULATOR");
            System.out.println("===================================");
            System.out.println("1. Generate Bill");
            System.out.println("2. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter Customer Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Consumer ID   : ");
                    String id = sc.nextLine();

                    int units;

                    while (true) {

                        System.out.print("Enter Units Consumed: ");

                        units = sc.nextInt();

                        if (units >= 0)
                            break;

                        System.out.println("Units cannot be negative.");
                    }

                    Customer customer = new Customer(name, id, units);

                    printBill(customer);

                    break;

                case 2:
                    System.out.println("\nThank you for using Electricity Bill Calculator.");
                    break;

                default:
                    System.out.println("\nInvalid Choice.");
            }

        } while (choice != 2);

        sc.close();
    }
}