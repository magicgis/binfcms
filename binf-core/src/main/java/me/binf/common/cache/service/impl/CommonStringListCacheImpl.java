package me.binf.common.cache.service.impl;


import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonStringListCache;

import java.util.List;

public class CommonStringListCacheImpl implements CommonStringListCache {


	private CacheService cacheService;

	public CommonStringListCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public List<String> getList(String listKey) {
		return cacheService.getStringListAll(listKey);
	}

	@Override
	public void add(String listKey, String... data) {
		cacheService.addStringToList(listKey, data);
	}

	@Override
	public void del(String listKey) {
		cacheService.delete(listKey);
	}

	@Override
	public boolean checkKeyExisted(Object key) {
		return cacheService.checkKeyExisted(key);
	}
	
}
