package com.traini8.Backend_Traini8_Azeem.Database;

import com.traini8.Backend_Traini8_Azeem.Model.TrainingCenter;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TrainingCenterDAO {

    @SqlUpdate("INSERT INTO training_center (center_name, center_code, detailed_address, city, state, pincode, student_capacity, courses_offered, created_on, contact_email, contact_phone) " +
            "VALUES (:centerName, :centerCode, :address.detailedAddress, :address.city, :address.state, :address.pincode, :studentCapacity, :coursesOffered, :createdOn, :contactEmail, :contactPhone)")
    void insert(@BindBean TrainingCenter trainingCenter);

    @SqlQuery("SELECT * FROM training_center;")
    @RegisterBeanMapper(TrainingCenter.class)
    List<TrainingCenter> getAllTrainingCenters();

    @SqlQuery("SELECT * FROM training_center WHERE center_code = :centerCode")
    @RegisterBeanMapper(TrainingCenter.class)
    TrainingCenter existsByCenterCode(@Bind("centerCode") String centerCode);

}

