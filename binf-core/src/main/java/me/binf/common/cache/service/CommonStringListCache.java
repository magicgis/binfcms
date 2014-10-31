package me.binf.common.cache.service;

import java.util.List;


/**
 * 
 */
public interface CommonStringListCache{
	
	public List<String> getList(String listKey);
	public void add(String listKey, String... data);
	public void del(String listKey);
	
	public boolean checkKeyExisted(Object key);
}
