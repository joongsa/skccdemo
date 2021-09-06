package com.skcc.skccdemo.controller;

import lombok.*;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequiredArgsConstructor

public class SampleApiController {

    @GetMapping("index")
    public String testFunction(@RequestParam("name") String name) {

        TestData testData = new TestData();
        testData.setName(name);

        String return_value = "Welcome who \t" + testData.getName() +"\t" + testData.getAudit_dtm();

        return return_value;

    }

    @Getter
    @Setter
    class TestData {

        private String name;
        private LocalTime audit_dtm = LocalTime.now();

    }

}

 