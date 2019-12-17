package parsers;

import models.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class CompanySaxParser extends DefaultHandler {
    /*
    * <Company >
         <companyId>1</companyId>
         <name>MIT</name>
         <discount>0.4</discount>
      </Company>
      **/

    private static final Logger logger = LogManager.getLogger(CompanySaxParser.class);

    enum CompanyTag {
       Company, Companies, companyId, name, discount;
    }

    private ArrayList<Company> companies;
    private Company company;
    private StringBuilder input;

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        input = new StringBuilder();
        if (qName.equals(CompanyTag.Companies.toString())) {
            companies = new ArrayList<Company>();
        }
        if ((companies != null) && (qName.equals(CompanyTag.Company.toString()))) {
            company = new Company();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        input.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            CompanyTag tagName = CompanyTag.valueOf(qName);
            switch (tagName) {
                case companyId:
                    company.setCompanyId(Integer.parseInt(input.toString()));
                    break;
                case name:
                    company.setName(input.toString());
                    break;
                case discount:
                    company.setDiscount(Double.parseDouble(input.toString()));
                    break;
                case Company:
                    companies.add(company);
                    company = null;
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }

    }
}

