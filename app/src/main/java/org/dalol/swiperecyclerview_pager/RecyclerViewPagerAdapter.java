package org.dalol.swiperecyclerview_pager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Filippo-TheAppExpert on 9/15/2015.
 */
public abstract class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.Holder> {

    private int mWidth;

    public RecyclerViewPagerAdapter(int width) {
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
        holder.mText.setText(Integer.toString(position));
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
        return 65;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mText;

        public Holder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(Holder.this);
        }

        @Override
        public void onClick(View v) {
            snapViewToCenter(v);
        }
    }

    public abstract void snapViewToCenter(View view);
}
