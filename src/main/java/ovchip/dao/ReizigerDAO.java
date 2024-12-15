package ovchip.dao;

import ovchip.domain.Reiziger;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

public interface ReizigerDAO {
    void save(Reiziger reiziger) throws SQLException;
    void update(Reiziger reiziger);
    void delete(Reiziger reiziger);
    Reiziger findById(int id);
    List<Reiziger> findAll();
}

