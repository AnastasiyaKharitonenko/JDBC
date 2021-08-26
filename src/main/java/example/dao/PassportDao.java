package example.dao;

import config.Passport;

import java.util.List;


public interface PassportDao extends CrudDao<Passport, Long> {
    List<Passport> findAllByCodeDepartment(String departmentCode);

}
