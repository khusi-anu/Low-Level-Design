import jdk.jshell.Snippet;

public class BookItem extends Book {
    private int bookId;
    private BookStatus status;
    private BookReservation reservation;

    public BookItem(String title, String barCodeNo, String subject, String publisher, Author author, String language, int bookId) {
        super(title, barCodeNo, subject, publisher, author, language);
        this.bookId = bookId;
        status = BookStatus.AVAILABLE;
        reservation = new BookReservation();
    }

    public int getBookId() {
        return bookId;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookReservation getReservation() {
        return reservation;
    }
}
