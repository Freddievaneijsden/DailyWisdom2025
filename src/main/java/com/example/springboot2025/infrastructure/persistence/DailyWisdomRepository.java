package com.example.springboot2025.infrastructure.persistence;

import com.example.springboot2025.domain.entity.DailyWisdom;
import org.springframework.data.repository.ListCrudRepository;

public interface DailyWisdomRepository extends ListCrudRepository<DailyWisdom, Integer> {
}
