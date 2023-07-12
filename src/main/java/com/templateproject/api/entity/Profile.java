package com.templateproject.api.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthDate;
    private String logo;

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<SugarData> sugarDatas;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // private User user;

    public Profile() {
    }

    public Profile(String name, Date birthDate, String logo) {
        this.name = name;
        this.birthDate = birthDate;
        this.logo = logo;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<SugarData> getSugarDatas() {
        return this.sugarDatas;
    }

    public void setSugarDatas(List<SugarData> sugarDatas) {
        this.sugarDatas = sugarDatas;
    }

}
