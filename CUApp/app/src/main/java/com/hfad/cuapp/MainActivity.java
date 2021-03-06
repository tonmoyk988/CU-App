package com.hfad.cuapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    //RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<rept_home_page_activity_list> activity_lists;
    private ImageView imageView;


    public MainActivity(){
        activity_lists = new ArrayList<>();//int r= R.drawable.update;
        rept_home_page_activity_list item1 = new rept_home_page_activity_list("Class Updates",R.drawable.update);
        activity_lists.add(item1);
        rept_home_page_activity_list item2  = new rept_home_page_activity_list("Class Schedule",R.drawable.schedule);
        activity_lists.add(item2);
        rept_home_page_activity_list item3  = new rept_home_page_activity_list("Notice Board",R.drawable.notice_board);
        activity_lists.add(item3);
        rept_home_page_activity_list item4  = new rept_home_page_activity_list("Community",R.drawable.community);
        activity_lists.add(item4);
        rept_home_page_activity_list item5  = new rept_home_page_activity_list("Slides and Books",R.drawable.share);
        activity_lists.add(item5);
        rept_home_page_activity_list item6  = new rept_home_page_activity_list("Activities",R.drawable.activity);
        activity_lists.add(item6);
        rept_home_page_activity_list item7  = new rept_home_page_activity_list("Dept. info",R.drawable.info);
        activity_lists.add(item7);
        rept_home_page_activity_list item8  = new rept_home_page_activity_list("Gallery",R.drawable.gallery);
        activity_lists.add(item8);
    }

    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dept. Of CSE");


        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle =new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_opem,R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.homepage_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myAdapter(activity_lists,this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.dept_home_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.go_to_campus:
                Intent intent = new Intent(this, campus_home.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
