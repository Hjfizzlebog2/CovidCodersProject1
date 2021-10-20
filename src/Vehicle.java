import java.io.Serializable;

public class Vehicle implements Serializable {

    private String make;
    private String model;
    private int year;
    private double price;
    private double mpg;
    private boolean has4Wd;

    public Vehicle() {

    }

    public Vehicle(String make, String model, int year, double price, double mpg, boolean has4Wd) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mpg = mpg;
        this.has4Wd = has4Wd;

    }

    //GETTERS

    //returns make
    public String getMake() {
        return make;
    }

    //returns model
    public String getModel() {
        return model;
    }

    //returns year
    public int getYear() {
        return year;
    }

    //returns price
    public double getPrice() {
        return price;
    }

    //returns mpgs
    public double getMpg() {
        return mpg;
    }

    //returns boolean for 4WD or not
    public boolean get4Wd() {
        return has4Wd;
    }

    //SETTERS
    //sets make
    public void setMake(String make) {
        this.make = make;
    }

    //sets model
    public void setModel(String model) {
        this.model = model;
    }

    //set year
    public void setYear(int year) {
        this.year = year;
    }

    //set price
    public void setPrice(double price) {
        this.price = price;
    }

    //set mpg
    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    //set boolean 4wd
    public void set4Wd(boolean has4Wd) {
        this.has4Wd = has4Wd;
    }

    //print info
    public void printInfo() {
        System.out.println("------------------------");
        System.out.printf("| %d %8s %6s |%n", year, make, model);
        if(!has4Wd) {
            System.out.printf("| %-20s |%n", "4WD");
        }
        System.out.printf("| $%2.0f\tMPG: %-6.1f|%n",price, mpg);
        System.out.println("------------------------");
    }


}