package com.SplitWise.SplitWise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Expense extends BaseModel{
    private String description;
    private int amount;
    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

   @OneToMany(mappedBy = "expense", fetch = FetchType.EAGER)
    private List<ExpenseUser> expenseUsers;

  @ManyToOne
   private Group group;

    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

}
