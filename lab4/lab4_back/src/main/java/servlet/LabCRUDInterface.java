package servlet;

import java.util.List;

public interface LabCRUDInterface<T> {
	
	public void create(T t);
	public List<T> read();
	public void update(int cat, T t);
	public void delete(int cat);	

}