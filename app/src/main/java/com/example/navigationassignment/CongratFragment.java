package com.example.navigationassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CongratFragment extends Fragment {

    private Button scoreBtn, retestBtn;

    public CongratFragment() {
        // Required empty public constructor
    }

   public static CongratFragment newInstance(String param1, String param2) {
        CongratFragment fragment = new CongratFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_congrat, container, false);
        scoreBtn = view.findViewById(R.id.score);
        retestBtn = view.findViewById(R.id.retest_btn);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Integer argument = CongratFragmentArgs.fromBundle(getArguments()).getArg();
        scoreBtn.setText("Score "+argument);
        retestBtn.setOnClickListener(v->{
            NavController controller = Navigation.findNavController(v);
            controller.popBackStack();
        });
    }
}