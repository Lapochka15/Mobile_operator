package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class DataBaseObject {
    @JacksonXmlElementWrapper(localName = "Clients")
    @JacksonXmlProperty(localName = "Client")
    private List<Client> clients;

    @JacksonXmlElementWrapper(localName = "Calls")
    @JacksonXmlProperty(localName = "Call")
    private List<Call> calls;

    @JacksonXmlElementWrapper(localName = "TariffPlans")
    @JacksonXmlProperty(localName = "TariffPlan")
    private List<TariffPlan> tariffPlans;

    @JacksonXmlElementWrapper(localName = "SMSes")
    @JacksonXmlProperty(localName = "SMS")
    private List<SMS> smsList;

    @JacksonXmlElementWrapper(localName = "Companies")
    @JacksonXmlProperty(localName = "Company")
    private List<Company> companies;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public List<TariffPlan> getTariffPlans() {
        return tariffPlans;
    }

    public void setTariffPlans(List<TariffPlan> tariffPlans) {
        this.tariffPlans = tariffPlans;
    }

    public List<SMS> getSmsList() {
        return smsList;
    }

    public void setSmsList(List<SMS> smsList) {
        this.smsList = smsList;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
