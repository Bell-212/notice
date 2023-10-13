package com.gdu.myapp;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;



// JUnit4를 이용한다.
@RunWith(SpringJUnit4ClassRunner.class)

// ContactDao Bean 생성 방법을 알려준다.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")

// 테스트 메소드의 이름 오름차순(알파벳순)으로 테스트를 수행한다.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoticeUnitTest {

  @Autowired // Spring Container에서 NoticeDao 객체(Bean)을 가져온다.
  private NoticeDao noticeDao;
  
//  @Test  // 테스트를 수행한다.
//  public void test01_삽입테스트() {
//    NoticeDto noticeDto = new NoticeDto(0, 1, "연락처", "이메일");
//    int insertResult = noticeDto.insert(noticeDto);
//    assertEquals(1, insertResult);  // insertResult가 1이면 테스트 성공이다.
//  }

  @Test // 테스트를 수행한다.
  public void test02_조회테스트() {
    List<NoticeDto> noticeDto = noticeDao.selectList();
    assertNotNull(noticeDto);  //contactDto가 not null이면 테스트 성공이다.
  }
  
//  @Test
//  public void test03_삭제() {
//    int contact_no = 1;
//    int deleteResult = contactDao.delete(contact_no);
//    assertEquals(1, deleteResult);  // deleteResult가 1이면 테스트 성공이다.
    // assertNull(contactDao.selectContactByNo(contact_no));  select 결과가 null이면 테스트 성공이다.
    
//  }
  
  
  
}
