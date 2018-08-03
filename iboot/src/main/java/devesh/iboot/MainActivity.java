package devesh.iboot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;


public class MainActivity extends Activity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        MobileAds.initialize(this,
                getString(R.string.AdMob_AppID));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.Ad_Ad_ID));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                finish();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                finish();
            }
        });


        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("su"); // or whatever command.
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: your Phone is Not Rooted", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Root your Phone to Use this App", Toast.LENGTH_SHORT).show();

        }
    }

    public void restart(View v) { // Restart Phone
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("su adb reboot");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: your Phone is Not Rooted", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Root your Phone to Use this App", Toast.LENGTH_SHORT).show();

        }

    }

    public void bl(View v) { // Bootloader
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("su adb reboot bootloader");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: your Phone is Not Rooted", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Root your Phone to Use this App", Toast.LENGTH_SHORT).show();

        }

    }

    public void recovery(View v) { // Recovery
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("su adb reboot recovery");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: your Phone is Not Rooted", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Root your Phone to Use this App", Toast.LENGTH_SHORT).show();

        }

    }

    public void about(View v) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void exit(View v) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
            Log.d("iBoot: ", "The interstitial wasn't loaded yet.");
        }
    }

    // @Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    // getMenuInflater().inflate(R.menu.main, menu);
    // return true;
    // }

    // @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    // int id = item.getItemId();
    // if (id == R.id.action_settings) {
    // return true;
    // }
    // return super.onOptionsItemSelected(item);
    // }


    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
            Log.d("iBoot: ", "The interstitial wasn't loaded yet.");
        }
        super.onBackPressed();
    }
}
