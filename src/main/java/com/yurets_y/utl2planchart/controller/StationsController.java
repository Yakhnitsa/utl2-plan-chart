package com.yurets_y.utl2planchart.controller;


import com.yurets_y.utl2planchart.entities.Station;
import com.yurets_y.utl2planchart.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class StationsController {

    @Autowired
    private StationsRepository stationsRepository;

    @GetMapping("/stations")
    public String getStations(Model model){
        Iterable<Station> stationsList = stationsRepository.findAll();
        model.addAttribute("stations",stationsList);
        return "other/stations";
    }

    @PostMapping("/stations")
    public String getStationsSearch(@RequestParam(required=false) String searchRequest, Model model){
        Iterable<Station> stationsList;

        if (searchRequest != null && !searchRequest.isEmpty()) {
            if(searchRequest.matches("\\d{6}")){
                stationsList = Arrays.asList(stationsRepository.findByCodeEquals(Integer.parseInt(searchRequest)));
            }else {
                stationsList = stationsRepository.findAllByUkrNameContainsOrRusNameContains(searchRequest,searchRequest);
            }

        } else {
            stationsList = stationsRepository.findAll();
        }
        model.addAttribute("stations", stationsList);
        return "other/stations";
    }


    @GetMapping("/stations-list")
    @ResponseBody
    public Iterable<Station> getRestStations(){
        Iterable<Station> stations = stationsRepository.findAll();
        return stations;
    }

}
