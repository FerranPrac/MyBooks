package cat.nilnet.mybooks.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * A map of sample book items, by ID.
     */
    public static final Map<Integer, BookItem> BOOK_ITEM_MAP = new HashMap<Integer, BookItem>();

    private static final int COUNT = 25;

    /*static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addBookItem(createBookItem(i));
        }
    }*/


    private static void addBookItem(BookItem book) {
        BOOKS_ITEMS.add(book);
        BOOK_ITEM_MAP.put(book.getId(), book);
    }


    private static BookItem createBookItem(int position) {
        return new BookItem(position, "Title" + position, "Author" + position, "Description " + position);
    }


    public static List<BookItem> getAll(int position) {
        for (int i = position; i <= COUNT; i++) {
            addBookItem(createBookItem(i));
        }

        return BOOKS_ITEMS;
    }


}
