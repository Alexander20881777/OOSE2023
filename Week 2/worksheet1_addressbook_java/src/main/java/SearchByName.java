public class SearchByName implements Options
{
    private String name;
    private AddressBook book;
    public SearchByName(AddressBook inBook)
    {
        //INSTANTIATE SearchByName OBJECT
        this.book = inBook; //book object to search through (already instantiated and occupied elsewhere)
    }

    @Override
    public Entry doOption()
    {
        return book.findFromName(name);
    }

    public void setValue(String inName)
    {
        this.name = inName;
    }

}
