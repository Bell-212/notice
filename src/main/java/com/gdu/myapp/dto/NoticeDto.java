package com.gdu.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDto {
  
  private int notice_no;
  private int gubun;
  private String title;
  private String content;
}

  /* 공지번호 */
  /* 공지구분(1='긴급', 2='일반') */
  /* 제목 */
  /* 내용 */
