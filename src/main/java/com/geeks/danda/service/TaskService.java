package com.geeks.danda.service;

import com.geeks.danda.constants.TaskStatuses;
import com.geeks.danda.models.TaskDetails;
import com.geeks.danda.repositories.TaskRepository;
import com.geeks.danda.requests.CreateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDetails createTask(CreateTask createTask) {

        TaskDetails taskDetails = new TaskDetails();
        taskDetails.setName(createTask.getName());
        taskDetails.setDetails(createTask.getDetails());
        taskDetails.setDeadLine(createTask.getDeadLine());
        taskDetails.setTimeEstimation(createTask.getTimeEstimation());
        taskDetails.setRemainingTime(Duration.ofMinutes(0));
        taskDetails.setTaskStatus(TaskStatuses.PENDING);

        taskRepository.save(taskDetails);

        return taskDetails;
    }

    public List<TaskDetails> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
