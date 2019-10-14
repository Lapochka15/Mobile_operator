package DataAccess.Repository;



import DataAccess.Models.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteData<T> {
    private String _fileName;

    public ReadWriteData(String fileName){
        _fileName = fileName;
    }

    public void WriteArrayOfEntities(ArrayList<T> entities) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(_fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(entities);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public ArrayList<T> ReadArrayOfEntities() {
        ArrayList<T> entities;
        try {
            FileInputStream inputStream = new FileInputStream(_fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            entities = (ArrayList<T>) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch(Exception e){
            entities = new ArrayList<T>();
        }
        return entities;
    }
}
