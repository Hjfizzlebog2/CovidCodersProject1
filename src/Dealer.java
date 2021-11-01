import org.apache.commons.io.*;
import org.apache.commons.lang3.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.io.FileWriter;

/**
 * BRIAN MOLINA, WORKED WITH BRANDON SAID
 * This is a class that loads data from the internet and will
 * serialize as well as deserialize the data.
 */
public class Dealer implements Serializable{

    // fields
    private static final long serialVersionUID = -1012675660432375000L;
    private Inventory dealerInventory;

    /**
     * Default constructor that will set to a new inventory
     */
    public Dealer() {
        dealerInventory = new Inventory();
    }

    /**
     * This is a method to load the data from a given file
     * and store it in an Inventory
     */
    public Inventory dataToLoad(String pathForFile) throws IOException {
        URL dataUrl = new URL(pathForFile);
        Scanner dataFromFile = new Scanner(dataUrl.openStream());

        while (dataFromFile.hasNextLine()) {
            String line = dataFromFile.nextLine();
            String[] vehicleFields = line.split(",");
            String[] vehicleElements = StringUtils.splitPreserveAllTokens(line,",");
            dealerInventory.add(new Vehicle(vehicleElements[0],Integer.parseInt(vehicleElements[1]),
                    Integer.parseInt(vehicleElements[2]), Boolean.parseBoolean(vehicleElements[3])));

        }
        return dealerInventory;
    }

    /**
     * This is a method to serialize the data
     */
    public void serializeDealer() {
        File file = FileUtils.getFile("dealer.ser");
        byte[] data = SerializationUtils.serialize((Serializable) dealerInventory);
        try {
            FileUtils.writeByteArrayToFile(file,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is a method to deserialize the data
     */
    public Inventory deserializeDealer() {
        File file = FileUtils.getFile("dealer.ser");
        byte[] dataToDeserialize = null;
        try {
            dataToDeserialize = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Inventory deserializedInventory = SerializationUtils.deserialize(dataToDeserialize);
        for (Vehicle currentVehicle : deserializedInventory.getListOfVehicles()) {
            currentVehicle.printVehicle2();
            System.out.println();
        }
        return deserializedInventory;
    }

    /**
     * This is a method to create a report
     */
    public void generateReport(Inventory inv) {
        try{
            File firstFile = new File("report.txt");
            if (!firstFile.exists()) {
                firstFile.createNewFile();
            }

            FileWriter fileWriter = new FileWriter("report.txt",true);
            for(Vehicle currentVehicle : inv.getListOfVehicles()) {
                String vehicleInfo = currentVehicle.getMakeModel() + "," + currentVehicle.getModelYear() + "," + currentVehicle.getMilesPerGallon() + ",";
                if (currentVehicle.isFourWheelDrive()) {
                    vehicleInfo += "TRUE";
                }
                fileWriter.write(vehicleInfo);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

