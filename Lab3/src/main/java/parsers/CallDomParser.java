package parsers;

import exceptions.DataSourceException;
import models.Call;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CallDomParser implements XmlDomParser, XmlParser<Call> {
    enum CallTag {
         id, duration
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
                    tag = CallTag.valueOf(input.toUpperCase().replace("-","_"));
                    /*switch (tag) {
                        case BET_AMOUNT:
                            call.setAmount(Integer.parseInt(orderProps.item(j).getTextContent()));
                            break;
                    }*/
                } catch (DOMException e) {
                    //TODO log
                }
            }
        }
        return call;
    }
}
