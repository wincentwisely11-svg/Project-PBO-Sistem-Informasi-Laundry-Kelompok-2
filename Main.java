import java.util.Scanner;
import dao.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            // ===== Tampilan menu =====
            System.out.println("==================================");
            System.out.println("        SISTEM INFORMASI LAUNDRY  ");
            System.out.println("==================================");
            System.out.println("1. Data Pelanggan");
            System.out.println("2. Data Layanan");
            System.out.println("3. Transaksi Baru");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.println("----------------------------------");
            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();
            System.out.println();

            // ===== Proses pilihan =====
            switch (pilihan) {
                case 1:
                    customerdao.menuUser(input);
                    break;
                case 2:
                    layanandao.menuLayanan(input); 
                    break;
                case 3:
                    System.out.println("[Menu Transaksi Baru - belum dibuat]");
                    break;
                case 4:
                    System.out.println("[Menu Riwayat Transaksi - belum dibuat]");
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            System.out.println();

        } while (pilihan != 0);

        input.close();
    }
}
