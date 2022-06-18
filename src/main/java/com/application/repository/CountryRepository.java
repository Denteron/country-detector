package com.application.repository;

import com.application.domain.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, String> {

    //@Query("select c from CountryEntity c where ?1 like concat(c.code, '%')")
   // CountryEntity findCountryByCodeLike(String number);

    //@Query("select c from CountryEntity c where upper(c.code) like concat('%', upper(?1), '%')")
    @Query("select c from CountryEntity c where ?1 like concat(c.code, '%')")
    List<CountryEntity> findWithQuery(String name);

}
