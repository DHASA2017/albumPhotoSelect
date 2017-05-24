package com.zhao.album;

import java.io.Serializable;

public class SingleImageModel implements Serializable{
    public String path;
    public boolean isPicked;
    public long date;
    public long id;
    public String thumbnailPath;
    public long duration;
    public boolean isVideo;

    public SingleImageModel(String path, boolean isPicked, long date, long id,String thumbnailPath,long duration,boolean isVideo){
        this.path = path;
        this.isPicked = isPicked;
        this.date = date;
        this.id = id;
        this.thumbnailPath = thumbnailPath;
        this.duration = duration;
        this.isVideo = isVideo;
    }
    public SingleImageModel(){

    }
    public boolean isThisImage(String path){
        return this.path.equalsIgnoreCase(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}
