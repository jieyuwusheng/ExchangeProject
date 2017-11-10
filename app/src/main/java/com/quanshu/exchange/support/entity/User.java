package com.quanshu.exchange.support.entity;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

/**
 * Created by jye on 2017/8/28.
 */
@Data
public class User implements Parcelable {

    public static final int TYPE_NOT_FRIEND = 0;
    public static final int TYPE_IS_FRIEND = 1;

    public static final int SEX_UNKNOWN = 0;
    public static final int SEX_FEMALE = 1;
    public static final int SEX_MALE = 2;

    public static final String TYPE_USER_MAIN = "1";
    public static final String TYPE_USER_NOT_MAIN = "0";

    private String id;
    private String username;
    private String pwd;
    private String nickname;
    private int gender;
    private String province;
    private String remarkName;
    private String city;

////////////////////////////////////////////////////////
//    *******************************************
//////////////////////////////////////////////////////////////////

    private String sapphire; // 蓝宝石
    private String ruby;   // 红宝石
    private String jtoken;  //结通币
    private String name;
    private String mobile;
    private String photo;
    private String level;
    private String packagejcoin;
    private String is_main = "";


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.pwd);
        dest.writeString(this.nickname);
        dest.writeInt(this.gender);
        dest.writeString(this.province);
        dest.writeString(this.remarkName);
        dest.writeString(this.city);
        dest.writeString(this.sapphire);
        dest.writeString(this.ruby);
        dest.writeString(this.jtoken);
        dest.writeString(this.name);
        dest.writeString(this.mobile);
        dest.writeString(this.photo);
        dest.writeString(this.level);
        dest.writeString(this.packagejcoin);
        dest.writeString(this.is_main);
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.pwd = in.readString();
        this.nickname = in.readString();
        this.gender = in.readInt();
        this.province = in.readString();
        this.remarkName = in.readString();
        this.city = in.readString();
        this.sapphire = in.readString();
        this.ruby = in.readString();
        this.jtoken = in.readString();
        this.name = in.readString();
        this.mobile = in.readString();
        this.photo = in.readString();
        this.level = in.readString();
        this.packagejcoin = in.readString();
        this.is_main = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
