package com.SplitWise.SplitWise.dtos;

import com.SplitWise.SplitWise.services.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponsedto {
    List<Transaction> transactions;

    @Override
    public String toString() {
        return "SettleUpGroupResponsedto{" +
                "transactions=" + transactions +
                '}';
    }
}
