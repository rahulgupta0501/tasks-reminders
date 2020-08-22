package com.inno.tasks.Service;

import com.inno.tasks.Entity.Task;
import com.inno.tasks.ExceptionHandeling.ResourceNotFoundException;
import com.inno.tasks.Repository.TaskRepository;
import com.inno.tasks.request.models.TaskDetailsRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService  {

    @Autowired
    TaskRepository taskRepository;


    public List<Task> getAll() {
        return taskRepository.findAll();
    }


    public Task getById(String id) throws ResourceNotFoundException{
        Optional<Task> t = taskRepository.findById(id);
        if(t.isPresent()) return t.get();
        throw new ResourceNotFoundException("Task","id",id);
    }


    public Task deleteById(String id) throws ResourceNotFoundException {
        Optional<Task> t = taskRepository.findById(id);
        if(t!=null){
            taskRepository.deleteById(id);
            return t.get();
        }
        throw new ResourceNotFoundException("Task","id",id);
    }

    public Task add(TaskDetailsRequestModel taskDetails) {
        Task newTask = new Task(taskDetails.getTaskName(), taskDetails.getTaskDescription(), taskDetails.getUserId());
        taskRepository.save(newTask);
        System.out.println(newTask);
        return newTask;
    }

    public Task update(TaskDetailsRequestModel taskDetails,String id) throws ResourceNotFoundException{
        Optional<Task> t = taskRepository.findById(id);
        if(t.isPresent()){
            Task task = t.get();
            task.setTaskName(taskDetails.getTaskName());
            task.setTaskDescription(taskDetails.getTaskDescription());
            taskRepository.save(task);
            return task;
        }
        throw new ResourceNotFoundException("Task","id",id);
    }

}
