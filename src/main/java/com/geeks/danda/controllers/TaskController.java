package com.geeks.danda.controllers;

import com.geeks.danda.models.TaskDetails;
import com.geeks.danda.requests.CreateTask;
import com.geeks.danda.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<TaskDetails> findAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDetails createTask(@RequestBody CreateTask createTask) {
        return taskService.createTask(createTask);
    }

}
