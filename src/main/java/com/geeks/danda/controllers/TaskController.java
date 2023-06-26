package com.geeks.danda.controllers;

import com.geeks.danda.models.TaskDetails;
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
    public List<TaskDetails> findAllProducts() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDetails addProduct(@RequestBody TaskDetails taskDetails) {
        return taskService.createTask(taskDetails);
    }

}
