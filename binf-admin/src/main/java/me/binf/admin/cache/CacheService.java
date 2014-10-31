package me.binf.admin.cache;


public interface CacheService<T> {
	public void put(String key, T t);
	public T get(String key);
	public boolean isContain(String key);
	public boolean isExist(String key);

	public void remove(String key);
}
