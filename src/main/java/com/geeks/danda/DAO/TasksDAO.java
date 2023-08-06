package com.geeks.danda.DAO;

import com.geeks.danda.models.TaskDetails;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TasksDAO {

    private final List<TaskDetails> taskDetailsList = new ArrayList<>();

    public List<TaskDetails> getAllTasks() {
        return taskDetailsList;
    }

    public void save(TaskDetails taskDetail) {
        taskDetail.setCreatedAt(Date.valueOf(LocalDate.now()));
        taskDetailsList.add(taskDetail);
    }

}
