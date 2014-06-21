package test.example.callgraphite.app;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import org.sil.palaso.Graphite;


public class MainActivity extends Activity {

    static final String TAG = "CallGraphite";
    Typeface mtfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.v(TAG, "about to load");
        Graphite.loadGraphite();
        Log.v(TAG, "graphite loaded");
        mtfp = (Typeface)Graphite.addFontResource(getAssets(), "Padauk.ttf", "padauk", 0, "shn", "wtri=1; ulon=1");
        Log.v(TAG, "after addFontResource");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
