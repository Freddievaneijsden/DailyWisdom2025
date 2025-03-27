package com.example.dailywisdom2025.controller;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.domain.DailyWisdomService;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DailyWisdomController {

    DailyWisdomRepository dailyWisdomRepository;
    DailyWisdomService dailyWisdomService;

    public DailyWisdomController(DailyWisdomRepository dailyWisdomRepository, DailyWisdomService dailyWisdomService) {
        this.dailyWisdomRepository = dailyWisdomRepository;
        this.dailyWisdomService = dailyWisdomService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("dailywisdomrespons")
    @ResponseBody
    DailyWisdom getLatestDailyWisdom(Model model) {
        return dailyWisdomService.getLatestDailyWisdom();
    }

    @PostMapping("/addMessage")
    public String addDailyWisdom(@RequestParam String message) {
        DailyWisdom newMessage = new DailyWisdom();
        newMessage.setMessage(message);
        dailyWisdomRepository.save(newMessage);
        return "redirect:/";
    }

    @RequestMapping("/dailywisdom")
    String getLatestDailyWisdomHTML(Model model) {
        var latestDailyWisdom = dailyWisdomService.getLatestDailyWisdom();
        model.addAttribute("dailyWisdomRepository", latestDailyWisdom);
        return "seeMessage";
    }

    @GetMapping("/all")
    String getAllDailyWisdom (Model model){
        var wisdomList = dailyWisdomService.getAllDailyWisdom();
        model.addAttribute("wisdomList", wisdomList);
        return "dailyWisdomList";
    }
}
