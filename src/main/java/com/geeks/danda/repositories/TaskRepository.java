package com.geeks.danda.repositories;

import com.geeks.danda.models.TaskDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<TaskDetails> taskDetailsList = new ArrayList<>();

    public List<TaskDetails> getAllTasks() {
        return taskDetailsList;
    }

    public TaskDetails findTaskById(int id) {
        TaskDetails taskDetail = null;

        for (TaskDetails details : taskDetailsList) {
            if (details.getId() == id) {
                taskDetail = details;
            }
        }

        return taskDetail;
    }

    public void save(TaskDetails taskDetail) {
        taskDetail.setId(taskDetailsList.size());
        taskDetailsList.add(taskDetail);
    }

    public void delete(int id) {
        taskDetailsList.removeIf(x -> x.getId() == id);
    }

    public TaskDetails update(TaskDetails taskDetails) {
        TaskDetails newTaskDetails = null;

        if (taskDetails != null) {
            newTaskDetails = findTaskById(taskDetails.getId());

            if (taskDetails.getName() != null) {
                newTaskDetails.setName(taskDetails.getName());
            }
            if (taskDetails.getDetails() != null) {
                newTaskDetails.setDetails(taskDetails.getDetails());
            }
            if (taskDetails.getTaskStatus() != null) {
                newTaskDetails.setTaskStatus(taskDetails.getTaskStatus());
            }
            if (taskDetails.getDeadLine() != null) {
                newTaskDetails.setDeadLine(taskDetails.getDeadLine());
            }
        }

        return newTaskDetails;
    }
}
