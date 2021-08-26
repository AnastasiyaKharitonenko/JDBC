package example.dao.impl;

import config.Passport;
import example.dao.PassportDao;
import jdbc.connection.ConnectionDataBaseFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassportDaoImpl implements PassportDao {
    //language=sql
    private static final String SAVE_PASSPORT = "insert into passport (series, number, department_code) VALUES (?,?,?);";
    //language=sql
    private static final String UPDATE_PASSPORT = "update passport SET series = ? WHERE id =?;";
    //language=sql
    private static final String FIND_ALL = "select * from passport";

    private static final String DELETE_PASSPORT = "delete from passport WHERE series =?;";




    @Override
    public List<Passport> findAllByCodeDepartment(String departmentCode) {
        return null;
    }

    @Override
    public void save(Passport model) {
        try {
            Connection connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_PASSPORT);

            preparedStatement.setInt(1, model.getSeries().intValue());
            preparedStatement.setInt(2, model.getNumber().intValue());
            preparedStatement.setString(3, model.getDepartmentCode());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    @Override
    public List<Passport> updatePassportSeries(int id, Long Series) {
        List<Passport> updatePassport = new ArrayList<>();

        try {
            Connection connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSPORT);
            preparedStatement.setLong(1, Series);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            updatePassport = findAll();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updatePassport;
    }

        @Override
        public void delete (Long Series){
            try {
                Connection connection = ConnectionDataBaseFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PASSPORT);
                preparedStatement.setLong(1, Series);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        @Override
        public List<Passport> findAll () {
            List<Passport> passportList = new ArrayList<>();
            try {
                Statement statement = ConnectionDataBaseFactory.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL);
                while (resultSet.next()) {
                    Long series = resultSet.getLong("series");
                    Long id = resultSet.getLong("id");
                    Long number = resultSet.getLong("number");
                    String departmentCode = resultSet.getString("department_code");
                    Passport passport = Passport.builder()
                            .id(id)
                            .series(series)
                            .number(number)
                            .departmentCode(departmentCode)
                            .build();
                    passportList.add(passport);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return passportList;
        }
    }




