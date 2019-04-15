package model;

import entity.Feedback;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

public class FeedbackModel {

    public void insert(Feedback feedback) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(feedback);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Feedback> getList() {

        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Feedback feedback where feedback.status=:status");
        query.setParameter("status", 1);
        List<Feedback> list = query.getResultList();
        if (list.size() == 0) list = new ArrayList<>();
        return (ArrayList<Feedback>) list;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Feedback> getListManage() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Feedback");
        List<Feedback> list = query.getResultList();
        if (list.size() == 0) list = new ArrayList<>();
        return (ArrayList<Feedback>) list;
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(Feedback.class, id));
        session.getTransaction().commit();
    }

    public void update(int id) {
        Session session = HibernateUtil.getSession();
        Feedback feedback = session.get(Feedback.class, id);
        feedback.setStatus(1);
        session.beginTransaction();
        session.update(feedback);
        session.getTransaction().commit();
    }
}
