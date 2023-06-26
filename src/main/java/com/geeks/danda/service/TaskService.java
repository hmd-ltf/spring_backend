package com.geeks.danda.service;

import com.geeks.danda.models.TaskDetails;
import com.geeks.danda.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDetails createTask(TaskDetails taskDetails) {
        taskRepository.save(taskDetails);

        return taskDetails;
    }

    public List<TaskDetails> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
