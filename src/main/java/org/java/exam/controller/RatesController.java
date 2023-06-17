package org.java.exam.controller;

import org.java.exam.model.Rate;
import org.java.exam.service.RateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RatesController {
    private final RateService rateService;

    public RatesController(RateService rateService) {
        this.rateService = rateService;
    }
    @GetMapping
    public List<Rate> getAllWorkouts() {
        return rateService.getAllRates();
    }

    @PostMapping
    public Rate createWorkout(@RequestBody Rate rate) {
        return rateService.createRate(rate);
    }

    @GetMapping("/{id}")
    public Rate getWorkoutById(@PathVariable("id") Long id) {
        return rateService.getRateById(id);
    }

    @PutMapping("/{id}")
    public Rate updateWorkout(@PathVariable("id") Long id, @RequestBody Rate workout) {
        return rateService.updateRate(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") Long id) {
        rateService.deleteRate(id);
    }
}

/*
@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable("id") Long id) {
        return workoutService.getWorkoutById(id);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable("id") Long id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") Long id) {
        workoutService.deleteWorkout(id);
    }
}
*/