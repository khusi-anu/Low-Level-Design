import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

abstract class Account {
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


class MemberAccount extends Account {

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
        if(!bc.isBookAvailable(item))
            return ReservationStatus.CANCELLED;

        bc.removeBookItem(item);
        bc.updateCatalog(true, item);
        item.getReservation().setStatus(ReservationStatus.COMPLETED);
        item.getReservation().setDayOfBooking(new Date());
        item.setStatus(BookStatus.RESERVED);
        return ReservationStatus.COMPLETED;
    }

    public ReservationStatus returnBook(Library library, BookItem item) {
        if(!library.isMember(this))
            return ReservationStatus.CANCELLED;

        BookCatalog bc = library.getBookCatalog();
        if(!bc.isBookAvailable(item))
            return ReservationStatus.CANCELLED;

        bc.removeBookItem(item);
        bc.updateCatalog(false, item);
        int fine = item.getReservation().calculateFine();
        System.out.println("Your fine is " + fine);
        item.getReservation().setStatus(ReservationStatus.UNRESERVED);
        return ReservationStatus.COMPLETED;
    }

    public ReservationStatus renewBook(Library library, BookItem item) {
        returnBook(library, item);
        borrowBook(library, item);
        return ReservationStatus.COMPLETED;
    }


}

class AdminAccount extends MemberAccount {

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

    public void addMember(Library library, MemberAccount account) {
        library.addMembers(account);
    }

    public void removeMember(Library library, MemberAccount account) {
        library.removeMembers(account);
    }

}
