package com.suntiago.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.suntiago.demo.R;
import com.suntiago.lockpattern.PatternManager;


/**
 * Created by Jeremy on 2018/11/16.
 */

public class MainActivity extends Activity {
    private final String TAG = getClass().getSimpleName();

    TextView tvPatternLoginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPattern();
        Log.d(TAG, "onCreate  [savedInstanceState]:");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void initPattern() {
        PatternManager.init(this);
        PatternManager.get().accountLogin("2345234 ");
        tvPatternLoginStatus = findViewById(R.id.tv_pattern_login_status);
        tvPatternLoginStatus.setText(PatternManager.get().isPatternSet() ?
                "已设置手势密码" : "未设置手势密码");
    }

    public void patternLogin(View v) {
        if (!PatternManager.get().isPatternSet()) {
            PatternManager.get().setPatternCallback(new PatternManager.PatternCallback() {
                @Override
                public void patternSet() {
                    Log.d(TAG, "patternSet  []:");
                    tvPatternLoginStatus.setText(PatternManager.get().isPatternSet() ?
                            "已设置手势密码" : "未设置手势密码");
                }

                @Override
                public void patternForget() {
                    Log.d(TAG, "patternForget  []:");
                }

                @Override
                public void patternChecked() {
                    Log.d(TAG, "patternChecked  []:");

                }
            });
            PatternManager.get().setPattern();
        }
    }

    public void patternLogout(View v) {
        if (PatternManager.get().isPatternSet()) {
            PatternManager.get().accountLoginout();
            tvPatternLoginStatus.setText(PatternManager.get().isPatternSet() ?
                    "已设置手势密码" : "未设置手势密码");
        }
    }

    public void patternCheck(View v) {
        if (PatternManager.get().isPatternSet()) {
            PatternManager.get().checkoutPattern();
        } else {
            Toast.makeText(this, "请先设置手势密码", Toast.LENGTH_SHORT).show();
        }
    }
}
