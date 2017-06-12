package jsc.com.lampstudio.Models;


import com.orm.SugarRecord;

import jsc.com.lampstudio.until.PasswordEncoder;

/**
 * Created by khoa on 6/10/2017.
 */
public class Korean extends SugarRecord{
//    id INTEGER PRIMARY KEY   ,
//    english TEXT NOT NULL ,
//    Korean TEXT NOT NULL
//,pronount TEXT NOT NULL
//, like BOOL DEFAULT false, "name_sound" TEXT, "type" INTEGER NOT NULL  DEFAULT 55)
    public int _id;
//    public int type;
    public String english;
    public String korea;
    public String pronout;
    public String name_sound;
    public int like;

    public Korean() {
    }

    public Korean(int id,  String english, String Korean, String pronount, String name_sound, int like) {
        this._id = id;
//        this.type = type;
        this.english = english;
        this.korea = Korean;
        this.pronout = pronount;
        this.name_sound = name_sound;
        this.like = like;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
//
//    public String getEnglish() {
//        return english;
//    }
//
//    public void setEnglish(String english) {
//        this.english = english;
//    }
//
//    public String getKorean() {
//        return Korean;
//    }
//
//    public void setKorean(String Korean) {
//        this.Korean = Korean;
//    }
//
//    public String getPronount() {
//        return pronount;
//    }
//
//    public void setPronount(String pronount) {
//        this.pronount = pronount;
//    }
//
//    public String getName_sound() {
//        return name_sound;
//    }
//
//    public void setName_sound(String name_sound) {
//        this.name_sound = name_sound;
//    }
//
//    public int getLike() {
//        return like;
//    }
//
//    public void setLike(int like) {
//        this.like = like;
//    }
//    public void encryptData(){
//        english = PasswordEncoder.encrypt(english);
//        Korean = PasswordEncoder.encrypt(Korean);
//        pronount = PasswordEncoder.encrypt(pronount);
//        name_sound = PasswordEncoder.encrypt(name_sound);
//    }
//    public void dencryptData(){
//        english = PasswordEncoder.decrypt(english);
//        Korean = PasswordEncoder.decrypt(Korean);
//        pronount = PasswordEncoder.decrypt(pronount);
//        name_sound = PasswordEncoder.decrypt(name_sound);
//    }
//    public void showInfor(){
//        System.out.println("Korean.showInfor english "+english+
//        "\n Korean "+Korean+"\n id "+id+ "\n pronout "+pronount+ "\n name sound "+name_sound+"\n ********************************");
//    }
}
