package cn.dazhou.railway.im.adapter.holder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.dazhou.railway.R;
import cn.dazhou.railway.im.db.FriendModel;

/**
 * Created by hooyee on 2017/5/11.
 */

public class RosterViewHolder extends BaseViewHolder<FriendModel> {
    private TextView mTv_name;
    private ImageView mImg_face;
    private TextView mTv_sign;

    public RosterViewHolder(ViewGroup parent) {
        super(parent, R.layout.roster_item);
        mTv_name = $(R.id.person_name);
        mTv_sign = $(R.id.person_sign);
        mImg_face = $(R.id.person_face);
    }

    @Override
    public void setData(final FriendModel entry){
        Log.i("ViewHolder","position"+getDataPosition());
        mTv_name.setText(entry.getName());
//        mTv_sign.setText(entry.getUnreadCount());
        Glide.with(getContext())
                .load(R.drawable.header_01)
                .asBitmap()
                .into(mImg_face);
    }
}
