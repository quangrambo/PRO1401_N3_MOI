/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repository.NhanVienRepository;
import service.NhanVienService;
import service.NhanVienVMService;
import service.impl.NhanVienServiceImpl;
import utility.Uhelper;
import viewmodel.NhanVienVM;

/**
 *
 * @author Admin
 */
public class ViewHeThong extends javax.swing.JPanel {

    private final NhanVienVMService nhanVienVMService;
    List<NhanVienVM> lstnv;
    NhanVienRepository repository = new NhanVienRepository();
    NhanVienService service = new NhanVienServiceImpl();

    private int ht = 0;
    private int size = 5;

    /**
     * Creates new form ViewHeThong1
     */
    public ViewHeThong() {
        initComponents();
        rdoNam.setSelected(true);
        rdoTatCa.setSelected(true);
//      
        nhanVienVMService = new NhanVienVMService();
//        
        txtDieuKhoan.setText("Áp dụng mọi hóa đơn");
//       
        lstnv = new ArrayList<>();
        lstnv = nhanVienVMService.getAllNVVM();
        loadDataToTableNV(lstnv);

        if (tblQLNVVM.getRowCount() > 0) {
            tblQLNVVM.setRowSelectionInterval(0, 0);
            showDetailNV();
        }

        showDataCboLocChucVu();
        showDataCboLocTinhTrang();
        clearFormNV();
    }

    public String getNhanVienVMFormSelectedRow() {
        Integer row = tblQLNVVM.getSelectedRow();
        String nhanVienID = (String) tblQLNVVM.getValueAt(row, 0);
        return nhanVienID;
    }

    private void clearForm() {
        txtMa.setText("");
        txtTen.setText("");

        txtLuotSuDung.setText("");
        txtGiaTri.setText("");
        chkTrangThai.setSelected(false);

    }

    private void clearFormNV() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        rdoNam.setSelected(false);
        rdoNu.setSelected(false);
        txtSDTNV.setText("");
        txtCCCD.setText("");
        jDateNgaySinh.setDate(null);
        txtDiaChi.setText("");
        txtEmailNV.setText("");
        cbbChucVu.setSelectedIndex(0);
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
        chkTrangThaiNV.setSelected(false);
        tblQLNVVM.clearSelection();
    }

    public void showDetailNV() {
        Integer row = tblQLNVVM.getSelectedRow();
        txtMaNV.setText(tblQLNVVM.getValueAt(row, 0).toString());
        txtTenNV.setText(tblQLNVVM.getValueAt(row, 1).toString());
        String gioiTinh = tblQLNVVM.getValueAt(row, 2).toString();
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        }
        txtSDTNV.setText(tblQLNVVM.getValueAt(row, 3).toString());
        txtCCCD.setText(tblQLNVVM.getValueAt(row, 4).toString());
        String ngaySinhValue = tblQLNVVM.getValueAt(row, 5).toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Chuyển đổi chuỗi thành đối tượng Date
            Date ngaySinh = dateFormat.parse(ngaySinhValue);

            // Đặt giá trị cho JDateChooser
            jDateNgaySinh.setDate(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtDiaChi.setText(tblQLNVVM.getValueAt(row, 6).toString());
        txtEmailNV.setText(tblQLNVVM.getValueAt(row, 7).toString());
        cbbChucVu.setSelectedItem(tblQLNVVM.getValueAt(row, 8).toString());
        txtTenDangNhap.setText(tblQLNVVM.getValueAt(row, 9).toString());
        txtMatKhau.setText(tblQLNVVM.getValueAt(row, 10).toString());

        if (row >= 0) {
            String trangthai = tblQLNVVM.getValueAt(row, 11).toString();
            if (trangthai.equalsIgnoreCase("Làm việc")) {
                chkTrangThaiNV.setSelected(true);
            }
            if (trangthai.equalsIgnoreCase("Nghỉ việc")) {
                chkTrangThaiNV.setSelected(false);
            }
        }

    }

    private void showDataCboLocTinhTrang() {
        String[] gt = {"", "Làm việc", "Nghỉ việc"};
        for (String string : gt) {
            cbbLocTT.addItem(string);
        }
    }

    public NhanVienVM getNhanVienVMFormInput() {
        NhanVienVM nvvm = new NhanVienVM();
        nvvm.setMa(txtMaNV.getText());
        nvvm.setHoten(txtTenNV.getText());
        if (rdoNam.isSelected()) {
            nvvm.setGioitinh(1);
        } else {
            nvvm.setGioitinh(0);
        }
        nvvm.setSdt(txtSDTNV.getText());
        nvvm.setCccd(txtCCCD.getText());

        LocalDate ngaySinh;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

// Chuyển đổi Date sang String với định dạng "yyyy-MM-dd"
        String ngayS = dateFormat.format(jDateNgaySinh.getDate());
// Chuyển đổi String sang LocalDate
        nvvm.setNgaysinh(LocalDate.parse(ngayS));
        nvvm.setDiachi(txtDiaChi.getText());
        nvvm.setEmail(txtEmailNV.getText());
//        String selectedChucVuS = cbbChucVu.getSelectedItem().toString(); // Chuyển đổi sang String
//        int selectedChucVu = Integer.parseInt(selectedChucVuS); // Chuyển đổi String sang int
//        nvvm.setChucvu(selectedChucVu);
        String chucvu = (String) cbbChucVu.getSelectedItem();
        if (chucvu.equalsIgnoreCase("Nhân viên")) {
            nvvm.setChucvu(1);
        } else {
            nvvm.setChucvu(0);
        }

        nvvm.setTendn(txtTenDangNhap.getText());
        nvvm.setMatkhau(hashPassword(txtMatKhau.getText()));
        boolean myBooleanValue = chkTrangThaiNV.isSelected(); // Giả sử có một biến boolean
        int trangThainv = myBooleanValue ? 1 : 0; // Ép kiểu boolean thành int (1 nếu true, 0 nếu false)
        nvvm.setTrangthai(trangThainv);

        return nvvm;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void showDataCboLocChucVu() {
        String[] gt = {"", "Nhân viên", "Quản lý"};
        for (String string : gt) {
            cbbLocCV.addItem(string);
        }
    }

    private void loadDataToTableNV(List<NhanVienVM> lstnv) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tblQLNVVM.getModel();
        dtm.setRowCount(0);
        List<NhanVienVM> lst = lstnv;
        for (NhanVienVM nvvm : lst) {
            dtm.addRow(new Object[]{
                nvvm.getMa(),
                nvvm.getHoten(),
                nvvm.getgt(),
                nvvm.getSdt(),
                nvvm.getCccd(),
                nvvm.getNgaysinh(),
                nvvm.getDiachi(),
                nvvm.getEmail(),
                nvvm.getcv(),
                nvvm.getTendn(),
                nvvm.getMatkhau(),
                nvvm.gettt()
            });
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        cbbChucVu = new javax.swing.JComboBox<>();
        chkTrangThaiNV = new javax.swing.JCheckBox();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNVVM = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbbLocCV = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbbLocTT = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTimKiemHT = new javax.swing.JTextField();
        btnPre = new javax.swing.JButton();
        lblSo = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnHoanTac1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnClearNV = new javax.swing.JButton();
        btnNVNghi = new javax.swing.JButton();
        pnlGiamGia = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLPGGVM = new javax.swing.JTable();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDangDienRa = new javax.swing.JRadioButton();
        rdoDaKetThuc = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtLuotSuDung = new javax.swing.JTextField();
        txtDieuKhoan = new javax.swing.JTextField();
        txtGiaTri = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        chkTrangThai = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        btnThemPGG = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnVoHieuHoaPGG = new javax.swing.JButton();
        ClearFormPGG = new javax.swing.JButton();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        pnlNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNhanVienMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Thông tin nhân viên");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("CCCD");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("SĐT");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mật khẩu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên đăng nhập");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Chức vụ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Họ tên");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Giới tính");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Ngày sinh");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtSDTNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDTNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtEmailNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCCCD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam.setText("Nam");

        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu.setText("Nữ");

        cbbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));

        chkTrangThaiNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTrangThaiNV.setText("Làm việc");
        chkTrangThaiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrangThaiNVActionPerformed(evt);
            }
        });

        jDateNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");
        jDateNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addComponent(txtTenNV)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(rdoNam)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmailNV))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMatKhau)
                        .addComponent(txtTenDangNhap)
                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel5)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(chkTrangThaiNV))
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Danh sách nhân viên");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        tblQLNVVM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Giới tính ", "SDT", "CCCD", "Ngày sinh", "Địa chỉ", "Email", "Chức vụ", "Tên ĐN", "Mật khẩu", "Trang thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLNVVM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVVMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNVVM);

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setText("Lọc nhân viên ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Chức vụ");

        cbbLocCV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbLocCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocCVActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Trạng thái");

        cbbLocTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbLocTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocTTActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setText("Tìm kiếm");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Họ tên");

        txtTimKiemHT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemHT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiemHT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemHTCaretUpdate(evt);
            }
        });
        txtTimKiemHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHTActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblSo.setText("1");

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnHoanTac1.setBackground(new java.awt.Color(0, 0, 0));
        btnHoanTac1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHoanTac1.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanTac1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btnHoanTac1.setText("Hoàn tác");
        btnHoanTac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTac1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLocCV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLocTT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnHoanTac1))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemHT, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(btnPre)
                .addGap(57, 57, 57)
                .addComponent(lblSo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnNext)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbbLocCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(cbbLocTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiemHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnPre)
                            .addComponent(lblSo)))
                    .addComponent(btnHoanTac1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        btnThemNV.setBackground(new java.awt.Color(0, 0, 0));
        btnThemNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnThemNV.setText("Thêm nhân viên");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnSuaNV.setBackground(new java.awt.Color(0, 0, 0));
        btnSuaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaNV.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pencil-20.png"))); // NOI18N
        btnSuaNV.setText("Sửa thông tin nv");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnClearNV.setBackground(new java.awt.Color(0, 0, 0));
        btnClearNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearNV.setForeground(new java.awt.Color(255, 255, 255));
        btnClearNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-available-updates-20 (1).png"))); // NOI18N
        btnClearNV.setText("Làm mới");
        btnClearNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNVActionPerformed(evt);
            }
        });

        btnNVNghi.setBackground(new java.awt.Color(0, 0, 0));
        btnNVNghi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNVNghi.setForeground(new java.awt.Color(255, 255, 255));
        btnNVNghi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-trash-20.png"))); // NOI18N
        btnNVNghi.setText("Nhân viên nghỉ");
        btnNVNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVNghiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNVNghi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnNVNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearNV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", pnlNhanVien);

        pnlGiamGia.setBackground(new java.awt.Color(255, 255, 255));
        pnlGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGiamGiaMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Danh sách khuyến mại");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        tblQLPGGVM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày bắt đầu", "Ngày kết thúc", "Lượt sử dụng", "Điều khoản", "Giá trị", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblQLPGGVM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLPGGVMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLPGGVM);

        rdoTatCa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        rdoDangDienRa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDangDienRa.setText("Đang diễn ra");
        rdoDangDienRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDangDienRaActionPerformed(evt);
            }
        });

        rdoDaKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaKetThuc.setText("Đã kết thúc");
        rdoDaKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaKetThucActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Danh sách phiếu giảm giá");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên" }));
        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdoTatCa)
                        .addGap(74, 74, 74)
                        .addComponent(rdoDangDienRa)
                        .addGap(47, 47, 47)
                        .addComponent(rdoDaKetThuc)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoTatCa)
                        .addComponent(rdoDangDienRa)
                        .addComponent(rdoDaKetThuc))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Thông tin khuyến mại");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Mã");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tên");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Ngày bắt đâu");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Lượt sử dụng");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Ngày kết thúc");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Giá trị");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Điều khoản");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtLuotSuDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLuotSuDung.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtDieuKhoan.setEditable(false);
        txtDieuKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDieuKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtDieuKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDieuKhoanActionPerformed(evt);
            }
        });

        txtGiaTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaTri.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Trạng thái");

        chkTrangThai.setText("Hoạt động");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27)
                        .addComponent(jLabel24)
                        .addComponent(jLabel23)
                        .addComponent(jLabel22)
                        .addComponent(jLabel28)
                        .addComponent(jLabel29)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuotSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTrangThai)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtLuotSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtDieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(chkTrangThai))
                .addGap(24, 24, 24))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        btnThemPGG.setBackground(new java.awt.Color(0, 0, 0));
        btnThemPGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemPGG.setForeground(new java.awt.Color(255, 255, 255));
        btnThemPGG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnThemPGG.setText("Thêm Phiếu giảm giá");
        btnThemPGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPGGActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pencil-20.png"))); // NOI18N
        jButton5.setText("Sửa thông tin PGG");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnVoHieuHoaPGG.setBackground(new java.awt.Color(0, 0, 0));
        btnVoHieuHoaPGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoHieuHoaPGG.setForeground(new java.awt.Color(255, 255, 255));
        btnVoHieuHoaPGG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-trash-20.png"))); // NOI18N
        btnVoHieuHoaPGG.setText("Vô hiệu hóa PGG");
        btnVoHieuHoaPGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoHieuHoaPGGActionPerformed(evt);
            }
        });

        ClearFormPGG.setBackground(new java.awt.Color(0, 0, 0));
        ClearFormPGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ClearFormPGG.setForeground(new java.awt.Color(255, 255, 255));
        ClearFormPGG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-available-updates-20 (1).png"))); // NOI18N
        ClearFormPGG.setText("Làm mới");
        ClearFormPGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearFormPGGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoHieuHoaPGG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemPGG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearFormPGG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnThemPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnVoHieuHoaPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ClearFormPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGiamGiaLayout = new javax.swing.GroupLayout(pnlGiamGia);
        pnlGiamGia.setLayout(pnlGiamGiaLayout);
        pnlGiamGiaLayout.setHorizontalGroup(
            pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiamGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlGiamGiaLayout.setVerticalGroup(
            pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiamGiaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addGroup(pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGiamGiaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGiamGiaLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý phiếu giảm giá", pnlGiamGia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkTrangThaiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrangThaiNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTrangThaiNVActionPerformed

    private void tblQLNVVMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVVMMouseClicked
 showDetailNV();        // TODO add your handling code here:
    }//GEN-LAST:event_tblQLNVVMMouseClicked

    private void cbbLocCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocCVActionPerformed

    }//GEN-LAST:event_cbbLocCVActionPerformed

    private void cbbLocTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocTTActionPerformed

    }//GEN-LAST:event_cbbLocTTActionPerformed

    private void txtTimKiemHTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemHTCaretUpdate

    }//GEN-LAST:event_txtTimKiemHTCaretUpdate

    private void txtTimKiemHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemHTActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed

    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnHoanTac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTac1ActionPerformed
        loadDataToTableNV(nhanVienVMService.getAllNVVM());
        cbbLocCV.setSelectedIndex(0);
        cbbLocTT.setSelectedIndex(0);
    }//GEN-LAST:event_btnHoanTac1ActionPerformed
    private boolean checkTuoi(Date selectedDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthLocalDate, currentDate);
        return period.getYears() >= 18;
    }
    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        if (Uhelper.checkRong(txtMaNV, "Không để trống mã nhân viên")) {
            return;
        }
        if (Uhelper.checkRong(txtTenNV, "Không để trống họ tên")) {
            return;
        }
        if (Uhelper.checkRong(txtSDTNV, "Không để trống số điện thoại")) {
            return;
        }
        if (Uhelper.checkRong(txtEmailNV, "Không để trống email")) {
            return;
        }
        if (Uhelper.checkRong(txtCCCD, "Không để trống căn cước công dân")) {
            return;
        }
        if (Uhelper.checkRong(txtDiaChi, "Không để trống địa chỉ")) {
            return;
        }
        if (Uhelper.checkRong(txtTenDangNhap, "Không để trống tên đăng nhập")) {
            return;
        }
        if (Uhelper.checkRong(txtMatKhau, "Không để trống mật khẩu")) {
            return;
        }
        if (Uhelper.checkRongChoNgay(jDateNgaySinh, "Không để trống ngày sinh")) {
            return;
        }

        Date selectedDate = jDateNgaySinh.getDate();
        if (!checkTuoi(selectedDate)) {
            JOptionPane.showMessageDialog(this, "Nhân viên phải đủ 18 tuổi trở lên.");
            return;
        }
        String ma = txtMaNV.getText();
        String sdt = txtSDTNV.getText();
        String cccd = txtCCCD.getText();
        String email = txtEmailNV.getText();
//        if (!txtMa.getText().matches("\\w+")) {
//            JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ");
//            return;
//        }

        for (NhanVienVM nv : nhanVienVMService.getAllNVVM()) {
            if (ma.equalsIgnoreCase(nv.getMa())) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
                return;
            }
        }
        for (NhanVienVM nv : nhanVienVMService.getAllNVVM()) {
            if (sdt.equalsIgnoreCase(nv.getSdt())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                return;
            }
        }
        for (NhanVienVM nv : nhanVienVMService.getAllNVVM()) {
            if (cccd.equalsIgnoreCase(nv.getCccd())) {
                JOptionPane.showMessageDialog(this, "Số căn cước đã tồn tại");
                return;
            }
        }
        for (NhanVienVM nv : nhanVienVMService.getAllNVVM()) {
            if (email.equalsIgnoreCase(nv.getEmail())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                return;
            }
        }
        if (!txtTenNV.getText().matches("^[\\p{L} .'-]+$")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không hợp lệ");
            return;
        }
        if (!txtSDTNV.getText().matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
        }
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!txtEmailNV.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "email không hợp lệ");
            return;
        }
        if (!txtCCCD.getText().matches("^[0-9]{9}$|^[0-9]{12}$")) {
            JOptionPane.showMessageDialog(this, "số căn cước không hợp lệ");
            return;
        }

        NhanVienVM nvvm = getNhanVienVMFormInput();
        if (nhanVienVMService.addNhanVienVM(nvvm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearFormNV();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        loadDataToTableNV(nhanVienVMService.getAllNVVM());
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        Integer row = tblQLNVVM.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên muốn sửa!");
            return;
        }

        if (Uhelper.checkRong(txtMaNV, "Không để trống mã nhân viên")) {
            return;
        }
        if (Uhelper.checkRong(txtTenNV, "Không để trống họ tên")) {
            return;
        }
        if (Uhelper.checkRong(txtSDTNV, "Không để trống số điện thoại")) {
            return;
        }
        if (Uhelper.checkRong(txtEmailNV, "Không để trống email")) {
            return;
        }
        if (Uhelper.checkRong(txtCCCD, "Không để trống căn cước công dân")) {
            return;
        }
        if (Uhelper.checkRong(txtDiaChi, "Không để trống địa chỉ")) {
            return;
        }
        if (Uhelper.checkRong(txtTenDangNhap, "Không để trống tên đăng nhập")) {
            return;
        }
        if (Uhelper.checkRong(txtMatKhau, "Không để trống mật khẩu")) {
            return;
        }
        if (Uhelper.checkRongChoNgay(jDateNgaySinh, "Không để trống ngày sinh")) {
            return;
        }

        Date selectedDate = jDateNgaySinh.getDate();
        if (!checkTuoi(selectedDate)) {
            JOptionPane.showMessageDialog(this, "Nhân viên phải đủ 18 tuổi trở lên.");
            return;
        }

        String ma = txtMaNV.getText();
        String sdt = txtSDTNV.getText();
        String cccd = txtCCCD.getText();
        String email = txtEmailNV.getText();
        NhanVienVM nvvm = getNhanVienVMFormInput();
        String nhanVien_ID = getNhanVienVMFormSelectedRow();
        nvvm.setMa(nhanVien_ID);
        if (nhanVienVMService.updateNhanVienVM(nvvm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
            clearFormNV();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
        }
        loadDataToTableNV(nhanVienVMService.getAllNVVM());
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnClearNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearNVActionPerformed
        clearFormNV();
    }//GEN-LAST:event_btnClearNVActionPerformed

    private void btnNVNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVNghiActionPerformed
        Integer selectedRow = tblQLNVVM.getSelectedRow();
        if (selectedRow == -1) {
            // Người dùng chưa chọn dòng nào trong table
            JOptionPane.showMessageDialog(this, "Cần chọn 1 nhân viên muốn cho nghỉ việc");
            return;
        }
        chkTrangThaiNV.setSelected(false);
        NhanVienVM nvvm = getNhanVienVMFormInput();
        String nhanVien_ID = getNhanVienVMFormSelectedRow();
        nvvm.setMa(nhanVien_ID);
        if (nhanVienVMService.voHieuHoaNhanVienVM(nvvm) != null) {
            JOptionPane.showMessageDialog(this, "vô hiệu hóa nhân viên thành công");
        } else {
            JOptionPane.showMessageDialog(this, "vô hiệu hóa nhân viên sửa thất bại");
        }

        loadDataToTableNV(nhanVienVMService.getAllNVVM());
    }//GEN-LAST:event_btnNVNghiActionPerformed

    private void pnlNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlNhanVienMouseClicked

    private void tblQLPGGVMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLPGGVMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblQLPGGVMMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed

    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDangDienRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDangDienRaActionPerformed

    }//GEN-LAST:event_rdoDangDienRaActionPerformed

    private void rdoDaKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaKetThucActionPerformed

    }//GEN-LAST:event_rdoDaKetThucActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimKiemActionPerformed

    private void txtDieuKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDieuKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDieuKhoanActionPerformed

    private void jDateNgayBatDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateNgayBatDauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateNgayBatDauMouseClicked

    private void btnThemPGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPGGActionPerformed

    }//GEN-LAST:event_btnThemPGGActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnVoHieuHoaPGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoHieuHoaPGGActionPerformed

    }//GEN-LAST:event_btnVoHieuHoaPGGActionPerformed

    private void ClearFormPGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearFormPGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearFormPGGActionPerformed

    private void pnlGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGiamGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlGiamGiaMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearFormPGG;
    private javax.swing.JButton btnClearNV;
    private javax.swing.JButton btnHoanTac1;
    private javax.swing.JButton btnNVNghi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemPGG;
    private javax.swing.JButton btnVoHieuHoaPGG;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbLocCV;
    private javax.swing.JComboBox<String> cbbLocTT;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JCheckBox chkTrangThai;
    private javax.swing.JCheckBox chkTrangThaiNV;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSo;
    private javax.swing.JPanel pnlGiamGia;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JRadioButton rdoDaKetThuc;
    private javax.swing.JRadioButton rdoDangDienRa;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblQLNVVM;
    private javax.swing.JTable tblQLPGGVM;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDieuKhoan;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtLuotSuDung;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemHT;
    // End of variables declaration//GEN-END:variables
}
