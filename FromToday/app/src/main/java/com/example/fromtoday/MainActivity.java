package com.example.fromtoday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //화면 상수 값 지정
    private static final int FRAGMENT_FOOD = 0;
    private static final int FRAGMENT_SLEEP = 1;
    private static final int FRAGMENT_HOME=2;
    private static final int FRAGMENT_ACTIVITY=3;
    private static final int FRAGMENT_PEOPLE=4;

    //---------------------------------------------------------------------------------------------
    // fields
    //---------------------------------------------------------------------------------------------
    // 네비게이션 사용을 위한 선언
    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    // 각 뷰에 값을 사용하기 위한 객체선언
    private Frag_Food fragFood;
    private Frag_Sleep fragSleep;
    private Frag_Home fragHome;
    private Frag_Activity fragActivity;
    private Frag_People fragPeople;

    private ImageView info;
    public SharedPreferences user_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);
        currentUser();


        bottomNavigationView = findViewById(R.id.bottom_Navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // 선택된 메뉴 번호 전달
                switch (menuItem.getItemId()){
                    case R.id.food:
                        setFrag(FRAGMENT_FOOD);
                        break;
                    case R.id.sleep:
                        setFrag(FRAGMENT_SLEEP);
                        break;
                    case R.id.home:
                        setFrag(FRAGMENT_HOME);
                        break;
                    case R.id.activity:
                        setFrag(FRAGMENT_ACTIVITY);
                        break;
                    case R.id.people:
                        setFrag(FRAGMENT_PEOPLE);
                        break;
                }
                return true;
            }
        });
        // 각 뷰에 값을 사용하기 위한 객체생성
        fragFood = new Frag_Food();
        fragSleep = new Frag_Sleep();
        fragHome = new Frag_Home();
        fragActivity = new Frag_Activity();
        fragPeople = new Frag_People();
        //foodDataActivity=new FoodDataActivity();
        // 첫 프래그먼트 화면을 무엇으로 지정해줄 것인지
        setFrag(FRAGMENT_HOME);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(intent);
            }
        });

    }

    // 프래그먼트 교체가 일어나는 실행문
    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0 :
                ft.replace(R.id.main_frame, fragFood);
                ft.commit(); // 저장
                break;
            case 1 :
                ft.replace(R.id.main_frame, fragSleep);
                ft.commit(); // 저장
                break;
            case 2 :
                ft.replace(R.id.main_frame, fragHome);
                ft.commit(); // 저장
                break;
            case 3 :
                ft.replace(R.id.main_frame, fragActivity);
                ft.commit(); // 저장
                break;
            case 4 :
                //Login Activity 에서 넘어온 값 받기.
//                Intent intent =getIntent();
//
//                String strName=intent.getStringExtra("name");
//                String strImage = intent.getStringExtra("profile");
//                String strEmail=intent.getStringExtra("email");
//                String strGender=intent.getStringExtra("gender");
//                String strAge=intent.getStringExtra("age");
//                String strBirth=intent.getStringExtra("birthday");
//
//                Bundle bundle = new Bundle(6);
//                bundle.putString("profile",strImage);
//                bundle.putString("name",strName);
//                bundle.putString("birthday",strAge);
//                bundle.putString("email",strEmail);
//                bundle.putString("gender",strGender);
//                bundle.putString("age",strAge);
//                bundle.putString("birthday",strBirth);
//
//                Frag_People people = new Frag_People();
//                people.setArguments(bundle);
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.main_frame,people).commit();
                ft.replace(R.id.main_frame, fragPeople);
                ft.commit();
                break;
        }


    }

    private void currentUser() {
        Intent intent = getIntent();

        String strName = intent.getStringExtra("name");
        String strProfile = intent.getStringExtra("profile");
        String strEmail = intent.getStringExtra("email");
        String strGender = intent.getStringExtra("gender");
        String strAge = intent.getStringExtra("age");
        String strBirth = intent.getStringExtra("birthday");

        user_Value = getSharedPreferences("currentUser",MODE_PRIVATE);
        SharedPreferences.Editor editor = user_Value.edit();

        editor.putString("name",strName);
        editor.putString("profile",strProfile);
        editor.putString("email",strEmail);
        editor.putString("gender",strGender);
        editor.putString("age",strAge);
        editor.putString("birthday",strBirth);

        editor.commit();
    }

}