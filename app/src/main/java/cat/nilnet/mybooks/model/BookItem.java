package cat.nilnet.mybooks.model;

import com.orm.SugarRecord;

import java.util.Date;

public class BookItem extends SugarRecord<BookItem> {


    String title;
    String author;
    Date publish_date;
    String description;
    String image_url;


    public BookItem(){
    }

    public BookItem(String title, String author, String description) {

        this.title = title;
        this.author = author;
        this.publish_date = new Date();
        this.description = description;
        this.image_url = "de moment és imatge fixe";
    }




    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getPublish_date() {
        return publish_date;
    }
}
