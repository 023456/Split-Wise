package com.SplitWise.SplitWise.services;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.models.User;
import com.SplitWise.SplitWise.repositories.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProfileService {

    @Autowired
    private Userrepo userrepo;
    public User updateProfile(long userId , String email, String phoneNo) throws UserNotFoundException {
        Optional<User> userOptional = userrepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setEmail(email);
        user.setPhoneNo(phoneNo);
        User updatedUser = userrepo.save(user);
        return updatedUser;

    }
}
