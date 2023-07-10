package Week1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class YasHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen doğum tarihinizi girin (GG/AA/YYYY):");
        String dogumTarihiStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dogumTarihi;
        try {
            dogumTarihi = LocalDate.parse(dogumTarihiStr, formatter);
            int yas = hesaplaYas(dogumTarihi);
            System.out.println("Yaşınız: " + yas);
        } catch (Exception e) {
            System.out.println("Geçersiz bir tarih girdiniz.");
        }
    }

    public static int hesaplaYas(LocalDate dogumTarihi) {
        LocalDate bugun = LocalDate.now();
        Period period = Period.between(dogumTarihi, bugun);
        return period.getYears();
    }
}
