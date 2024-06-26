/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.SanPhamChiTietRepository;
import service.ChatLieuService;
import service.KichCoService;
import service.LoaiSanPhamService;
import service.MauSacService;
import service.SanPhamChiTietService;
import service.SanPhamService;
import service.ThuongHieuService;
import service.impl.ChatLieuServiceImpl;
import service.impl.KichCoServiceImpl;
import service.impl.LoaiSanPhamServiceImpl;
import service.impl.MauSacSercviceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import view.contains.thuoctinh.ViewChatLieu;
import view.contains.thuoctinh.ViewLoaiSanPham;
import view.contains.thuoctinh.ViewMauSac;
import view.contains.thuoctinh.ViewSP;
import view.contains.thuoctinh.ViewSize;
import view.contains.thuoctinh.ViewThuongHieu;
import viewmodel.ChatLieuViewModel;
import viewmodel.DanhSachSP;
import viewmodel.KichCoViewModel;
import viewmodel.LoaiSanPhamViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author Admin
 */
public class ViewSanPham extends javax.swing.JPanel {

    private List<SPCTViewModel> list = new ArrayList<>();

    private List<SanPhamChiTietViewModel> listSPCT = new ArrayList<>();
    private SanPhamChiTietService service = new SanPhamChiTietServiceImpl();

    private List<ChatLieuViewModel> listCL = new ArrayList<>();
    private ChatLieuService serviceCL = new ChatLieuServiceImpl();
    private List<String> listCboCl = new ArrayList<>();
    private DefaultComboBoxModel dcbCL = new DefaultComboBoxModel();

    private List<KichCoViewModel> listKC = new ArrayList<>();
    private KichCoService serviceKC = new KichCoServiceImpl();
    private List<String> listCboKC = new ArrayList<>();
    private DefaultComboBoxModel dcbKC = new DefaultComboBoxModel();

    private List<SanPhamViewModel> listSP = new ArrayList<>();
    private SanPhamService serviceSp = new SanPhamServiceImpl();
    private List<String> listCboSP = new ArrayList<>();
    private DefaultComboBoxModel dcbSP = new DefaultComboBoxModel();

    private List<LoaiSanPhamViewModel> listLSP = new ArrayList<>();
    private LoaiSanPhamService serviceLSP = new LoaiSanPhamServiceImpl();
    private List<String> listCboLSP = new ArrayList<>();
    private DefaultComboBoxModel dcbLSP = new DefaultComboBoxModel();

    private List<MauSacViewModel> listMS = new ArrayList<>();
    private MauSacService serviceMS = new MauSacSercviceImpl();
    private List<String> listCboMS = new ArrayList<>();
    private DefaultComboBoxModel dcbMS = new DefaultComboBoxModel();

    private List<ThuongHieuViewModel> listTH = new ArrayList<>();
    private ThuongHieuService serviceTH = new ThuongHieuServiceImpl();
    private List<String> listCboTH = new ArrayList<>();
    private DefaultComboBoxModel dcbTH = new DefaultComboBoxModel();

    private List<String> listLocKC = new ArrayList<>();

    private DefaultComboBoxModel dcbLocLoaiSP = new DefaultComboBoxModel();

    private List<SPCTViewModel> listSPCTtable = new ArrayList<>();

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private List<DanhSachSP> listDSSP = new ArrayList<>();
    private DefaultTableModel dtmBangDanhSach = new DefaultTableModel();

    private DefaultComboBoxModel dcbLocLSP = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbLocTh = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbLocKichCo = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbLocMS = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbLocCL = new DefaultComboBoxModel();

    private SanPhamChiTietRepository chiTietRepository = new SanPhamChiTietRepository();
    private LoaiSanPhamService lspsv = new LoaiSanPhamServiceImpl();
    private List<SanPhamChiTietViewModel> ds = new ArrayList<>();
    private int ht = 0;
    private int size = 7;
    /**
     * Creates new form ViewSanPham
     */
    private JPanel panel;

    /**
     * Creates new form ViewSanPham1
     */
    public ViewSanPham() {
        initComponents();
        btnLui.setEnabled(false);
        btnTien.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
         listSPCTtable = service.getAllTable();
        listSP = serviceSp.getAll();
        listTH = serviceTH.getAll();
        listLSP = serviceLSP.getAll();
        listKC = serviceKC.getAll();
        listMS = serviceMS.getAll();
        listCL = serviceCL.getAll();
        dtm = (DefaultTableModel) this.tblSPCT.getModel();
//        showDataTable(listSPCTtable);

       dcbSP = (DefaultComboBoxModel) this.cboTenSP.getModel();
        listCboSP.add("");
        for (SanPhamViewModel sp : listSP) {
            listCboSP.add(sp.getTen());
        }
        showDataCBO(listCboSP, dcbSP);

        dcbLocLSP = (DefaultComboBoxModel) this.cbbLocSanPhamm.getModel();
        showDataCBO(listCboSP, dcbLocLSP);

        dcbKC = (DefaultComboBoxModel) this.cboKichCo.getModel();
        listCboKC.add("");
//        listCboKC.add("S");
//        listCboKC.add("M");
//        listCboKC.add("L");
//        listCboKC.add("XL");
        for (KichCoViewModel kc : listKC) {
            listCboKC.add(kc.getKichCo());
        }

        showDataCBO(listCboKC, dcbKC);
        dcbLocKichCo = (DefaultComboBoxModel) this.cbbLocKichCoo.getModel();
        showDataCBO(listCboKC, dcbLocKichCo);

        dcbTH = (DefaultComboBoxModel) this.cboThuongHIeu.getModel();
        listCboTH.add("");
        for (ThuongHieuViewModel sp : listTH) {
            listCboTH.add(sp.getTen());
        }
        showDataCBO(listCboTH, dcbTH);
        dcbLocTh = (DefaultComboBoxModel) cbbLocThuongHieu.getModel();
        showDataCBO(listCboTH, dcbLocTh);
//
        dcbLSP = (DefaultComboBoxModel) this.cboLSP.getModel();
        listCboLSP.add("");
        for (LoaiSanPhamViewModel sp : listLSP) {
            listCboLSP.add(sp.getTen());
        }
        showDataCBO(listCboLSP, dcbLSP);
        dcbLocLoaiSP = (DefaultComboBoxModel) cbbLoaiSanPham.getModel();
        showDataCBO(listCboLSP, dcbLocLoaiSP);

//        dcbLocLoaiTT = (DefaultComboBoxModel) this.cbbLocLoaiTT.getModel();
//        showDataCBO(listCboLTT, dcbLocLoaiTT);
        dcbMS = (DefaultComboBoxModel) this.cboMauSac.getModel();
        listCboMS.add("");
        for (MauSacViewModel sp : listMS) {
            listCboMS.add(sp.getTen());
        }
        showDataCBO(listCboMS, dcbMS);
        dcbLocMS = (DefaultComboBoxModel) this.cbbLocMauSac.getModel();
        showDataCBO(listCboMS, dcbLocMS);
        //
        dcbCL = (DefaultComboBoxModel) this.cboChatLieu.getModel();
        listCboCl.add("");
        for (ChatLieuViewModel sp : listCL) {
            listCboCl.add(sp.getTen());
        }
        showDataCBO(listCboCl, dcbCL);
        dcbLocCL = (DefaultComboBoxModel) this.cbbLocChatLieuu.getModel();
        showDataCBO(listCboCl, dcbLocCL);

//        dtmBangDanhSach = (DefaultTableModel) this.tblDanhSach.getModel();

      
        showDataTableSP(listSP);
    }
    
    private void showDataTable(List<SPCTViewModel> listTable) {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tblSPCT.getModel();
        for (SPCTViewModel spct : listTable) {
            dtm.addRow(spct.toRowData());
            
        }
    }
    private void showDataTable1(List<SanPhamChiTietViewModel> listTable) {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tblSPCT.getModel();
        for (SanPhamChiTietViewModel spct : listTable) {
            dtm.addRow(spct.toRowData());
            
        }
    }
      private void showDataTableSP(List<SanPhamViewModel> listTable) {
        DefaultTableModel dtmlam = (DefaultTableModel)this.tblSanPham.getModel();
      
        dtmlam.setRowCount(0);
        int soLuongTong=0;
        for (SanPhamViewModel sp : listTable) {
            for (SanPhamChiTietViewModel spct : listSPCT) {
                if(sp.getId()==spct.getIdSP()){
                    sp.setSoLuong(soLuongTong+=spct.getSoLuong());
                }
            }
            soLuongTong=0;
            dtmlam.addRow(sp.toRowData());
        }
    }

       private void showDataTablePhanTrang(int ht, int c) {
        listSPCTtable = service.getAllPhanTrang(ht, c);
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tblSPCT.getModel();
        for (SPCTViewModel spct : listSPCTtable) {
            dtm.addRow(spct.toRowData());
        }
       
    }
       public int LoadSPCTData(int page, int limit) {
    DefaultTableModel dtm = (DefaultTableModel) this.tblSPCT.getModel();
    dtm.setRowCount(0);
    List<SPCTViewModel> ds = service.getAllPhanTrang(page * limit, limit);
    
    for (SPCTViewModel d : ds) {
        dtm.addRow(d.toRowData());
    }
    
    return ds.size();
}


    private void showDataTableDSNhapMoi(List<DanhSachSP> listTable) {
        dtmBangDanhSach.setRowCount(0);
        for (DanhSachSP danhSachSP : listTable) {
            dtmBangDanhSach.addRow(danhSachSP.toRowData());
        }
    }

    private void showDataCBO(List<String> lisString, DefaultComboBoxModel cbo) {
        for (String string : lisString) {
            cbo.addElement(string);
        }
    }
    public void showdataCBBsp(){
          List<SanPhamViewModel> listloai = serviceSp.getAll();
          DefaultComboBoxModel l = (DefaultComboBoxModel)this.cboTenSP.getModel();
          for (SanPhamViewModel d : listloai) {
            
            l.addElement(d.getTen());
        }
          
    }
    private void showDataFrom(int index) {
        SPCTViewModel spct = list.get(index);
        txtMa.setText(spct.getMa());
        txtMaVach.setText(spct.getMaVach());
        
        cboThuongHIeu.setSelectedItem(spct.getThuongHieu());
        cboLSP.setSelectedItem(spct.getLoaiSanPham());
        cboKichCo.setSelectedItem(spct.getKichCo());
        cboMauSac.setSelectedItem(spct.getMauSac());
        cboChatLieu.setSelectedItem(spct.getChatLieu());
        txtSoLuong.setText(String.valueOf(spct.getSoLuong()));
        txtGiaNhap.setText(String.valueOf(spct.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(spct.getGiaBan()));
        txtMoT.setText(spct.getMoTa());
        ckbTrangThai.setSelected(spct.isTrangThai());
    }

    public void fillData() {
        int row = tblSPCT.getSelectedRow();
        // dtm = (DefaultTableModel) tb.getModel();
        SPCTViewModel ctspvm = new SPCTViewModel();

        txtMa.setText(tblSPCT.getValueAt(row, 0).toString());
        txtMaVach.setText(tblSPCT.getValueAt(row, 1).toString());
        txtMoT.setText(tblSPCT.getValueAt(row, 2).toString());
        txtSoLuong.setText(String.valueOf(tblSPCT.getValueAt(row, 3).toString()));

        String sp1 = tblSPCT.getValueAt(row, 4).toString();
        cboTenSP.setSelectedItem(sp1);

        String th = tblSPCT.getValueAt(row, 5).toString();
        cboThuongHIeu.setSelectedItem(th);

        String la = tblSPCT.getValueAt(row, 6).toString();
        cboLSP.setSelectedItem(la);

        String kc = tblSPCT.getValueAt(row, 7).toString();
        cboKichCo.setSelectedItem(kc);

        String ms = tblSPCT.getValueAt(row, 8).toString();
        cboMauSac.setSelectedItem(ms);

        String cl = tblSPCT.getValueAt(row, 9).toString();
        cboChatLieu.setSelectedItem(cl);

        txtGiaNhap.setText(String.valueOf(tblSPCT.getValueAt(row, 10).toString()));
        txtGiaBan.setText(String.valueOf(tblSPCT.getValueAt(row, 11).toString()));
        Object trangThaiValue = tblSPCT.getValueAt(row, 12);
        if (trangThaiValue != null) {
            String trangThai = trangThaiValue.toString();
            ckbTrangThai.setSelected(trangThai.equalsIgnoreCase("Còn hàng"));
        }
    }

    private SanPhamChiTietViewModel nhapDuLieu() {
        SanPhamChiTietViewModel spct = new SanPhamChiTietViewModel();
        int i = listSPCTtable.size();
        System.out.println(i);
        spct.setMa("SPCT" + (i+1));
        spct.setMaVach(txtMaVach.getText());
        spct.setMoTa(txtMoT.getText());
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cboTenSP.getSelectedItem().equals(sp.getTen())) {
                spct.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cboThuongHIeu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdTH(sp.getId());
            }
        }
        for (LoaiSanPhamViewModel sp : listLSP) {
            if (cboLSP.getSelectedItem().equals(sp.getTen())) {
                spct.setIdLSP(sp.getId());
            }
        }
        for (KichCoViewModel sp : listKC) {
            if (cboKichCo.getSelectedItem().equals(sp.getKichCo())) {
                spct.setIdKC(sp.getId());
            }
        }
        for (MauSacViewModel sp : listMS) {
            if (cboMauSac.getSelectedItem().equals(sp.getTen())) {
                spct.setIdMS(sp.getId());
            }
        }
        for (ChatLieuViewModel sp : listCL) {
            if (cboChatLieu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdCL(sp.getId());
            }
        }
        spct.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        spct.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        spct.setTrangThai(ckbTrangThai.isSelected());

        return spct;
    }
     private boolean validateTable1() {
        if(txtTen.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên");
            return false;
        }
        return true;
    }
    private void clicked(){
        int row = this.tblSanPham.getSelectedRow();
        String ma = this.tblSanPham.getValueAt(row, 0).toString();
        String ten = this.tblSanPham.getValueAt(row, 1).toString();
        for (SanPhamViewModel sp : listSP) {
          
            if (sp.getMa().equals(ma)) {
                int id = sp.getId();
                  System.out.println("ID của sản phẩm được chọn: " + id);
                 List<SPCTViewModel> ds = service.findbyId(id);
                 showDataTable(ds);
                 break;
            }
        }
        cboTenSP.setSelectedItem(ten);
        cboTenSP.setEditable(false);
    }
    private SanPhamChiTietViewModel updateData() {
        SanPhamChiTietViewModel spct = new SanPhamChiTietViewModel();
        spct.setMa(txtMa.getText());
        spct.setMaVach(txtMaVach.getText());
        spct.setMoTa(txtMoT.getText());
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cboTenSP.getSelectedItem().equals(sp.getTen())) {
                spct.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cboThuongHIeu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdTH(sp.getId());
            }
        }
        for (LoaiSanPhamViewModel sp : listLSP) {
            if (cboLSP.getSelectedItem().equals(sp.getTen())) {
                spct.setIdLSP(sp.getId());
            }
        }
        for (KichCoViewModel sp : listKC) {
            if (cboKichCo.getSelectedItem().equals(sp.getKichCo())) {
                spct.setIdKC(sp.getId());
            }
        }
        for (MauSacViewModel sp : listMS) {
            if (cboMauSac.getSelectedItem().equals(sp.getTen())) {
                spct.setIdMS(sp.getId());
            }
        }
        for (ChatLieuViewModel sp : listCL) {
            if (cboChatLieu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdCL(sp.getId());
            }
        }
        spct.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        spct.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        spct.setTrangThai(ckbTrangThai.isSelected());

        return spct;
    }

    

    private boolean validateTable() {
        if (txtMaVach.getText().trim().isEmpty() || txtSoLuong.getText().trim().isEmpty() || txtGiaNhap.getText().trim().isEmpty()
              
                || cboLSP.getSelectedItem().equals("") || cboKichCo.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Thông tin sản phẩm bị trống");
            return false;
        }

        String maVach = txtMaVach.getText().trim();
        int doDaiMaVach = maVach.length();
        if (doDaiMaVach < 2) {
            JOptionPane.showMessageDialog(this, "Mã vạch phải từ 2 so tro len");
            return false;
        }

        try {
            int soLuong = Integer.parseInt(txtSoLuong.getText());

            // Kiểm tra trước khi chuyển đổi giá nhập thành số
            String giaNhapText = txtGiaNhap.getText().trim();
            if (giaNhapText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Thông tin sản phẩm bị trống");
                return false;
            }

            float giaNhap = Float.parseFloat(giaNhapText);

            if (giaNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                return false;
            } else if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải >=0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sửa sản phẩm không thành công, kiểm tra lại");
            return false;
        }

        return true;
    }
    private SanPhamViewModel nhapDuLieu1() {
        SanPhamViewModel sp = new SanPhamViewModel();
        int i = listSP.size() - 1;
        sp.setMa("SP" + listSP.get(i).getId());
        sp.setTen(txtTen.getText());
       
        //sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        return sp;
    }
    private boolean validateThem() {
        // Các thông tin bắt buộc không được để trống
        if (txtMaVach.getText().trim().isEmpty() || txtSoLuong.getText().trim().isEmpty() || txtGiaNhap.getText().trim().isEmpty()
                || cboTenSP.getSelectedItem().equals("") || cboLSP.getSelectedItem().equals("") || cboKichCo.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Thông tin sản phẩm bị trống");
            return false;
        }

        // Kiểm tra mã vạch
        String maVach = txtMaVach.getText().trim();
        int doDaiMaVach = maVach.length();
        if (doDaiMaVach < 2 ) {
            JOptionPane.showMessageDialog(this, "Mã vạch phải từ 2 số");
            return false;
        }

        try {
            // Kiểm tra số lượng
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải >= 0");
                return false;
            }

            // Kiểm tra giá nhập
            String giaNhapText = txtGiaNhap.getText().trim();
            if (giaNhapText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Thông tin giá nhập sản phẩm bị trống");
                return false;
            }
            float giaNhap = Float.parseFloat(giaNhapText);
            if (giaNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                return false;
            }

            // Kiểm tra trùng lặp thuộc tính sản phẩm
            listSPCTtable = service.getAllTable();
            for (SPCTViewModel spct : listSPCTtable) {
                if (cboLSP.getSelectedItem().equals(spct.getLoaiSanPham())
                        && cboThuongHIeu.getSelectedItem().equals(spct.getThuongHieu())
                        && cboKichCo.getSelectedItem().equals(spct.getKichCo())
                        && cboMauSac.getSelectedItem().equals(spct.getMauSac())
                        && cboChatLieu.getSelectedItem().equals(spct.getChatLieu())) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng hoặc giá nhập không hợp lệ");
            return false;
        }

        return true;
    }

    private void clearFrom() {
        txtMa.setText("");
        txtMaVach.setText("");
        txtMoT.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        cboTenSP.setSelectedIndex(0);
        ckbTrangThai.setSelected(false);
    }

    public void cleaLoc() {
        cbbLocChatLieuu.setSelectedIndex(0);
        cbbLocKichCoo.setSelectedIndex(0);
        cbbLoaiSanPham.setSelectedIndex(0);
        cbbLocMauSac.setSelectedIndex(0);
        cbbLocSanPhamm.setSelectedIndex(0);
        cbbLocThuongHieu.setSelectedIndex(0);

    }

    public void updatePage() {
    int totalItems = chiTietRepository.getTotalIteams(); // Chỉnh sửa tên phương thức từ getTotalIteams thành getTotalItems
    int maxPage = (int) Math.ceil((double) totalItems / size);

    if (ht > maxPage) {
        ht = (maxPage == 0) ? 1 : maxPage;
    }

    lblPageSP.setText(ht + " / " + maxPage);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboLSP = new javax.swing.JComboBox<>();
        cboKichCo = new javax.swing.JComboBox<>();
        cboThuongHIeu = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        btnChatLieu = new javax.swing.JButton();
        btnKichCo = new javax.swing.JButton();
        btnMauSac = new javax.swing.JButton();
        btnLoaiTheThao = new javax.swing.JButton();
        btnThuongHieu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMaVach = new javax.swing.JTextField();
        txtMoT = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cboTenSP = new javax.swing.JComboBox<>();
        ckbTrangThai = new javax.swing.JCheckBox();
        btlClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaThongTinSp = new javax.swing.JButton();
        btnLuuDanhSach = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbbLocKichCoo = new javax.swing.JComboBox<>();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btlHoanTac = new javax.swing.JButton();
        cbbLocThuongHieu = new javax.swing.JComboBox<>();
        cbbLocChatLieuu = new javax.swing.JComboBox<>();
        cbbLocMauSac = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbbLocSanPhamm = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        lblPageSP = new javax.swing.JLabel();
        btnTien = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnViewAll = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtMaSP = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtHaha = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btlClear1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Thương hiệu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Loại SP");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Chất liệu");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Màu sắc");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Kích cỡ");

        cboLSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboLSP.setForeground(new java.awt.Color(51, 51, 51));
        cboLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLSPMouseClicked(evt);
            }
        });
        cboLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLSPActionPerformed(evt);
            }
        });

        cboKichCo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboKichCo.setForeground(new java.awt.Color(51, 51, 51));

        cboThuongHIeu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboThuongHIeu.setForeground(new java.awt.Color(51, 51, 51));
        cboThuongHIeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHIeuActionPerformed(evt);
            }
        });

        cboMauSac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboMauSac.setForeground(new java.awt.Color(51, 51, 51));
        cboMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauSacActionPerformed(evt);
            }
        });

        cboChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboChatLieu.setForeground(new java.awt.Color(51, 51, 51));

        btnChatLieu.setBackground(new java.awt.Color(0, 0, 0));
        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnKichCo.setBackground(new java.awt.Color(0, 0, 0));
        btnKichCo.setForeground(new java.awt.Color(204, 255, 255));
        btnKichCo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichCoActionPerformed(evt);
            }
        });

        btnMauSac.setBackground(new java.awt.Color(0, 0, 0));
        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnLoaiTheThao.setBackground(new java.awt.Color(0, 0, 0));
        btnLoaiTheThao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnLoaiTheThao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiTheThaoActionPerformed(evt);
            }
        });

        btnThuongHieu.setBackground(new java.awt.Color(0, 0, 0));
        btnThuongHieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuongHieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoaiTheThao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMauSac)))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cboThuongHIeu, 0, 146, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThuongHieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKichCo)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChatLieu)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboChatLieu, cboKichCo, cboLSP, cboMauSac, cboThuongHIeu});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoaiTheThao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboThuongHIeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mã :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Mã vạch :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Mô tả :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Số lượng :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Giá nhập :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Giá bán :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Trạng thái :");

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        txtMaVach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaVach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMaVach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaVachActionPerformed(evt);
            }
        });

        txtMoT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMoT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tên SP:");

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        cboTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenSPActionPerformed(evt);
            }
        });

        ckbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ckbTrangThai.setText("Còn hàng");
        ckbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTrangThaiActionPerformed(evt);
            }
        });

        btlClear.setBackground(new java.awt.Color(0, 0, 0));
        btlClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btlClear.setForeground(new java.awt.Color(255, 255, 255));
        btlClear.setText("CLEAR");
        btlClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlClearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Thông tin sản phẩm chi tiết");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(36, 36, 36)
                        .addComponent(txtMoT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ckbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(25, 25, 25)
                            .addComponent(cboTenSP, 0, 207, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaVach))))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btlClear)
                .addGap(118, 118, 118))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboTenSP, ckbTrangThai, txtGiaBan, txtGiaNhap, txtMa, txtMaVach, txtMoT, txtSoLuong});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtMaVach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ckbTrangThai))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btlClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTenSP, ckbTrangThai, txtGiaBan, txtGiaNhap, txtMa, txtMaVach, txtMoT, txtSoLuong});

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Thuộc tính sản phẩm");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnThemSanPham.setBackground(new java.awt.Color(0, 0, 0));
        btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnThemSanPham.setText("Thêm sản phẩm mới");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaThongTinSp.setBackground(new java.awt.Color(0, 0, 0));
        btnSuaThongTinSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThongTinSp.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTinSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pencil-20.png"))); // NOI18N
        btnSuaThongTinSp.setText("Sửa thông tin SP");
        btnSuaThongTinSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinSpActionPerformed(evt);
            }
        });

        btnLuuDanhSach.setBackground(new java.awt.Color(0, 0, 0));
        btnLuuDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-microsoft-excel-30.png"))); // NOI18N
        btnLuuDanhSach.setText("Lưu DS SP");
        btnLuuDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDanhSachActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-available-updates-20 (1).png"))); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaThongTinSp, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLuuDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLuuDanhSach, btnThemSanPham});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnThemSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnSuaThongTinSp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuuDanhSach)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

        tblSPCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Mã Vạch", "Mô tả", "Số lượng", "Tên SP", "Thương hiệu", "Loại SP", "Kích cỡ", "Màu sắc", "Chất liệu", "Gía nhập ", "Gía bán", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSPCTMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSPCT);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Kích cỡ");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Loại SP");

        cbbLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSanPhamActionPerformed(evt);
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

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tên sản phẩm");

        btlHoanTac.setBackground(new java.awt.Color(0, 0, 0));
        btlHoanTac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btlHoanTac.setForeground(new java.awt.Color(255, 255, 255));
        btlHoanTac.setText("Hoàn tác");
        btlHoanTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlHoanTacActionPerformed(evt);
            }
        });

        cbbLocMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocMauSacActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Thương Hiệu");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Chất Liệu");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Màu Sắc");

        cbbLocSanPhamm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                cbbLocSanPhammComponentResized(evt);
            }
        });
        cbbLocSanPhamm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocSanPhammActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("First page");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnLui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        lblPageSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPageSP.setText("?");

        btnTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Right.png"))); // NOI18N
        btnTien.setText(">>");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Last page");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách sản phẩm chi tiết");

        btnViewAll.setBackground(new java.awt.Color(0, 0, 0));
        btnViewAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewAll.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAll.setText("Xem tất cả SPCT");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButton3)
                .addGap(63, 63, 63)
                .addComponent(btnLui)
                .addGap(61, 61, 61)
                .addComponent(lblPageSP, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnTien)
                .addGap(34, 34, 34)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel28))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLocMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLocSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btlHoanTac))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btnViewAll)))
                        .addGap(91, 91, 91))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbLoaiSanPham, cbbLocChatLieuu, cbbLocKichCoo, cbbLocMauSac, cbbLocSanPhamm, cbbLocThuongHieu});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel31))
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbLocKichCoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbLocMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btlHoanTac)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLocThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocChatLieuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocSanPhamm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnViewAll)))))
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnLui)
                    .addComponent(lblPageSP)
                    .addComponent(btnTien)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Danh sách sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMaSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMaSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaSPCaretUpdate(evt);
            }
        });
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        jLabel22.setText("                   Tìm Kiếm");

        btnThemSP.setBackground(new java.awt.Color(0, 0, 0));
        btnThemSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setBackground(new java.awt.Color(0, 0, 0));
        btnSuaSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaSP.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pencil-20.png"))); // NOI18N
        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSP)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaSP))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Thông tin sản phẩm");

        txtHaha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHahaActionPerformed(evt);
            }
        });

        jLabel23.setText("MÃ:");

        jLabel25.setText("TÊN:");

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        btlClear1.setBackground(new java.awt.Color(0, 0, 0));
        btlClear1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btlClear1.setForeground(new java.awt.Color(255, 255, 255));
        btlClear1.setText("CLEAR");
        btlClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHaha)
                            .addComponent(txtTen)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btlClear1)
                .addGap(123, 123, 123))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtHaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addComponent(btlClear1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Chức năng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(170, 170, 170))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLSPMouseClicked
        //        cboLTT.removeAllItems();
        //        listCboLTT.removeAll(listCboLTT);
        //        for (LoaiTheThaoViewModel ltt : listLTT) {
        //            listCboLTT.add(ltt.getTen());
        //        }
        //        showDataCBO(listCboLTT, dcbLTT);
    }//GEN-LAST:event_cboLSPMouseClicked

    private void cboLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLSPActionPerformed

    }//GEN-LAST:event_cboLSPActionPerformed

    private void cboThuongHIeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHIeuActionPerformed

    }//GEN-LAST:event_cboThuongHIeuActionPerformed

    private void cboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMauSacActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        ViewChatLieu cl = new ViewChatLieu();
        cl.setVisible(true);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichCoActionPerformed
        ViewSize siz = new ViewSize();
        siz.setVisible(true);

    }//GEN-LAST:event_btnKichCoActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        ViewMauSac ms = new ViewMauSac();
        ms.setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnLoaiTheThaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiTheThaoActionPerformed
        ViewLoaiSanPham lsp = new ViewLoaiSanPham();
        lsp.setVisible(true);
    }//GEN-LAST:event_btnLoaiTheThaoActionPerformed

    private void btnThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuongHieuActionPerformed
        ViewThuongHieu th = new ViewThuongHieu();
        th.setVisible(true);
    }//GEN-LAST:event_btnThuongHieuActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtMaVachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaVachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaVachActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
 if (validateThem()) {
            SanPhamChiTietViewModel spct = nhapDuLieu();
             
                    
            int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm dữ liệu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (confirmResult == JOptionPane.YES_OPTION) {
                         
                String message = service.getAdd(spct);
               
             
                 
      
                JOptionPane.showMessageDialog(this, message);
              
               listSPCTtable = service.getAllTable();
                showDataTable(listSPCTtable);
                int rowIndex = tblSPCT.getRowCount() - 1;
        if (rowIndex >= 0) {
            tblSPCT.setRowSelectionInterval(rowIndex, rowIndex);
        }
                clearFrom();
            }
        }
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSuaThongTinSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinSpActionPerformed
 int index = tblSPCT.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật dữ liệu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (confirmResult == JOptionPane.YES_OPTION) {
                if (validateTable()) {
                    SanPhamChiTietViewModel spct = updateData();
                    SPCTViewModel spct1 = listSPCTtable.get(index);
                    JOptionPane.showMessageDialog(this, service.getUpdate(spct, spct1.getId()));
                    listSPCTtable = service.getAllTable();
                    showDataTable(listSPCTtable);
                            int rowIndex = tblSPCT.getRowCount() - 1;
        if (rowIndex >= 0) {
            tblSPCT.setRowSelectionInterval(rowIndex, rowIndex);
        }
                clearFrom();
                  
                }
            }
        }
    }//GEN-LAST:event_btnSuaThongTinSpActionPerformed

    private void btnLuuDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDanhSachActionPerformed
int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu dữ liệu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {

            System.out.println("Create file excel");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Customer_Info");
            int rowNum = 0;
            Row firstRow = sheet.createRow(rowNum++);
            Cell firstCell = firstRow.createCell(0);
            firstCell.setCellValue("Danh Sách Sản Phẩm");
            listSPCTtable = service.getAllTable();
            for (SPCTViewModel spct : listSPCTtable) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(spct.getId());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(spct.getMa());
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(spct.getMaVach());
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(spct.getMoTa());
                Cell cell5 = row.createCell(4);
                cell5.setCellValue(spct.getSoLuong());
                Cell cell6 = row.createCell(5);
                cell6.setCellValue(spct.getLoaiSanPham());
                Cell cell7 = row.createCell(6);
                cell7.setCellValue(spct.getThuongHieu());
                Cell cell8 = row.createCell(7);
                cell8.setCellValue(spct.getLoaiSanPham());
                Cell cell9 = row.createCell(8);
                cell9.setCellValue(spct.getKichCo());
                Cell cell10 = row.createCell(9);
                cell10.setCellValue(spct.getMauSac());
                Cell cell11 = row.createCell(10);
                cell11.setCellValue(spct.getChatLieu());
                Cell cell12 = row.createCell(11);
                cell12.setCellValue(spct.getGiaNhap());
                Cell cell13 = row.createCell(12);
                cell13.setCellValue(spct.getGiaBan());
                Cell cell14 = row.createCell(13);
                cell14.setCellValue(spct.isTrangThai());
            }
            try {
                FileOutputStream outputStream = new FileOutputStream("DanhSach.xlsx");
                workbook.write(outputStream);
                workbook.close();
                JOptionPane.showMessageDialog(this, "Lưu Thành Công");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lưu Thất Bại");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lưu Thất Bại");
            }
            System.out.println("Done");
        }
    }//GEN-LAST:event_btnLuuDanhSachActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
 clearFrom();
        cboKichCo.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboThuongHIeu.setSelectedIndex(0);
        cboLSP.setSelectedIndex(0);
        

        cleaLoc();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cboTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenSPActionPerformed

    private void ckbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbTrangThaiActionPerformed

    private void btlClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlClearActionPerformed
        // TODO add your handling code here:
        clearFrom();
    }//GEN-LAST:event_btlClearActionPerformed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int totalIteams = chiTietRepository.getTotalIteams();
        int end = (int) Math.ceil((double) totalIteams / size);
        ht = end;
        int page = (ht - 1) * size;
        showDataTablePhanTrang(page, size);
        updatePage();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        int recordCount = LoadSPCTData(ht, size);
        if (recordCount > 0) {
            ht++;
        } else {
            ht = 1; // Quay lại trang đầu tiên nếu không còn bản ghi nào
            LoadSPCTData(ht - 1, size);
        }
        updatePage();
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        if (ht > 1) {
            ht--;
        } else {
            int totalItems = chiTietRepository.getTotalIteams();
            int maxpage = (int) Math.ceil((double) totalItems / size);
            ht = (maxpage == 0) ? 1 : maxpage; // Quay lại trang cuối cùng nếu đang ở trang đầu tiên
        }
        LoadSPCTData(ht - 1, size);
        updatePage();
    }//GEN-LAST:event_btnLuiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ht = 1;
        showDataTablePhanTrang(ht, size);
        updatePage();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbbLocSanPhammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocSanPhammActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocSanPhammActionPerformed

    private void cbbLocSanPhammComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cbbLocSanPhammComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocSanPhammComponentResized

    private void cbbLocMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLocMauSacActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        List<SPCTViewModel> listLoc = new ArrayList<>();
        for (SPCTViewModel c : listSPCTtable) {
            if ((cbbLocSanPhamm.getSelectedItem().equals("") || cbbLocSanPhamm.getSelectedItem().equals(c.getTenSP()))
                && (cbbLocKichCoo.getSelectedItem().equals("") || cbbLocKichCoo.getSelectedItem().equals(c.getKichCo()))
                && (cbbLoaiSanPham.getSelectedItem().equals("") || cbbLoaiSanPham.getSelectedItem().equals(c.getLoaiSanPham()))
                && (cbbLocMauSac.getSelectedItem().equals("") || cbbLocMauSac.getSelectedItem().equals(c.getMauSac()))
                && (cbbLocChatLieuu.getSelectedItem().equals("") || cbbLocChatLieuu.getSelectedItem().equals(c.getChatLieu()))
                && (cbbLocThuongHieu.getSelectedItem().equals("") || cbbLocThuongHieu.getSelectedItem().equals(c.getThuongHieu()))) {
                listLoc.add(c);
            }
            else {
                System.out.println("Không tìm thấy");

            }
            listSPCTtable = listLoc;
            showDataTable(listLoc);
            listSPCTtable = service.getAllTable();

        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void cbbLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSanPhamActionPerformed

    private void tblSPCTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_tblSPCTMouseEntered

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        fillData();
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
//        if (validateTable()) {
//            int index = tblSanPham.getSelectedRow();
//            SanPhamViewModel sp1 = listSp.get(index);
//            SanPhamViewModel sp = updateData();
//            JOptionPane.showMessageDialog(this, service.getUpdate(sp, sp1.getId()));
//            listSp = service.getAll();
//            showDataTable(listSp);
//        }
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
         if (validateTable1()) {
            SanPhamViewModel sp = nhapDuLieu1();
            JOptionPane.showMessageDialog(this, serviceSp.getAdd(sp));
            listSP= serviceSp.getAll();
            showDataTableSP(listSP);
             showdataCBBsp();
         }
        
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        clicked();
        
          
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtHahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHahaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHahaActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void btlHoanTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlHoanTacActionPerformed
        listSPCTtable = service.getAllTable();
        dtm = (DefaultTableModel) this.tblSPCT.getModel();
        dtm.setRowCount(0);
        showDataTableSP(listSP);
        cleaLoc();
         btnLui.setEnabled(false);
        btnTien.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
    }//GEN-LAST:event_btlHoanTacActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
          showDataTablePhanTrang(ht, size);
           btnLui.setEnabled(true);
        btnTien.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void txtMaSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaSPCaretUpdate
      
    }//GEN-LAST:event_txtMaSPCaretUpdate

    private void btlClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlClear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btlClear1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlClear;
    private javax.swing.JButton btlClear1;
    private javax.swing.JButton btlHoanTac;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnKichCo;
    private javax.swing.JButton btnLoaiTheThao;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnLuuDanhSach;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnSuaThongTinSp;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThuongHieu;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JComboBox<String> cbbLoaiSanPham;
    private javax.swing.JComboBox<String> cbbLocChatLieuu;
    private javax.swing.JComboBox<String> cbbLocKichCoo;
    private javax.swing.JComboBox<String> cbbLocMauSac;
    private javax.swing.JComboBox<String> cbbLocSanPhamm;
    private javax.swing.JComboBox<String> cbbLocThuongHieu;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboLSP;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JComboBox<String> cboThuongHIeu;
    private javax.swing.JCheckBox ckbTrangThai;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPageSP;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHaha;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaVach;
    private javax.swing.JTextField txtMoT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
