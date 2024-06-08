/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.JDBCHelper;

/**
 *
 * @author Admin
 */
public class ThongKeRepository {
    public List<Object[]> thongKeDT(int index, String ngayBD, String ngayKT) {
        List<Object[]> list = new ArrayList<>();
        String query = "EXEC SP_THONGKE2 ?,?,?";
        ResultSet rs = null;
        try {
            rs = JDBCHelper.excuteQuery(query, index, ngayBD, ngayKT);
            while (rs != null && rs.next()) {
                Object[] a = { rs.getString(1), rs.getDouble(2) };
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCHelper.closeResources(null, null, rs);  // Close ResultSet
        }
        return list;
    }
    
    
    
    public List<Object[]>thongKeSPBanChay(){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.excuteQuery("EXEC SP_THONGKESPBANCHAY");
            while (rs.next()) {                
                Object[] a ={rs.getInt(1),rs.getString(2),rs.getString(3)}; 
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
  
}
