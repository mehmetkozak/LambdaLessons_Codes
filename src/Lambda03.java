import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {


    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    public static void main(String[] args) {
        List<String> menu=new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec",
                "küşleme","arabAşı","waffle","künefe"));

        alfBykTekrrsz(menu);//ARABAŞI GÜVEC HAVUCDİLİM KOKOREC KÜNEFE KÜŞLEME TRİLEÇE WAFFLE
        System.out.println("********");
        chrSayisiTersSiraliTekrrsz(menu);//10 7 6 5
        System.out.println("********");
        chrSayisiSirala(menu);//güvec waffle künefe trileçe kokorec küşleme arabAşı havucDilim
        System.out.println("********");
        el7mi(menu);//List elemanları 7 harfden büyük
        System.out.println("********");
        wIleBaslayanElKont(menu);
        System.out.println("********");
        xIleBitenElKont(menu);
        System.out.println("********");
        charSayisiEnBuyukEl(menu);
        System.out.println("********");
        sonHarfSiralaİlkElHaric(menu);
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static  void alfBykTekrrsz(List<String> yemek){
        yemek.stream().
                map(String::toUpperCase).
                sorted().
                distinct().//Elemanların tekrarsız olmasını sağladı
                forEach(t-> System.out.print(t+" "));
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static  void chrSayisiTersSiraliTekrrsz(List<String> yemek){
        yemek.stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::yazdir);
    }
    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static  void chrSayisiSirala(List<String> yemek){
        yemek.stream().
                sorted(Comparator.comparing(String::length)).//String ifadeler karakter saysına göre küçükten büyüğe sıraladım
                forEach(Lambda01::yazdir);
    }
    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static  void el7mi(List<String> yemek){
        System.out.println(yemek.stream().
                allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve 7 den daha az" :
                "List elemanları 7 harfden büyük");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static  void wIleBaslayanElKont(List<String> yemek){
        System.out.println(yemek.stream().
                noneMatch(t -> t.startsWith("w")) ? " w ile başlayan yemek mi olur" : " w ile başlayan yemek var");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKont(List<String> yemek){
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "Var" : "Yok");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBuyukEl(List<String> yemek){
        Stream<String> son=yemek.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).limit(1);
        System.out.println(Arrays.toString(son.toArray()));
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void sonHarfSiralaİlkElHaric(List<String> yemek){
        yemek.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(1).
                forEach(Lambda01::yazdir);
    }
}
