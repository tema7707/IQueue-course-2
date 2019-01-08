package apshirokov.cs.hse.iqueue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyNotesFragment extends Fragment {

    private List<Note> notes = new ArrayList();
    ListView notesList;
    public MyNotesFragment() { }

    public static MyNotesFragment newInstance() {
        return new MyNotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_notes, container, false);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        notesList = view.findViewById(R.id.notesList);
        // создаем адаптер
        NoteAdapter noteAdapter = new NoteAdapter(view.getContext(), R.layout.form_note, notes);
        // устанавливаем адаптер
        notesList.setAdapter(noteAdapter);
        return view;
    }

    private void setInitialData(){
        //TODO:: переделать для сервера
        try {
            notes.add(new Note("Sberbank", "420 Paper St", new Date(), new URL("http://example.com/")));
            notes.add(new Note("Rosbank", "3th Microraion d.48-a", new Date(), new URL("http://example.com/")));
            notes.add(new Note("Hospital", "Microraion Zelenyi d.15", new Date(), new URL("http://example.com/")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}