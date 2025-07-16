package com.spring.biz.common;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("boardVO")
public class BoardDTO {  // DB - 테이블
	
	private int    seq;
    private String title;
    private String writer;
    private String content;
    private Date   regDate;
    private int    cnt;
    
    // 파일 업로드
    private String fileAddress;
    private MultipartFile uploadFile;

	/*
		
		. 파일 업로드는 multipart/form-data 형식으로 데이터를 전송하는데 스프링에서는 이를 처리하기 위해서
		파일업로드 관리를 MultipartFile에서 처리한다
		. 동작순서
			
			1) 요청 ---> multipart/form-data 확인
			2) 만약 multipart/form-data라면 객체화시켜서 메모리에 올린다
			3) transferTo()에 의해 지정된 위치에 저장하게 된다
		
		. 메서드
			
			String getOriginalFilename(): 업로드한 파일명을 문자열로 반환
			void transferTo(File 저장할파일이름): 업로드한 파일을 저장할 파일이름으로 물리적 저장소에 저장한다
			boolean isEmpty()
			
	*/
    
    // 파일 업로드 Getter/Setter
    public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	//검색속성추가
    private String searchCondition;   // 메뉴
    private String searchKeyword;     // 검색어
    
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	//*****************************************************
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
    
    @Override
    public String toString() {
    	return "BoardVO [ "+seq+", "+title+", "+writer+", "+ content+", "+regDate+", "+ cnt+"]";
    }
}
