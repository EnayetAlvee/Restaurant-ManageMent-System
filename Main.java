import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.File;

public class Main {
    private static final String INPUT_FILE_NAME = "restaurant.txt";
    private static final String INPUT_FILE_NAME1 = "menu.txt";

    // public static final String OUTPUT_FILE_NAME="resout.txt";
    public static void main(String[] args) throws Exception {
        // int count = 0;
        Scanner scanner = new Scanner(System.in);
        List<Restaurant> restaurants = new ArrayList<>();
        Operations myOperations = new Operations();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            // System.out.println(line);
            String[] array = line.split(",", -1);
            String[] category = new String[3];
            for (int i = 5; i < array.length; i++) {
                category[i - 5] = array[i];
            }
            myOperations.addRestaurant(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), array[3],
                    array[4], category);
        }
        // myOperations.setRestaurants(restaurants);
        br.close();
        br = new BufferedReader(new FileReader(INPUT_FILE_NAME1));
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            // System.out.println(line);
            String[] array = line.split(",", -1);
            myOperations.addFoodToMenu(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]));
        }
        int ch = 0, option = 0;
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1) Search Restaurants");
            System.out.println("2) Search Food Items");
            System.out.println("3) Add Restaurant");
            System.out.println("4) Add Food Items to the Menu");
            System.out.println("5) Exit System");
            ch = scanner.nextInt();
            if (ch == 1) {
                System.out.println("Restaurant Searching Options");
                System.out.println("1) By Name");
                System.out.println("2) By Score");
                System.out.println("3) By Category");
                System.out.println("4) By Price ");
                System.out.println("5) By Zip Code");
                System.out.println("6) Different Category Wise List of Restaurants");
                System.out.println("7) Back to Main Menu");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter Restaurant Name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        myOperations.searchRestaurant(name);
                        break;
                    case 2:
                        System.out.println("Enter Restaurant Score range: ");
                        System.out.print("Lowest Score: ");
                        double Lowestscore = scanner.nextDouble();
                        System.out.println();
                        System.out.print("Highest Score: ");
                        double highestscore = scanner.nextDouble();
                        System.out.println();
                        myOperations.DisplayRestaurants(Lowestscore, highestscore);
                        break;
                    case 3:
                        System.out.println("Enter Category: ");
                        scanner.nextLine();
                        String category = scanner.nextLine();
                        myOperations.searchRestaurantByCat(category);
                        break;
                    case 4:
                        System.out.println("Enter Price");
                        scanner.nextLine();
                        String price = scanner.nextLine();
                        myOperations.searchRestaurantByprice(price);
                        break;
                    case 5:
                        System.out.println("Enter ZipCode");
                        scanner.nextLine();
                        String zipcode = scanner.nextLine();
                        myOperations.searchRestaurantByZipcode(zipcode);
                        break;
                    case 6:
                        System.out.println("Catefory Wise Restaurant names: ");
                        myOperations.CategoryWiseDisplay();
                        break;
                    case 7:
                        System.out.println("Returning To back main menu..........");
                        break;
                    default:
                        System.out.println("Enter Correct Option");
                        break;
                }
            } else if (ch == 2) {
                System.out.println("Food Item Searching Options");
                System.out.println("1) By Name");
                System.out.println("2) By Name in a Given Restaurant");
                System.out.println("3) By Category");
                System.out.println("4) By Category in a Given Restaurant");
                System.out.println("5) By Price Range");
                System.out.println("6) By Price Range in a Given Restaurant");
                System.out.println("7) Costliest Food Item(s) on the Menu in a Given Restaurant");
                System.out.println("8) List of Restaurants and Total Food Item on the Menu");
                System.out.println("9) Back to Main Menu");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter Food name:");
                        scanner.nextLine();
                        String foodname = scanner.nextLine();
                        myOperations.searchFoodItems(foodname);
                        break;
                    case 2:
                        System.out.println("Enter food name");
                        scanner.nextLine();
                        foodname = scanner.nextLine();
                        System.out.println("Enter Restaurant name");
                        // scanner.nextLine();
                        String resName = scanner.nextLine();
                        myOperations.SearchfoodInResTaurant(foodname, resName);
                        break;
                    case 3:
                        System.out.println("Enter Category: ");
                        scanner.nextLine();
                        String catname = scanner.nextLine();
                        myOperations.DisplayfoodFromCategory(catname);
                        break;
                    case 4:
                        System.out.println("Enter food category");
                        scanner.nextLine();
                        String foodCat = scanner.nextLine();
                        System.out.println("Enter Restaurant name: ");
                        scanner.nextLine();
                        resName = scanner.nextLine();
                        myOperations.DisplayfoodFromCategoryInRestaurant(resName, foodCat);
                        break;
                    case 5:
                        System.out.println("Enter Price range");
                        System.out.print("Lowest Price: ");
                        double lowPrice = scanner.nextDouble();
                        System.out.println();
                        System.out.print("Highwest Price: ");
                        double highPrice = scanner.nextDouble();
                        System.out.println();
                        myOperations.searchFoodwithPrice(lowPrice, highPrice);
                        break;
                    case 6:
                        System.out.println("Enter Price range and restauratn name");
                        System.out.print("Lowest Price: ");
                        lowPrice = scanner.nextDouble();
                        System.out.println();
                        System.out.print("Lowest Price: ");
                        highPrice = scanner.nextDouble();
                        System.out.println();
                        System.out.println("Restaurant Name: ");
                        scanner.nextLine();
                        resName = scanner.nextLine();
                        myOperations.SearchfoodInResTaurantwithprice(lowPrice, highPrice, resName);
                        break;
                    case 7:
                        System.out.println("Enter Restaurant Name: ");
                        scanner.nextLine();
                        resName = scanner.nextLine();
                        myOperations.DisplayCostliestItemOnRestaurant(resName);
                        break;
                    case 8:
                        myOperations.DisplayAllFoodAllrestaurants();
                        break;
                    case 9:
                        break;
                    default:
                        break;
                }

            } else if (ch == 3) { // add Restaurant work done
                String name, zipCode;
                double score;
                System.out.println("Enter Restaurant name:");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Enter Score:");
                score = scanner.nextDouble();
                System.out.println("Enter Restaurant id:");
                int id = scanner.nextInt();
                System.out.println("Enter Restaurant zipCode:");
                scanner.nextLine();
                zipCode = scanner.nextLine();
                System.out.println("How many category do you want?(Between 1 to 3)");
                int temp = scanner.nextInt();
                while (temp < 1 || temp > 3) {
                    System.out.println("Invalid choice.Please enter a number from 1 to 3.");
                    temp = scanner.nextInt();
                }
                String catName[] = new String[temp];
                System.out.println("Enter " + temp + " category names:");
                scanner.nextLine();
                for (int i = 0; i < temp; i++) {
                    catName[i] = scanner.nextLine();
                }

                myOperations.addRestaurant(id, name, score, zipCode, catName);
            } else if (ch == 4) { // add Food item work done
                String resName;
                System.out.println("Enter Restaurant name :");
                scanner.nextLine();
                resName = scanner.nextLine();
                System.out.println("Category Name:");
                // scanner.nextLine();
                String catName = scanner.nextLine();
                System.out.println("Enter food name:");
                String FoodName = scanner.nextLine();
                System.out.println("Enter food price");
                double FoodPrice = scanner.nextInt();
                myOperations.addFoodToMenu(resName, catName, FoodName, FoodPrice);
            } else if (ch == 5) {
                System.out.println("Exiting System.......");
                break;
            } else if (ch == 7) {
                myOperations.printRes();
            } else {
                System.out.println("Please Enter Number from 1 to 5.");
            }
        }
        restaurants = myOperations.getRestaurants();
        // File fin=new File(INPUT_FILE_NAME);
        BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant temp = restaurants.get(i);
            bw.write(temp.getId() + "," + temp.getName() + "," + temp.getscore() + "," + temp.getPrice() + ","
                    + temp.getzipCode() + ",");
            // System.out.println(temp.getCategory().length);
            for (int j = 0; j < temp.getCatCounter(); j++) {
                if (j == temp.getCatCounter() - 1) {
                    bw.write(temp.getCategory()[j]);
                    break;
                }
                bw.write(temp.getCategory()[j] + ",");
            }
            bw.write(System.lineSeparator());
        }
        bw.close();
        bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME1));
        for (Restaurant x : restaurants) {
            for (Food f : x.getAllFoods()) {
                bw.write(f.getresid() + "," + f.getCategory() + "," + f.getfoodname() + "," + f.getPrice());
                bw.write(System.lineSeparator());
            }
        }
        bw.close();
        // File fout=new File(OUTPUT_FILE_NAME);
        // boolean success=fout.renameTo(new File(INPUT_FILE_NAME));
        // System.out.println(success);
        // fin.delete();
        scanner.close();
    }
}