package co.simplon.poo.ch10.tp1.service.impl;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository users;

	public UserServiceImpl(UserRepository users) {
		this.users = users;
	}
    @Override
    public void changeMyPassword(String userId, String oldPass, String newPass) throws Exception {
        User targetUser = users.getById(userId);

        if (targetUser != null && targetUser.getPassword().equals(oldPass)) {
            targetUser.setPassword(newPass);
            users.update(targetUser, userId);
        } else {
            throw new Exception("Mauvais ancien mot de passe ou utilisateur introuvable");
        }
    }

    @Override
    public void changeMyEmail(String userId, String newEmail) throws Exception {
        User targetUser = users.getById(userId);

        if (targetUser != null) {
            // Changement de l'adresse e-mail
            targetUser.setEmail(newEmail);
            users.update(targetUser, userId);
        } else {
            throw new Exception("Utilisateur introuvable");
        }
    }
}