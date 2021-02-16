import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

interface Search
{
    public ArrayList<Book> SearchByTitle(String title);
    public ArrayList<Book> SearchByAuthor(String author);
    public ArrayList<Book> SearchBySubject(String subject);
}
public class BookCatalog implements Search
{

    private ArrayList<BookItem> bookItems;
    private HashMap<Book, Integer> countBooks;
    private HashMap<String, ArrayList<Book>> titleBook, subjectBook;
    private HashMap<Author, ArrayList<Book>> authorBook;

    BookCatalog()
    {
        bookItems = new ArrayList<>();
        countBooks = new HashMap<>();
        titleBook = new HashMap<>();
        subjectBook = new HashMap<>();
        authorBook = new HashMap<>();
    }
    public void addBookItem(BookItem bookItem)
    {
        bookItems.add(bookItem);
    }
    public void removeBookItem(BookItem bookItem)
    {
        bookItems.remove(bookItem);
    }

    public void updateCatalog(boolean isBorrow, BookItem bookItem)
    {
        String isbn = bookItem.getISBNNo();
        countBooks.forEach((book, integer) -> {
            String curr_isbn = book.getISBNNo();
            if (curr_isbn == isbn) {
                int value = countBooks.get(book);
                if(isBorrow)
                    countBooks.put(book, value - 1);
                else
                    countBooks.put(book, value + 1);
                return;
            }
        });

    }
    public void addBook(Book book) {
        if (countBooks.containsKey(book))
        {
            int value = countBooks.get(book);
            countBooks.put(book, value + 1);
        }
        else
            countBooks.put(book, 1);

        updateTitle(book);
        updateAuthor(book);
    }

    public void removeBook(Book book)
    {
        if(!countBooks.containsKey(book) || countBooks.get(book) == 0)
        {
            System.out.println("Book Not present");
            return;
        }
        else
        {
            int count = countBooks.get(book);
            countBooks.put(book, count-1);
        }

    }
    public void updateTitle(Book book)
    {
        if(titleBook.containsKey(book.getTitle()))
        {
            ArrayList<Book> availableBooks = titleBook.get(book.getTitle());
            if(!availableBooks.contains(book))
                availableBooks.add(book);
            titleBook.put(book.getTitle(), availableBooks);
        }
        else{
            ArrayList<Book> b = new ArrayList<>();
            b.add(book);
            titleBook.put(book.getTitle(), b);
        }

    }

    public void updateAuthor(Book book)
    {
        if(authorBook.containsKey(book.getAuthor()))
        {
            ArrayList<Book> availableBooks = authorBook.get(book.getAuthor());
            if(!availableBooks.contains(book))
                availableBooks.add(book);
            authorBook.put(book.getAuthor(), availableBooks);
        }
        else{
            ArrayList<Book> b = new ArrayList<>();
            b.add(book);
            authorBook.put(book.getAuthor(), b);
        }

    }



    @Override
    public ArrayList<Book> SearchByTitle(String title) {
        return titleBook.get(title);
    }

    @Override
    public ArrayList<Book> SearchByAuthor(String author) {
        return authorBook.get(author);
    }

    @Override
    public ArrayList<Book> SearchBySubject(String subject) {
        return subjectBook.get(subject);
    }


    public boolean isBookAvailable(BookItem bookitem)
    {
        AtomicBoolean isPresent = new AtomicBoolean(false);
        String isbn = bookitem.getISBNNo();
        countBooks.forEach((book, integer) -> {
            String curr_isbn = book.getISBNNo();
            if (curr_isbn == isbn) {
                int value = countBooks.get(book);
                if (value == 0)
                    isPresent.set(false);
                else
                    isPresent.set(true);

            }
        });
        return isPresent.get();
    }
}