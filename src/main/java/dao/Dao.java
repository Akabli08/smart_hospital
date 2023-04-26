package dao;

import java.util.ArrayList;

public interface Dao<Type> {
	Type findById(int id);
	ArrayList<Type> getAll();
	boolean save(Type t);
	boolean update(int id,Type t);
	boolean remove(int id);
}
