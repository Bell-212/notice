package com.gdu.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.dto.NoticeDto;
import com.gdu.myapp.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

  private final NoticeService noticeService;
  
  @GetMapping(value="/notice/list.do")
  public String list(Model model) {
    List<NoticeDto> noticeList = noticeService.getNoticeList(); 
    model.addAttribute("noticeList", noticeList);
    return "notice/list";
  }
  
  @GetMapping(value="/notice/write.do")
  public String write() {
    return "notice/write";
  }
  
  @GetMapping(value="/notice/modify.go")
  public String modifyGo(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, Model model) {
    model.addAttribute("notice", noticeService.getNoticeByNo(notice_no));
    return "notice/modify";
  }
  
  @RequestMapping(value="/contact/modify.do", method=RequestMethod.POST)
  public String modify(NoticeDto  noticeDto, RedirectAttributes redirectAttributes) {
    int modifyResult = noticeService.modify(noticeDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/contact/detail.do?notice_no=" + noticeDto.getNotice_no();
  }
  
  @RequestMapping(value="/notice/add.do", method=RequestMethod.POST)
  public String add(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int addResult = noticeService.add(noticeDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  @GetMapping(value="/notice/detail.do")
  public String detail(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, Model model) {
    model.addAttribute("notice", noticeService.getNoticeByNo(notice_no));
    return "notice/detail";
  }
  
  @RequestMapping(value="/contact/delete.do", method=RequestMethod.POST)
  public String delete(@RequestParam(value="notice_no", required=false, defaultValue="0") int contact_no, RedirectAttributes redirectAttributes) {
    int deleteResult = noticeService.delete(contact_no);
    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
    return "redirect:/contact/list.do";
  }
  
  
  
}
