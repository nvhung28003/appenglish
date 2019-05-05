package com.example.yuroko.appfood.entity;

public class Information {
    private String pagetitle;
    private String stt;
    private String avatar;
    private String noidung;
    private String cachdoc;
    private String giaithich;
    private String tuloai;
    private String vidu;
    private String viduvietsub;
    private String mp3;
    private String href;

    public Information() {
    }

    public Information(String pagetitle, String stt, String avatar, String noidung, String cachdoc, String giaithich, String tuloai, String vidu, String viduvietsub, String mp3, String href) {
        this.pagetitle = pagetitle;
        this.stt = stt;
        this.avatar = avatar;
        this.noidung = noidung;
        this.cachdoc = cachdoc;
        this.giaithich = giaithich;
        this.tuloai = tuloai;
        this.vidu = vidu;
        this.viduvietsub = viduvietsub;
        this.mp3 = mp3;
        this.href = href;
    }

    public String getPagetitle() {
        return pagetitle;
    }

    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getCachdoc() {
        return cachdoc;
    }

    public void setCachdoc(String cachdoc) {
        this.cachdoc = cachdoc;
    }

    public String getGiaithich() {
        return giaithich;
    }

    public void setGiaithich(String giaithich) {
        this.giaithich = giaithich;
    }

    public String getTuloai() {
        return tuloai;
    }

    public void setTuloai(String tuloai) {
        this.tuloai = tuloai;
    }

    public String getVidu() {
        return vidu;
    }

    public void setVidu(String vidu) {
        this.vidu = vidu;
    }

    public String getViduvietsub() {
        return viduvietsub;
    }

    public void setViduvietsub(String viduvietsub) {
        this.viduvietsub = viduvietsub;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Information{" +
                "pagetitle='" + pagetitle + '\'' +
                ", stt='" + stt + '\'' +
                ", avatar='" + avatar + '\'' +
                ", noidung='" + noidung + '\'' +
                ", cachdoc='" + cachdoc + '\'' +
                ", giaithich='" + giaithich + '\'' +
                ", tuloai='" + tuloai + '\'' +
                ", vidu='" + vidu + '\'' +
                ", viduvietsub='" + viduvietsub + '\'' +
                ", mp3='" + mp3 + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
