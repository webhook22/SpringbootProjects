package com.mss.crudoperationdemo.controller;


import com.mss.crudoperationdemo.model.UserDetailsDTO;
import com.mss.crudoperationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Save user details
    @PostMapping("/saveuserdetails")
    public ResponseEntity<UserDetailsDTO> saveUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        return Optional.ofNullable(userService.saveUserDetails(userDetailsDTO)).map(userDetail -> new ResponseEntity<>(userDetail, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    // Get user by id
    @GetMapping("/getuserdetailsbyid/{userId}")
    public ResponseEntity<UserDetailsDTO> getUserDetailsById(@PathVariable(value = "userId") Integer userId) {
        return new ResponseEntity<>(userService.getUserDetailsByID(userId), HttpStatus.OK);
    }

    // Get user details
    @PutMapping("/updateuserdetails")
    public ResponseEntity<UserDetailsDTO> updateUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) throws Exception {
        return Optional.ofNullable(userService.updateUserDetails(userDetailsDTO)).map(userDetail -> new ResponseEntity<>(userDetail, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    // Delete user by id
    @DeleteMapping("/deleteuserdetailsbyid/{userId}")
    public ResponseEntity<String> deleteUserDetailsById(@PathVariable(value = "userId") Integer userId) {
        return new ResponseEntity<>(userService.deleteUserDetailsById(userId), HttpStatus.OK);
    }

}
