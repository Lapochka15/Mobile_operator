package BusinessLayer.Services;

import DataAccess.Repository.ReadWriteData;

import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseService<T> {

    private ReadWriteData _readWriteData;
    public ArrayList<T> _entities;

    public BaseService(String filePath){
        _readWriteData = new ReadWriteData<T>(filePath);
    }

    private void LoadEntities() throws IOException, ClassNotFoundException {
        _entities = (ArrayList<T>)_readWriteData.ReadArrayOfEntities();
    }

    public T GetEntity(int position){
        if (position < _entities.size())
            return _entities.get(position);
        return null;
    }

    
    public void ShowAll() throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEntities();
        for (T entity: _entities ) {
            System.out.println(entity);
        }
    }

    public void AddEntity(T entity) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEntities();
        this._entities.add(entity);
    }

    public void AddEntity(T[] entities) throws IOException, ClassNotFoundException {
        if(_entities == null)
            LoadEntities();
        for(T entity : entities){
            this.AddEntity(entity);
        }
    }

    public void RemoveEntity(T entity) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEntities();
        _entities.remove(entity);
    }

    public void RemoveEntity(T[] entities) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEntities();
        for(T entity : entities) {
            this.RemoveEntity(entity);
        }
    }

    public void UpdateEntity(T entityNew, int position) throws IOException, ClassNotFoundException {
        if (_entities == null)
            LoadEntities();
        this._entities.set(position, entityNew);
    }

    public void SaveEntities() throws IOException {
        if(_entities != null)
            _readWriteData.WriteArrayOfEntities(_entities);
    }

}
