package com.example.assignment.widget;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WidgetSixFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WidgetSixFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etPhoneNumber;
    public WidgetSixFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WidgetSixFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WidgetSixFragment newInstance(String param1, String param2) {
        WidgetSixFragment fragment = new WidgetSixFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout rootLayout = new RelativeLayout(requireContext());
        rootLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootLayout.setPadding(16, 16, 16, 16);

        // Title TextView
        TextView tvTitle = new TextView(requireContext());
        tvTitle.setText("Enter Phone Number");
        tvTitle.setTextSize(24);
        tvTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        tvTitle.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        rootLayout.addView(tvTitle, titleParams);

        // EditText for phone number and DEL button in the first row
        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editTextParams.addRule(RelativeLayout.BELOW, tvTitle.getId());
        editTextParams.setMargins(0, 32, 0, 16);

        etPhoneNumber = new EditText(requireContext());
        etPhoneNumber.setLayoutParams(editTextParams);
        etPhoneNumber.setHint("Enter Phone Number");
        etPhoneNumber.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
        rootLayout.addView(etPhoneNumber);

        RelativeLayout.LayoutParams delButtonParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        delButtonParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        delButtonParams.addRule(RelativeLayout.ALIGN_BASELINE, etPhoneNumber.getId());

        Button btnDelete = new Button(requireContext());
        btnDelete.setLayoutParams(delButtonParams);
        btnDelete.setText("DEL");
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = etPhoneNumber.getText().toString();
                if (!currentText.isEmpty()) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    etPhoneNumber.setText(newText);
                    etPhoneNumber.setSelection(newText.length()); // Move cursor to end
                }
            }
        });
        rootLayout.addView(btnDelete);

        // GridLayout for buttons
        GridLayout gridLayout = new GridLayout(requireContext());
        gridLayout.setLayoutParams(new GridLayout.LayoutParams());
        gridLayout.setRowCount(4);
        gridLayout.setColumnCount(3);
        gridLayout.setOrientation(GridLayout.HORIZONTAL);
        RelativeLayout.LayoutParams gridParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        gridParams.addRule(RelativeLayout.BELOW, etPhoneNumber.getId());
        gridParams.setMargins(0, 32, 0, 16);
        rootLayout.addView(gridLayout, gridParams);

        // Adding buttons to the GridLayout dynamically
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        for (String label : buttonLabels) {
            Button button = new Button(requireContext());
            button.setText(label);
            button.setLayoutParams(new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, 1f),
                    GridLayout.spec(GridLayout.UNDEFINED, 1f)));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedButton = (Button) v;
                    String buttonText = clickedButton.getText().toString();
                    etPhoneNumber.append(buttonText);
                }
            });
            gridLayout.addView(button);
        }

        // LinearLayout for CALL and SAVE buttons in the last row
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        RelativeLayout.LayoutParams linearParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rootLayout.addView(linearLayout, linearParams);

        Button btnCall = new Button(requireContext());
        btnCall.setText("CALL");
        btnCall.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                if (!phoneNumber.isEmpty()) {
                    Toast.makeText(requireContext(), "Calling " + phoneNumber, Toast.LENGTH_SHORT).show();
                    // Add code to initiate a phone call
                } else {
                    Toast.makeText(requireContext(), "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linearLayout.addView(btnCall);

        Button btnSave = new Button(requireContext());
        btnSave.setText("SAVE");
        btnSave.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                if (!phoneNumber.isEmpty()) {
                    Toast.makeText(requireContext(), "Saving " + phoneNumber, Toast.LENGTH_SHORT).show();
                    // Add code to save the phone number (e.g., to database)
                } else {
                    Toast.makeText(requireContext(), "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linearLayout.addView(btnSave);

        return rootLayout;

    }
}