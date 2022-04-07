package com.neocaptainnemo.fragmentapril4th.ui.fm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.neocaptainnemo.fragmentapril4th.R;

public class FragmentRoot extends Fragment {

    public FragmentRoot() {
        super(R.layout.fragment_root);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new FragmentTwo())
                .commit();
    }
}
