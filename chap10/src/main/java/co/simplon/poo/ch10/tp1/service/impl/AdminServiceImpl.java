package co.simplon.poo.ch10.tp1.service.impl;

import java.util.List;
import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.AdminService;
import co.simplon.poo.ch10.tp1.utils.communication.FakeMailUtil;
import co.simplon.poo.ch10.tp1.utils.security.PasswordTools;

public class AdminServiceImpl implements AdminService {

	private final UserRepository users;

	public AdminServiceImpl(UserRepository users) {
		super();
		this.users = users;
	}

	@Override
	public List<User> findAllUsers() {
		return users.retrieve();
	}

	@Override
	public void resetAndSendNewPassword(String userId) {
		User user = users.getByLogin(userId);
		String newPassword = PasswordTools.generateRandomPassword();
		user.setPassword(newPassword);

		try {
			users.update(user, user.getId());
			FakeMailUtil.sendFakeEmail(user.getEmail(), "Changement mdp", "votre nouveau mdp" + newPassword);
		} catch (Exception e) {
			e.printStackTrace();

			/*
			 * Techniquement que fait-on de l'exception s'il y a un problème vu que que
			 * resetAndSendNewPassword ne renvoie pas d'exception ?
			 */
		}
	}

	@Override
	public void disableUser(String userId) throws Exception {
		User user = users.getByLogin(userId);
		user.setEnable(false);
		
		users.update(user, user.getId());

	}

	@Override
	public void enableUser(String userId) throws Exception {
		User user = users.getByLogin(userId);
		user.setEnable(true);
		
		users.update(user, user.getId());
	}

}
