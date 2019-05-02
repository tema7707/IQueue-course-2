package apshirokov.cs.hse.iqueue;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        // Кнопка
        Button getIn = view.findViewById(R.id.getIn);
        getIn.setOnClickListener(v -> {
            Date recordingtime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd+hh:mm:ss");
            new Adder().execute(LoginActivity.getLogin(), MainViewer.getCompanyName(), address, formatter.format(recordingtime));
            MainViewer.singleMainViewr().goToFirstMenuItem();
        });

        return view;
    }

    class Adder extends AsyncTask<String, Integer, String> {
        private void addNote(String login, String company, String address, String time) {
            String request = null;
            try {
                request = String.format("http://192.168.43.137:8080/addnote?login=%s&company=%s&address=%s&time=%s&logo=%s",
                        login, company, address, time, URLEncoder.encode(MainViewer.getCompanyURL(), "UTF-8"));
            } catch (UnsupportedEncodingException e) { }
            String answer = new HttpClient().request(request);
//                    if (answer == "true")
//                        Toast.makeText(getContext(),
//                                "Запись создана!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected  String doInBackground(String... strings) {
            addNote(strings[0], strings[1], strings[2], strings[3]);
            return null;
        }
    }

    private void setInitialData(){


    }
}
