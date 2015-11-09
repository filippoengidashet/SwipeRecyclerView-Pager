package org.dalol.swiperecyclerview_pager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.dalol.swiperecyclerview_pager.R;
import org.dalol.swiperecyclerview_pager.model.Planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filippo-TheAppExpert on 9/15/2015.
 */
public abstract class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.Holder> {

    List<Planet> mPlanets = new ArrayList<>();
    private int mWidth;

    public RecyclerViewPagerAdapter(List<Planet> planets, int width) {
        mPlanets = planets;
        mWidth = width / 2;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(mWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        if (viewType == 0) {
            params.leftMargin = mWidth;
        } else if (viewType == 1) {
            params.rightMargin = mWidth;
        }
        row.setLayoutParams(params);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Planet planet = mPlanets.get(position);

        holder.setPlanet(planet);
        holder.mText.setText(planet.getName());
        holder.mImage.setImageResource(planet.getImage());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == (getItemCount() - 1)) {
            return 1;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImage;
        public TextView mText;
        private Planet mPlanet;

        public Holder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.planetImage);
            mText = (TextView) itemView.findViewById(R.id.planetName);
            itemView.setOnClickListener(Holder.this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "You Tapped on -> " + mPlanet.getName() + "!", Toast.LENGTH_SHORT).show();

            snapViewToCenter(v);
        }

        public void setPlanet(Planet planet) {
            mPlanet = planet;
        }

        public Planet getPlanet() {
            return mPlanet;
        }
    }

    public abstract void snapViewToCenter(View view);
}
