package com.hufstudy.back.service;

import com.hufstudy.back.domain.Developer;
import com.hufstudy.back.repository.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService{
    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    @Transactional
    public Developer updateShortBio(Long developerId, String shortBio){
        return developerRepository.findById(developerId).map(existingDeveloper -> {
            existingDeveloper.setShortBio(shortBio);
            return developerRepository.save(existingDeveloper);
        }).orElseThrow(()-> new RuntimeException("Developer not found with id " + developerId));
    }

    @Override
    @Transactional
    public Developer updateIntroduction(Long developerId, String introduction){
        return developerRepository.findById(developerId).map(existingDeveloper -> {
            existingDeveloper.setIntroduction(introduction);
            return developerRepository.save(existingDeveloper);
        }).orElseThrow(()-> new RuntimeException("Developer not found with id " + developerId));
    }

}
