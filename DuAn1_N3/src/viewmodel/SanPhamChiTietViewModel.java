/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietViewModel {
     private int id;
    private String ma;
    private String maVach;
    private String moTa;
    private int soLuong;
    private int idSP;
    private int idTH;
    private int idLSP;
    private int idKC;
    private int idMS;
    private int idCL;
    private float giaNhap;
    private float giaBan;
    private boolean trangThai;

    public SanPhamChiTietViewModel() {
    }

    public SanPhamChiTietViewModel(int id, String ma, String maVach, String moTa, int soLuong, int idSP, int idTH, int idLSP, int idKC, int idMS, int idCL, float giaNhap, float giaBan, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.maVach = maVach;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.idSP = idSP;
        this.idTH = idTH;
        this.idLSP = idLSP;
        this.idKC = idKC;
        this.idMS = idMS;
        this.idCL = idCL;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getIdTH() {
        return idTH;
    }

    public void setIdTH(int idTH) {
        this.idTH = idTH;
    }

    public int getIdLSP() {
        return idLSP;
    }

    public void setIdLSP(int idLSP) {
        this.idLSP = idLSP;
    }

    public int getIdKC() {
        return idKC;
    }

    public void setIdKC(int idKC) {
        this.idKC = idKC;
    }

    public int getIdMS() {
        return idMS;
    }

    public void setIdMS(int idMS) {
        this.idMS = idMS;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public Object[] toRowData(){
        return new Object[]{ma,maVach,moTa,soLuong,idSP,idTH,idLSP,idKC,idMS,idCL,giaNhap,giaBan,soLuong==0?"Hết Hàng":"Con Hàng"};
    }
}
