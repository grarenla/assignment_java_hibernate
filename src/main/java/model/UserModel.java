package model;

import entity.Account;
//import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.*;
import java.util.List;

public class UserModel {
    Connection connection;

//    public void insert(User user) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password, fullName) VALUES(?, ?, ?)");
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFullName());
//
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
//    }


//    @SuppressWarnings("unchecked")
//    public Account getAccount(String username, String password) {
//        Session session = HibernateUtil.getSession();
//        Query query = session.createQuery("from Account acc where acc.username=:username and acc.password=:password");
//        query.setParameter("username", username);
//        query.setParameter("password", password);
//        List<Account> result = query.getResultList();
//        if (result.size() > 0) {
//            return result.get(0);
//        } else {
//            return null;
//        }
//    }
}
