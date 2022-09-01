package site.metacoding.red.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor
@RestController
public class UsersController {

	private final UsersDao usersDao;
	
	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {
		//return usersDao.findById(id);
		return new RespDto<>(1, "${id} 를 찾았습니다", usersDao.findById(id));
	}
	
	@GetMapping("/users")
	public RespDto<?> getUsers() {
		//return usersDao.findById(id);
		return new RespDto<>(1, "모든 사용자를 찾았습니다", usersDao.findAll());
	}
	
	@PostMapping("/users")
	public RespDto<?> insert(JoinDto joinDto){
		usersDao.insert(joinDto);
		return new RespDto<>(1, "행이 삽입 되었습니다", null);
	}
	 
	@DeleteMapping("/users/{id}")
	public RespDto<?> deleteById(@PathVariable Integer id){
		usersDao.deleteById(id);
		return new RespDto<>(1, "행이 삭제 되었습니다.", null);
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> updateAll(@PathVariable Integer id, UpdateDto updateDto){
		
		Users usersPS = usersDao.findById(id);
		
		usersPS.모두수정(updateDto);
		
		usersDao.update(usersPS);
		
		return new RespDto<>(1, "모두 수정 되었습니다", null);
	}
	
	@PutMapping("/users/{id}/pw")
	public RespDto<?> updatePassword(@PathVariable Integer id, String password){
		
		Users usersPS = usersDao.findById(id);
		
		usersPS.비밀번호수정(password)	;
		usersDao.update(usersPS);
		
		return new RespDto<>(1, "비번 수정 되었습니다", null);
	}
	


}
