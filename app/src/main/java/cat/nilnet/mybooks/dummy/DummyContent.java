package cat.nilnet.mybooks.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cat.nilnet.mybooks.model.BookItem;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    //public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * An array of sample book items.
     */
    public static final List<BookItem> BOOKS_ITEMS = new ArrayList<BookItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    //public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    /**
     * A map of sample book items, by ID.
     */
    public static final Map<Integer, BookItem> BOOK_ITEM_MAP = new HashMap<Integer, BookItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            //addItem(createDummyItem(i));

            addBookItem(createBookItem(i));
        }
    }

    /*private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }*/

    private static void addBookItem(BookItem book) {
        BOOKS_ITEMS.add(book);
        BOOK_ITEM_MAP.put(book.getId(), book);
    }

    /*private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }*/

    private static BookItem createBookItem(int position) {
        return new BookItem(position, "Title" + position, "Author" + position, "Description " + position);
    }

    /*private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/


    /**
     * A dummy item representing a piece of content.
     */
    /*public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }*/
}
