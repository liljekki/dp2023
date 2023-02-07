package Crud;

import Entity.MyEntity;
import fileIO.FileIO;
import fileIO.FileIOInterface;


public class fileCrud implements Lab2CrudInterface {
    FileIOInterface fio;
    public fileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public MyEntity readEntity() {
        return (MyEntity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(MyEntity entity) {
        fio.savetoFile(entity);
    }
}
