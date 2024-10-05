package com.traini8.Backend_Traini8_Azeem.Service;

import com.traini8.Backend_Traini8_Azeem.Database.TrainingCenterDAO;
import com.traini8.Backend_Traini8_Azeem.Exceptions.TrainingCenterAlreadyExistsException;
import com.traini8.Backend_Traini8_Azeem.Model.TrainingCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterDAO trainingCenterDAO;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        //set createdOn to current epoch time
        trainingCenter.setCreatedOn(System.currentTimeMillis());

        if (trainingCenterDAO.existsByCenterCode(trainingCenter.getCenterCode())!=null) {
            throw new TrainingCenterAlreadyExistsException("Center code already exists: " + trainingCenter.getCenterCode());
        }

        trainingCenterDAO.insert(trainingCenter);
        return trainingCenter;
    }


    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterDAO.getAllTrainingCenters();
    }
}

