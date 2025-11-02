package org.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {
    // Client
    public static void main(String[] args) {
        TaskList pullFromTable = new TaskList("Pull From Table");
        pullFromTable.addTaskList(new SimpleTask("UI"));
        pullFromTable.addTaskList(new SimpleTask("Field restriction"));
        pullFromTable.addTaskList(new SimpleTask("Generating code"));

        pullFromTable.display();
    }
}

interface  Task{  // Component ( Common Interface)
    String getTask();
    void setTask(String title);
    void display();
}

// Leaf
class SimpleTask implements  Task{

    private String title;

    public SimpleTask(String title){
        this.title = title;
    }

    /**
     * @return
     */
    @Override
    public String getTask() {
        return title;
    }

    /**
     * @param title
     */
    @Override
    public void setTask(String title) {
        this.title = title;
    }

    /**
     *
     */
    @Override
    public void display() {
        System.out.println("Simple Task is : "+ title);
    }
}

// Composite
class TaskList implements  Task {

    private String title;
    private List<Task> taskList;

   public TaskList(String title){
       this.title = title;
       this.taskList = new ArrayList<>();
   }

   public void addTaskList(Task task){
       this.taskList.add(task);
   }

   public void removeTask(Task task){
       this.taskList.remove(task);
   }


    /**
     * @return
     */
    @Override
    public String getTask() {
        return title;
    }

    /**
     * @param title
     */
    @Override
    public void setTask(String title) {
        this.title = title;
    }

    /**
     *
     */
    @Override
    public void display() {
        System.out.println("Task List of the project are :");
        for (Task task : taskList){
            task.display();
        }
    }
}