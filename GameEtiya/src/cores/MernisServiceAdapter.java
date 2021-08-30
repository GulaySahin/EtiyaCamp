package cores;
import entities.User;
import interfaces.UserIdentityValidatorService;

public class MernisServiceAdapter implements UserIdentityValidatorService {

	@Override
	public boolean isValid(User user) {
		MernisKpsManager mernisKpsManager=new MernisKpsManager();
		return mernisKpsManager.tcKimlikDogrula(Long.parseLong(user.getIdentityNumber()), user.getName(),
				user.getLastName(), user.getAgeofYear());
	}

}
