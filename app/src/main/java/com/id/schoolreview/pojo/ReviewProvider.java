package com.id.schoolreview.pojo;

public class ReviewProvider {
    private String kode,nama,deskripsi,nilai,kodeid;



    public ReviewProvider(String kode, String nama, String deskripsi, String nilai, String kodeid) {
        this.kode = kode;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.nilai = nilai;
        this.kodeid = kodeid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
    public String getKodeid() {
        return kodeid;
    }

    public void setKodeid(String kodeid) {
        this.kodeid = kodeid;
    }
}
