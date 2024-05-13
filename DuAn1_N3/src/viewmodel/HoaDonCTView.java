/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class HoaDonCTView {
    private int id;
        private int idHD;
        private int idSPCT;
        private int soluong;
        private int donGia;

    public HoaDonCTView() {
    }

    public HoaDonCTView(int id, int idHD, int idSPCT, int soluong, int donGia) {
        this.id = id;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.soluong = soluong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HoaDonCTView{" + "id=" + id + ", idHD=" + idHD + ", idSPCT=" + idSPCT + ", soluong=" + soluong + ", donGia=" + donGia + '}';
    }
        
}
