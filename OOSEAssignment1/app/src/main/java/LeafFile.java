import java.util.*;

public class LeafFile extends FileComponent
{
    private ArrayList<String> contents;
    public LeafFile()
    {
        this.name = null;
        this.file = null;
    }

    @Override
    public boolean isNode(FileComponent check) //overrides default implementation (which returns true)
    {
        return false;
    }

    public void setContents(ArrayList<String> inContents)
    {
        this.contents = inContents;
    }
}
