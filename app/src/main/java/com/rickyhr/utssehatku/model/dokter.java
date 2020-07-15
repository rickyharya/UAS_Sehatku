package com.rickyhr.utssehatku.model;

public class dokter {
    private String id_dokter;
    private String nama_dokter;
    private String spesialisasi;
    private String no_telp;
    private String nama_rs;

    public dokter(){
        super();
    }

    public dokter(String id_dokter, String nama_dokter, String spesialisasi, String no_telp, String nama_rs) {
        this.id_dokter = id_dokter;
        this.nama_dokter = nama_dokter;
        this.spesialisasi = spesialisasi;
        this.no_telp = no_telp;
        this.nama_rs = nama_rs;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getNama_rs() {
        return nama_rs;
    }

    public void setNama_rs(String nama_rs) {
        this.nama_rs = nama_rs;
    }
}
