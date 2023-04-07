 import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    public static void main(String[] args)
    {
        showMenu();
    }
    
    public static void showMenu()
    {
        int numOption = 0;
        Scanner input = new Scanner(System.in);
        boolean loop, hasQuit;
        hasQuit = false;

        
        while (!hasQuit)
        {
            loop = true;
            while (loop)
            {
                try
                {
                    System.out.println("Enter an integer (1, 2, 3 or 4) to select from one of the following options");
                    numOption = input.nextInt();
                    loop = false; //successful operation passes previous line
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid input type: must be of type 'int'");
                    input.nextLine(); //refresh the Scanner's buffer to prevent infinite loop
                }
            }

            if (numOption == 1)
            {
                //Set Criteria
                System.out.println("1 chosen");
            }
            else if (numOption == 2)
            {
                //Set Output Format
                System.out.println("2 chosen");
            }
            else if (numOption == 3)
            {
                LoadDirectory init = new LoadDirectory();
                init.loadDir("../");
                System.out.println("3 chosen");
            }
            else if (numOption == 4)
            {
                //Quit
                hasQuit = true;
                System.out.println("You have quit");
            }
            else //should not happen
            {
                System.out.println("Invalid number input '" + numOption + "': was not a number from 1-4");
                //TODO: What to do here?
            }
        }
        input.close(); //prevent resource leaks
        

    }

    public void enterSearchCriteria()
    {
        
    }
}