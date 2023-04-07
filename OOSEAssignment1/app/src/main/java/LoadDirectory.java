import java.io.*;
import java.util.*;

public class LoadDirectory 
{
    public LoadDirectory()
    {
        //constructor
    }
    public void loadDir(String dirName)
    {
        File currentFile = new File(dirName);
        NodeFile parentFile = new NodeFile();
        parentFile.setValues(dirName, currentFile);
        loadDirRec(parentFile);
        searchDir(parentFile);
    }

    public void loadDirRec(NodeFile parentFile) //requires instatiated parent file Node object
    {
        File[] contents = parentFile.getFile().listFiles(); //node object's file; list of this directories' inner files

        if (contents != null) //if root is an existing directory
        {
            for (File currentFile : contents) //for each directory in Contents
            {
                String dirName = currentFile.getName(); //get the current file's name
                //if current file is a directory itself
                if (currentFile.isDirectory()) //is a NodeFile
                {
                    NodeFile newNode = new NodeFile();
                    newNode.setValues(dirName, currentFile);
                    parentFile.addNodeFile(newNode); //add currentNode to the parent's list
                     //get the current folder's contents and store them in its internal data
                    loadDirRec(newNode); //recursively call until base(leaf) files are reached
                }
                else //is a leaf
                {
                    LeafFile newLeaf = new LeafFile();
                    newLeaf.setValues(dirName, currentFile);
                    newLeaf.setContents(readFile(currentFile)); // read the leaf object's file's contents, then store them in the leaf object
                    parentFile.addLeafFile(newLeaf);
                    //leaf is found, instantiated inside addLeafFile method
                }
            }
        }
    }

    public void searchDir(NodeFile parentNode)
    {
        System.out.println(parentNode.getName());
        ArrayList<FileComponent> components = parentNode.getContents();
        //System.out.println(components.size());
        for (FileComponent currentComponent : components)
        {
            //System.out.println("Checking contents");
            if (currentComponent.isNode(currentComponent))
            {
                searchDir((NodeFile)currentComponent); //can cast to NodeFile as a check has been satisfied
            }
            else
            {
                System.out.println(currentComponent.getName());
            }
        }
    }

    public ArrayList<String> readFile(File inFile)
    {
        ArrayList<String> lines = new ArrayList<String>();
        FileInputStream fileStream = null;
        InputStreamReader streamReader;
        BufferedReader buffReader;
        int lineNum;
        String line;
        try 
        {
            fileStream = new FileInputStream(inFile);
            streamReader = new InputStreamReader(fileStream);
            buffReader = new BufferedReader(streamReader);
            lineNum = 0;
            line = buffReader.readLine();
            while (line != null)
            {
                lines.add("[" + lineNum + "]: " + line);
                line = buffReader.readLine();
                lineNum++;
            }
            fileStream.close();
        }
        catch(IOException e)
        {
            System.out.println("Error in file processing: " + e.getMessage());
        }
        return lines;
    }

}
