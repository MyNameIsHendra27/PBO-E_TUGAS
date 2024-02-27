//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        UserDatabase userDatabase = new UserDatabase();

        while (true) {
            System.out.println("-- Library System --");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih Opsi (1-3) : ");
            int choice = objInput.nextInt();
            objInput.nextLine();

            // proses inputan data
            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM : ");
                    String nim = objInput.nextLine();
                    if (nim.length() == 15 && userDatabase.isValidMahasiswa(nim)) {
                        System.out.println("Sukses Login sebagai Mahasiswa");
                    } else {
                        System.out.println("Pengguna tidak ditemukan");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan username (admin) : ");
                    String username = objInput.nextLine();
                    System.out.print("Masukkan password (admin) : ");
                    String password = objInput.nextLine();
                    if (userDatabase.isValidAdmin(username, password)) {
                        System.out.println("Sukses Login sebagai Admin");
                    } else {
                        System.out.println("Pengguna tidak ditemukan");
                    }
                    break;
                case 3:
                    System.out.println("Anda keluar dari program");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid, silakan masukkan angka 1-3.");
            }
        }
    }
}

class UserDatabase {
    //
    private final String[] validMahasiswaNIMs = {"202310370311231"};
    private final String  validAdminPassword = "admin";

    public boolean isValidMahasiswa(String nim) {
        for (String validNIM : validMahasiswaNIMs) {
            if (validNIM.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidAdmin(String username, String password) {
        String validAdminUsername = "admin";
        return username.equals(validAdminUsername) && password.equals(validAdminPassword);
    }
}