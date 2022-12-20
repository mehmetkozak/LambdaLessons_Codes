import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println();
        System.out.println(ciftSayiTopla(4));
        System.out.println(kacinciXCiftTopls(4));
        System.out.println();
        System.out.println(kacinciXTekTopls(3));
        ikininIlkXKuvvetPrint(5);
        System.out.println();
        verilenSaininIlkXKuvvetPrint(3,5);
        System.out.println();
        faktoriyel(5);

    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari
    // toplayan bir program create ediniz.

    //Structured
    public static int topla(int x){
        int toplam=0;
        for (int i = 0; i <=x ; i++) {
            toplam+=i;
        }
        return toplam;
    }

    //Functional
    public static int toplaFunct(int x){
        return IntStream.//int değerlerde bir akış sağlar
                range(1,x+1).//1 dahil,x+1 dahil değil akışı almaya sağlar
                sum();//toplama işlemi yapar
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftSayiTopla(int x){
        return IntStream.range(1,x+1).filter(t->t%2==0).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int kacinciXCiftTopls(int x){
        return IntStream.
                iterate(2,t->t+2).//22Den başla sürekli +2 ekleyerek sonsuza git
                limit(x).
                sum();
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int kacinciXTekTopls(int x){
        return IntStream.
                iterate(1,t->t+2).//2'Den başla sürekli +2 ekleyerek sonsuza git
                limit(x).
                sum();
    }
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x){
        IntStream.
                iterate(2,t->t*2).//2'Den başla sürekli 2 ile çarparak sonsuza git
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk y kuvvetini ekrana yazdiran programi  create ediniz.
    public static void verilenSaininIlkXKuvvetPrint(int istenenSayi,int y){
        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(y).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static void faktoriyel(int a){
        System.out.println(IntStream.
                rangeClosed(1, a).reduce(1,(t,u)->t*u));
    }
}
