package parsers;

import exceptions.DataSourceException;
import models.Call;
import models.SMS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class SMSDomParser implements XmlDomParser, XmlParser<SMS> {

    /*
     <SMSes>
      <SMS >
         <serviceId>1</serviceId>
         <sourceClientId>1</sourceClientId>
         <destinationClientId>2</destinationClientId>
         <dateTime>2019-11-14 22:23:00</dateTime>
         <textSize>123</textSize>
      </SMS>
   </SMSes>*/

    private static final Logger logger = LogManager.getLogger(SMSDomParser.class);

    enum SMSTag {
        serviceId, sourceClientId, destinationClientId, dateTime, textSize
    }

    @Override
    public ArrayList<SMS> getDataFromFile(String filePath) throws DataSourceException {
        ArrayList<SMS> smses;
        File file = new File(filePath);
        try {
            Document document = buildDocument(file);
            NodeList nodeList = document.getDocumentElement().getElementsByTagName("SMS");
            smses = new ArrayList<SMS>(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.TEXT_NODE) {
                    smses.add(getBetFromNode(nodeList.item(i)));
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            logger.error("File " + filePath + " not found");
            throw new DataSourceException("File " + filePath + " not found");
        }
        return smses;
    }

    private SMS getBetFromNode(Node orderNode) {
        SMS sms = new SMS();
        NodeList orderProps = orderNode.getChildNodes();
        SMSTag tag = null;
        String input = null;
        for (int j = 0; j < orderProps.getLength(); j++) {
            if ((orderProps.item(j).getNodeType() != Node.TEXT_NODE)) {
                try {
                    input = orderProps.item(j).getNodeName();
                    tag = SMSTag.valueOf(input);
                    switch (tag) {
                        case serviceId:
                            sms.setServiceId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case  sourceClientId:
                            sms.setSourceClientId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case destinationClientId:
                            sms.setDestinationClientId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case dateTime:
                            sms.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderProps.item(j).getTextContent()));
                            break;
                        case textSize:
                            sms.setTextSize(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                    }
                } catch (DOMException | ParseException e) {
                    logger.error(e.getStackTrace());
                }
            }
        }
        return sms;
    }
}
