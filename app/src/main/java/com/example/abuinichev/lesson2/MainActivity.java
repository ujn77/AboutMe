package com.example.abuinichev.lesson2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    //private ListAdapter mAdapter = null;
    private DataAdapter mAdapter = null;
    private String[] mStringArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TextView tv4 = (TextView) findViewById(R.id.textView4);
        registerForContextMenu(tv4);

        ListView lv = (ListView) findViewById(R.id.lv);

//        mAdapter = new ArrayAdapter<>(this, R.layout.my_list_item,
//        getResources().getStringArray(R.array.skill_list));

        mStringArray = getResources().getStringArray(R.array.skill_list);
        mAdapter = new DataAdapter(getApplicationContext(), mStringArray);

        //mAdapter.setOnRemoveItemListener(this);
       // getResources().getStringArray(R.array.skill_list);

//        for (int i = 1; i <= 30; i++) {
//            mAdapter.addItem("Item " + i);
//        }

        lv.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present */
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

//        menu.add(0, 1, 0, "Red");
//        menu.add(0, 2, 0, "Green");
//        menu.add(0, 3, 0, "Blue");

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.MA);
        switch (item.getItemId()) {

            case R.id.mn_2:
                Toast toast = Toast.makeText(this, "Просто тост", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.mn_4:
                AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(this);
                dlgBuilder.setTitle("Заголовок окна");
                dlgBuilder.setMessage("Сообщение");
                AlertDialog dialog = dlgBuilder.create();
                dialog.show();
                return true;
            case R.id.mn_5:
                AlertDialog.Builder dlgBuilder2 = new AlertDialog.Builder(this);
                dlgBuilder2.setTitle("Заголовок окна");
                dlgBuilder2.setMessage("Сообщение");
                dlgBuilder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //tvText.setText(getString(R.string.dlg_btn_ok));
                    }
                });
                dlgBuilder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //tvText.setText(getString(R.string.dlg_btn_cancel));
                    }
                });
                AlertDialog dialog2 = dlgBuilder2.create();
                dialog2.show();
                return true;
            case R.id.mn_6:
                final Calendar c = Calendar.getInstance();

                //Переменные для иницилизации значения даты в диалоге
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);

                //Создание диалога выбора даты
                DatePickerDialog dateDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                GregorianCalendar calendar = new GregorianCalendar(year,
                                        monthOfYear, dayOfMonth);

                                java.text.DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);

                                Date date = calendar.getTime();
                                //tvText.setText(format.format(date));
                            }
                        }, y, m, d);

                //Отображение диалога
                dateDialog.show();
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
