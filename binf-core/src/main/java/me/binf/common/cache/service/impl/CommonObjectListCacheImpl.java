package me.binf.common.cache.service.impl;

import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.CommonObjectListCache;

import java.util.List;

public class CommonObjectListCacheImpl implements CommonObjectListCache {


	private CacheService cacheService;

	public CommonObjectListCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public List<Object> getList(String listKey) {
		return cacheService.getObjectListAll(listKey.getBytes());
	}

	@Override
	public void add(String listKey, Object... value) {
		cacheService.addObjectToList(listKey.getBytes(), value);
	}

	@Override
	public void del(String listKey) {
		cacheService.deleteObjectList(listKey.getBytes());
	}

	@Override
	public boolean checkKeyExisted(String key) {
		return cacheService.checkKeyExisted(key.getBytes());
	}

}
