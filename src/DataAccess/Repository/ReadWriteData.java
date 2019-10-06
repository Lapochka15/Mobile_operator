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

    public ArrayList<T> ReadArrayOfEntities() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(_fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ArrayList<T> entities = (ArrayList<T>) objectInputStream.readObject();
        objectInputStream.close();
        return entities;
    }
}
