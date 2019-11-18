package migration;

import com.sun.tools.javac.Main;
import models.TariffPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TariffPlanMigration {
    private static final String TABLE = "TariffPlan";
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE
            + " (id, name, subscriptionFee, debit, smsPrice, callPrice) VALUES ";
    // (moreid, ...)


    private Connection dbConnection;

    public TariffPlanMigration( Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<TariffPlan> tariffPlans) {
        AtomicInteger counter = new AtomicInteger();
        for (TariffPlan tariffPlan : tariffPlans) {
            try {
                saveTariffPlan(tariffPlan);
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

    private void saveTariffPlan(TariffPlan tariffPlan){
        ResultSet resultSet = null;
        try {
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String selectQuery = SELECT_QUERY + tariffPlan.getId() + ';';
            resultSet = stmt.executeQuery(selectQuery);

            if (resultSet.next()) {
                System.out.println("Record Bet with id " + tariffPlan.getId() + " already exists id database");
            }

            Statement stmtInsert = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // (id, name, subscriptionFee, debit, smsPrice, callPrice) VALUES
            String insertQuery = INSERT_QUERY + '(' +
                    tariffPlan.getId() + ",'" +
                    tariffPlan.getName()+ "'," +
                    tariffPlan.getSubscriptionFee() +",'" +
                    tariffPlan.getDebit() + "'," +
                    tariffPlan.getSmsPrice() + ',' +
                    tariffPlan.getCallPrice() + ");";

            resultSet = stmt.executeQuery(insertQuery);
            //INSERT INTO TariffPlan (id, name, subscriptionFee, debit, smsPrice, callPrice) VALUES (1,Lemon,3.2,everyDay,2.1,3.2);
        } catch (SQLException e) {
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
