import java.util.ArrayList;

public class Library {
    private String name;
    private int id;
    private Address address;
    private BookCatalog bookCatalog;
    ArrayList<MemberAccount> memberAccounts;

    public Library(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
        bookCatalog = new BookCatalog();
        memberAccounts = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BookCatalog getBookCatalog() {
        return bookCatalog;
    }

    public void addMembers(MemberAccount member)
    {
        memberAccounts.add(member);
    }
    public void removeMembers(MemberAccount member)
    {
        memberAccounts.remove(member);
    }

    public boolean isMember(MemberAccount member)
    {
        return memberAccounts.contains(member);
    }
}
