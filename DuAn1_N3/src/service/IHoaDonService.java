/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.Date;
import java.util.List;
import viewmodel.HDTableVIewModel;
import viewmodel.HoaDonView;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {
    List<HoaDonView> getall();
    boolean add(HoaDonView hd);
    boolean update(int id, HoaDonView hd);
    boolean delete(int id_hd);
    HoaDonView findById(String ma);
    List<HoaDonView> searchByDate(Date start, Date end, int type);
    List<HDTableVIewModel> getAllTable();
}
