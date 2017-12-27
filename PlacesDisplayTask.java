package com.example.PetrolFinder;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
public class PlacesDisplayTask extends AsyncTask<Object, Integer, List<HashMap<String, String>>> {
JSONObject googlePlacesJson;
GoogleMap googleMap;
Activity activity;
public PlacesDisplayTask(Activity activity) {
// TODO Auto-generated constructor stub
this.activity = activity;
}
@Override
protected List<HashMap<String, String>> doInBackground(Object... inputObj) {

List<HashMap<String, String>> googlePlacesList = null;
Places placeJsonParser = new Places();
try {
googleMap = (GoogleMap) inputObj[0];
googlePlacesJson = new JSONObject((String) inputObj[1]);
googlePlacesList = placeJsonParser.parse(googlePlacesJson);
Log.e("GooglePlacesActivity", googlePlacesList.size() + " ");
} catch (Exception e) {
Log.d("Exception", e.toString());
}
return googlePlacesList;
}
@Override
protected void onPostExecute(List<HashMap<String, String>> list) {
googleMap.clear();
for (int i = 0; i < list.size(); i++) {
MarkerOptions markerOptions = new MarkerOptions();
HashMap<String, String> googlePlace = list.get(i);
double lat = Double.parseDouble(googlePlace.get("lat"));
double lng = Double.parseDouble(googlePlace.get("lng"));
final String placeName = googlePlace.get("place_name");
final String vicinity = googlePlace.get("vicinity");
LatLng latLng = new LatLng(lat, lng);
markerOptions.position(latLng);
markerOptions.title(placeName + " : " + vicinity);
googleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
@Override
public void onInfoWindowClick(Marker arg0) {
// TODO Auto-generated method stub
Intent intent = new Intent(activity, Token.class);
intent.putExtra("data","         "+arg0.getTitle() );
activity.startActivity(intent);
}
});
googleMap.addMarker(markerOptions);
}
}
}
