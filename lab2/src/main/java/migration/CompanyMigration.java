package migration;

import models.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CompanyMigration {

    private static final String TABLE = "Company";
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE + " WHERE Id = ";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE
            + " (Id, Name, Discount) VALUES ";

    private Connection dbConnection;

    public CompanyMigration( Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<Company> companies) {
        AtomicInteger counter = new AtomicInteger();
        for (Company company : companies) {
            try {
                saveCompany(company);
                counter.getAndIncrement();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //logger.debug(e);
            }
        }
        //logger.debug("Total bets: " + bets.size() + ", successful migrated: " + counter);
        System.out.println(counter + " bets migrated");
        return counter.get();
    }

    private void saveCompany(Company company) {
        ResultSet resultSet = null;
        try {
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String selectQuery = SELECT_QUERY + company.getCompanyId() + ';';
            resultSet = stmt.executeQuery(selectQuery);

            if (resultSet.next()) {
                System.out.println("Record Bet with id " + company.getCompanyId() + " already exists id database");
            }

            Statement stmtInsert = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // " (Id, Name, Discount) VALUES ";
            String insertQuery = INSERT_QUERY + '(' +
                    company.getCompanyId() + ",'" +
                    company.getName() + "'," +
                    company.getDiscount() +  ");";

            resultSet = stmt.executeQuery(insertQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //logger.error(e);
            //throw new DatabaseException(e.getMessage());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                //logger.error(e);
            }

        }
    }
}
