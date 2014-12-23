package me.binf.admin.cache.impl;

import me.binf.admin.cache.CacheService;
import me.binf.entity.Member;
import me.binf.common.cache.service.AbstractCacheService;
import me.binf.common.cache.item.CommonCacheItem;
import org.springframework.stereotype.Service;

/**
 * Created by wangbin on 14-10-31.
 */
@Service
public class MemberCacheServiceImpl extends AbstractCacheService implements CacheService<Member>{

    private static final String MEMBER_KEY="MEMBER_CACHE_KEY";

    @Override
    public void put(String username, Member member){
        this.getCommonItemCache().put(getKey(username), new CommonCacheItem<Member>(member));
    }


    @Override
    public Member get(String username){
        @SuppressWarnings("unchecked")
        CommonCacheItem<Member> cacheItem=(CommonCacheItem<Member>)this.getCommonItemCache().get(getKey(username));
        if(cacheItem==null){
            return null;
        }
        Member member=cacheItem.getValue();
        return member;
    }

    @Override
    public boolean isContain(String username){
        return this.getCommonItemCache().contains(getKey(username));
    }

    public String getKey(String key) {
        return MEMBER_KEY+">"+key;
    }

    @Override
    public boolean isExist(String key) {
        return this.getCommonItemCache().checkKeyExisted(getKey(key));
    }

    @Override
    public void remove(String key) {
        this.getCommonStringCache().remove(getKey(key))	;
    }


}
