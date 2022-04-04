package com.neocaptainnemo.fragmentapril4th.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.neocaptainnemo.fragmentapril4th.R;
import com.neocaptainnemo.fragmentapril4th.domain.City;

public class CityDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_CITY = "EXTRA_CITY";

    public static void show(Context context, City city) {
        Intent intent = new Intent(context, CityDetailsActivity.class);
        intent.putExtra(EXTRA_CITY, city);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        if (savedInstanceState == null) {

            City city = getIntent().getParcelableExtra(EXTRA_CITY);

            CityDetailsFragment cityDetailsFragment = CityDetailsFragment.newInstance(city);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, cityDetailsFragment)
                    .commit();
        }
    }
}