package ovchip.dao;

import org.hibernate.Transaction;
import ovchip.domain.Adres;
import ovchip.domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ovchip.util.HibernateUtil;

import java.util.List;

public class AdresDAOPHibernate implements AdresDAO {

    public void save(Adres adres) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(adres);
        transaction.commit();
        session.close();
    }

    public void update(Adres adres) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(adres);
        transaction.commit();
        session.close();
    }

    public void delete(Adres adres) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(adres);
        transaction.commit();
        session.close();
    }

    public Adres findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Adres adres = session.get(Adres.class, id);
        session.close();
        return adres;
    }

    public List<Adres> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Adres> adressen = session.createQuery("FROM Adres", Adres.class).list();
        session.close();
        return adressen;
    }
}