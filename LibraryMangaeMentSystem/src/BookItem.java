public class BookItem extends Book {
    private int bookId;

    public BookItem(String title, String barCodeNo, String subject, String publisher, Author author, String language, int bookId) {
        super(title, barCodeNo, subject, publisher, author, language);
        this.bookId = bookId;
    }


}
