package Week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnCokTekrarEdenHarf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir metin girin:");
        String metin = scanner.nextLine();

        char enCokTekrarEdenHarf = bulEnCokTekrarEdenHarf(metin);
        int tekrarSayisi = hesaplaTekrarSayisi(metin, enCokTekrarEdenHarf);

        System.out.println("En çok tekrar eden harf: " + enCokTekrarEdenHarf);
        System.out.println("Tekrar sayısı: " + tekrarSayisi);
    }

    public static char bulEnCokTekrarEdenHarf(String metin) {
        Map<Character, Integer> harfSayilari = new HashMap<>();

        for (char harf : metin.toCharArray()) {
            if (Character.isLetter(harf)) {
                harf = Character.toLowerCase(harf);
                int sayi = harfSayilari.getOrDefault(harf, 0);
                harfSayilari.put(harf, sayi + 1);
            }
        }

        char enCokTekrarEdenHarf = ' ';
        int maxTekrar = 0;

        for (Map.Entry<Character, Integer> entry : harfSayilari.entrySet()) {
            if (entry.getValue() > maxTekrar) {
                enCokTekrarEdenHarf = entry.getKey();
                maxTekrar = entry.getValue();
            }
        }

        return enCokTekrarEdenHarf;
    }

    public static int hesaplaTekrarSayisi(String metin, char harf) {
        int tekrarSayisi = 0;

        for (char c : metin.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(harf)) {
                tekrarSayisi++;
            }
        }

        return tekrarSayisi;
    }
}
