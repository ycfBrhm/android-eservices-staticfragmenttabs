package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment {

    public static final String TAB_NAME = "ADD TO COUNTER";
    private CounterInterface counterInterface;
    private View rootView;

    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setupCounterButton();
    }

    private void setupCounterButton(){
        Button incrementButton = rootView.findViewById(R.id.button_increment);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counterInterface != null){
                    counterInterface.incrementCounter();
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
