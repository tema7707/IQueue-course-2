package apshirokov.cs.hse.iqueue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

import java.util.ArrayList;
import java.util.List;

public class ChooseBranchFragment extends Fragment {

    private List<BranchListElement> elements = new ArrayList();
    ListView elementsList;
    // MapBox
    private MapView mapView;

    public ChooseBranchFragment() { }

    public static ChooseBranchFragment newInstance() {
        return new ChooseBranchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Mapbox.getInstance(getContext(), getString(R.string.map_box_token));
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
        mapView = view.findViewById(R.id.mapChooseBranch);
        mapView.onCreate(savedInstanceState);

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
