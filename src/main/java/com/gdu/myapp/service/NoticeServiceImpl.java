package com.gdu.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
  
  private final NoticeDao noticeDao;

  @Override
  public int add(NoticeDto noticeDto) {
    int addResult = noticeDao.add(noticeDto);
    return addResult;
  }

  @Override
  public int modify(NoticeDto noticeDto) {
    int modifyResult = noticeDao.modify(noticeDto);
    return modifyResult;
  }

  @Override
  public int delete(int notice_no) {
    int deleteResult = noticeDao.delete(notice_no);
    return deleteResult;
  }

  @Override
  public List<NoticeDto> getNoticeList() {
    return noticeDao.selectList();
  }

  @Override
  public NoticeDto getNoticeByNo(int notice_no) {
    return noticeDao.selectNoticeByNo(notice_no);
  }

}
