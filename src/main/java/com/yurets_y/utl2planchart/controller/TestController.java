package com.yurets_y.utl2planchart.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yurets_y.utl2planchart.entities.Station;
import com.yurets_y.utl2planchart.forms.RegistrationForm;
import com.yurets_y.utl2planchart.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test-request")
public class TestController {
    @Autowired
    StationsRepository stationRepo;

    @GetMapping("/test")
    public String doGet(Model model) throws JsonProcessingException {
        List<Station> stationsList = new ArrayList();
        stationsList.add(stationRepo.findFirstByCodeEquals(320007));
        stationsList.add(stationRepo.findFirstByCodeEquals(335801));
        stationsList.add(stationRepo.findFirstByCodeEquals(400409));
        stationsList.add(stationRepo.findFirstByCodeEquals(429002));
        model.addAttribute("stations",stationsList);
//        Station station = stationRepo.findFirstByCodeEquals(320007);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String JSONstation = objectMapper.writeValueAsString(station);
//
//        model.addAttribute("station",station);

        return "test";
    }

    @GetMapping
    public String getTestPage( RegistrationForm registrationForm, Model model){
        System.out.println("test request get");
        return "other/test";
    }

    @PostMapping
    public String doPost(RegistrationForm registrationForm, Model model){

        System.out.println("test request post");
        return "other/test";
    }


}
