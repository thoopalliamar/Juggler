package com.stackroute.juggler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.kafka.domain.User;
import com.stackroute.juggler.repository.UserRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UserRepo userDao;

	public DataLoader(UserRepo userDao) {
		this.userDao = userDao;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		userDao.save(new User(1L, "distributor1@gmail.com", "dist1", 1111111111L, "Distributor"));
		userDao.save(new User(2L, "distributor2@gmail.com", "dist2", 1111111112L, "Distributor"));
		userDao.save(new User(3L, "distributor3@gmail.com", "dist3", 1111111113L, "Distributor"));
		userDao.save(new User(4L, "distributor4@gmail.com", "dist4", 1111111114L, "Distributor"));
		userDao.save(new User(5L, "distributor3@gmail.com", "dist5", 1111111115L, "Distributor"));
		userDao.save(new User(6L, "theatre1@gmail.com", "t01", 1111111116L, "Theatre Owner"));
		userDao.save(new User(7L, "theatre2@gmail.com", "t02", 1111111117L, "Theatre Owner"));
		userDao.save(new User(8L, "theatre3@gmail.com", "t03", 1111111118L, "Theatre Owner"));
		userDao.save(new User(9L, "theatre4@gmail.com", "t04", 1111111119L, "Theatre Owner"));
		userDao.save(new User(10L, "theatre5@gmail.com", "t05", 1111111120L, "Theatre Owner"));
		userDao.save(new User(20L, "theatre11@gmail.com", "t11", 1111111116L, "Theatre Owner"));
		userDao.save(new User(21L, "theatre12@gmail.com", "t12", 1111111117L, "Theatre Owner"));
		userDao.save(new User(22L, "theatre13@gmail.com", "t13", 1111111118L, "Theatre Owner"));
		userDao.save(new User(23L, "theatre14@gmail.com", "t14", 1111111119L, "Theatre Owner"));
		userDao.save(new User(24L, "theatre15@gmail.com", "t15", 1111111120L, "Theatre Owner"));
		userDao.save(new User(11L, "eventproducer1@gmail.com", "ep1", 1111111121L, "Event Producer"));
		userDao.save(new User(12L, "eventproducer2@gmail.com", "ep2", 1111111122L, "Event Producer"));
		userDao.save(new User(13L, "eventproducer3@gmail.com", "ep3", 1111111123L, "Event Producer"));
		userDao.save(new User(14L, "eventproducer4@gmail.com", "ep4", 1111111124L, "Event Producer"));
		userDao.save(new User(15L, "eventproducer5@gmail.com", "ep5", 1111111125L, "Event Producer"));
		userDao.save(new User(20L, "user1@gmail.com", "user1", 1111111126L, "user"));
		userDao.save(new User(16L, "user2@gmail.com", "user2", 1111111127L, "user"));
		userDao.save(new User(17L, "user3@gmail.com", "user3", 1111111128L, "user"));
		userDao.save(new User(18L, "user4@gmail.com", "user4", 1111111129L, "user"));
		userDao.save(new User(19L, "user5@gmail.com", "user5", 1111111130L, "user"));

	}

}
