package com.example.baitap13th5;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	TextView selection;
	 String arr[]={"Intel","SamSung","Nokia","Simen","AMD","KIC","ECD"};
	 ArrayAdapter<String >adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        setListAdapter(adapter);
        selection=(TextView) findViewById(R.id.selection);
        }
    
        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        String txt="postion = "+position +"; value ="+arr[position];
	        selection.setText(txt);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
