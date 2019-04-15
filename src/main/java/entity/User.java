package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="fullName")
    private String fullName;
    @Column(name="role")
    private String role;

//    @OneToMany
//    @JoinColumn(name = "userId")
//    private Set<Feedback> feedbacks = new HashSet<Feedback>();

//    public Set<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    public void setFeedbacks(Set<Feedback> feedbacks) {
//        this.feedbacks = feedbacks;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String username, String password, String fullName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public User() {
    }
}
