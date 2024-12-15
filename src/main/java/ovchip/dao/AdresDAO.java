package ovchip.dao;

import ovchip.domain.Adres;
import ovchip.domain.Reiziger;

import java.util.List;

public interface AdresDAO {
    void save(Adres adres);
    void update(Adres adres);
    void delete(Adres adres);
    Adres findById(int id);
    List<Adres> findAll();
}

