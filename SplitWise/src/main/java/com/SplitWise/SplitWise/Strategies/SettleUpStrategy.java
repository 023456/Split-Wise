package com.SplitWise.SplitWise.Strategies;

import com.SplitWise.SplitWise.models.Expense;
import com.SplitWise.SplitWise.services.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settle(List<Expense> expenses);
}
