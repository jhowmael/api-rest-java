package com.company.nomeprojeto.tasks.facade;

import com.company.nomeprojeto.tasks.dto.TaskDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TasksFacade {
    private static final Map<Long, TaskDTO> tasks = new HashMap();

    public TaskDTO create(TaskDTO taskDTO){
        Long nextId = tasks.keySet().size() + 1L;
        taskDTO.setId(nextId);
        tasks.put(nextId, taskDTO);

        return taskDTO;
    }

    public TaskDTO update (TaskDTO taskDTO, Long taskID){
        tasks.put(taskID, taskDTO);
        return taskDTO;
    }

    public TaskDTO getById(Long taskId){
        return tasks.get(taskId);
    }

    public List<TaskDTO> getAll(){
        return new ArrayList<>(tasks.values());
    }

    public String delete (Long taskId){
        tasks.remove(taskId);
        return "DELETED";
    }
}
