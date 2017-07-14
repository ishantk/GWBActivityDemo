package com.auribises.gwbactivitydemo;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment implements View.OnClickListener{


    //@InjectView(R.id.button12)
    Button btnSubmit;

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_upper, container, false);

        //ButterKnife.inject(view);

        context = getContext();

        btnSubmit = (Button)view.findViewById(R.id.button12);
        btnSubmit.setOnClickListener(this);

        return view;
    }

    void showNotification(){
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(getActivity(),"You Clicked Button",Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(),"You Clicked Button",Toast.LENGTH_LONG).show();
    }
}
