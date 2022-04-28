package io.redis.jedis.jedisdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.redis.jedis.jedisdemo.model.Programmer;
import io.redis.jedis.jedisdemo.services.ProgrammerService;

@RestController
@RequestMapping(value = "/programmers")
public class ProgrammerController {

	@Autowired
	private ProgrammerService programmerService;
	
	////****************** String **********************
	
	@PostMapping("/string")
	public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), mapper.writeValueAsString(programmer));
	}
	
	@GetMapping(value = "/string/{id}")
	public String readString(@PathVariable String id) {
		return programmerService.getProgrammerAsString(id);
	}
	
	////***************** List ***********************
	
	
	//add programmer to List
	@PostMapping("/list")
	public void addToProgrammersList(@RequestBody Programmer programmer) {
		programmerService.addToProgrammersList(programmer);
	}
	
	//get all programmers from a List
	@GetMapping("/list")
	public List<Programmer> getProgrammersListMembers() {
		return programmerService.getProgrammersListMembers();
	}
	
	//count all programmers in a list
	@GetMapping("/list/count")
	public Long getProgrammerListCount() {
		return programmerService.getProgrammersListCount();
	}
	
	
	
}
