package DataPresentation.EntityMenu;

import BusinessLayer.Services.BaseService;

import java.io.IOException;
import java.util.Scanner;

public abstract class BaseMenu {

    public abstract void Show() ;
    public abstract void Update();

    public abstract boolean Delete();
    public abstract void Add();

    public abstract void SaveChanges();

}
