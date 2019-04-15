package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public Account(String username, String password, UserInformation userInformation) {
        this.username = username;
        this.password = password;
        this.userInformation = userInformation;
    }


    @OneToOne(cascade = CascadeType.ALL)
    private UserInformation userInformation;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Feedback> feedbacks = new HashSet<>();

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }


    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "account_role",
            joinColumns = { @JoinColumn(name = "accountId") },
            inverseJoinColumns = { @JoinColumn(name = "roleId") }
    )
    private Set<Role> roles = new HashSet<>();

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public Account() {
    }

    @SuppressWarnings("JpaAttributeTypeInspection")
    private HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public boolean isValid() {
        checkErrors();
        System.out.println("error size: " + errors.size());
        return errors.size() == 0;
    }

    private void checkErrors() {
        ArrayList<String> usernameErrors = errors.get("username");
        if (usernameErrors == null) {
            usernameErrors = new ArrayList<>();
        }
        if (username == null || username.length() == 0) {
            usernameErrors.add("username Không được để trống.");
        }
        if (username != null && (username.length() < 2 || username.length() > 20)) {
            usernameErrors.add("username phải lớn hơn 2 và nhỏ hơn 20 kí tự.");
        }

        if (usernameErrors.size() > 0) errors.put("username", usernameErrors);


        ArrayList<String> passwordErrors = errors.get("password");
        if (passwordErrors == null) {
            passwordErrors = new ArrayList<>();
        }
        if ((password == null) || (password.length() == 0)) {
            passwordErrors.add("password Không được để trống.");
        }
        if (password != null && (password.length() < 6)) {
            passwordErrors.add("password phải lớn hơn 6 kí tự.");
        }
        if (passwordErrors.size() > 0) errors.put("password", passwordErrors);

    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
