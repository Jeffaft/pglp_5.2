
public interface DAO<T> {
		public T read(String name);
		public void update(T obj);
		public void write(T obj);
		public void delete (T obj);
}
