package me.binf.common.cache.service.impl;


import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonStringCache;

public class CommonStringCacheImpl implements CommonStringCache {

	private CacheService cacheService;

	public CommonStringCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public String get(String key) {
		return cacheService.getString(key);
	}

	@Override
	public void put(String key, String value) {
		cacheService.putString(key, value);
	}

    @Override
    public void put(String key, String obj, int second) {

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
