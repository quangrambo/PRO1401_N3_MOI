package viewmodel;

public class SanPhamThongKe {

    private String maSp;
    private String tenSp;
    private String loaiSp;
    private String thuongHieu;
    private String mauSac;
    
    private String kichCo;
    private String chatLieu;
    
    private int soLuongBan;
    
    private int giaBan;
    
    private int doanhThu;

    public SanPhamThongKe() {
    }

    public SanPhamThongKe(String maSp, String tenSp, String loaiSp, String thuongHieu, String mauSac, String kichCo, String chatLieu, int soLuongBan, int giaBan, int doanhThu) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.loaiSp = loaiSp;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.chatLieu = chatLieu;
        this.soLuongBan = soLuongBan;
        this.giaBan = giaBan;
        this.doanhThu = doanhThu;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
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

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }

    
}