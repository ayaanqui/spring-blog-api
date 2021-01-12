package com.github.ayaanqui.springblogapi.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RestController()
public class GreetingsController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    private class Greeting {
        final long id;
        final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }

    @GetMapping("/greetings")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String val) {
        return new Greeting(counter.incrementAndGet(), String.format(template, val));
    }
}
