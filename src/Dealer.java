import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;



    public class Dealer implements Serializable {
        private transient Inventory inventory = new Inventory();

        public Dealer(URL url) throws IOException {
            Scanner sw = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();

            while(sw.hasNext()) {
                sb.append(sw.nextLine());
                sb.append("\n");
            }

            //Retrieving the String from the String Buffer object
            String result = sb.toString();

            //Removing the HTML tags
            result = result.replaceAll("<[^>]*>", "");

            Scanner rawText = new Scanner(result);

            //loops over text
            while(rawText.hasNextLine()) {
                Vehicle toAdd;
                StringTokenizer tokenizedVehicle = new StringTokenizer(rawText.nextLine(), ",");
                int tokens = tokenizedVehicle.countTokens();
                StringTokenizer splitMakeModel = new StringTokenizer(tokenizedVehicle.nextToken(), " ");

                if(tokens == 4) {
                    toAdd = new Vehicle(splitMakeModel.nextToken(), splitMakeModel.nextToken(),
                            Integer.parseInt(tokenizedVehicle.nextToken()),
                            Double.parseDouble(tokenizedVehicle.nextToken()),0,  true);
                } else {
                    toAdd = new Vehicle(splitMakeModel.nextToken(), splitMakeModel.nextToken(),
                            Integer.parseInt(tokenizedVehicle.nextToken()),
                            Double.parseDouble(tokenizedVehicle.nextToken()),0,  false);
                }
                inventory.add(toAdd);
            }
        }

        public void serializeThis() {
            try {
                File file = new File("C:\\Users\\cmart\\IdeaProjects\\hw5-Hjfizzlebog2\\inventory.txt");
                FileOutputStream fileOut = new FileOutputStream("inventory.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(inventory);
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in inventory.txt");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        public Inventory deserializeThis() {

            System.out.println("Deserializing...");
            try {
                FileInputStream inputStream = new FileInputStream("inventory.txt");
                ObjectInputStream in = new ObjectInputStream(inputStream);
                inventory = (Inventory) in.readObject();
                inputStream.close();
                in.close();
                System.out.println("Success! Deserialized.");
            } catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Failed to Deserialize.");
            }
            return null;
        }

        public Inventory getInventory() {
            return inventory;
        }
    }

