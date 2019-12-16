package app.epam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import services.FileValidationService;
import services.LoadingDataService;

public class AddServlet extends  HttpServlet {
    //public static FileValidationService fileValidation = new FileValidationService();
    //public static LoadingDataService loadingDataService = new LoadingDataService();

    //private static final String XML_DATA_FILE = "src/main/resources/in.xml";

    public AddServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*boolean isValidFile = loadingDataService.loadDateFromXml(fileValidation.checkFile(XML_DATA_FILE));

        if(!isValidFile) {
            req.setAttribute("xmlStatus", "XML is incorrect!");
        }else {
            req.setAttribute("xmlStatus", "XML is correct!");
        }*/

        //req.setAttribute("xmlStatus", "XML is incorrect!");
        /*ArrayList<Call> calls = null;

        XmlParser parser = new CallDomParser();
        try {
            calls = parser.getDataFromFile(XML_DATA_FILE);
        } catch (DataSourceException e) {
            e.printStackTrace();
        }

        req.setAttribute("calls", calls);*/
        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
