package parsers;

import exceptions.DataSourceException;
import models.Call;
import models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClientStaxParser implements XmlParser<Client> {

    /*
    <Client>
         <clientId>1</clientId>
         <name>Ira</name>
         <surname>Lop</surname>
         <bankAccount>12.0</bankAccount>
         <tariffPlanId>1</tariffPlanId>
         <companyId>1</companyId>
         <activeClient>true</activeClient>
      </Client>
    * */
    private static final Logger logger = LogManager.getLogger(ClientStaxParser.class);
    enum ClientTag {
        Client, Clients, clientId, name, surname, bankAccount, tariffPlanId, companyId, activeClient
    }

    private XMLStreamReader reader;
    private ArrayList<Client> clients;

    @Override
    public ArrayList<Client> getDataFromFile(String filePath) throws DataSourceException {
        XMLInputFactory xmlInputFactory;
        xmlInputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            reader = xmlInputFactory.createXMLStreamReader(inputStream);
            parse();
        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error(e.getStackTrace());
            throw new DataSourceException(e.getMessage());
        }
        return clients;
    }

    private void parse() throws XMLStreamException {
        ClientTag tag = null;
        Client client = null;
        int staxEvent;
        while (reader.hasNext()) {
            staxEvent = reader.next();
            switch (staxEvent) {
                case XMLEvent.START_ELEMENT:
                    try {
                        String tagName = reader.getLocalName();
                        tag = ClientTag.valueOf(tagName);
                        switch (tag) {
                            case Clients:
                                clients = new ArrayList<Client>();
                                break;
                            case Client:
                                client = new Client();
                                break;
                        }
                    } catch (Exception e) {
                        tag = null;
                    }
                    break;
                case XMLEvent.CHARACTERS:
                    String text = reader.getText();
                    if (text.trim().isEmpty())
                        break;
                    if ((client != null) && (tag != null)) {
                        switch (tag) {
                            case name:
                                client.setName(text);
                                break;
                            case surname:
                                client.setSurname(text);
                                break;
                            case clientId:
                                client.setClientId(Integer.parseInt(text));
                                break;
                            case companyId:
                                client.setCompanyId(Integer.parseInt(text));
                                break;
                            case tariffPlanId:
                                client.setTariffPlanId(Integer.parseInt(text));
                                break;
                            case bankAccount:
                                client.setBankAccount(Double.parseDouble(text));
                                break;
                            case activeClient:
                                client.setActiveClient(Boolean.parseBoolean(text));
                                break;
                        }
                    }
                    break;
                case XMLEvent.END_ELEMENT:
                    try {
                        if (ClientTag.valueOf(reader.getLocalName()) == ClientTag.Client) {
                            clients.add(client);
                            client = null;
                        }
                    } catch (Exception e) {
                        logger.error(e.getStackTrace());
                    }
                    break;
            }
        }
    }
}