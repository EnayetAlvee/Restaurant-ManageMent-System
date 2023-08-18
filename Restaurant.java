import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    int id;
    String name;
    double score;
    String price;
    double avgPrice;
    String zip_code;
    String category[] = new String[3];
    int catCounter = 0;
    List<Food> allFoods = new ArrayList<>();

    public String[] getCategory() {
        return category;
    }

    public List<Food> getAllFoods() {
        return allFoods;
    }

    public Restaurant(int id, String name, double score, String zipcode, String catname[]) {
        setId(id);
        this.name = name;
        this.score = score;
        avgPrice = 0;
        this.zip_code = zipcode;
        for (int i = 0; i < catname.length; i++) {
            if (catname[i] != null) {
                setCategory(catname[i]);
            }
        }
    }

    public Restaurant(int id, String name, double score, String price, String zipcode, String catname[]) {
        setId(id);
        this.name = name;
        this.score = score;
        this.price = price;
        avgPrice = 0;

        if (price == "$" && avgPrice == 0) {
            avgPrice = 5;
        }
        if (price == "$$" && avgPrice == 0) {
            avgPrice = 14;
        }
        if (price == "$$$" && avgPrice == 0) {
            avgPrice = 25;
        }
        this.zip_code = zipcode;
        for (int i = 0; i < catname.length; i++) {
            if (catname[i] != null) {
                setCategory(catname[i]);
            }
        }
    }

    public void setCategory(String catName) {
        if (catCounter < 3) {
            category[catCounter] = catName;
            catCounter++;
        } else {
            System.out.println("Category limit exeeds(3)");
        }
        return;
    }

    public int getCatCounter() {
        return catCounter; // highest return 3 for 3 category
    }

    public void printCategory() {
        for (String x : category) {
            System.out.print("," + x);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setscore(double score) {
        this.score = score;
    }

    public double getscore() {
        return this.score;
    }

    public String getPrice() {
        return this.price;
    }

    public void setZipCode(String zipCode) {
        this.zip_code = zipCode;
    }

    public String getzipCode() {
        return this.zip_code;
    }

    public boolean isFoodAvailable(String cat, String foodname) {
        for (Food f : allFoods) {
            if (f.getCategory().equalsIgnoreCase(cat) && f.getfoodname().equalsIgnoreCase(foodname)) {
                return true;
            }
        }
        return false;
    }

    public void addFood(String cat, String foodname, double price) {
        if (isFoodAvailable(cat, foodname)) {
            System.out.println("Same category and Food exist in this restaurant already");
            return;
        }
        allFoods.add(new Food(this.getId(), cat, foodname, price));
        updatePrice();
    }

    private void updatePrice() { // call all food;
        double totallprice = 0;
        for (Food f : getAllFoods())
            totallprice += f.getPrice();
        avgPrice = totallprice / getAllFoods().size();
        if (avgPrice >= 1 && avgPrice <= 10)
            this.price = "$";
        if (avgPrice >= 11 && avgPrice <= 20)
            this.price = "$$";
        if (avgPrice >= 21 && avgPrice <= 30)
            this.price = "$$$";
    }

    public void DisplayRestaurant() {
        System.out.println("Id: " + id + ", Restaurant Name: " + this.name + ", Score: " + score+", Price: "+this.price+", zipCode "+this.zip_code);
        System.out.println("Categories: ");
        for (int j = 0; j < getCatCounter(); j++) {
            if (j == getCatCounter() - 1) {
                System.out.println(getCategory()[j]);
                break;
            }
            System.out.print(getCategory()[j] + " ,");
        }
    }
    public void DisplayShortlyRestaurant(){
        System.out.println("ID: "+this.id+", Name: "+this.name+", Score "+this.score+", price "+this.price+", zipcode: "+this.zip_code);
    }
    public void DisplayRestaurantFoods() {
        System.out.println("Id: " + id + ", Restaurant Name: " + this.name + " Score: " + score);
        System.out.println("Food Items: ");
        for (Food f : getAllFoods()) {
            f.Displayfood();
        }
    }
}