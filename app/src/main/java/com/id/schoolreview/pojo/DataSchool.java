package com.id.schoolreview.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class DataSchool implements Parcelable {
    String kode, nama, tingkat,alamat, gambar, banner, sarana, sarana1, prestasi, prestasi1;

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

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSarana() {
        return sarana;
    }

    public void setSarana(String sarana) {
        this.sarana = sarana;
    }

    public String getSarana1() {
        return sarana1;
    }

    public void setSarana1(String sarana1) {
        this.sarana1 = sarana1;
    }

    public String getPrestasi() {
        return prestasi;
    }

    public void setPrestasi(String prestasi) {
        this.prestasi = prestasi;
    }

    public String getPrestasi1() {
        return prestasi1;
    }

    public void setPrestasi1(String prestasi1) {
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
        dest.writeString(this.gambar);
        dest.writeString(this.banner);
        dest.writeString(this.sarana);
        dest.writeString(this.sarana1);
        dest.writeString(this.prestasi);
        dest.writeString(this.prestasi1);
    }

    public DataSchool() {
    }

    protected DataSchool(Parcel in) {
        this.kode = in.readString();
        this.nama = in.readString();
        this.tingkat = in.readString();
        this.alamat = in.readString();
        this.gambar = in.readString();
        this.banner = in.readString();
        this.sarana = in.readString();
        this.sarana1 = in.readString();
        this.prestasi = in.readString();
        this.prestasi1 = in.readString();
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
