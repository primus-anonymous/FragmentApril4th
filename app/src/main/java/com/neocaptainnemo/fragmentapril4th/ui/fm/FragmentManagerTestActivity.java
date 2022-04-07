package com.neocaptainnemo.fragmentapril4th.ui.fm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.neocaptainnemo.fragmentapril4th.R;

public class FragmentManagerTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager_test);

        findViewById(R.id.r1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new FragmentOne())
                        .commit();
            }
        });

        findViewById(R.id.r2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new FragmentTwo())
                        .addToBackStack("r2")
                        .commit();

            }
        });


        findViewById(R.id.r3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new FragmentThree())
                        .addToBackStack("r3")
                        .commit();

            }
        });

        //add

        findViewById(R.id.a1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.container, new FragmentOne(), "FragmentOne")
//                        .addToBackStack("a1")
                                .commit();

                        recreate();

                    }
                }, 2000L);


//                Fragment fragment = getSupportFragmentManager().findFragmentByTag("FragmentOne");
//
//                ((FragmentOne) fragment).sayHello();
            }
        });

        findViewById(R.id.a2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, new FragmentTwo())
                        .addToBackStack("a2")
                        .commit();

            }
        });


        findViewById(R.id.a3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, new FragmentThree())
                        .addToBackStack("a3")
                        .commit();

            }
        });

        findViewById(R.id.remove1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = getSupportFragmentManager().findFragmentByTag("FragmentOne");

                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(fragment)
                        .commit();
            }
        });

        findViewById(R.id.show1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = getSupportFragmentManager().findFragmentByTag("FragmentOne");

                getSupportFragmentManager()
                        .beginTransaction()
                        .show(fragment)
                        .commit();

            }
        });

        findViewById(R.id.hide1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("FragmentOne");

                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(fragment)
                        .commit();
            }
        });

        findViewById(R.id.pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().popBackStack("a1", 0);
            }
        });

    }
}