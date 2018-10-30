package cat.nilnet.mybooks.model;

import java.util.Date;

public class BookItemOld {


    private int id;
    private String title;
    private String author;
    private Date publish_date;
    private String description;
    private String image_url;



    public BookItemOld(int id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish_date = new Date();
        this.description = description;
        this.image_url = "de moment és imatge fixe";
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublish_date() {
        return publish_date;
    }
}
