package services;

import exceptions.InvalidFileException;
import models.DataBaseObject;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadingDataService {

    private final FileValidationService fileValidationService = new FileValidationService();

    private static final String XSD_FILE_NAME = "src/main/resources/out.xsd";

    public boolean loadDateFromXml(File xmlDataFile){
        if (xmlDataFile == null)
            return false;
        File xsdFile = new File(XSD_FILE_NAME);
        return fileValidationService.validate(xmlDataFile, xsdFile);
    }
}
