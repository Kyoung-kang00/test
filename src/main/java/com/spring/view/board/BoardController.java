package com.spring.view.board;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.board.impl.BoardService;
import com.spring.biz.board.impl.BoardServiceImpl;
import com.spring.biz.common.BoardDTO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	BoardService  boardService;   // 부모인 인터페이스로 주입한다

	// view에서  forEach를 활용해보려고  만들어 놓았다.
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		
		return conditionMap; 
	}
	
	
	
	
	@RequestMapping("/getBoardList.do" )
	public String getBoardList(BoardDTO  vo,  Model model) throws Exception {
		
		//혹시 null이라면 ...  TITLE을 디폴트로 하자
		if(vo.getSearchCondition() == null)  vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()  == null)  vo.setSearchKeyword("");
		
		
		model.addAttribute("boardList", boardService.getBoardList(vo)) ;
		return "board/getBoardList";
	}
	
	
	
	
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDTO vo,  Model model) throws Exception {
		
		// getBoardList에서  vo.seq >> 상세검색  getBoard.do 로 온것이다
		model.addAttribute("board",boardService.getBoard(vo)); 
		return "board/getBoard";
	}
	
	@GetMapping("/insertBoard.do")		// <a> --> 입력양식으로 이동
	public String insertBoard() throws Exception {
		
		// return "redirect:insertBoard.jsp";
		return "board/insertBoard";
		
	}
	
	// @RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	@PostMapping("/insertBoard.do")		// <form>
	public String insertBoard(BoardDTO vo) throws Exception {
		
		// vo에 담겨온 파일을 저장할 물리저인 위치를 정해서 DB에 저장(저장경로)시킨다
		String fileName = null;
		String realPath = "c:/Janghan/imgfile/";		// 저장할 위치 경로
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			
			fileName = uploadFile.getOriginalFilename();		// 파일 이름
			uploadFile.transferTo(new File(realPath + fileName));		// 실제 저장경로
			vo.setFileAddress("/file/" + fileName);
			
		}
		
		boardService.insertBoard(vo);  // 현재는 폼에서 온 파라미터는 vo에 넣지 않았다. 
		return "redirect:getBoardList.do";
	}
	
	
	//update (실습)
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO vo) throws Exception {
		
		System.out.println(vo.toString());		
		boardService.updateBoard(vo);		
		
		return "redirect:getBoardList.do";
	}
	
	//delete (실습)
}






