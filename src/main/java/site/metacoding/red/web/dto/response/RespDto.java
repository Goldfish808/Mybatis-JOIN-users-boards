package site.metacoding.red.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor

public class RespDto<T> {
	public Integer code;
	public String msg;
	public T body;
}
