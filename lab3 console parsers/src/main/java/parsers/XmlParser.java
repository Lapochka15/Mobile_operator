package parsers;

import exceptions.DataSourceException;

import java.util.ArrayList;
import java.util.List;

public interface XmlParser<T> {

    ArrayList<T> getDataFromFile(String filePath) throws DataSourceException;
}
