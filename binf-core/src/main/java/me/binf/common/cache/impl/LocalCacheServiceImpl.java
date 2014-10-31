package me.binf.common.cache.impl;

import me.binf.common.cache.CacheService;
import me.binf.common.cache.LRULinkedHashMap;
import me.binf.logger.Logger;
import me.binf.utils.ArrayUtil;
import me.binf.utils.StrUtil;

import java.util.*;

public class LocalCacheServiceImpl implements CacheService {
	private static final int cacheMaxCapacity=1000;
	private static Map<Object, Object> cacheMap=new LRULinkedHashMap<Object, Object>(cacheMaxCapacity);
	
	public static int CACHE_SIZE_LIMIT = 1000000; 
	private static final String RESET_DATE_KEY = "cacheResetDate";
	
	private int cacheHits;

	@Override
	public boolean containsKey(String key) {
		return cacheMap.containsKey(key);
	}

	@Override
	public Object get(String key) {
		if (cacheMap.containsKey(key)) {
			cacheHits++;
			Object obj=null;
			try {
				obj=cacheMap.get(key);
			} catch (Exception e) {
                Logger.error(e.getMessage());
			}
			return obj;
		}
		return null;
	}

	@Override
	public void put(String key, Object value) {
		cacheMap.put(key, value);
	}

    @Override
    public void put(String key, Object value, int time) {

    }

    @Override
	public Object remove(String key) {
		return cacheMap.remove(key);
	}

	@Override
	public long size() {
		return cacheMap.size();
	}

	@Override
	public byte[] getBlob(String key) {
		String chunkList = (String)get(key);
		if (chunkList != null) {
			List<byte[]> data = new ArrayList<byte[]>();
			for (String chunkKey : StrUtil.fromCSV(chunkList)) {
				byte[] chunk = (byte[])get(chunkKey);
				if (chunk == null) {
					return null;
				}
				data.add(chunk);
			}
			return ArrayUtil.packChunks(data);
		}
		return null;
	}

	@Override
	public void putBlob(String key, byte[] data) {
		List<String> chunkList = new ArrayList<String>();
		List<byte[]> chunks = ArrayUtil.makeChunks(data, CACHE_SIZE_LIMIT);
		int i = 0;
		for (byte[] chunk : chunks) {
			String chunkKey = key + String.valueOf(i);
			put(chunkKey, chunk);
			chunkList.add(chunkKey);
			i++;
		}
		put(key, StrUtil.toCSV(chunkList));
	}

	@Override
	public Date getResetDate() {
		return (Date)get(RESET_DATE_KEY);
	}

	public int getCacheHits() {
		return cacheHits;
	}
	@Override
	public int getCacheTotal() {
		return 0;
	}

	@Override
	public String getString(String key) {
		return null;
	}

	@Override
	public void putString(String key, String value) {
		cacheMap.put(key, value);;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getMap(String mapKey) {
		return (Map<String, String>)cacheMap.get(mapKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getFromMap(String mapKey, String field) {
		Map<String, String> data= (Map<String, String>)cacheMap.get(mapKey);
		return data.get(field);
	}

	@Override
	public void putMap(String mapKey, Map<String, String> data) {
		cacheMap.put(mapKey, data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putToMap(String mapKey, String field, String value) {
		Map<String, String> data= (Map<String, String>)cacheMap.get(mapKey);
		if(data==null){
			data=new HashMap<String, String>();
		}
		data.put(field, value);
		cacheMap.put(mapKey, data);
	}

	@Override
	public boolean isContainFromMap(String mapKey, String field) {
		@SuppressWarnings("unchecked")
		Map<String, String> data= (Map<String, String>)cacheMap.get(mapKey);
		if(data==null){
			return false;
		}
		return data.containsKey(field);
	}

	@Override
	public void addStringToList(String listKey, String... value) {
		Logger.error("none implements method 'addStringToList'");
	}

	@Override
	public List<String> getStringListAll(String listKey) {
		Logger.error("none implements method 'getStringListAll'");
		return null;
	}

	@Override
	public long delete(String listKey) {
		Logger.error("none implements method 'delete'");
		return 0;
	}

	@Override
	public boolean checkKeyExisted(Object key) {
		return cacheMap.containsKey(key);
	}


	@Override
	public void addObjectToList(Object listKey, Object... value) {
		// TODO Auto-generated method stub
		Logger.error("none implements method 'addObjectToList'");
	}

	@Override
	public List<Object> getObjectListAll(Object listKey) {
		Logger.error("none implements method 'getObjectListAll'");
		return null;
	}

	@Override
	public long deleteObjectList(Object listKey) {
		Logger.error("none implements method 'deleteObjectList'");
		return 0;
	}

	@Override
	public Map<String, Object> getObjectMap(String mapKey) {
		Map<String, Object> data= (Map<String, Object>)cacheMap.get(mapKey);
		return data;
	}

	@Override
	public Object getFromObjectMap(String mapKey, String field) {
		Map<String, Object> data= (Map<String, Object>)cacheMap.get(mapKey);
		return data.get(field);
	}

	@Override
	public void putObjectMap(String mapKey, Map<String, Object> data) {
		cacheMap.put(mapKey, data);
	}

	@Override
	public void putToObjectMap(String mapKey, String field, Object value) {
		Map<String, Object> data= (Map<String, Object>)cacheMap.get(mapKey);
		if(data==null){
			data=new HashMap<String, Object>();
		}
		data.put(field, value);
		cacheMap.put(mapKey, data);
	}

	@Override
	public void removeFromMap(String mapKey, String field) {
		Logger.error("none implements method 'removeFromMap'");
	}
	
}
