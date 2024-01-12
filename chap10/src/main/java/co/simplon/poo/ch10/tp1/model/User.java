package co.simplon.poo.ch10.tp1.model;

import co.simplon.poo.ch10.tp1.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{	
	public User(String login2, String password2, String email2, String string) {
		// TODO Auto-generated constructor stub
	}

	@NonNull
	private String login;
	@NonNull
	private String password;
	@NonNull
	private String email;
	
	private boolean enable;
}
