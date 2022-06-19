package com.application.controller;

import com.application.service.IdentifyCountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/ui/find")
public class CountryFinderUIController {

    private final IdentifyCountryService service;

    @GetMapping(value = "/{number}")
    public String findCountry(Model model, @PathVariable(value = "number") String number) {
        var response = service.findCountryByPhoneNumber(number);
        model.addAttribute("response", response);
        return "redirect:/ui/foundCountry";
    }


}
