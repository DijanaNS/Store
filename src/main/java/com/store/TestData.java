package com.store;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.model.Basket;
import com.store.model.Book;
import com.store.model.Category;
import com.store.model.Role;
import com.store.model.User;
import com.store.service.BasketService;
import com.store.service.BookService;
import com.store.service.CategoryService;
import com.store.service.RoleService;
import com.store.service.UserService;

@Component
public class TestData {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BasketService basketService;
	
	@PostConstruct
	public void init() {
		Category c1 = new Category();
		c1.setName("Avantura");
		c1.setDescription("A genre of fiction in which action is the key element, overshadowing characters, theme and setting.");
		categoryService.save(c1);
		
		Category c2 = new Category();
		c2.setName("Horor");
		c2.setDescription("Horror is a genre of speculative fiction which is intended to, or has the capacity to frighten, scare, disgust, or startle its readers or viewers by inducing feelings of horror and terror.");
		categoryService.save(c2);
		
		Category c3 = new Category();
		c3.setName("Fantastika");
		c3.setDescription("Fantasy is a genre of speculative fiction set in a fictional universe, often without any locations, events, or people referencing the real world.");
		categoryService.save(c3);
		
		Category c4 = new Category();
		c4.setName("Ljubavni roman");
		c4.setDescription("Novels of this type of genre fiction place their primary focus on the relationship and romantic love between two people");
		categoryService.save(c4);
		
		Category c5 = new Category();
		c5.setName("Popularna psihologija");
		c5.setDescription("Popularna psihologija");
		categoryService.save(c5);
		
		Book b1 = new Book();
		b1.setAuthor("Sindni Seldon");
		b1.setTitle("Nema udovica");
		b1.setCategory(c4);
		b1.setCount(1000);
		b1.setIsbn("978-86-10-02273-5");
		b1.setFormat("145 x 205 mm");
		b1.setDescription("U gradu u kojem su prijatelji i neprijatelji jedno, ona mora da bude gospodar svoje igre.");
		b1.setImgNumber(1);
		b1.setPagesNumber(325);
		b1.setPrice(499);
		b1.setPublisher("Vulkan");
		b1.setYear(2013);
		bookService.save(b1);
		
		Book b2 = new Book();
		b2.setAuthor("Sindni Seldon");
		b2.setTitle("Nema udovica Special");
		b2.setCategory(c4);
		b2.setCount(1000);
		b2.setIsbn("978-86-10-02273-6");
		b2.setFormat("145 x 205 mm");
		b2.setDescription("U gradu u kojem su prijatelji i neprijatelji jedno, ona mora da bude gospodar svoje igre.");
		b2.setImgNumber(1);
		b2.setPagesNumber(325);
		b2.setPrice(499);
		b2.setPublisher("Vulkan");
		b2.setYear(2013);
		bookService.save(b2);
		
		Book b3 = new Book();
		b3.setAuthor("Rouzi Volš");
		b3.setTitle("Propusten poziv");
		b3.setCategory(c4);
		b3.setCount(1000);
		b3.setIsbn("978-86-10-02259-9");
		b3.setFormat("145 x 205 mm");
		b3.setDescription("Ako ste ikada čekale poziv koji nije stigao, ovo je knjiga za vas.");
		b3.setImgNumber(2);
		b3.setPagesNumber(272);
		b3.setPrice(399);
		b3.setPublisher("Vulkan");
		b3.setYear(2010);
		bookService.save(b3);
		
		Book b4 = new Book();
		b4.setAuthor("Elena Favili i Frančeska Kavalo");
		b4.setTitle("Price za laku noc male buntovnice");
		b4.setCategory(c4);
		b4.setCount(1000);
		b4.setIsbn("978-86-10-02125-7");
		b4.setFormat("145 x 205 mm");
		b4.setDescription("Sa ilustracijama 60 umetnica iz svakog kutka na svetu, ovo je originalna knjiga sa najviše donacija u istoriji kraudfandinga.");
		b4.setImgNumber(3);
		b4.setPagesNumber(272);
		b4.setPrice(199);
		b4.setPublisher("Vulkan");
		b4.setYear(2016);
		bookService.save(b4);
		
		Book b5 = new Book();
		b5.setAuthor("Džek Kenfild");
		b5.setTitle("USPEH – sto da ne?");
		b5.setCategory(c5);
		b5.setCount(1000);
		b5.setIsbn("978-86-10-00799-2");
		b5.setFormat("145 x 205 mm");
		b5.setDescription("Spremite se za uspeh! Od autora serijala Melem za dušu, stiže nova knjiga koja će vam pomoći da ostvarite svoje ciljeve.");
		b5.setImgNumber(4);
		b5.setPagesNumber(122);
		b5.setPrice(199);
		b5.setPublisher("Vulkan");
		b5.setYear(2016);
		bookService.save(b5);
		
		Book b6 = new Book();
		b6.setAuthor("Karol Bušar");
		b6.setTitle("Pohod");
		b6.setCategory(c5);
		b6.setCount(1000);
		b6.setIsbn("978-86-10-00799-2");
		b6.setFormat("145 x 205 mm");
		b6.setDescription("Karijera Novaka Đokovića je priča o uspehu. Njegova konačna pobeda na Rolan Garosu je priča o trijumfu unutar trijumfa. Došla je uz mnogo bola, suza, nesigurnosti, preispitivanja i prolivenog znoja. Za Novaka je to bio veoma važan pohod, okončan pobedom. Kako je uspeo da se povrati? Kako je uspeo da se otrese svih onih demona koji su mu se neprekidno vraćali?");
		b6.setImgNumber(5);
		b6.setPagesNumber(122);
		b6.setPrice(199);
		b6.setPublisher("Vulkan");
		b6.setYear(2016);
		bookService.save(b6);
		
		Role r1 = new Role();
		r1.setName("Member");
		roleService.save(r1);
		
		Role r2 = new Role();
		r2.setName("Admin");
		roleService.save(r2);
		
		Basket basket = new Basket();
		basketService.save(basket);
		User admin = new User();
		admin.setEmail("dijanabogdanovic87@gmail.com");
		admin.setFirstName("Dijana");
		admin.setLastName("Bogdanovic");
		admin.setPassword("admin");
		admin.setUsername("admin");
		admin.setRole(r2);
		admin.setBasket(basket);
		basket.setUser(admin);
		userService.save(admin);
		basketService.save(basket);
		
	}
}
