package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.UserService;
import com.etiya.reCapProject.core.dataAccess.UserDao;
import com.etiya.reCapProject.core.entities.concrates.User;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
	super();
	this.userDao = userDao;
}

	@Override
	public DataResult<List<User>> getAll() {
		List<User>user=this.userDao.findAll();
		return new SuccessDataResult<>("Kullanıcılar listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı güncellendi");
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Kullanıcı silindi");
	}

}
