/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import model.HoaDonCTDomain;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Tus
 */
public class HoaDonCTRepository implements HoaDonCTRepo {

    @Override
    public List<HoaDonCTDomain> getall() {
        ArrayList<HoaDonCTDomain> hdct = new ArrayList<>();
//        try {
//            Connection cnn = DBConnect.getConnection();
//            String sql = "SELECT\n"
//                    + "HOA_DON_CT.ID_HD,\n"
//                    + "HOA_DON_CT.ID,\n"
//                    + "HOA_DON_CT.ID_SPCT,\n"
//                    + "HOA_DON_CT.SOLUONG,\n"
//                    + "HOA_DON_CT.DONGIA\n"
//                    + "FROM\n"
//                    + "HOA_DON_CT\n";
//            PreparedStatement ps = cnn.prepareStatement(sql);
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            while (rs.next()) {
//                HoaDonCTDomain hdd = new HoaDonCTDomain(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(4), rs.getInt(5));
//                hdct.add(hdd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return hdct;
    }

    @Override
    public boolean add(HoaDonCTDomain ht) {
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = "INSERT INTO HOA_DON_CT(ID_HD, ID_SPCT,LOAISANPHAM,THUONGHIEU,MAUSAC,KICHCO,CHATLIEU, SOLUONG, DONGIA)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, ht.getIdHD());
            ps.setInt(2, ht.getIdSPCT());
            ps.setString(3, ht.getLoaiSanPham());
            ps.setString(4, ht.getThuongHieu());
            ps.setString(5, ht.getMauSac());
            ps.setString(6, ht.getKichCo());
            ps.setString(7, ht.getChatLieu());
            ps.setInt(8,ht.getSoLuong());
            ps.setInt(9, ht.getDonGia());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, HoaDonCTDomain ht) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE HOA_DON_CT set ID_HD = ?,ID_SPCT = ?, SOLUONG = ?, DONGIA = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ht.getIdHD());
            ps.setInt(2, ht.getIdSPCT());
            ps.setInt(3, ht.getSoLuong());
            ps.setInt(4, ht.getDonGia());
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE HOA_DON_CT where ID =  ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPhamHDViewModel> getByHdId(int idHd) {
 ArrayList<SanPhamHDViewModel> hdct = new ArrayList<>();
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = "select h.id, sp.TEN,h.LOAISANPHAM,h.THUONGHIEU,h.MAUSAC,h.KICHCO, h.CHATLIEU, h.SOLUONG, h.DONGIA from HOA_DON_CT h\n" +
            "inner join SAN_PHAM_CHI_TIET spct on spct.id = h.ID_SPCT\n" +
            "inner join SAN_PHAM sp on spct.ID_SP = sp.ID where h.ID_HD = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idHd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                SanPhamHDViewModel hdd = new SanPhamHDViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(9));
                hdct.add(hdd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }

}
