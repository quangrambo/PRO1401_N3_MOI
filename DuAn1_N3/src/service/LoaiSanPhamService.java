/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.LoaiSanPhamViewModel;

/**
 *
 * @author pc
 */
public interface LoaiSanPhamService {
    
    List<LoaiSanPhamViewModel> getAll();
    
    String getAdd(LoaiSanPhamViewModel ltt);
    
    String getUpdate(LoaiSanPhamViewModel ltt,int id);
    
    String getDelete(int id);
}
