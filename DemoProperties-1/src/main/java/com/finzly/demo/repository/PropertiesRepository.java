package com.finzly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finzly.demo.entity.PropertiesManager;



@Repository
public interface PropertiesRepository extends JpaRepository<PropertiesManager,Long>{


}
