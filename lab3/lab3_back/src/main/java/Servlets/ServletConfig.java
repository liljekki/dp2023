package Servlets;
import Crud.Lab2CrudInterface;
import Crud.fileCrud;


public class ServletConfig implements ServletConfigInterface{
    Lab2CrudInterface l2ci;

    public ServletConfig() {
        this.l2ci =  new fileCrud();
    }

    public void setL2ci(Lab2CrudInterface l2ci){
        this.l2ci = l2ci;
    }
    @Override
    public Lab2CrudInterface getCrud() {

        return l2ci;
    }
}
