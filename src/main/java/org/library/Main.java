package org.library;

import org.library.repository.*;
import org.library.service.*;
import org.library.utils.*;
import org.library.view.LibraryMenuView;

public class Main {

	// TODO 4 Cari tau tentang Try-Catch dan Tambahkan Try Catch dalam program
	//  tersebut!
	// TODO 5 Presentasikan hasil source code yang baru pada Bulan Mei.

	private static final UserRepository userRepo = new UserRepositoryImpl();
	private static final UserService userService = new UserServiceImpl(userRepo);

	private static final BookRepository bookRepo = new BookRepositoryImpl();
	private static final BookService bookService =
			new BookServiceImpl(bookRepo, userRepo);

	public static void main(String[] args) {
		BookUtil.setBookRepository(bookRepo);
		UserUtil.setUserRepository(userRepo);
		// TODO 3 Kembangkan program tersebut supaya terdapat 4 pilar OOP dan
		//  jelaskan! (untuk nomor 3, harus dari analisa kalian sendiri, tidak
		//  boleh sama dengan teman kalian)
		new LibraryMenuView(userService, bookService);
	}

	// TODO 2 Ketika menambahkan member kita masih dapat membuat id yang sama,
	//  perbaiki supaya id yang dihasilkan tidak boleh sama! (dapat menggunakan
	//  hash set)
}