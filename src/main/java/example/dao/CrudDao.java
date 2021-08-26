package example.dao;

import config.Passport;

import java.util.List;

public interface CrudDao <T, ID> {

    void save(T model);

    List<Passport> updatePassportSeries(int id, Long Series);

    void delete(ID id);

    List<T> findAll ();


}
