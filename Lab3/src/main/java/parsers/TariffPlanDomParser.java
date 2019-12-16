package parsers;


import exceptions.DataSourceException;
import models.Debit;
import models.SMS;
import models.TariffPlan;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TariffPlanDomParser implements XmlDomParser, XmlParser<TariffPlan> {

/*
      <TariffPlan >
         <id>3</id>
         <name>Lemon3</name>
         <subscriptionFee>3.1</subscriptionFee>
         <debit>everyWeek</debit>
         <smsPrice>2.9</smsPrice>
         <callPrice>3.2</callPrice>
      </TariffPlan>*/

enum TariffPlanTag {
    id, name, subscriptionFee, debit, smsPrice, callPrice
}

    @Override
    public ArrayList<TariffPlan> getDataFromFile(String filePath) throws DataSourceException {
        ArrayList<TariffPlan> tariffPlans;
        File file = new File(filePath);
        try {
            Document document = buildDocument(file);
            NodeList nodeList = document.getDocumentElement().getElementsByTagName("TariffPlan");
            tariffPlans = new ArrayList<TariffPlan>(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.TEXT_NODE) {
                    tariffPlans.add(getBetFromNode(nodeList.item(i)));
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new DataSourceException("File " + filePath + " not found");
        }
        return tariffPlans;
    }

    private TariffPlan getBetFromNode(Node orderNode) {
        TariffPlan tariffPlan = new TariffPlan();
        NodeList orderProps = orderNode.getChildNodes();
       TariffPlanTag tag = null;
        String input = null;
        for (int j = 0; j < orderProps.getLength(); j++) {
            if ((orderProps.item(j).getNodeType() != Node.TEXT_NODE)) {
                try {
                    input = orderProps.item(j).getNodeName();
                    tag = TariffPlanTag.valueOf(input);
                    switch (tag) {
                        case id:
                            tariffPlan.setId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case  name:
                            tariffPlan.setName(orderProps.item(j).getTextContent());
                            break;
                        case subscriptionFee:
                            tariffPlan.setSubscriptionFee(Double.parseDouble(orderProps.item(j).getTextContent()));
                            break;
                        case debit:
                            String b = orderProps.item(j).getTextContent();
                            tariffPlan.setDebit(Debit.valueOf(b));
                            break;
                        case smsPrice:
                            tariffPlan.setSmsPrice(Double.parseDouble(orderProps.item(j).getTextContent()));
                            break;
                        case callPrice:
                            tariffPlan.setCallPrice(Double.parseDouble(orderProps.item(j).getTextContent()));
                            break;
                    }
                } catch (DOMException e) {
                    //TODO log
                }
            }
        }
        return tariffPlan;
    }
}
