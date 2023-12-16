package com.SplitWise.SplitWise.repositories;

import com.SplitWise.SplitWise.models.Expense;
import com.SplitWise.SplitWise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(Group group);

}
