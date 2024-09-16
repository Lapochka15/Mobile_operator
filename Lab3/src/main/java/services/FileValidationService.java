package services;

import exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parsers.TariffPlanDomParser;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class FileValidationService {
    private static final Logger logger = LogManager.getLogger(FileValidationService.class);

    public boolean validate(File xmlFile, File xsdFile) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            return true;
        } catch (IOException e) {
            logger.error("Exception: " + e.getMessage());
        } catch (org.xml.sax.SAXException e) {
            logger.error("Exception: " + e.getMessage());
        }
        return false;
    }

    public File checkFile(String path){
        File file = new File(path);
        if ((file.exists()) && (file.isFile()) &&
                (file.canRead()) && (file.length() > 0))
            return file;
        else{
            return null;
        }
    }
}
