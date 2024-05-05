import java.io.File;
import java.util.Scanner;

public class Main {
    public static void kayittanAl() {
        File file = new File("kayıt.bin");
        Scanner input = new Scanner(System.in);
        if (file.exists()) {
            System.out.print("Kaydedilmiş bir oyununuz var. Kayıttdan devam etmek ister misiniz?(Evet ya da Hayır): ");
            String cevap = input.nextLine();
            if (cevap.equalsIgnoreCase("Evet")) {
                kartlar = OyunKayit.kayittanAl();
                return;
            }
        }
        kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');
    }
    private static Kart[][] kartlar = new Kart[4][4];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        kayittanAl();
       // oyunTahtasi();
        while (!oyunBittiMi()) {
            oyunTahtasi();
            System.out.print("Çıkmak için 'Evet' devam etmek için 'Hayır' yazınız: ");
            String cikis = input.nextLine();
            if (cikis.equalsIgnoreCase("Evet")) {
                System.out.print("Oyunu kaydetmek istiyor musunuz?(Evet ya da Hayır): ");
                String kayit = input.nextLine();
                if (kayit.equalsIgnoreCase("Evet")) {
                    OyunKayit.oyunKaydet(kartlar);
                }
                else {
                    System.out.println("Oyun kaydedilmedi.");
                }
                System.out.println("Programdan çıkılıyor...");
                break;
            }

            tahminEt();
        }
        if (oyunBittiMi()) {
            oyunTahtasi();
            System.out.println("Oyunu başarıyla bitirdiniz. Tebrikler!");
        }
    }
    public static void tahminEt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Birinci Tahmin: ");
        int i1 = scan.nextInt() - 1;
        int j1 = scan.nextInt() - 1;
        kartlar[i1][j1].setTahmin(true);
        oyunTahtasi();

        System.out.print("İkinci Tahmin: ");
        int i2 = scan.nextInt() - 1;
        int j2 = scan.nextInt() - 1;

        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()) {
            kartlar[i2][j2].setTahmin(true);
            System.out.println("Seçilen yerler eşit. Tebrikler!");
        }
        else {
            System.out.println("Seçilen yerler eşit değil!");
            kartlar[i1][j1].setTahmin(false);
        }
    }
    public static boolean oyunBittiMi() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!kartlar[i][j].isTahmin()) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void oyunTahtasi() {
        for (int i = 0; i < 4; i++) {
            System.out.println("____________________");
            for (int j = 0; j < 4; j++) {
                if (kartlar[i][j].isTahmin()) {
                    System.out.print(" |" +  kartlar[i][j].getDeger() + "| ");
                }
                else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("____________________");
    }
}
