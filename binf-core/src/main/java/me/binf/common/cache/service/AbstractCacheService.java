package me.binf.common.cache.service;


import me.binf.common.cache.CacheService;
import me.binf.common.cache.service.impl.*;

import javax.annotation.Resource;


public abstract class AbstractCacheService{

    private CommonItemCache commonItemCache;
    private CommonMapCache commonMapCache;
    private CommonObjectCache commonObjectCache;
    private CommonStringCache commonStringCache;
    private CommonStringListCache commonStringListCache;
    private CommonObjectListCache commonObjectListCache;

    private CommonItemCache localCommonItemCache;
    private CommonMapCache localCommonMapCache;
    private CommonObjectCache localCommonObjectCache;
    private CommonStringCache localCommonStringCache;
    private CommonStringListCache localCommonStringListCache;
    private CommonObjectListCache localCommonObjectListCache;
    private CommonObjectMapCache localCommonObjectMapCache;

    @Resource(name="localCacheServiceImpl")
    private CacheService localCacheService;
    @Resource(name="redisCacheServiceImpl")
    private CacheService redisCacheService;

    public CommonItemCache getCommonItemCache() {
        if(commonItemCache==null){
            synchronized (this) {
                if(commonItemCache==null){
                    commonItemCache=new CommonItemCacheImpl(redisCacheService);
                }
            }
        }
        return commonItemCache;
    }
    public CommonMapCache getCommonMapCache() {
        if(commonMapCache==null){
            synchronized (this) {
                if(commonMapCache==null){
                    commonMapCache=new CommonMapCacheImpl(redisCacheService);
                }
            }
        }
        return commonMapCache;
    }
    public CommonObjectCache getCommonObjectCache() {
        if(commonObjectCache==null){
            synchronized (this) {
                if(commonObjectCache==null){
                    commonObjectCache=new CommonObjectCacheImpl(redisCacheService);
                }
            }
        }
        return commonObjectCache;
    }
    public CommonStringCache getCommonStringCache() {
        if(commonStringCache==null){
            synchronized (this) {
                if(commonStringCache==null){
                    commonStringCache=new CommonStringCacheImpl(redisCacheService);
                }
            }
        }
        return commonStringCache;
    }
    public CommonStringListCache getCommonStringListCache() {
        if(commonStringListCache==null){
            synchronized (this) {
                if(commonStringListCache==null){
                    commonStringListCache=new CommonStringListCacheImpl(redisCacheService);
                }
            }
        }
        return commonStringListCache;
    }
    public CommonObjectListCache getCommonObjectListCache() {
        if(commonObjectListCache==null){
            synchronized (this) {
                if(commonObjectListCache==null){
                    commonObjectListCache=new CommonObjectListCacheImpl(redisCacheService);
                }
            }
        }
        return commonObjectListCache;
    }

    protected abstract String getKey(String key);

    public CommonItemCache getLocalCommonItemCache() {
        if(localCommonItemCache==null){
            synchronized (this) {
                if(localCommonItemCache==null){
                    localCommonItemCache=new CommonItemCacheImpl(localCacheService);
                }
            }
        }
        return localCommonItemCache;
    }
    public CommonMapCache getLocalCommonMapCache() {
        if(localCommonMapCache==null){
            synchronized (this) {
                if(localCommonMapCache==null){
                    localCommonMapCache=new CommonMapCacheImpl(localCacheService);
                }
            }
        }
        return localCommonMapCache;
    }
    public CommonObjectCache getLocalCommonObjectCache() {
        if(localCommonObjectCache==null){
            synchronized (this) {
                if(localCommonObjectCache==null){
                    localCommonObjectCache=new CommonObjectCacheImpl(localCacheService);
                }
            }
        }
        return localCommonObjectCache;
    }
    public CommonStringCache getLocalCommonStringCache() {
        if(localCommonStringCache==null){
            synchronized (this) {
                if(localCommonStringCache==null){
                    localCommonStringCache=new CommonStringCacheImpl(localCacheService);
                }
            }
        }
        return localCommonStringCache;
    }
    public CommonStringListCache getLocalCommonStringListCache() {
        if(localCommonStringListCache==null){
            synchronized (this) {
                if(localCommonStringListCache==null){
                    localCommonStringListCache=new CommonStringListCacheImpl(localCacheService);
                }
            }
        }
        return localCommonStringListCache;
    }
    public CommonObjectListCache getLocalCommonObjectListCache() {
        if(localCommonObjectListCache==null){
            synchronized (this) {
                if(localCommonObjectListCache==null){
                    localCommonObjectListCache=new CommonObjectListCacheImpl(localCacheService);
                }
            }
        }
        return localCommonObjectListCache;
    }
    public CommonObjectMapCache getLocalCommonObjectMapCache() {
        if(localCommonObjectMapCache==null){
            synchronized (this) {
                if(localCommonObjectMapCache==null){
                    localCommonObjectMapCache=new CommonObjectMapCacheImpl(localCacheService);
                }
            }
        }
        return localCommonObjectMapCache;
    }


}