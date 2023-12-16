package com.SplitWise.SplitWise.Strategies;

import com.SplitWise.SplitWise.models.Expense;
import com.SplitWise.SplitWise.models.ExpenseUser;
import com.SplitWise.SplitWise.models.ExpenseUserType;
import com.SplitWise.SplitWise.models.User;
import com.SplitWise.SplitWise.services.Transaction;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class HeapBasedSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        HashMap<User, Double> outstandingAmountMap = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>();
        // Loop through all expenses and userExpenses for each expense, and calculate the final outstanding amount for each user
        for (Expense expense : expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                User user = expenseUser.getUser();
                double currentOutStandingAmount = outstandingAmountMap.getOrDefault(user, 0.00);
                outstandingAmountMap.put(user,getUpdatedOutStandingAmount(currentOutStandingAmount,expenseUser) );
            }

        }

        // maxheap contains all the users with the positive balance
        PriorityQueue<Map.Entry<User,Double>> maxheap = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(),a.getValue()));


      // minheap contains all the users with the negative balance
        PriorityQueue<Map.Entry<User,Double>> minheap = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));

//Populate the heaps using the values from the map
      for(Map.Entry<User,Double> entry : outstandingAmountMap.entrySet()){
          if(entry.getValue()<0){
              minheap.add(entry);
          }
          else if(entry.getValue()>0){
              maxheap.add(entry);
          }
          else {
              System.out.println(entry.getKey().getName() + "'s is already settled");

          }
      }
      // calculate the transaction until heaps become empty
        while (!minheap.isEmpty()){
            // removing out min from minheap and max from maxheap
            Map.Entry<User,Double> maxHasToPay = minheap.poll();
            Map.Entry<User,Double> maxwillgetpaid  = maxheap.poll();
            Transaction transaction1 = new
                    Transaction(maxHasToPay.getKey().getName() ,
                    maxwillgetpaid.getKey().getName() , Math.min(Math.abs(maxHasToPay.getValue()) , maxwillgetpaid.getValue()));
              transactions.add(transaction1);

              double newBalance = maxHasToPay.getValue() + maxwillgetpaid.getValue();
              if(newBalance==0){
                  System.out.println("Settled for :  " + maxHasToPay.getKey().getName() + ", and " + maxwillgetpaid.getKey().getName());

              }
              else if(newBalance<0){
                  maxHasToPay.setValue(newBalance);
                  minheap.add(maxHasToPay);
              } else if (newBalance>0) {
                  maxwillgetpaid.setValue(newBalance);
                  maxheap.add(maxwillgetpaid);

              }
        }
        return transactions;
    }


        private double getUpdatedOutStandingAmount (double currentOutstandingamount , ExpenseUser expenseUser){
            if(expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID_BY)){
                currentOutstandingamount = currentOutstandingamount + expenseUser.getAmount();
            }
            else {
                currentOutstandingamount = currentOutstandingamount - expenseUser.getAmount();
            }
            return currentOutstandingamount;
        }




}
