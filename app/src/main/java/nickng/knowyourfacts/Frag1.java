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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnChange;
    TextView tv;
    LinearLayout l;
    int color;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        int saveColor = prefs.getInt("color1", color);
        l.setBackgroundColor(saveColor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_1, container, false);

        btnChange = (Button)view.findViewById(R.id.btnChange);
        tv = (TextView)view.findViewById(R.id.textView);
        l = (LinearLayout)view.findViewById(R.id.layout);

        tv.setText("The word \"queue\" is the only word in the English language that is still pronounced the same way when the last four letters are removed.\n\nBeetles taste like apples, wasps like pine nuts, and worms  like fried bacon.\n\nOf all the words in the English language, the word 'set' has the most definitions!");
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                color = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));
                l.setBackgroundColor(color);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("color1", color);
                prefEdit.commit();
            }
        });

        return view;
    }

}
