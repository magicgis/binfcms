
package me.binf.common.cache;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CacheService {

	void putBlob(String key, byte[] data);
	byte[] getBlob(String key);
	Date getResetDate();
	
	int getCacheHits();
	int getCacheTotal();
	
	public boolean containsKey(String key);
	public Object remove(String key);
	public long size();
	
	public Object get(String key);
	public void put(String key, Object value);
	public void put(String key, Object value,int time);

	public String getString(String key);
	public void putString(String key, String value);
	
	public void removeFromMap(String mapKey, String field);
	public Map<String, String> getMap(String mapKey);
	public String getFromMap(String mapKey, String field);
	public void putMap(String mapKey, Map<String, String> data);
	public void putToMap(String mapKey, String field, String value);
	
	public Map<String, Object> getObjectMap(String mapKey);
	public Object getFromObjectMap(String mapKey, String field);
	public void putObjectMap(String mapKey, Map<String, Object> data);
	public void putToObjectMap(String mapKey, String field, Object value);
	
	
	public boolean isContainFromMap(String mapKey, String field);
	
	
	public void addStringToList(String listKey, String ...value);
	
	public List<String> getStringListAll(String listKey);
	
	public long delete(String listKey);
	public boolean checkKeyExisted(Object key);
	
	public void addObjectToList(Object listKey, Object ...value);
	public List<Object> getObjectListAll(Object listKey);
	public long deleteObjectList(Object listKey);
}
