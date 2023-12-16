package com.SplitWise.SplitWise.controllers;

import com.SplitWise.SplitWise.Exceptions.GroupNotFoundException;
import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.dtos.SettleUpGroupRequestdto;
import com.SplitWise.SplitWise.dtos.SettleUpGroupResponsedto;
import com.SplitWise.SplitWise.dtos.SettleUpUserRequestdto;
import com.SplitWise.SplitWise.dtos.SettleUpUserResponsedto;
import com.SplitWise.SplitWise.services.SettleUpService;
import com.SplitWise.SplitWise.services.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpService settleUpService;
    public SettleUpUserResponsedto settleUpUser(SettleUpUserRequestdto settleUpUserRequestdto) throws UserNotFoundException {
        SettleUpUserResponsedto settleUpUserResponsedto = new SettleUpUserResponsedto();
        List<Transaction> transactionList = settleUpService.settleUpUser(settleUpUserRequestdto.getUserId());
        settleUpUserResponsedto.setTransactions(transactionList);
        return settleUpUserResponsedto;
    }

    public SettleUpGroupResponsedto settleUpGroup(SettleUpGroupRequestdto settleUpGroupRequestdto) throws GroupNotFoundException {
        SettleUpGroupResponsedto settleUpGroupResponsedto = new SettleUpGroupResponsedto();
        List<Transaction> transactions = settleUpService.settleUpGroup(settleUpGroupRequestdto.getGroup_id());
        settleUpGroupResponsedto.setTransactions(transactions);
        return settleUpGroupResponsedto;

    }
}
