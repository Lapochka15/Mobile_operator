package migration;

import models.SMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SMSMigration {

    private static final String TABLE = "SMS";
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE + " WHERE Id = ";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE
            + " (Id, DateSent, TextLength, SourceClientId, DestinationClientId) VALUES ";

    private Connection dbConnection;

    public SMSMigration( Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<SMS> smses) {
        AtomicInteger counter = new AtomicInteger();
        for (SMS sms : smses) {
            try {
                saveSMS(sms);
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

    private void saveSMS(SMS sms) {
        ResultSet resultSet = null;
        try {
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String selectQuery = SELECT_QUERY + sms.getServiceId() + ';';
            resultSet = stmt.executeQuery(selectQuery);

            if (resultSet.next()) {
                System.out.println("Record Bet with id " + sms.getServiceId() + " already exists id database");
            }

            Statement stmtInsert = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //   (Id, DateSent, TextLength, SourceClientId, DestinationClientId) VALUES
            String insertQuery = INSERT_QUERY + '(' +
                    sms.getServiceId() + ",'" +
                    format.format(sms.getDateTime()) + "'," +
                    sms.getTextSize() + "," +
                    sms.getSourceClientId() + "," +
                    sms.getDestinationClientId() + ");";

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
