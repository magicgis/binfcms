package me.binf.common.cache.service;

import java.util.List;


/**
 * 
 */
public interface CommonObjectListCache{
	
	public List<Object> getList(String listKey);
	public void add(String listKey, Object... data);
	public void del(String listKey);
	
	public boolean checkKeyExisted(String key);
}
