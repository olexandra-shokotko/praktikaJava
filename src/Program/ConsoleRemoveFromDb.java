package Program;

import BLL.EntityService;
import BLL.IEntityServiceInterface;

import java.util.Scanner;

public class ConsoleRemoveFromDb
{
    IEntityServiceInterface entityService;
    private Scanner in = new Scanner(System.in);

    private String ingredientName;
    private String dishName;
    private int orderNumber;

    public ConsoleRemoveFromDb()
    {
        entityService = new EntityService();
    }

    public void start(String selectedType)
    {
        try
        {
            if (selectedType.equals("Ingredient"))
            {
                ingredientName = getInputData("Input ingredient name to remove it:");
                entityService.removeIngredient(ingredientName);
            }
            else if(selectedType.equals("Dish"))
            {
                dishName = getInputData("Input dish name:");
                entityService.removeDish(dishName);
            }else if(selectedType.equals("Order"))
            {
                orderNumber = Integer.parseInt(getInputData("Input order number:"));
                entityService.removeOrder(orderNumber);
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
