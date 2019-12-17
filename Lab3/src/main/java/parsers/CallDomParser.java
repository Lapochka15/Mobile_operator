package parsers;

import exceptions.DataSourceException;
import models.Call;
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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CallDomParser implements XmlDomParser, XmlParser<Call> {

    /*
     <Call >
         <serviceId>1</serviceId>
         <sourceClientId>1</sourceClientId>
         <destinationClientId>2</destinationClientId>
         <dateTime>2019-11-14 22:23:00</dateTime>
         <duration>03:00:00</duration>
    </Call>*/

    private static final Logger logger = LogManager.getLogger(CallDomParser.class);

    enum CallTag {
         serviceId, sourceClientId, destinationClientId, dateTime, duration
    }

    @Override
    public ArrayList<Call> getDataFromFile(String filePath) throws DataSourceException {
        ArrayList<Call> calls;
        File file = new File(filePath);
        try {
            Document document = buildDocument(file);
            NodeList nodeList = document.getDocumentElement().getElementsByTagName("Call");
            calls = new ArrayList<Call>(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.TEXT_NODE) {
                    calls.add(getBetFromNode(nodeList.item(i)));
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            logger.error("File " + filePath + " not found");
            throw new DataSourceException("File " + filePath + " not found");
        }
        return calls;
    }

    private Call getBetFromNode(Node orderNode) {
        Call call = new Call();
        NodeList orderProps = orderNode.getChildNodes();
        CallTag tag = null;
        String input = null;
        for (int j = 0; j < orderProps.getLength(); j++) {
            if ((orderProps.item(j).getNodeType() != Node.TEXT_NODE)) {
                try {
                    input = orderProps.item(j).getNodeName();
                    tag = CallTag.valueOf(input);
                    switch (tag) {
                        case serviceId:
                            call.setServiceId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case  sourceClientId:
                            call.setSourceClientId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case destinationClientId:
                            call.setDestinationClientId(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                        case dateTime:
                            call.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderProps.item(j).getTextContent()));
                            break;
                        case duration:
                            call.setDuration((Time) new SimpleDateFormat("HH:mm:ss").parse(orderProps.item(j).getTextContent()));
                            break;
                    }
                } catch (DOMException | ParseException e) {
                    logger.error(e.getStackTrace());
                }
            }
        }
        return call;
    }
}
