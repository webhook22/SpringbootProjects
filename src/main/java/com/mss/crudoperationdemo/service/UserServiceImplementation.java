package com.mss.crudoperationdemo.service;

import com.mss.crudoperationdemo.model.UserDetails;
import com.mss.crudoperationdemo.model.UserDetailsDTO;
import com.mss.crudoperationdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDetailsDTO saveUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = userRepository.save(getUserDetails(userDetailsDTO));
        return convertEntityToPojo(userDetails);
    }

    public UserDetailsDTO getUserDetailsByID(Integer userId) {
        UserDetails userDetails =userRepository.findById(userId).orElse(null);
        return  convertEntityToPojo(userDetails);
    }

    public UserDetailsDTO updateUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails =null;
//        UserDetails existingUserDetail = userRepository.findById(userDetailsDTO.getUserID()).orElse(null);
//       if( Objects.nonNull(existingUserDetail)){
//            existingUserDetail.setName(userDetailsDTO.getName());
//            existingUserDetail.setEmail(userDetailsDTO.getEmail());
//            existingUserDetail.setDepartment(userDetailsDTO.getDepartment());
//            userDetails = userRepository.save(getUserDetails(userDetailsDTO));
//        }
        userDetails = userRepository.save(getUserDetails(userDetailsDTO));
        return convertEntityToPojo(userDetails);
    }

    public String deleteUserDetailsById(Integer userId) {
        userRepository.deleteById(userId);
        return "Successfully deleted";
    }

    private UserDetails getUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetail = new UserDetails();
        userDetail.setUserID(userDetailsDTO.getUserID());
        userDetail.setName(userDetailsDTO.getName());
        userDetail.setEmail(userDetailsDTO.getEmail());
        userDetail.setDepartment(userDetailsDTO.getDepartment());
        return userDetail;
    }

    private UserDetailsDTO convertEntityToPojo(UserDetails userDetail) {
        if (Objects.nonNull(userDetail)) {
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            userDetailsDTO.setUserID(userDetail.getUserID());
            userDetailsDTO.setName(userDetail.getName());
            userDetailsDTO.setEmail(userDetail.getEmail());
            userDetailsDTO.setDepartment(userDetail.getDepartment());
            return userDetailsDTO;
        }
        return null;
    }
}
