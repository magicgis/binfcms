package me.binf.common.cache.service.impl;


import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonObjectCache;

/**
 * 
 * 
 */
public class CommonObjectCacheImpl implements CommonObjectCache {
	
	private CacheService cacheService;

	public CommonObjectCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public Object get(String key) {
		return cacheService.get(key);
	}

	@Override
	public void put(String key, Object obj) {
		cacheService.put(key, obj);
	}

    @Override
    public void put(String key, Object obj, int second) {

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
	public boolean checkKeyExisted(String key) {
		return cacheService.checkKeyExisted(key);
	}
	
}
