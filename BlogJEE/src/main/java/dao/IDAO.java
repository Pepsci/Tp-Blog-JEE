package dao;

import java.util.List;


public interface IDAO<T> {
	

	boolean create(T object);
	public List<T> read();
}
