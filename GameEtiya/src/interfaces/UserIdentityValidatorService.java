package interfaces;
import entities.User;


public interface UserIdentityValidatorService {
	boolean isValid(User user);
}
