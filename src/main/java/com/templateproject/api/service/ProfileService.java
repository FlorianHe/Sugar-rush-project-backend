package com.templateproject.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Profile;
import com.templateproject.api.entity.User;
import com.templateproject.api.repository.ProfileRepository;
import com.templateproject.api.repository.SugarDataRepository;
import com.templateproject.api.repository.UserRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final SugarDataRepository sugarDataRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, SugarDataRepository sugarDataRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.sugarDataRepository = sugarDataRepository;
        this.userRepository = userRepository;
    }

    public Profile getProfilById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile createProfileByUser(Long id, Profile profile) {
        User user = userRepository.getReferenceById(id);
        profile.setUser(user);
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
        Integer sumAmount = sugarDataRepository.getSumAmountByDateAndByProfileId(profile);
        if (sumAmount == null) {
            sumAmount = 0;
        }
        return sumAmount;
    }

    public List<Profile> getProfilesByUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return profileRepository.findByUser(user);
    }
}