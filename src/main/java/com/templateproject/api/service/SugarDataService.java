package com.templateproject.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.SugarData;
import com.templateproject.api.repository.SugarDataRepository;

@Service
public class SugarDataService {

    private final SugarDataRepository sugarDataRepository;

    public SugarDataService(SugarDataRepository sugarDataRepository) {
        this.sugarDataRepository = sugarDataRepository;
    }

    public List<SugarData> getSugarDatas() {
        return sugarDataRepository.findAll();
    }

    public SugarData create(SugarData sugarData) {
        sugarData.setDate(new Date());
        return sugarDataRepository.save(sugarData);
    }

    public SugarData delete(Long id) {
        SugarData sugarData = sugarDataRepository.findById(id).get();
        sugarDataRepository.deleteById(id);
        return sugarData;
    }

    public List<SugarData> findSugarDatasByProfileId(Long id) {
        return sugarDataRepository.findByProfileId(id);
    }
}
