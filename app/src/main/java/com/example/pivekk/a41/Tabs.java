package com.example.pivekk.a41;

import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Tabs extends AppCompatActivity  {


    FragmentTransaction transakcja;
    Fragment12 f12;
    Fragment13 f13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);



        f12 = new Fragment12();
        f13 = new Fragment13();


        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kont, f12);
        transakcja.detach(f12);
        transakcja.add(R.id.kont, f13);
        transakcja.detach(f13);
        transakcja.commit();

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }
        if (bar != null) {
            bar.setDisplayShowTitleEnabled(true);
        }

        ActionBar.Tab tab1 = bar.newTab().setText("Fragment1");
        ActionBar.Tab tab2 = bar.newTab().setText("Fragment2");

        tab1.setTabListener(new MyTabsListener(f12));
        tab2.setTabListener(new MyTabsListener(f13));

        bar.addTab(tab1);
        bar.addTab(tab2);






    }




    class MyTabsListener implements ActionBar.TabListener{
        public Fragment fragment;

        public MyTabsListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.kont, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }
    }

}




