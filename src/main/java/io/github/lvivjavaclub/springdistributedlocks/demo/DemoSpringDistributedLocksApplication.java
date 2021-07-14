package io.github.lvivjavaclub.springdistributedlocks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;
import org.springframework.integration.support.locks.LockRegistry;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoSpringDistributedLocksApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoSpringDistributedLocksApplication.class, args);
  }

//	@Bean
//	public LockRegistry lockRegistry(RedisConnectionFactory connectionFactory) {
//		return new RedisLockRegistry(connectionFactory, "user-lock");
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	public LockRepository lockRepository(DataSource datasource) {
//		return new DefaultLockRepository(datasource);
//	}
//
//	@Bean
//	public LockRegistry lockRegistry(LockRepository repository) {
//		return new JdbcLockRegistry(repository);
//	}
}
