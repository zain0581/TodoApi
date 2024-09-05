package com.example.todolist.Models;
import android.location.Location;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

enum  TypeTask{
    Cleaning,
    Cooking,
    Televission,
    YardWork,
    Planning
}
enum Priorty{

    High,
    Low,
    Normal,

}
public class ToDoTsk {
  int id;
    String name;
    String imageFileBefore;
    String imageFileAfter;
    String description;
    LocalDateTime plannedStartTime;
    LocalDateTime plannedEndTime;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int timeSpend;
    Location location;
    TypeTask typeTask;
    List<ToDoTsk> todoitemblockerlist;
    Boolean isCompleted = false;
    Boolean isRepeatable;
    int Xp;
    Priorty priorty;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageFileBefore() {
        return imageFileBefore;
    }

    public void setImageFileBefore(String imageFileBefore) {
        this.imageFileBefore = imageFileBefore;
    }

    public String getImageFileAfter() {
        return imageFileAfter;
    }

    public void setImageFileAfter(String imageFileAfter) {
        this.imageFileAfter = imageFileAfter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(int timeSpend) {
        this.timeSpend = timeSpend;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public List<ToDoTsk> getTodoitemblockerlist() {
        return todoitemblockerlist;
    }

    public void setTodoitemblockerlist(List<ToDoTsk> todoitemblockerlist) {
        this.todoitemblockerlist = todoitemblockerlist;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Boolean getRepeatable() {
        return isRepeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        isRepeatable = repeatable;
    }

    public int getXp() {
        return Xp;
    }

    public void setXp(int xp) {
        Xp = xp;
    }

    public Priorty getPriorty() {
        return priorty;
    }

    public void setPriorty(Priorty priorty) {
        this.priorty = priorty;
    }
}
