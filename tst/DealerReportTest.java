import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.IOException;

public class DealerReportTest {

    /**
     * Ensures that a report.txt file does not exist prior to
     * every test. This is because the logic within each test
     * is dependent upon the fact that report.txt does not exist
     * nor does it already have data in it. Otherwise, tests would
     * not validate correctly if report.txt changed every time
     * a test ran.
     */
    @Before
    public void destroyFileBeforeTests() {
        File reportFile = new File("report.txt");
        reportFile.delete();
        //NOTE: Might require if/else based on if report.txt exists
    }


    /**
     * Tests that the report.txt file is created. Deletes file after to
     * prevent from messing with other tests.
     */
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
        Assert.assertTrue("File does not exist.", firstFile.exists());
    }

    /**
     * Tests that generateReport() produces the correct file after
     */
    @Test
    public void generateReportWithFullInventoryTest() throws IOException {
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
        File report = new File("report.txt");
        File expectedReport = new File("generateReportWithFullInventory.txt");

        // Act
        firstDealer.generateReport(firstInventory);

        // Assert
        Assert.assertTrue("File generated incorrectly.", FileUtils.contentEquals(report, expectedReport));
    }



    /**
     * Test checks that text is added to a file correctly when
     * using generateReport when report.txt already exists
     */
    @Test
    public void appendingWorksTest() throws IOException {
        //Arrange
        Inventory inventory = new Inventory();
        inventory.add(new Vehicle("Ford F150",2015,35000,true));

        Dealer dealer = new Dealer();
        File report = new File("report.txt");
        File expectedReport = new File("appendingWorks.txt");

        //Act
        dealer.generateReport(inventory);
        dealer.generateReport(inventory); // purposefully done twice


        //Assert
        Assert.assertTrue("File's text generated incorrectly.",
                FileUtils.contentEquals(report, expectedReport));
    }


    /**
     * Test checks that appending works when file exists, but is blank to start.
     */
    @Test
    public void appendingToBlankFileTest() throws IOException {
        //Arrange
        File report = new File("report.txt"); //Should create blank file?
        Inventory inventory = new Inventory();
        inventory.add(new Vehicle("Ford Fiesta",2012,18000,false));

        File expectedReport = new File("appendingToBlankFile.txt");

        //Act
        Dealer dealer = new Dealer();
        dealer.generateReport(inventory);

        //Assert
        Assert.assertTrue("File's text generated incorrectly.",
                FileUtils.contentEquals(report, expectedReport));
    }

    //Could have null test

}