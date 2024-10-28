package com.deadline.repository;

import com.deadline.model.DeadlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeadlineRepository extends JpaRepository<DeadlineEntity, Long> {
    List<DeadlineEntity> findByUserId(Long userId);
}