import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {

    private java.util.ArrayList<Vehicle> list = new ArrayList<Vehicle>();

    //Empty constructor
    public Inventory() {

    }

    //Constructor for single vehicle variable
    public Inventory(Vehicle vehicle) {
        list.add(vehicle);
    }

    //Constructor that takes in an array list of vehicles
    public Inventory(java.util.ArrayList<Vehicle> list) {
        for(Vehicle v : list) {
            this.list.add(v);
        }
    }

    //adds a vehicle to the list
    public void add(Vehicle v) {
        this.list.add(v);
    }

    //Removes the vehicle if found in the array
    public void remove(Vehicle v) {
        if(list.contains(v)) {
            list.remove(v);
        } else {
            System.out.println("Vehicle not found in inventory. Remove failed!");
        }
    }

    //returns true or false if the given vehicle is in inventory
    public boolean contains(Vehicle v) {
        if(list.contains(v)) {
            return true;
        }
        return false;
    }

    //for testing purposes, clears list entirely
    public void clearList() {
        list.clear();
    }

    //returns size of list
    public int size() {
        return list.size();
    }

    //returns cheapest vehicle
    public Vehicle findCheapestVehicle() {
        double min = Double.MAX_VALUE;
        Vehicle cheapest = null;
        for (Vehicle v :list) {
            if(v.getPrice() < min) {
                cheapest = v;
                min = v.getPrice();
            }
        }
        return cheapest;
    }

    //returns most expensive vehicle
    public Vehicle findMostExpensiveVehicle() {
        double max = Double.MIN_VALUE;
        Vehicle mostExpensive = null;
        for (Vehicle v :list) {
            if(v.getPrice() > max) {
                mostExpensive = v;
                max = v.getPrice();
            }
        }
        return mostExpensive;
    }

    //Prints the average price of all vehicles
    public void printAveragePriceOfAllVehicles() {
        double avg = 0;
        double sum = 0;

        for(Vehicle v: list) {
            sum += v.getPrice();
        }

        avg = sum / list.size();

        System.out.printf("Average Price of Inventory: %2.2f%n", avg);
    }

    public void printAll() {
        for (Vehicle v : list) {
            v.printInfo();
        }
    }
}
