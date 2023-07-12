package com.templateproject.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.templateproject.api.entity.SugarData;
import com.templateproject.api.service.SugarDataService;

@RestController
@RequestMapping("/sugar-datas")
public class SugarDataController {

    private final SugarDataService sugarDataService;

    public SugarDataController(SugarDataService sugarDataService) {
        this.sugarDataService = sugarDataService;
    }

    @GetMapping
    public List<SugarData> getSugarDatas() {
        return sugarDataService.getSugarDatas();
    }

    @PostMapping
    public SugarData create(@RequestBody SugarData sugarData) {
        return sugarDataService.create(sugarData);
    }

    @DeleteMapping("/{id}")
    public SugarData delete(@PathVariable Long id) {
        return sugarDataService.delete(id);
    }
}
