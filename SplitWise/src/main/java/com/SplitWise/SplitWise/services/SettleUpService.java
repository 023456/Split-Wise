package com.SplitWise.SplitWise.services;

import com.SplitWise.SplitWise.Exceptions.GroupNotFoundException;
import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.Strategies.SettleUpStrategy;
import com.SplitWise.SplitWise.models.Expense;
import com.SplitWise.SplitWise.models.ExpenseUser;
import com.SplitWise.SplitWise.models.Group;
import com.SplitWise.SplitWise.models.User;
import com.SplitWise.SplitWise.repositories.ExpenseRepo;
import com.SplitWise.SplitWise.repositories.ExpenseUserRepo;
import com.SplitWise.SplitWise.repositories.GroupRepo;
import com.SplitWise.SplitWise.repositories.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SettleUpService {

    @Autowired
    private Userrepo userrepo;
    @Autowired
    private ExpenseUserRepo expenseUserRepo;
    @Autowired
    private SettleUpStrategy settleUpStrategy;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private ExpenseRepo expenseRepo;

    public List<Transaction> settleUpUser(long userId) throws UserNotFoundException {
        /*
        1) Fetch the users
        2)Fetch all the expenses which the user is a part of
        3) Iterate through all the expenses and find out all the people involved and how much
        is owed and owes by each
        $) use min and max heap algo to caluclate the list of transaction
        5) Return list of transactions
        6)
         */
        Optional<User>  userOptional = userrepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");

        }
        User user = userOptional.get();
        List<ExpenseUser> expenseUsers = expenseUserRepo.findAllByUser(user);
        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }


        List<Transaction> transactions = settleUpStrategy.settle(expenses);
        List<Transaction> filterTransaction = new ArrayList<>();
//        for (int i = 0; i< transactions.size(); i++) {
//            Transaction transaction = transactions.get(i);
//        }
        for(Transaction transaction : transactions){
            if(transaction.getFrom().equals(user)|| transaction.getTo().equals(user)){
                filterTransaction.add(transaction);

            }
        }
         return filterTransaction;

    }

    public List<Transaction> settleUpGroup(Long groupId) throws GroupNotFoundException {
        Optional<Group> optionalGroup = groupRepo.findById(groupId);
        if(optionalGroup.isEmpty()){
            throw new GroupNotFoundException("Group not found");
        }
        Group group = optionalGroup.get();

        List<Expense> expenses = expenseRepo.findAllByGroup(group);
        List<Transaction> transactions = settleUpStrategy.settle(expenses);
        return transactions;

    }
}
