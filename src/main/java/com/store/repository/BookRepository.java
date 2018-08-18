package com.store.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	Page<Book> findByCategoryId(Long categoryId, Pageable pageable);
	@Query("SELECT b FROM Book b WHERE "
			+ "(:title IS NULL OR b.title like :title OR b.author like :title)"
			)
	Page<Book> search(@Param("title") String title, Pageable pageable);
}
