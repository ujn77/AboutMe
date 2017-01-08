package com.example.abuinichev.lesson2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present */
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.MA);
        switch (item.getItemId()) {

            case R.id.mn_2:
                Toast toast = Toast.makeText(this, "Просто тост", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.mn_3_1:
                ll.setBackgroundColor(Color.RED);
                return true;
            case R.id.mn_3_2:
                ll.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.mn_3_3:
                ll.setBackgroundColor(Color.GREEN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
