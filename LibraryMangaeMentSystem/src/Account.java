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

    public ReservationStatus borrowBook(BookItem item) {

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

    public int addBookItem() {

    }

    public boolean removeBookItem(BookItem bookItem) {

    }

    public int addMember(MemberAccount account) {

    }

    public boolean removeMember(MemberAccount account) {

    }

}
