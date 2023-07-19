package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
