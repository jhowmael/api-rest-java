package com.company.nomeprojeto.tasks.api;

import com.company.nomeprojeto.tasks.dto.TaskDTO;
import com.company.nomeprojeto.tasks.facade.TasksFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksAPI {
    @Autowired
    private TasksFacade tasksFacade;

    @PostMapping
    @ResponseBody
    public TaskDTO create(@RequestBody TaskDTO taskDTO) {
        return tasksFacade.create(taskDTO);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TaskDTO update(@PathVariable("taskId") Long taskId,
                          @RequestBody TaskDTO taskDTO) {
        return tasksFacade.update(taskDTO, taskId);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getAll() {
        return tasksFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String dell(@PathVariable("taskId") Long taskId) {
        return tasksFacade.delete(taskId);
    }
}