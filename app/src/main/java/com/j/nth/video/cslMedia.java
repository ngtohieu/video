package com.j.nth.video;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class cslMedia {
    Context context;

    public cslMedia(Context context) {
        this.context = context;
    }

    public ArrayList<ObjVideo> getAllMedia() {
        ArrayList<ObjVideo> videoItemHashSet = new ArrayList<>();
        String[] projection = { MediaStore.Video.VideoColumns.DATA ,MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do{
                String path = (cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)));
                String name = (cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)));
                videoItemHashSet.add(new ObjVideo(path,this.getImageURL(path),name));
            }while(cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ObjVideo> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }

    public Bitmap getImageURL(String path)
    {
        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(path,
                MediaStore.Images.Thumbnails.MINI_KIND);
        return thumb;
    }

    public String getNameURL(String path)
    {
        Uri u = Uri.parse(path);

        File f = new File("" + u);

        return f.getName();
    }
}
