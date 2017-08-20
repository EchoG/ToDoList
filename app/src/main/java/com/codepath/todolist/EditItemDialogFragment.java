package com.codepath.todolist;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

/**
 * Created by chenrangong on 8/6/17.
 */

public class EditItemDialogFragment extends DialogFragment{

    public interface EditSaveListener{
        public void onEditSave(Item item, EditItemDialogFragment editItemDialogFragment);
    }

    private EditText mEditContent;
    Button saveBtw;
    public EditSaveListener editSaveListener;
    public Item item;

    public EditItemDialogFragment(){

    }

    public static EditItemDialogFragment newInstance(Item item){
        EditItemDialogFragment frag = new EditItemDialogFragment();
        frag.item = item;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_edit_item, container);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
       super.onViewCreated(view, savedInstanceState);
        mEditContent = (EditText) view.findViewById(R.id.content);
        mEditContent.setText(item.content);
        mEditContent.requestFocus();

        final Spinner prioritySpinner = (Spinner) view.findViewById(R.id.prioritySpinner);
        if(item.priority != null){
            if(item.priority.equals("High")){
                prioritySpinner.setSelection(0);
            }else if(item.priority.equals("Medium")){
                prioritySpinner.setSelection(1);
            }else if(item.priority.equals("Low")){
                prioritySpinner.setSelection(2);
            }else{
                prioritySpinner.setSelection(0);
            }
        }

        final DatePicker datePicker = (DatePicker) view.findViewById(R.id.datePicker);
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(currentYear, currentMonth, currentDay, null);

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        saveBtw = (Button) view.findViewById(R.id.saveBtn);
        saveBtw.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String content = mEditContent.getText().toString();
                item.content = content;
                item.priority  = prioritySpinner.getSelectedItem().toString();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                item.dueDate = calendar.getTime();

                editSaveListener.onEditSave(item, EditItemDialogFragment.this);
            }
        });
    }

}
