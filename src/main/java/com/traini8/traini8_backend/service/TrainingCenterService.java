package com.traini8.traini8_backend.service;


import com.traini8.traini8_backend.model.TrainingCenter;
import com.traini8.traini8_backend.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
                return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }

    public List<TrainingCenter> getAllTrainingCenters(String city, String state, String course, String centerName) {
        if (Objects.nonNull(city) && Objects.nonNull(state)) {
            return repository.findByAddressCityAndAddressState(city, state);
        } else if (Objects.nonNull(city)) {
            return repository.findByAddressCity(city);
        } else if (Objects.nonNull(state)) {
            return repository.findByAddressState(state);
        } else if (Objects.nonNull(course)) {
            return repository.findByCoursesOffered(course);
        } else if (Objects.nonNull(centerName)) {
            return repository.findByCenterNameContainingIgnoreCase(centerName);
        } else {
            return repository.findAll();
        }
    }
}
