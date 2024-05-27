/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.HDTableModel;
import model.HoaDonDomain;
import repository.HDTableRepository;
import repository.HoaDonRepository;
import service.IHoaDonService;
import viewmodel.HDTableVIewModel;
import viewmodel.HoaDonView;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {
private HoaDonRepository rs = new HoaDonRepository();
    HDTableRepository HDRepo=new HDTableRepository();
    @Override
    public List<HoaDonView> getall() {
        List<viewmodel.HoaDonView> hdd = new ArrayList<>();
        List<HoaDonDomain> list = this.rs.getall();
        for (HoaDonDomain x : list) {
            HoaDonView hoaDonView = new HoaDonView(x.getId(), x.getMa(), x.getIdNV(), x.getIdKH(), x.getMaPGG(), x.getNgayTao(), x.getNgayThanhToan(), x.getTienGiam(), x.getTongTien(), x.getTienKhachDua(), x.getTienThua(), x.getTienTraTruoc(), x.getHinhThucThanhToan(), x.getMaChuyenKhoan(), x.getTienChuyenKhoan());
            hdd.add(hoaDonView);
        }
        return hdd;
        }

    @Override
    public boolean add(HoaDonView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(int id, HoaDonView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id_hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonView findById(String ma) {
        HoaDonDomain x = rs.findByMa(ma);
        HoaDonView hoaDonView = new HoaDonView(x.getId(), x.getMa(), x.getIdNV(), x.getIdKH(), x.getMaPGG(), x.getNgayTao(), x.getNgayThanhToan(), x.getTienGiam(), x.getTongTien(), x.getTienKhachDua(), x.getTienThua(), x.getTienTraTruoc(), x.getHinhThucThanhToan(), x.getMaChuyenKhoan(), x.getTienChuyenKhoan());
        hoaDonView.setTrangThai(x.getTrangThai());
        return hoaDonView;
        }

    @Override
    public List<HoaDonView> searchByDate(Date start, Date end, int type) {
        List<HoaDonDomain> list=rs.searchByDate(start, end, type);
        List<HoaDonView> listHDV=new ArrayList<>();
        for (HoaDonDomain x : list) {
            HoaDonView hoaDonView = new HoaDonView(x.getId(), x.getMa(), x.getIdNV(), x.getIdKH(), x.getMaPGG(), x.getNgayTao(), x.getNgayThanhToan(), x.getTienGiam(), x.getTongTien(), x.getTienKhachDua(), x.getTienThua(), x.getTienTraTruoc(), x.getHinhThucThanhToan(), x.getMaChuyenKhoan(), x.getTienChuyenKhoan());
            listHDV.add(hoaDonView);
        }
        return listHDV;
    }

    @Override
    public List<HDTableVIewModel> getAllTable() {
        List<HDTableModel> getAll=HDRepo.getAll();
        List<HDTableVIewModel> getTable=new ArrayList<>();
        for (HDTableModel hd : getAll) {
            getTable.add(new HDTableVIewModel(hd.getId(),hd.getMa(),hd.getTenNhanVien(), hd.getTenKhachHang(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai()));
        }
        return getTable;
    }
    
}
