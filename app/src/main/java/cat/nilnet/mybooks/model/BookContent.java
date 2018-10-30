package cat.nilnet.mybooks.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cat.nilnet.mybooks.BookListActivity;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * Modificat per utilitzar BookItems
 *
 */
public class BookContent {

    /**
     * An array of sample book items.
     */
    public static final List<BookItem> BOOKS_ITEMS = new ArrayList<BookItem>();

    private static final String TAG = BookContent.class.getSimpleName();
    /**
     * A map of sample book items, by ID.
     */
    public static final Map<Long, BookItem> BOOK_ITEM_MAP = new HashMap<Long, BookItem>();

    private static final int COUNT = 25;


    private static void addBookItem(BookItem book) {
        BOOKS_ITEMS.add(book);
        BOOK_ITEM_MAP.put(book.getId(), book);
    }


    private static BookItem createBookItem(int position) {

        BookItem book =  new BookItem("Titlesad" + position, "Authorasd" + position, "Descriptionasd " + position);
        book.save();
        return book;
    }


    public static void createBooksList() {
        for (int i = 1; i <= COUNT; i++) {
            addBookItem(createBookItem(i));
        }

        return;
    }

    public static List<BookItem> getBooks() {

        List<BookItem> books = BookItem.listAll(BookItem.class);
        return books;
    }

    public static boolean exists (String title) {

        List<BookItem> books = BookItem.find(BookItem.class, "title = ?", title);

        if (books.isEmpty()) {
            Log.i(BookContent.TAG, "not found " + title);
            return false;
        } else {
            Log.i(BookContent.TAG, "found " + title);
            return true;
        }


    }

    public static void fetchData() {
        final DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();

        dbReference
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.w(BookContent.TAG, "onDataChange");
                        List<BookItem> books = dataSnapshot.child("books").getValue(new GenericTypeIndicator<List<BookItem>>() {
                        });
                        ListIterator<BookItem> i = books.listIterator();
                        BookItem bookItem;

                        while (i.hasNext()) {
                            bookItem = i.next();


                            if (!exists(bookItem.title)) {
                                Log.i(BookContent.TAG, "Inserting " + bookItem.title);
                                BookItem newBook = new BookItem(bookItem.title, bookItem.author , bookItem.description);
                                newBook.save();
                            }
                        }

                        dbReference.removeEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.i(BookContent.TAG, "Firebase error " + databaseError.getMessage());
                        dbReference.removeEventListener(this);
                    }
                });
    }
}
