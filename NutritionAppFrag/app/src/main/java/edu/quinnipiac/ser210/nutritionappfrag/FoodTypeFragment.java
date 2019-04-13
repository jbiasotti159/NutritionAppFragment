package edu.quinnipiac.ser210.nutritionappfrag;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
public class FoodTypeFragment extends Fragment {


    public FoodTypeFragment() {
        // Required empty public constructor
    }

    TextView text;
    TextView opt;
    EditText editText;
    Button button;
    ImageView pic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_type, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        text = (TextView)view.findViewById(R.id.textView);
        opt = (TextView)view.findViewById(R.id.option);
        editText = (EditText)view.findViewById(R.id.editText);
        button = (Button)view.findViewById(R.id.button);
        pic = (ImageView)view.findViewById(R.id.image);

      /*  button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                String foodText = editText.getText().toString();
                intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("name", foodText);
                startActivity(intent);
            }
        });
*/
        return view;
    }

}
