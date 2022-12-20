import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {


        /*
    TASK :
    fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */

    public static void main(String[] args) {
        Universite u01=new Universite("bogazici","matematik",571,93);
        Universite u02=new Universite("istanbul tk","matematik",600,84);
        Universite u03=new Universite("istanbul","hukuk",1400,71);
        Universite u04=new Universite("marmara","bilgisayar",1080,77);
        Universite u05=new Universite("odtu","gemi mh",333,74);

        List<Universite> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));//False
        System.out.println();
        System.out.println(matBlmVarMi(unv));//true
        System.out.println();
        System.out.println(siralaBykKck(unv));//[Universite{univercity='istanbul', bolum='hukuk', ogrSayisi=1400, notOrt=71}, Universite{univercity='marmara', bolum='bilgisayar', ogrSayisi=1080, notOrt=77}, Universite{univercity='istanbul tk', bolum='matematik', ogrSayisi=600, notOrt=84}, Universite{univercity='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93}, Universite{univercity='odtu', bolum='gemi mh', ogrSayisi=333, notOrt=74}]
        System.out.println();
        System.out.println(matSayısı(unv));//2
        System.out.println();
        System.out.println(ogrSayısı550BykMaxNotOrt(unv));//OptionalInt[93]
        System.out.println(ogrSayisi1050AzMinOrt(unv));//OptionalInt[74]
    }

    //task 01--> Bütün üniversiteleri notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return  unv.stream().
                allMatch(t->t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBlmVarMi(List<Universite> unv){
        return unv.stream().anyMatch(t->t.getBolum().equals("matematik"));
    }

    //task 3-üniversiteleri öğrenci sayılarına göre B--K sıralayın
    public static List<Universite> siralaBykKck(List<Universite> unv){
       return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matSayısı(List<Universite> unv){
        return (int)unv.
                stream().
                filter(t->t.getBolum().equalsIgnoreCase("matematik")).
                count();

    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayısı550BykMaxNotOrt(List<Universite> unv){
       return unv.stream().
               filter(t->t.getOgrSayisi()>550).
               mapToInt(t->t.getNotOrt()).
               max();
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi1050AzMinOrt(List<Universite> unv){
        return unv.stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(Universite::getNotOrt).
                min();
    }


}
