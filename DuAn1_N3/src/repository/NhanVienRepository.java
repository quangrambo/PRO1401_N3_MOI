/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import viewmodel.QLNhanVien;
import java.sql.*;
import model.NhanVien;
import utility.JDBCHelper;
import viewmodel.QLKhachHang;

/**
 *
 * @author adm
 */
public class NhanVienRepository {

    DBConnect con;

    public ArrayList<QLNhanVien> getListFromDB() {
        ArrayList<QLNhanVien> list = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI from NHAN_VIEN";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setCccd(rs.getString(6));
                nv.setNgaySinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getInt(10));
                nv.setTrangThai(rs.getInt(11));
                list.add(nv);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public Boolean Them(NhanVien nhanVien) {
        String sql = "insert into NHAN_VIEN(MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getCccd());
            ps.setObject(6, nhanVien.getNgaySinh());
            ps.setObject(7, nhanVien.getDiaChi());
            ps.setObject(8, nhanVien.getEmail());
            ps.setObject(9, nhanVien.getChucVu());
            ps.setObject(10, nhanVien.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean Xoa(int id) {
        String sql = "Delete NHAN_VIEN where ID = ?";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean Sua(int id, NhanVien nhanVien) {
        String sql = "update NHAN_VIEN set MA =?, HOTEN=?, GIOTINH=?, SDT=?, CCCD=?, NGAYSINH=?, DIACHI=?,"
                + " EMAIL =?, CHUCVU =?, TRANGTHAI =? where ID = ?";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getCccd());
            ps.setObject(6, nhanVien.getNgaySinh());
            ps.setObject(7, nhanVien.getDiaChi());
            ps.setObject(8, nhanVien.getEmail());
            ps.setObject(9, nhanVien.getChucVu());
            ps.setObject(10, nhanVien.getTrangThai());
            ps.setObject(11, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<QLNhanVien> TimKiemTheoMa(String name) {
        ArrayList<QLNhanVien> listNV = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI from NHAN_VIEN "
                + "where MA like '%" + name + "%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setCccd(rs.getString(6));
                nv.setNgaySinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getInt(10));
                nv.setTrangThai(rs.getInt(11));
                listNV.add(nv);

            }
        } catch (Exception e) {
        }
        return listNV;
    }

    public ArrayList<QLNhanVien> getPhanTrang(int offset, int fetchSize) {
        ArrayList<QLNhanVien> list = new ArrayList<>();
        String sql = """
                     	 SELECT dbo.NHAN_VIEN.ID, dbo.NHAN_VIEN.MA, dbo.NHAN_VIEN.HOTEN, dbo.NHAN_VIEN.GIOTINH, dbo.NHAN_VIEN.SDT, dbo.NHAN_VIEN.CCCD, dbo.NHAN_VIEN.NGAYSINH, dbo.NHAN_VIEN.DIACHI, dbo.NHAN_VIEN.EMAIL, 
                                                                                         dbo.NHAN_VIEN.CHUCVU, dbo.NHAN_VIEN.TRANGTHAI, dbo.TAI_KHOAN.TENDANGNHAP, dbo.TAI_KHOAN.MATKHAU
                                                                       FROM     dbo.NHAN_VIEN INNER JOIN
                                                                                         dbo.TAI_KHOAN ON dbo.NHAN_VIEN.ID = dbo.TAI_KHOAN.ID_NV
                                                                       				 
                                                  									 order by id offset ? row fetch next ? rows only;
                     """;
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = JDBCHelper.excuteQuery(sql, offset, fetchSize);
            while (rs.next()) {
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setCccd(rs.getString(6));
                nv.setNgaySinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getInt(10));
                nv.setTrangThai(rs.getInt(11));
                nv.setTenDN(rs.getString(12));
                nv.setMatKhau(rs.getString(13));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalItems() {
        int totalItems = 0;
        String sql = "select COUNT(*) From NHAN_VIEN Where NHAN_VIEN.TRANGTHAI =1";

        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            if (rs.next()) {
                totalItems = rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalItems;
    }
}
