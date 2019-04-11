package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {
	@Autowired
	private TestRepository testRepository;

	@GetMapping("{name}")
	public String check(@PathVariable String name) {
		String s = "Hi," + name;
		return s;

	}

	/*
	 * @GetMapping public ResponseEntity<Map<Object, Object>> test() { List<String>
	 * l = new ArrayList<>(); l.add("Amit"); l.add("Mohit"); l.add("Atharv");
	 * Map<Object, Object> map = new HashMap<>(); map.put("Family-members", l);
	 * return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.OK); }
	 */

	@PostMapping
	public ResponseEntity<Test> saveTest(@RequestBody Test test) {
		return ResponseEntity.ok(testRepository.save(test));
	}

	@PutMapping
	public ResponseEntity<Test> updateTest(@RequestBody Test test) {
		return ResponseEntity.ok(testRepository.saveAndFlush(test));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Map<Object, Object>> deleteTest(@PathVariable Integer id) {
		testRepository.delete(id);
		Map<Object, Object> map = new HashMap<>();
		map.put("Message", "Successfully deleted");
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<Map<Object, Object>> test() {
		List<Test> l = new ArrayList<>();
		l = testRepository.findAll();
		Map<Object, Object> map = new HashMap<>();
		map.put("object", l);
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.OK);
	}
}
