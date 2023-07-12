package com.templateproject.api.service;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Profile;
import com.templateproject.api.repository.ProfileRepository;
import com.templateproject.api.repository.SugarDataRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final SugarDataRepository sugarDataRepository;

    public ProfileService(ProfileRepository profileRepository, SugarDataRepository sugarDataRepository) {
        this.profileRepository = profileRepository;
        this.sugarDataRepository = sugarDataRepository;
    }

    public Profile getProfilById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile update(Long id, Profile profile) {
        Profile profileToUpdate = profileRepository.findById(id).get();
        profileToUpdate.setName(profile.getName());
        profileToUpdate.setBirthDate(profile.getBirthDate());
        profileToUpdate.setLogo(profile.getLogo());
        return profileRepository.save(profile);
    }

    public boolean delete(Long id) {
        profileRepository.deleteById(id);
        return true;
    }

    public Integer findTodaySugarDatasByProfileId(Long id) {
        Profile profile = profileRepository.findById(id).get();
        return sugarDataRepository.getSumAmountByDateAndByProfileId(profile);
    }
}