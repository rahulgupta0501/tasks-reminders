package com.inno.tasks.Controller;

import com.inno.tasks.Entity.Task;
import com.inno.tasks.ExceptionHandeling.ResourceNotFoundException;
import com.inno.tasks.Service.TasksService;
import com.inno.tasks.request.models.TaskDetailsRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TasksService taskService;

    @GetMapping("/")
    private List<Task> indexRoute() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    private Task getById(@PathVariable("id") String id) throws ResourceNotFoundException {
        return taskService.getById(id);
    }

    @PutMapping("/{id}")
    private Task updateById(@Valid @RequestBody TaskDetailsRequestModel taskDetails, @PathVariable("id") String id)
            throws ResourceNotFoundException {
        return taskService.update(taskDetails, id);

    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Task addTask(@Valid @RequestBody TaskDetailsRequestModel taskDetails) {
        Task task = taskService.add(taskDetails);
        return task;
    }
}
