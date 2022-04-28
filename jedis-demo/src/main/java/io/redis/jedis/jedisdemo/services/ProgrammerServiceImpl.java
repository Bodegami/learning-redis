package io.redis.jedis.jedisdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	private ProgrammerRepository programmerRepository;
	
	////************* String *****************
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		programmerRepository.setProgrammerAsString(idKey, programmer);

	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return programmerRepository.getProgrammerAsString(idKey);
	}
	
	////************** List ******************

	@Override
	public void addToProgrammersList(Programmer programmer) {
		programmerRepository.addToProgrammersList(programmer);
		
	}

	@Override
	public List<Programmer> getProgrammersListMembers() {
		return programmerRepository.getProgrammersListMembers();
	}

	@Override
	public Long getProgrammersListCount() {
		return programmerRepository.getProgrammersListCount();
	}

}
