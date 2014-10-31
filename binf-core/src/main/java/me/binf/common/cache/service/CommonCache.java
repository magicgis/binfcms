package me.binf.common.cache.service;


/**
 * 
 */
public interface CommonCache<T> {

	void put(String key, T obj);
	void put(String key, T obj, int second);

	void remove(String key);

	boolean contains(String key);

	T get(String key);
	
	boolean checkKeyExisted(String key);
}
