package edu.quinnipiac.ser210.nutritionapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class UPC extends Fragment implements View.OnClickListener{

    private Listener listener;

    @Override
    public void onClick(View v) {
        listener.onContinueResult(v);
    }

    static interface Listener{
        void onContinueResult(View v);
    }

    public UPC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_upc, container, false);

        Button button = (Button) layout.findViewById(R.id.button);
        button.setOnClickListener(this);
        return layout;
    }

    //Attaches the listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }
}
