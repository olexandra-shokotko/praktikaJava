package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable
{
    private static final long serialVersionUID = 4390619385273939000L;

    private int table;
    private Double price = 0d;
    private int numberOfDishes = 0;
    public ArrayList<String> dishes = new ArrayList<String>();
//    public ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Order(int table) { this.table = table; }
    public Order()
    {}

//    public ArrayList<Dish> getDishes() { return dishes; }
    public void setPrice(Double price) { this.price = price; }
    public Double getPrice() { return price; }
    public void setTable(int table) { this.table = table; }
    public int getTable() { return table; }
    public ArrayList<String> getDishes() { return dishes; }
    public void addDish(String dishName) { dishes.add(dishName); }
    public void removeDish(String dishName)
    {
        for (String d :  dishes)
        {
            if (d.equals(dishName))
            {
                dishes.remove(d);
            }
        }
    }
    public int getNumberOfDishes() { return numberOfDishes; }
    public void setNumberOfDishes(int numberOfDishes) { this.numberOfDishes = numberOfDishes; }

    @Override
    public String toString()
    {
        return  "Number of table: " + table +
                "\nOrder price: " + price +
                "\nNumber of dishes: " + numberOfDishes;
//                "\nDishes: " + dishes.toString();
    }
}
