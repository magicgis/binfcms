package me.binf.common.cache.service;

import java.util.Map;


/**
 * 
 */
public interface CommonMapCache extends CommonCache<Map<String, String>> {
	
	public Map<String, String> getMap(String mapKey);
	public String getFromMap(String mapKey, String field);
	public void putMap(String mapKey, Map<String, String> data);
	public void putToMap(String mapKey, String field, String value);
	
	public boolean isContainFromMap(String mapKey, String field);
	
	public void removeFromMap(String mapKey, String field);
}
