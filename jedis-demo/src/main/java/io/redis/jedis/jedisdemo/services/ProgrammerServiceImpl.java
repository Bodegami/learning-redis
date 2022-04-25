package io.redis.jedis.jedisdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	private ProgrammerRepository programmerRepository;

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		programmerRepository.setProgrammerAsString(idKey, programmer);

	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return programmerRepository.getProgrammerAsString(idKey);
	}

}
