package com.nuoya.secluxury;

import com.nuoya.secluxury.utils.JedisClient;
import com.nuoya.secluxury.utils.JedisClientPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SecluxuryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecluxuryApplication.class, args);
    }



    @Value("${spring.redis.host}")
    String host ;

    @Value("${spring.redis.port}")
    int port ;


    @Bean  // <bean id='' class=“”/>
    public JedisClient getJedisClient(){
        JedisClientPool jedisClient =new JedisClientPool();
        JedisPool jedisPool =new JedisPool(host,port);
        jedisClient.setJedisPool(jedisPool);
        return jedisClient;
    }
}
