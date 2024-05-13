/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class GioHangViewModel {
    private int id;
    
    private String maHD;
    
    private String tenSp;
    private String loaiSanPham;
    private String thuongHieu;
    private String mauSac;
    private String kichCo;
    
    private String chatLieu;
    
    private int soLuong;
    
    private Float donGia;

    public GioHangViewModel() {
    }

    public GioHangViewModel(int id, String maHD, String tenSp, String loaiSanPham, String thuongHieu, String mauSac, String kichCo, String chatLieu, int soLuong, Float donGia) {
        this.id = id;
        this.maHD = maHD;
        this.tenSp = tenSp;
        this.loaiSanPham = loaiSanPham;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.chatLieu = chatLieu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    public Object[] toRowData(){
        return new Object[]{maHD,tenSp,loaiSanPham,thuongHieu,mauSac,kichCo,chatLieu,soLuong,donGia};
    }
}
