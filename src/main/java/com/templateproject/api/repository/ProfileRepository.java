package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Profile;
import com.templateproject.api.entity.User;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findByUser(User user);
}
