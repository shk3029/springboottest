package me.js.springboottest.sample;

import me.js.springboottest.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello2")
    public String hello() {
        logger.info("hey log");
        return "hello change" + sampleService.getName();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return null;
    }
}
