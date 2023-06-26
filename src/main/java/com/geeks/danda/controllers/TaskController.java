package com.geeks.danda.controllers;

import com.geeks.danda.models.TaskDetails;
import com.geeks.danda.requests.CreateTask;
import com.geeks.danda.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<TaskDetails> findAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDetails createTask(@RequestBody CreateTask createTask) {
        return taskService.createTask(createTask);
    }

}
