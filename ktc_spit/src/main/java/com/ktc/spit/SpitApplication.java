package com.ktc.spit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import util.IdWorker;


@SpringBootApplication
public class SpitApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpitApplication.class,args);
	}
	
	@Bean
	public IdWorker idWorker(){
		return new IdWorker();
	}
	
	@Bean
	public RedisTemplate redisTemplate(RedisTemplate redisTemplate){
			redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			return redisTemplate;
	}
}
