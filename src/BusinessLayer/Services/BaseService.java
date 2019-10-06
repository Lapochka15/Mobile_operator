package BusinessLayer.Services;

import DataAccess.Repository.ReadWriteData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseService<T> {

    private ReadWriteData _readWriteData;
    public ArrayList<T> _entities;

    public BaseService(String filePath){
        _readWriteData = new ReadWriteData<T>(filePath);
    }

    private void LoadEnrities() throws IOException, ClassNotFoundException {
        _entities = (ArrayList<T>)_readWriteData.ReadArrayOfEntities();
    }

    public ArrayList<T> GetEntities() throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEnrities();
        return _entities;
    }
    
    public void ShowAll() throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEnrities();
        for (T entity: _entities ) {
            System.out.println(entity);
        }
    }

    public void AddElement(T entity) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEnrities();
        this._entities.add(entity);
    }

    public void RemoveElement(T entity) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEnrities();
        _entities.remove(entity);
    }

    public void Save() throws IOException {
        if(_entities != null)
            _readWriteData.WriteArrayOfEntities(_entities);
    }


}
