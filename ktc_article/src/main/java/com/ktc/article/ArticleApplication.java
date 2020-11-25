package com.ktc.article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import util.IdWorker;

/**
 * @Description
 * @author admin
 * @date 2020-11-25 12:25:56
*/
@SpringBootApplication
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
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
