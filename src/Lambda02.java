import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi=new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);//16 4 36
        System.out.println();
        tekKupPrint(sayi);//1332 -124 344 28 3376
        System.out.println();
        maxElBul(sayi);//Optional[15]
        System.out.println();
        ciftKareBuyuk(sayi);//Optional[36]
        System.out.println();
        elCarp(sayi);//Optional[48]
        System.out.println();
        minBul(sayi);//Optional[-5]
        System.out.println();
        besBuyukTek(sayi);//Optional[7]
        System.out.println();
        ciftElKareSırala(sayi);//4 16 36

    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

   public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).//Stram içerisindeki elemanları başka değerlere dönüştürüyor
                forEach(Lambda01::yazdir);

   }

    // Task 2 : Functional Programming ile listin
    // tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda02::tekBul).
                map(t->t*t*t+1).//Stream içerisindeki elemanları başka değerlere dönüştürüyor
                forEach(Lambda01::yazdir);

    }
    public static boolean tekBul(int a) {
        return a % 2 != 0;
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer>sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.println(t+" "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer>sayi){
        Optional<Integer> maxSayı = sayi.//Optinal Class'a atadık
                stream().
                reduce(Math::max);//Eğer resultım tek bir değer ise o zaman reduce terminal opr. kullanılır.
        System.out.println(maxSayı);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareBuyuk(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));//Bu sefer Math yerine Integer max'i seçtik çünkü daha hızlı

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elTopla(List<Integer>sayi){
        int toplam=sayi.
                stream().
                reduce(0,(a,b)->a+b);
        System.out.println(toplam);
        /*
    * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
    bu örnekte 0 oluyor
    * b degerini her zamana  stream()'dan akısdan alır
    * a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void elCarp(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//Math::multiplyExact = Tüm elemanları çarpar

    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                reduce(Integer::min));
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besBuyukTek(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(t -> t % 2 != 0 && t > 5).
                reduce(Integer::min));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElKareSırala(List<Integer>sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().
                forEach(Lambda01::yazdir);
    }



}



