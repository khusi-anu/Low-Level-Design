public class Library {
    private String name;
    private int id;
    private Address address;

    public Library(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
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

}
