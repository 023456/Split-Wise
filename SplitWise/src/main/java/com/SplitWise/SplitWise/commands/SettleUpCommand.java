package com.SplitWise.SplitWise.commands;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.controllers.SettleUpController;
import com.SplitWise.SplitWise.dtos.SettleUpUserRequestdto;
import com.SplitWise.SplitWise.dtos.SettleUpUserResponsedto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpCommand implements Command{
    private SettleUpController settleUpController;
    @Override
    public void execute(String input) throws UserNotFoundException {
     List<String>  words = List.of(input.split(""));
     Long userId = Long.valueOf(words.get(0));
     SettleUpUserRequestdto settleUpUserRequestdto = new SettleUpUserRequestdto();
     settleUpUserRequestdto.setUserId(userId);
     SettleUpUserResponsedto settleUpUserResponsedto = settleUpController.settleUpUser(settleUpUserRequestdto);

    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(""));
        return words.size() ==2 &&
                words.get(1).equalsIgnoreCase(CommandKeyword.settleup);
    }
}
