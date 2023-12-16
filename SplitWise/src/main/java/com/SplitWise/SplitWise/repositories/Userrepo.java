package com.SplitWise.SplitWise.repositories;

import com.SplitWise.SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Long> {
    Optional<User>findById(Long aLong);

    User save(User user);
}
