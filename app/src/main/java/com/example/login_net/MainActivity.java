package com.example.login_net;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItem;

    EditText editText1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가족 구성원 추가");

        editText1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);

        listItem = new ArrayList<String>();

        // 아이템 추가한다.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listItem.add(editText1.getText().toString());
                adapter.notifyDataSetChanged(); // 변경되었음을 어답터에 알려준다.
                editText1.setText("");
            }
        });


        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listItem);
        listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        // 각 아이템 클릭시 해당 아이템 삭제한다.
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 콜백매개변수는 순서대로 어댑터뷰, 해당 아이템의 뷰, 클릭한 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),listItem.get(i).toString() + " 삭제되었습니다.",Toast.LENGTH_SHORT).show();

                listItem.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }
}




