package com.SplitWise.SplitWise.repositories;

import com.SplitWise.SplitWise.models.ExpenseUser;
import com.SplitWise.SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepo extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findAllByUser(User user);

}
