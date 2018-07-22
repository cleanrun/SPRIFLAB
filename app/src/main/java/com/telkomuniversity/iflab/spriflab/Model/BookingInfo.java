package com.telkomuniversity.iflab.spriflab.Model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;


public class BookingInfo {
    @SerializedName("title")
    @Expose
    private String nim;

    @SerializedName("start")
    @Expose
    private String tanggalmulai;

    @SerializedName("end")
    @Expose
    private String tanggalselesai;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("nohp")
    @Expose
    private String nohp;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("dosen")
    @Expose
    private String dosen;

    @SerializedName("ruang")
    @Expose
    private String ruangan;

    @SerializedName("organisasi")
    @Expose
    private String organisasi;

    @SerializedName("alasan")
    @Expose
    private String alasan;

    @SerializedName("mulai")
    @Expose
    private String waktumulai;

    @SerializedName("selesai")
    @Expose
    private String waktuselesai;

    @SerializedName("status")
    @Expose
    private String status;

    private String ktm;

    public BookingInfo(String nim, String tanggalmulai, String tanggalselesai, String nama, String alamat,
                       String ruangan, String nohp, String dosen, String organisasi, String alasan,
                       String waktumulai, String waktuselesai, String ktm, String status) {
        this.nim = nim;
        this.tanggalmulai = tanggalmulai;
        this.tanggalselesai = tanggalselesai;
        this.nama = nama;
        this.alamat = alamat;
        this.ruangan = ruangan;
        this.nohp = nohp;
        this.dosen = dosen;
        this.organisasi = organisasi;
        this.alasan = alasan;
        this.waktumulai = waktumulai;
        this.waktuselesai = waktuselesai;
        this.ktm = ktm;
        this.status = status;
    }

    public BookingInfo(){

    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setTanggalmulai(String tanggalmulai) {
        this.tanggalmulai = tanggalmulai;
    }

    public void setTanggalselesai(String tanggalselesai) {
        this.tanggalselesai = tanggalselesai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public void setWaktumulai(String waktumulai) {
        this.waktumulai = waktumulai;
    }

    public void setWaktuselesai(String waktuselesai) {
        this.waktuselesai = waktuselesai;
    }

    public void setKtm(String ktm) {
        this.ktm = ktm;
    }

    public String getNim() {
        return nim;
    }

    public String getTanggalmulai() {
        return tanggalmulai;
    }

    public String getTanggalselesai() {
        return tanggalselesai;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getRuangan() {
        return ruangan;
    }

    public String getNohp() {
        return nohp;
    }

    public String getDosen() {
        return dosen;
    }

    public String getOrganisasi() {
        return organisasi;
    }

    public String getAlasan() {
        return alasan;
    }

    public String getWaktumulai() {
        return waktumulai;
    }

    public String getWaktuselesai() {
        return waktuselesai;
    }

    public String getKtm() {
        return ktm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
