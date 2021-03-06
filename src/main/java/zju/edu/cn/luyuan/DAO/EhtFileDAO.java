package zju.edu.cn.luyuan.DAO;

import zju.edu.cn.luyuan.bean.EhtFile;
import zju.edu.cn.luyuan.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EhtFileDAO {
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from ehtfile";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public int getTotalByMid(int mid) {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from ehtfile where mid="+mid;

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    //chip,stype,sversion,sdate,htype,remarks,note,date
    public void add(EhtFile bean) {
        String sql = "insert into ehtfile (chip,stype,sversion,sdate,htype,remarks,note,date) values(?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getChip());
            ps.setString(2, bean.getStype());
            ps.setInt(3, bean.getSversion());
            ps.setString(4, bean.getSdate());
            ps.setString(5, bean.getHtype());
            ps.setString(6, bean.getRemarks());
            ps.setString(7, bean.getNote());
            ps.setLong(8, bean.getDate());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from ehtfile where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //chip,stype,sversion,sdate,htype,remarks,note,date
    public void updateAllById(EhtFile bean) {
        String sql = "update ehtfile set chip=?,stype=?,sversion=?,sdate=?,htype=?,remarks=?,note=?,date=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getChip());
            ps.setString(2, bean.getStype());
            ps.setInt(3, bean.getSversion());
            ps.setString(4, bean.getSdate());
            ps.setString(5, bean.getHtype());
            ps.setString(6, bean.getRemarks());
            ps.setString(7, bean.getNote());
            ps.setLong(8, bean.getDate());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //chip,stype,sversion,sdate,htype,remarks,note,date
    public void updatePartById(EhtFile bean) {
        String sql = "update ehtfile set chip=?,stype=?,sversion=?,sdate=?,htype=?,remarks=?,note=?,date=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getChip());
            ps.setString(2, bean.getStype());
            ps.setInt(3, bean.getSversion());
            ps.setString(4, bean.getSdate());
            ps.setString(5, bean.getHtype());
            ps.setString(6, bean.getRemarks());
            ps.setString(7, bean.getNote());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////chip,stype,sversion,sdate,htype,remarks,note,date
    public EhtFile getById(int id) {
        EhtFile bean = new EhtFile();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from ehtfile where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                int chip = rs.getInt("chip");
                String stype=rs.getString("stype");
                int sversion = rs.getInt("sversion");
                String sdate=rs.getString("sdate");
                String htype=rs.getString("htype");
                String remarks=rs.getString("remarks");
                String note = rs.getString("note");
                long date = rs.getLong("bdate");
                bean.setChip(chip);
                bean.setStype(stype);
                bean.setSversion(sversion);
                bean.setSdate(sdate);
                bean.setHtype(htype);
                bean.setRemarks(remarks);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public List<EhtFile> list() {
        return list(0,Short.MAX_VALUE);
    }
    public List<EhtFile> list(int start, int count) {
        List<EhtFile> beans = new ArrayList<EhtFile>();
        String sql = "select * from ehtfile limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EhtFile bean = new EhtFile();
                int id = rs.getInt(1);
                int chip = rs.getInt("chip");
                String stype=rs.getString("stype");
                int sversion = rs.getInt("sversion");
                String sdate=rs.getString("sdate");
                String htype=rs.getString("htype");
                String remarks=rs.getString("remarks");
                String note = rs.getString("note");
                long date = rs.getLong("bdate");
                bean.setChip(chip);
                bean.setStype(stype);
                bean.setSversion(sversion);
                bean.setSdate(sdate);
                bean.setHtype(htype);
                bean.setRemarks(remarks);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public List<EhtFile> listByChip(int chip) {
        List<EhtFile> beans = new ArrayList<EhtFile>();
        String sql = "select * from ehtfile where chip="+chip;
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EhtFile bean = new EhtFile();
                int id = rs.getInt(1);
                String stype=rs.getString("stype");
                int sversion = rs.getInt("sversion");
                String sdate=rs.getString("sdate");
                String htype=rs.getString("htype");
                String remarks=rs.getString("remarks");
                String note = rs.getString("note");
                long date = rs.getLong("date");
                bean.setChip(chip);
                bean.setStype(stype);
                bean.setSversion(sversion);
                bean.setSdate(sdate);
                bean.setHtype(htype);
                bean.setRemarks(remarks);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public List<EhtFile> listByChipStypeHtype(int chip,String stype,String htype) {
        List<EhtFile> beans = new ArrayList<EhtFile>();
        String sql = "select * from ehtfile where chip=? and stype=? and htype=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, chip);
            ps.setString(2, stype);
            ps.setString(3, htype);
            ResultSet rs = ps.executeQuery();
            System.out.println("sql:"+sql);
            while (rs.next()) {
                EhtFile bean = new EhtFile();
                int id = rs.getInt(1);
                int sversion = rs.getInt("sversion");
                String sdate=rs.getString("sdate");
                String remarks=rs.getString("remarks");
                String note = rs.getString("note");
                long date = rs.getLong("date");
                bean.setChip(chip);
                bean.setStype(stype);
                bean.setSversion(sversion);
                bean.setSdate(sdate);
                bean.setHtype(htype);
                bean.setRemarks(remarks);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

//    public boolean checkVersionExist(int type,int version) {
//        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
//            String sql = "select * from ehtfile where type=" + type+" and version="+version;
//            ResultSet rs = s.executeQuery(sql);
//
//            if (rs.next()) {
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        return true;
//    }
}
