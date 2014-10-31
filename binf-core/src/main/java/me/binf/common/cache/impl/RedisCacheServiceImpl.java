package me.binf.common.cache.impl;


import me.binf.common.cache.CacheService;
import me.binf.logger.Logger;
import me.binf.utils.RedisUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RedisCacheServiceImpl implements CacheService {

	private RedisUtils redisUtils;
	
	public void setRedisUtils(RedisUtils redisUtils) {
		this.redisUtils = redisUtils;
	}
	
	@Override
	public long size() {
		return redisUtils.size();
	}

	@Override
	public Object get(String key) {
		return redisUtils.get(key);
	}

	@Override
	public void put(String key, Object value) {
		redisUtils.set(key, value);
	}

    @Override
    public void put(String key, Object value, int time) {
        redisUtils.set(key, value,time);
    }

    @Override
	public Object remove(String key) {
		redisUtils.delete(key);
		return null;
	}
	
	@Override
	public boolean containsKey(String key) {
		return redisUtils.checkKeyExisted(key);
	}
	
	@Override
	public void putBlob(String key, byte[] data) {
		Logger.error("putBlob(String key, byte[] data) not implemented");
		
	}

	@Override
	public byte[] getBlob(String key) {
		Logger.error("getBlob(String key) not implemented");
		return null;
	}

	@Override
	public Date getResetDate() {
		return null;
	}

	@Override
	public int getCacheHits() {
		Logger.error("getCacheHits() not implemented");
		return 0;
	}

	@Override
	public int getCacheTotal() {
		Logger.error("getCacheTotal() not implemented");
		return 0;
	}

	@Override
	public String getString(String key) {
		return redisUtils.getString(key);
	}

	@Override
	public void putString(String key, String value) {
		redisUtils.setString(key, value);
	}

	@Override
	public void removeFromMap(String mapKey, String field) {
		redisUtils.removeFromMap(mapKey, field);
	}
	
	@Override
	public Map<String, String> getMap(String mapKey) {
		return redisUtils.getStringMapAll(mapKey);
	}
	
	@Override
	public String getFromMap(String mapKey, String field) {
		return redisUtils.getStringFromMap(mapKey, field);
	}
	
	@Override
	public boolean isContainFromMap(String mapKey, String field) {
		return redisUtils.isContainFromMap(mapKey, field);
	}
	
	@Override
	public void putMap(String mapKey, Map<String, String> data) {
		redisUtils.putStringToMap(mapKey, data);
	}
	
	@Override
	public void putToMap(String mapKey, String field, String value){
		redisUtils.putStringToMap(mapKey, field, value);
	}



    @Override
	public void addStringToList(String listKey, String ...value){
		redisUtils.addStringToList(listKey, value);
	}
	
	@Override
	public List<String> getStringListAll(String listKey) {
		return redisUtils.getStringListAll(listKey);
	}
	
	@Override
	public long delete(String listKey) {
		return redisUtils.delete(listKey);
	}
	
	@Override
	public void addObjectToList(Object listKey, Object ...value){
		redisUtils.addToListRight(listKey, value);
	}
	
	@Override
	public List<Object> getObjectListAll(Object listKey) {
		return redisUtils.getListAll(listKey);
	}
	
	@Override
	public long deleteObjectList(Object listKey) {
		return redisUtils.deleteObjectKey(listKey);
	}
	
	@Override
	public boolean checkKeyExisted(Object listKey){
		return redisUtils.checkKeyExisted(listKey);
	}

	@Override
	public Map<String, Object> getObjectMap(String mapKey) {
		return redisUtils.getObjectMapAll(mapKey);
	}

	@Override
	public Object getFromObjectMap(String mapKey, String field) {
		return redisUtils.getFromMap(mapKey, field);
	}

	@Override
	public void putObjectMap(String mapKey, Map<String, Object> data) {
		Logger.error("none implements method 'putObjectMap'");
	}

	@Override
	public void putToObjectMap(String mapKey, String field, Object value) {
		Logger.error("none implements method 'putToObjectMap'");
	}
}
