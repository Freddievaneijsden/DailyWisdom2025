package com.example.dailywisdom2025.domain;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DailyWisdomService {

    DailyWisdomRepository dailyWisdomRepository;

    public DailyWisdomService(DailyWisdomRepository dailyWisdomRepository) {
        this.dailyWisdomRepository = dailyWisdomRepository;
    }

    public DailyWisdom getLatestDailyWisdom() {
        return dailyWisdomRepository.findTopByOrderByIdDesc().orElse(null);
    }
}
