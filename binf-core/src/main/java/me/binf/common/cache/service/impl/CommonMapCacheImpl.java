package me.binf.common.cache.service.impl;



import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonMapCache;

import java.util.Map;

public class CommonMapCacheImpl implements CommonMapCache {

	private CacheService cacheService;

	public CommonMapCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public Map<String, String> get(String key) {
		return cacheService.getMap(key);
	}

	@Override
	public void put(String key, Map<String, String> value) {
		cacheService.putMap(key, value);
	}

    @Override
    public void put(String key, Map<String, String> obj, int second) {

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
	public Map<String, String> getMap(String mapKey) {
		return cacheService.getMap(mapKey);
	}

	@Override
	public String getFromMap(String mapKey, String field) {
		return cacheService.getFromMap(mapKey, field);
	}

	@Override
	public void putMap(String mapKey, Map<String, String> data) {
		cacheService.putMap(mapKey, data);
	}

	@Override
	public void putToMap(String mapKey, String field, String value) {
		cacheService.putToMap(mapKey, field, value);
	}



    @Override
	public boolean isContainFromMap(String mapKey, String field) {
		return cacheService.isContainFromMap(mapKey, field);
	}
	
	@Override
	public boolean checkKeyExisted(String key) {
		return cacheService.checkKeyExisted(key);
	}

	@Override
	public void removeFromMap(String mapKey, String field) {
		cacheService.removeFromMap(mapKey, field);
	}
}
