import java.util.Scanner;

public class HitungGajiKaryawan {

    private static final int GAJI_PER_HARI = 120000;
    private static final int UANG_MAKAN_PER_HARI = 15000;
    private static final int NUM_OF_EMPLOYEES = 5;
    private static final double PAJAK_PERSENTASE = 0.1; // 10% pajak

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalBiayaPerusahaan = 0;
        int[] gajiBersihArray = new int[NUM_OF_EMPLOYEES];

        for (int a = 0; a < NUM_OF_EMPLOYEES; a++) {
            // Input validation for the number of working days
            while (true) {
                System.out.print("Masukkan Nama Karyawan " + (a + 1) + "\t: ");
                String namaKaryawan = input.next();

                System.out.print("Masukkan Jumlah Hari Kerja : ");
                int hariKerja = input.nextInt();

                if (hariKerja > 0) {
                    // Proceed with calculations
                    int gajiKotorPerHari = GAJI_PER_HARI;
                    int totalMakan = UANG_MAKAN_PER_HARI * hariKerja;
                    int gajiKotor = gajiKotorPerHari * hariKerja;
                    int gajiBersih = gajiKotor - totalMakan;

                    // Hitung pajak
                    double pajak = gajiBersih * PAJAK_PERSENTASE;
                    gajiBersih -= pajak;

                    System.out.println("=======================================");
                    System.out.println("Karyawan " + (a + 1));
                    System.out.println("Nama Karyawan \t\t: " + namaKaryawan);
                    System.out.println("Jumlah Hari Kerja \t: " + hariKerja + " Hari");
                    System.out.println("Uang Makan Perhari \t: Rp." + UANG_MAKAN_PER_HARI);
                    System.out.println("Gaji Kotor \t\t: Rp." + gajiKotor);
                    System.out.println("Pajak \t\t\t: Rp." + pajak);
                    System.out.println("Gaji Bersih \t\t: Rp." + gajiBersih);
                    System.out.println("Total Biaya Karyawan \t: Rp." + (gajiKotor + totalMakan));
                    System.out.println("=======================================");

                    // Calculate and display total expenses for each employee
                    totalBiayaPerusahaan += (gajiKotor + totalMakan);
                    gajiBersihArray[a] = gajiBersih;

                    break;
                } else {
                    System.out.println("Masukkan jumlah hari kerja yang valid.");
                }
            }
        }

        // Calculate average and maximum salary
        int totalGajiBersih = 0;
        int gajiMaksimum = Integer.MIN_VALUE;

        for (int gaji : gajiBersihArray) {
            totalGajiBersih += gaji;
            gajiMaksimum = Math.max(gajiMaksimum, gaji);
        }

        int rataRataGaji = totalGajiBersih / NUM_OF_EMPLOYEES;

        // Display average and maximum salary
        System.out.println("Rata-rata Gaji Karyawan \t: Rp." + rataRataGaji);
        System.out.println("Gaji Tertinggi \t\t: Rp." + gajiMaksimum);
        System.out.println("Dana Yang Harus di Keluarkan Perusahaan : Rp." + totalBiayaPerusahaan);
    }
}