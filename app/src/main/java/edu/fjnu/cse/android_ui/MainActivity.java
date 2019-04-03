package edu.fjnu.cse.android_ui;

//import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
//import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] icons = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化ListView控件
        mListView = findViewById(R.id.ls);//////
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("face", icons[i]);
            listItem.put("name", names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simleAdapter = new SimpleAdapter(MainActivity.this, listItems,
                R.layout.list_item, new String[]{"face", "name"}, new int[]{R.id.face, R.id.name});
        mListView.setAdapter(simleAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //我们需要的内容，跳转页面或显示详细信息
                Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_LONG).show();
                if (((ListView)parent).getTag() != null){
                    ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
                }
                ((ListView)parent).setTag(view);
                view.setBackgroundColor(Color.RED);
            } });
            }



}
