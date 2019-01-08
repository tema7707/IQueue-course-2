package apshirokov.cs.hse.iqueue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainViewer extends AppCompatActivity {

    TextView title;
    private static MainViewer singleMainViewer;

    public static MainViewer singleMainViewr(){
        return singleMainViewer;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.my_notes:
                    loadFragment(MyNotesFragment.newInstance());
                    title.setText("My Notes");
                    return true;
                case R.id.add_new:
                    loadFragment(ChooseCompanyFragment.newInstance());
                    title.setText("Add New Note");
                    return true;
                case R.id.companies:
                    loadFragment(MyNotesFragment.newInstance());
                    return true;
                case R.id.settings:
                    loadFragment(MyNotesFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewer);

        singleMainViewer = this;
        title = findViewById(R.id.title);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(MyNotesFragment.newInstance());
    }

}
