package Program;

import BLL.EntityService;
import BLL.IEntityServiceInterface;

import java.util.Scanner;

public class ConsoleChangeInformation
{
    IEntityServiceInterface entityService;
    private Scanner in = new Scanner(System.in);

    private String ingredientName;
    private String dishName;
    private String orderNumber;

    public ConsoleChangeInformation() { entityService = new EntityService(); }

    public void addIngredientToDish()
    {
        try
        {
            dishName = getInputData("Input dish name to add ingredient to it:");
            ingredientName = getInputData("Input ingredient name to add to dish:");
            entityService.addIngredientToDish(dishName, ingredientName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void removeIngredientFromDish()
    {
        try
        {
            dishName = getInputData("Input dish name to remove ingredient from it:");
            ingredientName = getInputData("Input ingredient name to remove from dish:");
            entityService.removeIngredientFromDish(dishName, ingredientName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void addDishToOrder()
    {
        try
        {
            orderNumber = getInputData("Input order number to add dish to it:");
            dishName = getInputData("Input dish name to add to order:");
            entityService.addDishToOrder(orderNumber, dishName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void removeDishFromOrder()
    {
        try
        {
            orderNumber = getInputData("Input dish name to remove ingredient from it:");
            dishName = getInputData("Input ingredient name to remove from dish:");
            entityService.removeDishFromOrder(orderNumber, dishName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeIngredientName()
    {
        try
        {
            String oldIngredientName = getInputData("Input old ingredient name:");
            String newIngredientName = getInputData("Input new ingredient name: ");
            entityService.changeIngredientName(oldIngredientName, newIngredientName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeDishName()
    {
        try
        {
            String oldDishName = getInputData("Input old dish name:");
            String newDishName = getInputData("Input new dish name: ");
            entityService.changeDishName(oldDishName, newDishName);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeDishPrice()
    {
        try
        {
            String dishName = getInputData("Input dish name:");
            String newDishPrice = getInputData("Input new dish price: ");
            entityService.changeDishPrice(dishName, newDishPrice);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeDishTime()
    {
        try
        {
            String dishName = getInputData("Input dish name:");
            String newDishTime = getInputData("Input new dish time: ");
            entityService.changeDishTime(dishName, newDishTime);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeOrderPrice()
    {
        try
        {
            String orderNumber = getInputData("Input order number:");
            String newOrderPrice = getInputData("Input new order total price: ");
            entityService.changeOrderPrice(orderNumber, newOrderPrice);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeOrderNumber()
    {
        try
        {
            String oldOrderNumber = getInputData("Input old order number:");
            String newOrderNumber = getInputData("Input new order number: ");
            entityService.changeOrderNumber(oldOrderNumber, newOrderNumber);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public void changeNumberOfDishesInOrder()
    {
        try
        {
            String orderNumber = getInputData("Input order number:");
            String numberOfDishes = getInputData("Input number of dishes: ");
            entityService.changeNumberOfDishesInOrder(orderNumber, numberOfDishes);
        }catch(Exception e)
        {
            System.out.println("\tError: " + e.getMessage());
        }
    }

    public String getInputData(String prompt) throws Exception
    {
        System.out.println(prompt);
        String field = in.nextLine();
        if(field.equals(""))
        {
            throw new Exception("Empty input");
        }
        return field;
    }
}
