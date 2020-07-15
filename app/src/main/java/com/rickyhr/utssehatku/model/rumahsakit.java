package com.rickyhr.utssehatku.model;

public class rumahsakit {
    private String id_rs;
    private String nama_rs;
    private String alamat_rs;
    private String no_telp;

    public rumahsakit(){
        super();
    }

    public rumahsakit(String id_rs, String nama_rs, String alamat_rs, String no_telp) {
        this.id_rs = id_rs;
        this.nama_rs = nama_rs;
        this.alamat_rs = alamat_rs;
        this.no_telp = no_telp;
    }

    public String getId_rs() {
        return id_rs;
    }

    public void setId_rs(String id_rs) {
        this.id_rs = id_rs;
    }

    public String getNama_rs() {
        return nama_rs;
    }

    public void setNama_rs(String nama_rs) {
        this.nama_rs = nama_rs;
    }

    public String getAlamat_rs() {
        return alamat_rs;
    }

    public void setAlamat_rs(String alamat_rs) {
        this.alamat_rs = alamat_rs;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
