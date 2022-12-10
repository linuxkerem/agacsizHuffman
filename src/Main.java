import java.util.Scanner;

// Kerem Mert İzmir
// 02215076057 ( İÖ )


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Uzunlugu maksimum 8 olan bir string giriniz ( Kabul edilen alfabe : ABCD ) ;");

        String se = s.nextLine();

        //Frekans hesapliyoruz

        int[] freq = new int[se.length()];
        char str1[] = se.toCharArray();
        for (int i = 0; i < se.length(); i++) {
            freq[i] = 1;
            for (int j = i + 1; j < se.length(); j++) {
                if (str1[i] == str1[j]) {
                    freq[i]++;
                    str1[j] = '0';
                }
            }
        }

        // frekanslari freq adli arrayda tutuyoruz
        // str1 arrayinda ise girilen stringlerde ki elemanlarini tutuyoruz

        System.out.println("Frekanslarimizi siralamadan once;");
        for (int i = 0; i < freq.length; i++) {
            if (str1[i] != ' ' && str1[i] != '0')
                System.out.println(str1[i] + "              " + freq[i]);
        }


        // frekanslari siraliyoruz.

        System.out.println("Frekanslari siralaniyor...");
        int temp;
        char temp2;
        for (int i = 0; i < freq.length; i++) {
            for (int j = i + 1; j < freq.length; j++) {
                if (freq[i] > freq[j]) {      //swap elements if not in order
                    temp = freq[i];
                    temp2 = str1[i];
                    str1[i] = str1[j];
                    str1[j] = temp2;
                    freq[i] = freq[j];
                    freq[j] = temp;
                }
            }
        }

        System.out.println("Frekanslari siraladiktan sonra;");
        for (int i = 0; i < freq.length; i++) {
            if (str1[i] != ' ' && str1[i] != '0')
                System.out.println(str1[i] + "              " + freq[i]);
        }

        // str1 arrayinde stringlerimiz random yerlerde bulunuyor. Bunlari dogru indexlere yerlestiriyoruz.
        // str1 arrayinda yerlestirdigimiz indexlerin frekanslarini da ayni sekilde ayni indexlere yerlestirmemiz gerek.
        // Sirasiyla 0,1,2,3 ....
        for (int i = 0; str1.length > i; i++) {
            int c = i;
            if (str1[i] != '0' && i != 0) {
                while (str1[c - 1] == '0' && c != 0 && c - 1 != 0) {
                    str1[c - 1] = str1[c];
                    freq[c - 1] = freq[c];
                    str1[c] = '0';
                    c = c - 1;
                }
            }
        }

        // c = 1 oldugu durumda yukarida ki for dongusunden cikis yaptigimiz icin c=1 durumunu
        // elle yonetmemiz gerekiyor

        int c = 1;
        while (str1[c] != '0') {
            str1[c - 1] = str1[c];
            str1[c] = '0';
            c = c + 1;
        }

        // Simdi kodlarimizi bulalim
        // Sag cocuklara giderken 1, sol cocuklara giderken 0 biti ile gideriz.
        // Bu yuzden dolayi 2 tane farkli string olusturalim.
        // Agac yapisi kullanmadigimiz icin kokumuze 0 bitini atayalim.

        String sikistirilmisKodSag = "0";
        String sikistirilmisKodSol = "0";
        System.out.println("Kokumuz : "+ str1[0] + ", sıkıştırılmış kodu  0");
        int maks = str1.length;
        for (int i = 0; i < str1.length; i++) {
            if (2 * i + 1 < maks ) {
                if (str1[2*i+1] != '0'){
                    sikistirilmisKodSag += "1";
                    System.out.println(str1[i] + "'nin sag cocugu: " + str1[2 * i + 1] + " sıkıştırılmış kodu " + sikistirilmisKodSag);
                }
            }
            if (2 * i + 2 < maks) {
                if (str1[2*i+2] != '0'){
                    sikistirilmisKodSol += "0";
                    System.out.println(str1[i] + "'in sol cocugu: " + str1[2 * i + 2] + " sıkıştırılmış kodu " + sikistirilmisKodSol);
                }
            }
        }
    }
}
