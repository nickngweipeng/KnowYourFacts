package nickng.knowyourfacts;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    Button btnChange;
    TextView tv;
    LinearLayout l;
    ImageView iv1;
    int color;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        int saveColor = prefs.getInt("color2", color);
        l.setBackgroundColor(saveColor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_2, container, false);

        btnChange = (Button)view.findViewById(R.id.btnChange);
        tv = (TextView)view.findViewById(R.id.textView);
        l = (LinearLayout)view.findViewById(R.id.layout);
        iv1 = (ImageView)view.findViewById(R.id.iv);

        tv.setText("What is called a \"French kiss\" in the English speaking world is known as an \"English kiss\" in France.\n\n\"Almost\" is the longest word in the English language with all the letters in alphabetical order.\n\n\"Rhythm\" is the longest English word without a vowel.");

        String image = "http://68.media.tumblr.com/b3118ebae18e7f442b72fc903c68867b/tumblr_opyi4meN2j1roqv59o1_500.png";
        Picasso.with(getContext()).load(image).into(iv1);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int color = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));
                l.setBackgroundColor(color);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("color2", color);
                prefEdit.commit();
            }
        });

        return view;
    }

}
