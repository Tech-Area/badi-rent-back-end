package com.techarea.badirent.repository;

import com.techarea.badirent.entity.ATV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATVRepository extends JpaRepository<ATV, Long> {
}
