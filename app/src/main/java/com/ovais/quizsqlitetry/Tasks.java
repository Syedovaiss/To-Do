package com.ovais.quizsqlitetry;

public class Tasks {
    private int id;
    private String task;
    public void Tasks(){}

    public Tasks( String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
