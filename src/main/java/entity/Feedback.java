package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
//    @Column(name = "accountId")
//    private int accountId;
    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    public Feedback() {
    }

    public Feedback(int id, String title, String description, int accountId, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
//        this.accountId = accountId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(int accountId) {
//        this.accountId = accountId;
//    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @SuppressWarnings("JpaAttributeTypeInspection")
    private HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public boolean isValid() {
        checkErrors();
        System.out.println("error feedback size: " + errors.size());
        return errors.size() == 0;
    }

    private void checkErrors() {
        ArrayList<String> titleErrors = errors.get("title");
        if (titleErrors == null) {
            titleErrors = new ArrayList<>();
        }
        if (title == null || title.length() == 0) {
            titleErrors.add("Title không được để trống.");
        }

        if (titleErrors.size() > 0) errors.put("username", titleErrors);


        ArrayList<String> descriptionErrors = errors.get("description");
        if (descriptionErrors == null) {
            descriptionErrors = new ArrayList<>();
        }
        System.out.println("description: " + description);
        if ((description == null) || (description.length() == 0)) {
            descriptionErrors.add("Description không được để trống.");
        }

        if (descriptionErrors.size() > 0) errors.put("password", descriptionErrors);
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }

}
