package com.programmerfriend.ultimateredis;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.programmerfriend.ultimateredis.config.CacheConfig;

@Slf4j
@Service
public class CacheService {
	final Logger log = LoggerFactory.getLogger(CacheConfig.class);

    @Cacheable(cacheNames = "myCache", key = "'myPrefix_'.concat(#relevant)")
    public String cacheThis(String relevant, String unrelevantTrackingId){
        log.info("Returning NOT from cache. Tracking: {}!", unrelevantTrackingId);
        return "this Is it";
    }

    @CacheEvict(cacheNames = "myCache", key = "'myPrefix_'.concat(#relevant)")
    public void forgetAboutThis(String relevant){
        log.info("Forgetting everything about this '{}'!", relevant);
    }
}
