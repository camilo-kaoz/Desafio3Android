package com.desafiolatam.desafio3android;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private TextView question, category, dificulty;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private Button button;

    public FirstFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2, String param3) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_first, container, false);

        initializeViews(view);

        question.setText(mParam1);
        category.setText(mParam2);
        dificulty.setText(mParam3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAlOtro();
            }
        });
        return view;

    }
        private void initializeViews (View view){
            question = view.findViewById(R.id.texto1);
            category = view.findViewById(R.id.texto2);
            dificulty = view.findViewById(R.id.texto3);
            button = view.findViewById(R.id.buttonFragment);
        }

        private void pasarAlOtro (){
            SecondFragment secondFragment = SecondFragment.newInstance("", "");
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.framelayout, secondFragment, "SECONDFRAGMENT")
                    .commit();

        }
    }