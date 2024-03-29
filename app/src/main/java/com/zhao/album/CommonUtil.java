package com.zhao.album;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }



    /**
     * md5加密
     */
    public static String md5(Object object) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(toByteArray(object));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }



    /**
     * 获取存储路径
     */
    public static String getDataPath() {
        String path;
        if (isExistSDcard())
            path = Environment.getExternalStorageDirectory().getPath() + "/albumSelect";
        else
            path = AppContext.getInstance().getFilesDir().getPath();
        if (!path.endsWith("/"))
            path = path + "/";
        return path;
    }


    /**
     * 检测SDcard是否存在
     *
     * @return
     */
    public static boolean isExistSDcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
            return true;
        else {
            return false;
        }
    }

    public static boolean isImage(String type) {
        return MimeType.JPEG.toString().equals(type)
                ||MimeType.PNG.toString().equals(type)
                ||MimeType.GIF.toString().equals(type)
                ||MimeType.BMP.toString().equals(type)
                ||MimeType.WEBP.toString().equals(type);
    }


    public static boolean isVideo(String type) {
        return MimeType.MPEG.toString().equals(type)
                ||MimeType.MP4.toString().equals(type)
                ||MimeType.QUICKTIME.toString().equals(type)
                ||MimeType.THREEGPP.toString().equals(type)
                ||MimeType.THREEGPP2.toString().equals(type)
                ||MimeType.MKV.toString().equals(type)
                ||MimeType.WEBM.toString().equals(type)
                ||MimeType.TS.toString().equals(type)
                ||MimeType.AVI.toString().equals(type);
    }
}
