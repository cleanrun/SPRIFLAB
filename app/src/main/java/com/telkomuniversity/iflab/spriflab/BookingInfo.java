package com.telkomuniversity.iflab.spriflab;

import java.io.Serializable;

public class BookingInfo {
    private String nim, tanggalmulai, tanggalselesai, nama, alamat, ruangan,
            nohp, dosen, organisasi, alasan, waktumulai, waktuselesai, ktm, status;

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
