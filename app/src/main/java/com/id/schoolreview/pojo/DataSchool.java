package com.id.schoolreview.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class DataSchool implements Parcelable {
    String kode, nama, tingkat,alamat, sarana, prestasi, location;
    int gambar, banner, sarana1,prestasi1;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public String getSarana() {
        return sarana;
    }

    public void setSarana(String sarana) {
        this.sarana = sarana;
    }



    public String getPrestasi() {
        return prestasi;
    }

    public void setPrestasi(String prestasi) {
        this.prestasi = prestasi;
    }


    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public int getSarana1() {
        return sarana1;
    }

    public void setSarana1(int sarana1) {
        this.sarana1 = sarana1;
    }

    public int getPrestasi1() {
        return prestasi1;
    }

    public void setPrestasi1(int prestasi1) {
        this.prestasi1 = prestasi1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kode);
        dest.writeString(this.nama);
        dest.writeString(this.tingkat);
        dest.writeString(this.alamat);
        dest.writeString(this.sarana);
        dest.writeString(this.prestasi);
        dest.writeInt(this.gambar);
        dest.writeInt(this.banner);
        dest.writeInt(this.sarana1);
        dest.writeInt(this.prestasi1);
        dest.writeString(this.location);
    }

    public DataSchool() {
    }

    protected DataSchool(Parcel in) {
        this.kode = in.readString();
        this.nama = in.readString();
        this.tingkat = in.readString();
        this.alamat = in.readString();
        this.sarana = in.readString();
        this.prestasi = in.readString();
        this.gambar = in.readInt();
        this.banner = in.readInt();
        this.sarana1 = in.readInt();
        this.prestasi1 = in.readInt();
        this.location = in.readString();
    }

    public static final Parcelable.Creator<DataSchool> CREATOR = new Parcelable.Creator<DataSchool>() {
        @Override
        public DataSchool createFromParcel(Parcel source) {
            return new DataSchool(source);
        }

        @Override
        public DataSchool[] newArray(int size) {
            return new DataSchool[size];
        }
    };
}
