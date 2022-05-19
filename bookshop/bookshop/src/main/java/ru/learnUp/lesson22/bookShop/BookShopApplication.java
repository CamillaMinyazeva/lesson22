package ru.learnUp.lesson22.bookShop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.lesson22.bookShop.dao.AuthorDao;
import ru.learnUp.lesson22.bookShop.dao.BookDao;
import ru.learnUp.lesson22.bookShop.dao.OrderDao;
import ru.learnUp.lesson22.bookShop.dao.UserDao;

import java.time.LocalDate;

@SpringBootApplication
public class BookShopApplication {

	private static final Logger log = LoggerFactory.getLogger(BookShopApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);

		User userForUpdate = User.builder()
				.name("Camilla")
				.surname("Minyazeva")
				.address("Russia, Moscow")
				.birthDate(LocalDate.of(1999, 05, 28))
				.build();

		UserDao userDao = context.getBean(UserDao.class);
//		userDao.save(userForUpdate);
		User user = userDao.findById(1);
		log.info("{}", user);

		Book bookForUpdate = Book.builder()
				.bookName("Louisa May Alcott")
				.authorName("Little Woman")
				.price(412)
				.build();

		BookDao bookDao = context.getBean(BookDao.class);
//		bookDao.save(bookForUpdate);
		Book book = bookDao.findByName("Louisa May Alcott");
		log.info("{}", book);

		Author authorForUpdate = Author.builder()
				.name("Little")
				.surname("Woman")
				.books("Louisa May Alcott")
				.build();

		AuthorDao authorDao = context.getBean(AuthorDao.class);
//		authorDao.save(authorForUpdate);
		Author author = authorDao.findById(1);
		log.info("{}", author);

		Order orderForUpdate = Order.builder()
				.userName("Camilla")
				.bookName("Three Comrades")
				.count(1)
				.build();

		OrderDao orderDao = context.getBean(OrderDao.class);
//		orderDao.save(orderForUpdate);
		Order order = orderDao.findById(1);
		log.info("{}", order);
	}
}
