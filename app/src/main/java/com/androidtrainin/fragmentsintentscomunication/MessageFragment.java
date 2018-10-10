package com.androidtrainin.fragmentsintentscomunication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment
        implements View.OnClickListener {

    MessageFragment.OnSendMessageListener mCallback;
    TextView editText;
    TextView txtMessage;
    TextView txtTitle;

    // Container Activity must implement this interface
    public interface OnSendMessageListener {
        void onSendMessage(String message, MessageFragment sender);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        Button btnSubmit = view.findViewById(R.id.button);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtMessage = view.findViewById(R.id.txtMessage);
        editText = view.findViewById(R.id.editText);

        btnSubmit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (MessageFragment.OnSendMessageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onClick(View v) {
        String myMessage = editText.getText().toString();
        mCallback.onSendMessage(myMessage, this);
        editText.setText("");
    }

    public void setMessage(String message){
        txtMessage.setText(message);
    }

    public void setTitle(String title){
        txtTitle.setText(title);
    }
}
