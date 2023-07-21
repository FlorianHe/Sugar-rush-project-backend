package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.SugarData;
import com.templateproject.api.entity.Profile;

@Repository
public interface SugarDataRepository extends JpaRepository<SugarData, Long> {

    public List<SugarData> findByProfileId(Long id);

    @Query("SELECT sum(sd.amount) FROM SugarData sd WHERE sd.date >= CURRENT_DATE AND sd.profile = :profile")
    public Integer getSumAmountByDateAndByProfileId(@Param("profile") Profile profile);
}
