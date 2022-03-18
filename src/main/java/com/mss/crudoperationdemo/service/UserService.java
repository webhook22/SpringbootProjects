package com.mss.crudoperationdemo.service;

import com.mss.crudoperationdemo.model.UserDetailsDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public UserDetailsDTO saveUserDetails(UserDetailsDTO userDetailsDTO);
    public UserDetailsDTO getUserDetailsByID(Integer id);
    public UserDetailsDTO updateUserDetails(UserDetailsDTO userDetailsDTO);
    public String deleteUserDetailsById(Integer id);
}
