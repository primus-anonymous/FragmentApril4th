package com.neocaptainnemo.fragmentapril4th.ui.fm;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.neocaptainnemo.fragmentapril4th.R;

public class FragmentOne extends Fragment {

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(requireContext(), "created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(requireContext(), "view created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(requireContext(), "started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        Toast.makeText(requireContext(), "stopped", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(requireContext(), "view destroyed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(requireContext(), "destroyed", Toast.LENGTH_SHORT).show();

    }

    public void sayHello() {

        Toast.makeText(requireContext(), "Hello!", Toast.LENGTH_SHORT).show();
    }
}
