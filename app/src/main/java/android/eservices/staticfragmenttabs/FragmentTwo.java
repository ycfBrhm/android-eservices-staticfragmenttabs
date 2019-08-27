package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "REMOVE TO COUNTER";
    private View rootView;
    private CounterInterface counterInterface;

    public FragmentTwo() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_two, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupCounterButton();
    }

    private void setupCounterButton(){
        Button decrementButton = rootView.findViewById(R.id.button_decrement);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counterInterface != null){
                    counterInterface.decrementCounter();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CounterInterface){
            this.counterInterface = (CounterInterface) context;
        }
    }
}
