package com.example.PetrolFinder;
import com.example.PetrolFinder.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class Token extends Activity {
TextView txtView;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.token);
txtView = (TextView) findViewById(R.id.textView1);
Intent intent = getIntent();
String data  = intent.getStringExtra("data");
txtView.setText("Thank you for selecting this station"+data);}}
