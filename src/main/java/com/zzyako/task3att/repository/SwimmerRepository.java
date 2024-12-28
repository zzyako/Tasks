package com.zzyako.task3att.repository;

import com.zzyako.task3att.entity.SwimmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SwimmerRepository extends JpaRepository<SwimmerEntity, UUID> {
}
