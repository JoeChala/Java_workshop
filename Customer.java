import java.util.*;
import java.util.Scanner;
public class Customer {
    private String firstName;
    private String lastName;
    private int id;
    private double balance;

    public Customer() {
    }
    public Customer(String Name, int id, double balance) {
        this.firstName = Name.split(" ")[0];
        this.lastName = Name.split(" ")[1];
        this.id = id;
        this.balance = balance;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }
    public int compareCustomers(Customer customer2) {
        int firstNameComparison = this.firstName.compareToIgnoreCase(customer2.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        int lastNameComparison = this.lastName.compareToIgnoreCase(customer2.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        if (this.id != customer2.id) {
            return this.id - customer2.id;
        }
        if (this.balance != customer2.balance) {
            return Double.compare(this.balance, customer2.balance);
        }
        return 0;
    }
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        var n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Balance: ");
            double bal = sc.nextDouble();
            customers.add(new Customer(name, id, bal));
            sc.nextLine();
        }
        System.out.println("Before sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        customers.sort(Customer::compareCustomers);
        System.out.println("\nAfter sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sc.close();
    }
}