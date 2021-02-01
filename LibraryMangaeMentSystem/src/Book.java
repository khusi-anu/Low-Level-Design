public class Book {
    private String title;
    private String barCodeNo;
    private String subject;
    private String publisher;
    private Author author;
    private String language;

    public Book(String title, String barCodeNo, String subject, String publisher, Author author, String language) {
        this.title = title;
        this.barCodeNo = barCodeNo;
        this.subject = subject;
        this.publisher = publisher;
        this.author = author;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getBarCodeNo() {
        return barCodeNo;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBarCodeNo(String barCodeNo) {
        this.barCodeNo = barCodeNo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
