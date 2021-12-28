/*
 * Copyright (c) WhatsApp Inc. and its affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.jobeso.RNWhatsAppStickers;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

class Sticker implements Parcelable {
    String imageFileName;
    List<String> emojis;
    Boolean isAnimated;
    long size;


    Sticker(String imageFileName, List<String> emojis) {
        this.imageFileName = imageFileName;
        this.emojis = emojis;
        this.isAnimated = true;
    }

    protected Sticker(Parcel in) {
        Log.v("ReactNative","Sticker Constructor triggered....!"); //ksr
        imageFileName = in.readString();
        emojis = in.createStringArrayList();
        isAnimated = in.readByte() != 0;;
        size = in.readLong();
    }

    public static final Creator<Sticker> CREATOR = new Creator<Sticker>() {
        @Override
        public Sticker createFromParcel(Parcel in) {
            return new Sticker(in);
        }

        @Override
        public Sticker[] newArray(int size) {
            return new Sticker[size];
        }
    };

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageFileName);
        dest.writeStringList(emojis);
        dest.writeLong(size);
    }

    public String getContent() {
        return imageFileName;
    }
}
