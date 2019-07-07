package com.j.nth.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<ObjVideo> objVideos;

    public adapter(Context context, int layout, ArrayList<ObjVideo> objVideos) {
        this.context = context;
        this.layout = layout;
        this.objVideos = objVideos;
    }

    @Override
    public int getCount() {
        return objVideos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class viewHolder{
        ImageView imageView;
        TextView nameVideo;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if(view == null)
        {
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.itemvideo,null);
            holder.imageView = view.findViewById(R.id.imageView);
            holder.nameVideo = view.findViewById(R.id.nameVideo);
            view.setTag(holder);
        }
        else
        {
            holder = (viewHolder) view.getTag();
        }
        ObjVideo video = objVideos.get(i);
        holder.imageView.setImageBitmap(video.image);
        holder.nameVideo.setText(video.nameVideo);
        return view;
    }
}
