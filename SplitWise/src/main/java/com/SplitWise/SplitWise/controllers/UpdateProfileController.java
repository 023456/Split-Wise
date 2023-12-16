package com.SplitWise.SplitWise.controllers;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.dtos.ResponseStatus;
import com.SplitWise.SplitWise.dtos.UpdateProfileRequestdto;
import com.SplitWise.SplitWise.dtos.UpdateProfileResponsedto;
import com.SplitWise.SplitWise.models.User;
import com.SplitWise.SplitWise.services.UpdateProfileService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UpdateProfileController {

    @Autowired
    private UpdateProfileService updateProfileService;

    public UpdateProfileResponsedto updateProfile(UpdateProfileRequestdto updateProfileRequestdto) throws UserNotFoundException {
   UpdateProfileResponsedto updateProfileResponsedto = new UpdateProfileResponsedto();
   User user;
   try{
       user = updateProfileService.updateProfile(updateProfileRequestdto.getUserId() , updateProfileRequestdto.getEmail(),
               updateProfileRequestdto.getPhoneNo());
       updateProfileResponsedto.setEmail(user.getEmail());
       updateProfileResponsedto.setPhoneNo(user.getPhoneNo());
       updateProfileResponsedto.setResponseStatus(ResponseStatus.SUCCESS);


   }
   catch (Exception e){
       updateProfileResponsedto.setResponseStatus(ResponseStatus.FAILED);
   }
   return updateProfileResponsedto;



    }
}
