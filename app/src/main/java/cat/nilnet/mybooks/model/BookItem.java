package cat.nilnet.mybooks.model;

import java.util.Date;

public class BookItem {


    private int id;
    private String title;
    private String author;
    private Date publish_date;



    private String description;
    private String image_url;



    public BookItem(int id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish_date = new Date();
        this.description = description; //"Lorem ipsum dolor sit amet.\nWinter is coming.\nHola que tal estem. Això és una descripció fake del llibre.";
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
