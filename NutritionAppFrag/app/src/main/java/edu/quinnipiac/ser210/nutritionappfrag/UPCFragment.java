package edu.quinnipiac.ser210.nutritionappfrag;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UPCFragment extends Fragment {

    public UPCFragment() {
        // Required empty public constructor
    }


    TextView title;
    EditText code;
    Button cont;
    ImageView pic;
    TextView hint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upc, container, false);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        View view = getView();
        if(view != null)
        {
            title = (TextView)view.findViewById(R.id.textView);
            code = (EditText)view.findViewById(R.id.editText);
            pic = (ImageView)view.findViewById(R.id.imageView);
            hint = (TextView)view.findViewById(R.id.hint);
            cont = (Button)view.findViewById(R.id.continueButton);
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            cont.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent();
                    String foodText = code.getText().toString();
                    intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("name", foodText);
                    startActivity(intent);
                }
            });
        }
        else
        {
            Log.d("UPC frag error", "view is null");
        }
    }

}
