/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.HDCTService;
import service.HDService;
import service.HDTableService;
import service.NhanVienService;
import service.SanPhamChiTietService;
import service.impl.HDCTVServiceIMpl;
import service.impl.HDServiceImpl;
import service.impl.HDTableSeriveImpl;
import service.impl.NhanVienServiceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import viewmodel.GioHangViewModel;
import viewmodel.HDCTViewModel;
import viewmodel.HDTableVIewModel;
import viewmodel.HDViewModel;
import viewmodel.NhanVienVM;
import viewmodel.QLNhanVien;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author Admin
 */
public class ViewBanHang extends javax.swing.JPanel {

    private List<SPCTViewModel> listSPCT = new ArrayList<>();
    private List<SanPhamChiTietViewModel> listSP = new ArrayList<>();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private SanPhamChiTietService serviceSPCT = new SanPhamChiTietServiceImpl();
    private DefaultTableModel dtmCTSP = new DefaultTableModel();
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
     * Creates new form ViewBanHang1
     */
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
        listSPCT = serviceSPCT.getAllTable();
        listSPThemGioHang = listSPCT;
        showDataTable(listSPCT);
        dtmHD = (DefaultTableModel) this.tblHoaDon.getModel();

        listSPCT = serviceSPCT.getAllTable();

        listHD = serviceHD.getAll();
        listHDTable = serviceHDTable.getAll();
        for (HDTableVIewModel hdctt : listHDTable) {
            if (hdctt.getTrangThai().trim().equals("0")) {
                listHDTableChuaThanhToan.add(hdctt);
            }
        }
        listSpGiohang = serviceGioHang.getGioHang();

        listGioHang = serviceGioHang.getAll();
        dtmGioHang = (DefaultTableModel) this.tblGioHang.getModel();

        dtmHD = (DefaultTableModel) this.tblHoaDon.getModel();
        showDataHoaDon(listHDTableChuaThanhToan);

    }

    private void showDataHoaDon(List<HDTableVIewModel> listTable) {
        dtmHD.setRowCount(0);
        for (HDTableVIewModel hd : listTable) {
            dtmHD.addRow(hd.toRowDataHD());
        }
    }

    private void showDataTable(List<SPCTViewModel> listTable) {
        dtmCTSP.setRowCount(0);
        dtmCTSP = (DefaultTableModel) tblLocSanPham3.getModel();
        for (SPCTViewModel spct : listTable) {
            dtmCTSP.addRow(spct.toRowDataBanHang());
        }
    }

    private HDCTViewModel sanPhamGioHang(SPCTViewModel spct) {
        HDCTViewModel hdct = new HDCTViewModel();
        hdct.setIdHD(idHD);
        hdct.setIdSPCT(spct.getId());
        hdct.setKichCo(spct.getKichCo());
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jlbMaGG = new javax.swing.JLabel();
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        btnUpdateSoLuong = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dongAddSL3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblLocSanPham3 = new javax.swing.JTable();
        btnThemGioHang3 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        txtSoLuongMua2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        btnLoc = new javax.swing.JButton();
        cbbLocTenSanPham = new javax.swing.JComboBox<>();
        cbbLocKichCoo = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        cbbLocLoaiSanPhamm = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        cbbLocChatLieuu = new javax.swing.JComboBox<>();
        cbbLocMauSacc = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cbbLocThuongHieu = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(jlbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
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
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenNhanVien)
                    .addComponent(jLabel35))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jlbMaGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không Dùng" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jlbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel30))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaChuyenKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel29)))
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThanhToan)))
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
                                    .addComponent(jlbTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jlbMaGG)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
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

        tblGioHang.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên SP", "Loại Sản Phẩm", "Thương Hiệu", "Màu Sắc", "Chất Liệu", "Kích Cỡ", "Số Lượng", "Tổng Tiền"
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
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
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(37, 37, 37))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách sản phẩm");

        dongAddSL3.setBackground(new java.awt.Color(255, 255, 255));
        dongAddSL3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

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

        cbbLocTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocTenSanPhamActionPerformed(evt);
            }
        });

        jLabel36.setText("Kích Cỡ");

        jLabel53.setText("Tên SP");

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setToolTipText("");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel45.setText("Loai Sản Phẩm");

        cbbLocChatLieuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocChatLieuuActionPerformed(evt);
            }
        });

        cbbLocMauSacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocMauSaccActionPerformed(evt);
            }
        });

        jLabel54.setText("Màu Sắc");

        jLabel55.setText("Chất Liệu");

        cbbLocThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocThuongHieuActionPerformed(evt);
            }
        });

        jLabel46.setText("Thương Hiệu");

        javax.swing.GroupLayout dongAddSL3Layout = new javax.swing.GroupLayout(dongAddSL3);
        dongAddSL3.setLayout(dongAddSL3Layout);
        dongAddSL3Layout.setHorizontalGroup(
            dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
            .addGroup(dongAddSL3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbLocTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLocMauSacc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dongAddSL3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dongAddSL3Layout.createSequentialGroup()
                                        .addComponent(cbbLocLoaiSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnLoc))
                                    .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLoc, jButton6});

        dongAddSL3Layout.setVerticalGroup(
            dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dongAddSL3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocLoaiSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dongAddSL3Layout.createSequentialGroup()
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel56)
                                    .addComponent(txtSoLuongMua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemGioHang3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6))))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dongAddSL3Layout.createSequentialGroup()
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dongAddSL3Layout.createSequentialGroup()
                                .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dongAddSL3Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(dongAddSL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocMauSacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dongAddSL3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLoc, jButton6});

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Thông tin ");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dongAddSL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void rdoChuyenKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.enable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.disable();
        txtTienKhachDua.repaint();
        jlbTienThua.setText("");
    }//GEN-LAST:event_rdoChuyenKhoanMouseClicked

    private void rdoChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChuyenKhoanActionPerformed

    private void rdoTienMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTienMatMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.disable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.enable();
        txtTienKhachDua.repaint();
        txtMaChuyenKhoan.setText("");
    }//GEN-LAST:event_rdoTienMatMouseClicked

    private void jlbTongTienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTongTienMouseEntered

    }//GEN-LAST:event_jlbTongTienMouseEntered

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate

    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtTienKhachDuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseEntered

    }//GEN-LAST:event_txtTienKhachDuaMouseEntered

    private void txtTienKhachDuaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienKhachDuaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaInputMethodTextChanged

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed

    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased

    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void jlbTienThuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbTienThuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbTienThuaKeyPressed

    private void txtMaChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChuyenKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChuyenKhoanActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
        gioHangTable(listSPInHD);

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed

    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void btnUpdateSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSoLuongActionPerformed

    }//GEN-LAST:event_btnUpdateSoLuongActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed

    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnThemGioHang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHang3ActionPerformed

    }//GEN-LAST:event_btnThemGioHang3ActionPerformed

    private void txtSoLuongMua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongMua2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongMua2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed

    }//GEN-LAST:event_btnLocActionPerformed

    private void cbbLocTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocTenSanPhamActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbLocChatLieuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocChatLieuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocChatLieuuActionPerformed

    private void cbbLocMauSaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocMauSaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocMauSaccActionPerformed

    private void cbbLocThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocThuongHieuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemGioHang3;
    private javax.swing.JButton btnUpdateSoLuong;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cbbLocChatLieuu;
    private javax.swing.JComboBox<String> cbbLocKichCoo;
    private javax.swing.JComboBox<String> cbbLocLoaiSanPhamm;
    private javax.swing.JComboBox<String> cbbLocMauSacc;
    private javax.swing.JComboBox<String> cbbLocTenSanPham;
    private javax.swing.JComboBox<String> cbbLocThuongHieu;
    private javax.swing.JPanel dongAddSL3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbKhachPhaiTra;
    private javax.swing.JLabel jlbMaGG;
    private javax.swing.JLabel jlbMaHD;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbTenKhachHang;
    private javax.swing.JLabel jlbTenNhanVien;
    private javax.swing.JLabel jlbTienGiam;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoTienMat;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblLocSanPham3;
    private javax.swing.JTextField txtMaChuyenKhoan;
    private javax.swing.JTextField txtSoLuongMua2;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
