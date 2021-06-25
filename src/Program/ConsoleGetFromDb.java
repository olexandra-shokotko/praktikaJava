package Program;

import BLL.EntityService;
import BLL.IEntityServiceInterface;
import Model.Dish;
import Model.Ingredient;
import Model.Order;

import java.util.ArrayList;

public class ConsoleGetFromDb
{
    IEntityServiceInterface entityService;

    public ConsoleGetFromDb() { entityService = new EntityService(); }
    public void start(String selectedType)
    {
        try
        {
            if (selectedType.equals("Ingredient"))
            {
                ArrayList<Ingredient> ingredients = entityService.getAllIngredients();
                for (Ingredient i : ingredients)
                {
                    System.out.println();
                    System.out.println(i);
                }
            }else if (selectedType.equals("Dish"))
            {
                ArrayList<Dish> dishes = entityService.getAllDishes();
                for (Dish d : dishes)
                {
                    System.out.println();
                    System.out.println(d);
                }
            }else if (selectedType.equals("Order"))
            {
                ArrayList<Order> orders = entityService.getAllOrders();
                for (Order o : orders)
                {
                    System.out.println();
                    System.out.println(o);
                }
            }
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }
}
