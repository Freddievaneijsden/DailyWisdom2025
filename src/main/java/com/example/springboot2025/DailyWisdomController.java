package com.example.springboot2025;

import com.example.springboot2025.infrastructure.persistence.DailyWisdomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DailyWisdomController {

    DailyWisdomRepository dailyWisdomRepository;

    public DailyWisdomController(DailyWisdomRepository dailyWisdomRepository) {
        this.dailyWisdomRepository = dailyWisdomRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("dailywisdom")
    String getAllDailyWisdom (Model model) {
        model.addAttribute("dailyWisdomRepository", dailyWisdomRepository.findAll());
        return "seeMessage";
    }
}
