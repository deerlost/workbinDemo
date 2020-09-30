package com.mushiny.workbin.rabbit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangtao
 * @description:
 * @date 2020/7/15 3:09 下午
 */
public class MonitorToteTaskStatusChange {

    private Integer sectionId;
    private String robotId;
    private Integer currentCellId;
    private Short level;
    private Integer battery;
    private Integer currentStepId;
    private String toteAGVTaskType;
    /**
     * 每个料箱任务类型
     */
    private String toteAGVStepTaskType;
    private String taskId;
    private String stepTaskId;
    /**
     *  整个任务状态
     */
    private String taskStatus;
    /**
     * 每个料箱任务状态
     */
    private String stepTaskStatus;
    private List<String> toteCodes;
    private String toteCode;
    private String binCode;

    public Integer getSectionId() {
        return sectionId;
    }

    public MonitorToteTaskStatusChange setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public String getRobotId() {
        return robotId == null ? "" : robotId;
    }

    public MonitorToteTaskStatusChange setRobotId(String robotId) {
        this.robotId = robotId;
        return this;
    }

    public Integer getCurrentCellId() {
        return currentCellId;
    }

    public MonitorToteTaskStatusChange setCurrentCellId(Integer currentCellId) {
        this.currentCellId = currentCellId;
        return this;
    }

    public Short getLevel() {
        return level;
    }

    public MonitorToteTaskStatusChange setLevel(Short level) {
        this.level = level;
        return this;
    }

    public Integer getBattery() {
        return battery;
    }

    public MonitorToteTaskStatusChange setBattery(Integer battery) {
        this.battery = battery;
        return this;
    }

    public Integer getCurrentStepId() {
        return currentStepId;
    }

    public MonitorToteTaskStatusChange setCurrentStepId(Integer currentStepId) {
        this.currentStepId = currentStepId;
        return this;
    }

    public String getToteAGVTaskType() {
        return toteAGVTaskType == null ? "" : toteAGVTaskType;
    }

    public MonitorToteTaskStatusChange setToteAGVTaskType(String toteAGVTaskType) {
        this.toteAGVTaskType = toteAGVTaskType;
        return this;
    }

    public String getToteAGVStepTaskType() {
        return toteAGVStepTaskType == null ? "" : toteAGVStepTaskType;
    }

    public MonitorToteTaskStatusChange setToteAGVStepTaskType(String toteAGVStepTaskType) {
        this.toteAGVStepTaskType = toteAGVStepTaskType;
        return this;
    }

    public String getTaskId() {
        return taskId == null ? "" : taskId;
    }

    public MonitorToteTaskStatusChange setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getStepTaskId() {
        return stepTaskId == null ? "" : stepTaskId;
    }

    public MonitorToteTaskStatusChange setStepTaskId(String stepTaskId) {
        this.stepTaskId = stepTaskId;
        return this;
    }

    public String getTaskStatus() {
        return taskStatus == null ? "" : taskStatus;
    }

    public MonitorToteTaskStatusChange setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    public String getStepTaskStatus() {
        return stepTaskStatus == null ? "" : stepTaskStatus;
    }

    public MonitorToteTaskStatusChange setStepTaskStatus(String stepTaskStatus) {
        this.stepTaskStatus = stepTaskStatus;
        return this;
    }

    public List<String> getToteCodes() {
        if (toteCodes == null) {
            return new ArrayList<>();
        }
        return toteCodes;
    }

    public MonitorToteTaskStatusChange setToteCodes(List<String> toteCodes) {
        this.toteCodes = toteCodes;
        return this;
    }

    public String getToteCode() {
        return toteCode == null ? "" : toteCode;
    }

    public MonitorToteTaskStatusChange setToteCode(String toteCode) {
        this.toteCode = toteCode;
        return this;
    }

    public String getBinCode() {
        return binCode == null ? "" : binCode;
    }

    public MonitorToteTaskStatusChange setBinCode(String binCode) {
        this.binCode = binCode;
        return this;
    }
}
