/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import model.PhieuGiamGiaCT;
import repository.KhachHangRepository;
import service.ChatLieuService;
import model.PGGModel;
import model.PhieuGiamGiaCT;

import service.HDCTService;
import service.HDService;
import service.HDTableService;
import service.KhachHangService;
import service.KichCoService;
import service.LoaiSanPhamService;
import service.MauSacService;
import service.NhanVienService;
import service.PhieuGiamGiaCTService;
import service.SanPhamChiTietService;
import service.SanPhamService;
import service.ThuongHieuService;
import service.impl.ChatLieuServiceImpl;
import service.impl.HDCTVServiceIMpl;
import service.impl.HDServiceImpl;
import service.impl.HDTableSeriveImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.KichCoServiceImpl;
import service.impl.LoaiSanPhamServiceImpl;
import service.impl.MauSacSercviceImpl;

import service.impl.NhanVienServiceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import viewmodel.ChatLieuViewModel;
//import utility.Print;
import viewmodel.GioHangViewModel;
import viewmodel.HDCTViewModel;
import viewmodel.HDTableVIewModel;
import viewmodel.HDViewModel;
import viewmodel.KichCoViewModel;
import viewmodel.LoaiSanPhamViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.NhanVienVM;
import viewmodel.QLKhachHang;
import viewmodel.QLNhanVien;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author pc
 */
public class ViewBanHang extends javax.swing.JPanel implements Runnable, ThreadFactory {

    private List<SPCTViewModel> listSPCT = new ArrayList<>();
    private List<SanPhamChiTietViewModel> listSP = new ArrayList<>();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private SanPhamChiTietService serviceSPCT = new SanPhamChiTietServiceImpl();

    private List<KichCoViewModel> listKC = new ArrayList<>();
    private KichCoService serviceKC = new KichCoServiceImpl();
    private List<String> listCboKC = new ArrayList<>();
    private DefaultComboBoxModel dcbKC = new DefaultComboBoxModel();

    private List<SanPhamViewModel> listSPVM = new ArrayList<>();
    private SanPhamService serviceSp = new SanPhamServiceImpl();
    private List<String> listCboSP = new ArrayList<>();
    private DefaultComboBoxModel dcbSP = new DefaultComboBoxModel();

    private List<LoaiSanPhamViewModel> listLTT = new ArrayList<>();
    private LoaiSanPhamService serviceLTT = new LoaiSanPhamServiceImpl();
    private List<String> listCboLTT = new ArrayList<>();
    private DefaultComboBoxModel dcbLTT = new DefaultComboBoxModel();
    
    private List<MauSacViewModel> listMS = new ArrayList<>();
    private MauSacService serviceMS = new MauSacSercviceImpl();
    private List<String> listCboMS = new ArrayList<>();
    private DefaultComboBoxModel dcbMS = new DefaultComboBoxModel();

    private List<ThuongHieuViewModel> listTH = new ArrayList<>();
    private ThuongHieuService serviceTH = new ThuongHieuServiceImpl();
    private List<String> listCboTH = new ArrayList<>();
    private DefaultComboBoxModel dcbTH = new DefaultComboBoxModel();

    private List<ChatLieuViewModel> listCL = new ArrayList<>();
    private ChatLieuService serviceCL = new ChatLieuServiceImpl();
    private List<String> listCboCL = new ArrayList<>();
    private DefaultComboBoxModel dcbCL = new DefaultComboBoxModel();


    private DefaultTableModel dtmLoc = new DefaultTableModel();
    private DefaultTableModel dtmCTSP = new DefaultTableModel();
    private List<SanPhamViewModel> listSPXemCT = new ArrayList<>();

    private List<SPCTViewModel> listSPThemGioHang = new ArrayList<>();

    private List<HDViewModel> listHD = new ArrayList<>();
    private HDService serviceHD = new HDServiceImpl();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private List<HDTableVIewModel> listHDTable = new ArrayList<>();
    private List<HDTableVIewModel> listHDTableChuaThanhToan = new ArrayList<>();
    private HDTableService serviceHDTable = new HDTableSeriveImpl();
    private int idHD = 0;
    private String maHD = null;

    private List<HDCTViewModel> listGioHang = new ArrayList<>();
    private HDCTService serviceGioHang = new HDCTVServiceIMpl();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private List<GioHangViewModel> listSPInHD = new ArrayList<>();

    private List<GioHangViewModel> listSpGiohang = new ArrayList<>();

    private List<QLKhachHang> listKhachHang = new ArrayList<>();
    private KhachHangService serviceKhachHang = new KhachHangServiceImpl();
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private int idKhachHang = 0;

    private KhachHangRepository repository = new KhachHangRepository();


    private List<PhieuGiamGiaCT> listPGG = new ArrayList<>();
    private PhieuGiamGiaCTService servicePGG = new PhieuGiamGiaCTService();
    private List<String> listCboPGG = new ArrayList<>();
    private DefaultComboBoxModel dcbPGG = new DefaultComboBoxModel();

    private NhanVienVM nhanVien;
    private List<QLNhanVien> listnhanVien = new ArrayList<>();
    private NhanVienService serviceNV = new NhanVienServiceImpl();

    private int idNV = 0;

    private int idPGG = 0;
    private int tienPGG = 0;
    private int tienQuyDoi = 0;
    private int tongTien = 0;
    private int tienKhachDua = 0;
    private int tienThua = 0;
    private int tienKhachPhaiTra = 0;
    private int tienGiam = 0;

    /**
     * Creates new form BanHang
     */
    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ViewBanHang(NhanVienVM nv) {
        initComponents();
        nhanVien = nv;
        listnhanVien = serviceNV.getList();
        for (QLNhanVien nv1 : listnhanVien) {
            if (nv1.getMa().trim().equals(nhanVien.getMa())) {
                idNV = nv1.getId();
                jlbTenNhanVien.setText(nv1.getTen());
            }
        }

        // Show CBB Phiếu giảm giá (trong thời gian sử dụng, còn lượt , trạng thái đang sử dụng)
        listPGG = servicePGG.getAllPGGCT();
        dcbPGG = (DefaultComboBoxModel) this.cboPGG.getModel();
        listCboPGG.add("Không Dùng");
        List<PGGModel> list = servicePGG.getByMaPGGHD();
        for (PGGModel pGGModel : list) {
            if (pGGModel.getLuotSuDung() >= 0 && pGGModel.getTrangThai() == 1) {
                listCboPGG.add(pGGModel.getMa());
            }
        }
        showDataCBO(listCboPGG, dcbPGG);
        cboPGG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String selectedValue = (String) cboPGG.getSelectedItem();
                
                PGGModel selectedPhieu = null;
                        int selectedIndex = cboPGG.getSelectedIndex();

                for (PGGModel pg : list) {
                    if (pg.getMa().equals(selectedValue)) {
                        selectedPhieu = pg;
                        break;
                    }
                }
                
                if (selectedPhieu != null && selectedIndex !=0) {
                    txtGiaTri.setText("" + selectedPhieu.getGiaTri());
                }else{
                    txtGiaTri.setText("");
                }
            }
        });


        listHD = serviceHD.getAll();
        listHDTable = serviceHDTable.getAll();
        for (HDTableVIewModel hdctt : listHDTable) {
            if (hdctt.getTrangThai().trim().equals("0")) {
                listHDTableChuaThanhToan.add(hdctt);
            }
        }
        dtmHD = (DefaultTableModel) this.tblHoaDon.getModel();

        listSpGiohang = serviceGioHang.getGioHang();

        listGioHang = serviceGioHang.getAll();
        dtmGioHang = (DefaultTableModel) this.tblGioHang.getModel();

        listSPCT = serviceSPCT.getAllTable();
        listSP = serviceSPCT.getAll();
        dtmSP = (DefaultTableModel) this.tblSanPham.getModel();
        // showDataSanPham(listSPCT);

        dtmLoc = (DefaultTableModel) this.tblLocSanPham3.getModel();

        listSPVM = serviceSp.getAll();
        showDataSanPham(listSPVM);
        // show data cbb tên sp
        dcbSP = (DefaultComboBoxModel) this.cbbLocSanPhamm.getModel();
        listCboSP.add("");
        for (SanPhamViewModel sp : listSPVM) {
            listCboSP.add(sp.getTen());
        }
        showDataCBO(listCboSP, dcbSP);
        // show data cbb kích cỡ
        listKC = serviceKC.getAll();
        dcbKC = (DefaultComboBoxModel) this.cbbLocKichCoo.getModel();
        listCboKC.add("");
        for (KichCoViewModel kc : listKC) {
            listCboKC.add(kc.getKichCo());
        }
        showDataCBO(listCboKC, dcbKC);
        // show data cbb Loại Sản Phẩm
        listLTT = serviceLTT.getAll();
        dcbLTT = (DefaultComboBoxModel) this.cbbLoaiSanPham.getModel();
        listCboLTT.add("");
        for (LoaiSanPhamViewModel sp : listLTT) {
            listCboLTT.add(sp.getTen());
        }
        showDataCBO(listCboLTT, dcbLTT);
        //Show data cbb màu sắc
        listMS = serviceMS.getAll();
        dcbMS = (DefaultComboBoxModel) this.cbbLocMauSacc.getModel();
        listCboMS.add("");
        for (MauSacViewModel ms : listMS) {
            listCboMS.add(ms.getTen());
        }
        showDataCBO(listCboMS, dcbMS);
        //Show data cbb Chất Liệu
        listCL = serviceCL.getAll();
        dcbCL = (DefaultComboBoxModel) this.cbbLocChatLieuu.getModel();
        listCboCL.add("");
        for (ChatLieuViewModel cl : listCL) {
            listCboCL.add(cl.getTen());
        }
        showDataCBO(listCboCL, dcbCL);
        //Show data cbb Thương Hiệu
        listTH = serviceTH.getAll();
        dcbTH = (DefaultComboBoxModel) this.cbbLocThuongHieu.getModel();
        listCboTH.add("");
        for (ThuongHieuViewModel th : listTH) {
            listCboTH.add(th.getTen());
        }
        showDataCBO(listCboTH, dcbTH);

        
        showDataHoaDon(listHDTableChuaThanhToan);
        listKhachHang = serviceKhachHang.getList();
        defaultTableModel = (DefaultTableModel) this.tblKhachHang.getModel();
        loadDataTable(serviceKhachHang.getList());
        idKhachHang = khacLe();
        txtMaChuyenKhoan.disable();

        listSPThemGioHang = listSPCT;
        showDataTable(listSPCT);
    }

    private void showDataTable(List<SPCTViewModel> listTable) {
        dtmCTSP.setRowCount(0);
        dtmCTSP = (DefaultTableModel) tblLocSanPham3.getModel();
        for (SPCTViewModel spct : listTable) {
            dtmCTSP.addRow(spct.toRowDataBanHang());
        }
    }

    private void showDataSanPham(List<SanPhamViewModel> listTable) {
        dtmSP.setRowCount(0);
        int soLuongTong = 0;
        for (SanPhamViewModel sp : listTable) {
            for (SanPhamChiTietViewModel spct : listSP) {
                if (sp.getId() == spct.getIdSP()) {
                    sp.setSoLuong(soLuongTong += spct.getSoLuong());
                }
            }
            soLuongTong = 0;
            if (sp.getSoLuong() != 0) {
                listSPXemCT.add(sp);
                dtmSP.addRow(sp.toRowData());
            }

        }

    }

    private int khacLe() {
        for (QLKhachHang kh : listKhachHang) {
            if (kh.getId() == 7) {
                jlbTenKhachHang.setText(kh.getTen());
                jlbSDT.setText(kh.getSdt());
                jlbEmail.setText(kh.getEmail());
                return kh.getId();
            }

        }
        return 7;
    }

    public void loadDataTable(ArrayList<QLKhachHang> listKH) {
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : listKH) {
            defaultTableModel.addRow(new Object[]{kh.getId(),
                kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }

    }

    private void showDataSearch(List<SPCTViewModel> listTable) {
        dtmLoc.setRowCount(0);
        for (SPCTViewModel sPCTViewModel : listTable) {
            dtmLoc.addRow(sPCTViewModel.toRowDataBanHang());
        }
    }

    private void showDataCBO(List<String> lisString, DefaultComboBoxModel cbo) {
        for (String string : lisString) {
            cbo.addElement(string);
        }
    }

    private SanPhamViewModel getSPCT(int index) {
        SanPhamViewModel sp = listSPVM.get(index);
        return sp;
    }

    private SPCTViewModel getSpThemGioHang(int index) {
        SPCTViewModel sp = listSPThemGioHang.get(index);
        return sp;

    }

    private HDCTViewModel sanPhamGioHang(SPCTViewModel spct) {
       HDCTViewModel hdct = new HDCTViewModel();
        hdct.setIdHD(idHD);
        hdct.setIdSPCT(spct.getId());
        hdct.setLoaiSanPham(spct.getLoaiSanPham());
        hdct.setThuongHieu(spct.getThuongHieu());
        hdct.setMauSac(spct.getMauSac());
        hdct.setKichCo(spct.getKichCo());
        hdct.setChatLieu(spct.getChatLieu());
        hdct.setSoLuong(Integer.parseInt(txtSoLuongMua2.getText()));
        hdct.setDonGia(spct.getGiaBan() * Integer.parseInt(txtSoLuongMua2.getText()));
        return hdct;
    }

    private void gioHangTable(List<GioHangViewModel> listGioHang) {
        dtmGioHang.setRowCount(0);
        for (GioHangViewModel hdct : listGioHang) {
            dtmGioHang.addRow(hdct.toRowData());
        }
    }

    private HDViewModel taoHoaDonLe() {
        HDViewModel hd = new HDViewModel();
        int i = listHD.size() - 1;
        hd.setMa("HD" + listHD.get(i).getId());
        hd.setIdNV(idNV);
        hd.setIdKH(7);
        hd.setMaPGG("");
        hd.setNgayTao(Date.valueOf(java.time.LocalDate.now()));
        hd.setNgayThanhToan(Date.valueOf(java.time.LocalDate.now()));
        hd.setTienGiam(Integer.parseInt("0"));
        hd.setTongTien(Integer.parseInt("0"));
        hd.setTienKhachDua(Integer.parseInt("0"));
        hd.setTienThua(Integer.parseInt("0"));
        hd.setTienKhachPhaiTra(Integer.parseInt("0"));
        hd.setHinhThucThanhToan(Integer.parseInt("0"));
        hd.setMaChuyenKhoan("");
        hd.setTrangThai(Integer.parseInt("0"));
        return hd;
    }

    private HDViewModel taoHoaDon() {
        HDViewModel hd = new HDViewModel();
        int i = listHD.size() - 1;
        hd.setMa("HD" + listHD.get(i).getId());
        hd.setIdNV(idNV);
        hd.setIdKH(idKhachHang);
        hd.setMaPGG("");
        hd.setNgayTao(Date.valueOf(java.time.LocalDate.now()));
        hd.setNgayThanhToan(Date.valueOf(java.time.LocalDate.now()));
        hd.setTienGiam(Integer.parseInt("0"));
        hd.setTongTien(Integer.parseInt("0"));
        hd.setTienKhachDua(Integer.parseInt("0"));
        hd.setTienThua(Integer.parseInt("0"));
        hd.setTienKhachPhaiTra(Integer.parseInt("0"));
        hd.setHinhThucThanhToan(Integer.parseInt("0"));
        hd.setMaChuyenKhoan("");
        hd.setTrangThai(Integer.parseInt("0"));
        return hd;
    }

    private void showDataHoaDon(List<HDTableVIewModel> listTable) {
        dtmHD.setRowCount(0);
        for (HDTableVIewModel hd : listTable) {
            dtmHD.addRow(hd.toRowDataHD());
        }
    }

    private HDViewModel xoaHD(int index) {

        HDViewModel hd = listHD.get(index);
        return hd;
    }

    private void layKhachHang(int index) {
        QLKhachHang khachHang = listKhachHang.get(index);
        idKhachHang = khachHang.getId();
        jlbTenKhachHang.setText(khachHang.getTen());
        jlbSDT.setText(khachHang.getSdt());
        jlbEmail.setText(khachHang.getEmail());

    }

    private void layKhachHangLe(int index) {
        QLKhachHang khachHang = listKhachHang.get(index);

        // Check if the id is equal to 9
        if (khachHang.getId() == 7) {
            idKhachHang = khachHang.getId();
            jlbTenKhachHang.setText(khachHang.getTen());
            jlbSDT.setText(khachHang.getSdt());
            jlbEmail.setText(khachHang.getEmail());

        }
    }

//    private HDViewModel getThanhToan() {
//
//        HDViewModel hd = new HDViewModel();
//        hd.setIdKH(idKhachHang);
//        hd.setMaPGG(jlbMaGG.getText());
//        hd.setNgayThanhToan(Date.valueOf(java.time.LocalDate.now()));
//
//        // Kiểm tra và chuyển đổi giá trị từ chuỗi sang số nguyên
//        try {
//            String tienGiamText = jlbTienGiam.getText();
//            hd.setTienGiam(tienGiamText.isEmpty() ? 0 : Integer.parseInt(tienGiamText));
//
//            String tongTienText = jlbTongTien.getText();
//            hd.setTongTien(tongTienText.isEmpty() ? 0 : Integer.parseInt(tongTienText));
//
//            String tienKhachDuaText = txtTienKhachDua.getText();
//            hd.setTienKhachDua(tienKhachDuaText.isEmpty() ? 0 : Integer.parseInt(tienKhachDuaText));
//
//            String tienThuaText = jlbTienThua.getText();
//            hd.setTienThua(tienThuaText.isEmpty() ? 0 : Integer.parseInt(tienThuaText));
//
//            String tienKhachPhaiTraText = jlbKhachPhaiTra.getText();
//            hd.setTienKhachPhaiTra(tienKhachPhaiTraText.isEmpty() ? 0 : Integer.parseInt(tienKhachPhaiTraText));
//        } catch (NumberFormatException e) {
//            // Xử lý nếu có lỗi chuyển đổi
//            e.printStackTrace();
//        }
//
//        if (rdoChuyenKhoan.isSelected()) {
//            hd.setHinhThucThanhToan(0);
//        } else {
//            hd.setHinhThucThanhToan(1);
//        }
//
//        hd.setMaChuyenKhoan(txtMaChuyenKhoan.getText());
//
//        // Kiểm tra và chuyển đổi giá trị từ chuỗi sang số nguyên
//        try {
//            String trangThaiText = "1";
//            hd.setTrangThai(trangThaiText.isEmpty() ? 0 : Integer.parseInt(trangThaiText));
//        } catch (NumberFormatException e) {
//            // Xử lý nếu có lỗi chuyển đổi
//            e.printStackTrace();
//        }
//
//        return hd;
//    }

    private void thanhToanXong() {
        jlbMaHD.setText("MaHD");
        jlbTongTien.setText("0");
        

        jlbTienGiam.setText("0");
        jlbKhachPhaiTra.setText("0");
        txtMaChuyenKhoan.setText("");
        txtTienKhachDua.setText("0");
        jlbTienThua.setText("0");
    }

    private boolean validateThanhToan() {
        if (rdoChuyenKhoan.isSelected()) {
            if (txtMaChuyenKhoan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa có mã chuyển khoản");
                return false;
            }

            // Kiểm tra ký tự đặc biệt trong mã chuyển khoản
            String maChuyenKhoan = txtMaChuyenKhoan.getText().trim();
            // Kiểm tra độ dài của chuỗi (10 đến 20 ký tự)
            if (maChuyenKhoan.isEmpty() || maChuyenKhoan.length() < 10 || maChuyenKhoan.length() > 20) {
                JOptionPane.showMessageDialog(this, "Mã chuyển khoản không hợp lệ, kiểm tra và nhập lại");
                return false;
            }
            if (!maChuyenKhoan.matches("[a-zA-Z0-9]+")) {
                JOptionPane.showMessageDialog(this, "Mã chuyển khoản chứa ký tự không hợp lệ, hãy nhập lại!");
                return false;
            }
        } else if (tongTien == 0) {
            JOptionPane.showMessageDialog(this, "Thanh toán không thành công, chưa chọn hóa đơn hoặc hóa đơn trống\n Vui lòng kiểm tra lại");
            return false;
        } else {
            // Kiểm tra tiền khách đưa
            String tienKhachDuaStr = txtTienKhachDua.getText().trim();
            if (tienKhachDuaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa\n Mời nhập lại!");
                return false;
            }

            if (!tienKhachDuaStr.matches("^\\d*\\.?\\d+$")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa hợp lệ\n Mời nhập lại!");
                return false;
            }

            tienKhachDua = Integer.parseInt(txtTienKhachDua.getText());

            if (tienKhachDua <= 0) {
                JOptionPane.showMessageDialog(this, "Số tiền khách đưa phải lớn hơn 0\n Mời nhập lại!");
                return false;
            }

            if (tienKhachDua < tienKhachPhaiTra) {
                JOptionPane.showMessageDialog(this, "Số tiền khách đưa phải ít nhất bằng tổng tiền cần thanh toán\n Mời nhập lại!");
                return false;
            }
        }

        return true;
    }

    public void Clear() {
        txtTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        buttonGroup1.clearSelection();
        dateNgaySinh.setDate(null);
        cbTrangThai.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jdlLocSanPham = new javax.swing.JDialog();
        dongAddSL = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLocSanPham = new javax.swing.JTable();
        btnThemGioHang = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        txtSoLuongMua = new javax.swing.JTextField();
        jdlUpdateSoLuong = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtSoLuongCapNhat = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jdlKhachHang = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jdlThemKhachHang = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        cbTrangThai = new javax.swing.JCheckBox();
        btnThem = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        cboLocSanPham = new javax.swing.JComboBox<>();
        cboLocKichCo = new javax.swing.JComboBox<>();
        cboLocLTT = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jlbTenKhachHang = new javax.swing.JLabel();
        jlbSDT = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jlbTenNhanVien = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnClearForm = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btnUpdateSoLuong = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
        rdoTienMat = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jlbMaHD = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        jlbTienGiam = new javax.swing.JLabel();
        jlbKhachPhaiTra = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jlbTienThua = new javax.swing.JLabel();
        txtMaChuyenKhoan = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cboPGG = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        dongAddSL3 = new javax.swing.JPanel();
        btnThemGioHang3 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        txtSoLuongMua2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        btnLoc = new javax.swing.JButton();
        cbbLocSanPhamm = new javax.swing.JComboBox<>();
        cbbLocKichCoo = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblLocSanPham3 = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cbbLocMauSacc = new javax.swing.JComboBox<>();
        cbbLocChatLieuu = new javax.swing.JComboBox<>();
        cbbLocThuongHieu = new javax.swing.JComboBox<>();

        jMenuItem1.setText("Thêm vào giỏ hàng");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        dongAddSL.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 51));
        jLabel43.setText("Sản Phẩm ");

        tblLocSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ", "Tên SP", "Thương Hiệu", "Loại TT", "Kích Cỡ", "Màu Sắc ", "Số Lượng ", "Giá "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblLocSanPham);

        btnThemGioHang.setBackground(new java.awt.Color(255, 255, 204));
        btnThemGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemGioHang.setForeground(new java.awt.Color(0, 153, 51));
        btnThemGioHang.setText("Thêm Giỏ Hàng");
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Số Lượng Mua:");

        txtSoLuongMua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongMua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSoLuongMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongMuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dongAddSLLayout = new javax.swing.GroupLayout(dongAddSL);
        dongAddSL.setLayout(dongAddSLLayout);
        dongAddSLLayout.setHorizontalGroup(
            dongAddSLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dongAddSLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(17, 17, 17)
                .addComponent(txtSoLuongMua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        dongAddSLLayout.setVerticalGroup(
            dongAddSLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dongAddSLLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(dongAddSLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(txtSoLuongMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlLocSanPhamLayout = new javax.swing.GroupLayout(jdlLocSanPham.getContentPane());
        jdlLocSanPham.getContentPane().setLayout(jdlLocSanPhamLayout);
        jdlLocSanPhamLayout.setHorizontalGroup(
            jdlLocSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dongAddSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdlLocSanPhamLayout.setVerticalGroup(
            jdlLocSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dongAddSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("Số Lượng : ");

        txtSoLuongCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoLuongCapNhat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuongCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtSoLuongCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jdlUpdateSoLuongLayout = new javax.swing.GroupLayout(jdlUpdateSoLuong.getContentPane());
        jdlUpdateSoLuong.getContentPane().setLayout(jdlUpdateSoLuongLayout);
        jdlUpdateSoLuongLayout.setHorizontalGroup(
            jdlUpdateSoLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlUpdateSoLuongLayout.setVerticalGroup(
            jdlUpdateSoLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Họ tên", "Email", "SDT", "Giới tính", "Ngày sinh", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhachHang);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 0, 51));
        jLabel46.setText(" Khách Hàng ");

        jButton12.setBackground(new java.awt.Color(255, 255, 204));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 153, 51));
        jButton12.setText("Chọn");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Họ Tên", "Email", "SDT" }));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jdlKhachHangLayout = new javax.swing.GroupLayout(jdlKhachHang.getContentPane());
        jdlKhachHang.getContentPane().setLayout(jdlKhachHangLayout);
        jdlKhachHangLayout.setHorizontalGroup(
            jdlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdlKhachHangLayout.setVerticalGroup(
            jdlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Mã");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Email");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Họ tên");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setText("Giới tính");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Ngày sinh");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Địa Chỉ");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("Số điện thoại");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setText("Trạng thái");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMa.setEnabled(false);

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        rdNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNam.setText("Nam");

        rdNu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNu.setText("Nữ");

        dateNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dateNgaySinh.setDateFormatString("yyyy-MM-dd");

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTrangThai.setSelected(true);
        cbTrangThai.setText("Đã thanh toán");
        cbTrangThai.setEnabled(false);

        btnThem.setBackground(new java.awt.Color(255, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem.setText("Thêm khách hàng ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(jLabel24)
                                    .addComponent(txtTen))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel52)
                                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu)))))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btnThem)
                .addGap(0, 173, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTrangThai))
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdlThemKhachHangLayout = new javax.swing.GroupLayout(jdlThemKhachHang.getContentPane());
        jdlThemKhachHang.getContentPane().setLayout(jdlThemKhachHangLayout);
        jdlThemKhachHangLayout.setHorizontalGroup(
            jdlThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlThemKhachHangLayout.setVerticalGroup(
            jdlThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText(" Lọc và tìm kiếm sản phẩm");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Sản phẩm");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Kích cỡ");

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        jButton5.setText("Chọn sản phẩm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Loại TT ");

        cboLocSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocSanPhamActionPerformed(evt);
            }
        });

        cboLocKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocKichCoActionPerformed(evt);
            }
        });

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Loại Sản Phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/qrcode (1).jpg"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel41)
                                .addGap(38, 38, 38)
                                .addComponent(cboLocLTT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41)
                                .addComponent(cboLocLTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
            .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        result_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        result_field.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        result_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                result_fieldMouseEntered(evt);
            }
        });
        result_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_fieldActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 0, 51));
        jLabel42.setText("Mã Vạch SP");

        jPanel8.setBackground(new java.awt.Color(250, 250, 250));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Chon SP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setToolTipText("");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách sản phẩm");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Thông tin ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("SDT: ");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm KH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email :");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 255));
        jLabel10.setText("Nhân viên");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Danh sách");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 0, 255));
        jLabel22.setText("Khách hàng ");

        jlbTenKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTenKhachHang.setText("Tên khách hàng");

        jlbSDT.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbSDT.setText("Số điện thoại");

        jlbEmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbEmail.setText("Email ");

        jlbTenNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTenNhanVien.setText("Tên nhân viên");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Tên: ");

        btnClearForm.setBackground(new java.awt.Color(0, 0, 0));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-available-updates-20 (1).png"))); // NOI18N
        btnClearForm.setText("Clear");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jlbEmail, jlbSDT, jlbTenKhachHang, jlbTenNhanVien});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel22)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlbTenKhachHang)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlbSDT))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlbEmail)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTenNhanVien)
                            .addComponent(jLabel35)))
                    .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jlbEmail, jlbSDT, jlbTenKhachHang, jlbTenNhanVien});

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Hóa đơn ");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel3.setToolTipText("");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày Tạo", "Nhân Viên", "Khách Hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel40.setText("Hóa đơn chờ ");

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 0, 0));
        btnTaoHoaDon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuyHoaDon.setBackground(new java.awt.Color(0, 0, 0));
        btnHuyHoaDon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel39.setText("Giỏ Hàng");

        btnUpdateSoLuong.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateSoLuong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdateSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSoLuong.setText("Sửa số lượng");
        btnUpdateSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSoLuongActionPerformed(evt);
            }
        });

        btnXoaSanPham.setBackground(new java.awt.Color(0, 0, 0));
        btnXoaSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        tblGioHang.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên SP", "Loại Sản Phẩm", "Thương Hiệu", "Màu Sắc", "Kích Cỡ", "Chất Liệu", "Số Lượng", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jLabel39)
                    .addComponent(btnUpdateSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Hóa đơn thanh toán");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText(" Mã               ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã giảm giá ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền      ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tổng tiền giảm");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Khách phải trả");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Tiền khách đưa");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Tiền thừa");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Hình thức TT");

        buttonGroup1.add(rdoChuyenKhoan);
        rdoChuyenKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChuyenKhoan.setText("Chuyển khoản");
        rdoChuyenKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChuyenKhoanMouseClicked(evt);
            }
        });
        rdoChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuyenKhoanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTienMat);
        rdoTienMat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoTienMat.setSelected(true);
        rdoTienMat.setText("Tiền mặt");
        rdoTienMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTienMatMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Mã chuyển khoản");

        jlbMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaHD.setText("Mã HD");

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTongTien.setText("0");
        jlbTongTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbTongTienMouseEntered(evt);
            }
        });

        jlbTienGiam.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTienGiam.setForeground(new java.awt.Color(51, 0, 255));
        jlbTienGiam.setText("0");

        jlbKhachPhaiTra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlbKhachPhaiTra.setForeground(new java.awt.Color(255, 0, 0));
        jlbKhachPhaiTra.setText("0");

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 51)));
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseEntered(evt);
            }
        });
        txtTienKhachDua.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTienKhachDuaInputMethodTextChanged(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jlbTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienThua.setText("0");
        jlbTienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlbTienThuaKeyPressed(evt);
            }
        });

        txtMaChuyenKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaChuyenKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 0)));
        txtMaChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChuyenKhoanActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(255, 0, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("VNĐ");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 0, 255));
        jLabel26.setText("VNĐ");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("VNĐ");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("VNĐ");

        cboPGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPGGActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Giá Trị( %)");

        txtGiaTri.setEditable(false);
        txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel19))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaChuyenKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel29))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32))
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThanhToan))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtGiaTri, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboPGG, javax.swing.GroupLayout.Alignment.LEADING, 0, 119, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jlbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoChuyenKhoan)
                                    .addComponent(rdoTienMat)
                                    .addComponent(jlbKhachPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlbMaHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlbTongTien)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboPGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jlbTienGiam)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jlbKhachPhaiTra)
                    .addComponent(jLabel29))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(rdoTienMat))
                .addGap(15, 15, 15)
                .addComponent(rdoChuyenKhoan)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jlbTienThua)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        dongAddSL3.setBackground(new java.awt.Color(255, 255, 255));
        dongAddSL3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        btnThemGioHang3.setBackground(new java.awt.Color(0, 0, 0));
        btnThemGioHang3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemGioHang3.setForeground(new java.awt.Color(255, 255, 255));
        btnThemGioHang3.setText("Thêm Giỏ Hàng");
        btnThemGioHang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHang3ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Số Lượng");

        txtSoLuongMua2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongMua2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSoLuongMua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongMua2ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/qrcode (1).jpg"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btnLoc.setBackground(new java.awt.Color(0, 0, 0));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        cbbLocSanPhamm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocSanPhammActionPerformed(evt);
            }
        });

        cbbLocKichCoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocKichCooActionPerformed(evt);
            }
        });

        jLabel36.setText("Kích Cỡ");

        jLabel53.setText("Tên SP");

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Hoàn Tác");
        jButton6.setToolTipText("");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cbbLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel45.setText("Loại Sản Phẩm");

        tblLocSanPham3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Tên SP", "Loại Sản Phẩm", "Thương Hiệu", "Màu Sắc", "Kích Cỡ", "Chất Liệu", "Số Lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblLocSanPham3);

        jLabel54.setText("Màu Sắc");

        jLabel47.setText("Chất Liệu");

        jLabel55.setText("Thương Hiệu");

        cbbLocMauSacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocMauSaccActionPerformed(evt);
            }
        });

        cbbLocChatLieuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocChatLieuuActionPerformed(evt);
            }
        });

        cbbLocThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocThuongHieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dongAddSL3Layout = new javax.swing.GroupLayout(dongAddSL3);
        dongAddSL3.setLayout(dongAddSL3Layout);
        dongAddSL3Layout.setHorizontalGroup(
            dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dongAddSL3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addComponent(cbbLocMauSacc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuongMua2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemGioHang3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addComponent(cbbLocSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnLoc)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLoc, jButton6});

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel36, jLabel45, jLabel53});

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbLoaiSanPham, cbbLocKichCoo, cbbLocSanPhamm});

        dongAddSL3Layout.setVerticalGroup(
            dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dongAddSL3Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addGap(10, 10, 10)
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(txtSoLuongMua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemGioHang3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)))
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLocMauSacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbLoaiSanPham, cbbLocKichCoo, cbbLocSanPhamm});

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLoc, jButton6});

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel36, jLabel45, jLabel53});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dongAddSL3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dongAddSL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel4});

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setBackground(new java.awt.Color(0, 0, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_white.png"))); // NOI18N
        jdlThemKhachHang.setSize(500, 400);
        jdlThemKhachHang.setResizable(false);
        jdlThemKhachHang.setLocationRelativeTo(null);
        jdlThemKhachHang.setVisible(true);
        int index = listKhachHang.size() - 1;
        txtMa.setText(String.valueOf("KH" + listKhachHang.get(index).getId()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed

        HDViewModel hd = taoHoaDon();

        for (QLKhachHang kh : listKhachHang) {
            if (kh.getId() == hd.getIdKH() && kh.getTrangThai() == 0 && kh.getId() != 7) {
                System.out.println(kh.getId()+ " abc " +  hd.getIdKH());
                JOptionPane.showMessageDialog(this, "Khách hàng đã có hóa đơn chờ");
                return;
            }

        }
        JOptionPane.showMessageDialog(this, serviceHD.getAdd(hd));
        jlbMaHD.setText(hd.getMa());
        listHDTable = serviceHDTable.getAll();
        if (idKhachHang != 7) {
            serviceKhachHang.khachHangTaoHD(idKhachHang);
        }

        listHD = serviceHD.getAll();
        for (HDViewModel hdid : listHD) {
            if (hdid.getMa().trim().equals(hd.getMa())) {
                idHD = hdid.getId();
                maHD = hdid.getMa();
            }
        }
        listKhachHang = serviceKhachHang.getList();
        loadDataTable(serviceKhachHang.getList());
        listHDTableChuaThanhToan = new ArrayList<>();
        for (HDTableVIewModel hdctt : listHDTable) {
            if (hdctt.getTrangThai().trim().equals("0")) {
                listHDTableChuaThanhToan.add(hdctt);
            }
        }
        showDataHoaDon(listHDTableChuaThanhToan);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jdlLocSanPham.setSize(850, 250);
        jdlLocSanPham.setResizable(false);
        jdlLocSanPham.setLocationRelativeTo(null);
        jdlLocSanPham.setVisible(true);
        txtSoLuongMua2.setText("0");
        int index = tblSanPham.getSelectedRow();
        SanPhamViewModel sp = listSPXemCT.get(index);
        List<SPCTViewModel> listChiTiet = new ArrayList<>();
        for (SPCTViewModel spct : listSPCT) {
            if (spct.getLoaiSanPham().equals(sp.getTen())) {
                listChiTiet.add(spct);
            }
        }
        listSPCT = listChiTiet;
        showDataSearch(listSPCT);
        listSPThemGioHang = listSPCT;
        listSPCT = serviceSPCT.getAllTable();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        jButton12.setText("Chọn");
        jdlKhachHang.setSize(900, 300);
        jdlKhachHang.setResizable(false);
        jdlKhachHang.setLocationRelativeTo(null);
        jdlKhachHang.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int index = tblKhachHang.getSelectedRow();

        int id = (int) tblKhachHang.getValueAt(index, 0);

    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed

        int index = tblHoaDon.getSelectedRow();
        if (index >= 0 && index <= listHD.size()) {
            //lấy sản phẩm trong hóa đơn
            int sul = JOptionPane.showConfirmDialog(this, "Có muốn xóa hóa đơn không ?");
            if (sul == 0) {
                listSPInHD = new ArrayList<>();
                for (GioHangViewModel gh : listSpGiohang) {
                    if (gh.getMaHD().equals(maHD)) {
                        listSPInHD.add(gh);
                    }
                }
                int soLuongSanPhamXoa = 0;
                int soLuongSanPham = 0;
                int idSpCapNhap = 0;

                for (GioHangViewModel ghxoa : listSPInHD) {
                    //san phảm cập nhập số lượng
                    soLuongSanPhamXoa = ghxoa.getSoLuong();
                    for (HDCTViewModel sp : listGioHang) {
                        if (sp.getId() == ghxoa.getId()) {
                            for (SPCTViewModel spct : listSPCT) {
                                if (spct.getId() == sp.getIdSPCT()) {
                                    soLuongSanPham = spct.getSoLuong();
                                    idSpCapNhap = spct.getId();
                                }
                            }
                        }
                    }
                    serviceSPCT.getUpdateSLMua(soLuongSanPham + soLuongSanPhamXoa, idSpCapNhap);
                    listSPCT = serviceSPCT.getAllTable();
                    listSP = serviceSPCT.getAll();
                    listSPVM = serviceSp.getAll();
                    showDataSanPham(listSPVM);
                    showDataSearch(listSPCT);
                    // Xoa san phẩm
                    serviceGioHang.getDelete(ghxoa.getId());

                }
                listGioHang = serviceGioHang.getAll();
                //Xóa hóa đơn
                HDViewModel hd = xoaHD(index);
                JOptionPane.showMessageDialog(this, serviceHD.getDelete(idHD));
                listHDTable = serviceHDTable.getAll();
                listHD = serviceHD.getAll();
                listHDTableChuaThanhToan = new ArrayList<>();
                for (HDTableVIewModel hdctt : listHDTable) {
                    if (hdctt.getTrangThai().trim().equals("0")) {
                        listHDTableChuaThanhToan.add(hdctt);
                    }
                }
                showDataHoaDon(listHDTableChuaThanhToan);

            } else {
//                JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
                return;
            }
        }
        serviceKhachHang.khachHangThanhToanHD(idKhachHang);
        listKhachHang = serviceKhachHang.getList();
        loadDataTable(serviceKhachHang.getList());
        khacLe();
        //Cập nhập lại tổng tiền và giỏ hàng
        listSpGiohang = serviceGioHang.getGioHang();
        listSPInHD = new ArrayList<>();
        listGioHang = serviceGioHang.getAll();
        int tongTien = 0;
        for (GioHangViewModel gh : listSpGiohang) {
            if (gh.getMaHD().equals(maHD)) {
                listSPInHD.add(gh);
                tongTien += gh.getDonGia();
            }
        }
        jlbTongTien.setText(String.valueOf(tongTien));
        jlbTienGiam.setText(String.valueOf(tienPGG + tienQuyDoi));
        jlbKhachPhaiTra.setText(String.valueOf(0));
        gioHangTable(listSPInHD);
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int index = tblKhachHang.getSelectedRow();
        if (index >= 0 & index <= listKhachHang.size()) {
            QLKhachHang khachHang = listKhachHang.get(index);
            if (khachHang.getTrangThai() == 0 && khachHang.getId() != 7) {
                JOptionPane.showMessageDialog(this, "Khách hàng đã có hóa đơn chờ");
            } else {
                layKhachHang(index);
            }

            jdlKhachHang.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        listSPInHD = new ArrayList<>();
        HDTableVIewModel hd = listHDTableChuaThanhToan.get(index);
        tongTien = 0;
        idHD = hd.getId();
        maHD = hd.getMa();
        jlbMaHD.setText(maHD);
        for (GioHangViewModel gh : listSpGiohang) {
            if (gh.getMaHD().trim().equals(hd.getMa())) {
                listSPInHD.add(gh);
                tongTien += gh.getDonGia();
            }
        }

        jlbTongTien.setText(String.valueOf(tongTien));

        if (tienGiam > tongTien) {
            tienGiam = 0;
            jlbTienGiam.setText(String.valueOf(tienGiam));
        } else {
            tienGiam = tienPGG + tienQuyDoi;
            jlbTienGiam.setText(String.valueOf(tienGiam));

        }
        tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
        jlbKhachPhaiTra.setText(String.valueOf(tienKhachPhaiTra));
        txtTienKhachDua.setText("");
        jlbTienThua.setText("");
        txtMaChuyenKhoan.setText("");

        for (QLKhachHang kh : listKhachHang) {
            if (hd.getTenKhachHang().trim().equals(kh.getTen())) {
                idKhachHang = kh.getId();
                jlbTenKhachHang.setText(kh.getTen());
                jlbSDT.setText(kh.getSdt());
                jlbEmail.setText(kh.getEmail());

            }
        }
        for (QLNhanVien nv : listnhanVien) {
            if (hd.getTenNhanVien().trim().equals(nv.getTen())) {
                jlbTenNhanVien.setText(nv.getTen());
            }

        }
        gioHangTable(listSPInHD);
    }//GEN-LAST:event_tblHoaDonMouseClicked



    private void btnUpdateSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSoLuongActionPerformed
        int index = tblGioHang.getSelectedRow();
        if (index >= 0 && index < listSPInHD.size()) {
            GioHangViewModel gh = listSPInHD.get(index);
//
//            txtSoLuongCapNhat.setText(String.valueOf(gh.getSoLuong()));
            jdlUpdateSoLuong.setSize(400, 150);
            jdlUpdateSoLuong.setResizable(false);
            jdlUpdateSoLuong.setLocationRelativeTo(null);
            jdlUpdateSoLuong.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");

        }

    }//GEN-LAST:event_btnUpdateSoLuongActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        listSPInHD = new ArrayList<>();
        for (GioHangViewModel gh : listSpGiohang) {
            if (gh.getMaHD().equals(maHD)) {
                listSPInHD.add(gh);
            }
        }
        int soLuongSanPhamXoa = 0;
        int soLuongSanPham = 0;
        int idSpCapNhap = 0;
        int index = tblGioHang.getSelectedRow();
        if (index >= 0 && index <= listSPInHD.size()) {
            GioHangViewModel gh = listSPInHD.get(index);
            soLuongSanPhamXoa = gh.getSoLuong();
            for (HDCTViewModel sp : listGioHang) {
                if (sp.getId() == gh.getId()) {
                    for (SPCTViewModel spct : listSPCT) {
                        if (spct.getId() == sp.getIdSPCT()) {
                            soLuongSanPham = spct.getSoLuong();
                            idSpCapNhap = spct.getId();
                        }
                    }
                }
            }
            int sul = JOptionPane.showConfirmDialog(this, "Có muốn xóa sản phẩm không?");
            if (sul == 0) {
                JOptionPane.showMessageDialog(this, serviceGioHang.getDelete(gh.getId()));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }

        serviceSPCT.getUpdateSLMua(soLuongSanPham + soLuongSanPhamXoa, idSpCapNhap);
        listSPCT = serviceSPCT.getAllTable();
        listSP = serviceSPCT.getAll();
        listSPVM = serviceSp.getAll();
        showDataSanPham(listSPVM);
        showDataSearch(listSPCT);

        listSpGiohang = serviceGioHang.getGioHang();
        listSPInHD = new ArrayList<>();
        listGioHang = serviceGioHang.getAll();
        tongTien = 0;
        for (GioHangViewModel gh : listSpGiohang) {
            if (gh.getMaHD().equals(maHD)) {
                listSPInHD.add(gh);
                tongTien += gh.getDonGia();
            }
        }

        jlbTongTien.setText(String.valueOf(tongTien));
        tienGiam = tienPGG + tienQuyDoi;
        jlbTienGiam.setText(String.valueOf(tienGiam));
        tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
        jlbKhachPhaiTra.setText(String.valueOf(tienKhachPhaiTra));

        gioHangTable(listSPInHD);

    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int index = tblGioHang.getSelectedRow();

        if (index >= 0 && index < listSPInHD.size()) {
            GioHangViewModel gh = listSPInHD.get(index);
            jdlUpdateSoLuong.dispose();
            try {
                // Lấy giá trị từ JTextField
                int soLuongNhap = Integer.parseInt(txtSoLuongCapNhat.getText());

                // Kiểm tra xem số lượng có âm không
                if (soLuongNhap < 0 || soLuongNhap == 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng không âm  ");

                } else {
                    int soLuongSanPhamXoa = 0;
                    int soLuongSanPham = 0;
                    int idSpCapNhap = 0;
                    soLuongSanPhamXoa = gh.getSoLuong();
                    for (HDCTViewModel sp : listGioHang) {
                        if (sp.getId() == gh.getId()) {
                            for (SPCTViewModel spct : listSPCT) {
                                if (spct.getId() == sp.getIdSPCT()) {
                                    soLuongSanPham = spct.getSoLuong();
                                    idSpCapNhap = spct.getId();
                                }
                            }
                        }
                    }

                    int soLuongbd = gh.getSoLuong();
                    int soLuong = Integer.parseInt(txtSoLuongCapNhat.getText());
                    float donGia = soLuong * (gh.getDonGia() / soLuongbd);
                    int soluongmoi =0;
                    soluongmoi = soLuongSanPham + soLuongSanPhamXoa - soLuong;
                    if(soluongmoi <0){
                        JOptionPane.showMessageDialog(this, "Số lượng vượt quá số lượng còn lại  ");
                        return;
                    }
                    serviceSPCT.getUpdateSLMua(soLuongSanPham + soLuongSanPhamXoa - soLuong, idSpCapNhap);
                   
                    listSPCT = serviceSPCT.getAllTable();
                    listSP = serviceSPCT.getAll();
                    listSPVM = serviceSp.getAll();
                    showDataSanPham(listSPVM);
                    showDataSearch(listSPCT);

                    JOptionPane.showMessageDialog(this, serviceGioHang.getUpdateSoLuong(gh.getId(), soLuong, donGia));

                    listGioHang = serviceGioHang.getAll();
                    listSpGiohang = serviceGioHang.getGioHang();

                    tongTien = 0;
                    listSPInHD = new ArrayList<>();
                    for (GioHangViewModel gh1 : listSpGiohang) {
                        if (gh1.getMaHD().equals(maHD)) {
                            listSPInHD.add(gh1);
                            tongTien += gh1.getDonGia();
                        }
                    }
                    gioHangTable(listSPInHD);
                    jlbTongTien.setText(String.valueOf(tongTien));
                    tienGiam = tienPGG + tienQuyDoi;
                    jlbTienGiam.setText(String.valueOf(tienGiam));
                    tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
                    jlbKhachPhaiTra.setText(String.valueOf(tienKhachPhaiTra));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jlbTongTienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTongTienMouseEntered

    }//GEN-LAST:event_jlbTongTienMouseEntered

    private void txtTienKhachDuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseEntered

    }//GEN-LAST:event_txtTienKhachDuaMouseEntered

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
        String pattern = "[1-9][0-9]*";
        if (!txtTienKhachDua.getText().matches(pattern) || txtTienKhachDua.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thông tin điền sai");
            tienKhachDua = 0;
        } else if (!txtTienKhachDua.getText().equals("")) {
            tienKhachDua = Integer.parseInt(txtTienKhachDua.getText());

        }

        tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
        tienThua = tienKhachDua - tienKhachPhaiTra;
        jlbTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate

    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

//        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán?");
//        if (choice == JOptionPane.NO_OPTION) {
//            // Người dùng đã chọn "No", thực hiện các hành động tương ứng ở đây
//            // Ví dụ: không thanh toán
////            JOptionPane.showMessageDialog(this, "Thanh toán thất bại người dùng Chọn No !");
//            return;
//        } else if (choice == JOptionPane.YES_OPTION) {
//            // Người dùng đã chọn "Yes", thực hiện các hành động tương ứng ở đây
//            // Ví dụ: thanh toán
//            if (validateThanhToan()) {
//                HDViewModel hdTT = getThanhToan();
//                JOptionPane.showMessageDialog(this, serviceHD.getThanhToan(hdTT, idHD));
//                for (HDViewModel hd : listHD) {
//                    if (hd.getId() == idHD) {
//                        for (QLKhachHang kh : listKhachHang) {
//                            if (kh.getId() == hd.getIdKH()) {
//                                if (kh.getId() != khacLe()) {
//
//                                }
//                                thanhToanXong();
//                            }
//                        }
//                    }
//
//                }
//                if (idKhachHang != 7) {
//                    serviceKhachHang.khachHangThanhToanHD(idKhachHang);
//                }
//                listKhachHang = serviceKhachHang.getList();
//                loadDataTable(serviceKhachHang.getList());
//                listHD = serviceHD.getAll();
//                listHDTable = serviceHDTable.getAll();
//                listHDTableChuaThanhToan = new ArrayList<>();
//                for (HDTableVIewModel hdctt : listHDTable) {
//                    if (hdctt.getTrangThai().trim().equals("0")) {
//                        listHDTableChuaThanhToan.add(hdctt);
//                    }
//                }
//                showDataHoaDon(listHDTableChuaThanhToan);
//                listBangTichDiem = serviceBangTichDiem.getList();
//                listKhachHang = serviceKhachHang.getList();
//                listSPInHD = new ArrayList<>();
//                gioHangTable(listSPInHD);
//                //print
//
//            }
//        } else if (choice == JOptionPane.CANCEL_OPTION) {
//            // Người dùng đã chọn "Cancel", thực hiện các hành động tương ứng ở đây
//            // Ví dụ: hủy bỏ hành động
////            JOptionPane.showMessageDialog(this, "Thanh toán thất bại người dùng Chọn Cencel !");
//            return;
//        } else {
//            // Người dùng đã đóng hộp thoại hoặc nhấn nút đóng, xử lý tương ứng ở đây
//            JOptionPane.showMessageDialog(this, "Thanh toán thất bại người dùng Chọn X ");
//        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private boolean validateThem() {


        if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
                || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thông tin không để trống");
            return false;
        }

        // Kiểm tra số điện thoại
        String sdt = txtSDT.getText().trim();
        if (sdt.length() != 10 || !sdt.startsWith("0") || !sdt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return false;
        }

        // Kiểm tra email
        String email = txtEmail.getText().trim();
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            return false;
        }

        for (QLKhachHang kh : listKhachHang) {
            if (txtMa.getText().trim().equals(kh.getMa())) {
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
                return false;
            }
        }
        return true;
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang kh = new KhachHang();
        if (validateThem()) {
            kh.setMa(txtMa.getText().trim());
            kh.setTen(txtTen.getText().trim());
            kh.setEmail(txtEmail.getText().trim());
            kh.setSdt(txtSDT.getText().trim());
            int gioiTinh = 0;
            if (rdNam.isSelected() == true) {
                gioiTinh = 1;
            }
            kh.setGioiTinh(gioiTinh);
            kh.setNgaySinh(dateNgaySinh.getDate());
            kh.setDiaChi(txtDiaChi.getText().trim());
            int trangThai = 0;
            if (cbTrangThai.isSelected() == true) {
                trangThai = 1;
            }
            kh.setTrangThai(trangThai);
            serviceKhachHang.Them(kh);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataTable(serviceKhachHang.getList());
            int id = 0;
            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
                if (txtMa.getText().equalsIgnoreCase(tblKhachHang.getValueAt(i, 1).toString())) {
                    id = (int) tblKhachHang.getValueAt(i, 0);
                }
            }
            listKhachHang = serviceKhachHang.getList();

            Clear();
        }

    }//GEN-LAST:event_btnThemActionPerformed

    public void TimTheoMa() {
        String ma = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoMa(ma)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoTen() {
        String ten = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoTen(ten)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoEmail() {
        String email = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoEmail(email)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoSDT() {
        String sdt = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoSDT(sdt)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (jComboBox1.getSelectedItem().equals("Mã")) {
            TimTheoMa();
        } else if (jComboBox1.getSelectedItem().equals("Họ Tên")) {
            TimTheoTen();
        } else if (jComboBox1.getSelectedItem().equals("Email")) {
            TimTheoEmail();
        } else if (jComboBox1.getSelectedItem().equals("SDT")) {
            TimTheoSDT();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtMaChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChuyenKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChuyenKhoanActionPerformed

    private void txtTienKhachDuaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienKhachDuaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaInputMethodTextChanged

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void rdoChuyenKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.enable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.disable();
        txtTienKhachDua.repaint();
        jlbTienThua.setText("");

    }//GEN-LAST:event_rdoChuyenKhoanMouseClicked

    private void rdoTienMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTienMatMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.disable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.enable();
        txtTienKhachDua.repaint();
        txtMaChuyenKhoan.setText("");
    }//GEN-LAST:event_rdoTienMatMouseClicked

    private void jlbTienThuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbTienThuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbTienThuaKeyPressed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        // TODO add your handling code here:

        String pattern = "[1-9][0-9]*";
        if (!txtTienKhachDua.getText().matches(pattern) || txtTienKhachDua.getText().equals("")) {
            jlbTienThua.setText("");
        } else if (!txtTienKhachDua.getText().equals("")) {
            tienKhachDua = Integer.parseInt(txtTienKhachDua.getText());
            tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
            tienGiam = tienPGG + tienQuyDoi;
            jlbTienGiam.setText(String.valueOf(tienGiam));
            jlbKhachPhaiTra.setText(String.valueOf(tongTien - (tienPGG + tienQuyDoi)));

            tienThua = tienKhachDua - tienKhachPhaiTra;
            jlbTienThua.setText(String.valueOf(tienThua));

        }

    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void rdoChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChuyenKhoanActionPerformed

    private void btnThemGioHang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHang3ActionPerformed
        // TODO add your handling code here:

        int index = tblLocSanPham3.getSelectedRow();

if (index == -1) {
    JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm");
} else {
    String slnhap = txtSoLuongMua2.getText().trim();
    if (slnhap.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");
        return;
    }

    try {
        int soLuongNhap = Integer.parseInt(slnhap);

        if (index >= 0 && index < listSPThemGioHang.size()) {
            SPCTViewModel spct = getSpThemGioHang(index);

            if (soLuongNhap > spct.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm mua vượt quá số lượng tồn tại");
            } else if (soLuongNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập vào không hợp lệ");
            } else {
                HDCTViewModel gioHang = sanPhamGioHang(spct);
                if (gioHang.getIdHD() == 0) {
                    JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
                } else {
                    for (HDCTViewModel hdct : listGioHang) {
                        if (hdct.getIdHD() == gioHang.getIdHD() && hdct.getIdSPCT() == gioHang.getIdSPCT()) {
                            JOptionPane.showMessageDialog(this, "Giỏ hàng đã tồn tại sản phẩm");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, serviceGioHang.getAdd(gioHang));

                    int soLuongThayDoi = spct.getSoLuong() - soLuongNhap;
                    int idSoLuongThayDoi = spct.getId();
                    serviceSPCT.getUpdateSLMua(soLuongThayDoi, idSoLuongThayDoi);
                    listSPCT = serviceSPCT.getAllTable();
                    listSP = serviceSPCT.getAll();
                    listSPVM = serviceSp.getAll();
                    showDataSanPham(listSPVM);
                    showDataSearch(listSPCT);

                    listGioHang = serviceGioHang.getAll();
                    listSpGiohang = serviceGioHang.getGioHang();

                    int tongTien = 0;
                    listSPInHD = new ArrayList<>();
                    for (GioHangViewModel gh : listSpGiohang) {
                        if (gh.getMaHD().equals(maHD)) {
                            listSPInHD.add(gh);
                            tongTien += gh.getDonGia();
                        }
                    }
                    jlbTongTien.setText(String.valueOf(tongTien));
                    jlbTienGiam.setText(String.valueOf(tienPGG + tienQuyDoi));
                    tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
                    jlbKhachPhaiTra.setText(String.valueOf(tienKhachPhaiTra));
                    gioHangTable(listSPInHD);
                    spct.setSoLuong(soLuongThayDoi);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ");
    }
}


    }//GEN-LAST:event_btnThemGioHang3ActionPerformed

    private void txtSoLuongMua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongMua2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongMua2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        btnThemGioHang3.setBackground(new java.awt.Color(0, 0, 0));
        btnThemGioHang3.setForeground(new java.awt.Color(255, 255, 255));
        btnThemGioHang3.setText("Thêm vào Giỏ");
        jDialog1.setSize(490, 410);
        jDialog1.setResizable(false);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
        jdlLocSanPham.setVisible(false);

        initWebcam();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered

    }//GEN-LAST:event_tblSanPhamMouseEntered

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = tblSanPham.rowAtPoint(evt.getPoint());
            if (row >= 0 && row < listSPCT.size()) {
                tblSanPham.setRowSelectionInterval(row, row);
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        int row = tblSanPham.getSelectedRow();
        String tenSP = tblSanPham.getValueAt(row, 1).toString();
        cboLocSanPham.setSelectedItem(tenSP);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cboLocKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocKichCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocKichCoActionPerformed

    private void cboLocSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocSanPhamActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //  TODO add your handling code here:
//        btnThemGioHang.setBackground(new java.awt.Color(0, 0, 0));
//        btnThemGioHang.setForeground(new java.awt.Color(255, 255, 255));
//        txtSoLuongMua.setText("0");
//        List<SPCTViewModel> listLoc = new ArrayList<>();
//        for (SPCTViewModel spct : listSPCT) {
//            if (cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham()) && cboLocKichCo.getSelectedItem().equals(spct.getKichCo()) && cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham()) && cboLocKichCo.getSelectedItem().equals("") && cboLocLTT.getSelectedItem().equals("")) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham()) && cboLocKichCo.getSelectedItem().equals(spct.getKichCo()) && cboLocLTT.getSelectedItem().equals("")) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham()) && cboLocKichCo.getSelectedItem().equals("") && cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals("") && cboLocKichCo.getSelectedItem().equals(spct.getKichCo()) && cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals("") && cboLocKichCo.getSelectedItem().equals(spct.getKichCo()) && cboLocLTT.getSelectedItem().equals("")) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals("") && cboLocKichCo.getSelectedItem().equals("") && cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())) {
//                listLoc.add(spct);
//            } else if (cboLocSanPham.getSelectedItem().equals("") && cboLocKichCo.getSelectedItem().equals("") && cboLocLTT.getSelectedItem().equals("")) {
//                listLoc = listSPCT;
//            }
//        }
//        jdlLocSanPham.setSize(850, 250);
//        jdlLocSanPham.setResizable(false);
//        jdlLocSanPham.setLocationRelativeTo(null);
//        // jdlLocSanPham.setVisible(true);
//        listSPCT = listLoc;
//        listSPThemGioHang = listSPCT;
//        showDataSearch(listSPCT);
//        listSPCT = serviceSPCT.getAllTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtSoLuongMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongMuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongMuaActionPerformed

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        int index = tblLocSanPham.getSelectedRow();
        if (index >= 0 && index <= listSPThemGioHang.size()) {
            SPCTViewModel spct = getSpThemGioHang(index);
            jdlLocSanPham.dispose();
            if (Integer.parseInt(txtSoLuongMua.getText()) > spct.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm mua không dủ");
            } else if (Integer.parseInt(txtSoLuongMua.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Chưa nhập só lượng sản phẩm");
            } else {

                HDCTViewModel gioHang = sanPhamGioHang(spct);
                if (gioHang.getIdHD() == 0) {
                    JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
                } else {
                    for (HDCTViewModel hdct : listGioHang) {
                        if (hdct.getIdHD() == gioHang.getIdHD() && hdct.getIdSPCT() == gioHang.getIdSPCT()) {
                            JOptionPane.showMessageDialog(this, "Giỏ hàng đã tồn tại sản phẩm");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, serviceGioHang.getAdd(gioHang));
                }

                int soLuongThayDoi = spct.getSoLuong() - Integer.parseInt(txtSoLuongMua.getText());
                int idSoLuongThayDoi = spct.getId();
                serviceSPCT.getUpdateSLMua(soLuongThayDoi, idSoLuongThayDoi);
                listSPCT = serviceSPCT.getAllTable();
                listSP = serviceSPCT.getAll();
                listSPVM = serviceSp.getAll();
                showDataSanPham(listSPVM);
                showDataSearch(listSPCT);

                listGioHang = serviceGioHang.getAll();
                listSpGiohang = serviceGioHang.getGioHang();

                int tongTien = 0;
                listSPInHD = new ArrayList<>();
                for (GioHangViewModel gh : listSpGiohang) {
                    if (gh.getMaHD().equals(maHD)) {
                        listSPInHD.add(gh);
                        tongTien += gh.getDonGia();
                    }
                }
                jlbTongTien.setText(String.valueOf(tongTien));
                jlbTienGiam.setText(String.valueOf(tienPGG + tienQuyDoi));
                tienKhachPhaiTra = tongTien - (tienPGG + tienQuyDoi);
                jlbKhachPhaiTra.setText(String.valueOf(tienKhachPhaiTra));
                gioHangTable(listSPInHD);
                spct.setSoLuong(Integer.parseInt(txtSoLuongMua.getText()));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    }//GEN-LAST:event_btnThemGioHangActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Chọn SP");

        btnThemGioHang.setBackground(new java.awt.Color(0, 0, 0));
        btnThemGioHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemGioHang.setText("Thêm vào Giỏ");
        jDialog1.setSize(490, 410);
        jDialog1.setResizable(false);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);

//        listSPThemGioHang = listSPCT;
//        showDataTable(listSPCT);
        initWebcam();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void result_fieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_result_fieldMouseEntered

    }//GEN-LAST:event_result_fieldMouseEntered

    private void result_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_fieldActionPerformed
        //        List<SPCTViewModel> listChiTiet = new ArrayList<>();
        //
        //        for (SPCTViewModel sPCTViewModel : listSPCT) {
        //            if (sPCTViewModel.getMaVach().trim().equals(result_field.getText())) {
        //                listChiTiet.add(sPCTViewModel);
        //
        //                jdlLocSanPham.setSize(850, 250);
        //                jdlLocSanPham.setResizable(false);
        //                jdlLocSanPham.setLocationRelativeTo(null);
        //                jdlLocSanPham.setVisible(true);
        //            }
        //        }
        //        txtSoLuongMua.setText("1");
        //        listSPCT = listChiTiet;
        //        showDataSearch(listSPCT);
    }//GEN-LAST:event_result_fieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<SPCTViewModel> listChiTiet = new ArrayList<>();

        for (SPCTViewModel sPCTViewModel : listSPCT) {
            if (sPCTViewModel.getMaVach().trim().equals(result_field.getText())) {
                listChiTiet.add(sPCTViewModel);

//                jdlLocSanPham.setSize(850, 250);
//                jdlLocSanPham.setResizable(false);
//                jdlLocSanPham.setLocationRelativeTo(null);
//                jdlLocSanPham.setVisible(true);
            }
        }
        txtSoLuongMua.setText("1");
        listSPCT = listChiTiet;
        showDataSearch(listSPCT);
        listSPThemGioHang = listSPCT;
        listSPCT = serviceSPCT.getAllTable();
        try {
            clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        Clear();
        jDialog1.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        List<SPCTViewModel> listLoc = new ArrayList<>();
        for (SPCTViewModel c : listSPCT) {
            if ((cbbLocSanPhamm.getSelectedItem().equals("") || cbbLocSanPhamm.getSelectedItem().equals(c.getTenSP()))
        && (cbbLocKichCoo.getSelectedItem().equals("") || cbbLocKichCoo.getSelectedItem().equals(c.getKichCo()))
        && (cbbLoaiSanPham.getSelectedItem().equals("") || cbbLoaiSanPham.getSelectedItem().equals(c.getLoaiSanPham()))
        && (cbbLocMauSacc.getSelectedItem().equals("") || cbbLocMauSacc.getSelectedItem().equals(c.getMauSac()))
        && (cbbLocChatLieuu.getSelectedItem().equals("") || cbbLocChatLieuu.getSelectedItem().equals(c.getChatLieu()))
        && (cbbLocThuongHieu.getSelectedItem().equals("") || cbbLocThuongHieu.getSelectedItem().equals(c.getThuongHieu()))) {
        listLoc.add(c);
    } else {
        System.out.println("Không tìm thấy");
    }
        }

        listSPCT = listLoc;
        showDataSearch(listSPCT);
        listSPThemGioHang = listSPCT;
        listSPCT = serviceSPCT.getAllTable();


    }//GEN-LAST:event_btnLocActionPerformed

    private void cbbLocSanPhammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocSanPhammActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocSanPhammActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        cbbLocKichCoo.setSelectedIndex(0);
        cbbLocSanPhamm.setSelectedIndex(0);
        cbbLoaiSanPham.setSelectedIndex(0);
        cbbLocChatLieuu.setSelectedIndex(0);
        cbbLocThuongHieu.setSelectedIndex(0);
        cbbLocMauSacc.setSelectedIndex(0);
        listSPThemGioHang = listSPCT;
        showDataTable(listSPCT);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbLocKichCooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocKichCooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocKichCooActionPerformed

    private void cbbLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSanPhamActionPerformed

    private void cbbLocMauSaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocMauSaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocMauSaccActionPerformed

    private void cbbLocChatLieuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocChatLieuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocChatLieuuActionPerformed

    private void cbbLocThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocThuongHieuActionPerformed

    private void cboPGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPGGActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        showDataHoaDon(listHDTableChuaThanhToan);
        idKhachHang =7;
        khacLe();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void txtGiaTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTriActionPerformed

    //Quét ma QR
    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel8.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);

    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }

            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                result_field.setText(result.getText());
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        System.out.println(t);
        t.setDaemon(true);
        return t;
    }
    //Quet ma QR

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemGioHang;
    private javax.swing.JButton btnThemGioHang3;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateSoLuong;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbTrangThai;
    private javax.swing.JComboBox<String> cbbLoaiSanPham;
    private javax.swing.JComboBox<String> cbbLocChatLieuu;
    private javax.swing.JComboBox<String> cbbLocKichCoo;
    private javax.swing.JComboBox<String> cbbLocMauSacc;
    private javax.swing.JComboBox<String> cbbLocSanPhamm;
    private javax.swing.JComboBox<String> cbbLocThuongHieu;
    private javax.swing.JComboBox<String> cboLocKichCo;
    private javax.swing.JComboBox<String> cboLocLTT;
    private javax.swing.JComboBox<String> cboLocSanPham;
    private javax.swing.JComboBox<String> cboPGG;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JPanel dongAddSL;
    private javax.swing.JPanel dongAddSL3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jdlKhachHang;
    private javax.swing.JDialog jdlLocSanPham;
    private javax.swing.JDialog jdlThemKhachHang;
    private javax.swing.JDialog jdlUpdateSoLuong;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbKhachPhaiTra;
    private javax.swing.JLabel jlbMaHD;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbTenKhachHang;
    private javax.swing.JLabel jlbTenNhanVien;
    private javax.swing.JLabel jlbTienGiam;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoTienMat;
    private javax.swing.JTextField result_field;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblLocSanPham;
    private javax.swing.JTable tblLocSanPham3;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaChuyenKhoan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuongCapNhat;
    private javax.swing.JTextField txtSoLuongMua;
    private javax.swing.JTextField txtSoLuongMua2;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
