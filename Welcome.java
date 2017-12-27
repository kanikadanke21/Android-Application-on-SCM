package com.example.PetrolFinder;
import com.example.PetrolFinder.R;
import android.net.Uri;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Welcome extends Activity {
Button button,btn;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.welcome);
addListenerOnButton();
}
public void addListenerOnButton() {
final Context context = this;
button = (Button) findViewById(R.id.button1);
btn=(Button)findViewById(R.id.button2);
button.setOnClickListener(new OnClickListener() {
public void onClick(View arg0) {
Intent intent = new Intent(context,GooglePlacesActivity.class);
startActivity(intent);
}
});
btn.setOnClickListener(new OnClickListener()  {
public void onClick(View arg0){
Uri uri = Uri.parse("http://www.petrolprices.com/fuel-tax-calculator.html/");
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);
}
});
}
}
