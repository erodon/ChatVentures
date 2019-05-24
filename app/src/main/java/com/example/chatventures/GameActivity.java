package com.example.chatventures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class GameActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private MessageAdapter messageAdapter;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        messageAdapter = new MessageAdapter(getApplicationContext());
        listView = (ListView) findViewById(R.id.messages_view);
        listView.setAdapter(messageAdapter);

        editText = (EditText) findViewById(R.id.editText);
        game = new Game(messageAdapter);
        game.kerdestFeltesz();
    }

    public void sendMessage(View view) {
        String str = editText.getText().toString();


        if(str.length() > 0) {
            messageAdapter.add(new Message(str, true));
            game.valaszEllenorzes(str);
            editText.getText().clear();
        }
    }




}
