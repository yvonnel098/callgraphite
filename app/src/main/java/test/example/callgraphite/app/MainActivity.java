package test.example.callgraphite.app;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import org.sil.palaso.Graphite;

import java.io.UnsupportedEncodingException;


public class MainActivity extends Activity {

    static final String TAG = "CallGraphite";
    Typeface mtfp;
    Typeface mtfs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView tv1;
        TextView tv2;
        WebView wv;

        Log.v(TAG, "about to load");
        Graphite.loadGraphite();
        Log.v(TAG, "graphite loaded");
        mtfp = (Typeface)Graphite.addFontResource(getAssets(), "Padauk.ttf", "padauk", 0, "shn", "wtri=1; ulon=1");
        mtfs = (Typeface)Graphite.addFontResource(getAssets(), "Scheherazade-R.ttf", "scher", 1, "", "");
        Log.v(TAG, "after addFontResource");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String s="\u00a5123";
        String s = "မိူဝ်ႈ/ၵေႃႇၸႃႉ/ႁူဝ်ပိုင်း/ၼၼ်ႉ၊/မီး/ၼုၵ်ႈၵပၢတ်ႈ/ၸဝ်ႈ/ဢေႃႈ။ ၼုၵ်ႈၵပၢတ်ႈၸဝ်ႈ/ၼၼ်ႉ၊/မီး/လူၺ်ႈ/ၵၼ်/တင်း/ၽြႃးပဵၼ်ၸဝ်ႈ/ လႄႈ/ၼုၵ်ႈၵပၢတ်ႈ/ၸဝ်ႈ/ၼၼ်ႉ၊/ပဵၼ်/ၽြႃးပဵၼ်ၸဝ်ႈ/ဢေႃႈ။- မၼ်းၸဝ်ႈ/ၼၼ်ႉ၊/မီး/ယူႇ/ၸဵမ်/မိူဝ်ႈ/ႁူဝ်/ပိုင်း/ႁူမ်ႈ/လူၺ်ႈ/ၵၼ်/တင်း/ ၽြႃးပဵၼ်ၸဝ်ႈ/လႄႈ၊- ".replace("/", "\u200B");
        String sa = "لمّا كان الاعتراف بالكرامة المتأصلة في جميع أعضاء الأسرة (البشرية) وبحقوقهم المتساوية\u221A الثابتة هو أساس الحرية والعدل \u06F1\u06F2\u06F3 والسلام في العالم.";
        String w = "\uFEFF<html><head/><body><p style=\"font-family: padauk\">" + s + "</p><p style=\"font-family: scher\">" + sa + "</p></body></html>";                   // <3>

        wv = (WebView) findViewById(R.id.wv);
        try {
            wv.loadData(Base64.encodeToString(w.getBytes("UTF-8"), 0), "text/html", "base64");
        }
        catch (UnsupportedEncodingException e) {
            Log.e("Grandroid", "Can't handle UTF-8, java is so broken");
        }
        //String s="\u1000\u1039\u1000";
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(s);
        tv1.setTypeface(mtfp, 0);
        tv1.setTextSize((float)20.0);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText(sa);
        tv2.setTypeface(mtfs, 0);
        tv2.setTextSize((float)20.0);
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
