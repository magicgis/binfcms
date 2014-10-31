package me.binf.common.cache.service;

import java.util.Map;


/**
 * 
 */
public interface CommonObjectMapCache extends CommonCache<Map<String, Object>> {
	
	public Map<String, Object> getMap(String mapKey);
	public Object getFromMap(String mapKey, String field);
	public void putMap(String mapKey, Map<String, Object> data);
	public void putToMap(String mapKey, String field, Object value);
	
	public boolean isContainFromMap(String mapKey, String field);
}
