package DAL;

import Model.Dish;
import Model.Ingredient;
import Model.Order;

import javax.naming.Context;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.util.UUID;

public class EntityContext implements IEntityContextInterface, Serializable {
    private static final long serialVersionUID = 4390619385273939000L;
    String dbIngredient;
    String dbDish;
    String dbOrder;
    String filePath = "C:\\Users\\Olexandra\\nau\\praktika\\praktikaJava\\";

    public void saveToDb(Object obj) {
        if (obj instanceof Ingredient)
        {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            dbIngredient = filePath + "IngredientsDB\\" + uuidAsString + ".txt";
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbIngredient)))
            {
                oos.writeObject(obj);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        if (obj instanceof Dish)
        {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
            {
                oos.writeObject(obj);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        if (obj instanceof Order)
        {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbOrder)))
            {
                oos.writeObject(obj);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Ingredient> getAllIngredientsFromDb()
    {
        File folder = new File(filePath + "IngredientsDB\\");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    ingredients.add((Ingredient) ois.readObject());
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return ingredients;
    }

    public ArrayList<Dish> getAllDishesFromDb()
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Dish> dishes = new ArrayList<Dish>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    dishes.add((Dish) ois.readObject());
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return dishes;
    }

    public ArrayList<Order> getAllOrdersFromDb()
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Order> orders = new ArrayList<Order>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    orders.add((Order) ois.readObject());
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return orders;
    }

    public void removeIngredientFromDb(String ingredientName)
    {
        File folder = new File(filePath + "IngredientsDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Ingredient ingredient = (Ingredient) ois.readObject();
                    if (ingredient.getName().equals(ingredientName))
                    {
                        File f = new File(filePath + "IngredientsDB\\" + "\\" + listOfFiles[i].getName());
                        ois.close();
                        if (f.delete()) {
                            System.out.println("Deleted the file: " + f.getName());
                        }else {
                            System.out.println("Failed to delete the file.");
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void removeDishFromDb(String dishName)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(dishName))
                    {
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        ois.close();
                        if (f.delete()) {
                            System.out.println("Deleted the file: " + f.getName());
                        }else {
                            System.out.println("Failed to delete the file.");
                        }

                        System.out.println("bbb");
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void removeOrderFromDb(int orderNumber)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == orderNumber)
                    {
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        if (f.delete()) {
                            System.out.println("Deleted the file: " + f.getName());
                        }else {
                            System.out.println("Failed to delete the file.");
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public Dish getDishInformation(String name)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();
        Dish resDish = new Dish();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(name))
                    {
                        resDish = dish;
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return resDish;
    }

    public Order getOrderInformation(int number)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();
        Order resOrder = new Order();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == number)
                    {
                        resOrder = order;
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return resOrder;
    }
    public Ingredient findByIngredientName(String ingredientName)
    {
        File folder = new File(filePath + "IngredientsDB\\");
        File[] listOfFiles = folder.listFiles();
        Ingredient resIngredient = new Ingredient();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Ingredient ingredient = (Ingredient) ois.readObject();
                    if (ingredient.getName().equals(ingredientName))
                    {
                        resIngredient = ingredient;
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return resIngredient;
    }

    public void addIngredientToDish(String dishName, String ingredientName)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(dishName))
                    {
                        Ingredient ingredient = new Ingredient(ingredientName);
                        dish.addIngredient(ingredient);
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void removeIngredientFromDish(String dishName, String ingredientName)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(dishName))
                    {
                        dish.removeIngredient(ingredientName);
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void addDishToOrder(String orderNumber, String dishName)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == Integer.parseInt(orderNumber))
                    {
                        Dish dish = new Dish(dishName);
                        order.dishes.add(dishName);
//                        order.addDish(dish);
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbOrder)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void removeDishFromOrder(String orderNumber, String dishName)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == Integer.parseInt(orderNumber))
                    {
                        order.removeDish(dishName);
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(order);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeIngredientName(String oldIngredientName, String newIngredientName)
    {
        File folder = new File(filePath + "IngredientsDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Ingredient ingredient = (Ingredient) ois.readObject();
                    if (ingredient.getName().equals(oldIngredientName))
                    {
                        ingredient.setName(newIngredientName);
                        File f = new File(filePath + "IngredientsDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "IngredientsDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbIngredient = filePath + "IngredientsDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbIngredient)))
                        {
                            oos.writeObject(ingredient);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeDishName(String oldDishName, String newDishName)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(oldDishName))
                    {
                        dish.setName(newDishName);
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeDishPrice(String dishName, String newDishPrice)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(dishName))
                    {
                        dish.setPrice(newDishPrice);
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeDishTime(String dishName, String newDishTime)
    {
        File folder = new File(filePath + "DishesDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Dish dish = (Dish) ois.readObject();
                    if (dish.getName().equals(dishName))
                    {
                        dish.setMakeTime(newDishTime);
                        File f = new File(filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "DishesDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbDish = filePath + "DishesDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbDish)))
                        {
                            oos.writeObject(dish);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeOrderPrice(String orderNumber, String newOrderPrice)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == Integer.parseInt(orderNumber))
                    {
                        order.setPrice(Double.parseDouble(newOrderPrice));
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbOrder)))
                        {
                            oos.writeObject(order);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeOrderNumber(String oldOrderNumber, String newOrderNumber)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == Integer.parseInt(oldOrderNumber))
                    {
                        order.setTable(Integer.parseInt(newOrderNumber));
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbOrder)))
                        {
                            oos.writeObject(order);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void changeNumberOfDishesInOrder(String orderNumber, String numberOfDishes)
    {
        File folder = new File(filePath + "OrdersDB\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + listOfFiles[i].getName())))
                {
                    Order order = (Order) ois.readObject();
                    if (order.getTable() == Integer.parseInt(orderNumber))
                    {
                        order.setNumberOfDishes(Integer.parseInt(numberOfDishes));
                        File f = new File(filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName());
                        String s = filePath + "OrdersDB\\" + "\\" + listOfFiles[i].getName();
                        ois.close();
                        f.delete();
                        UUID uuid = UUID.randomUUID();
                        String uuidAsString = uuid.toString();
                        dbOrder = filePath + "OrdersDB\\" + uuidAsString + ".txt";
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbOrder)))
                        {
                            oos.writeObject(order);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}