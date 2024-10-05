package com.traini8.Backend_Traini8_Azeem.Controller;

import com.traini8.Backend_Traini8_Azeem.Model.TrainingCenter;
import com.traini8.Backend_Traini8_Azeem.Service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedTrainingCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainingCenter);
    }

    @GetMapping("/azeem")
    public List<TrainingCenter> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters();
        return trainingCenters;
    }
}

