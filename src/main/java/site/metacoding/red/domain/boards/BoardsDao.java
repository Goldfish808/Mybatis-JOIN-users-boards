package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.domain.boards.mapper.BoardsDetail;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.request.users.JoinDto;

public interface BoardsDao {
	public void insert(WriteDto wirteDto);
	public Boards findById(Integer id);
	public List<BoardsUsersSelect> findAll();
	public void deleteById(Integer id);
	public void update(Boards board);
	//아래는 내가한거
	public BoardsUsersSelect findBoardsById(Integer id);
	//아래는 수강 버전
	public BoardsDetail findByIdDetail(Integer id);
}

