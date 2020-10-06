package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment implements View.OnClickListener {
    public static final String TAB_NAME = "SUB TO COUNTER";
    private FragmentOne.OnButtonClickedListener mCallback;

    public FragmentTwo() {
        //TODO
        // constructeur vide
    }

    public static FragmentTwo newInstance() {
        //TODO
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO
        ViewGroup fragmentOneView = (ViewGroup) inflater.inflate(R.layout.fragment_two, container, false);

        fragmentOneView.findViewById(R.id.button_decrement).setOnClickListener(this);
        return fragmentOneView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    private void createCallbackToParentActivity(Context context){
        try {

            mCallback = (FragmentOne.OnButtonClickedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity(context);
    }

    @Override
    public void onClick(View view) {
        mCallback.onCounterUpdated(false);
    }
}
