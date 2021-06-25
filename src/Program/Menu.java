package Program;

import java.util.Scanner;

public class Menu
{
    Scanner in = new Scanner(System.in);
    public static boolean isExit = false;
    public void MainMenu()
    {
        while(!isExit)
        {
            System.out.println("\nShow options? (y/n)");
            String answer = in.nextLine();
            if (answer.equals("y"))
            {
                showOptions();
                String option = in.nextLine();
                doAction(option);
            }else
            {
                isExit = true;
            }
        }
    }
    private void showOptions()
    {
        System.out.println("");
        System.out.println("Choose number of option:");

        System.out.println("Ingredients management");
        System.out.println("\t1.1 Add ingredient");
        System.out.println("\t1.2 Remove ingredient");
        System.out.println("\t1.3 Change ingredient");
        System.out.println("\t1.4 Show all ingredients");

        System.out.println("\nDishes management");
        System.out.println("\t2.1 Add dish");
        System.out.println("\t2.2 Remove dish");
        System.out.println("\tChange dish");
        System.out.println("\t\t2.3.1 Add ingredient to dish");
        System.out.println("\t\t2.3.2 Remove ingredient from dish");
        System.out.println("\t\t2.3.3 Change dish name");
        System.out.println("\t\t2.3.4 Change dish price");
        System.out.println("\t\t2.3.5 Change time to cook a dish");
        System.out.println("\t2.4 Show information about dish");
        System.out.println("\t2.5 Show all dishes");

        System.out.println("\nOrders management");
        System.out.println("\t3.1 Add order");
        System.out.println("\t3.2 Remove order");
        System.out.println("\tChange order");
        System.out.println("\t\t3.3.1 Change number of dishes");
        System.out.println("\t\t3.3.2 Change total price of order");
        System.out.println("\t\t3.3.3 Change table number of order");
        System.out.println("\t3.4 Show information about order");
        System.out.println("\t3.5 Show all orders");

        System.out.println("\nFind");
        System.out.println("\t4.1 Find ingredient by name");
        System.out.println("\t4.2 Find order by table number");

        System.out.println("\n5) Exit");
    }

    private void doAction(String option)
    {
        ConsoleInputToDb ci = new ConsoleInputToDb();
        ConsoleGetFromDb cg = new ConsoleGetFromDb();
        ConsoleRemoveFromDb cr = new ConsoleRemoveFromDb();
        ConsoleGetInformation cgi = new ConsoleGetInformation();
        ConsoleFindByFromDb cf = new ConsoleFindByFromDb();
        ConsoleChangeInformation chi = new ConsoleChangeInformation();

        switch(option)
        {
            //Ingredient
            case "1.1":
                ci.start("Ingredient");
                break;
            case "1.2":
                cr.start("Ingredient");
                break;
            case "1.3":
                chi.changeIngredientName();
                break;
            case "1.4":
                cg.start("Ingredient");
                break;

            //Dish
            case "2.1":
                ci.start("Dish");
                break;
            case "2.2":
                cr.start("Dish");
                break;
            case "2.3.1":
                chi.addIngredientToDish();
                break;
            case "2.3.2":
                chi.removeIngredientFromDish();
                break;
            case "2.3.3":
                chi.changeDishName();
                break;
            case "2.3.4":
                chi.changeDishPrice();
                break;
            case "2.3.5":
                chi.changeDishTime();
                break;
            case "2.4":
                cgi.start("Dish");
                break;
            case "2.5":
                cg.start("Dish");
                break;

            //Order
            case "3.1":
                ci.start("Order");
                break;
            case "3.2":
                cr.start("Order");
                break;
            case "3.3.1":
                chi.changeNumberOfDishesInOrder();
                break;
            case "3.3.2":
                chi.changeOrderPrice();
                break;
            case "3.3.3":
                chi.changeOrderNumber();
                break;
            case "3.4":
                cgi.start("Order");
                break;
            case "3.5":
                cg.start("Order");
                break;

            //Find
            case "4.1":
                cf.start("Ingredient");
                break;
            case "4.2":
                cf.start("Order");
                break;

            case "5":
                System.out.println("Bye!");
                isExit = true;
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
