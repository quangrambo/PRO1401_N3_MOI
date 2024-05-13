/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SPCTModel;
import repository.SPCTRepository;
import service.SanPhamChiTietService;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService{
    SPCTRepository spRepo = new SPCTRepository();

    @Override
    public List<SanPhamChiTietViewModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SPCTViewModel> getAllPhanTrang(int offset, int fetchSize) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAdd(SanPhamChiTietViewModel spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdate(SanPhamChiTietViewModel spct, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SPCTViewModel> getAllTable() {
List<SPCTModel> listAll = spRepo.getAll();
        List<SPCTViewModel> listTable = new ArrayList<>();
        for (SPCTModel spct : listAll) {
            listTable.add(new SPCTViewModel(spct.getId(), spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), spct.getTenSP(), spct.getThuongHieu(), spct.getLoaiSanPham(), spct.getKichCo(), spct.getMauSac(), spct.getChatLieu(), spct.getGiaNhap(), spct.getGiaBan(), spct.isTrangThai()));
        }
        return listTable;    }

    @Override
    public List<SPCTViewModel> getSearch(String ma, String mavach, String moTa, String soLuong, String tenSp, String tenTH, String tenLSP, String tenKichCo, String mauSac, String chatLieu, String giaNhap, String giaBan, String trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateSoLuong(int soLuong, int id, int giaNhap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateSLMua(int soLuong, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
