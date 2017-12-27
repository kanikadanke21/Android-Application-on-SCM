package com.example.PetrolFinder;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
public class GooglePlacesReadTask extends AsyncTask<Object, Integer, String> {
String googlePlacesData = null;
GoogleMap googleMap;
Activity activity;
public GooglePlacesReadTask(Activity activity) {
// TODO Auto-generated constructor stub
this.activity = activity;
}
@Override
protected String doInBackground(Object... inputObj) {
try {
googleMap = (GoogleMap) inputObj[0];
String googlePlacesUrl = (String) inputObj[1];
Http http = new Http();
googlePlacesData = http.read(googlePlacesUrl);
Log.e("GooglePlacesActivity", googlePlacesData);
} catch (Exception e) {
Log.d("Google Place Read Task", e.toString());
}
return googlePlacesData;
}
@Override
protected void onPostExecute(String result) {
PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask(activity);
Object[] toPass = new Object[2];
toPass[0] = googleMap;
toPass[1] = result;
placesDisplayTask.execute(toPass);
}
}
