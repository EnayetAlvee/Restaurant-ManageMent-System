public class Food {
    int restaurantId;
    String catagory;
    String name;
    double price;

    public Food(int id, String category, String name, double price) {
        this.restaurantId = id;
        this.catagory = category;
        this.price = price;
        this.name = name;
    }

    public void setFoodname(String name) {
        this.name = name;
    }

    public void setCategory(String name) {
        this.catagory = name;
    }

    public void setprice(double n) {
        this.price = n;
    }

    public int getresid() {
        return this.restaurantId;
    }

    public String getfoodname() {
        return this.name;
    }

    public String getCategory() {
        return this.catagory;
    }

    public double getPrice() {
        return this.price;
    }

    public void Displayfood() { // category name price
        System.out.println("Category: " + catagory + ", Food Name: " + name + ", Price: " + price);
    }

    public void DisplayFoodWithId() {
        System.out.println("Restaurant id: " + this.restaurantId + ", Category: " + catagory + ", Food Name: " + name
                + " Price: " + price);
    }
}
