package DataAccess.Repository;



import DataAccess.Models.Client;

import java.io.*;

public class ReadWriteData<T> {
    private String _fileName;

    public ReadWriteData(String fileName){
        _fileName = fileName;
    }

    public void WriteArrayOfEntities(T[] entities) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(_fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(entities);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public T[] ReadArrayOfEntities() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        T[] entities = (T[]) objectInputStream.readObject();
        objectInputStream.close();
        return entities;
    }
}
