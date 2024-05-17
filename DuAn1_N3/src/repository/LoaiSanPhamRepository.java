/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.LoaiSanPhamModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class LoaiSanPhamRepository {
    public List<LoaiSanPhamModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[TEN]
                     FROM [dbo].[LOAISANPHAM]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<LoaiSanPhamModel> listLTT = new ArrayList<>();
            while (rs.next()) {
                LoaiSanPhamModel ltt = new LoaiSanPhamModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listLTT.add(ltt);
            }
            return listLTT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getAdd(LoaiSanPhamModel ltt) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[LOAISANPHAM]
                              ([MA]
                              ,[TEN])
                        VALUES
                              (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ltt.getMa());
            pr.setObject(2, ltt.getTen());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(LoaiSanPhamModel ltt, int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[LOAISANPHAM]
                      SET [MA] =?
                         ,[TEN] =?
                    WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ltt.getMa());
            pr.setObject(2, ltt.getTen());
            pr.setObject(3, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                  DELETE FROM [dbo].[LOAISANPHAM]
                         WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            
            pr.setObject(1, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
}
