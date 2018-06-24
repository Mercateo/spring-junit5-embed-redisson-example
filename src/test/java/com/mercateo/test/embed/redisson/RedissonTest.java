package com.mercateo.test.embed.redisson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;

import com.mercateo.spring.junit5.embed.redisson.SpringBootRedissonTest;

@SpringBootRedissonTest
public class RedissonTest {

	
	@Test
	public void testWithInjectedRedissonParameter(RedissonClient c) {

		RDeque<Object> deque = c.getDeque("mylist");
		assertEquals(0, deque.size());
		
		deque.add("hubba");
		assertEquals("hubba", deque.pop());
	}

	@Test
	public void testWithoutRedissonParameter() {
		// there is no redis server being started for this test, as there is no redisson parameter
	}
	
	@Test
	public void otherRedissonTest(RedissonClient c) {

		RDeque<Object> deque = c.getDeque("mylist");
		assertEquals(0, deque.size());
		
		deque.add("hubba");
		assertEquals("hubba", deque.pop());
	}

}
