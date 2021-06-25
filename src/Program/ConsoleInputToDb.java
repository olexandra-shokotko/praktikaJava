package Program;
import java.util.ArrayList;
import java.util.Scanner;
import BLL.IEntityServiceInterface;
import BLL.EntityService;
import Model.Dish;
import Model.Ingredient;
import Model.Order;

public class ConsoleInputToDb
{
    private Scanner in = new Scanner(System.in);

    private String ingredientName;
    private String dishName;
    private String price;
    private String makeTime;
    private int orderNumber;
    IEntityServiceInterface entityService;

    public ConsoleInputToDb()
    {
        entityService = new EntityService();
    }

    public void start(String selectedType)
    {
        try
        {
            if (selectedType.equals("Ingredient"))
            {
                ingredientName = getInputData("Input ingredient name:");
                entityService.createAndStoreIngredient(ingredientName);
            }else if(selectedType.equals("Dish"))
            {
                dishName = getInputData("Input dish name:");
                makeTime = getInputData("Input dish making time:");
                price = getInputData("Input dish price:");
                entityService.createAndStoreDish(dishName, price, makeTime);
            }else if(selectedType.equals("Order"))
            {
                orderNumber = Integer.parseInt(getInputData("Input order number:"));
                entityService.createAndStoreOrder(orderNumber);
            }
            System.out.println("\tYour data has been saved into the database!\n");
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
