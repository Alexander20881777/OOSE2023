import java.util.*;

/**
 * Contains all the address book entries.
 * 
 * @author ...
 */
public class AddressBook
{
    private HashMap<String, Entry> nameHash;
    private HashMap<String, Entry> emailHash;

    public AddressBook()
    {
        nameHash = new HashMap<String, Entry>();
        emailHash = new HashMap<String, Entry>(); //initialize the two hashmaps containing relevant entries.
    }

    public void addName(String inName, Entry inEntry)
    {
        //int code = nameHash.hashCode(inName);
        nameHash.put(inName, inEntry);
    }

    public void addEmail(String inEmail, Entry inEntry)
    {
        //int code = emailHash.hashCode(inEmail);
        emailHash.put(inEmail, inEntry);
    }

    public Entry findFromName(String name)
    {
        Entry returnVal = nameHash.get(name);
        return returnVal;
    }
    
    public Entry findFromEmail(String email)
    {
        Entry returnVal = emailHash.get(email);
        return returnVal;
    }
    // Insert your code here.
}
