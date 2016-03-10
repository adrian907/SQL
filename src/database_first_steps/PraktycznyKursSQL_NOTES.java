package database_first_steps;

public class PraktycznyKursSQL_NOTES {

}

/*
Baza danych to zbiór powi¹zanych ze sob¹ informacji o œciœle okreœlonej
strukturze.

/////////////////Model jednorodny
W tym modelu wszystkie dane s¹ przechowywane w jednym arkuszu, tabeli, kostce
analitycznej lub pliku (st¹d nazwa modelu).

Zaletami tego modelu s¹ ³atwoœæ i szybkoœæ odczytywania interesuj¹cych nas
danych — w tym przypadku wystarczy tylko znaleŸæ rekord opisuj¹cy szukany zakup,
¿eby poznaæ wszystkie szczegó³y operacji.
Wad¹ modelu jednorodnego jest du¿a liczba duplikatów (powtarzaj¹cych siê
danych) — w naszym przyk³adzie nazwa dostawcy, jego adres i telefon kontaktowy
wpisane s¹ tyle razy, ile razy kupiliœmy u niego towar.

Wielokrotne zapisywanie tych samych danych nie tylko zajmuje wiêcej miejsca na dysku
i w pamiêci, lecz tak¿e:

1. Utrudnia modyfikowanie danych.
2. Zwiêksza ryzyko wpisania b³êdnych danych.

 ////////////////////////RELATIONAL MODEL 
W modelu relacyjnym dane s¹ przechowywane w wielu odrêbnych, ale powi¹zanych
ze sob¹ tabelach.

Zalet¹ modelu relacyjnego jest zapobieganie tworzeniu duplikatów danych.

Wad¹ modelu relacyjnego jest skomplikowane i wolne odczytywanie danych.

Dane s¹ przechowywane w osobnych, ale powi¹zanych ze sob¹ tabelach.

Te ³¹cz¹ce tabele
powi¹zania nazywa siê relacjami (st¹d nazwa modelu).

Informacje na temat tego, która tabela jest powi¹zana z innymi tabelami, s¹ prezentowane
w postaci diagramów E/R (diagramów Encja/Relacja).

Kolumna, która zawiera identyfikator rekordu innej
tabeli, nazywa siê kluczem obcym.

Specjalna kolumna,w której zapisuje siê identyfikatory poszczególnych wierszy - kolumna ta nazywa
siê kluczem podstawowym tabeli.


///////////////////////////Model obiektowy

Relacyjn¹ bazê danych mo¿na porównaæ do magazynu z meblami, w którym ka¿da
czêœæ mebla jest umieszczana w osobnym, przeznaczonym wy³¹cznie dla niej kontenerze
(odpowiednikami kontenerów s¹ tabele).

Tymczasem model obiektowy przypomina magazyn, w którym meble s¹ ustawiane bez
rozbierania na czêœci. W rezultacie korzystanie z magazynu jest prostsze (ale niekoniecznie
szybsze), za to liczba mebli, jak¹ mo¿na zmieœciæ na tej samej przestrzeni,
jest znacznie mniejsza.

W opracowanym w latach 90. XX wieku modelu obiektowym informacje s¹ przechowywane
w bazie nie w postaci rekordów, ale ca³ych obiektów.

Zalet¹ modelu obiektowego jest zgodnoœæ z obowi¹zuj¹cym paradygmatem programowania.

Wiêkszoœæ jêzyków programowania, w przeciwieñstwie
do jêzyka SQL, ma wbudowan¹ statyczn¹ kontrolê typów, a w prawie ¿adnym
z nich nie wystêpuje podstawowy dla jêzyka SQL typ „relacja”, wiele jêzyków
programowania nie obs³uguje te¿ wartoœci NULL.

SQL jest jêzykiem interpretowanym, a nie kompilowanym.

W jêzyku SQL programista okreœla wynik, jaki chce
otrzymaæ, a nie sposób, w jaki ma on byæ osi¹gniêty.

Do dziœ nie opracowano standardu tego modelu, a nieliczne obiektowe bazy danych s¹ u¿ywane
g³ównie w celach badawczych, ponadto nie umo¿liwiaj¹ one na razie przechowywania
du¿ych (liczonych w setkach gigabajtów czy terabajtów) iloœci danych, nie mówi¹c ju¿
o wydajnym zarz¹dzaniu nimi.

Ogromn¹ popularnoœæ zdobywaj¹ technologie ORM (ang. Object-Relational Mapping), które
pozwalaj¹ programistom traktowaæ relacyjne bazy danych tak, jakby by³y bazami
obiektowymi.

Relacyjny model baz danych zosta³ opracowany w latach 70. XX wieku przez pracuj¹cego
dla firmy IBM naukowca Edgara Franka Codda.

Tylko serwery zgodne z wszystkimi postulatami E.F. Codda uznawane
s¹ za serwery relacyjnych baz danych.

Metadane (informacje o strukturze bazy danych).

Proces dostosowywania schematu bazy danych do wymogów modelu relacyjnego
nazywa siê normalizacj¹.

Edgar Frank Codd zdefiniowa³ trzy postacie normalne i chocia¿ póŸniej zosta³y dodane
kolejne trzy, to prawie wszystkie bazy danych doprowadza siê do trzeciej postaci
normalnej (3PN), a ponad 75% baz danych znormalizowanych jest do czwartej
postaci normalnej (4NF). Baza danych znajduj¹ca siê w wy¿szej postaci normalnej
musi spe³niaæ wymogi wszystkich ni¿szych postaci normalnych.

/////////////////Pierwsza postaæ normalna
G³ównym celem doprowadzania do pierwszej postaci normalnej jest wyeliminowanie
nieatomowych atrybutów (tabela jest zgodna z 1PN, jeœli wszystkie jej kolumny przechowuj¹
atomowe, niepodzielne wartoœci). Na przyk³ad kolumnê Adres nale¿y rozbiæ
na kilka kolumn przechowuj¹cych kod, nazwê miasta i ulicê, a kolumnê Osoba — na
dwie: Imiê i Nazwisko.

Za atomowe wartoœci nale¿y przyj¹æ takie, które mog¹ byæ u¿yte w przysz³oœci do:
1. wyszukiwania, np. znalezienia osoby o podanym nazwisku;
2. sortowania, np. przygotowania listy osób u³o¿onej alfabetycznie wed³ug imion;
3. grupowania, np. policzenia osób mieszkaj¹cych w poszczególnych miastach.
Ponadto aby spe³niæ wymogi pierwszej postaci normalnej, tabela musi posiadaæ
kolumnê klucza podstawowego.

//////////////////Druga postaæ normalna
 * 
Doprowadzenie tabeli do drugiej postaci normalnej polega na usuniêciu z niej atrybutów
(kolumn), które zale¿¹ funkcyjnie od czêœci klucza podstawowego (tabela jest
zgodna z 2PN, je¿eli znajduje siê w pierwszej postaci normalnej i wartoœci jej
wszystkich niekluczowych kolumn zale¿¹ od ca³ego klucza podstawowego). W praktyce
oznacza to, ¿e jeœli klucz podstawowy tabeli jest prosty (za³o¿ony na pojedynczej
kolumnie), a nie z³o¿ony (za³o¿ony na kilku kolumnach), i tabela jest w 1PN, to
spe³nia ona te¿ automatycznie wymogi drugiej postaci normalnej.

Sytuacja taka mia³aby miejsce, gdyby w tabeli SalesOrderDetail, której kluczem
podstawowym s¹ kolumny SalesOrderID oraz SalesOrderDetailID, znajdowa³a siê
kolumna z dat¹ zamówienia. Wtedy kolumna OrderDate zale¿a³aby wy³¹cznie od jednej
czêœci klucza podstawowego (kolumny SalesOrderID), innymi s³owy — znaj¹c identyfikator
zamówienia, moglibyœmy ze 100-procentow¹ dok³adnoœci¹ odczytaæ jego
datê i znajomoœæ identyfikatora SalesOrderDetailID by³aby do tego niepotrzebna.

////////////////////Trzecia postaæ normalna
Doprowadzenie tabeli do trzeciej postaci normalnej polega na znalezieniu i usuniêciu
przechodnich zale¿noœci pomiêdzy atrybutami (tabela jest zgodna z 3PN, je¿eli jest
ju¿ w drugiej postaci normalnej i wartoœci jej kolumn nie s¹ zale¿ne od niekluczowych
atrybutów).
Na przyk³ad jeœli w tabeli Product znajdowa³aby siê kolumna z nazwami kategorii,
wartoœci w tej kolumnie powtarza³yby siê tyle razy, ile produktów nale¿a³oby do
danej kategorii. Nadmiarowoœæ ta wynika z faktu, ¿e nazwa kategorii zale¿y funkcyjnie
nie tylko od identyfikatora produktu (znaj¹c go, mo¿emy jednoznacznie odczytaæ
nazwê kategorii), ale równie¿ od innych atrybutów produktu, takich jak jego
nazwa czy numer.

Doprowadzanie tabel do trzeciej postaci normalnej polega na:
1. Utworzeniu tabel s³ownikowych, np. tabeli z nazwami miast. Takie tabele
zawieraj¹ listy (s³owniki) u¿ywanych w bazie terminów, dziêki czemu zamiast
ka¿dorazowo pos³ugiwaæ siê danym terminem, wystarczy u¿yæ jego
identyfikatora.
2. Utworzeniu tabel ³¹cznikowych, czyli takich, które umo¿liwiaj¹ budowanie
relacji typu „wiele do wielu”. Na przyk³ad je¿eli przyjmiemy, ¿e ta sama
osoba mo¿e zapisaæ siê jednoczeœnie na kilka kursów, a na ten sam kurs z regu³y
mo¿e zapisaæ siê wiele osób, powinniœmy utworzyæ tabelê KursOsoba i umieœciæ
w niej klucze obce tabel Osoby i Kursy oraz atrybuty konieczne dla po³¹czenia
kursanta z jego zajêciami, takie jak numer sali czy godzina rozpoczêcia zajêæ.



Relacja "Wiele do wielu."
Przyk³ad : Ten sam sklep mo¿e sprzedawaæ dowolne produkty i ten sam produkt
mo¿e byæ sprzedawany w ró¿nych sklepach

Relacja „jeden do wielu”
Jeden produkt nie mo¿e nale¿eæ do ró¿nych kategorii, ale do tej samej
kategorii mo¿e nale¿eæ wiele produktów.

//////////////////Postaæ Boyce’a-Codda
Kolejn¹, czasami nazwan¹ postaci¹ trzeci¹ i pó³, postaci¹ normaln¹ jest postaæ
Boyce’a-Codda (BCNF). Jej formalna definicja brzmi nastêpuj¹co: tabela jest zgodna
z BCNF, je¿eli jest ju¿ w trzeciej postaci normalnej i dla ka¿dej nietrywialnej zale¿noœci
miêdzy podzbiorami jej atrybutów zbiór bêd¹cy wyznacznikiem jest jej zbiorem
identyfikuj¹cym. Poniewa¿ ³atwiej jest wyjaœniæ postaæ Boyce’a-Codda na przyk³adzie
ni¿ na podstawie jej definicji, przypuœæmy, ¿e w bazie danych znajduje siê tabela
z danymi na temat sklepów, sprzedawanych w nich towarów oraz ich kategorii. Za³ó¿my
te¿, ¿e ten sam sklep mo¿e sprzedawaæ dowolne produkty i ten sam produkt
mo¿e byæ sprzedawany w ró¿nych sklepach (tak¹ relacjê nazywa siê relacj¹ „wiele do
wielu”) i ¿e jeden produkt nie mo¿e nale¿eæ do ró¿nych kategorii, ale do tej samej
kategorii mo¿e nale¿eæ wiele produktów (jest to przyk³ad znanej nam ju¿ relacji „jeden
do wielu”)

Kluczem podstawowym takiej tabeli mog³yby byæ kolumny Sklep i Towar, bo na podstawie
obu tych wartoœci mo¿na jednoznacznie zidentyfikowaæ pozosta³e atrybuty, w tym
kategoriê. W takim wypadku tabela by³aby znormalizowana do trzeciej postaci normalnej.
Gdybyœmy jednak chcieli dopisaæ do tej tabeli nowy sklep, mielibyœmy problem
— jej kluczem jest kombinacja identyfikatora sklepu i sprzedawanych w nim produktów,
a wiêc sklepu, w którym nic jeszcze nie sprzedaliœmy, nie da³oby siê dopisaæ.
Aby rozwi¹zaæ ten problem, nale¿a³oby podzieliæ tabelê na cztery osobne, spe³niaj¹ce
wymogi postaci BCNF tabele, w których by³yby zapisane dane:

1. w pierwszej o sklepach;
2. w drugiej o produktach;
3. w trzeciej o kategoriach produktów;
4. w czwartej o sprzedawanych w danym sklepie produktach (to by³aby tak
zwana tabela ³¹cznikowa).


////////////////////Czwarta postaæ normalna
W definicji czwartej postaci normalnej termin „zale¿noœæ funkcyjna” jest zast¹piony
terminem „zale¿noœæ wielowartoœciowa” (tabela jest zgodna z 4PN, je¿eli jest ju¿
w postaci Boyce’a-Codda i nie wystêpuj¹ w niej zale¿noœci wielowartoœciowe). Ponownie
naj³atwiej postaæ tê wyt³umaczyæ na przyk³adzie.

WyobraŸmy sobie tabelê Produkty, w której w kolumnie Nazwa zapisane s¹ nazwy ró¿nych
przedmiotów (np. krzes³o, lornetka i tak dalej). W kolejnych kolumnach znajduj¹
siê wartoœci ró¿nych atrybutów tych przedmiotów, np. w kolumnie Obicie kolor obicia,
a w kolumnie Ogniskowa dane o ogniskowej obiektywu. Jako ¿e ró¿ne przedmioty
maj¹ ró¿ne cechy (np. krzes³a nie maj¹ ogniskowej), wiele komórek takiej tabeli bêdzie
pustych.

Powodem tej anomalii jest wystêpowanie zale¿noœci wielowartoœciowej, czyli takiej,
w której na podstawie jednej kolumny (nazwy przedmiotu) mo¿na wnioskowaæ o wielu
kolumnach (takich jak Ogniskowa czy Obwód w pasie). Aby doprowadziæ tabelê do postaci
zgodnej z czwart¹ postaci¹ normaln¹, nale¿y j¹ rozbiæ na osobne tabele, których
kolumny bêd¹ zawiera³y wy³¹cznie nazwy cech obiektów danego typu.

//////////////////////////////////////////////////////////////////

Teoretyczne podstawy modelu relacyjnego, w tym trzy pierwsze postacie
normalne, zosta³y zdefiniowane w latach 70. XX wieku przez dra E.F. Codda.

W odró¿nieniu od innych jêzyków SQL umo¿liwia przetwarzanie wielu danych za
pomoc¹ pojedynczej instrukcji.

!W przeciwieñstwie do jêzyków proceduralnych SQL pozwala okreœliæ wynik, nie
sposób jego osi¹gniêcia. Instrukcje jêzyka SQL nie zawieraj¹ ¿adnych wskazówek
dotycz¹cych metody ich wykonywania przez serwer bazodanowy. W poprzednim przyk³adzie
instrukcja SELECT nie okreœla³a sposobu (algorytmu), wed³ug którego serwer mia³
znaleŸæ szukany element w tabeli. Poniewa¿ w jêzyku SQL deklaruje siê spodziewany
rezultat wykonania instrukcji, nazywa siê go jêzykiem strukturalnym.

!Sposób wykonania instrukcji jêzyka SQL zale¿y od serwera bazodanowego.

!W przeciwieñstwie do jêzyków proceduralnych, których instrukcje s¹ wykonywane w tej samej
kolejnoœci, w jakiej zosta³y zapisane, w jêzyku SQL kolejnoœæ wykonywania poleceñ
zale¿y od serwera i niekoniecznie odpowiada kolejnoœci, w jakiej zapisano poszczególne
instrukcje i ich klauzule3.

Wspomniane wczeœniej jêzyki: C, C++, Pascal, Visual Basic i Java s¹ jêzykami kompilowanymi
— ich instrukcje s¹ przekszta³cane do postaci kodu wykonywalnego przez
kompilatory.

Instrukcje jêzyka SQL, przed wykonaniem s¹ interpretowane przez serwer bazodanowy.
Wynikiem tej interpretacji jest plan wykonania instrukcji, który nastêpnie jest
realizowany przez serwer.

Podczas interpretacji przeprowadzana jest optymalizacja polegaj¹ca na znalezieniu
jak najlepszego (w przypadku serwera SQL Server jak najtañszego) planu wykonania.
Odpowiedzialne za to optymalizatory s¹ z regu³y najbardziej skomplikowanymi
elementami serwerów bazodanowych.

Poniewa¿ instrukcje jêzyka SQL s¹ interpretowane, a nie kompilowane, niektóre b³êdy
 zostan¹ wykryte dopiero podczas ich wykonywania.

Kolejn¹ konsekwencj¹ ka¿dorazowego interpretowania instrukcji SQL jest d³u¿szy
czas (a wiêc wy¿szy koszt) ich wykonania. Dotyczy to jednak wy³¹cznie sytuacji, w których
jêzyk SQL jest u¿ywany niezgodnie z jego przeznaczeniem, czyli do przetwarzania
pojedynczych, a nie ca³ych zbiorów danych.


/////////////////Sk³adnia jêzyka SQL
W jêzyku SQL wystêpuje piêæ g³ównych kategorii syntaktycznych:
1. identyfikatory, czyli nazwy obiektów;
2. litera³y, czyli sta³e;
3. operatory, czyli spójniki;
4. s³owa kluczowe, czyli wyrazy interpretowane przez serwer bazodanowy
w okreœlony sposób;
5. ignorowane przez serwery bazodanowe komentarze.

////////////////////////////////////////////////////////////////////////
Identyfikatory musz¹ byæ zgodne ze zdefiniowanymi w standardzie jêzyka SQL regu³ami:

1. Nie mog¹ sk³adaæ siê z wiêcej ni¿ 128 znaków.
2. Mog¹ zawieraæ litery, cyfry oraz symbole: @, $, #. Pozosta³e symbole, w tym znak
spacji, s¹ niedozwolone.
3. Mog¹ zaczynaæ siê liter¹, ale nie cyfr¹. Identyfikatory zaczynaj¹ce siê jednym
z dwóch dozwolonych symboli maj¹ specjalne znaczenie:
a) Identyfikator rozpoczynaj¹cy siê symbolem @ oznacza zmienn¹.
b) Identyfikator rozpoczynaj¹cy siê symbolem # oznacza obiekt tymczasowy.
4. Nie mog¹ byæ s³owami kluczowymi jêzyka SQL.

Dodatkowo identyfikatory powinny byæ zgodne z poni¿szymi konwencjami nazewniczymi:
1. Powinny byæ krótkie, ale jednoznacznie opisywaæ dany obiekt. Na przyk³ad
tabela zawieraj¹ca zamówienia z roku 2008 powinna nazywaæ siê nie Z08,
ale raczej Zamówienia2008.
2. Wielkoœæ liter powinna byæ zgodna z przyjêtymi w ramach projektu regu³ami.
Nam najbardziej podoba siê zasada mówi¹ca, ¿e ka¿dy wyraz (z wyj¹tkiem
pierwszego) powinien zaczynaæ siê od wielkiej litery, np.
udfNajdro¿szeTowary.
3. Przedrostek nazw widoków, funkcji u¿ytkownika, procedur sk³adowanych
czy wyzwalaczy powinien wskazywaæ na typ obiektu, np. udf — funkcja
u¿ytkownika (ang. User Define Function), usp — procedura u¿ytkownika
(ang. User Stored Procedure), v — widok (ang. View), tr — wyzwalacz
(ang. Trigger)

/////////////////////////////////////////////////////////////////////////////
Litera³y
Wszystkie cyfry, ci¹gi znaków i daty, je¿eli nie s¹ identyfikatorami, s¹ traktowane jako
sta³e, czyli litera³y. W jêzyku SQL ci¹gi znaków umieszcza siê w apostrofach:
SELECT 'Przyk³adowy ci¹g znaków';

////////////////////////////////////////////////////////////////////////////////////
Operatory
Operatory odgrywaj¹ rolê spójników. Niektóre z nich mog¹ (ale nie powinny, bo instrukcje
z nimi s¹ czytelniejsze) byæ zast¹pione odpowiednimi funkcjami. Operatory dziel¹ siê na:
1. Arytmetyczne, do których nale¿¹: iloczyn *, iloraz /, modulo %, suma + i ró¿nica -.
2. Znakowe, do których nale¿¹: konkatenacja (z³¹czenie ci¹gów znaków) +, symbol
wieloznaczny (zastêpuj¹cy dowolny ci¹g znaków) % i symbol wieloznaczny
(zastêpuj¹cy jeden znak) _.
3. Logiczne, do których nale¿¹: koniunkcja AND, alternatywa OR i negacja NOT.
4. Porównania, do których nale¿¹: równy =, mniejszy ni¿ <, wiêkszy ni¿ >, mniejszy
lub równy <=, wiêkszy lub równy >= i ró¿ny != lub <>.
5. Charakterystyczne dla jêzyka SQL. Nale¿¹ do nich m.in.: przynale¿noœæ
do zbioru IN, przynale¿noœæ do domkniêtego przedzia³u BETWEEN … AND, zgodnoœæ
ze wzorem LIKE, kaskadowe wykonanie operacji CASCADE oraz wywo³anie
funkcji tabelarycznej APPLY.


!Lista dostêpnych operatorów jêzyka SQL zale¿y od konkretnego serwera bazodanowego.
///////////////////////////////////////////////////////////////////////////////////////////
S³owa kluczowe
S³owa kluczowe to zastrze¿one, maj¹ce œciœle okreœlone znaczenie ci¹gi znaków. Nale¿¹
do nich:
1. instrukcje jêzyka SQL, takie jak SELECT czy CREATE;
2. klauzule jêzyka SQL, np. WHERE lub JOIN;
3. nazwy typów danych, np. INT lub CHAR;
4. nazwy funkcji systemowych, takie jak ISNULL() lub ABS();
5. terminy zarezerwowane dla przysz³ego u¿ycia w danym serwerze bazodanowym.

Komentarze
W jêzyku SQL wystêpuj¹ dwa rodzaje komentarzy:
1. Podwójny znak myœlnika oznacza komentarz w wierszu. Czêœæ wiersza,
która znajduje siê za znakami --, jest traktowana jako komentarz:
SELECT 'test'; -- przyk³adowy komentarz
2. Znaki / * ( bez spacji) oznaczaj¹ pocz¹tek bloku komentarza, a znaki * / — jego koniec.
Wiersze znajduj¹ce siê pomiêdzy tymi znakami s¹ traktowane jako komentarz:
/*
Funkcja zwraca ostatnie zamówienie
z³o¿one przez klienta w danym sklepie
*/
/*
 
W ró¿nych serwerach zastosowane s¹ ró¿ne dialekty jêzyka SQL , 
wynika to z konkurowania miêdzy sob¹ firm w zakresie oferowanych przez ich serwery mo¿liwoœci.

Standard SQL99 nie definiuje wielu rozszerzeñ jêzyka SQL, przede wszystkim
instrukcji steruj¹cych wykonaniem programu oraz metod obs³ugi b³êdów.

Standard SQL99 nie obejmuje tak¿e wewnêtrznych mechanizmów wykonywania
i optymalizacji instrukcji jêzyka SQL przez serwery bazodanowe.


////////////////////////////////////////////////////////////////////
 
Do najpopularniejszych dialektów jêzyka SQL nale¿¹:
1. T-SQL — chocia¿ stosowane w serwerach Microsoft SQL Server i Sybase
Adaptive Server odmiany tego jêzyka ró¿ni¹ siê, to wci¹¿ klasyfikuje siê je
jako jeden dialekt.
2. PL/SQL (ang. Procedural Language/SQL) — przypominaj¹cy jêzyk ADA,
bardzo rozbudowany dialekt jêzyka SQL stosowany w serwerach firmy Oracle.
3. PL/pgSQL (ang. Procedural Language/PostgreSQL Structured Query Language)
— przypominaj¹ca dialekt PL/SQL wersja jêzyka SQL zaimplementowana
w serwerze PostgreSQL.
4. SQL PL (ang. SQL Procedural Language) — dialekt u¿ywany w serwerach
bazodanowych firmy IBM.



SQL1 - 1989 wydany przez ISO .
SQL2 - 1992 .
SQL3 - 1999. 
SQL4 - 2003	
SQL5 - 2006
SQL6 - 2008
SQL7 - 2011

Podzia³ instrukcji na kategorie w SQL3 :

1. Connection Statements — instrukcje umo¿liwiaj¹ce nawi¹zanie i zakoñczenie
po³¹czenia z serwerem, np. CONNECT i DISCONNECT;
2. Control Statements — instrukcje steruj¹ce wykonaniem programu, np. CALL
i RETURN;
3. Data Statements — instrukcje maj¹ce trwa³y wp³yw na dane, np. SELECT, INSERT,
UPDATE i DELETE;
4. Diagnostics Statements — instrukcje diagnostyczne umo¿liwiaj¹ce obs³ugê
b³êdów, np. GET DIAGNOSTICS, TRY … CATCH i RAISERROR;
5. Schema Statements — instrukcje maj¹ce trwa³y wp³yw na obiekty baz danych,
np. CREATE, ALTER i DROP;
6. Session Statements — instrukcje kontroluj¹ce opcje sesji u¿ytkowników, np. SET;
7. Transaction Statements — instrukcje umo¿liwiaj¹ce rozpoczêcie i zakoñczenie
transakcji, np. START, COMMIT i ROLLBACK.


SQL3 - By³ to pierwszy standard obejmuj¹cy zaawansowane funkcje i obszary zastosowañ jêzyka SQL, takie jak modele
obiektowo-relacyjnych baz danych, mechanizmy wywo³ywania instrukcji jêzyka SQL
czy techniki zarz¹dzania spójnoœci¹ danych.

Kategoria Przyk³adowe typy danych Opis
Typy liczbowe INTEGER (INT), SMALLINT				Reprezentuj¹ liczby ca³kowite.
NUMERIC (DECIMAL)									Reprezentuje liczby o okreœlonej skali i precyzji.
REAL												Reprezentuje liczby o zmiennej precyzji.

Typy daty i czasu 
DATE												Reprezentuje datê.
TIME												Reprezentuje czas.

Typy znakowe 
CHAR												Reprezentuje ci¹g znaków o okreœlonej d³ugoœci.
VARCHAR												Reprezentuje ci¹g znaków o zmiennej d³ugoœci.
NCHAR, NVARCHAR										Reprezentuje ci¹g znaków o zmiennej d³ugoœci 
													zakodowanych w UNICODE.


Typy binarne 
BINARY												Reprezentuje ci¹g bitów o okreœlonej d³ugoœci.
VARBINARY											Reprezentuje ci¹g bitów o zmiennej d³ugoœci.
BLOB												Reprezentuje du¿e obiekty binarne.

Dokumenty XML										 XML Reprezentuje ca³e dokumenty XML.



Wartoœæ specjalna NULL nie jest równa jakiejkolwiek innej wartoœci ani od niej ró¿na.

Dwie wartoœci NULL nie s¹ ani sobie równe, ani ró¿ne od siebie. Wartoœæ NULL
nie jest te¿ równa jakiejkolwiek innej wartoœci ani mniejsza czy wiêksza
od niej.

Wynikiem wszystkich operacji zawieraj¹cych NULL jest wartoœæ NULL ( lub UNKNOWN) .

Wartoœæ NULL jest ignorowana przez wszystkie funkcje grupuj¹ce z wyj¹tkiem
funkcji COUNT(*).

W pe³ni kwalifikowana nazwa obiektu ma
postaæ nazwa serwera.nazwa bazy danych.nazwa schematu.nazwa obiektu, przy czym:

1. Opcjonalna nazwa serwera wskazuje serwer bazodanowy. Je¿eli jej nie podamy,
instrukcja zostanie wykonana przez serwer, z którym jesteœmy po³¹czeni.

2. Opcjonalna nazwa bazy danych wskazuje nazwê bazy danych, w której znajduje
siê ¿¹dany obiekt. Je¿eli nie zostanie ona podana, serwer za³o¿y, ¿e obiekt
znajduje siê w bie¿¹cej bazie danych. 

3. Opcjonalna nazwa schematu wskazuje schemat (przestrzeñ nazwy grupuj¹c¹
powi¹zane ze sob¹ obiekty), w którym znajduje siê ¿¹dana tabela. Gdybyœmy
j¹ pominêli, serwer bazodanowy za³o¿y³by, ¿e obiekt o podanej nazwie znajduje
siê w domyœlnym schemacie u¿ytkownika wykonuj¹cego dan¹ instrukcjê.

4. Obowi¹zkowa nazwa obiektu wskazuje obiekt, do którego chcemy siê odwo³aæ,
w naszym przypadku tabelê Klienci.

Wybranie niektórych kolumn tabeli nazywa siê selekcj¹ pionow¹, rzutem lub projekcj¹
tabeli. Wynikiem projekcji jest tabela o liczbie kolumn mniejszej ni¿ liczba kolumn
odczytywanej tabeli.

Odradza sie u¿ywanie symbolu * — stosuj¹c go, nara¿amy siê na otrzymanie
b³êdnych, innych, ni¿ siê spodziewaliœmy, wyników oraz stosowanie symbolu
* mo¿e znacznie wyd³u¿yæ czas wykonywania zapytania.	
SELECT * FROM [SalesLT].[ProductCategory];

S³owo kluczowe DISTINCT eliminuje z wyniku zapytania powtórzone wiersze, a nie
powtórzone wartoœci wybranych kolumn.

W SQL mo¿emy u¿ywaæ operatorów arytmetycznych : + - *  / %. Pierwsze dwa maj¹ ni¿szy priorytet od pozosta³ych. 
One z kolei s¹ na równi. 

U¿ywaj¹c zapytania mo¿emy oczekiwaæ kolumny bêd¹cej np iloczynem innych dwóch kolumn. 
SELECT NAME, PRICE, WEIGHT , PRICE * WEIGHT FROM TABLE1;

Mo¿emy dokonywaæ konkatenacji ³¹cz¹c za pomoc¹ znaku + wartoœci z kolumn, np : 
SELECT NAME, COLOR + SERIALNUMBER FROM TABLE1; 
Lub za pomoc¹ funkcji CONCAT(). 
SELECT NAME , CONCAT(COLOR , SERIALNUMBER) FROM TABLE1 ;	

Najpopularniejsze funkcje : 
ABS() , CEILING() , FLOOR() , POWER(X,Y) , RAND() , ROUND(X, PRZYBLI¯ENIE) , SQRT();
LEN(TEKST), LOWER(), LTRIM() - usuwa spacje ,  REPLACE ( tekst, what , with what), REPLICATE(TXT, N), RTRIM(),
SUBSTRING(TXT, FROM, HOW MANY SYMBOLS) , UPPER(). 
DATEADD( DAY, 20, '20071228'), DATEDIFF(HOUR, '20071231', '20150412'), DAY(GETDATE()), MONTH(), YEAR().

Typy Liczbowe maj¹ wy¿szy priorytet ni¿ znakowe! 
SELECT '1'+1+'1', '1'+'1'+1;	zwróci 3 i 12 . 

Jawn¹ konwersjê typów umo¿liwiaj¹ funkcje CAST(wyra¿enie AS typ) oraz CONVERT
(typ, wyra¿enie).
SELECT [ProductNumber] + [ListPrice] FROM [SalesLT].[Product];	zwróci b³¹d gdy¿ pierwwsza koluna zawiera typy 
znakowe a druga liczby i serwer próbuje je do siebie dodaæ a nie skonkatenowaæ. 
Rozwi¹zanie : SELECT [ProductNumber] + CAST([ListPrice] AS VARCHAR(15)) FROM [SalesLT].[Product];

Funkcja CASE jest SQL-owym odpowiednikiem instrukcji warunkowej IF … THEN … ELSE.
SELECT [ListPrice],
CASE
WHEN [ListPrice] <10 THEN 'Tani'
WHEN [ListPrice] <50 THEN 'Œrednia pó³ka'
ELSE 'Drogi'
END
FROM [SalesLT].[Product];

Bardzo u¿yteczn¹ rzecz¹ w SQL s¹ aliasy pozwalaj¹ce w zakresie zapytania zmieniæ nazw kolumny. 
SELECT [Name] AS [Nazwa Produktu], [ListPrice] - [StandardCost] AS Zysk FROM [SalesLT].[Product];

Kolumna wyliczeniowa - taka, która nie zosta³a bezpoœrednio odczytana z tabeli, tylko wyliczona w zapytaniu.

Poniewa¿ klauzula SELECT, choæ w zapytaniach wystêpuje jako pierwsza, jest wykonywana
jako jedna z ostatnich, zdefiniowanych w niej aliasów nie mo¿na u¿yæ w innych
klauzulach zapytania.

Aliasy tabel definiuje siê w ten sam sposób, ale w klauzuli FROM. Do zdefiniowanych
w klauzuli FROM aliasów mo¿na siê odwo³aæ w innych klauzulach zapytania. 
Jednak poniewa¿ klauzula FROM jest wykonywana w pierwszej kolejnoœci, po zdefiniowaniu
w niej aliasu dla tabeli w pozosta³ych klauzulach zapytania nie mo¿emy ju¿ u¿ywaæ
oryginalnej nazwy tabeli.

/////////////////////////LITERA£Y

SELECT 'Zamówienie ' + CAST([SalesOrderID] AS CHAR(5)) + ' zosta³o z³o¿one w roku '
+ CONVERT(CHAR(4),DATEPART(YEAR,[OrderDate])) FROM [SalesLT].[SalesOrderHeader];
Przyk³ad u¿ycia litera³ów w klauzuli SELECT.

Jako specjalny rodzaj sta³ych nale¿y te¿ traktowaæ wiêkszoœæ wywo³ywanych bez parametrów
i umieszczanych w klauzuli SELECT funkcji. Takie funkcje s¹ wywo³ywane raz
dla ca³ego zapytania, a nie dla ka¿dego wiersza jego wyniku, wiêc np dziêki RAND() w ka¿dym wierszu dostaniemy 
tê sam¹ liczbê pseudolosow¹. 

NEWID() - jedyna funkcja bêd¹ca wyj¹tkiem od tej regu³y. 

Kolejnoœæ wierszy wyniku zapytania jest niedeterministyczna i zale¿y od sposobu,
w jaki serwer bazodanowy w danej chwili wykona to zapytanie.

Kolejnoœæ klauzul instrukcji SELECT jest œciœle okreœlona, a opcjonalna klauzula
ORDER BY musi byæ ostatni¹ klauzul¹ zapytania.
W klauzuli ORDER BY umieszcza siê nazwy lub numery kolumn, wed³ug których chcemy
posortowaæ wynik zapytania.
SELECT [Name],[ListPrice]
FROM [SalesLT].[Product]
ORDER BY 2 DESC;

Wyniki zapytañ mog¹ byæ sortowane wed³ug wartoœci wielu kolumn.

Poszczególne klauzule zapytania s¹ od siebie niezale¿ne, co oznacza, ¿e w ka¿dej
z nich mo¿emy odwo³aæ siê do innych kolumn.

Powtórzone wiersze mog¹ byæ usuniête z wyniku za pomoc¹ s³owa kluczowego
DISTINCT, a wiêc wynik zapytania mo¿e liczyæ mniej wierszy ni¿ oryginalna tabela.
W takim przypadku sortowanie go wed³ug wartoœci nieistniej¹cej w nim kolumny jest
niemo¿liwe. Innymi s³owy, je¿eli w zapytaniu zosta³o u¿yte s³owo kluczowe DISTINCT,
wszystkie wymienione w klauzuli ORDER BY kolumny i wyra¿enia musz¹ wystêpowaæ
w klauzuli SELECT.

/////////////////////////////Sortowanie danych tekstowych
Dane tekstowe s¹ przechowywane i przetwarzane w postaci kodów — ka¿dej literze
alfabetu, cyfrze i znakowi specjalnemu odpowiada inna cyfra kodu. Serwery bazodanowe
u¿ywaj¹ dwóch rodzajów kodowania danych tekstowych:

1. W kodowaniu ANSII jeden znak jest zakodowany za pomoc¹ jednego bajta.
Ogranicza to liczbê mo¿liwych kodów do 256 . Poniewa¿
liczba stosowanych w ró¿nych jêzykach liter alfabetu jest znacznie
wiêksza, w kodowaniu ANSII stosuje siê strony kodowe.

2. W kodowaniu UNICODE jeden znak jest zakodowany za pomoc¹ dwóch bajtów.
Daje to 65 536 (2^16 = 65 536) ró¿nych kodów, co wystarcza do zapisania
wszystkich znaków diakrytycznych, a wtedy stosowanie stron kodowych jest
niepotrzebne.

Oprócz typu kodowania (i strony kodowej w przypadku kodowania ANSII) serwery
bazodanowe pozwalaj¹ te¿ okreœliæ sposób sortowania danych tekstowych. Z regu³y
mo¿emy zadecydowaæ:

1. Czy ci¹gi znaków maj¹ byæ sortowane wed³ug kodów (takie sortowanie
nazywa siê sortowaniem binarnym), czy w porz¹dku alfabetycznym.

2. Czy maj¹ byæ uwzglêdniane znaki diakrytyczne (w przypadku jêzyka polskiego:
czy litera ¹ ma byæ umieszczona pomiêdzy literami a i b, czy po z).

Sortowanie binarne wed³ug znaków polskiej strony kodowej. 

SELECT imie
FROM imiona
ORDER BY imie COLLATE Polish_BIN;

To klauzula FROM jest wykonywana jako pierwsza klauzula zapytania.Wynikiem zapytania jest tabela.

W klauzulach SELECT i ORDER BY mo¿na umieszczaæ wyra¿enia i wywo³ywaæ
funkcje systemowe, o ile tylko ich wynikami s¹ pojedyncze wartoœci.

///////////////////////////////////Logika trójwartoœciowa
Podstaw¹ u¿ywanej na co dzieñ klasycznej logiki s¹ trzy intuicyjnie uznawane za prawdziwe
zasady:
1. Zasada to¿samoœci, na mocy której a=a, czyli ka¿da rzecz jest równa samej sobie.
2. Zasada sprzecznoœci, na mocy której ~(a ^ ~a), czyli z dwóch sprzecznych zdañ
(predykatów) jedno jest prawdziwe2.
3. Zasada wy³¹czonego œrodka, na mocy której (a v ~a), czyli zdanie (predykat)
albo jest prawdziwe, albo fa³szywe.

W jêzyku SQL ¿adna z tych zasad nie stosuje siê do wartoœci NULL.

Wartoœæ NULL reprezentuje brakuj¹c¹ lub nieznan¹ wartoœæ, a wiêc w rzeczywistoœci
w ogóle nie jest wartoœci¹ ¿adnego typu.

Wartoœæ NULL nie jest równa samej sobie (wyj¹tkiem od tej regu³y jest opisana
klazula GROUP BY).
Ani wartoœæ NULL, ani jej negacja nie s¹ prawdziwe.
Wartoœæ NULL nie jest ani prawdziwa, ani fa³szywa.

W jêzyku
SQL warunek logiczny mo¿e mieæ trzeci¹ wartoœæ — wartoœæ UNKNOWN.

Operatory logiczne : AND , OR , NOT.
TRUE OR NULL = TRUE ; FALSE OR NULL = UNKNOWN; NULL OR NULL = UNKNOWN.
FALSE AND NULL = FALSE; TRUE AND NULL = UNKNOWN; 

Typowe zapytania ³¹cz¹ poznan¹ w poprzednim rozdziale projekcjê (wybieranie kolumn) z selekcj¹
(wybieraniem wierszy).

Opcjonalna klauzula WHERE musi wyst¹piæ bezpoœrednio po klauzuli FROM.

//////////////////////////////////////////////////OPERATORY PORÓWNANIA 
 = , <>,!= , < , > , <= , >=. 

Nazwy kolumn mog¹ byæ u¿yte w wyra¿eniach znajduj¹cych siê po obu stronach
operatorów porównania.
SELECT [ProductNumber], [StandardCost], [ListPrice]
FROM [SalesLT].[Product]
WHERE [StandardCost]*2<[ListPrice];

//////////////////////////////////////////////////Operatory SQL
Oprócz standardowych operatorów porównania w klauzuli WHERE mo¿emy u¿yæ specyficznych
dla jêzyka SQL operatorów IN, BETWEEN … AND, LIKE oraz IS NULL.

Operator IN pozwala sprawdziæ, czy szukana wartoœæ nale¿y do podanego zbioru, np.
czy wielkoœæ produktu wynosi 44, 48 lub 50:
SELECT [ProductNumber], [Size]
FROM [SalesLT].[Product]
WHERE [Size] IN ('44','48','50');

Operator BETWEEN … AND pozwala sprawdziæ, czy szukana wartoœæ nale¿y do okreœlonego
przedzia³u domkniêtego. Dziêki niemu mo¿emy np. poznaæ nazwy towarów o cenach
nie ni¿szych ni¿ 10 i nie wy¿szych ni¿ 20:
SELECT [ProductNumber], [ListPrice]
FROM [SalesLT].[Product]
WHERE [ListPrice] BETWEEN 10 AND 20;

Operator BETWEEN … AND mo¿e byæ te¿ u¿yty do sprawdzenia, czy dane tekstowe nale¿¹ do
podanego zakresu. W takim przypadku stosowany jest domyœlny, okreœlony na poziomie
kolumny, tabeli, bazy lub ca³ego serwera, porz¹dek sortowania. Poni¿sze zapytanie
zwraca nazwiska klientów zaczynaj¹ce siê na litery od B do D:
SELECT [LastName]
FROM [SalesLT].[Customer]
WHERE LEFT([LastName],1) BETWEEN 'B' AND 'D';

Za pomoc¹ operatora LIKE mo¿emy przeszukiwaæ dane tekstowe pod k¹tem ich zgodnoœci
z podanym wzorcem. Do tworzenia wzorca mo¿na u¿yæ dwóch symboli o specjalnym
znaczeniu:
1. Symbol % (procent) zastêpuje dowolny ci¹g znaków.
2. Symbol _ (podkreœlenie) zastêpuje jeden dowolny znak.
SELECT [ProductID], [Name]
FROM [SalesLT].[Product]
WHERE [Name] LIKE 'S%';

Apostrof oznacza ci¹g znaków, wiêc je¿eli chcemy wyszukaæ dane tekstowe zawieraj¹ce
apostrof, musimy poprzedziæ go dodatkowym apostrofem.

Chocia¿ nie mo¿emy porównywaæ wartoœci NULL z innymi wartoœciami, to mo¿emy
sprawdziæ, czy dana wartoœæ jest nieokreœlona. S³u¿y do tego operator IS NULL. Poni¿sze
zapytanie zwraca kody produktów, które nie maj¹ okreœlonej daty wycofania ze
sprzeda¿y:
SELECT [ProductNumber]
FROM [SalesLT].[Product]
WHERE [SellEndDate] IS NULL;

///////////////////////////////////////////////////Hierarchia operatorów
1. Jako pierwsze wykonywane s¹ operacje mno¿enia i dzielenia.
2. Nastêpnie — dodawania i odejmowania.
3. W trzeciej kolejnoœci wykonywane s¹ standardowe operacje porównania,
takie jak równy lub mniejszy ni¿.
4. Pierwszym wykonywanym operatorem logicznym jest operator NOT.
5. Nastêpnie wykonywany jest operator AND.
6. Jako ostatnie — operatory SQL (IN, BETWEEN … AND, LIKE) oraz operator OR.
Je¿eli wyra¿enie zawiera kilka operatorów o tym samym priorytecie, s¹ one wykonywane
od lewej do prawej.

/////////////////////////////////////////TOP
 Opcjonalna klauzula TOP pozwala ograniczyæ wynik zapytania do podanej w niej liczby
wierszy. Docelowa liczba wierszy mo¿e byæ okreœlona bezwzglêdnie lub procentowo.
Je¿eli wystêpuje w zapytaniu, klauzula TOP musi siê znaleŸæ bezpoœrednio po instrukcji
SELECT, a przed nazwami zwracanych przez zapytanie kolumn.
Kolejnoœæ wierszy wyniku zapytania mo¿emy okreœliæ tylko za pomoc¹ klauzuli ORDER
BY; bez niej klauzula TOP jest niedeterministyczna i praktycznie bezu¿yteczna.

Natomiast aby dodaæ do wyniku dodatkowe, zawieraj¹ce powtórzenia wiersze, nale¿y
u¿yæ rozszerzonej sk³adni TOP … WITH TIES (rozszerzona sk³adnia klauzuli TOP wymaga
u¿ycia klauzuli ORDER BY, bez niej serwer bazodanowy zg³osi b³¹d sk³adni):
SELECT TOP 3 WITH TIES [Name], [ListPrice]
FROM [SalesLT].[Product]
ORDER BY [ListPrice] DESC;

Mo¿emy równie¿ okreœliæ, jaki procent wierszy odczytywanej tabeli ma zwróciæ zapytanie.
Kolejny przyk³ad pokazuje, jak odczytaæ dane o 5% najdro¿szych produktów:
SELECT TOP 5 PERCENT WITH TIES [Name], [ListPrice]
FROM [SalesLT].[Product]
ORDER BY [ListPrice] DESC;

Argumentem klauzuli TOP mog¹ byæ nie tylko sta³e, lecz tak¿e zmienne i wyra¿enia.

//////////////////////////////////////////////////////////////Stronicowanie wierszy
Mo¿liwoœæ wybierania wierszy na podstawie ich kolejnoœci pozwala równie¿ je stronicowaæ,
czyli ograniczaæ wynik zapytania do wierszy o okreœlonych numerach.
W serwerze SQL klauzule OFFSET (w której okreœla siê liczbê wczeœniejszych, przeznaczonych
do pominiêcia wierszy) oraz FETCH NEXT (w której okreœla siê liczbê zwracanych
wierszy) umieszcza siê (co jest zgodne ze standardem ANSI jêzyka SQL) za klauzul¹
ORDER BY.
SELECT [Name], [ProductModelID]
FROM [SalesLT].[Product]
ORDER BY [ProductModelID]
OFFSET 15 ROWS
FETCH NEXT 5 ROWS ONLY;	// OPUSC 15 WIERSZY I WYPISZ 5 . 

Technika ta nazywa siê stronicowaniem, bo pozwala zwracaæ jedynie podzbiór wierszy
wyniku, który ma byæ wyœwietlony w danym momencie przez program kliencki.

DECLARE @Strona tinyint = 5	, @Bie¿¹ca tinyint = 2;
SELECT [Name], [ProductModelID]
FROM [SalesLT].[Product]
ORDER BY [ProductModelID] OFFSET (@Strona * (@Bie¿¹ca - 1)) ROWS FETCH NEXT @Strona ROWS ONLY;

Operatory SQL IN oraz BETWEEN … AND pozwalaj¹ uproœciæ warunki logiczne
i poprawiaj¹ czytelnoœæ zapytañ, nie wp³ywaj¹c w ¿aden sposób na ich wydajnoœæ.

/////////////////////////////////////////////£¥CZENIE TABEL.
 * SELECT C.Name,P.Name
FROM [SalesLT].[ProductCategory] AS C
JOIN [SalesLT].[Product] AS P				//FROM TABLE1 AS ... JOIN TABLE2 AS ... ON COL1 = COL2.
ON P.ProductCategoryID=C.ProductCategoryID;	//KOLUMNY KLUCZA PODSTAWOWEGO I OBCEGO.

1. W klauzuli SELECT nazwy kolumn zosta³y poprzedzone aliasami nazw tabel.
W innym wypadku próba wykonania zapytania mog³aby siê skoñczyæ b³êdem.

2. W klauzuli FROM pojawi³ siê nowy operator JOIN … ON. Pozwala on na:
a) wymienienie nazw wszystkich odczytywanych tabel;
b) okreœlenie warunków ich ³¹czenia. W tym przypadku do wyniku zapytania
trafi¹ tylko te wiersze z obu tabel, w których wartoœci kolumny
ProductCategoryID s¹ takie same.

Dzia³anie operatora JOIN … ON polega na wygenerowaniu wszystkich mo¿liwych
kombinacji wierszy ³¹czonych tabel, a nastêpnie usuniêciu z tak otrzymanego zbioru
poœredniego wierszy niespe³niaj¹cych warunku z³¹czenia.

Chocia¿ mo¿na operator JOIN … ON zast¹piæ warunkiem WHERE,
to rozwi¹zanie takie ma jednak kilka wad:
1. Jest niezgodne ze standardem jêzyka SQL.
2. Pogarsza czytelnoœæ zapytañ, szczególnie tych z rozbudowan¹ klauzul¹ WHERE.
3. W z³¹czeniach zewnêtrznych mo¿e byæ przyczyn¹ trudnych do wykrycia b³êdów
logicznych.

Z³¹czenie tabel na podstawie wartoœci kolumn klucza podstawowego i klucza obcego
nazywa siê z³¹czeniem naturalnym.

Jêzyk SQL pozwala te¿ na z³¹czenie tabel na podstawie wartoœci niekluczowych
kolumn. Poniewa¿ wynik takiego z³¹czenia nie odzwierciedla naturalnego po³¹czenia
danych, nazywa siê je z³¹czeniem nienaturalnym.

Im bardziej znormalizowana baza danych, tym mniej zawiera duplikatów danych i tym
rzadziej u¿ywane s¹ w niej z³¹czenia nienaturalne.

Z³¹czenia nienaturalne, jako odwo³uj¹ce siê do kolumn, które mog¹ zawieraæ powtarzaj¹ce siê wartoœci,
s¹ niejednoznaczne. W skrajnym przypadku taki warunek z³¹czenia nie wyeliminuje
z wyniku zapytania ¿adnych wierszy. I tak powy¿sze z³¹czenie licz¹cej
847 wierszy tabeli [SalesLT].[Customer] z zawieraj¹c¹ 450 wierszy tabel¹ [SalesLT].
[Address] zwróci³o a¿ 36 864 rekordy.

Odwo³uj¹c siê do wiêcej ni¿ jednej tabeli, powinniœmy nadawaæ aliasy wszystkim tabelom
i konsekwentnie u¿ywaæ ich w ca³ym zapytaniu:
W klauzuli ON równie¿ nie mo¿emy pos³u¿yæ siê oryginalnymi nazwami tabel,
dla których zdefiniowane zosta³y aliasy.

Wyniki zapytañ ze z³¹czeniem równoœciowym zawieraj¹
te wiersze z³¹czonych tabel, w których wartoœci u¿ytych do z³¹czenia kolumn s¹
takie same.

Tabele mog¹ byæ te¿ ³¹czone na podstawie warunków z³¹czeñ zawieraj¹cych inne
operatory porównania ni¿ =, np. operator > — takie z³¹czenia nazywane s¹ nierównoœciowymi.

Chocia¿ wydaje siê, ¿e poni¿sze zapytanie zwraca informacje o produktach
sprzedanych za cenê ni¿sz¹ ni¿ wartoœæ zamówienia, to w rzeczywistoœci zwraca
ono po³¹czone ze sob¹ w trybie ka¿dy z ka¿dym, spe³niaj¹ce ten warunek wiersze obu
tabel:
SELECT H.SalesOrderID, H.SalesOrderNumber, D.LineTotal, H.SubTotal
FROM [SalesLT].[SalesOrderHeader] AS H
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.LineTotal<H.SubTotal;

Z³¹czenia nierównoœciowe s¹ bardzo rzadko u¿ywane — jednym z ich nielicznych zastosowañ
jest analiza danych polegaj¹ca na wyszukiwaniu istniej¹cych miêdzy tymi danymi
zale¿noœci.Poniewa¿ wyniki takich z³¹czeñ zawieraj¹ mnóstwo powtórzonych wierszy,
z³¹czenia nierównoœciowe z regu³y wystêpuj¹ razem ze z³¹czeniami naturalnymi:
SELECT H.SalesOrderID, H.SalesOrderNumber, D.LineTotal, H.SubTotal
FROM [SalesLT].[SalesOrderHeader] AS H
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.SalesOrderID=H.SalesOrderID
AND D.LineTotal<H.SubTotal;
///////////////////////////////////////////////////Z£AÆZENIA ZEWNÊRZNE
 
SELECT ProductNumber, C.Name
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON C.ProductCategoryID=P.ProductCategoryID
WHERE P.Color = 'WHITE';
Poniewa¿ klauzula ON równie¿ filtruje wiersze (¿eby produkt trafi³ do wyniku zapytania,
w tabeli [SalesLT].[ProductCategory] musi istnieæ powi¹zany z nim rekord), zapytanie
to nie zwraca wszystkich bia³ych produktów.


Wszystkie omówione do tej pory z³¹czenia by³y z³¹czeniami wewnêtrznymi — ich
wyniki zawiera³y tylko wiersze spe³niaj¹ce podany w nich warunek z³¹czenia.

Z³¹czenie zewnêtrzne, czyli takie, które zwróci równie¿ niepasuj¹ce (tj. niemaj¹ce odpowiednika w powi¹zanej
tabeli) wiersze.

Lewostronne z³¹czenie zewnêtrzne (LEFT OUTER JOIN) powoduje pozostawienie w wyniku
niepasuj¹cych wierszy z pierwszej (lewej) tabeli. Poniewa¿ te wiersze nie maj¹ swoich
odpowiedników w z³¹czonej tabeli, w kolumnach wyniku zwracaj¹cego dane z drugiej
(prawej) tabeli zostanie wstawiona wartoœæ NULL.
Tym razem wynik zapytania zawiera numery wszystkich produktów, w tym nienale¿¹cego
do jakiejkolwiek kategorii.

Tak jak lewostronne z³¹czenie zewnêtrzne dodaje do wyniku zapytania niepasuj¹ce
wiersze z tabeli, której nazwa jest podana jako pierwsza, tak prawostronne z³¹czenie
zewnêtrzne (RIGHT OUTER JOIN) dodaje niepasuj¹ce wiersze z prawej tabeli. Czyli
zmieniaj¹c kolejnoœæ tabel w klauzuli FROM, mo¿emy zast¹piæ z³¹czenie lewostronne
równowa¿nym z³¹czeniem prawostronnym.

Obustronne z³¹czenia zewnêtrzne (FULL OUTER JOIN) zwracaj¹ wszystkie wiersze obu
z³¹czonych tabel, w tym te, które nie spe³niaj¹ warunku z³¹czenia.

Z³¹czenie krzy¿owe
(iloczyn kartezjañski)

Poniewa¿ przy z³¹czeniu krzy¿owym nie okreœla siê warunku z³¹czenia (bo wynik ma
zawieraæ wszystkie mo¿liwe po³¹czenia wierszy), mo¿emy w ten sposób z³¹czyæ dowolne
dwie tabele:
SELECT P.Name, C.FirstName
FROM [SalesLT].[Product] AS P
CROSS JOIN [SalesLT].[Customer] AS C;

Wynik z³¹czenia krzy¿owego zawiera mnóstwo powtórzeñ — imiê ka¿dego klienta
zosta³o powtórzone 296 razy (tyle wierszy liczy³a tabela [SalesLT].[Product]), a nazwa
ka¿dego towaru 847 razy (tylu jest klientów). W rezultacie zapytanie to zwróci³o
250 712 (296 * 847 = 250 712) wierszy.

Poniewa¿
tak otrzymane dane s¹ w wiêkszoœci wynikiem przypadkowego po³¹czenia wierszy,
z³¹czenia krzy¿owe s¹ u¿ywane przede wszystkim do:
1. Generowania danych testowych. Wynik poni¿szego zapytania zawiera
250 tysiêcy kombinacji kodów (zwróæ uwagê, ¿e s³owo kluczowe CROSS JOIN
mo¿e byæ pominiête):
SELECT [ProductNumber], C.[rowguid]
FROM [SalesLT].[Product], [SalesLT].[Customer] AS;

2. Poprawy wydajnoœci podzapytañ zawieraj¹cych kilka funkcji grupuj¹cych.

/////////////////////////////////////////////////////////Z³¹czenia wielokrotne 

W jednym zapytaniu mo¿emy siê odwo³aæ do wiêcej ni¿ dwóch tabel.
Niezale¿nie od tego, do ilu tabel siê odwo³ujemy, serwery bazodanowe zawsze ³¹cz¹
ze sob¹ dwie tabele.
SELECT C.LastName, P.Name
FROM [SalesLT].[Customer] AS C
JOIN [SalesLT].[SalesOrderHeader] AS H
ON C.CustomerID=H.CustomerID
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.SalesOrderID=H.SalesOrderID
JOIN [SalesLT].[Product] AS P
ON D.ProductID=P.ProductID
ORDER BY C.LastName;

W z³¹czeniach równoœciowych kolejnoœæ ³¹czenia tabel nie ma ¿adnego wp³ywu na
wynik zapytania.Natomiast w przypadku z³¹czeñ zewnêtrznych klauzula ON wykonywana
po dodaniu niepasuj¹cych wierszy z powrotem usuwa je z wyniku.

SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.ProductID=P.ProductID
JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID;

Kolejnoœæ wykonywania operacji ³¹czenia jest ustalana przez optymalizator i nie wynika
z kolejnoœci, w jakiej nazwy tabel zosta³y wymienione w klauzuli FROM. Wynik tego
zapytania nie zawiera wiêc informacji o niesprzedanych produktach, które pocz¹tkowo
dodane zosta³y z niego usuniête w trakcie wykonywania drugiej klauzuli ON.

Problem ten mo¿na rozwi¹zaæ na dwa sposoby:
1. £¹cz¹c zewnêtrznie wszystkie tabele. Wad¹ tego rozwi¹zania jest to, ¿e gdyby
w kolejnych tabelach (w tym przypadku w tabeli [SalesLT].[SalesOrderHeader)
równie¿ znajdowa³y siê wiersze niepasuj¹ce do wierszy z ostatniej ³¹czonej
tabeli, one tak¿e znalaz³yby siê w wyniku zapytania:
SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.ProductID=P.ProductID
LEFT JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID;

2. Okreœlaj¹c za pomoc¹ nawiasów kolejnoœæ, w jakiej tabele powinny byæ
po³¹czone. Je¿eli z³¹czenie zewnêtrzne bêdzie wykonane jako ostatnie
(co wymaga przeniesienia okreœlaj¹cej warunek tego z³¹czenia klauzuli ON
poza nawias), niepasuj¹cy wiersz znajdzie siê w wyniku zapytania:
SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN
(
[SalesLT].[SalesOrderDetail] AS D
JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID
)
ON D.ProductID=P.ProductID;

/////////////////////////////////////////////////Z³¹czenie tabeli z ni¹ sam¹
Z³¹czenie tabeli z ni¹ sam¹ jest wykonywane w taki sam sposób jak omawiane
do tej pory z³¹czenia ró¿nych tabel. Chocia¿ serwery bazodanowe nie tworz¹ kopii
z³¹czonej tabeli, to wszystkie operacje przeprowadzane s¹ tak, jakby dotyczy³y dwóch
identycznych tabel.

SELECT P1.ProductNumber // Musi znalezc sie tu poprzedzona nazwa tabeli a raczej aliasu nazwa kolumny . 
FROM [SalesLT].[Product] AS P1	// Nadajemy aliasy tabeli i jej kopii. 
CROSS JOIN [SalesLT].[Product] AS P2;

Z³¹czenia tabel z nimi samymi s¹ czêsto wykonywane w celu analizy danych. Na
przyk³ad poni¿sze zapytanie zwraca dane towarów, które s¹ co najmniej szeœciokrotnie
tañsze ni¿ jakikolwiek inny towar z tej samej kategorii:
SELECT P1.ProductID, P1.ListPrice, P2.ProductID, P2.ListPrice
FROM [SalesLT].[Product] AS P1
JOIN [SalesLT].[Product] AS P2
ON P1.ProductCategoryID=P2.ProductCategoryID
WHERE P1.ListPrice*6 <P2.ListPrice
ORDER BY P1.ProductID;

Skoro najczêstszym typem z³¹czeñ s¹ z³¹czenia naturalne, to tabela przewa¿nie jest
z³¹czana z ni¹ sam¹, je¿eli w jej obrêbie wystêpuje relacja klucz podstawowy – klucz
obcy.

/////////////////////////////////////////////////£¹czenie wyników zapytañ
Oprócz tabel jêzyk SQL pozwala równie¿ ³¹czyæ wyniki zapytañ. O ile ³¹czenie tabel
polega na dodawaniu do wyniku zapytania dodatkowych, pochodz¹cych ze z³¹czonych
tabel kolumn, o tyle ³¹czenie wyników polega na dodawaniu (lub usuwaniu) wierszy
zwróconych przez z³¹czone zapytania.

£¹czone wyniki zapytañ musz¹ siê sk³adaæ z tej samej liczby kolumn, a odpowiadaj¹ce
sobie kolumny musz¹ byæ tych samych albo umo¿liwiaj¹cych niejawn¹ konwersjê
typów.

Dodaæ do siebie wyniki zapytañ mo¿emy za pomoc¹ operatora UNION.
SELECT [Name]
FROM [SalesLT].[Product]
UNION
SELECT [Name]
FROM [SalesLT].[ProductCategory];	// Srednik po ostatnim zapytaniu !
ORDER BY 1;

Klauzula ORDER BY moze wystapic tylko w ostatnim zapytaniu . 

Operator UNION powoduje usuniêcie z wyniku powtórzonych wierszy!

Jako ¿e nazwy kolumn z³¹czonych wyników zapytañ nie musz¹ byæ takie same, w klauzuli
ORDER BY najczêœciej u¿ywa siê ich numerów, a nie nazw.

Je¿eli chcemy tylko z³¹czyæ ze sob¹ wyniki zapytañ, bez eliminowania ewentualnych
duplikatów, albo je¿eli mamy pewnoœæ, ¿e ³¹czone wyniki s¹ roz³¹czne6, powinniœmy
u¿yæ operatora UNION ALL — takie ³¹czenie wyników zapytañ, jako niewymagaj¹ce
wyszukiwania i usuwania powtarzaj¹cych siê wierszy, jest znacznie szybsze.

Operator INTERSECT zwraca czêœæ wspóln¹ wyników dwóch zapytañ, a wiêc tylko te
wiersze, które zosta³y zwrócone przez oba zapytania.
SELECT [AddressID]
FROM [SalesLT].[Address]
INTERSECT
SELECT [CustomerID]
FROM [SalesLT].[Customer];

Chocia¿ standard SQL3 uwzglêdnia operatory INTERSECT ALL i EXCEPT ALL, to jednak
¿aden serwer bazodanowy ich nie implementuje. Spowodowane jest to tym, ¿e
usuwanie wierszy na podstawie nie pojedynczego ich wyst¹pienia, ale wielokrotnego
powtórzenia jest ma³o intuicyjne i prowadzi do b³êdów logicznych.

Operator EXCEPT zwraca te wiersze, które znalaz³y siê wy³¹cznie w wyniku pierwszego
zapytania i nie by³o ich w wyniku drugiego zapytania.

SELECT [AddressID]
FROM [SalesLT].[Address]
EXCEPT
SELECT [CustomerID]
FROM [SalesLT].[Customer];

W przeciwieñstwie do sumy i opisanej powy¿ej czêœci wspólnej operator EXCEPT jest
asymetryczny — zmiana kolejnoœci zapytañ spowoduje zmianê wyniku.

Zapytania nie musz¹ odczytywaæ danych bezpoœrednio z tabel — w wielu produkcyjnych
bazach danych bezpoœredni dostêp do tabel jest wrêcz niemo¿liwy (ze
wzglêdów bezpieczeñstwa i dla poprawy wydajnoœci zapytañ), a u¿ytkownicy odczytuj¹
i modyfikuj¹ dane za poœrednictwem widoków, procedur lub funkcji.

Funkcje tabelaryczne zwracaj¹ dane w postaci tabel, dlatego mo¿emy je wywo³aæ w klauzuli FROM . 

G³ówna ró¿nica miêdzy odczytywaniem danych poprzez widok a odczytywaniem
ich poprzez funkcjê tabelaryczn¹ polega na tym, ¿e widoku nie mo¿na wywo³aæ
z parametrami.
SELECT *
FROM [dbo].[ufnGetCustomerInformation](1);		// funkcja tabelaryczna . 

SELECT *
FROM [SalesLT].[vGetAllCategories];				// Widok.

Operator APPLY umo¿liwia wywo³anie dla ka¿dego wiersza pierwszej (lewej) tabeli
dowolnego wyra¿enia zwracaj¹cego dane w postaci tabelarycznej, np. podzapytania
albo funkcji tabelarycznej.

SELECT C.[CustomerID], F.*
FROM [SalesLT].[Customer] AS C
CROSS APPLY [dbo].[ufnGetCustomerInformation](C.[CustomerID]) AS F
WHERE C.Title = 'Ms.';

Operator CROSS APPLY odpowiada z³¹czeniu wewnêtrznemu, a wiêc eliminuje z wyniku
zapytania te wiersze, dla których funkcja zwróci³a wartoœci NULL.

Jêzyk SQL pozwala jednak na do³¹czenie do wyniku zapytania tych wierszy, dla których funkcja tabelaryczna
zwróci³a wartoœæ NULL, a wiêc uzyskanie efektu podobnego do z³¹czenia zewnêtrznego.
W tym celu operator CROSS APPLY nale¿y zast¹piæ operatorem OUTER APPLY:

SELECT C.FirstName, C.[CustomerID], F.*
FROM [SalesLT].[Customer] AS C
OUTER APPLY [dbo].[udfLastOrders](C.[CustomerID],2) AS F;

////////////////////////////////////////Funkcje grupuj¹ce
Grupowanie danych polega na ³¹czeniu wielu wierszy w jeden.
Charakterystyczn¹ cech¹ funkcji grupuj¹cych jest operowanie na zbiorach, a nie
pojedynczych wartoœciach. Funkcje grupuj¹ce zwracaj¹ pojedyncze (skalarne)
wartoœci, wiêc wywo³uje siê je w klauzuli SELECT, tak jak wczeœniej poznane funkcje
systemowe.

Funkcja COUNT() zwraca liczbê przekazanych jako argument wywo³ania wartoœci. U¿ywa
siê jej do sprawdzenia liczebnoœci grupy lub policzenia wierszy tabeli.
Domyœlnie funkcje grupuj¹ce s¹ wywo³ywane dla wszystkich wartoœci w grupie
z wyj¹tkiem wartoœci NULL.

SELECT COUNT(DISTINCT CustomerID)	// Dostaniemy rozne id konsumentow .Piszac DISTINCT COUNT()... dostaniemy rozne wyniki zliczenia , a w zasadzie jeden - 33.
FROM [SalesLT].[SalesOrderHeader];
Funkcje grupuj¹ce mog¹ byæ te¿ wywo³ywane tylko dla wartoœci niepowtarzaj¹cych
siê w grupie.

Funkcja COUNT() mo¿e byæ wywo³ana z * jako argumentem — zwraca wtedy liczbê
wierszy tabeli lub grupy.Wyj¹tkowoœæ sk³adni COUNT(*) polega na tym, ¿e zliczane s¹ nie tylko duplikaty
wierszy, lecz tak¿e puste wiersze, czyli funkcja COUNT() wywo³ana z * jako jedyna
funkcja grupuj¹ca uwzglêdnia wartoœæ NULL. Z tego powodu symbolu * nie mo¿na poprzedziæ
s³owem kluczowym DISTINCT. 

Funkcje SUM() i AVG()
Argumentami funkcji SUM() i AVG() mog¹ byæ tylko liczby,funkcje te ignoruj¹ wartoœæ NULL.
SELECT SUM([ListPrice]), AVG([ListPrice])
FROM [SalesLT].[Product];

Funkcje MIN() i MAX()
Argumentami funkcji MIN() i MAX() mog¹ byæ oprócz danych liczbowych dane daty
i czasu oraz tekstowe.

CHECKSUM_AGG(), której argumentem musz¹ byæ liczby ca³kowite,
zwraca sumê kontroln¹ wartoœci w grupie (ta funkcja jest u¿ywana g³ównie
do porównywania grup, np. sprawdzenia, czy nie zmieni³y siê ceny produktów):
SELECT CHECKSUM_AGG([SalesOrderID]), CHECKSUM_AGG(CAST([UnitPrice] AS INT))
FROM [SalesLT].[SalesOrderDetail];

COUNT_BIG() od funkcji COUNT() ró¿ni siê tylko typem zwracanych
wartoœci — w jej przypadku liczba wierszy w grupie jest zwracana jako dane
typu BIGINT.

STDEV() zwraca odchylenie standardowe wartoœci w grupie.

VAR() zwraca wariancjê wartoœci w grupie.

Funkcje grupuj¹ce mog¹ byæ czêœci¹ dowolnych wyra¿eñ,
o ile tylko te wyra¿enia s¹ poprawne sk³adniowo:
SELECT MAX([ListPrice]) - MIN( [ListPrice]),
MAX([ListPrice]) - AVG( [ListPrice])
FROM [SalesLT].[Product];

Argumentami funkcji grupuj¹cych równie¿ mog¹ byæ wyra¿enia. Na przyk³ad mo¿emy
policzyæ œredni¹ z cen brutto produktów (cen pomno¿onych przez 1,23):
SELECT AVG([ListPrice]*1.23)
FROM [SalesLT].[Product];

Zagnie¿d¿anie funkcji grupuj¹cych
Standard SQL3 nie zezwala na zagnie¿d¿anie funkcji grupuj¹cych, tak wiêc argumentem
funkcji grupuj¹cej nie mo¿e byæ wynik innej funkcji grupuj¹cej:
SELECT AVG(SUM([ListPrice]))
FROM [SalesLT].[Product];

Funkcje grupuj¹ce mog¹ byæ wywo³ywane dla okreœlonych grup, a nie tylko dla ca³ych
tabel. Podzia³ wierszy na logiczne grupy umo¿liwia w³aœnie klauzula GROUP BY.

Na przyk³ad ¿eby odczytaæ œredni¹ cenê i liczbê towarów nale¿¹cych do poszczególnych
kategorii, nale¿y pogrupowaæ wiersze na podstawie identyfikatora lub nazwy
kategorii i wyliczyæ œredni¹ dla ka¿dej grupy.
SELECT AVG([ListPrice]) AS Œrednia,
COUNT([ProductID]) AS Liczba
FROM [SalesLT].[Product]
GROUP BY [ProductCategoryID];

Je¿eli zapytanie zawiera klauzulê GROUP BY,
w klauzuli SELECT dopuszczalne s¹ wy³¹cznie funkcje grupuj¹ce oraz nazwy kolumn
lub wyra¿enia u¿yte do pogrupowania danych, czyli wystêpuj¹ce w klauzuli GROUP BY.
SELECT [ProductCategoryID],AVG([ListPrice]), [Name]
FROM [SalesLT].[Product]
GROUP BY [ProductCategoryID]; 	// nie zadzia³a . 


SELECT LEFT([Color],1), COUNT(*)	// Wypisze tylko pierwsze litery kolorow i wzgledem tych pierwszych liter odbedzie sie grupowanie .
FROM [SalesLT].[Product]
GROUP BY LEFT([Color],1);

Klauzula GROUP BY umo¿liwia równie¿ tworzenie podgrup. Przypuœæmy, ¿e chcemy
poznaæ liczbê oraz œredni¹ cenê produktów z poszczególnych kategorii z rozbiciem na
kolory tych produktów. W tym celu musimy w klauzuli GROUP BY umieœciæ nazwê dodatkowej
kolumny:
SELECT C.Name, P.Color, COUNT(*) AS Liczba, AVG(ListPrice) AS Œrednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY C.Name, P.Color
ORDER BY C.Name;

Kolejnoœæ wykonywania klauzuli
1. Jako pierwsza wykonywana jest klauzula FROM. Je¿eli zapytanie odwo³uje siê
do wielu tabel, s¹ one kolejno ze sob¹ z³¹czane.
2. Otrzymany w ten sposób zbiór poœredni jest filtrowany na podstawie warunku
logicznego umieszczonego w klauzuli WHERE. Tylko te wiersze, dla których jest
on prawdziwy, trafiaj¹ do kolejnego zbioru poœredniego.
3. Nastêpnie wykonywana jest klauzula GROUP BY, czyli grupowane s¹ tylko
przefiltrowane wiersze.
4. Po zgrupowaniu wykonywana jest klauzula SELECT.
5. W dalszej kolejnoœci serwer sortuje wiersze, czyli wykonywana jest
klauzula ORDER BY.
6. Na koñcu, podczas wykonywania klauzuli TOP, liczba wierszy wyniku
zapytania zostaje ograniczona.

!W klauzuli WHERE nie mo¿na umieœciæ funkcji grupuj¹cych
gdy¿ podczas wykonywania tej klauzuli dane nie s¹ jeszcze pogrupowane.
!Wiersze wyeliminowane w klauzuli WHERE nie zostan¹ pogrupowane . 
!Dane s¹ najpierw grupowane, a potem sortowane, czyli w klauzuli
ORDER BY mo¿emy umieœciæ tylko kolumny lub wyra¿enia u¿yte do grupowania
b¹dŸ funkcje grupuj¹ce.

Operatory CUBE i ROLLUP maj¹ ograniczon¹ funkcjonalnoœæ — te same rezultaty,
ale szybciej i z pe³n¹ mo¿liwoœci¹ kontrolowania tworzonych podsumowañ oferuje
operator GROUPING SETS. Z tych powodów operatory CUBE i ROLLUP nie powinny byæ
u¿ywane w nowych aplikacjach.

Mo¿emy dodaæ do wyniku zapytania sumy poœrednie — s³u¿y do tego operator ROLLUP.
Operator ROLLUP doda³ podsumowania dla grup utworzonych na podstawie wartoœci
pierwszej z kolumn wymienionych w klauzuli GROUP BY. Dodane przez niego wiersze
zawieraj¹ wartoœci NULL w kolumnach u¿ytych do grupowania, natomiast w ostatniej
kolumnie tych wierszy znajdziemy sumy poœrednie : 

SELECT C.Name, P.Color, COUNT(*) AS Liczba, SUM(ListPrice) AS Œrednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY ROLLUP (C.Name, P.Color)
ORDER BY C.Name;
------------------------------------------------------------
Name 			Color 		Liczba 		Œrednia
Mountain Bikes 	Black 		16 			27404,84
Mountain Bikes 	Silver 		16			26462,84
Mountain Bikes 	NULL 		32 			53867,68
Mountain Frames Black 		14 			9391,99
Mountain Frames Silver 		14 			9599,11
Mountain Frames NULL 		28 			18991,10
Panniers 		Grey 		1 			125,00
Panniers 		NULL 		1 			125,00

Dziêki operatorowi CUBE mo¿emy unikn¹æ pisania wielu
wersji tego samego zapytania — jego dzia³anie polega bowiem na dodaniu do wyniku
zapytania podsumowañ dla wszystkich mo¿liwych kombinacji grup i podgrup:

SELECT C.Name, P.Color, COUNT(*) AS Liczba, SUM(ListPrice) AS Œrednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;
------------------------------------------------------------
Name Color Liczba Œrednia
NULL NULL 50 2750,12
NULL Black 89 67436,26
NULL Grey 1 125,00
NULL Multi 8 478,92
NULL Red 38 53274,10
NULL Yellow 36 34527,29
NULL NULL 295 219655,59
NULL Blue 26 24015,66
NULL Silver 36 36563,13
NULL White 4 36,98

Dodatkowe dziesiêæ wierszy dodanych
przez operator CUBE zawiera sumy poœrednie policzone dla kolorów, np. drugi wiersz
zawiera liczbê i sumê cen wszystkich czarnych produktów, niezale¿nie od kategorii,
do jakiej one nale¿¹. Dodane przez operator CUBE wiersze z podsumowaniami mo¿na
rozpoznaæ po wartoœciach NULL wystêpuj¹cych w kolumnach, wed³ug których pogrupowane
zosta³y dane:
1. Wartoœæ NULL w kolumnie Color oznacza podsumowanie dla koloru.
2. Wartoœæ NULL w kolumnie Name — podsumowanie dla kategorii.
3. Wartoœæ NULL w obu u¿ytych do grupowania kolumnach oznacza podsumowanie
ca³ego zapytania.

Oznaczanie dodatkowych grup za pomoc¹ wartoœci NULL jest niejednoznaczne — gdyby
w u¿ytych do grupowania kolumnach wystêpowa³a wartoœæ nieokreœlona, wiersze z wartoœci¹
NULL by³yby nie do odró¿nienia od wierszy zawieraj¹cych sumy poœrednie.
Serwer SQL rozwi¹zuje ten problem za pomoc¹:
1. Funkcji GROUPING(), która zwraca 1, je¿eli dany wiersz zawiera podsumowania
dodane do wyniku przez operatory CUBE lub ROLLUP, i 0, je¿eli dany wiersz
zawiera wartoœci wyliczone dla danej grupy:

SELECT C.Name, GROUPING(C.Name) AS ByName,
P.Color, GROUPING(P.Color) AS ByColor,
AVG(ListPrice) AS Œrednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;

2. Funkcji GROUPING_ID(), która zwraca numer poziomu podsumowania, przy
czym 0 oznacza wiersz zawieraj¹cy wartoœci wyliczone dla grupy, a najwiêkszy
numer — wiersz zawieraj¹cy podsumowanie ca³ego zapytania:
SELECT C.Name, GROUPING_ID(C.Name,P.Color) AS GroupLevel,
P.Color, AVG(ListPrice) AS Œrednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;

Mo¿liwoœæ zdefiniowania wielu metod grupowania tych samych danych daje nam
operator GROUPING SETS.

SELECT a, NULL as b, NULL as c, sum(x) as sumx
FROM #T
GROUP BY a
UNION ALL
SELECT NULL as a, b, NULL as c, sum(x) as sumx
FROM #T
GROUP BY b
UNION ALL
SELECT a, b, c, sum(x) as sumx
FROM #T
GROUP BY a, b, c;

Powy¿sza instrukcja jest równowa¿na tej : 
SELECT a, b, c, SUM(x) AS sumx
FROM #T
GROUP BY
GROUPING SETS (a, (b), (a, b, c));	// Poszczególne metody grupowania danych s¹ ujête w nawiasy i oddzielone przecinkami . 	

Podsumowuj¹c — klauzula GROUP BY umo¿liwia wskazanie jednego porz¹dku grupowania,
a operator GROUPING SETS rozszerza jej funkcjonalnoœæ, umo¿liwiaj¹c zdefiniowanie
w jednym zapytaniu wielu ró¿nych porz¹dków grupowania.

Serwer SQL pozwala na przekszta³canie wierszy w kolumny i odwrotnie, czyli na
pracê z tabelami przestawnymi. Pierwsza operacja pozwala poprawiæ czytelnoœæ
wyników zapytañ, grupuj¹cych dane (zmniejszaj¹c liczbê wierszy, poprawiamy czytelnoœæ
raportów), druga — dostosowaæ dane pochodz¹ce z arkuszy kalkulacyjnych do
struktury tabel bazodanowych.

Serwery bazodanowe pozwalaj¹ okreœliæ dodatkowy porz¹dek grupowania w klauzuli
OVER. Zdefiniowane w tej klauzuli grupy s¹ nazywane partycjami i mog¹ byæ u¿yte do
wywo³ania funkcji grupuj¹cych oraz funkcji rankingu, okienkowych i analitycznych.

































 */
