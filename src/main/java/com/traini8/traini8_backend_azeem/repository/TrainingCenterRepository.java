package com.traini8.traini8_backend_azeem.repository;

import com.traini8.traini8_backend_azeem.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    List<TrainingCenter> findByAddressCity(String city);

    List<TrainingCenter> findByAddressState(String state);

    List<TrainingCenter> findByCenterNameContainingIgnoreCase(String centerName);

    //filter by course offered
    @Query("SELECT t FROM TrainingCenter t JOIN t.coursesOffered c WHERE c = :course")
    List<TrainingCenter> findByCoursesOffered(@Param("course") String course);

    //combined filter (city and state)
    List<TrainingCenter> findByAddressCityAndAddressState(String city, String state);
}
