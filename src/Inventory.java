import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class called Inventory that maintains an array list of
 * vehicle type that are available for sale
 */
public class Inventory implements Serializable {
    private static final long serialVersionUID = 8120157080073719468L;
    // create a list for the vehicles to be stored
    private List<Vehicle> listOfVehicles;

    // constructor
    public Inventory() {
        listOfVehicles = new ArrayList<Vehicle>();
    }

    // This is a method to add a vehicle to the array list
    public void add(Vehicle newVehicle) {
        listOfVehicles.add(newVehicle);
    }

    /**
     * This is a method to remove a vehicle from the array list
     */
    public void remove(Vehicle vehicleToRemove) {
        for (int i = 0; i < listOfVehicles.size(); i++) {
            Vehicle currentVehicle = listOfVehicles.get(i);

            if (currentVehicle.getMake().equalsIgnoreCase(vehicleToRemove.getMake()) &&
                    currentVehicle.getModel().equalsIgnoreCase(vehicleToRemove.getModel()) &&
                    currentVehicle.getModelYear() == vehicleToRemove.getModelYear() &&
                    currentVehicle.getRetailPrice() == vehicleToRemove.getRetailPrice() &&
                    currentVehicle.getMilesPerGallon() == vehicleToRemove.getMilesPerGallon() &&
                    currentVehicle.isFourWheelDrive() == vehicleToRemove.isFourWheelDrive()){

                listOfVehicles.remove(currentVehicle);

            }
        }
    }

    /**
     * This is a method to find the cheapest vehicle in the array list
     */
    public Vehicle findCheapestVehicle() {
        if (listOfVehicles.isEmpty()) {
            return null;
        }

        Vehicle cheapestVehicle = listOfVehicles.get(0);
        for (Vehicle currentVehicle : listOfVehicles) {
            if (currentVehicle.getRetailPrice() < cheapestVehicle.getRetailPrice()) {
                cheapestVehicle = currentVehicle;
            }
        }
        return cheapestVehicle;
    }

    /**
     * This is a method to find the most expensive vehicle in the array list
     */
    public Vehicle findMostExpensiveVehicle() {
        if (!listOfVehicles.isEmpty()) {
            Vehicle mostExpensiveVehicle = listOfVehicles.get(0);
            for (Vehicle currentVehicle : listOfVehicles) {
                if (currentVehicle.getRetailPrice() > mostExpensiveVehicle.getRetailPrice()) {
                    mostExpensiveVehicle = currentVehicle;
                }
            }
            return mostExpensiveVehicle;
        } else {
            return null;
        }
    }

    /**
     * This is a method that prints out the average price of all the vehicles
     */
    public String printAveragePriceOfAllVehicles() {
        int sumOfVehiclePrices = 0;
        int averageOfVehiclePrices;
        String averagePriceString;

        if (listOfVehicles.size() > 0) {
            for (Vehicle vehiclesInList : listOfVehicles) {
                sumOfVehiclePrices += vehiclesInList.getRetailPrice();
            }
            averageOfVehiclePrices = sumOfVehiclePrices / listOfVehicles.size();
            averagePriceString = "Average price of all vehicles: $" + averageOfVehiclePrices + ",000";
        } else {
            averagePriceString = "Size of inventory is 0, no average can be calculated";
        }

        System.out.println(averagePriceString);
        return averagePriceString;
    }

    // Getter method to return the array list of vehicles
    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

}
