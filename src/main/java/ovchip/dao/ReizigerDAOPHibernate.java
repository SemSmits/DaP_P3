package ovchip.dao;

import org.hibernate.Transaction;
import ovchip.domain.Reiziger;
import org.hibernate.Session;
import ovchip.util.HibernateUtil;

import java.util.List;

public class ReizigerDAOPHibernate implements ReizigerDAO {

    public void save(Reiziger reiziger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(reiziger);
        transaction.commit();
        session.close();
    }

    public void update(Reiziger reiziger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(reiziger);
        transaction.commit();
        session.close();
    }

    public void delete(Reiziger reiziger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reiziger);
        transaction.commit();
        session.close();
    }

    public Reiziger findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Reiziger reiziger = session.get(Reiziger.class, id);
        session.close();
        return reiziger;
    }

    public List<Reiziger> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reiziger> reizigers = session.createQuery("FROM Reiziger", Reiziger.class).list();
        session.close();
        return reizigers;
    }
}