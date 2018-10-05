package cat.nilnet.mybooks;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import cat.nilnet.mybooks.dummy.DummyContent;
import cat.nilnet.mybooks.model.BookItem;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link BookListActivity}
 * in two-pane mode (on tablets) or a {@link BookDetailActivity}
 * on handsets.
 */
public class BookDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";


    /**
     * The dummy content this fragment is presenting.
     */
    private BookItem bookItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            bookItem = DummyContent.BOOK_ITEM_MAP.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));

            Log.v("ARG_ITEM ID", String.valueOf(bookItem.getId()));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(bookItem.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (bookItem != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            ((TextView) rootView.findViewById(R.id.textAuthor)).setText(bookItem.getAuthor());
            ((TextView) rootView.findViewById(R.id.textDate)).setText(sdf.format(bookItem.getPublish_date()));
            ((TextView) rootView.findViewById(R.id.textDescription)).setText(bookItem.getDescription());
        }

        return rootView;
    }
}
