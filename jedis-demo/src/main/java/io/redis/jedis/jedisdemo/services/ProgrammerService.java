package io.redis.jedis.jedisdemo.services;

public interface ProgrammerService {

	//String
	void setProgrammerAsString(String idKey, String programmer);
	
	String getProgrammerAsString(String idKey);
	
}
