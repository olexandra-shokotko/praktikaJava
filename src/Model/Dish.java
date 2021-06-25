package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Dish implements Serializable
{
    private static final long serialVersionUID = 4390619385273939000L;

    private String dishName;
    private String price;
    private String makeTime;
    public ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public Dish(String name, String price, String time)
    {
        dishName = name;
        this.price = price;
        makeTime = time;
    }
    public Dish(String name)
    {
        dishName = name;
    }
    public Dish()
    {}

    public String getName() { return dishName; }
    public void setName(String name) { this.dishName = name; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getMakeTime() { return makeTime; }
    public void setMakeTime(String makeTime) { this.makeTime = makeTime; }
    public ArrayList<Ingredient> getIngredients() { return ingredients; }
    public void addIngredient(Ingredient ingredient) { ingredients.add(ingredient); }
    public void removeIngredient(String ingredient)
    {
        for (Ingredient i :  ingredients)
        {
            if (i.getName().equals(ingredient))
            {
                ingredients.remove(i);
            }
        }
    }
//    public void removeIngredient(Ingredient ingredient) { ingredients.remove(ingredient); }

    @Override
    public String toString()
    {
        return  "Dish: " + dishName +
                "\nTime to make: " + makeTime +
                "\nPrice: " + price +
                "\nIngredients: " + ingredients.toString();
    }
}
