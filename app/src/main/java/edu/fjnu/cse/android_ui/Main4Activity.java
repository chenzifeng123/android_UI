package edu.fjnu.cse.android_ui;



import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



public class Main4Activity extends AppCompatActivity  {
     Button button1;
     Button button2;
     Button button3;
     Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //绑定按钮事件

        button1=(Button)findViewById(R.id.one_btn);
        button2=(Button)findViewById(R.id.two_btn);
        button3=(Button)findViewById(R.id.three_btn);
        button4=(Button)findViewById(R.id.four_btn);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Main4Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Main4Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Main4Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

     /*   button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(Main4Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        });*/

      //  registerForContextMenu(button4);
        //对话框
        initEvent();

}

    public void ToContextualMenu(View view){
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }



    //设置按钮事件
    private void initEvent() {
        findViewById(R.id.two_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        Button mButton1;
        Button mButton2;
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout=inflater.inflate(R.layout.order,null);  //布局
        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this)
                .setView(layout);
        final AlertDialog dialog=builder.create();
        dialog.show();
        mButton1 = (Button) layout.findViewById(R.id.startOrder_btn);
        mButton2 = (Button)layout.findViewById(R.id.managerOrder_btn);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText()
                dialog.dismiss();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


}











