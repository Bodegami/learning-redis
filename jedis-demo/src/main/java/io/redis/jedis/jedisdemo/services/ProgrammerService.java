package io.redis.jedis.jedisdemo.services;

import java.util.List;

import io.redis.jedis.jedisdemo.model.Programmer;

public interface ProgrammerService {

	//String
	void setProgrammerAsString(String idKey, String programmer);
	
	String getProgrammerAsString(String idKey);
	
	//List
	void addToProgrammersList(Programmer programmer);
	
	List<Programmer> getProgrammersListMembers();
	
	Long getProgrammersListCount();
	
}
