package apshirokov.cs.hse.iqueue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.SupportMapFragment;

public class ChooseBranchFragment extends Fragment {

    private List<BranchListElement> elements = new ArrayList();
    ListView elementsList;

    private MapFragmentView mapFrafmentView;
    // map embedded in the map fragment
    private Map map = null;
    // map fragment embedded in this activity
    private SupportMapFragment mapFragment = null;

    public ChooseBranchFragment() { }

    public static ChooseBranchFragment newInstance() {
        return new ChooseBranchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_choose_branch, container, false);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        elementsList =  view.findViewById(R.id.branchElementsList);
        // создаем адаптер
        BranchListElementAdapter branchAdapter = new BranchListElementAdapter(view.getContext(),
                R.layout.form_branch_list_element, elements);
        // устанавливаем адаптер
        elementsList.setAdapter(branchAdapter);

        // Карта

        // Search for the map fragment to finish setup by calling init().


        mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.mapfragment);
        mapFrafmentView = new MapFragmentView(mapFragment, MainViewer.singleMainViewr());

        return view;
    }

    private void setInitialData(){
        elements.add(new BranchListElement ("420 Something ST", "10 min"));
        elements.add(new BranchListElement ("2311 North Robles Aven...", "17 min"));
        elements.add(new BranchListElement ("44 Cedar Avenue", "38 min"));
        elements.add(new BranchListElement ("319 Paper St", "1h 23min"));
        elements.add(new BranchListElement ("420 Something ST", "1h 58min"));
        elements.add(new BranchListElement ("44 Cedar Avenue", "2h 3min"));
    }
}
