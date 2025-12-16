package com.auth.AuthAungular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
public class Controller {
	
	@Autowired
	UserRepository repo;
	@PostMapping("/create")
    public User create(@RequestBody User user) {
		System.out.println("hello");
		System.out.println(user);
        return repo.save(user);
    }
	

}
