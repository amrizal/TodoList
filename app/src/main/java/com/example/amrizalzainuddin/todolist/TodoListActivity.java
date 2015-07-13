package com.example.amrizalzainuddin.todolist;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class TodoListActivity extends ActionBarActivity implements NewItemFragment.OnNewItemAddedListener {

    private ToDoItemAdapter aa;
    private ArrayList<ToDoItem> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        FragmentManager fm = getFragmentManager();
        ToDoListFragment toDoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);

        todoItems = new ArrayList<ToDoItem>();

        int resID = R.layout.todolist_item;
        aa = new ToDoItemAdapter(this, resID, todoItems);

        toDoListFragment.setListAdapter(aa);
    }

    public  void onNewItemAdded(String newItem){
        ToDoItem newToDoItem = new ToDoItem(newItem);
        todoItems.add(0, newToDoItem);
        aa.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
