package com.test.util;

/**
 * @ClassName CacheContext
 * @Description TODO
 * @Author jdp
 * @Date 15:04 2022/5/5
 * @Version 1.0
 **/
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wenchao.ren
 *         2015/1/5.
 */
@Component
public class CacheContext<T> {

    private Map<String, T> cache = Maps.newConcurrentMap();

    public T get(String key){
        return  cache.get(key);
    }

    public void addOrUpdateCache(String key,T value) {
        cache.put(key, value);
    }

    // 根据 key 来删除缓存中的一条记录
    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    // 清空缓存中的所有记录
    public void evictCache() {
        cache.clear();
    }

}
