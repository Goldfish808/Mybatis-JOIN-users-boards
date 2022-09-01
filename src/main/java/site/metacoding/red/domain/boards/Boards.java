package site.metacoding.red.domain.boards;

import java.security.Timestamp;

import lombok.Getter;
import site.metacoding.red.web.dto.request.boards.UpdateDto;

@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;
	private Timestamp createdAt;
	
	public void 제목수정(String title) {
		this.title = title;
	}
	
	public void 내용수정(String content) {
		this.content = content; 
	}
	
	public void 모두수정(UpdateDto update) {
		this.title = update.getTitle();
		this.content = update.getContent();
	}

}
