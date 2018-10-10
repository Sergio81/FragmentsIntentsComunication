package com.androidtrainin.fragmentsintentscomunication;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements MessageFragment.OnSendMessageListener {

    private MessageFragment topFragment;
    private MessageFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        topFragment = (MessageFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmentTop);

        topFragment.setTitle("Top Fragment");

        bottomFragment = (MessageFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmentBottom);

        bottomFragment.setTitle("Bottom Fragment");
    }

    @Override
    public void onSendMessage(String message, MessageFragment sender) {
        hideSoftKeyboard();

        if(sender.getId() == topFragment.getId())
            bottomFragment.setMessage(message);
        else
            topFragment.setMessage(message);
    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
