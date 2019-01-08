package apshirokov.cs.hse.iqueue;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ChooseCompanyAdapter extends ArrayAdapter<ChooseCompany> {

    private LayoutInflater inflater;
    private int layout;
    private List<ChooseCompany> companies;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    public ChooseCompanyAdapter(Context context, int resource, List<ChooseCompany> states) {
        super(context, resource, states);
        this.companies = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        ImageView logoView1 = view.findViewById(R.id.logoCompany1);
        ImageView logoView2 = view.findViewById(R.id.logoCompany2);
        TextView nameView1 = view.findViewById(R.id.nameCompany1);
        TextView nameView2 = view.findViewById(R.id.nameCompany2);

        final ChooseCompany company = companies.get(position);
        // TODO:: picasso
        logoView1.setImageResource(R.drawable.sberbank);
        if (!company.getCompanyName2().equals(""))
            logoView2.setImageResource(R.drawable.sberbank);

        nameView1.setText(company.getCompanyName1());
        nameView2.setText(company.getCompanyName2());

        // Set Listeners
        View.OnClickListener clickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    LinearLayout buttonsLayout = v.findViewById(R.id.companyChoose1);
                    // Анимация нажатия
                    Animation animationB = AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_press);
                    animationB.setInterpolator(INTERPOLATOR);
                    animationB.setAnimationListener(new AnimListener(company, 1));
                    buttonsLayout.startAnimation(animationB);
            }
        };
        view.findViewById(R.id.companyChoose1).setOnClickListener(clickListener1);

        // Set Listeners
        View.OnClickListener clickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout buttonsLayout = v.findViewById(R.id.companyChoose2);
                // Анимация нажатия
                Animation animationB = AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_press);
                animationB.setInterpolator(INTERPOLATOR);
                animationB.setAnimationListener(new AnimListener(company, 2));
                buttonsLayout.startAnimation(animationB);
            }
        };
        view.findViewById(R.id.companyChoose2).setOnClickListener(clickListener2);

        return view;
    }

    private class AnimListener implements Animation.AnimationListener {

        private ChooseCompany company;
        private int number;
        public AnimListener(ChooseCompany company, int number){
            this.company = company;
            this.number = number;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            MainViewer.singleMainViewr().title.setText(number == 1 ? company.getCompanyName1() :
                    company.getCompanyName2());
            MainViewer.singleMainViewr().loadFragment(ChooseBranchFragment.newInstance());
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) { }
    }
}