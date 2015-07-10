package com.example.amrizalzainuddin.todolist;

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


public class TodoListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);

        final ArrayList<String> todoItems = new ArrayList<String>();

        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                    if((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)){
                        todoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                return false;
            }
        });
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
