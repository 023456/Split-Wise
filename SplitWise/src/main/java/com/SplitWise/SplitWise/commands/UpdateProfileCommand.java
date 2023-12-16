package com.SplitWise.SplitWise.commands;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.controllers.UpdateProfileController;
import com.SplitWise.SplitWise.dtos.SettleUpUserRequestdto;
import com.SplitWise.SplitWise.dtos.SettleUpUserResponsedto;
import com.SplitWise.SplitWise.dtos.UpdateProfileRequestdto;
import com.SplitWise.SplitWise.dtos.UpdateProfileResponsedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class UpdateProfileCommand implements Command{

    @Autowired
    private UpdateProfileController updateProfileController;


    @Override
    public void execute(String input) throws UserNotFoundException {
        List<String> words = List.of(input.split(" "));
        long userId = Long.valueOf(words.get(0));
        UpdateProfileRequestdto updateProfileRequestdto = new UpdateProfileRequestdto();
        updateProfileRequestdto.setUserId(userId);
        UpdateProfileResponsedto updateProfileResponsedto = updateProfileController.updateProfile(updateProfileRequestdto);
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==3 && words.get(1).equalsIgnoreCase(CommandKeyword.updateProfile);
    }
}
