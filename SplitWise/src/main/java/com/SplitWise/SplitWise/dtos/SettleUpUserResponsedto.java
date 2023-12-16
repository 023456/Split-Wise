package com.SplitWise.SplitWise.dtos;

import com.SplitWise.SplitWise.services.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SettleUpUserResponsedto {
    List<Transaction> transactions;
}
