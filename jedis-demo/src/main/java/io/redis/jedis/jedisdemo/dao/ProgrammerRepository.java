package io.redis.jedis.jedisdemo.dao;

public interface ProgrammerRepository {
	
	//String
	void setProgrammerAsString(String idKey, String programmer);
	
	String getProgrammerAsString(String idKey);

}
