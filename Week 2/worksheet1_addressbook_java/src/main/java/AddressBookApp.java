

import java.io.*;
import java.util.*;

/**
 * A simple address book application.
 * @author Dave and ...
 */
public class AddressBookApp 
{

    public interface Option
    {
        public String doOptions(String s);
    }
    
    /** Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String fileName;
        String entryName;
        
        System.out.print("Enter address book filename: ");
        fileName = input.nextLine();
        
        try
        {
            AddressBook addressBook = readAddressBook(fileName);
            showMenu(addressBook);
        }
        catch(IOException e)
        {
            System.out.println("Could not read from " + fileName + ": " + e.getMessage());
        }
    }
    
    /**
     * Read the address book file, containing all the names and email addresses.
     *
     * @param fileName The name of the address book file.
     * @return A new AddressBook object containing all the information.
     * @throws IOException If the file cannot be read.
     */
    private static AddressBook readAddressBook(String fileName) throws IOException
    {
        AddressBook addressBook = new AddressBook();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            while(line != null)
            {
                String[] parts = line.split(":");
                Entry currentLine = new Entry(parts);       // makes a new entry filled with the current line         
                // FIXME: Insert your code here to add a new address book entry.
                // Note: 
                // parts[0] contains the person's name.
                // parts[1], parts[2], etc. contain the person's email address(es).

                addressBook.addName(parts[0], currentLine); //hash the name, used as a key pointing to this entry
                for (int i = 1; i < parts.length; i++)
                {
                    addressBook.addEmail(parts[i], currentLine); //hashes each email, used as keys pointing to this entry
                }
                
                line = reader.readLine();
            }
        }
        
        return addressBook;
    }
    
    /**
     * Show the main menu, offering the user options to (1) search entries by 
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    private static void showMenu(AddressBook addressBook)
    {
        Map<String, Options> options = new HashMap<>();
        options.put("1", new SearchByName(addressBook));
        options.put("2", new SearchByEmail(addressBook));
        boolean done = false;
        while(!done)
        {
            int option;
            System.out.println("(1) Search by name, (2) Search by email, (3) Quit");
            
            try
            {
                Options userOption;
                Entry displayEntry = null;
                String userInput;
                userInput = input.nextLine();
                if (userInput.equals("1") || userInput.equals("2"))
                {
                    userOption = options.get(userInput);
                    System.out.println("Enter a value to search for");
                    String nextInput = input.nextLine();
                    userOption.setValue(nextInput);
                    displayEntry = userOption.doOption();
                    displayEntry.displayEntry();
                }
                else
                {
                    done = true;
                    System.out.println("You have quit");
                }
                
                /*switch(Integer.parseInt(input.nextLine()))
                {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        
                        displayEntry = options.get("1").doOption();
                        displayEntry.displayEntry();
                        break;
                        
                    case 2:
                        System.out.print("Enter email address: ");
                        String email = input.nextLine();
                        
                        displayEntry = options.get(email).doOption();
                        displayEntry.displayEntry();
                        break;
                        
                    case 3:
                        done = true;
                        break;
                        
                    default:
                        System.out.println("Enter a valid number");
                        break;
                }*/
            }
            catch(NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
        }
    }
}
