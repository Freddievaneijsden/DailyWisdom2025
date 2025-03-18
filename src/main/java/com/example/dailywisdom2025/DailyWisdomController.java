package com.example.dailywisdom2025;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        DailyWisdom latestWisdom = dailyWisdomRepository.findTopByOrderByIdDesc().orElse(null);
        model.addAttribute("dailyWisdomRepository", latestWisdom);
        return "seeMessage";
    }

    @PostMapping("/addMessage")
    public String addDailyWisdom(@RequestParam String message) {
        DailyWisdom newMessage = new DailyWisdom();
        newMessage.setMessage(message);
        dailyWisdomRepository.save(newMessage);
        return "redirect:/";
    }
}
