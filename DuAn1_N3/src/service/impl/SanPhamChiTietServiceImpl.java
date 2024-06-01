/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SPCTModel;
import model.SanPhamChiTietModel;
import repository.SPCTRepository;
import repository.SanPhamChiTietRepository;
import service.SanPhamChiTietService;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService{
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();

    SPCTRepository spRepo = new SPCTRepository();

    @Override
    public List<SanPhamChiTietViewModel> getAll() {
        List<SanPhamChiTietModel> listAll = spctRepo.getAll();
        List<SanPhamChiTietViewModel> listTable = new ArrayList<>();
        for (SanPhamChiTietModel spct : listAll) {
            listTable.add(new SanPhamChiTietViewModel(spct.getId(), spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), spct.getIdSP(), spct.getIdTH(), spct.getId(), spct.getIdKC(), spct.getIdMS(), spct.getIdCL(), spct.getGiaNhap(), spct.getGiaBan(), spct.isTrangThai()));
        }
        return listTable;
    }

    @Override
    public List<SPCTViewModel> getAllPhanTrang(int offset, int fetchSize) {
       List<SPCTModel> listAll = spRepo.getAllPhanTrang(offset, fetchSize);
        List<SPCTViewModel> listTable = new ArrayList<>();
        for (SPCTModel spct : listAll) {
            listTable.add(new SPCTViewModel(spct.getId(), spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), 
                    spct.getTenSP(), spct.getThuongHieu(), spct.getLoaiSanPham(), spct.getKichCo(), spct.getMauSac(), 
                    spct.getChatLieu(), spct.getGiaNhap(), spct.getGiaBan(), spct.isTrangThai()));
        }
        return listTable;}

    @Override
    public String getAdd(SanPhamChiTietViewModel spct) {
       SanPhamChiTietModel sp = new SanPhamChiTietModel(spct.getId(), spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), spct.getIdSP(), spct.getIdTH(), spct.getIdLSP(), spct.getIdKC(), spct.getIdMS(), spct.getIdCL(), spct.getGiaNhap(), spct.getGiaBan(), spct.isTrangThai());
        boolean them = spctRepo.getAdd(sp);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }}

    @Override
    public String getUpdate(SanPhamChiTietViewModel spct, int id) {
        SanPhamChiTietModel sp = new SanPhamChiTietModel(spct.getId(), 
                spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), spct.getIdSP(),
                spct.getIdTH(), spct.getIdLSP(), spct.getIdKC(), spct.getIdMS(), spct.getIdCL(), spct.getGiaNhap(), 
                spct.getGiaBan(), spct.isTrangThai());
        boolean sua = spctRepo.getUpdate(sp, id);
        if (sua) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }}

    @Override
    public String getDelete(int id) {
        boolean xoa = spctRepo.getDelete(id);
        if (xoa) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }}

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
        List<SPCTModel> listSearch = spRepo.getSearch(ma, mavach, moTa, soLuong, tenSp, tenTH, tenLSP, tenKichCo, mauSac, 
                chatLieu, giaNhap, giaBan, trangThai);
        List<SPCTViewModel> listTable = new ArrayList<>();
        for (SPCTModel spct : listSearch) {
            listTable.add(new SPCTViewModel(spct.getId(), spct.getMa(), spct.getMaVach(), spct.getMoTa(), spct.getSoLuong(), 
                    spct.getLoaiSanPham(), spct.getThuongHieu(), spct.getLoaiSanPham(), spct.getKichCo(), spct.getMauSac(), 
                    spct.getChatLieu(), spct.getGiaNhap(), spct.getGiaBan(), spct.isTrangThai()));
        }
        return listTable;}

    @Override
    public String getUpdateSoLuong(int soLuong, int id, int giaNhap) {
       boolean sua = spctRepo.getUpdateSoLuong(soLuong, id, giaNhap);
        if (sua) {
            return "Sua Thành Công";
        } else {
            return "Sua thất bại";
        }}

    @Override
    public String getUpdateSLMua(int soLuong, int id) {
        boolean sua = spctRepo.getUpdateSLKhiMua(soLuong, id);
        if (sua) {
            return "Sua Thành Công";
        } else {
            return "Sua thất bại";
        }
    }
    
}
