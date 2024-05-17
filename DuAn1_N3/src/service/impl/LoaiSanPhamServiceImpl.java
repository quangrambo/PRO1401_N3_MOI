/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPhamModel;
import repository.LoaiSanPhamRepository;
import service.LoaiSanPhamService;
import viewmodel.LoaiSanPhamViewModel;

/**
 *
 * @author pc
 */
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

    LoaiSanPhamRepository lttRepo = new LoaiSanPhamRepository();

    @Override
    public List<LoaiSanPhamViewModel> getAll() {
        List<LoaiSanPhamModel> listAll = lttRepo.getAll();
        List<LoaiSanPhamViewModel> listTable = new ArrayList<>();
        for (LoaiSanPhamModel ltt : listAll) {
            listTable.add(new LoaiSanPhamViewModel(ltt.getId(), ltt.getMa(), ltt.getTen()));
        }
        return listTable;
    }

    @Override
    public String getAdd(LoaiSanPhamViewModel ltt) {
        LoaiSanPhamModel lttmd = new LoaiSanPhamModel(ltt.getId(), ltt.getMa(), ltt.getTen());
        boolean them = lttRepo.getAdd(lttmd);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(LoaiSanPhamViewModel ltt, int id) {
        LoaiSanPhamModel lttmd = new LoaiSanPhamModel(ltt.getId(), ltt.getMa(), ltt.getTen());
        boolean sua = lttRepo.getUpdate(lttmd, id);
        if (sua) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa = lttRepo.getDelete( id);
        if (xoa) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
