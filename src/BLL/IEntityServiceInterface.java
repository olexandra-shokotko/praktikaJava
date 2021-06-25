package BLL;

import Model.Dish;
import Model.Ingredient;
import Model.Order;

import java.util.ArrayList;

public interface IEntityServiceInterface
{
    void store(Ingredient ingredient);
    void store(Dish dish);
    void store(Order order);
    void createAndStoreIngredient(String name);
    void createAndStoreDish(String name, String p, String mt);
    void createAndStoreOrder(int table);

    ArrayList<Ingredient> getAllIngredients();
    ArrayList<Dish> getAllDishes();
    ArrayList<Order> getAllOrders();

    void removeIngredient(String name);
    void removeDish(String name);
    void removeOrder(int number);

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