package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment implements View.OnClickListener {

    public static final String TAB_NAME = "ADD TO COUNTER";
    private OnButtonClickedListener mCallback;

    public FragmentOne() {
        //TODO
        // constructeur vide
    }

    public static FragmentOne newInstance() {
        //TODO
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO
        ViewGroup fragmentOneView = (ViewGroup) inflater.inflate(R.layout.fragment_one, container, false);

        fragmentOneView.findViewById(R.id.button_increment).setOnClickListener(this);
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

    public interface OnButtonClickedListener {
        public void onCounterUpdated(boolean isIncremented);
    }


    private void createCallbackToParentActivity(Context context){
        try {

            mCallback = (OnButtonClickedListener) context;
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
        mCallback.onCounterUpdated(true);
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
