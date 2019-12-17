package app.epam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import exceptions.DataSourceException;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import parsers.*;
import services.FileValidationService;
import services.LoadingDataService;

public class AddServlet extends  HttpServlet {
    public static FileValidationService fileValidation = new FileValidationService();
    public static LoadingDataService loadingDataService = new LoadingDataService();

    private static final Logger logger = LogManager.getLogger(AddServlet.class);

    private static final String XML_DATA_FILE = "src/main/resources/in.xml";

    public AddServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isValidFile = loadingDataService.loadDateFromXml(fileValidation.checkFile(XML_DATA_FILE));

        if(!isValidFile) {
            req.setAttribute("xmlStatus", "XML is incorrect!");
        }else {
            req.setAttribute("xmlStatus", "XML is correct!");
        }


        try {
            XmlParser parser = new CallDomParser();
            List<Call> calls = parser.getDataFromFile(XML_DATA_FILE);

            parser = new SMSDomParser();
            List<SMS> smsList = parser.getDataFromFile(XML_DATA_FILE);

            parser = new TariffPlanDomParser();
            List<TariffPlan> tariffPlans = parser.getDataFromFile(XML_DATA_FILE);

            parser = new ClientStaxParser();
            List<Client> clients = parser.getDataFromFile(XML_DATA_FILE);

            CompanySaxParser companySaxParser = new CompanySaxParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(companySaxParser);
            xmlReader.parse(new InputSource(XML_DATA_FILE));
            List<Company> companies = companySaxParser.getCompanies();

            req.setAttribute("clients", clients);

        } catch (SAXException | DataSourceException e) {
            logger.error("Error: "+ e.getStackTrace());
        }



        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
