package io.redis.jedis.jedisdemo.dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import io.redis.jedis.jedisdemo.model.Programmer;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {
	
	public static final String REDIS_LIST_KEY = "ProgrammersList";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	@Qualifier("listOperations")
	private ListOperations<String, Programmer> listOps;
	
	
	////*********** String **************

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		redisTemplate.opsForValue().set(idKey, programmer);
		redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	////************* List **************
	
	@Override
	public void addToProgrammersList(Programmer programmer) {
		listOps.leftPush(REDIS_LIST_KEY, programmer);
	}

	@Override
	public List<Programmer> getProgrammersListMembers() {
		return listOps.range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getProgrammersListCount() {
		return listOps.size(REDIS_LIST_KEY);
	}

}
