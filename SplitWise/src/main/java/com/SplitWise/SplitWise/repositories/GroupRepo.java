package com.SplitWise.SplitWise.repositories;

import com.SplitWise.SplitWise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    @Override
    Optional<Group> findById(Long aLong);
}
