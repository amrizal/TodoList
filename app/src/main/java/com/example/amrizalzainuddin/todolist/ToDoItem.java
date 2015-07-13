package com.example.amrizalzainuddin.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by amrizal.zainuddin on 13/7/2015.
 */
public class ToDoItem {
    String task;
    Date created;

    public Date getCreated() {
        return created;
    }

    public String getTask() {
        return task;
    }

    public ToDoItem(String _task) {
       this(_task, new Date(java.lang.System.currentTimeMillis()));
    }

    public ToDoItem(String _task, Date _created) {
        this.created = _created;
        this.task = _task;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String dateString = sdf.format(created);
        return "(" + dateString + ") " + task;
    }
}
