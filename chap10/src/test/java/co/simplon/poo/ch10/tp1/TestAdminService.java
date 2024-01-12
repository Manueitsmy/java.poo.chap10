package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.AdminService;
import co.simplon.poo.ch10.tp1.service.impl.AdminServiceImpl;

public class TestAdminService {

	private UserRepository users = new UserRepositoryJson("data/json/users.json");
	private AdminService adminService = new AdminServiceImpl(users);

	@Test
	void testFindAllUsers() throws Exception {
		initUserRepository();

		List<User> actual = adminService.findAllUsers();
		List<User> expected = users.retrieve();

		assertEquals(expected, actual);

	}

	private void initUserRepository() throws Exception {
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
	}

	@Test
	void testResetAndSendNewPassword() throws Exception {		
		initUserRepository();
		User user = users.getByLogin("user1");
		String oldPassword = user.getPassword();
		
		adminService.resetAndSendNewPassword("user1");
		
		user = users.getByLogin("user1");
		String newPassword = user.getPassword();				
		assertNotEquals(oldPassword, newPassword);
/* Impossible de vérifier que le mail a bien été envoyé
car il n'y a que des effets de bord, il ne renvoie rien */
	}

	@Test
	void testDisableUser() throws Exception {		
		initUserRepository();

		adminService.disableUser("user1");
				
		User user = users.getByLogin("user1");
		assertFalse(user.isEnable());
		
	}

	@Test
	void testEnableUser() throws Exception {
		initUserRepository();
		
		adminService.enableUser("user1");
		
		User user = users.getByLogin("user1");
		assertTrue(user.isEnable());
	}

}