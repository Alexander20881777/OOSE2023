import java.io.*;
import java.util.*;

public class FileReader 
{
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
            line = buffReader.readLine();
            while (line != null)
            {
                lines.add(line);
                line = buffReader.readLine();
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
