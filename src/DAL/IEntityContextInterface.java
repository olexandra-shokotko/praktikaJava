package DAL;

import Model.Dish;
import Model.Ingredient;
import Model.Order;

import java.util.ArrayList;

public interface IEntityContextInterface
{
    void saveToDb(Object obj);

    ArrayList<Ingredient> getAllIngredientsFromDb();
    ArrayList<Dish> getAllDishesFromDb();
    ArrayList<Order> getAllOrdersFromDb();

    void removeIngredientFromDb(String name);
    void removeDishFromDb(String name);
    void removeOrderFromDb(int number);

    Dish getDishInformation(String name);
    Order getOrderInformation(int number);

    Ingredient findByIngredientName(String ingredientName);

    void addIngredientToDish(String dishName, String ingredientName);
    void removeIngredientFromDish(String dishName, String ingredientName);

    void addDishToOrder(String orderNumber, String dishName);
    void removeDishFromOrder(String orderNumber, String dishName);

    void changeIngredientName(String oldIngredientName, String newIngredientName);

    void changeDishName(String oldDishName, String newDishName);
    void changeDishPrice(String dishName, String newDishPrice);
    void changeDishTime(String dishName, String newDishTime);

    void changeOrderPrice(String orderNumber, String newOrderPrice);
    void changeOrderNumber(String oldOrderNumber, String newOrderNumber);
    void changeNumberOfDishesInOrder(String orderNumber, String numberOfDishes);
}
