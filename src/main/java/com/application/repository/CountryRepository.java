package com.application.repository;

import com.application.domain.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, String> {


    @Query("select c from CountryEntity c where ?1 like concat(c.code, '%')")
    List<CountryEntity> findCountryByCode(String name);

}
