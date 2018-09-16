package com.protocol.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:redisConfig/redis.properties")
public class RedisConfig {
	
	@Value("${spring.redis.host}")
	private  String host;
	
	@Value("${spring.redis.port}")
	private  int port;
	
	@Value("${spring.redis.password}")
	private  String passwd;
	
	@Value("${spring.redis.timeout}")
	private  int timeout;
	
	@Value("${spring.redis.blockWhenExhausted}")
	private  boolean blockWhenExhausted;
	
	@Value("${spring.redis.maxIdle}")
	private  int maxIdle;
	
	@Value("${spring.redis.maxWaitMillis}")
	private  int maxWaitMillis;
	
	@Value("${spring.redis.maxTotal}")
	private  int maxTotal;
	
	@Value("${spring.redis.testOnBorrow}")
	private  boolean testOnBorrow;
	
	
	private  JedisPool jedisPool;
	
	@Bean
	public JedisPoolConfig getRedisConfig() {
		JedisPoolConfig config=new JedisPoolConfig();
		return config;
	}
	
	@Bean
	public JedisPool getJedisPool() {
		JedisPoolConfig config=getRedisConfig();
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		config.setBlockWhenExhausted(blockWhenExhausted);
		config.setTestOnBorrow(testOnBorrow);
		config.setMaxWaitMillis(maxWaitMillis);
		JedisPool jedisPool=new JedisPool(config,host,port,timeout,passwd);
		return jedisPool;
	}
	
}
