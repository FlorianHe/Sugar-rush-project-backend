package com.templateproject.api.controller;

import org.springframework.web.bind.annotation.*;

import com.templateproject.api.entity.Profile;
import com.templateproject.api.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public Profile getProfilById(@PathVariable Long id) {
        return profileService.getProfilById(id);
    }

    @PostMapping
    public Profile create(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @PutMapping("/{id}")
    public Profile update(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return profileService.delete(id);
    }

    @GetMapping("/{id}/sugar-datas")
    public Integer getSugarDatasByProfileId(@PathVariable Long id) {
        return profileService.findTodaySugarDatasByProfileId(id);
    }
}
