/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SPCTModel;
import utility.DBConnect;
import utility.JDBCHelper;

/**
 *
 * @author Admin
 */
public class SPCTRepository {
    public List<SPCTModel> getAll() {
        String qery = """
                  				   SELECT SAN_PHAM_CHI_TIET.[ID]
                                                    ,SAN_PHAM_CHI_TIET.[MA]
                                                    ,[MAVACH]
                                                    ,[MOTA]
                                                    ,SAN_PHAM_CHI_TIET.[SOLUONG]
                                                    ,SAN_PHAM.[TEN] AS TENSANPHAM
                                                    ,THUONG_HIEU.[TEN] AS THUONGHIEU
                                                    ,LOAISANPHAM.[TEN] AS LOAISANPHAM
                                                    ,KICH_CO.[KICHCO] AS KICHCO
                                                    ,MAU_SAC.[TEN] AS MAUSAC
                                                    ,CHAT_LIEU.[TEN] AS CHATLIEU
                                                    ,[GIANHAP]
                                                    ,[GIABAN]
                                                    ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                                                FROM [dbo].[SAN_PHAM_CHI_TIET]
                                              	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                                              	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                                              	JOIN LOAISANPHAM ON LOAISANPHAM.ID=SAN_PHAM_CHI_TIET.ID_LSP
                                              	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                                              	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                                              	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                                               
                        			order by MA ASC
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<SPCTModel> listSPCT = new ArrayList<>();
            while (rs.next()) {
                SPCTModel spct = new SPCTModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                listSPCT.add(spct);
            }
            return listSPCT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public List<SPCTModel> getAllPhanTrang(int offset, int fetchSize) {
        String qery = """
                  				   SELECT SAN_PHAM_CHI_TIET.[ID]
                                                                                                       ,SAN_PHAM_CHI_TIET.[MA]
                                                                                                       ,[MAVACH]
                                                                                                       ,[MOTA]
                                                                                                       ,SAN_PHAM_CHI_TIET.[SOLUONG]
                                                                                                       ,SAN_PHAM.[TEN] AS TENSANPHAM
                                                                                                       ,THUONG_HIEU.[TEN] AS THUONGHIEU
                                                                                                       ,LOAISANPHAM.[TEN] AS LOAISANPHAM
                                                                                                       ,KICH_CO.[KICHCO] AS KICHCO
                                                                                                       ,MAU_SAC.[TEN] AS MAUSAC
                                                                                                       ,CHAT_LIEU.[TEN] AS CHATLIEU
                                                                                                       ,[GIANHAP]
                                                                                                       ,[GIABAN]
                                                                                                       ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                                                                                                   FROM [dbo].[SAN_PHAM_CHI_TIET]
                                                                                                 	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                                                                                                 	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                                                                                                 	JOIN LOAISANPHAM ON LOAISANPHAM.ID=SAN_PHAM_CHI_TIET.ID_LSP
                                                                                                 	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                                                                                                 	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                                                                                                 	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                        						--where SAN_PHAM_CHI_TIET.TRANGTHAI = 1
                                             	order by id 
                                             	OFFSET ? row
                                             	fetch next ? rows only;
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = JDBCHelper.excuteQuery(qery, offset, fetchSize);
            List<SPCTModel> listSPCT = new ArrayList<>();
            while (rs.next()) {
                SPCTModel spct = new SPCTModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                listSPCT.add(spct);
            }
            return listSPCT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public List<SPCTModel> getSearch( String ma, String mavach, String moTa, String soLuong, String tenSp, String tenTH, String tenLSP, String tenKichCo, String mauSac, String chatLieu, String giaNhap, String giaBan, String trangThai) {
        String qery = """
                 SELECT SAN_PHAM_CHI_TIET.[ID]
                                                  ,SAN_PHAM_CHI_TIET.[MA]
                                                  ,[MAVACH]
                                                  ,[MOTA]
                                                  ,SAN_PHAM_CHI_TIET.[SOLUONG]
                                                  ,SAN_PHAM.[TEN] AS TENSANPHAM
                                                  ,THUONG_HIEU.[TEN] AS THUONGHIEU
                                                  ,LOAISANPHAM.[TEN] AS LOAISANPHAM
                                                  ,KICH_CO.[KICHCO] AS KICHCO
                                                  ,MAU_SAC.[TEN] AS MAUSAC
                                                  ,CHAT_LIEU.[TEN] AS CHATLIEU
                                                  ,[GIANHAP]
                                                  ,[GIABAN]
                                                  ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                                              FROM [dbo].[SAN_PHAM_CHI_TIET]
                                            	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                                            	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                                            	JOIN LOAISANPHAM ON LOAISANPHAM.ID=SAN_PHAM_CHI_TIET.ID_LTT
                                            	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                                            	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                                            	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                                            WHERE SAN_PHAM_CHI_TIET.MA like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.MAVACH like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.MOTA like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.SOLUONG like '%'+ ? +'%' 
                      						OR SAN_PHAM.TEN like '%'+ ? +'%' 
                      						OR THUONG_HIEU.TEN like '%'+ ? +'%' 
                      						OR LOAISANPHAM.TEN like '%'+ ? +'%' 
                      						OR KICH_CO.KICHCO like '%'+ ? +'%' 
                      						OR MAU_SAC.TEN like '%'+ ? +'%' 
                      						OR CHAT_LIEU.TEN like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.GIANHAP like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.GIABAN like '%'+ ? +'%' 
                      						OR SAN_PHAM_CHI_TIET.TRANGTHAI like '%'+ ? +'%' 
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(qery)) {
          
            pr.setObject(1, ma);
            pr.setObject(2, mavach);
            pr.setObject(3, moTa);
            pr.setObject(4, soLuong);
            pr.setObject(5, tenSp);
            pr.setObject(6, tenTH);
            pr.setObject(7, tenLSP);
            pr.setObject(8, tenKichCo);
            pr.setObject(9, mauSac);
            pr.setObject(10, chatLieu);
            pr.setObject(11, giaNhap);
            pr.setObject(12, giaBan);
            pr.setObject(13, trangThai);
            ResultSet rs = pr.executeQuery();
            List<SPCTModel> listSearch = new ArrayList<>();
            while (rs.next()) {
                SPCTModel spct = new SPCTModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                listSearch.add(spct);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

}
