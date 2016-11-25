package com.example.fixtergeek.myapplication;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by fixtergeek on 25/11/16.
 */

public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener{

    private static  int seekvalue = 10;
    private  static EditText editText;

    ToolbarListener activityCallback;

    public interface ToolbarListener{
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            activityCallback = (ToolbarListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Se debe implementar toolbatLisener");
        }
    }//onAttach

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflar layout
        View view = inflater.inflate(R.layout.layout, container, false);

        //implementamos el seebar
        editText = (EditText) view.findViewById(R.id.edittext);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        final Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonClicked(v);
            }
        });

        return view;
    }//metodo oncreateview

    public void buttonClicked(View view){
        activityCallback.onButtonClick(seekvalue,editText.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0){

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0){

    }
}
