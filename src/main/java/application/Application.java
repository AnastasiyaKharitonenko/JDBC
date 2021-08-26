package application;

import config.Passport;
import example.dao.PassportDao;
import example.dao.impl.PassportDaoImpl;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        PassportDao passportDao = new PassportDaoImpl();
        List<Passport> passportList = passportDao.findAll();
        passportList.forEach(System.out::println);
        System.out.println("---------------------------------------------");

        passportDao.delete(7008L);
        passportDao.findAll().forEach(System.out::println);
        System.out.println("---------------------------------------------");

        Passport passport = Passport.builder()
                .series(6005L)
                .number(458489L)
                .departmentCode("650-150")
                .build();

        passportDao.save(passport);
        passportList = passportDao.findAll();
        passportList.forEach(System.out::println);
        System.out.println("---------------------------------------------");

        passportDao.updatePassportSeries(12,7008L).forEach(System.out::println);
    }
}



