/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class SanPhamHDViewModel {
     private int id;
    
    private String tenSp;
    private String loaiSanPham;
    private String thuongHieu;
    private String mauSac;
    private String kichCo;
    
    private String chatLieu;
    
    private int soLuong;
    
    private int donGia;

    public SanPhamHDViewModel() {
    }

    public SanPhamHDViewModel(int id, String tenSp, String loaiSanPham, String thuongHieu, String mauSac, String kichCo, String chatLieu, int soLuong, int donGia) {
        this.id = id;
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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "SanPhamHDViewModel{" + "id=" + id + ", tenSp=" + tenSp + ", loaiSanPham=" + loaiSanPham + ", thuongHieu=" + thuongHieu + ", mauSac=" + mauSac + ", kichCo=" + kichCo + ", chatLieu=" + chatLieu + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    
   
}
