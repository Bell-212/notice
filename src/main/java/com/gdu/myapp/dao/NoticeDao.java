package com.gdu.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.myapp.dto.NoticeDto;

@Repository
public class NoticeDao {

  @Autowired
  private JdbcConnection jdbcConnection;
  
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  // 삽입
  public int add(NoticeDto noticeDto) {
    int addResult = 0;
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "INSERT INTO NOTICE_T(NOTICE_NO, GUBUN, TITLE, CONTENT) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
      ps = con.prepareStatement(sql);
      ps.setInt(1, noticeDto.getGubun());
      ps.setString(2, noticeDto.getTitle());
      ps.setString(3, noticeDto.getContent());
      addResult = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    return addResult;
  }
  
  // 수정
  public int modify(NoticeDto noticeDto) {
    
    int modifyResult = 0;
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "UPDATE NOTICE_T SET GUBUN = ?, TITLE = ?, CONTENT = ? WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, noticeDto.getGubun());
      ps.setString(2, noticeDto.getTitle());
      ps.setString(3, noticeDto.getContent());
      modifyResult = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    return modifyResult;
  }
    
  // 삭제
  public int delete(int notice_no) {
    
    int deleteResult = 0;
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "DELETE FROM NOTICE_T WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      deleteResult = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    return deleteResult;
  }  
  
  
  // 조회

  public List<NoticeDto> selectList() {
    
    List<NoticeDto> list = new ArrayList<NoticeDto>();
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T ORDER BY NOTICE_NO DESC";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setNotice_no(rs.getInt("NOTICE_NO"));
        noticeDto.setGubun(rs.getInt("GUBUN"));
        noticeDto.setTitle(rs.getString("TITLE"));
        noticeDto.setContent(rs.getString("CONTENT"));
        list.add(noticeDto);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    return list;
  }
  
  // 상세조회
  public NoticeDto selectNoticeByNo(int notice_no) {
    
    NoticeDto noticeDto = null;
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      rs = ps.executeQuery();
      if(rs.next()) {
        noticeDto = new NoticeDto();
        noticeDto.setNotice_no(rs.getInt(1));
        noticeDto.setGubun(rs.getInt(2));
        noticeDto.setTitle(rs.getString(3));
        noticeDto.setContent(rs.getString(4));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    return noticeDto;
  }
    
  
  
}
