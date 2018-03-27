package com.example.pafio.ex6v2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pafio on 27-Mar-18.
 */

public class ColorFragment extends Fragment {

    private Integer colorVal;

    public ColorFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            colorVal = getArguments().getInt("colorVal");
        }
    }

    public static ColorFragment newInstance(Integer colorVal) {
        ColorFragment colorFragment = new ColorFragment();

        Bundle args = new Bundle();
        args.putInt("colorVal", colorVal);
        colorFragment.setArguments(args);

        return colorFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.color_fragment, container, false);
        layout.setBackgroundColor(colorVal);

        TextView textView = layout.findViewById(R.id.textView);
        textView.setText( String.format("#%06X", (0xFFFFFF & colorVal)) );

        return layout;
    }
}
