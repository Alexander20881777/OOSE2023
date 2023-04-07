import java.util.*;
import java.io.*;


public abstract class FileComponent 
{
    protected String name; //each file component has a unique name
    protected File file; //protected to disallow public access but allow inheritance

    public String getName()
    {
        return this.name;
    }

    public File getFile()
    {
        return this.file;
    }

    public void setValues(String inName, File inFile)
    {
        System.out.println("Set some values!");
        this.name = inName;
        this.file = inFile;
    }

    public boolean isNode(FileComponent check) //to be overriden in non-node class
    {
        return true;
    }
}  

