package me.js.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("name", "jongseon");
        return "hi";
    }
}
