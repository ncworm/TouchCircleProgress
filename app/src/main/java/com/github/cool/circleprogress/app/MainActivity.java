package com.github.cool.circleprogress.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.cool.circleprogress.ArcProgress;
import com.github.cool.circleprogress.Callback;
import com.github.cool.circleprogress.CircleProgress;
import com.github.cool.circleprogress.DonutProgress;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.donut)
    DonutProgress donut;
    @Bind(R.id.circle)
    CircleProgress circle;
    @Bind(R.id.arc)
    ArcProgress arc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        donut.setCallback(new Callback() {
            @Override
            public void update(int progress) {
                Log.d("DonutProgress", "progress:" + progress);
            }
        });

        circle.setCallback(new Callback() {
            @Override
            public void update(int progress) {
                Log.d("CircleProgress", "progress:" + progress);
            }
        });

        arc.setCallback(new Callback() {
            @Override
            public void update(int progress) {
                Log.d("ArcProgress", "progress:" + progress);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_normal) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (id == R.id.action_view_pager) {
            startActivity(new Intent(this, ViewPagerActivity.class));
            return true;
        } else if (id == R.id.action_custom) {
            startActivity(new Intent(this, SwipeBackActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
