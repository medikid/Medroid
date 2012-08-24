package com.meditrainer.medroid.ui;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PerfAnalysisActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perf_analysis);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_perf_analysis, menu);
        return true;
    }
}
