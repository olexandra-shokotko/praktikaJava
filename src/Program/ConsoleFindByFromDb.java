package Program;

import BLL.EntityService;
import BLL.IEntityServiceInterface;
import Model.Ingredient;
import Model.Order;

import java.util.Scanner;

public class ConsoleFindByFromDb
{
    private Scanner in = new Scanner(System.in);
    IEntityServiceInterface entityService;
    private String ingredientName;
    private int orderNumber;

    public ConsoleFindByFromDb() { entityService = new EntityService(); }

    public void start(String selectedType)
    {
        try
        {
            if (selectedType.equals("Ingredient"))
            {
                ingredientName = getInputData("Input ingredient name:");
                Ingredient ingredient = entityService.findByIngredientName(ingredientName);
                System.out.println(ingredient);
            }else if(selectedType.equals("Order"))
            {
                orderNumber = Integer.parseInt(getInputData("Input order number:"));
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
