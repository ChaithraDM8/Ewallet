package com.example.Ewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getUser")
    public User getUserByUserName(@RequestParam("userName") String userName,String password) throws UserNotFoundException{
        return userService.findByUserNameAndPassword(userName,password);
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto) throws UserAlreadyExistsException {
        userService.addUser(userEntryDto);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
