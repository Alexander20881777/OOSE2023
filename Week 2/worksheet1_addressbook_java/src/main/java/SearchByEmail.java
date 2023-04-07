public class SearchByEmail implements Options
{
    private String email;
    private AddressBook book;
    public SearchByEmail(AddressBook inBook)
    {
        //INSTANTIATE SearchByEmail OBJECT
        this.book = inBook; //book object to search through (already instantiated and occupied elsewhere)
    }

    @Override
    public Entry doOption()
    {
        return book.findFromEmail(email);
    }

    public void setValue(String inEmail)
    {
        this.email = inEmail;
    }
}
