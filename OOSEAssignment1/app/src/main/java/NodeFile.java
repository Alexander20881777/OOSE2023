import java.io.*;
import java.util.*;

public class NodeFile extends FileComponent
{
    private ArrayList<FileComponent> contents;

    public NodeFile()
    {
        this.contents = new ArrayList<FileComponent>(); //instantiate new FileComponent object list
        this.name = null;
        this.file = null; //FileComponent defines these variables
    }

    public void addNodeFile(NodeFile newNode)
    {
        contents.add(newNode);
    }

    public void addLeafFile(LeafFile newNode)
    {
        contents.add(newNode);
    }

    public ArrayList<FileComponent> getContents()
    {
        return this.contents;
    }
}