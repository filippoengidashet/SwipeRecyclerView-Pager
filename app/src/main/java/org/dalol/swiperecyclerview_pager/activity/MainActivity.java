package org.dalol.swiperecyclerview_pager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.dalol.swiperecyclerview_pager.R;
import org.dalol.swiperecyclerview_pager.widget.RecyclerViewPager;
import org.dalol.swiperecyclerview_pager.adapter.RecyclerViewPagerAdapter;
import org.dalol.swiperecyclerview_pager.helper.PlanetHelper;
import org.dalol.swiperecyclerview_pager.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewPager.SnapRecyclerViewListener {

    private RecyclerViewPager mRecyclerViewPager;
    private RecyclerViewPagerAdapter mAdapter;
    private int mWidth;
    private List<Planet> mPlanetList = new ArrayList<>();
    private TextView mPlanetName, mMass, mDiameter, mDensity, mOblateness, mRotation, mDistance, mRevolution, mEccentricity, mInclination, mAxisTilt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
    }

    private void configViews() {
        mWidth = getWindowManager().getDefaultDisplay().getWidth();
        mRecyclerViewPager = (RecyclerViewPager) findViewById(R.id.recycleView);

        mPlanetName = (TextView) findViewById(R.id.planetName);
        mMass = (TextView) findViewById(R.id.planetMass);
        mDiameter = (TextView) findViewById(R.id.planetDiameter);
        mDensity = (TextView) findViewById(R.id.planetDensity);
        mOblateness = (TextView) findViewById(R.id.planetOblateness);
        mRotation = (TextView) findViewById(R.id.planetRotation);
        mDistance = (TextView) findViewById(R.id.planetDistance);
        mRevolution = (TextView) findViewById(R.id.planetRevolution);
        mEccentricity = (TextView) findViewById(R.id.planetEccentricy);
        mInclination = (TextView) findViewById(R.id.planetInclination);
        mAxisTilt = (TextView) findViewById(R.id.planetAxis);


        mRecyclerViewPager.addSnapListener(MainActivity.this);

        initializePlanets();

        mAdapter = new RecyclerViewPagerAdapter(mPlanetList, mWidth) {
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

        RecyclerViewPagerAdapter.Holder center = (RecyclerViewPagerAdapter.Holder) centerHolder;

        Planet planet = center.getPlanet();

        mPlanetName.setText(planet.getName());
        mMass.setText(Double.toString(planet.getMass()) + " (* ME)");
        mDiameter.setText(Double.toString(planet.getDiameter()) + " (km)");
        mDensity.setText(Double.toString(planet.getDensity()) + " g/cm3");
        mOblateness.setText(Double.toString(planet.getOblateness()) + " [=(De-Dp)/De]");
        mRotation.setText(Double.toString(planet.getRotation()));
        mDistance.setText(Double.toString(planet.getDistance()) + " (A.U.)");
        mRevolution.setText(Double.toString(planet.getRevolution()));
        mEccentricity.setText(Double.toString(planet.getEccentricity()));
        mInclination.setText(Double.toString(planet.getInclination()) + " (deg)");
        mAxisTilt.setText(Double.toString(planet.getAxisTilt()) + " (deg)");

    }

    @Override
    public void onLeftItemSnapped(int holderPosition, RecyclerView.ViewHolder leftHolder) {

    }

    @Override
    public void onRightItemSnapped(int holderPosition, RecyclerView.ViewHolder rightHolder) {

    }

    public void initializePlanets() {
        mPlanetList.add(PlanetHelper.getMercury());
        mPlanetList.add(PlanetHelper.getVenus());
        mPlanetList.add(PlanetHelper.getEarth());
        mPlanetList.add(PlanetHelper.getMars());
        mPlanetList.add(PlanetHelper.getJupiter());
        mPlanetList.add(PlanetHelper.getSaturn());
        mPlanetList.add(PlanetHelper.getUranus());
        mPlanetList.add(PlanetHelper.getNeptune());
        mPlanetList.add(PlanetHelper.getPluto());
    }
}
