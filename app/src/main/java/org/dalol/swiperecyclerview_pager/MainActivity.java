package org.dalol.swiperecyclerview_pager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerViewPager.SnapRecyclerViewListener {

    private RecyclerViewPager mRecyclerViewPager;
    private RecyclerViewPagerAdapter mAdapter;
    private int mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
    }

    private void configViews() {
        mWidth = getWindowManager().getDefaultDisplay().getWidth();
        mRecyclerViewPager = (RecyclerViewPager) findViewById(R.id.recycleView);
        mRecyclerViewPager.addSnapListener(MainActivity.this);
        mAdapter = new RecyclerViewPagerAdapter(mWidth) {
            @Override
            public void snapViewToCenter(View view) {
                int viewCenter = (view.getLeft() + view.getRight()) / 2;
                int scrollNeeded = viewCenter - (mWidth / 2);
                mRecyclerViewPager.setScrollType(RecyclerViewPager.SwipeType.TAP);
                mRecyclerViewPager.smoothScrollBy(scrollNeeded, 0);
            }
        };
        mRecyclerViewPager.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCenterItemSnapped(int centerHolderPosition, RecyclerView.ViewHolder centerHolder, RecyclerViewPager.SwipeType scrollType) {
        Toast.makeText(getApplicationContext(), "Center holder snapped at position :: " + centerHolderPosition, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLeftItemSnapped(int holderPosition, RecyclerView.ViewHolder leftHolder) {

    }

    @Override
    public void onRightItemSnapped(int holderPosition, RecyclerView.ViewHolder rightHolder) {

    }
}
