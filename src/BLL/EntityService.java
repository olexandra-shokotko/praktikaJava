package BLL;
import DAL.IEntityContextInterface;
import DAL.EntityContext;
import Model.Dish;
import Model.Ingredient;
import Model.Order;

import java.util.ArrayList;

public class EntityService implements IEntityServiceInterface
{
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    IEntityContextInterface entityContext;

    public EntityService() { entityContext = new EntityContext(); }
    public EntityService(EntityContext ec) { entityContext = ec; }

    public void store(Ingredient ingredient) { entityContext.saveToDb(ingredient); }
    public void store(Dish dish) { entityContext.saveToDb(dish); }
    public void store(Order order) { entityContext.saveToDb(order); }

    public void createAndStoreIngredient(String in)
    {
        Ingredient ingredient = new Ingredient(in);
        store(ingredient);
    }
    public void createAndStoreDish(String dn, String p, String mt)
    {
        Dish dish = new Dish(dn, p, mt);
        store(dish);
    }
    public void createAndStoreOrder(int t)
    {
        Order order = new Order(t);
        store(order);
    }

    public ArrayList<Ingredient> getAllIngredients()
    {
        ArrayList<Ingredient> ingredients = entityContext.getAllIngredientsFromDb();
        return ingredients;
    }

    public ArrayList<Dish> getAllDishes()
    {
        ArrayList<Dish> dishes = entityContext.getAllDishesFromDb();
        return dishes;
    }

    public ArrayList<Order> getAllOrders()
    {
        ArrayList<Order> orders = entityContext.getAllOrdersFromDb();
        return orders;
    }

    public void removeIngredient(String ingredientName) { entityContext.removeIngredientFromDb(ingredientName); }
    public void removeDish(String dishName) { entityContext.removeDishFromDb(dishName); }
    public void removeOrder(int orderNumber) { entityContext.removeOrderFromDb(orderNumber); }

    public Dish getDishInformation(String name)
    {
        Dish dish = entityContext.getDishInformation(name);
        return dish;
    }
    public Order getOrderInformation(int number)
    {
        Order order = entityContext.getOrderInformation(number);
        return order;
    }

    public Ingredient findByIngredientName(String ingredientName)
    {
        Ingredient ingredient = entityContext.findByIngredientName(ingredientName);
        return ingredient;
    }

    public void addIngredientToDish(String dishName, String ingredientName)
    {
        entityContext.addIngredientToDish(dishName, ingredientName);
    }

    public void removeIngredientFromDish(String dishName, String ingredientName)
    {
        entityContext.removeIngredientFromDish(dishName, ingredientName);
    }

    public void addDishToOrder(String orderNumber, String dishName)
    {
        entityContext.addDishToOrder(orderNumber, dishName);
    }

    public void removeDishFromOrder(String orderNumber, String dishName)
    {
        entityContext.removeDishFromOrder(orderNumber, dishName);
    }

    public void changeIngredientName(String oldIngredientName, String newIngredientName)
    {
        entityContext.changeIngredientName(oldIngredientName, newIngredientName);
    }

    public void changeDishName(String oldDishName, String newDishName)
    {
        entityContext.changeDishName(oldDishName, newDishName);
    }

    public void changeDishPrice(String dishName, String newDishPrice)
    {
        entityContext.changeDishPrice(dishName, newDishPrice);
    }

    public void changeDishTime(String dishName, String newDishTime)
    {
        entityContext.changeDishTime(dishName, newDishTime);
    }

    public void changeOrderPrice(String orderNumber, String newOrderPrice)
    {
        entityContext.changeOrderPrice(orderNumber, newOrderPrice);
    }

    public void changeOrderNumber(String oldOrderNumber, String newOrderNumber)
    {
        entityContext.changeOrderNumber(oldOrderNumber, newOrderNumber);
    }

    public void changeNumberOfDishesInOrder(String orderNumber, String numberOfDishes)
    {
        entityContext.changeNumberOfDishesInOrder(orderNumber, numberOfDishes);
    }
}
