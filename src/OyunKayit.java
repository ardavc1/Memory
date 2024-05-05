import java.io.*;

public class OyunKayit {
    public static void oyunKaydet(Kart[][] kartlar) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayıt.bin"))) {
            System.out.println("Oyun kaydediliyor...");
            out.writeObject(kartlar);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Kart[][] kayittanAl() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayıt.bin"))) {
            Kart[][] cikti = (Kart[][])in.readObject();
            return cikti;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
