package com.vn.green.rest.controller;

import com.vn.green.rest.test.Summary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculationController {

    private Summary result;

    @GetMapping("/no-auth/sum")
    @ResponseBody
    public ResponseEntity sum(@RequestParam(value = "first-number") int firstNumber, @RequestParam(value = "second-number") int secondNumber) {

        int sum = firstNumber + secondNumber;
        Summary summary = new Summary(firstNumber, secondNumber, sum);

        return new ResponseEntity(result, HttpStatus.OK);
    }

}
