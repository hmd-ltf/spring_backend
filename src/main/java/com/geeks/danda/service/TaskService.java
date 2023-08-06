package com.geeks.danda.service;

import com.geeks.danda.constants.TaskStatuses;
import com.geeks.danda.models.TaskDetails;
import com.geeks.danda.DAO.TasksDAO;
import com.geeks.danda.models.requests.CreateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class TaskService {

    private final TasksDAO tasksDAO;

    @Autowired
    public TaskService(TasksDAO tasksDAO) {
        this.tasksDAO = tasksDAO;
    }

    public TaskDetails createTask(CreateTask createTask) {

        TaskDetails taskDetails = new TaskDetails();
        taskDetails.setName(createTask.getName());
        taskDetails.setDetails(createTask.getDetails());
        taskDetails.setDeadLine(createTask.getDeadLine());
        taskDetails.setTimeEstimation(createTask.getTimeEstimation());
        taskDetails.setRemainingTime(Duration.ofMinutes(0));
        taskDetails.setTaskStatus(TaskStatuses.PENDING);

        tasksDAO.save(taskDetails);

        return taskDetails;
    }

    public List<TaskDetails> getAllTasks() {
        return tasksDAO.getAllTasks();
    }
}
