package org.library;

import org.library.management.User;
import org.library.management.Book;
import org.library.management.Library;

import java.util.Scanner;

class Main {

	// TODO 4 Cari tau tentang Try-Catch dan Tambahkan Try Catch dalam program
	//  tersebut!
	// TODO 5 Presentasikan hasil source code yang baru pada Bulan Mei.

	static Scanner scan = new Scanner(System.in);
	static Library library = new Library();

	public static void main(String[] args) {
		// TODO 3 Kembangkan program tersebut supaya terdapat 4 pilar OOP dan
		//  jelaskan! (untuk nomor 3, harus dari analisa kalian sendiri, tidak
		//  boleh sama dengan teman kalian)
		initLibraryData();

		String isContinue = "y";

		while (isContinue.isBlank() || isContinue.isEmpty()
				|| isContinue.equalsIgnoreCase("y")) {
			showMenu();
			int selectedMenu = chooseMenu();

			switch (selectedMenu) {
				case 1 -> showBooks();
				case 2 -> showMembers();
				case 3 -> showBorrowedBooks();
				case 4 -> addMember();
				case 5 -> addBook();
				case 6 -> borrowBook();
				case 7 -> returnBook();
				default -> System.out.println("wrong input");
			}

			System.out.print("continue (Y/n)? ");
			isContinue = scan.next();
		}
	}

	private static void showMembers() {
		library.showUsers();
	}

	private static void showBooks() {
		library.showBooks();
	}

	private static void showBorrowedBooks() {
		System.out.print("member id : ");
		String id = scan.next();

		library.showBorrowedBooks(id);
	}

	public static void showMenu() {
		System.out.println("================================");
		System.out.println("1. show books list");
		System.out.println("2. show users list");
		System.out.println("3. show borrowed books list");
		System.out.println("4. add member");
		System.out.println("5. add book");
		System.out.println("6. borrow book");
		System.out.println("7. return book");
		System.out.println("================================");
	}

	public static void initLibraryData() {
		library.addBook(new Book("pemrograman java", "1"), true);
		library.addBook(new Book("pemrograman oop", "2"), true);
		library.addBook(new Book("pemrograman android", "3"), true);

		library.addMember(new User("aka", "1"), true);
		library.addMember(new User("budi", "2"), true);
		library.addMember(new User("tono", "3"), true);
	}

	public static int chooseMenu() {
		System.out.print("choose menu : ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		return pilihan;
	}

	// TODO 2 Ketika menambahkan member kita masih dapat membuat id yang sama,
	//  perbaiki supaya id yang dihasilkan tidak boleh sama! (dapat menggunakan
	//  hash set)
	public static void addMember() {

		System.out.print("id : ");
		String userId = scan.next();

		System.out.print("name : ");
		String userName = scan.next();

		library.addMember(new User(userName, userId), true);
	}

	public static void borrowBook() {
		System.out.print("id member : ");
		String memberId = scan.next();

		System.out.print("id book : ");
		String bookId = scan.next();

		library.giveBook(memberId, bookId);
	}

	public static void returnBook() {
		System.out.print("id user : ");
		String userId = scan.next();

		System.out.print("id book : ");
		String bookId = scan.next();

		library.receiveBook(userId, bookId);
	}

	public static void addBook() {
		System.out.print("book title : ");
		String title = scan.nextLine();

		System.out.print("book id : ");
		String id = scan.next();

		library.addBook(new Book(title, id), true);
	}
}