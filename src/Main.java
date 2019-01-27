import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main

{
    //dekalracja

    static int strona_a = 100;
    static  int strona_b = 100;

    static  int flag_a = 0;
    static int flag_b = 0;

    static  int samoch_na_moscie_a = 0;

    static int wurownia_ilosc_a = 0;

    // 0 - rowno  1 - wiec a  2 - wiec b
    static  int procent_po_stronie = 0;


    public static void main ( String args[] )
    {
        // Wygenerowania losowej liczby sam. po kazdej stronie
        generacja_samochodow();

        // Oblicz strony na jakiej jest wiecje sam.
        procent_po_stronam_na_moscie();

        while(strona_b > 0 || strona_a > 0 )
        {
            pszejazd_lewa_a();
            if(procent_po_stronie != 2)
            {
                generacja_mosta("a");
            }

            procent_po_stronam_na_moscie();

            pszejazd_prawa_b();
            if(procent_po_stronie != 1)
            {
                generacja_mosta("b");
            }

        }

    }


    ////////////
    public static void generacja_samochodow()
    {
        Random random_1_liczba_sam = new Random();

        strona_a = random_1_liczba_sam.nextInt(100);
        //strona_a = 1;
        System.out.print("Po lewej stronie a " + strona_a + "\n");

        strona_b = random_1_liczba_sam.nextInt(100);
        //strona_b = 10;
        System.out.print("Po prawej stronie b " + strona_b + "\n");

    }

    ///////

    public static void pszejazd_lewa_a()
    {

        samoch_na_moscie_a = 0;

        if( flag_a == 0 && strona_a > 0 )
        {
            flag_b = 1;

            switch (procent_po_stronie)
            {
                // a = b
                case 0:
                {
                    if(strona_a >= 10 )
                    {
                        samoch_na_moscie_a = 10;
                        strona_a = strona_a - 10;

                    }
                    else
                    {
                        samoch_na_moscie_a = strona_a;
                        strona_a = 0;
                    }

                    flag_b = 0;
                    break;
                }
                // a > b
                case 1:
                {
                    samoch_na_moscie_a = wurownia_ilosc_a;
                    strona_a = strona_a - wurownia_ilosc_a;
                    flag_b = 0;
                    break;
                }
                // a < b
                case 2:
                {
                    flag_b = 0;
                    break;
                }

            }

        }

    }
    ///////////////////

    public static void pszejazd_prawa_b()
    {

        samoch_na_moscie_a = 0;

        if( flag_b == 0 && strona_b > 0 )
        {
            flag_a = 1;

            switch (procent_po_stronie)
            {
                //  b = a
                case 0:
                {
                    if(strona_b >= 10 )
                    {
                        samoch_na_moscie_a = 10;
                        strona_b = strona_b - 10;

                    }
                    else
                    {
                        samoch_na_moscie_a = strona_b;
                        strona_b = 0;
                    }

                    flag_a = 0;
                    break;
                }
                // b < a
                case 1:
                {
                    flag_a = 0;
                    break;
                }
                // b > a
                case 2:
                {

                    samoch_na_moscie_a = wurownia_ilosc_a;
                    strona_b = strona_b - wurownia_ilosc_a;
                    System.out.print("test"+strona_b);
                    flag_a = 0;
                    break;
                }

            }

        }

    }
///////////////





    //////////////////
    public static void procent_po_stronam_na_moscie()
    {

        // 1 a = b
        if(strona_a == strona_b )
        {
            wurownia_ilosc_a = 10;
            procent_po_stronie  = 0;
        }

        // 2 a > b
        if(strona_a > strona_b )
        {
            //if(strona_a >= 25)
            wurownia_ilosc_a = strona_a - strona_b;
            procent_po_stronie = 1;
        }
        // 3  b > a
        if(strona_b > strona_a )
        {
            wurownia_ilosc_a = strona_b - strona_a;
            procent_po_stronie = 2;
        }

        switch (procent_po_stronie)
        {
            case 0:
            {
                System.out.print("\nJednakowa ilosc z kazdej strony a = b \n");
                break;
            }
            case 1:
            {
                System.out.print("\nPo stronie a wiecej samochodow a > b \n");
                break;
            }
            case 2:
            {
                System.out.print("\nPo stronie b wiecej samochodow b > a \n");
                break;
            }


        }




    }
////////////////////////






    public static void generacja_mosta(String strona)
    {
        System.out.print("Pszejazd sam. ze strony " + strona + "\n" );
        System.out.print(samoch_na_moscie_a + " somochodow ze strony " + strona + "\n" );

        for(int i = 0; i < samoch_na_moscie_a; i++)
        {
            System.out.print(i+" Pszejazd \n");
            try
            {
                TimeUnit.MILLISECONDS.sleep(30);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        //samoch_na_moscie_a = 0;
        System.out.print("\n strona b "+strona_b +"\n");
        System.out.print("\n strona a "+strona_a +"\n");

    }











}
