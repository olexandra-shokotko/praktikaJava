package Program;

import BLL.EntityService;
import BLL.IEntityServiceInterface;
import Model.Dish;
import Model.Ingredient;
import Model.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGetInformation
{
    IEntityServiceInterface entityService;
    private Scanner in = new Scanner(System.in);

    private String dishName;
    private int orderNumber;

    public ConsoleGetInformation() { entityService = new EntityService(); }

    public void start(String selectedType)
    {
        try
        {
            if (selectedType.equals("Dish"))
            {
                dishName = getInputData("Input dish name:");
                Dish dish = entityService.getDishInformation(dishName);
                System.out.println(dish);
            }else if (selectedType.equals("Order"))
            {
                orderNumber = Integer.parseInt(getInputData("Input number of table:"));
                Order order = entityService.getOrderInformation(orderNumber);
                System.out.println(order);
            }
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
