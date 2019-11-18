import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import migration.TariffPlanMigration;
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

    public static String ConnectionString = "jdbc:sqlserver://LAPTOP-0681GAS6\\SQLEXPRESS:1433;databaseName=Mobile_opeartor;user=Katya_dub;password=12345678qwerty";

    public static TariffPlanMigration tariffPlanMigration;

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
        int a = 0;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc.Statement");
        try (Connection connection = DriverManager.getConnection(ConnectionString); ) {

            tariffPlanMigration = new TariffPlanMigration(connection);

            tariffPlanMigration.migrate(db.getTariffPlans());
            /*Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String SQL = "SELECT TOP 10 * FROM Person;";
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println(rs.getFetchDirection());

            while(rs.next()){
                int id = rs.getInt("id");
                String str = rs.getString("Name");
                System.out.println(id);
                System.out.println(str);
            }
            int t = 5;*/



        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
