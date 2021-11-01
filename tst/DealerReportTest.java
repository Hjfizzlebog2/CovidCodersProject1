import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class DealerReportTest {

    @Test
    public void fileExistsTest() {
        // Arrange
        Inventory firstInventory = new Inventory();
        Vehicle vehicle1 = new Vehicle("Ford F150",2015,35000,true);
        Vehicle vehicle2 = new Vehicle("Ford Focus",2010,15000,false);
        Vehicle vehicle3 = new Vehicle("Ford Fiesta",2012,18000,false);
        Vehicle vehicle4 = new Vehicle("GM Sierra",2016,40000,true);
        Vehicle vehicle5 = new Vehicle("Chevy Silverado",2016,35000,true);
        firstInventory.add(vehicle1);
        firstInventory.add(vehicle2);
        firstInventory.add(vehicle3);
        firstInventory.add(vehicle4);
        firstInventory.add(vehicle5);

        Dealer firstDealer = new Dealer();
        File firstFile = new File("report.txt");
        // Act
        firstDealer.generateReport(firstInventory);
        // Assert
        Assert.assertTrue(firstFile.exists());
    }
}
