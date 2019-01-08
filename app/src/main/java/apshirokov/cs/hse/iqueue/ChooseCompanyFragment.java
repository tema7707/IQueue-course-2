package apshirokov.cs.hse.iqueue;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ChooseCompanyFragment extends Fragment {

    private List<ChooseCompany> companies = new ArrayList();
    ListView companiesList;

    public ChooseCompanyFragment() { }

    public static ChooseCompanyFragment newInstance() {
        return new ChooseCompanyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_choose_company, container, false);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        companiesList =  view.findViewById(R.id.chooseCompanyList);
        // создаем адаптер
        ChooseCompanyAdapter stateAdapter = new ChooseCompanyAdapter(view.getContext(), R.layout.form_company, companies);
        // устанавливаем адаптер
        companiesList.setAdapter(stateAdapter);

        return view;
    }

    private void setInitialData(){

        try {
            companies.add(new ChooseCompany ("Sberbank", new URL("http://example.com/"),
                    "Hookah", new URL("http://example.com/")));
            companies.add(new ChooseCompany ("Post", new URL("http://example.com/"),
                    "Cafe", new URL("http://example.com/")));
            companies.add(new ChooseCompany ("Pizza", new URL("http://example.com/"),
                    "Tinkoff", new URL("http://example.com/")));
            companies.add(new ChooseCompany ("Pizza", new URL("http://example.com/")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
