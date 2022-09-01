package site.metacoding.red.web.dto.request.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	public String username;
	public String password;
	public String email;

}
