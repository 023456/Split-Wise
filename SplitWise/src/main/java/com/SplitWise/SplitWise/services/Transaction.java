package com.SplitWise.SplitWise.services;

import com.SplitWise.SplitWise.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // parameterised constructor
@NoArgsConstructor // default constructor

public class Transaction {

    private String from;
    private String  to;
    private double amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
