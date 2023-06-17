import java.util.Scanner;
import com.config.cConfig;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("--------------------------------");
        System.out.println("WELCOME TO ......");
        System.out.println("--------------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("--------------------------------");

        while (true) {
            System.out.print("Pilih: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    readData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        }
    }

    public static void readData() {
        cConfig myConfig = new cConfig();
        myConfig.connection();
        myConfig.getDatabase();
    }

    public static void insertData() {
        cConfig myConfig = new cConfig();
        myConfig.insertData();
    }

    public static void editData() {
        cConfig myConfig = new cConfig();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID data yang akan diubah: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk Nama Barang: ");
        String Nama = scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk Harga Barang: ");
        double Harga = scanner.nextDouble();

        System.out.print("Masukkan nilai baru untuk Stok Barang: ");
        int Stok = scanner.nextInt();

        myConfig.editData(ID, Nama, Harga, Stok);

        scanner.close();
    }

    public static void deleteData() {
        cConfig myConfig = new cConfig();
        myConfig.deleteData();
    }
}
