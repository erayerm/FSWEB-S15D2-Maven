package org.example.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String pick) {
        //enchanced switch?
        switch (pick) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> union = new HashSet<>();
                union.addAll(annsTasks);
                union.addAll(bobsTasks);
                union.addAll(carolsTasks);
                return union;
            default:
                return null;
        }
    }

    public Set<Task> getUnion(Set<Task> task1, Set<Task> task2) {
        Set<Task> union = new HashSet<>();
        union.addAll(task1);
        union.addAll(task2);
        return union;
    }

    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2) {
        Set<Task> intersection = new HashSet<>(task1);
        intersection.retainAll(task2);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2) {
        Set<Task> difference = new HashSet<>(task1);
        difference.removeAll(task2);
        return difference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskData taskData = (TaskData) o;
        return Objects.equals(annsTasks, taskData.annsTasks) && Objects.equals(bobsTasks, taskData.bobsTasks) && Objects.equals(carolsTasks, taskData.carolsTasks) && Objects.equals(unassignedTasks, taskData.unassignedTasks);
    }
    @Override
    public int hashCode() {
        return Objects.hash(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
    }
    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                ", unassignedTasks=" + unassignedTasks +
                '}';
    }


}
