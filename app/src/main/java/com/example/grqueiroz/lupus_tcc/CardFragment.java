package com.example.grqueiroz.lupus_tcc;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    private Button button1;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layout = getArguments().getInt("layout");

        fragmentManager = getFragmentManager();

        // Inflate the layout for this fragment
        View view = inflater.inflate(layout, container, false);
        button1 = (Button) view.findViewById(R.id.subtopic1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardFragment.this.onClick(view, R.layout.card_riscos_orgaos);
            }
        });

        return view;
    }

    public void onClick(View view, int layout) {
        View fragmentContainer = getView().findViewById(R.id.fragment_container_card);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CardFragment cardFragment = new CardFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("layout", layout);

        cardFragment.setArguments(bundle);

        fragmentTransaction.addToBackStack("subcard");
        fragmentTransaction.add(R.id.fragment_container_card, cardFragment);
        fragmentTransaction.commit();

        View scrollView = getView().findViewById(R.id.card_riscos_orgaos_content);
        scrollView.setVisibility(View.GONE);

        fragmentContainer.setVisibility(View.VISIBLE);
    }

}
