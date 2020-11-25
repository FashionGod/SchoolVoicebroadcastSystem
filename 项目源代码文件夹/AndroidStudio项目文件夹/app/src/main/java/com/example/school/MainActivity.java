package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    HashMap<Integer, Integer> soundMap = new HashMap<Integer, Integer>();
    private float volumnRatio;
    private AudioManager am;
    private SoundPool soundPool;
    public String text="";
    public TextView title;
    public TextView LeaveSchoolNews;
    public TextView todayDate;
    public Button one_one;
    public Button one_two;
    public Button one_three;
    public Button one_four;
    public Button one_five;
    public Button one_six;
    public Button two_one;
    public Button two_two;
    public Button two_three;
    public Button two_four;
    public Button two_five;
    public Button two_six;
    public Button three_one;
    public Button three_two;
    public Button three_three;
    public Button three_four;
    public Button three_five;
    public Button three_six;
    public Button four_one;
    public Button four_two;
    public Button four_three;
    public Button four_four;
    public Button four_five;
    public Button four_six;
    public Button five_one;
    public Button five_two;
    public Button five_three;
    public Button five_four;
    public Button five_five;
    public Button five_six;
    public Button six_one;
    public Button six_two;
    public Button six_three;
    public Button six_four;
    public Button six_five;
    public Button six_six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title) ;
        LeaveSchoolNews = (TextView)findViewById(R.id.LeaveSchoolNews);
        todayDate = (TextView)findViewById(R.id.todayDate) ;
        one_one = (Button)findViewById(R.id.one_one);
        one_two = (Button)findViewById(R.id.one_two);
        one_three = (Button)findViewById(R.id.one_three);
        one_four = (Button)findViewById(R.id.one_four);
        one_five = (Button)findViewById(R.id.one_five);
        one_six = (Button)findViewById(R.id.one_six);
        two_one = (Button)findViewById(R.id.two_one);
        two_two = (Button)findViewById(R.id.two_two);
        two_three = (Button)findViewById(R.id.two_three);
        two_four = (Button)findViewById(R.id.two_four);
        two_five = (Button)findViewById(R.id.two_five);
        two_six = (Button)findViewById(R.id.two_six);
        three_one = (Button)findViewById(R.id.three_one);
        three_two = (Button)findViewById(R.id.three_two);
        three_three = (Button)findViewById(R.id.three_three);
        three_four = (Button)findViewById(R.id.three_four);
        three_five = (Button)findViewById(R.id.three_five);
        three_six = (Button)findViewById(R.id.three_six);
        four_one = (Button)findViewById(R.id.four_one);
        four_two = (Button)findViewById(R.id.four_two);
        four_three = (Button)findViewById(R.id.four_three);
        four_four = (Button)findViewById(R.id.four_four);
        four_five = (Button)findViewById(R.id.four_five);
        four_six = (Button)findViewById(R.id.four_six);
        five_one = (Button)findViewById(R.id.five_one);
        five_two = (Button)findViewById(R.id.five_two);
        five_three = (Button)findViewById(R.id.five_three);
        five_four = (Button)findViewById(R.id.five_four);
        five_five = (Button)findViewById(R.id.five_five);
        five_six = (Button)findViewById(R.id.five_six);
        six_one = (Button)findViewById(R.id.six_one);
        six_two = (Button)findViewById(R.id.six_two);
        six_three = (Button)findViewById(R.id.six_three);
        six_four = (Button)findViewById(R.id.six_four);
        six_five = (Button)findViewById(R.id.six_five);
        six_six = (Button)findViewById(R.id.six_six);

        //初始化音频
        initSound();
        //初始化标题
        initSharePreferences();

        title.setText(sharedPreferences.getString("title","XX学校放学信息播报系统"));
        //遍历所有的二到六班查询并修改为之前的设置。
        updateClass();
        updateTitleSharePreferences();
        title.setOnClickListener(new View.OnClickListener() {
            Context context = getBaseContext();
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请输入标题");
                final EditText et = new EditText(MainActivity.this);
                builder.setView(et);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text = et.getText().toString().trim();
                        if(!TextUtils.isEmpty(et.getText().toString().trim())){
                            Toast.makeText(MainActivity.this,et.getText().toString(),Toast.LENGTH_SHORT).show();
                            title.setText(text);
                        }
                        updateTitleSharePreferences();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();

            }
        });
    //以下为单击按钮事件监听
        //以下为一年级
        one_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_one.setSelected(true);
                        playSound(1);
                        LeaveSchoolNews.setText("请注意：一年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });

        one_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_two.setSelected(true);
                        playSound(2);
                        LeaveSchoolNews.setText("请注意：一年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        one_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_three.setSelected(true);
                        playSound(3);
                        LeaveSchoolNews.setText("请注意：一年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        one_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_four.setSelected(true);
                        playSound(4);
                        LeaveSchoolNews.setText("请注意：一年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        one_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_five.setSelected(true);
                        playSound(5);
                        LeaveSchoolNews.setText("请注意：一年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        one_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        one_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        one_six.setSelected(true);
                        playSound(6);
                        LeaveSchoolNews.setText("请注意：一年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        //以下为二年级
        two_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_one.setSelected(true);
                        playSound(7);
                        LeaveSchoolNews.setText("请注意：二年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        two_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_two.setSelected(true);
                        playSound(8);
                        LeaveSchoolNews.setText("请注意：二年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        two_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_three.setSelected(true);
                        playSound(9);
                        LeaveSchoolNews.setText("请注意：二年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        two_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_four.setSelected(true);
                        playSound(10);
                        LeaveSchoolNews.setText("请注意：二年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        two_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_five.setSelected(true);
                        playSound(11);
                        LeaveSchoolNews.setText("请注意：二年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        two_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        two_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        two_six.setSelected(true);
                        playSound(12);
                        LeaveSchoolNews.setText("请注意：二年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        //以下为三年级
        three_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_one.setSelected(true);
                        playSound(13);
                        LeaveSchoolNews.setText("请注意：三年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        three_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_two.setSelected(true);
                        playSound(14);
                        LeaveSchoolNews.setText("请注意：三年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        three_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_three.setSelected(true);
                        playSound(15);
                        LeaveSchoolNews.setText("请注意：三年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        three_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_four.setSelected(true);
                        playSound(16);
                        LeaveSchoolNews.setText("请注意：三年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        three_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_five.setSelected(true);
                        playSound(17);
                        LeaveSchoolNews.setText("请注意：三年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        three_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        three_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        three_six.setSelected(true);
                        playSound(18);
                        LeaveSchoolNews.setText("请注意：三年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
//        //以下为四年级
        four_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_one.setSelected(true);
                        playSound(19);
                        LeaveSchoolNews.setText("请注意：四年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        four_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_two.setSelected(true);
                        playSound(20);
                        LeaveSchoolNews.setText("请注意：四年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        four_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_three.setSelected(true);
                        playSound(21);
                        LeaveSchoolNews.setText("请注意：四年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        four_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_four.setSelected(true);
                        playSound(22);
                        LeaveSchoolNews.setText("请注意：四年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        four_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_five.setSelected(true);
                        playSound(23);
                        LeaveSchoolNews.setText("请注意：四年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        four_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        four_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        four_six.setSelected(true);
                        playSound(24);
                        LeaveSchoolNews.setText("请注意：四年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        //五年级
        five_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_one.setSelected(true);
                        playSound(25);
                        LeaveSchoolNews.setText("请注意：五年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        five_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_two.setSelected(true);
                        playSound(26);
                        LeaveSchoolNews.setText("请注意：五年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        five_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_three.setSelected(true);
                        playSound(27);
                        LeaveSchoolNews.setText("请注意：五年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        five_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_four.setSelected(true);
                        playSound(28);
                        LeaveSchoolNews.setText("请注意：五年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        five_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_five.setSelected(true);
                        playSound(29);
                        LeaveSchoolNews.setText("请注意：五年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        five_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        five_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        five_six.setSelected(true);
                        playSound(30);
                        LeaveSchoolNews.setText("请注意：五年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        //六年级
        six_one.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_one.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_one.setSelected(true);
                        playSound(31);
                        LeaveSchoolNews.setText("请注意：六年级一班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        six_two.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_two.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_two.setSelected(true);
                        playSound(32);
                        LeaveSchoolNews.setText("请注意：六年级二班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        six_three.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_three.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_three.setSelected(true);
                        playSound(33);
                        LeaveSchoolNews.setText("请注意：六年级三班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        six_four.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_four.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_four.setSelected(true);
                        playSound(34);
                        LeaveSchoolNews.setText("请注意：六年级四班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        six_five.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_five.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_five.setSelected(true);
                        playSound(35);
                        LeaveSchoolNews.setText("请注意：六年级五班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
        six_six.setOnClickListener(new Button.OnClickListener() {
            int flag = 1;
            public void onClick(View view) {
                switch (flag){
                    case 0:
                        six_six.setSelected(false);
                        flag = 1;
                        break;
                    case 1:
                        six_six.setSelected(true);
                        playSound(36);
                        LeaveSchoolNews.setText("请注意：六年级六班已放学！");
                        flag = 0;
                        break;
                }
            }
        });
    //以下为长按按钮事件监听
        //以下为一年级
        one_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        one_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        one_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        one_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag =0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("12",12);
                        editor.commit();
                        one_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("12",0);
                        editor.commit();
                        one_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        one_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("13",13);
                        editor.commit();
                        one_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("13",0);
                        editor.commit();
                        one_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        one_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("14",14);
                        editor.commit();
                        one_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("14",0);
                        editor.commit();
                        one_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        one_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("15",15);
                        editor.commit();
                        one_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("15",0);
                        editor.commit();
                        one_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        one_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("16",16);
                        editor.commit();
                        one_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("16",0);
                        editor.commit();
                        one_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        //以下为二年级
        two_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        two_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        two_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        two_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("22",22);
                        editor.commit();
                        two_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("22",0);
                        editor.commit();
                        two_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        two_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("23",23);
                        editor.commit();
                        two_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("23",0);
                        editor.commit();
                        two_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        two_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("24",24);
                        editor.commit();
                        two_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("24",0);
                        editor.commit();
                        two_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        two_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("25",25);
                        editor.commit();
                        two_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("25",0);
                        editor.commit();
                        two_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        two_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("26",26);
                        editor.commit();
                        two_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("26",0);
                        editor.commit();
                        two_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        //以下为三年级长按
        three_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        three_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        three_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        three_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("32",32);
                        editor.commit();
                        three_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("32",0);
                        editor.commit();
                        three_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        three_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("33",33);
                        editor.commit();
                        three_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("33",0);
                        editor.commit();
                        three_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        three_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("34",34);
                        editor.commit();
                        three_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("34",0);
                        editor.commit();
                        three_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        three_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("35",35);
                        editor.commit();
                        three_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("35",0);
                        editor.commit();
                        three_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        three_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("36",36);
                        editor.commit();
                        three_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("36",0);
                        editor.commit();
                        three_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        //四年级长按
        four_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        four_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        four_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        four_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("42",42);
                        editor.commit();
                        four_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("42",0);
                        editor.commit();
                        four_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        four_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("43",43);
                        editor.commit();
                        four_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("43",0);
                        editor.commit();
                        four_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        four_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("44",44);
                        editor.commit();
                        four_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("44",0);
                        editor.commit();
                        four_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        four_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("45",45);
                        editor.commit();
                        four_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("45",0);
                        editor.commit();
                        four_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        four_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("46",46);
                        editor.commit();
                        four_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("46",0);
                        editor.commit();
                        four_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        //五年级长按
        five_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        five_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        five_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        five_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("52",52);
                        editor.commit();
                        five_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("52",0);
                        editor.commit();
                        five_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        five_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("53",53);
                        editor.commit();
                        five_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("53",0);
                        editor.commit();
                        five_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        five_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("54",54);
                        editor.commit();
                        five_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("54",0);
                        editor.commit();
                        five_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        five_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("55",55);
                        editor.commit();
                        five_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("55",0);
                        editor.commit();
                        five_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        five_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("56",56);
                        editor.commit();
                        five_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("56",0);
                        editor.commit();
                        five_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        //六年级长按
        six_one.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        six_one.setText("");
                        flag = 1;
                        break;
                    case 1:
                        six_one.setText("一班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        six_two.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("62",62);
                        editor.commit();
                        six_two.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("62",0);
                        editor.commit();
                        six_two.setText("二班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        six_three.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("63",63);
                        editor.commit();
                        six_three.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("63",0);
                        editor.commit();
                        six_three.setText("三班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        six_four.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("64",64);
                        editor.commit();
                        six_four.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("64",0);
                        editor.commit();
                        six_four.setText("四班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        six_five.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("65",65);
                        editor.commit();
                        six_five.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("65",0);
                        editor.commit();
                        six_five.setText("五班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
        six_six.setOnLongClickListener(new Button.OnLongClickListener() {
            int flag = 0;
            public boolean onLongClick(View view) {
                switch (flag){
                    case 0:
                        editor.putInt("66",66);
                        editor.commit();
                        six_six.setText("");
                        flag = 1;
                        break;
                    case 1:
                        editor.putInt("66",0);
                        editor.commit();
                        six_six.setText("六班");
                        flag = 0;
                        break;
                }
                return false;
            }

        });
//实时显示时间
        new TimeThread().start(); //启动时间线程
    }
    public void disappear(View view){
        LeaveSchoolNews.setText("");
    }
    public void refreshDate(){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm");
        String str = formatter.format(date);
        todayDate.setText(str);
    }
    //实时显示时间线程
    class TimeThread extends Thread {
        @Override
        public void run() {
            refreshDate();
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;  //消息(一个整型值)
                    mHandler.sendMessage(msg);// 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    refreshDate();
                    break;
                default:
                    break;

            }
        }
    };
    //遍历所有班级改变布局
    public void updateClass(){
        //一年级
        if(sharedPreferences.getInt("12",0)==0){
            one_two.setText("二班");
        }
        else {
            one_two.setText("");
        }
        if(sharedPreferences.getInt("13",0)==0){
            one_three.setText("三班");
        }
        else {
            one_three.setText("");
        }
        if(sharedPreferences.getInt("14",0)==0){
            one_four.setText("四班");
        }
        else {
            one_four.setText("");
        }
        if(sharedPreferences.getInt("15",0)==0){
            one_five.setText("五班");
        }
        else {
            one_five.setText("");
        }
        if(sharedPreferences.getInt("16",0)==0){
            one_six.setText("六班");
        }
        else {
            one_six.setText("");
        }
        //二年级
        if(sharedPreferences.getInt("22",0)==0){
            two_two.setText("二班");
        }
        else {
            two_two.setText("");
        }
        if(sharedPreferences.getInt("23",0)==0){
            two_three.setText("三班");
        }
        else {
            two_three.setText("");
        }
        if(sharedPreferences.getInt("24",0)==0){
            two_four.setText("四班");
        }
        else {
            two_four.setText("");
        }
        if(sharedPreferences.getInt("25",0)==0){
            two_five.setText("五班");
        }
        else {
            two_five.setText("");
        }
        if(sharedPreferences.getInt("26",0)==0){
            two_six.setText("六班");
        }
        else {
            two_six.setText("");
        }
        //三年级
        if(sharedPreferences.getInt("32",0)==0){
            three_two.setText("二班");
        }
        else {
            three_two.setText("");
        }
        if(sharedPreferences.getInt("33",0)==0){
            three_three.setText("三班");
        }
        else {
            three_three.setText("");
        }
        if(sharedPreferences.getInt("34",0)==0){
            three_four.setText("四班");
        }
        else {
            three_four.setText("");
        }
        if(sharedPreferences.getInt("35",0)==0){
            three_five.setText("五班");
        }
        else {
            three_five.setText("");
        }
        if(sharedPreferences.getInt("36",0)==0){
            three_six.setText("六班");
        }
        else {
            three_six.setText("");
        }
        //四年级
        if(sharedPreferences.getInt("42",0)==0){
            four_two.setText("二班");
        }
        else {
            four_two.setText("");
        }
        if(sharedPreferences.getInt("43",0)==0){
            four_three.setText("三班");
        }
        else {
            four_three.setText("");
        }
        if(sharedPreferences.getInt("44",0)==0){
            four_four.setText("四班");
        }
        else {
            four_four.setText("");
        }
        if(sharedPreferences.getInt("45",0)==0){
            four_five.setText("五班");
        }
        else {
            four_five.setText("");
        }
        if(sharedPreferences.getInt("46",0)==0){
            four_six.setText("六班");
        }
        else {
            four_six.setText("");
        }
        //五年级
        if(sharedPreferences.getInt("52",0)==0){
            five_two.setText("二班");
        }
        else {
            five_two.setText("");
        }
        if(sharedPreferences.getInt("53",0)==0){
            five_three.setText("三班");
        }
        else {
            five_three.setText("");
        }
        if(sharedPreferences.getInt("54",0)==0){
            five_four.setText("四班");
        }
        else {
            five_four.setText("");
        }
        if(sharedPreferences.getInt("55",0)==0){
            five_five.setText("五班");
        }
        else {
            five_five.setText("");
        }
        if(sharedPreferences.getInt("56",0)==0){
            five_six.setText("六班");
        }
        else {
            five_six.setText("");
        }
        //六年级
        if(sharedPreferences.getInt("62",0)==0){
            six_two.setText("二班");
        }
        else {
            six_two.setText("");
        }
        if(sharedPreferences.getInt("63",0)==0){
            six_three.setText("三班");
        }
        else {
            six_three.setText("");
        }
        if(sharedPreferences.getInt("64",0)==0){
            six_four.setText("四班");
        }
        else {
            six_four.setText("");
        }
        if(sharedPreferences.getInt("65",0)==0){
            six_five.setText("五班");
        }
        else {
            six_five.setText("");
        }
        if(sharedPreferences.getInt("66",0)==0){
            six_six.setText("六班");
        }
        else {
            six_six.setText("");
        }

    }
    public void initSharePreferences(){
        //标题修改以及年级数的存储
        //建立储存单元
        sharedPreferences = getSharedPreferences("title",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //初始化班级修改情况储存单元  0表示该班级存在，对应数字表示班级不存在
        getSharedPreferences("12",0);
        getSharedPreferences("13",0);
        getSharedPreferences("14",0);
        getSharedPreferences("15",0);
        getSharedPreferences("16",0);
        getSharedPreferences("22",0);
        getSharedPreferences("23",0);
        getSharedPreferences("24",0);
        getSharedPreferences("25",0);
        getSharedPreferences("26",0);
        getSharedPreferences("32",0);
        getSharedPreferences("33",0);
        getSharedPreferences("34",0);
        getSharedPreferences("35",0);
        getSharedPreferences("36",0);
        getSharedPreferences("42",0);
        getSharedPreferences("43",0);
        getSharedPreferences("44",0);
        getSharedPreferences("45",0);
        getSharedPreferences("46",0);
        getSharedPreferences("52",0);
        getSharedPreferences("53",0);
        getSharedPreferences("54",0);
        getSharedPreferences("55",0);
        getSharedPreferences("56",0);
        getSharedPreferences("62",0);
        getSharedPreferences("63",0);
        getSharedPreferences("64",0);
        getSharedPreferences("65",0);
        getSharedPreferences("66",0);
        editor.commit();
    }
    public void updateTitleSharePreferences(){

        editor.putString("title",title.getText().toString());
        editor.commit();
    }
    //播放音频
    public void initSound(){
        soundPool = new SoundPool(40, AudioManager.STREAM_SYSTEM,5);
        soundMap .put(1,soundPool.load(this,R.raw.oneone,1));
        soundMap.put(2,soundPool.load(this,R.raw.onetwo,1));
        soundMap.put(3,soundPool.load(this,R.raw.onethree,1));
        soundMap .put(4,soundPool.load(this,R.raw.onefour,1));
        soundMap .put(5,soundPool.load(this,R.raw.onefive,1));
        soundMap .put(6,soundPool.load(this,R.raw.onesix,1));
        soundMap .put(7,soundPool.load(this,R.raw.twoone,1));
        soundMap .put(8,soundPool.load(this,R.raw.twotwo,1));
        soundMap .put(9,soundPool.load(this,R.raw.twothree,1));
        soundMap .put(10,soundPool.load(this,R.raw.twofour,1));
        soundMap .put(11,soundPool.load(this,R.raw.twofive,1));
        soundMap .put(12,soundPool.load(this,R.raw.twosix,1));
        soundMap .put(13,soundPool.load(this,R.raw.threeone,1));
        soundMap .put(14,soundPool.load(this,R.raw.threetwo,1));
        soundMap .put(15,soundPool.load(this,R.raw.threethree,1));
        soundMap .put(16,soundPool.load(this,R.raw.threefour,1));
        soundMap .put(17,soundPool.load(this,R.raw.threefive,1));
        soundMap .put(18,soundPool.load(this,R.raw.threesix,1));
        soundMap .put(19,soundPool.load(this,R.raw.fourone,1));
        soundMap .put(20,soundPool.load(this,R.raw.fourtwo,1));
        soundMap .put(21,soundPool.load(this,R.raw.fourthree,1));
        soundMap .put(22,soundPool.load(this,R.raw.fourfour,1));
        soundMap .put(23,soundPool.load(this,R.raw.fourfive,1));
        soundMap .put(24,soundPool.load(this,R.raw.foursix,1));
        soundMap .put(25,soundPool.load(this,R.raw.fiveone,1));
        soundMap .put(26,soundPool.load(this,R.raw.fivetwo,1));
        soundMap .put(27,soundPool.load(this,R.raw.fivethree,1));
        soundMap .put(28,soundPool.load(this,R.raw.fivefour,1));
        soundMap .put(29,soundPool.load(this,R.raw.fivefive,1));
        soundMap .put(30,soundPool.load(this,R.raw.fivesix,1));
        soundMap .put(31,soundPool.load(this,R.raw.sixone,1));
        soundMap .put(32,soundPool.load(this,R.raw.sixtwo,1));
        soundMap .put(33,soundPool.load(this,R.raw.sixthree,1));
        soundMap .put(34,soundPool.load(this,R.raw.sixfour,1));
        soundMap .put(35,soundPool.load(this,R.raw.sixfive,1));
        soundMap .put(36,soundPool.load(this,R.raw.sixsix,1));
        am = (AudioManager)this.getSystemService(AUDIO_SERVICE);

    }
    public void playSound(int id) {

        float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // 返回当前AudioManager对象的最大音量值
        float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);// 返回当前AudioManager对象的音量值
        volumnRatio = audioCurrentVolumn / audioMaxVolumn;
        try {
            soundPool.play(soundMap.get(id), volumnRatio, // 左声道音量
                    volumnRatio, // 右声道音量
                    1, // 优先级，0为最低
                    0, // 循环次数，0无不循环，-1无永远循环
                    1 // 回放速度 ，该值在0.5-2.0之间，1为正常速度
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        Log.i("Wmx logs::", "活动销毁...");
        super.onDestroy();
        /**注销 unregisterReceiver()，否则可能引起内存泄露。*/
    }

}
