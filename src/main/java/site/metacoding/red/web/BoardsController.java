package site.metacoding.red.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.boards.UpdateDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor
@RestController
public class BoardsController {

	private final BoardsDao boardsDao;
	
	@GetMapping("/boards/{id}")
	public RespDto<?> getBoards(@PathVariable Integer id) {
		return new RespDto<>(1, "${id} 를 찾았습니다", boardsDao.findById(id));
	}
	
	@GetMapping("/boards")
	public RespDto<?> getBoards() {
		return new RespDto<>(1, "모든 사용자를 찾았습니다", boardsDao.findAll());
	}
	
	@PostMapping("/boards")
	public RespDto<?> insert(WriteDto writeDto){
		boardsDao.insert(writeDto);
		return new RespDto<>(1, "행이 삽입 되었습니다", null);
	}
	 
	@DeleteMapping("/boards/{id}")
	public RespDto<?> deleteById(@PathVariable Integer id){
		boardsDao.deleteById(id);
		return new RespDto<>(1, "행이 삭제 되었습니다.", null);
	}
	
	@PutMapping("/boards/{id}")
	public RespDto<?> updateAll(@PathVariable Integer id, UpdateDto updateDto){
		Boards boardsPS = boardsDao.findById(id);
		
		boardsPS.모두수정(updateDto);
		
		boardsDao.update(boardsPS);
		
		return new RespDto<>(1, "모두 수정 되었습니다", null);
	}
	
	@PutMapping("/boards/{id}/title")
	public RespDto<?> updateTitle(@PathVariable Integer id, String title){		
		Boards boardsPS = boardsDao.findById(id);
		
		boardsPS.제목수정(title);
		
		boardsDao.update(boardsPS);
		
		return new RespDto<>(1, "내용 수정 되었습니다", null);
	}
	
	@PutMapping("/boards/{id}/content")
	public RespDto<?> updateContent(@PathVariable Integer id, String content){		
		Boards boardsPS = boardsDao.findById(id);
		
		boardsPS.제목수정(content);
		
		boardsDao.update(boardsPS);
		
		return new RespDto<>(1, "내용 수정 되었습니다", null);
	}

}
