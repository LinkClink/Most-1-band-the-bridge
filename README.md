# Synchronization (Solution) of passage over 1-band the bridge - realisation in Java with semaphores.
Projekt wykorzystania semaforow do symulacji przejazdu przez waski most Realizacja w Java.


Opis projektu (zadania):
 ~ Na drodze wschód – zachód znajduje się wąski most, po którym w danej chwili mogą jechać samochody tylko w jednym kierunku. 
 

~ Używając semaforów i traktując ruch samochodów w obu kierunkach jako dwa procesy (zadania) napisać w pseudokodzie program współbieżny rozwiązujący problem synchronizacji przejazdu samochodów przez most. 



Treść
1-	Rozwiazanie problemu metodą semaforów
2-	Rozwiazanie problemu w pseudokodzie pierwsza metoda (podobnie do języka Java)
3-	Rozwiazanie problemu w pseudokodzie druga metoda (podobnie do języka Java)
4-	Wynik





Rozwiazanie problemu metodą semaforów
Semafory:
A – semafor (1)  (1, ø)
B – semafor (2) (0, ø)
![alt text](https://pp.userapi.com/c851420/v851420223/a1313/HhG7Sn4nCAw.jpg)
 
Strona a:
wait(A); - czekamy na przejazd ze strony  b
przejazd:
{
1-	przepuszczamy maksymalnie po 10 samochódów
2-	Jezeli nie ma samochódów to wychodzimy (break);
}
signal(B); dajemy signal że strona a przejechała
_____________________________________________________
Strona b:
wait(B); czekamy na przejazd ze strony a
{
1-	przepuszczamy maksymalnie po 10 samochódów
2-	Jezeli nie ma samochódów to wychodzimy (break);
}
signal(A); dajemy signal że strona b przejechała



Rozwiązanie problemu w pseudokodzie przyklad (1)

Zmianne:
a - liczba samochodów po lewej stronie 
b - liczba samochodów po prawej stronie 
c – semafor (zmienna) dostępu mosta (dostępny jeżeli równy się 0) (0,0)
d– samochódy co przejezdzają most
 ![alt text](https://pp.userapi.com/c851420/v851420223/a1313/HhG7Sn4nCAw.jpg)
~ Będziemy przepuszczac po 10 samoshodów z jednej strony
i zaczniemy ze strony a 
Pseudokod:
Jezeli if ( a>0 i c=0 ) po stronie a jest samochody zaczynamy przepuszcac 
{
c = 1 ; semafor mosta zamknięty 
(1:Jezeli a <=10 i a >0 przepuszczamy wszystkich i (d = a) 
a =0;)
(2: Jezeli: a >10 to przepusczamy tylko 10 i (d = 10)
a = a-10;) 
} else (break)
c = 0; otwieramy dostęp do semaforu  (mosta)
Jezeli if ( b>0 i c=0 ) po stronie b też są samochody przepuszczamy
{
c = 1 ; semafor mosta zamknięty
 (1:Jezeli b <=10 i b >0 przepuszczamy wszystkich (d_liczba_sam_na_most = b)
b =0;)
(2: Jezeli: a >10 to przepusczamy tylko 10 i (d_liczba_sam_na_most = 10)
a = a-10;)
} else (break) wracamy do a; 




Rozwiązanie problemu w pseudokodzie przyklad (2)
Zmianne:
a - liczba samochodów po lewej stronie 
b - liczba samochodów po prawej stronie 
c – semafor (zmienna) dostepu mosta (dostępny jezeli rowny sie 0) (0,0)
d– samochódy co przejezdzają most
 ![alt text](https://pp.userapi.com/c851420/v851420223/a1313/HhG7Sn4nCAw.jpg)
~ Będziemy przepuszczac wszystkie samochódy z kazdej strony , znowu zaczynamy ze strony a
Pseudokod:
Jeżeli if ( a>0 i c=0 ) po stronie a jest samochódy zaczynamy przepuszcać
{
c = 1 ; semafor mosta zamknięty
d = a ; wszystkie samochody ze strony a przepuszcamy
a = 0 ; zerujemy ilość po prawej stronie
} else (break) przechodzimy do b
c = 0; otwieramy dostęp do semaforu  (mosta)
Jezeli if ( b>0 i c=0 ) po stronie b też są samochódy przepuszczamy
{
c = 1 ; semafor mosta zamknięty
d = b ; wszystkie samochódy ze strony b przepuszcamy
b = 0 ; zerujemy ilość po lewej stronie
} else (break) wracamy do a; 


Wynik
~ Ze względu na temat można powiedzieć że problem jest trywialny ale nie jest aż tak latwo.Można rozwiązać problem dużej ilośćą sposobów i metodów.
~ Kilka pszedstałyłem w projekcie:
1 – Metoda przepuszczania po pewnej ilości samochodów z każdej strony ( w moim pszypadku po 10 ) .
2 – Metoda przepuszczania wszystkich z kazdej strony po koleji .

~ Jakich nie ma w projekcie:
3 – Metoda pszepuszczania po czasie jak (np. kilka minut) 
jest to bardzo dobra metoda w naszym życiu realizowana pszez sygnalizacją świetlną.

~ Na mój względ jeżeli podzielić ich na lepsze i gorsze to można tak zdecydować że:
Najgorsza metoda jest druga(2) dlatego że nie wiemy gdzie to będzie wykorzystane i ile będzie tych samochódów obok mosta , nejlepsze są trzecia(3) metoda bo jest sprawdzona i dziala barzdo dobrze , tak samo jak i pierwsza(1) metoda.

