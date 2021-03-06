package com.neocaptainnemo.fragmentapril4th.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.neocaptainnemo.fragmentapril4th.R;
import com.neocaptainnemo.fragmentapril4th.domain.City;
import com.neocaptainnemo.fragmentapril4th.domain.InMemoryCitiesRepository;

import java.util.List;

public class CitiesListFragment extends Fragment {

    public static final String CITIES_CLICKED_KEY = "CITIES_CLICKED_KEY";
    public static final String SELECTED_CITY = "SELECTED_CITY";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (requireActivity() instanceof ToolbarHolder) {
            ((ToolbarHolder)requireActivity()).setToolbar(toolbar);
        }

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_action) {
                    Toast.makeText(requireContext(), "action", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });

//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        List<City> cities = InMemoryCitiesRepository.getInstance(requireContext()).getAll();

        LinearLayout container = view.findViewById(R.id.container);

        for (City city : cities) {

            View itemView = getLayoutInflater().inflate(R.layout.item_city, container, false);

            itemView.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, CityDetailsFragment.newInstance(city))
                            .addToBackStack("details")
                            .commit();
                }
            });

            ImageView icon = itemView.findViewById(R.id.icon);

            icon.setImageResource(city.getIcon());

            TextView title = itemView.findViewById(R.id.title);

            title.setText(city.getName());

            container.addView(itemView);
        }
    }
}
