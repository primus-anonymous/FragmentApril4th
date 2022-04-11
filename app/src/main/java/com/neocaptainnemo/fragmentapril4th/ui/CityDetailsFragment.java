package com.neocaptainnemo.fragmentapril4th.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
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

    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setHasOptionsMenu(true);
//    }
//
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        icon = view.findViewById(R.id.icon);


        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (requireActivity() instanceof ToolbarHolder) {
            ((ToolbarHolder)requireActivity()).setToolbar(toolbar);
        }

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_info:
                        Toast.makeText(requireContext(), "info", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_share:
                        Toast.makeText(requireContext(), "share", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), view);

                requireActivity().getMenuInflater().inflate(R.menu.menu_pop_up, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_search:
                                Toast.makeText(requireContext(), "search", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_copy:
                                Toast.makeText(requireContext(), "copy", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });

//
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager()
//                        .popBackStack();
//            }
//        });

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

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_city_details, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_action) {
//            Toast.makeText(requireContext(), "action", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void showCity(City city) {
        title.setText(city.getName());
        icon.setImageResource(city.getIcon());
    }
}
