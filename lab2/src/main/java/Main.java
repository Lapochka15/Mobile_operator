import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import migration.*;
import models.*;
import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdGen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Main {

    public static String ConnectionString = "jdbc:sqlserver://LAPTOP-0681GAS6\\SQLEXPRESS:1433;databaseName=Mobile_operator;user=Katya_dub;password=12345678qwerty";

    public static TariffPlanMigration tariffPlanMigration;
    public static SMSMigration smsMigration;
    public static CompanyMigration companyMigration;
    public static CallMigration callMigration;
    public static ClientMigration clientMigration;

    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        DataBaseObject db = DataBaseObject.GetInstance();

        /*XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(db);
        System.out.println(xml);

        try(FileWriter writer = new FileWriter("in.xml", false))
        {
            writer.write(xml);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        XsdGen gen = new XsdGen();
        gen.parse(new File("in.xml"));
        File out = new File("out.xsd");

        gen.write(new FileOutputStream(out));

         */
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc.Statement");

        try (Connection connection = DriverManager.getConnection(ConnectionString); ) {

            tariffPlanMigration = new TariffPlanMigration(connection);
            companyMigration = new CompanyMigration(connection);
            clientMigration = new ClientMigration(connection);
            smsMigration = new SMSMigration(connection);
            callMigration = new CallMigration(connection);



            //tariffPlanMigration.migrate(db.getTariffPlans());
            //companyMigration.migrate(db.getCompanies());
            //clientMigration.migrate(db.getClients());
            //smsMigration.migrate(db.getSmsList());
            callMigration.migrate(db.getCalls());

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
