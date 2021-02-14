package com.sawicka.springrestimage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test1")
    public String get1() {
        return "test1";
    }

    @GetMapping("/test2")
    public String get2() {
        return "test2";
    }

    @GetMapping("/test3")
    public String get3() {
        return "test3";
    }

}
