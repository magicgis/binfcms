package me.binf.common.cache.service.impl;

import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonObjectMapCache;

import java.util.Map;

public class CommonObjectMapCacheImpl implements CommonObjectMapCache {

	private CacheService cacheService;

	public CommonObjectMapCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public Map<String, Object> get(String key) {
		return cacheService.getObjectMap(key);
	}

	@Override
	public void put(String key, Map<String, Object> value) {
		cacheService.putObjectMap(key, value);
	}

    @Override
    public void put(String key, Map<String, Object> obj, int second) {

    }

    @Override
	public void remove(String key) {
		cacheService.remove(key);
	}

	@Override
	public boolean contains(String key) {
		if (cacheService.containsKey(key)) {
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> getMap(String mapKey) {
		return cacheService.getObjectMap(mapKey);
	}

	@Override
	public Object getFromMap(String mapKey, String field) {
		return cacheService.getFromObjectMap(mapKey, field);
	}

	@Override
	public void putMap(String mapKey, Map<String, Object> data) {
		cacheService.putObjectMap(mapKey, data);
	}

	@Override
	public void putToMap(String mapKey, String field, Object value) {
		cacheService.putToObjectMap(mapKey, field, value);
	}

	@Override
	public boolean isContainFromMap(String mapKey, String field) {
		return cacheService.isContainFromMap(mapKey, field);
	}
	
	@Override
	public boolean checkKeyExisted(String key) {
		return cacheService.checkKeyExisted(key);
	}
}
