package com.example.fixtergeek.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by fixtergeek on 25/11/16.
 */

    public class TextFragment extends Fragment {

        private static TextView textView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.text_fragment, container,false);

            //encontramos e texto
            textView = (TextView) view.findViewById(R.id.textView);
            return view;
        }

    public void changeTextProperties(int fontsize, String text){
        textView.setTextSize(fontsize);
        textView.setText(text);
    }
    }
