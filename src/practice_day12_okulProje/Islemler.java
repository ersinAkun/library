package practice_day12_okulProje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Islemler {

    static List<Kisi> ogrtmnList=new ArrayList<>();
    static List<Kisi> ogrncList=new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String kisiTuru;




    public static void girisPaneli(){
        System.out.println("====================================");
        System.out.println("ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("====================================");
        System.out.println("1- ÖĞRENCİ İŞLEMLERİ");
        System.out.println("2- ÖĞRETMEN İŞLEMLERİ");
        System.out.println("Q- ÇIKIŞ");

        String secim=scan.next().toUpperCase();//kullanici kucuk harf girse bile buyuk harfe cevirdik
        switch(secim){
            case "1":
                kisiTuru="OGRENCI";
                islemMenusu();
                break;
            case "2":
                kisiTuru="OGRETMEN";
                islemMenusu();
                break;
            case "Q":
                break;
            default:
                System.out.println("hatali giris :(");
                girisPaneli();
                break;
        }
    }

    private static void islemMenusu() {
        System.out.println("sectigin kisi turu  "+kisiTuru +"  lutfen asagidaki islmleri seciniz");
        System.out.println("============= İŞLEMLER =============\n" +
                "         1-EKLEME\n" +
                "         2-ARAMA\n" +
                "         3-LİSTELEME\n" +
                "         4-SİLME\n" +
                "         5-ANA MENÜ\n" +
                "         0-ÇIKIŞ");

        System.out.println("islem tercihinizi giriniz: ");
        int secilenIslem=scan.nextInt();

        switch (secilenIslem) {
            case 1:
                ekle();
                islemMenusu();
                break;
            case 2:
                arama();
                islemMenusu();
                break;
            case 3:
                listeleme();
                islemMenusu();
                break;
            case 4:
                silme();
                islemMenusu();
                break;
            case 5:
                girisPaneli();
                break;
            case 0:
                cikis();
                break;
            default:
                System.out.println("guzel birsey gir");
                islemMenusu();
                break;
        }
    }

    private static void cikis() {
        System.out.println("Yine bekleriz okulumuza hoscakalin");
        System.exit(0);    // cikis
    }

    private static void silme() {
        System.out.println("**** "+ kisiTuru+" silme sayfasina hosgeldin");
        boolean flag=true;

        if (kisiTuru.equalsIgnoreCase("OGRENCI")){
            System.out.println("silmek istedigin kimlik no gir");

            String silinecekKimlikNo= scan.next().replaceAll(" ","");

            for (Kisi each:ogrncList ) {
                if (each.getKimlikNo().equals(silinecekKimlikNo)){
                    System.out.println("silinen ogrenci "+each.getAdSoyad());
                    ogrncList.remove(each);
                    flag=false;
                    break;
                }
            }if (flag){
                System.out.println("bu tc ile ogrenci yok silinemedi");
            }



        }else{
            System.out.println("silinecek ogretmenin kimlik no gir");
            String silinecekKimlikNo=scan.next().replaceAll(" ","");

            for (Kisi each:ogrtmnList) {
                if (each.getKimlikNo().equalsIgnoreCase(silinecekKimlikNo)){
                    System.out.println("silinen ogretmen "+each.getAdSoyad());
                    ogrtmnList.remove(each);
                    flag =false;
                    break;

                }
            }if (flag){
                System.out.println("bu tc ile ogretmen bulunamadi ve silinemedi");
            }
        }
    }
    private static void listeleme() {
        System.out.println("**** "+ kisiTuru+" listeleme sayfasina hosgeldin");
        if (kisiTuru.equalsIgnoreCase("OGRENCI")){
            System.out.println("ogrncList = " + ogrncList);
        }else{
            for (Kisi each:ogrtmnList) {
                System.out.println("each.toString() = " + each.toString());
            }
        }
    }

    private static void arama() {
        System.out.println("**** "+ kisiTuru+" arama sayfasina hosgeldin");
        boolean flag =true;

        if (kisiTuru.equalsIgnoreCase("OGRENCI")){
            System.out.println("kimlik no giriniz");
            String arananKimlikNo= scan.next().replaceAll(" ","");

            for (Kisi w:ogrncList ) {
                if (w.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("aradiginiz ogrenci " +w.getAdSoyad());
                    flag=false;
                }

            }if (flag){
                System.out.println("aranan tc ile ogrenci yok ");
            }
        }else{   // kisi turu ogretmense else calisir

            System.out.println("kimlik no giriniz");
            String arananKimlikNo= scan.next().replaceAll(" ","");

            for (Kisi w:ogrtmnList ) {
                if (w.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("aradiginiz ogretmen " +w.getAdSoyad());
                    flag=false;
                }

            }if (flag){
                System.out.println("aranan tc ile ogretmen yok ");
            }

        }


    }

    private static void ekle() {
        System.out.println("**** "+ kisiTuru+" ekleme sayfasina hosgeldin");
        System.out.println("isim soyisim gir");
        scan.nextLine();
        String adSoyad=scan.nextLine();

        System.out.println("kimlik gir");
        String kimliNo=scan.nextLine();

        System.out.println("yas gir");
        int yas=scan.nextInt();

        if (kisiTuru.equals("OGRENCI")){
            System.out.println("ogrenci no gir");
            String ogrenciNo= scan.next().replaceAll(" ","");

            System.out.println("sinif gir");
            String sinif= scan.next().replaceAll(" ","");

            Ogrenci ogrenci=new Ogrenci(adSoyad,kimliNo,yas,ogrenciNo,sinif);
            ogrncList.add(ogrenci);

        }else{
            scan.nextLine();
            System.out.println("bolum gir");
            String bolum= scan.nextLine();
            System.out.println("sicil no gir");
            String sicilNo= scan.nextLine();

            Ogretmen ogretmen=new Ogretmen(adSoyad,kimliNo,yas,bolum,sicilNo);
            ogrtmnList.add(ogretmen);
            System.out.println(ogrtmnList);
        }


    }
}