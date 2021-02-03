import java.lang.reflect.Array;
import java.util.ArrayList;

abstract public class Account {
    private String barCode;
    private Address address;
    private String name;
    private String age;

    public Account(String barCode, Address address, String name, String age) {
        this.barCode = barCode;
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public String getBarCode() {
        return barCode;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}


public class MemberAccount extends Account {

    private String dateOfMembership;
    private int noOfBooksBorrowed;

    public MemberAccount(String barCode, Address address, String name, String age, String dateOfMembership) {
        super(barCode, address, name, age);
        this.dateOfMembership = dateOfMembership;
        this.noOfBooksBorrowed = 0;
    }

    public ReservationStatus borrowBook(Library library, BookItem item) {
        if(!library.isMember(this))
            return ReservationStatus.CANCELLED;

        BookCatalog bc = library.getBookCatalog();
        if(!bc.isBookItemAvailable(item))
            return ReservationStatus.CANCELLED;

        bc.removeBookItem(item);

    }

    public boolean returnBook(BookItem item) {

    }

    public ReservationStatus renewBook(BookItem item) {

    }


}

public class AdminAccount extends MemberAccount {

    public AdminAccount(String barCode, Address address, String name, String age, String dateOfMembership) {
        super(barCode, address, name, age, dateOfMembership);
    }

    public void addBook(){

    }
    public void addBookItem(BookItem bookItem, Library library) {
        BookCatalog bc = library.getBookCatalog();
        bc.addBookItem(bookItem);
    }

    public void removeBookItem(BookItem bookItem, Library library) {
        BookCatalog bc = library.getBookCatalog();
        bc.removeBookItem(bookItem);
    }

    public int addMember(Library library, MemberAccount account) {
        library.addMembers(account);
    }

    public boolean removeMember(Library library, MemberAccount account) {
        library.removeMembers(account);
    }

}
