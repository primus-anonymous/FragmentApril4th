package com.neocaptainnemo.fragmentapril4th.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.neocaptainnemo.fragmentapril4th.R;
import com.neocaptainnemo.fragmentapril4th.domain.City;

public class CityDetailsFragment extends Fragment {

    private static final String ARG_CITY = "ARG_CITY";
    private TextView title;
    private ImageView icon;

    public CityDetailsFragment() {
        super(R.layout.fragment_city_details);
    }

    public static CityDetailsFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);

        CityDetailsFragment fragment = new CityDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        icon = view.findViewById(R.id.icon);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .popBackStack();
            }
        });

        getParentFragmentManager()
                .setFragmentResultListener(CitiesListFragment.CITIES_CLICKED_KEY, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        City city = result.getParcelable(CitiesListFragment.SELECTED_CITY);

                        showCity(city);
                    }
                });

        if (getArguments() != null && getArguments().containsKey(ARG_CITY)) {
            City city = getArguments().getParcelable(ARG_CITY);

            showCity(city);
        }
    }

    private void showCity(City city) {
        title.setText(city.getName());
        icon.setImageResource(city.getIcon());
    }
}
