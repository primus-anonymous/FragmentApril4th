package com.neocaptainnemo.fragmentapril4th.domain;

import android.content.Context;

import com.neocaptainnemo.fragmentapril4th.R;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCitiesRepository implements CitiesRepository {

    private static CitiesRepository INSTANCE;

    public static CitiesRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryCitiesRepository(context);
        }
        return INSTANCE;
    }

    private Context context;

    private InMemoryCitiesRepository(Context context) {
        this.context = context;
    }

    @Override
    public List<City> getAll() {
        ArrayList<City> result = new ArrayList<>();

        result.add(new City(context.getString(R.string.msk), R.drawable.msc));
        result.add(new City(context.getString(R.string.ebrg), R.drawable.ebrg));
        result.add(new City(context.getString(R.string.nsk), R.drawable.nsk));
        result.add(new City(context.getString(R.string.sam), R.drawable.sam));
        result.add(new City(context.getString(R.string.spb), R.drawable.spb));

        return result;
    }

    @Override
    public void add(City city) {

    }
}
