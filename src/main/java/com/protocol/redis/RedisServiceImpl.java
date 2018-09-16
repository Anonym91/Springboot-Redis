package com.protocol.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService{
	@Autowired
	private JedisPool jedisPool;
	
	public redis.clients.jedis.Jedis getResource() {
		return jedisPool.getResource();
	}
	
	@SuppressWarnings("deprecation")
	public void returnResource(redis.clients.jedis.Jedis jedis) {
		if(jedis!=null) {
			jedisPool.returnResource(jedis);
		}
	}
	
	public void setInfo(String key, Map<String, String> value) {
		redis.clients.jedis.Jedis jedis=null;
		try {
			
			jedis=getResource();
			jedis.select(15);
			jedis.hmset(key, value);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			returnResource(jedis);
		}
	}
	
	public Map<String, String> get(String key){
		redis.clients.jedis.Jedis jedis=null;
		Map<String, String> result=null;
		try {
			jedis=getResource();
			jedis.select(15);
			jedis.hgetAll(key);
			result=jedis.hgetAll(key);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			returnResource(jedis);
		}
		return result;
	}

}
