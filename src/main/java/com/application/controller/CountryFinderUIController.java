package com.application.controller;

import com.application.service.IdentifyCountryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
public class CountryFinderUIController {

    private final IdentifyCountryService service;

    @GetMapping("/{number}")
    public String findCountryWithUI(Model model, @PathVariable(value = "number") String number) {
        var response = service.findCountryByPhoneNumber(number);
        model.addAttribute("response", response);
        return "resultOfFoundCountry";
    }

    @GetMapping()
    public String startPage() {
        return "index";
    }



}
