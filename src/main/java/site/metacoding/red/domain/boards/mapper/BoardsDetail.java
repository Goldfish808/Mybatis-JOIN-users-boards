package site.metacoding.red.domain.boards.mapper;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardsDetail {
	private Integer id;
	private String title;
	private String content;
	private String usersId;
	private Timestamp createdAt;
	private String username;
	private String password;
	private String email;
	
}
