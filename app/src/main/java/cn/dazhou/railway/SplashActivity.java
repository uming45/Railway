package cn.dazhou.railway;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.dazhou.im.util.Tool;
import cn.dazhou.maputil.MapLauncher;
import cn.dazhou.railway.im.activity.LoginActivity;
import cn.dazhou.railway.util.LogUtil;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.content)
    ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapLauncher.init(getApplicationContext());
        ViewGroup content = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_splash, null);
        setContentView(content);
        Tool.checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        Tool.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Tool.checkPermission(this, Manifest.permission.RECORD_AUDIO);
        Tool.checkPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        Tool.checkPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
//        Tool.checkPermission(this);
        LogUtil.init();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    void login() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.bt_position)
    void position() {
        MapLauncher.loadMap(content);
        MapLauncher.getPosition();
    }

    public static void startItself(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }
}
