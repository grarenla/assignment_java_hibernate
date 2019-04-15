package model;

import entity.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class AccountModel {
    public void insert(Account account) {
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public Account getAccount(String username, String password) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Account acc where acc.username=:username and acc.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Account> result = query.getResultList();
//        session.getTransaction().commit();
//        session.close();
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
