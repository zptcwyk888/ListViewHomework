package com.homework.wyk.homelistview.bean;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Fruit {
    public String mFruitName;
    public  int mImageId;

    public Fruit(String mFruitName, int mImageId) {
        this.mFruitName = mFruitName;
        this.mImageId = mImageId;
    }

    public String getmFruitName() {
        return mFruitName;
    }

    public void setmFruitName(String mFruitName) {
        this.mFruitName = mFruitName;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}
