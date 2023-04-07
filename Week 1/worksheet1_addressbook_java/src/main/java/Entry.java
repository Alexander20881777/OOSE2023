import java.util.*;
        
/**
 * Represents a single address book entry.
 * 
 * @author ...
 */
public class Entry 
{
    String[] entryVals;

    public Entry(String[] inEntry) // param constructor creating complete entry, a value to be held within several key-value pairs, who's keys will be derived from the entry's components
    {
        entryVals = inEntry;
    }

    public void displayEntry()
    {
        for (int i = 0; i < entryVals.length; i++)
        {
            System.out.println(entryVals[i] + '\t');
        }
    }
}

