/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.sql.Date;
import java.util.List;
import model.HoaDonDomain;

/**
 *
 * @author Admin
 */
public interface HoaDonRepo {
    List<HoaDonDomain> getall();
    boolean add(HoaDonDomain hd);
    boolean update(int id, HoaDonDomain hd);
    boolean delete(int  hd);
    HoaDonDomain findByMa(String ma);
    List<HoaDonDomain> searchByDate(Date start, Date end, int type);
}
