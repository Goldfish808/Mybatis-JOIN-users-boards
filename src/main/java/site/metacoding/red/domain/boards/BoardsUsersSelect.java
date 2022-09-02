package site.metacoding.red.domain.boards;

import java.security.Timestamp;

import lombok.Getter;
import site.metacoding.red.web.dto.request.boards.UpdateDto;

@Getter
public class BoardsUsersSelect {
	private Integer id;
	private String title;
	private String content;
	private String username;
	private Timestamp createdAt;
}
