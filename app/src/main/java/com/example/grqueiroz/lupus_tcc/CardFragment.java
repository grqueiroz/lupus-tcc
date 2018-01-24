package com.example.grqueiroz.lupus_tcc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    int layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = getArguments().getInt("layout");

        // Inflate the layout for this fragment
        return inflater.inflate(layout, container, false);
    }

}
