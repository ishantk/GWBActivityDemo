package com.auribises.gwbactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<User> userList;
    UserAdapter adapter;

    void initList(){
        listView = (ListView)findViewById(R.id.listView);

        User u1 = new User(R.drawable.category,"John Watson","9999999999");
        User u2 = new User(R.drawable.contact,"Jennie Watson","5555999999");
        User u3 = new User(R.drawable.pb,"Jim Watson","6669999999");
        User u4 = new User(R.drawable.music,"Jack Watson","9944567895");
        User u5 = new User(R.drawable.folder,"Joe Watson","9464567599");

        userList = new ArrayList<User>();
        userList.add(u1); // 0
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5); // n-1

        adapter = new UserAdapter(this,R.layout.list_item,userList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        initList();
    }
}
