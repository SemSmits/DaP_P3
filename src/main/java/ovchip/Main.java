package ovchip;

import ovchip.dao.AdresDAO;
import ovchip.dao.AdresDAOPHibernate;
import ovchip.dao.ReizigerDAO;
import ovchip.dao.ReizigerDAOPHibernate;
import ovchip.domain.Adres;
import ovchip.domain.Reiziger;
import ovchip.util.HibernateUtil;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        AdresDAO adresDAO = new AdresDAOPHibernate();
        ReizigerDAO reizigerDAO = new ReizigerDAOPHibernate();

        Reiziger reiziger1 = new Reiziger(1, "G", "van", "Rijn", new Date(102, Calendar.SEPTEMBER, 17));
        Adres adres1 = new Adres(1, "3511 LX", "37", "Oudegracht", "Utrecht");
        reiziger1.setAdres(adres1);
        adres1.setReiziger(reiziger1);
        adresDAO.save(adres1);
        reizigerDAO.save(reiziger1);

        Reiziger reiziger2 = new Reiziger(2, "B", "van", "Rijn", new Date(102, Calendar.OCTOBER, 22));
        Adres adres2 = new Adres(2, "3521 AL", "6A", "Vismarkt", "Utrecht");
        reiziger2.setAdres(adres2);
        adres2.setReiziger(reiziger2);
        adresDAO.save(adres2);
        reizigerDAO.save(reiziger2);

        Reiziger reiziger3 = new Reiziger(3, "H", "", "Lubben", new Date(98, Calendar.AUGUST, 11));
        Adres adres3 = new Adres(3, "6707 AA", "375", "Hoofdstraat", "Wageningen");
        reiziger3.setAdres(adres3);
        adres3.setReiziger(reiziger3);
        adresDAO.save(adres3);
        reizigerDAO.save(reiziger3);

        Reiziger reiziger4 = new Reiziger(4, "F", "", "Memari", new Date(102, Calendar.DECEMBER, 3));
        Adres adres4 = new Adres(4, "3817 CH", "4", "Koningstraat", "Amersfoort");
        reiziger4.setAdres(adres4);
        adres4.setReiziger(reiziger4);
        adresDAO.save(adres4);
        reizigerDAO.save(reiziger4);

        Reiziger reiziger5 = new Reiziger(5, "G", "", "Piccardo", new Date(102, Calendar.DECEMBER, 3));
        Adres adres5 = new Adres(5, "3572 WP", "22", "Maliebaan", "Utrecht");
        reiziger5.setAdres(adres5);
        adres5.setReiziger(reiziger5);
        adresDAO.save(adres5);
        reizigerDAO.save(reiziger5);

        List<Reiziger> allReizigers = reizigerDAO.findAll();
        for (Reiziger reiziger : allReizigers) {
            String adresString = reiziger.getAdres() != null
                    ? "Adres {#" + reiziger.getAdres().getId() + " " + reiziger.getAdres().getPostcode() + "-" + reiziger.getAdres().getHuisnummer() + "}"
                    : "Geen adres";
            System.out.println("Reiziger {#" + reiziger.getId() + " " + reiziger.getVoorletters() + ". " + (reiziger.getTussenvoegsel() != null && !reiziger.getTussenvoegsel().isEmpty() ? reiziger.getTussenvoegsel() + " " : "") + reiziger.getAchternaam() + ", geb. " + reiziger.getGeboortedatum() + ", " + adresString + "}");
        }

        HibernateUtil.shutdown();
    }
}

