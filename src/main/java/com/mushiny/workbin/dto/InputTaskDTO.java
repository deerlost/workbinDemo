package com.mushiny.workbin.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Package com.mushiny.workbin.dto
 * @anthor：wyang
 * @date：2020/11/2
 */
public class InputTaskDTO {
    private List<WorkBinTaskDTO> taskList;

    public List<WorkBinTaskDTO> getTaskList() {
        if (taskList == null) {
            return new ArrayList<>();
        }
        return taskList;
    }

    public InputTaskDTO setTaskList(List<WorkBinTaskDTO> taskList) {
        this.taskList = taskList;
        return this;
    }
}
