package apshirokov.cs.hse.iqueue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BranchFragment extends Fragment {

    protected String address, time;

    public BranchFragment() { }

    public static BranchFragment newInstance(String address, String time) {
        BranchFragment fragment = new BranchFragment();
        fragment.address = address;
        fragment.time = time;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_branch, container, false);

        // начальная инициализация списка
        setInitialData();

        ((TextView) view.findViewById(R.id.branchFragmentAddress)).setText(address);
        ((TextView) view.findViewById(R.id.branchFragmentTime)).setText(time);

        return view;
    }

    private void setInitialData(){


    }
}
