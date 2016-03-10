package database_first_steps;

public class PraktycznyKursSQL_NOTES {

}

/*
Baza danych to zbi�r powi�zanych ze sob� informacji o �ci�le okre�lonej
strukturze.

/////////////////Model jednorodny
W tym modelu wszystkie dane s� przechowywane w jednym arkuszu, tabeli, kostce
analitycznej lub pliku (st�d nazwa modelu).

Zaletami tego modelu s� �atwo�� i szybko�� odczytywania interesuj�cych nas
danych � w tym przypadku wystarczy tylko znale�� rekord opisuj�cy szukany zakup,
�eby pozna� wszystkie szczeg�y operacji.
Wad� modelu jednorodnego jest du�a liczba duplikat�w (powtarzaj�cych si�
danych) � w naszym przyk�adzie nazwa dostawcy, jego adres i telefon kontaktowy
wpisane s� tyle razy, ile razy kupili�my u niego towar.

Wielokrotne zapisywanie tych samych danych nie tylko zajmuje wi�cej miejsca na dysku
i w pami�ci, lecz tak�e:

1. Utrudnia modyfikowanie danych.
2. Zwi�ksza ryzyko wpisania b��dnych danych.

 ////////////////////////RELATIONAL MODEL 
W modelu relacyjnym dane s� przechowywane w wielu odr�bnych, ale powi�zanych
ze sob� tabelach.

Zalet� modelu relacyjnego jest zapobieganie tworzeniu duplikat�w danych.

Wad� modelu relacyjnego jest skomplikowane i wolne odczytywanie danych.

Dane s� przechowywane w osobnych, ale powi�zanych ze sob� tabelach.

Te ��cz�ce tabele
powi�zania nazywa si� relacjami (st�d nazwa modelu).

Informacje na temat tego, kt�ra tabela jest powi�zana z innymi tabelami, s� prezentowane
w postaci diagram�w E/R (diagram�w Encja/Relacja).

Kolumna, kt�ra zawiera identyfikator rekordu innej
tabeli, nazywa si� kluczem obcym.

Specjalna kolumna,w kt�rej zapisuje si� identyfikatory poszczeg�lnych wierszy - kolumna ta nazywa
si� kluczem podstawowym tabeli.


///////////////////////////Model obiektowy

Relacyjn� baz� danych mo�na por�wna� do magazynu z meblami, w kt�rym ka�da
cz�� mebla jest umieszczana w osobnym, przeznaczonym wy��cznie dla niej kontenerze
(odpowiednikami kontener�w s� tabele).

Tymczasem model obiektowy przypomina magazyn, w kt�rym meble s� ustawiane bez
rozbierania na cz�ci. W rezultacie korzystanie z magazynu jest prostsze (ale niekoniecznie
szybsze), za to liczba mebli, jak� mo�na zmie�ci� na tej samej przestrzeni,
jest znacznie mniejsza.

W opracowanym w latach 90. XX wieku modelu obiektowym informacje s� przechowywane
w bazie nie w postaci rekord�w, ale ca�ych obiekt�w.

Zalet� modelu obiektowego jest zgodno�� z obowi�zuj�cym paradygmatem programowania.

Wi�kszo�� j�zyk�w programowania, w przeciwie�stwie
do j�zyka SQL, ma wbudowan� statyczn� kontrol� typ�w, a w prawie �adnym
z nich nie wyst�puje podstawowy dla j�zyka SQL typ �relacja�, wiele j�zyk�w
programowania nie obs�uguje te� warto�ci NULL.

SQL jest j�zykiem interpretowanym, a nie kompilowanym.

W j�zyku SQL programista okre�la wynik, jaki chce
otrzyma�, a nie spos�b, w jaki ma on by� osi�gni�ty.

Do dzi� nie opracowano standardu tego modelu, a nieliczne obiektowe bazy danych s� u�ywane
g��wnie w celach badawczych, ponadto nie umo�liwiaj� one na razie przechowywania
du�ych (liczonych w setkach gigabajt�w czy terabajt�w) ilo�ci danych, nie m�wi�c ju�
o wydajnym zarz�dzaniu nimi.

Ogromn� popularno�� zdobywaj� technologie ORM (ang. Object-Relational Mapping), kt�re
pozwalaj� programistom traktowa� relacyjne bazy danych tak, jakby by�y bazami
obiektowymi.

Relacyjny model baz danych zosta� opracowany w latach 70. XX wieku przez pracuj�cego
dla firmy IBM naukowca Edgara Franka Codda.

Tylko serwery zgodne z wszystkimi postulatami E.F. Codda uznawane
s� za serwery relacyjnych baz danych.

Metadane (informacje o strukturze bazy danych).

Proces dostosowywania schematu bazy danych do wymog�w modelu relacyjnego
nazywa si� normalizacj�.

Edgar Frank Codd zdefiniowa� trzy postacie normalne i chocia� p�niej zosta�y dodane
kolejne trzy, to prawie wszystkie bazy danych doprowadza si� do trzeciej postaci
normalnej (3PN), a ponad 75% baz danych znormalizowanych jest do czwartej
postaci normalnej (4NF). Baza danych znajduj�ca si� w wy�szej postaci normalnej
musi spe�nia� wymogi wszystkich ni�szych postaci normalnych.

/////////////////Pierwsza posta� normalna
G��wnym celem doprowadzania do pierwszej postaci normalnej jest wyeliminowanie
nieatomowych atrybut�w (tabela jest zgodna z 1PN, je�li wszystkie jej kolumny przechowuj�
atomowe, niepodzielne warto�ci). Na przyk�ad kolumn� Adres nale�y rozbi�
na kilka kolumn przechowuj�cych kod, nazw� miasta i ulic�, a kolumn� Osoba � na
dwie: Imi� i Nazwisko.

Za atomowe warto�ci nale�y przyj�� takie, kt�re mog� by� u�yte w przysz�o�ci do:
1. wyszukiwania, np. znalezienia osoby o podanym nazwisku;
2. sortowania, np. przygotowania listy os�b u�o�onej alfabetycznie wed�ug imion;
3. grupowania, np. policzenia os�b mieszkaj�cych w poszczeg�lnych miastach.
Ponadto aby spe�ni� wymogi pierwszej postaci normalnej, tabela musi posiada�
kolumn� klucza podstawowego.

//////////////////Druga posta� normalna
 * 
Doprowadzenie tabeli do drugiej postaci normalnej polega na usuni�ciu z niej atrybut�w
(kolumn), kt�re zale�� funkcyjnie od cz�ci klucza podstawowego (tabela jest
zgodna z 2PN, je�eli znajduje si� w pierwszej postaci normalnej i warto�ci jej
wszystkich niekluczowych kolumn zale�� od ca�ego klucza podstawowego). W praktyce
oznacza to, �e je�li klucz podstawowy tabeli jest prosty (za�o�ony na pojedynczej
kolumnie), a nie z�o�ony (za�o�ony na kilku kolumnach), i tabela jest w 1PN, to
spe�nia ona te� automatycznie wymogi drugiej postaci normalnej.

Sytuacja taka mia�aby miejsce, gdyby w tabeli SalesOrderDetail, kt�rej kluczem
podstawowym s� kolumny SalesOrderID oraz SalesOrderDetailID, znajdowa�a si�
kolumna z dat� zam�wienia. Wtedy kolumna OrderDate zale�a�aby wy��cznie od jednej
cz�ci klucza podstawowego (kolumny SalesOrderID), innymi s�owy � znaj�c identyfikator
zam�wienia, mogliby�my ze 100-procentow� dok�adno�ci� odczyta� jego
dat� i znajomo�� identyfikatora SalesOrderDetailID by�aby do tego niepotrzebna.

////////////////////Trzecia posta� normalna
Doprowadzenie tabeli do trzeciej postaci normalnej polega na znalezieniu i usuni�ciu
przechodnich zale�no�ci pomi�dzy atrybutami (tabela jest zgodna z 3PN, je�eli jest
ju� w drugiej postaci normalnej i warto�ci jej kolumn nie s� zale�ne od niekluczowych
atrybut�w).
Na przyk�ad je�li w tabeli Product znajdowa�aby si� kolumna z nazwami kategorii,
warto�ci w tej kolumnie powtarza�yby si� tyle razy, ile produkt�w nale�a�oby do
danej kategorii. Nadmiarowo�� ta wynika z faktu, �e nazwa kategorii zale�y funkcyjnie
nie tylko od identyfikatora produktu (znaj�c go, mo�emy jednoznacznie odczyta�
nazw� kategorii), ale r�wnie� od innych atrybut�w produktu, takich jak jego
nazwa czy numer.

Doprowadzanie tabel do trzeciej postaci normalnej polega na:
1. Utworzeniu tabel s�ownikowych, np. tabeli z nazwami miast. Takie tabele
zawieraj� listy (s�owniki) u�ywanych w bazie termin�w, dzi�ki czemu zamiast
ka�dorazowo pos�ugiwa� si� danym terminem, wystarczy u�y� jego
identyfikatora.
2. Utworzeniu tabel ��cznikowych, czyli takich, kt�re umo�liwiaj� budowanie
relacji typu �wiele do wielu�. Na przyk�ad je�eli przyjmiemy, �e ta sama
osoba mo�e zapisa� si� jednocze�nie na kilka kurs�w, a na ten sam kurs z regu�y
mo�e zapisa� si� wiele os�b, powinni�my utworzy� tabel� KursOsoba i umie�ci�
w niej klucze obce tabel Osoby i Kursy oraz atrybuty konieczne dla po��czenia
kursanta z jego zaj�ciami, takie jak numer sali czy godzina rozpocz�cia zaj��.



Relacja "Wiele do wielu."
Przyk�ad : Ten sam sklep mo�e sprzedawa� dowolne produkty i ten sam produkt
mo�e by� sprzedawany w r�nych sklepach

Relacja �jeden do wielu�
Jeden produkt nie mo�e nale�e� do r�nych kategorii, ale do tej samej
kategorii mo�e nale�e� wiele produkt�w.

//////////////////Posta� Boyce�a-Codda
Kolejn�, czasami nazwan� postaci� trzeci� i p�, postaci� normaln� jest posta�
Boyce�a-Codda (BCNF). Jej formalna definicja brzmi nast�puj�co: tabela jest zgodna
z BCNF, je�eli jest ju� w trzeciej postaci normalnej i dla ka�dej nietrywialnej zale�no�ci
mi�dzy podzbiorami jej atrybut�w zbi�r b�d�cy wyznacznikiem jest jej zbiorem
identyfikuj�cym. Poniewa� �atwiej jest wyja�ni� posta� Boyce�a-Codda na przyk�adzie
ni� na podstawie jej definicji, przypu��my, �e w bazie danych znajduje si� tabela
z danymi na temat sklep�w, sprzedawanych w nich towar�w oraz ich kategorii. Za��my
te�, �e ten sam sklep mo�e sprzedawa� dowolne produkty i ten sam produkt
mo�e by� sprzedawany w r�nych sklepach (tak� relacj� nazywa si� relacj� �wiele do
wielu�) i �e jeden produkt nie mo�e nale�e� do r�nych kategorii, ale do tej samej
kategorii mo�e nale�e� wiele produkt�w (jest to przyk�ad znanej nam ju� relacji �jeden
do wielu�)

Kluczem podstawowym takiej tabeli mog�yby by� kolumny Sklep i Towar, bo na podstawie
obu tych warto�ci mo�na jednoznacznie zidentyfikowa� pozosta�e atrybuty, w tym
kategori�. W takim wypadku tabela by�aby znormalizowana do trzeciej postaci normalnej.
Gdyby�my jednak chcieli dopisa� do tej tabeli nowy sklep, mieliby�my problem
� jej kluczem jest kombinacja identyfikatora sklepu i sprzedawanych w nim produkt�w,
a wi�c sklepu, w kt�rym nic jeszcze nie sprzedali�my, nie da�oby si� dopisa�.
Aby rozwi�za� ten problem, nale�a�oby podzieli� tabel� na cztery osobne, spe�niaj�ce
wymogi postaci BCNF tabele, w kt�rych by�yby zapisane dane:

1. w pierwszej o sklepach;
2. w drugiej o produktach;
3. w trzeciej o kategoriach produkt�w;
4. w czwartej o sprzedawanych w danym sklepie produktach (to by�aby tak
zwana tabela ��cznikowa).


////////////////////Czwarta posta� normalna
W definicji czwartej postaci normalnej termin �zale�no�� funkcyjna� jest zast�piony
terminem �zale�no�� wielowarto�ciowa� (tabela jest zgodna z 4PN, je�eli jest ju�
w postaci Boyce�a-Codda i nie wyst�puj� w niej zale�no�ci wielowarto�ciowe). Ponownie
naj�atwiej posta� t� wyt�umaczy� na przyk�adzie.

Wyobra�my sobie tabel� Produkty, w kt�rej w kolumnie Nazwa zapisane s� nazwy r�nych
przedmiot�w (np. krzes�o, lornetka i tak dalej). W kolejnych kolumnach znajduj�
si� warto�ci r�nych atrybut�w tych przedmiot�w, np. w kolumnie Obicie kolor obicia,
a w kolumnie Ogniskowa dane o ogniskowej obiektywu. Jako �e r�ne przedmioty
maj� r�ne cechy (np. krzes�a nie maj� ogniskowej), wiele kom�rek takiej tabeli b�dzie
pustych.

Powodem tej anomalii jest wyst�powanie zale�no�ci wielowarto�ciowej, czyli takiej,
w kt�rej na podstawie jednej kolumny (nazwy przedmiotu) mo�na wnioskowa� o wielu
kolumnach (takich jak Ogniskowa czy Obw�d w pasie). Aby doprowadzi� tabel� do postaci
zgodnej z czwart� postaci� normaln�, nale�y j� rozbi� na osobne tabele, kt�rych
kolumny b�d� zawiera�y wy��cznie nazwy cech obiekt�w danego typu.

//////////////////////////////////////////////////////////////////

Teoretyczne podstawy modelu relacyjnego, w tym trzy pierwsze postacie
normalne, zosta�y zdefiniowane w latach 70. XX wieku przez dra E.F. Codda.

W odr�nieniu od innych j�zyk�w SQL umo�liwia przetwarzanie wielu danych za
pomoc� pojedynczej instrukcji.

!W przeciwie�stwie do j�zyk�w proceduralnych SQL pozwala okre�li� wynik, nie
spos�b jego osi�gni�cia. Instrukcje j�zyka SQL nie zawieraj� �adnych wskaz�wek
dotycz�cych metody ich wykonywania przez serwer bazodanowy. W poprzednim przyk�adzie
instrukcja SELECT nie okre�la�a sposobu (algorytmu), wed�ug kt�rego serwer mia�
znale�� szukany element w tabeli. Poniewa� w j�zyku SQL deklaruje si� spodziewany
rezultat wykonania instrukcji, nazywa si� go j�zykiem strukturalnym.

!Spos�b wykonania instrukcji j�zyka SQL zale�y od serwera bazodanowego.

!W przeciwie�stwie do j�zyk�w proceduralnych, kt�rych instrukcje s� wykonywane w tej samej
kolejno�ci, w jakiej zosta�y zapisane, w j�zyku SQL kolejno�� wykonywania polece�
zale�y od serwera i niekoniecznie odpowiada kolejno�ci, w jakiej zapisano poszczeg�lne
instrukcje i ich klauzule3.

Wspomniane wcze�niej j�zyki: C, C++, Pascal, Visual Basic i Java s� j�zykami kompilowanymi
� ich instrukcje s� przekszta�cane do postaci kodu wykonywalnego przez
kompilatory.

Instrukcje j�zyka SQL, przed wykonaniem s� interpretowane przez serwer bazodanowy.
Wynikiem tej interpretacji jest plan wykonania instrukcji, kt�ry nast�pnie jest
realizowany przez serwer.

Podczas interpretacji przeprowadzana jest optymalizacja polegaj�ca na znalezieniu
jak najlepszego (w przypadku serwera SQL Server jak najta�szego) planu wykonania.
Odpowiedzialne za to optymalizatory s� z regu�y najbardziej skomplikowanymi
elementami serwer�w bazodanowych.

Poniewa� instrukcje j�zyka SQL s� interpretowane, a nie kompilowane, niekt�re b��dy
 zostan� wykryte dopiero podczas ich wykonywania.

Kolejn� konsekwencj� ka�dorazowego interpretowania instrukcji SQL jest d�u�szy
czas (a wi�c wy�szy koszt) ich wykonania. Dotyczy to jednak wy��cznie sytuacji, w kt�rych
j�zyk SQL jest u�ywany niezgodnie z jego przeznaczeniem, czyli do przetwarzania
pojedynczych, a nie ca�ych zbior�w danych.


/////////////////Sk�adnia j�zyka SQL
W j�zyku SQL wyst�puje pi�� g��wnych kategorii syntaktycznych:
1. identyfikatory, czyli nazwy obiekt�w;
2. litera�y, czyli sta�e;
3. operatory, czyli sp�jniki;
4. s�owa kluczowe, czyli wyrazy interpretowane przez serwer bazodanowy
w okre�lony spos�b;
5. ignorowane przez serwery bazodanowe komentarze.

////////////////////////////////////////////////////////////////////////
Identyfikatory musz� by� zgodne ze zdefiniowanymi w standardzie j�zyka SQL regu�ami:

1. Nie mog� sk�ada� si� z wi�cej ni� 128 znak�w.
2. Mog� zawiera� litery, cyfry oraz symbole: @, $, #. Pozosta�e symbole, w tym znak
spacji, s� niedozwolone.
3. Mog� zaczyna� si� liter�, ale nie cyfr�. Identyfikatory zaczynaj�ce si� jednym
z dw�ch dozwolonych symboli maj� specjalne znaczenie:
a) Identyfikator rozpoczynaj�cy si� symbolem @ oznacza zmienn�.
b) Identyfikator rozpoczynaj�cy si� symbolem # oznacza obiekt tymczasowy.
4. Nie mog� by� s�owami kluczowymi j�zyka SQL.

Dodatkowo identyfikatory powinny by� zgodne z poni�szymi konwencjami nazewniczymi:
1. Powinny by� kr�tkie, ale jednoznacznie opisywa� dany obiekt. Na przyk�ad
tabela zawieraj�ca zam�wienia z roku 2008 powinna nazywa� si� nie Z08,
ale raczej Zam�wienia2008.
2. Wielko�� liter powinna by� zgodna z przyj�tymi w ramach projektu regu�ami.
Nam najbardziej podoba si� zasada m�wi�ca, �e ka�dy wyraz (z wyj�tkiem
pierwszego) powinien zaczyna� si� od wielkiej litery, np.
udfNajdro�szeTowary.
3. Przedrostek nazw widok�w, funkcji u�ytkownika, procedur sk�adowanych
czy wyzwalaczy powinien wskazywa� na typ obiektu, np. udf � funkcja
u�ytkownika (ang. User Define Function), usp � procedura u�ytkownika
(ang. User Stored Procedure), v � widok (ang. View), tr � wyzwalacz
(ang. Trigger)

/////////////////////////////////////////////////////////////////////////////
Litera�y
Wszystkie cyfry, ci�gi znak�w i daty, je�eli nie s� identyfikatorami, s� traktowane jako
sta�e, czyli litera�y. W j�zyku SQL ci�gi znak�w umieszcza si� w apostrofach:
SELECT 'Przyk�adowy ci�g znak�w';

////////////////////////////////////////////////////////////////////////////////////
Operatory
Operatory odgrywaj� rol� sp�jnik�w. Niekt�re z nich mog� (ale nie powinny, bo instrukcje
z nimi s� czytelniejsze) by� zast�pione odpowiednimi funkcjami. Operatory dziel� si� na:
1. Arytmetyczne, do kt�rych nale��: iloczyn *, iloraz /, modulo %, suma + i r�nica -.
2. Znakowe, do kt�rych nale��: konkatenacja (z��czenie ci�g�w znak�w) +, symbol
wieloznaczny (zast�puj�cy dowolny ci�g znak�w) % i symbol wieloznaczny
(zast�puj�cy jeden znak) _.
3. Logiczne, do kt�rych nale��: koniunkcja AND, alternatywa OR i negacja NOT.
4. Por�wnania, do kt�rych nale��: r�wny =, mniejszy ni� <, wi�kszy ni� >, mniejszy
lub r�wny <=, wi�kszy lub r�wny >= i r�ny != lub <>.
5. Charakterystyczne dla j�zyka SQL. Nale�� do nich m.in.: przynale�no��
do zbioru IN, przynale�no�� do domkni�tego przedzia�u BETWEEN � AND, zgodno��
ze wzorem LIKE, kaskadowe wykonanie operacji CASCADE oraz wywo�anie
funkcji tabelarycznej APPLY.


!Lista dost�pnych operator�w j�zyka SQL zale�y od konkretnego serwera bazodanowego.
///////////////////////////////////////////////////////////////////////////////////////////
S�owa kluczowe
S�owa kluczowe to zastrze�one, maj�ce �ci�le okre�lone znaczenie ci�gi znak�w. Nale��
do nich:
1. instrukcje j�zyka SQL, takie jak SELECT czy CREATE;
2. klauzule j�zyka SQL, np. WHERE lub JOIN;
3. nazwy typ�w danych, np. INT lub CHAR;
4. nazwy funkcji systemowych, takie jak ISNULL() lub ABS();
5. terminy zarezerwowane dla przysz�ego u�ycia w danym serwerze bazodanowym.

Komentarze
W j�zyku SQL wyst�puj� dwa rodzaje komentarzy:
1. Podw�jny znak my�lnika oznacza komentarz w wierszu. Cz�� wiersza,
kt�ra znajduje si� za znakami --, jest traktowana jako komentarz:
SELECT 'test'; -- przyk�adowy komentarz
2. Znaki / * ( bez spacji) oznaczaj� pocz�tek bloku komentarza, a znaki * / � jego koniec.
Wiersze znajduj�ce si� pomi�dzy tymi znakami s� traktowane jako komentarz:
/*
Funkcja zwraca ostatnie zam�wienie
z�o�one przez klienta w danym sklepie
*/
/*
 
W r�nych serwerach zastosowane s� r�ne dialekty j�zyka SQL , 
wynika to z konkurowania mi�dzy sob� firm w zakresie oferowanych przez ich serwery mo�liwo�ci.

Standard SQL99 nie definiuje wielu rozszerze� j�zyka SQL, przede wszystkim
instrukcji steruj�cych wykonaniem programu oraz metod obs�ugi b��d�w.

Standard SQL99 nie obejmuje tak�e wewn�trznych mechanizm�w wykonywania
i optymalizacji instrukcji j�zyka SQL przez serwery bazodanowe.


////////////////////////////////////////////////////////////////////
 
Do najpopularniejszych dialekt�w j�zyka SQL nale��:
1. T-SQL � chocia� stosowane w serwerach Microsoft SQL Server i Sybase
Adaptive Server odmiany tego j�zyka r�ni� si�, to wci�� klasyfikuje si� je
jako jeden dialekt.
2. PL/SQL (ang. Procedural Language/SQL) � przypominaj�cy j�zyk ADA,
bardzo rozbudowany dialekt j�zyka SQL stosowany w serwerach firmy Oracle.
3. PL/pgSQL (ang. Procedural Language/PostgreSQL Structured Query Language)
� przypominaj�ca dialekt PL/SQL wersja j�zyka SQL zaimplementowana
w serwerze PostgreSQL.
4. SQL PL (ang. SQL Procedural Language) � dialekt u�ywany w serwerach
bazodanowych firmy IBM.



SQL1 - 1989 wydany przez ISO .
SQL2 - 1992 .
SQL3 - 1999. 
SQL4 - 2003	
SQL5 - 2006
SQL6 - 2008
SQL7 - 2011

Podzia� instrukcji na kategorie w SQL3 :

1. Connection Statements � instrukcje umo�liwiaj�ce nawi�zanie i zako�czenie
po��czenia z serwerem, np. CONNECT i DISCONNECT;
2. Control Statements � instrukcje steruj�ce wykonaniem programu, np. CALL
i RETURN;
3. Data Statements � instrukcje maj�ce trwa�y wp�yw na dane, np. SELECT, INSERT,
UPDATE i DELETE;
4. Diagnostics Statements � instrukcje diagnostyczne umo�liwiaj�ce obs�ug�
b��d�w, np. GET DIAGNOSTICS, TRY � CATCH i RAISERROR;
5. Schema Statements � instrukcje maj�ce trwa�y wp�yw na obiekty baz danych,
np. CREATE, ALTER i DROP;
6. Session Statements � instrukcje kontroluj�ce opcje sesji u�ytkownik�w, np. SET;
7. Transaction Statements � instrukcje umo�liwiaj�ce rozpocz�cie i zako�czenie
transakcji, np. START, COMMIT i ROLLBACK.


SQL3 - By� to pierwszy standard obejmuj�cy zaawansowane funkcje i obszary zastosowa� j�zyka SQL, takie jak modele
obiektowo-relacyjnych baz danych, mechanizmy wywo�ywania instrukcji j�zyka SQL
czy techniki zarz�dzania sp�jno�ci� danych.

Kategoria Przyk�adowe typy danych Opis
Typy liczbowe INTEGER (INT), SMALLINT				Reprezentuj� liczby ca�kowite.
NUMERIC (DECIMAL)									Reprezentuje liczby o okre�lonej skali i precyzji.
REAL												Reprezentuje liczby o zmiennej precyzji.

Typy daty i czasu 
DATE												Reprezentuje dat�.
TIME												Reprezentuje czas.

Typy znakowe 
CHAR												Reprezentuje ci�g znak�w o okre�lonej d�ugo�ci.
VARCHAR												Reprezentuje ci�g znak�w o zmiennej d�ugo�ci.
NCHAR, NVARCHAR										Reprezentuje ci�g znak�w o zmiennej d�ugo�ci 
													zakodowanych w UNICODE.


Typy binarne 
BINARY												Reprezentuje ci�g bit�w o okre�lonej d�ugo�ci.
VARBINARY											Reprezentuje ci�g bit�w o zmiennej d�ugo�ci.
BLOB												Reprezentuje du�e obiekty binarne.

Dokumenty XML										 XML Reprezentuje ca�e dokumenty XML.



Warto�� specjalna NULL nie jest r�wna jakiejkolwiek innej warto�ci ani od niej r�na.

Dwie warto�ci NULL nie s� ani sobie r�wne, ani r�ne od siebie. Warto�� NULL
nie jest te� r�wna jakiejkolwiek innej warto�ci ani mniejsza czy wi�ksza
od niej.

Wynikiem wszystkich operacji zawieraj�cych NULL jest warto�� NULL ( lub UNKNOWN) .

Warto�� NULL jest ignorowana przez wszystkie funkcje grupuj�ce z wyj�tkiem
funkcji COUNT(*).

W pe�ni kwalifikowana nazwa obiektu ma
posta� nazwa serwera.nazwa bazy danych.nazwa schematu.nazwa obiektu, przy czym:

1. Opcjonalna nazwa serwera wskazuje serwer bazodanowy. Je�eli jej nie podamy,
instrukcja zostanie wykonana przez serwer, z kt�rym jeste�my po��czeni.

2. Opcjonalna nazwa bazy danych wskazuje nazw� bazy danych, w kt�rej znajduje
si� ��dany obiekt. Je�eli nie zostanie ona podana, serwer za�o�y, �e obiekt
znajduje si� w bie��cej bazie danych. 

3. Opcjonalna nazwa schematu wskazuje schemat (przestrze� nazwy grupuj�c�
powi�zane ze sob� obiekty), w kt�rym znajduje si� ��dana tabela. Gdyby�my
j� pomin�li, serwer bazodanowy za�o�y�by, �e obiekt o podanej nazwie znajduje
si� w domy�lnym schemacie u�ytkownika wykonuj�cego dan� instrukcj�.

4. Obowi�zkowa nazwa obiektu wskazuje obiekt, do kt�rego chcemy si� odwo�a�,
w naszym przypadku tabel� Klienci.

Wybranie niekt�rych kolumn tabeli nazywa si� selekcj� pionow�, rzutem lub projekcj�
tabeli. Wynikiem projekcji jest tabela o liczbie kolumn mniejszej ni� liczba kolumn
odczytywanej tabeli.

Odradza sie u�ywanie symbolu * � stosuj�c go, nara�amy si� na otrzymanie
b��dnych, innych, ni� si� spodziewali�my, wynik�w oraz stosowanie symbolu
* mo�e znacznie wyd�u�y� czas wykonywania zapytania.	
SELECT * FROM [SalesLT].[ProductCategory];

S�owo kluczowe DISTINCT eliminuje z wyniku zapytania powt�rzone wiersze, a nie
powt�rzone warto�ci wybranych kolumn.

W SQL mo�emy u�ywa� operator�w arytmetycznych : + - *  / %. Pierwsze dwa maj� ni�szy priorytet od pozosta�ych. 
One z kolei s� na r�wni. 

U�ywaj�c zapytania mo�emy oczekiwa� kolumny b�d�cej np iloczynem innych dw�ch kolumn. 
SELECT NAME, PRICE, WEIGHT , PRICE * WEIGHT FROM TABLE1;

Mo�emy dokonywa� konkatenacji ��cz�c za pomoc� znaku + warto�ci z kolumn, np : 
SELECT NAME, COLOR + SERIALNUMBER FROM TABLE1; 
Lub za pomoc� funkcji CONCAT(). 
SELECT NAME , CONCAT(COLOR , SERIALNUMBER) FROM TABLE1 ;	

Najpopularniejsze funkcje : 
ABS() , CEILING() , FLOOR() , POWER(X,Y) , RAND() , ROUND(X, PRZYBLI�ENIE) , SQRT();
LEN(TEKST), LOWER(), LTRIM() - usuwa spacje ,  REPLACE ( tekst, what , with what), REPLICATE(TXT, N), RTRIM(),
SUBSTRING(TXT, FROM, HOW MANY SYMBOLS) , UPPER(). 
DATEADD( DAY, 20, '20071228'), DATEDIFF(HOUR, '20071231', '20150412'), DAY(GETDATE()), MONTH(), YEAR().

Typy Liczbowe maj� wy�szy priorytet ni� znakowe! 
SELECT '1'+1+'1', '1'+'1'+1;	zwr�ci 3 i 12 . 

Jawn� konwersj� typ�w umo�liwiaj� funkcje CAST(wyra�enie AS typ) oraz CONVERT
(typ, wyra�enie).
SELECT [ProductNumber] + [ListPrice] FROM [SalesLT].[Product];	zwr�ci b��d gdy� pierwwsza koluna zawiera typy 
znakowe a druga liczby i serwer pr�buje je do siebie doda� a nie skonkatenowa�. 
Rozwi�zanie : SELECT [ProductNumber] + CAST([ListPrice] AS VARCHAR(15)) FROM [SalesLT].[Product];

Funkcja CASE jest SQL-owym odpowiednikiem instrukcji warunkowej IF � THEN � ELSE.
SELECT [ListPrice],
CASE
WHEN [ListPrice] <10 THEN 'Tani'
WHEN [ListPrice] <50 THEN '�rednia p�ka'
ELSE 'Drogi'
END
FROM [SalesLT].[Product];

Bardzo u�yteczn� rzecz� w SQL s� aliasy pozwalaj�ce w zakresie zapytania zmieni� nazw kolumny. 
SELECT [Name] AS [Nazwa Produktu], [ListPrice] - [StandardCost] AS Zysk FROM [SalesLT].[Product];

Kolumna wyliczeniowa - taka, kt�ra nie zosta�a bezpo�rednio odczytana z tabeli, tylko wyliczona w zapytaniu.

Poniewa� klauzula SELECT, cho� w zapytaniach wyst�puje jako pierwsza, jest wykonywana
jako jedna z ostatnich, zdefiniowanych w niej alias�w nie mo�na u�y� w innych
klauzulach zapytania.

Aliasy tabel definiuje si� w ten sam spos�b, ale w klauzuli FROM. Do zdefiniowanych
w klauzuli FROM alias�w mo�na si� odwo�a� w innych klauzulach zapytania. 
Jednak poniewa� klauzula FROM jest wykonywana w pierwszej kolejno�ci, po zdefiniowaniu
w niej aliasu dla tabeli w pozosta�ych klauzulach zapytania nie mo�emy ju� u�ywa�
oryginalnej nazwy tabeli.

/////////////////////////LITERA�Y

SELECT 'Zam�wienie ' + CAST([SalesOrderID] AS CHAR(5)) + ' zosta�o z�o�one w roku '
+ CONVERT(CHAR(4),DATEPART(YEAR,[OrderDate])) FROM [SalesLT].[SalesOrderHeader];
Przyk�ad u�ycia litera��w w klauzuli SELECT.

Jako specjalny rodzaj sta�ych nale�y te� traktowa� wi�kszo�� wywo�ywanych bez parametr�w
i umieszczanych w klauzuli SELECT funkcji. Takie funkcje s� wywo�ywane raz
dla ca�ego zapytania, a nie dla ka�dego wiersza jego wyniku, wi�c np dzi�ki RAND() w ka�dym wierszu dostaniemy 
t� sam� liczb� pseudolosow�. 

NEWID() - jedyna funkcja b�d�ca wyj�tkiem od tej regu�y. 

Kolejno�� wierszy wyniku zapytania jest niedeterministyczna i zale�y od sposobu,
w jaki serwer bazodanowy w danej chwili wykona to zapytanie.

Kolejno�� klauzul instrukcji SELECT jest �ci�le okre�lona, a opcjonalna klauzula
ORDER BY musi by� ostatni� klauzul� zapytania.
W klauzuli ORDER BY umieszcza si� nazwy lub numery kolumn, wed�ug kt�rych chcemy
posortowa� wynik zapytania.
SELECT [Name],[ListPrice]
FROM [SalesLT].[Product]
ORDER BY 2 DESC;

Wyniki zapyta� mog� by� sortowane wed�ug warto�ci wielu kolumn.

Poszczeg�lne klauzule zapytania s� od siebie niezale�ne, co oznacza, �e w ka�dej
z nich mo�emy odwo�a� si� do innych kolumn.

Powt�rzone wiersze mog� by� usuni�te z wyniku za pomoc� s�owa kluczowego
DISTINCT, a wi�c wynik zapytania mo�e liczy� mniej wierszy ni� oryginalna tabela.
W takim przypadku sortowanie go wed�ug warto�ci nieistniej�cej w nim kolumny jest
niemo�liwe. Innymi s�owy, je�eli w zapytaniu zosta�o u�yte s�owo kluczowe DISTINCT,
wszystkie wymienione w klauzuli ORDER BY kolumny i wyra�enia musz� wyst�powa�
w klauzuli SELECT.

/////////////////////////////Sortowanie danych tekstowych
Dane tekstowe s� przechowywane i przetwarzane w postaci kod�w � ka�dej literze
alfabetu, cyfrze i znakowi specjalnemu odpowiada inna cyfra kodu. Serwery bazodanowe
u�ywaj� dw�ch rodzaj�w kodowania danych tekstowych:

1. W kodowaniu ANSII jeden znak jest zakodowany za pomoc� jednego bajta.
Ogranicza to liczb� mo�liwych kod�w do 256 . Poniewa�
liczba stosowanych w r�nych j�zykach liter alfabetu jest znacznie
wi�ksza, w kodowaniu ANSII stosuje si� strony kodowe.

2. W kodowaniu UNICODE jeden znak jest zakodowany za pomoc� dw�ch bajt�w.
Daje to 65 536 (2^16 = 65 536) r�nych kod�w, co wystarcza do zapisania
wszystkich znak�w diakrytycznych, a wtedy stosowanie stron kodowych jest
niepotrzebne.

Opr�cz typu kodowania (i strony kodowej w przypadku kodowania ANSII) serwery
bazodanowe pozwalaj� te� okre�li� spos�b sortowania danych tekstowych. Z regu�y
mo�emy zadecydowa�:

1. Czy ci�gi znak�w maj� by� sortowane wed�ug kod�w (takie sortowanie
nazywa si� sortowaniem binarnym), czy w porz�dku alfabetycznym.

2. Czy maj� by� uwzgl�dniane znaki diakrytyczne (w przypadku j�zyka polskiego:
czy litera � ma by� umieszczona pomi�dzy literami a i b, czy po z).

Sortowanie binarne wed�ug znak�w polskiej strony kodowej. 

SELECT imie
FROM imiona
ORDER BY imie COLLATE Polish_BIN;

To klauzula FROM jest wykonywana jako pierwsza klauzula zapytania.Wynikiem zapytania jest tabela.

W klauzulach SELECT i ORDER BY mo�na umieszcza� wyra�enia i wywo�ywa�
funkcje systemowe, o ile tylko ich wynikami s� pojedyncze warto�ci.

///////////////////////////////////Logika tr�jwarto�ciowa
Podstaw� u�ywanej na co dzie� klasycznej logiki s� trzy intuicyjnie uznawane za prawdziwe
zasady:
1. Zasada to�samo�ci, na mocy kt�rej a=a, czyli ka�da rzecz jest r�wna samej sobie.
2. Zasada sprzeczno�ci, na mocy kt�rej ~(a ^ ~a), czyli z dw�ch sprzecznych zda�
(predykat�w) jedno jest prawdziwe2.
3. Zasada wy��czonego �rodka, na mocy kt�rej (a v ~a), czyli zdanie (predykat)
albo jest prawdziwe, albo fa�szywe.

W j�zyku SQL �adna z tych zasad nie stosuje si� do warto�ci NULL.

Warto�� NULL reprezentuje brakuj�c� lub nieznan� warto��, a wi�c w rzeczywisto�ci
w og�le nie jest warto�ci� �adnego typu.

Warto�� NULL nie jest r�wna samej sobie (wyj�tkiem od tej regu�y jest opisana
klazula GROUP BY).
Ani warto�� NULL, ani jej negacja nie s� prawdziwe.
Warto�� NULL nie jest ani prawdziwa, ani fa�szywa.

W j�zyku
SQL warunek logiczny mo�e mie� trzeci� warto�� � warto�� UNKNOWN.

Operatory logiczne : AND , OR , NOT.
TRUE OR NULL = TRUE ; FALSE OR NULL = UNKNOWN; NULL OR NULL = UNKNOWN.
FALSE AND NULL = FALSE; TRUE AND NULL = UNKNOWN; 

Typowe zapytania ��cz� poznan� w poprzednim rozdziale projekcj� (wybieranie kolumn) z selekcj�
(wybieraniem wierszy).

Opcjonalna klauzula WHERE musi wyst�pi� bezpo�rednio po klauzuli FROM.

//////////////////////////////////////////////////OPERATORY POR�WNANIA 
 = , <>,!= , < , > , <= , >=. 

Nazwy kolumn mog� by� u�yte w wyra�eniach znajduj�cych si� po obu stronach
operator�w por�wnania.
SELECT [ProductNumber], [StandardCost], [ListPrice]
FROM [SalesLT].[Product]
WHERE [StandardCost]*2<[ListPrice];

//////////////////////////////////////////////////Operatory SQL
Opr�cz standardowych operator�w por�wnania w klauzuli WHERE mo�emy u�y� specyficznych
dla j�zyka SQL operator�w IN, BETWEEN � AND, LIKE oraz IS NULL.

Operator IN pozwala sprawdzi�, czy szukana warto�� nale�y do podanego zbioru, np.
czy wielko�� produktu wynosi 44, 48 lub 50:
SELECT [ProductNumber], [Size]
FROM [SalesLT].[Product]
WHERE [Size] IN ('44','48','50');

Operator BETWEEN � AND pozwala sprawdzi�, czy szukana warto�� nale�y do okre�lonego
przedzia�u domkni�tego. Dzi�ki niemu mo�emy np. pozna� nazwy towar�w o cenach
nie ni�szych ni� 10 i nie wy�szych ni� 20:
SELECT [ProductNumber], [ListPrice]
FROM [SalesLT].[Product]
WHERE [ListPrice] BETWEEN 10 AND 20;

Operator BETWEEN � AND mo�e by� te� u�yty do sprawdzenia, czy dane tekstowe nale�� do
podanego zakresu. W takim przypadku stosowany jest domy�lny, okre�lony na poziomie
kolumny, tabeli, bazy lub ca�ego serwera, porz�dek sortowania. Poni�sze zapytanie
zwraca nazwiska klient�w zaczynaj�ce si� na litery od B do D:
SELECT [LastName]
FROM [SalesLT].[Customer]
WHERE LEFT([LastName],1) BETWEEN 'B' AND 'D';

Za pomoc� operatora LIKE mo�emy przeszukiwa� dane tekstowe pod k�tem ich zgodno�ci
z podanym wzorcem. Do tworzenia wzorca mo�na u�y� dw�ch symboli o specjalnym
znaczeniu:
1. Symbol % (procent) zast�puje dowolny ci�g znak�w.
2. Symbol _ (podkre�lenie) zast�puje jeden dowolny znak.
SELECT [ProductID], [Name]
FROM [SalesLT].[Product]
WHERE [Name] LIKE 'S%';

Apostrof oznacza ci�g znak�w, wi�c je�eli chcemy wyszuka� dane tekstowe zawieraj�ce
apostrof, musimy poprzedzi� go dodatkowym apostrofem.

Chocia� nie mo�emy por�wnywa� warto�ci NULL z innymi warto�ciami, to mo�emy
sprawdzi�, czy dana warto�� jest nieokre�lona. S�u�y do tego operator IS NULL. Poni�sze
zapytanie zwraca kody produkt�w, kt�re nie maj� okre�lonej daty wycofania ze
sprzeda�y:
SELECT [ProductNumber]
FROM [SalesLT].[Product]
WHERE [SellEndDate] IS NULL;

///////////////////////////////////////////////////Hierarchia operator�w
1. Jako pierwsze wykonywane s� operacje mno�enia i dzielenia.
2. Nast�pnie � dodawania i odejmowania.
3. W trzeciej kolejno�ci wykonywane s� standardowe operacje por�wnania,
takie jak r�wny lub mniejszy ni�.
4. Pierwszym wykonywanym operatorem logicznym jest operator NOT.
5. Nast�pnie wykonywany jest operator AND.
6. Jako ostatnie � operatory SQL (IN, BETWEEN � AND, LIKE) oraz operator OR.
Je�eli wyra�enie zawiera kilka operator�w o tym samym priorytecie, s� one wykonywane
od lewej do prawej.

/////////////////////////////////////////TOP
 Opcjonalna klauzula TOP pozwala ograniczy� wynik zapytania do podanej w niej liczby
wierszy. Docelowa liczba wierszy mo�e by� okre�lona bezwzgl�dnie lub procentowo.
Je�eli wyst�puje w zapytaniu, klauzula TOP musi si� znale�� bezpo�rednio po instrukcji
SELECT, a przed nazwami zwracanych przez zapytanie kolumn.
Kolejno�� wierszy wyniku zapytania mo�emy okre�li� tylko za pomoc� klauzuli ORDER
BY; bez niej klauzula TOP jest niedeterministyczna i praktycznie bezu�yteczna.

Natomiast aby doda� do wyniku dodatkowe, zawieraj�ce powt�rzenia wiersze, nale�y
u�y� rozszerzonej sk�adni TOP � WITH TIES (rozszerzona sk�adnia klauzuli TOP wymaga
u�ycia klauzuli ORDER BY, bez niej serwer bazodanowy zg�osi b��d sk�adni):
SELECT TOP 3 WITH TIES [Name], [ListPrice]
FROM [SalesLT].[Product]
ORDER BY [ListPrice] DESC;

Mo�emy r�wnie� okre�li�, jaki procent wierszy odczytywanej tabeli ma zwr�ci� zapytanie.
Kolejny przyk�ad pokazuje, jak odczyta� dane o 5% najdro�szych produkt�w:
SELECT TOP 5 PERCENT WITH TIES [Name], [ListPrice]
FROM [SalesLT].[Product]
ORDER BY [ListPrice] DESC;

Argumentem klauzuli TOP mog� by� nie tylko sta�e, lecz tak�e zmienne i wyra�enia.

//////////////////////////////////////////////////////////////Stronicowanie wierszy
Mo�liwo�� wybierania wierszy na podstawie ich kolejno�ci pozwala r�wnie� je stronicowa�,
czyli ogranicza� wynik zapytania do wierszy o okre�lonych numerach.
W serwerze SQL klauzule OFFSET (w kt�rej okre�la si� liczb� wcze�niejszych, przeznaczonych
do pomini�cia wierszy) oraz FETCH NEXT (w kt�rej okre�la si� liczb� zwracanych
wierszy) umieszcza si� (co jest zgodne ze standardem ANSI j�zyka SQL) za klauzul�
ORDER BY.
SELECT [Name], [ProductModelID]
FROM [SalesLT].[Product]
ORDER BY [ProductModelID]
OFFSET 15 ROWS
FETCH NEXT 5 ROWS ONLY;	// OPUSC 15 WIERSZY I WYPISZ 5 . 

Technika ta nazywa si� stronicowaniem, bo pozwala zwraca� jedynie podzbi�r wierszy
wyniku, kt�ry ma by� wy�wietlony w danym momencie przez program kliencki.

DECLARE @Strona tinyint = 5	, @Bie��ca tinyint = 2;
SELECT [Name], [ProductModelID]
FROM [SalesLT].[Product]
ORDER BY [ProductModelID] OFFSET (@Strona * (@Bie��ca - 1)) ROWS FETCH NEXT @Strona ROWS ONLY;

Operatory SQL IN oraz BETWEEN � AND pozwalaj� upro�ci� warunki logiczne
i poprawiaj� czytelno�� zapyta�, nie wp�ywaj�c w �aden spos�b na ich wydajno��.

/////////////////////////////////////////////��CZENIE TABEL.
 * SELECT C.Name,P.Name
FROM [SalesLT].[ProductCategory] AS C
JOIN [SalesLT].[Product] AS P				//FROM TABLE1 AS ... JOIN TABLE2 AS ... ON COL1 = COL2.
ON P.ProductCategoryID=C.ProductCategoryID;	//KOLUMNY KLUCZA PODSTAWOWEGO I OBCEGO.

1. W klauzuli SELECT nazwy kolumn zosta�y poprzedzone aliasami nazw tabel.
W innym wypadku pr�ba wykonania zapytania mog�aby si� sko�czy� b��dem.

2. W klauzuli FROM pojawi� si� nowy operator JOIN � ON. Pozwala on na:
a) wymienienie nazw wszystkich odczytywanych tabel;
b) okre�lenie warunk�w ich ��czenia. W tym przypadku do wyniku zapytania
trafi� tylko te wiersze z obu tabel, w kt�rych warto�ci kolumny
ProductCategoryID s� takie same.

Dzia�anie operatora JOIN � ON polega na wygenerowaniu wszystkich mo�liwych
kombinacji wierszy ��czonych tabel, a nast�pnie usuni�ciu z tak otrzymanego zbioru
po�redniego wierszy niespe�niaj�cych warunku z��czenia.

Chocia� mo�na operator JOIN � ON zast�pi� warunkiem WHERE,
to rozwi�zanie takie ma jednak kilka wad:
1. Jest niezgodne ze standardem j�zyka SQL.
2. Pogarsza czytelno�� zapyta�, szczeg�lnie tych z rozbudowan� klauzul� WHERE.
3. W z��czeniach zewn�trznych mo�e by� przyczyn� trudnych do wykrycia b��d�w
logicznych.

Z��czenie tabel na podstawie warto�ci kolumn klucza podstawowego i klucza obcego
nazywa si� z��czeniem naturalnym.

J�zyk SQL pozwala te� na z��czenie tabel na podstawie warto�ci niekluczowych
kolumn. Poniewa� wynik takiego z��czenia nie odzwierciedla naturalnego po��czenia
danych, nazywa si� je z��czeniem nienaturalnym.

Im bardziej znormalizowana baza danych, tym mniej zawiera duplikat�w danych i tym
rzadziej u�ywane s� w niej z��czenia nienaturalne.

Z��czenia nienaturalne, jako odwo�uj�ce si� do kolumn, kt�re mog� zawiera� powtarzaj�ce si� warto�ci,
s� niejednoznaczne. W skrajnym przypadku taki warunek z��czenia nie wyeliminuje
z wyniku zapytania �adnych wierszy. I tak powy�sze z��czenie licz�cej
847 wierszy tabeli [SalesLT].[Customer] z zawieraj�c� 450 wierszy tabel� [SalesLT].
[Address] zwr�ci�o a� 36 864 rekordy.

Odwo�uj�c si� do wi�cej ni� jednej tabeli, powinni�my nadawa� aliasy wszystkim tabelom
i konsekwentnie u�ywa� ich w ca�ym zapytaniu:
W klauzuli ON r�wnie� nie mo�emy pos�u�y� si� oryginalnymi nazwami tabel,
dla kt�rych zdefiniowane zosta�y aliasy.

Wyniki zapyta� ze z��czeniem r�wno�ciowym zawieraj�
te wiersze z��czonych tabel, w kt�rych warto�ci u�ytych do z��czenia kolumn s�
takie same.

Tabele mog� by� te� ��czone na podstawie warunk�w z��cze� zawieraj�cych inne
operatory por�wnania ni� =, np. operator > � takie z��czenia nazywane s� nier�wno�ciowymi.

Chocia� wydaje si�, �e poni�sze zapytanie zwraca informacje o produktach
sprzedanych za cen� ni�sz� ni� warto�� zam�wienia, to w rzeczywisto�ci zwraca
ono po��czone ze sob� w trybie ka�dy z ka�dym, spe�niaj�ce ten warunek wiersze obu
tabel:
SELECT H.SalesOrderID, H.SalesOrderNumber, D.LineTotal, H.SubTotal
FROM [SalesLT].[SalesOrderHeader] AS H
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.LineTotal<H.SubTotal;

Z��czenia nier�wno�ciowe s� bardzo rzadko u�ywane � jednym z ich nielicznych zastosowa�
jest analiza danych polegaj�ca na wyszukiwaniu istniej�cych mi�dzy tymi danymi
zale�no�ci.Poniewa� wyniki takich z��cze� zawieraj� mn�stwo powt�rzonych wierszy,
z��czenia nier�wno�ciowe z regu�y wyst�puj� razem ze z��czeniami naturalnymi:
SELECT H.SalesOrderID, H.SalesOrderNumber, D.LineTotal, H.SubTotal
FROM [SalesLT].[SalesOrderHeader] AS H
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.SalesOrderID=H.SalesOrderID
AND D.LineTotal<H.SubTotal;
///////////////////////////////////////////////////Z�A�ZENIA ZEWN�RZNE
 
SELECT ProductNumber, C.Name
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON C.ProductCategoryID=P.ProductCategoryID
WHERE P.Color = 'WHITE';
Poniewa� klauzula ON r�wnie� filtruje wiersze (�eby produkt trafi� do wyniku zapytania,
w tabeli [SalesLT].[ProductCategory] musi istnie� powi�zany z nim rekord), zapytanie
to nie zwraca wszystkich bia�ych produkt�w.


Wszystkie om�wione do tej pory z��czenia by�y z��czeniami wewn�trznymi � ich
wyniki zawiera�y tylko wiersze spe�niaj�ce podany w nich warunek z��czenia.

Z��czenie zewn�trzne, czyli takie, kt�re zwr�ci r�wnie� niepasuj�ce (tj. niemaj�ce odpowiednika w powi�zanej
tabeli) wiersze.

Lewostronne z��czenie zewn�trzne (LEFT OUTER JOIN) powoduje pozostawienie w wyniku
niepasuj�cych wierszy z pierwszej (lewej) tabeli. Poniewa� te wiersze nie maj� swoich
odpowiednik�w w z��czonej tabeli, w kolumnach wyniku zwracaj�cego dane z drugiej
(prawej) tabeli zostanie wstawiona warto�� NULL.
Tym razem wynik zapytania zawiera numery wszystkich produkt�w, w tym nienale��cego
do jakiejkolwiek kategorii.

Tak jak lewostronne z��czenie zewn�trzne dodaje do wyniku zapytania niepasuj�ce
wiersze z tabeli, kt�rej nazwa jest podana jako pierwsza, tak prawostronne z��czenie
zewn�trzne (RIGHT OUTER JOIN) dodaje niepasuj�ce wiersze z prawej tabeli. Czyli
zmieniaj�c kolejno�� tabel w klauzuli FROM, mo�emy zast�pi� z��czenie lewostronne
r�wnowa�nym z��czeniem prawostronnym.

Obustronne z��czenia zewn�trzne (FULL OUTER JOIN) zwracaj� wszystkie wiersze obu
z��czonych tabel, w tym te, kt�re nie spe�niaj� warunku z��czenia.

Z��czenie krzy�owe
(iloczyn kartezja�ski)

Poniewa� przy z��czeniu krzy�owym nie okre�la si� warunku z��czenia (bo wynik ma
zawiera� wszystkie mo�liwe po��czenia wierszy), mo�emy w ten spos�b z��czy� dowolne
dwie tabele:
SELECT P.Name, C.FirstName
FROM [SalesLT].[Product] AS P
CROSS JOIN [SalesLT].[Customer] AS C;

Wynik z��czenia krzy�owego zawiera mn�stwo powt�rze� � imi� ka�dego klienta
zosta�o powt�rzone 296 razy (tyle wierszy liczy�a tabela [SalesLT].[Product]), a nazwa
ka�dego towaru 847 razy (tylu jest klient�w). W rezultacie zapytanie to zwr�ci�o
250 712 (296 * 847 = 250 712) wierszy.

Poniewa�
tak otrzymane dane s� w wi�kszo�ci wynikiem przypadkowego po��czenia wierszy,
z��czenia krzy�owe s� u�ywane przede wszystkim do:
1. Generowania danych testowych. Wynik poni�szego zapytania zawiera
250 tysi�cy kombinacji kod�w (zwr�� uwag�, �e s�owo kluczowe CROSS JOIN
mo�e by� pomini�te):
SELECT [ProductNumber], C.[rowguid]
FROM [SalesLT].[Product], [SalesLT].[Customer] AS;

2. Poprawy wydajno�ci podzapyta� zawieraj�cych kilka funkcji grupuj�cych.

/////////////////////////////////////////////////////////Z��czenia wielokrotne 

W jednym zapytaniu mo�emy si� odwo�a� do wi�cej ni� dw�ch tabel.
Niezale�nie od tego, do ilu tabel si� odwo�ujemy, serwery bazodanowe zawsze ��cz�
ze sob� dwie tabele.
SELECT C.LastName, P.Name
FROM [SalesLT].[Customer] AS C
JOIN [SalesLT].[SalesOrderHeader] AS H
ON C.CustomerID=H.CustomerID
JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.SalesOrderID=H.SalesOrderID
JOIN [SalesLT].[Product] AS P
ON D.ProductID=P.ProductID
ORDER BY C.LastName;

W z��czeniach r�wno�ciowych kolejno�� ��czenia tabel nie ma �adnego wp�ywu na
wynik zapytania.Natomiast w przypadku z��cze� zewn�trznych klauzula ON wykonywana
po dodaniu niepasuj�cych wierszy z powrotem usuwa je z wyniku.

SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.ProductID=P.ProductID
JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID;

Kolejno�� wykonywania operacji ��czenia jest ustalana przez optymalizator i nie wynika
z kolejno�ci, w jakiej nazwy tabel zosta�y wymienione w klauzuli FROM. Wynik tego
zapytania nie zawiera wi�c informacji o niesprzedanych produktach, kt�re pocz�tkowo
dodane zosta�y z niego usuni�te w trakcie wykonywania drugiej klauzuli ON.

Problem ten mo�na rozwi�za� na dwa sposoby:
1. ��cz�c zewn�trznie wszystkie tabele. Wad� tego rozwi�zania jest to, �e gdyby
w kolejnych tabelach (w tym przypadku w tabeli [SalesLT].[SalesOrderHeader)
r�wnie� znajdowa�y si� wiersze niepasuj�ce do wierszy z ostatniej ��czonej
tabeli, one tak�e znalaz�yby si� w wyniku zapytania:
SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN [SalesLT].[SalesOrderDetail] AS D
ON D.ProductID=P.ProductID
LEFT JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID;

2. Okre�laj�c za pomoc� nawias�w kolejno��, w jakiej tabele powinny by�
po��czone. Je�eli z��czenie zewn�trzne b�dzie wykonane jako ostatnie
(co wymaga przeniesienia okre�laj�cej warunek tego z��czenia klauzuli ON
poza nawias), niepasuj�cy wiersz znajdzie si� w wyniku zapytania:
SELECT P.ProductNumber, D.SalesOrderID, H.TotalDue
FROM [SalesLT].[Product] AS P
LEFT OUTER JOIN
(
[SalesLT].[SalesOrderDetail] AS D
JOIN [SalesLT].[SalesOrderHeader] AS H
ON D.SalesOrderID=H.SalesOrderID
)
ON D.ProductID=P.ProductID;

/////////////////////////////////////////////////Z��czenie tabeli z ni� sam�
Z��czenie tabeli z ni� sam� jest wykonywane w taki sam spos�b jak omawiane
do tej pory z��czenia r�nych tabel. Chocia� serwery bazodanowe nie tworz� kopii
z��czonej tabeli, to wszystkie operacje przeprowadzane s� tak, jakby dotyczy�y dw�ch
identycznych tabel.

SELECT P1.ProductNumber // Musi znalezc sie tu poprzedzona nazwa tabeli a raczej aliasu nazwa kolumny . 
FROM [SalesLT].[Product] AS P1	// Nadajemy aliasy tabeli i jej kopii. 
CROSS JOIN [SalesLT].[Product] AS P2;

Z��czenia tabel z nimi samymi s� cz�sto wykonywane w celu analizy danych. Na
przyk�ad poni�sze zapytanie zwraca dane towar�w, kt�re s� co najmniej sze�ciokrotnie
ta�sze ni� jakikolwiek inny towar z tej samej kategorii:
SELECT P1.ProductID, P1.ListPrice, P2.ProductID, P2.ListPrice
FROM [SalesLT].[Product] AS P1
JOIN [SalesLT].[Product] AS P2
ON P1.ProductCategoryID=P2.ProductCategoryID
WHERE P1.ListPrice*6 <P2.ListPrice
ORDER BY P1.ProductID;

Skoro najcz�stszym typem z��cze� s� z��czenia naturalne, to tabela przewa�nie jest
z��czana z ni� sam�, je�eli w jej obr�bie wyst�puje relacja klucz podstawowy � klucz
obcy.

/////////////////////////////////////////////////��czenie wynik�w zapyta�
Opr�cz tabel j�zyk SQL pozwala r�wnie� ��czy� wyniki zapyta�. O ile ��czenie tabel
polega na dodawaniu do wyniku zapytania dodatkowych, pochodz�cych ze z��czonych
tabel kolumn, o tyle ��czenie wynik�w polega na dodawaniu (lub usuwaniu) wierszy
zwr�conych przez z��czone zapytania.

��czone wyniki zapyta� musz� si� sk�ada� z tej samej liczby kolumn, a odpowiadaj�ce
sobie kolumny musz� by� tych samych albo umo�liwiaj�cych niejawn� konwersj�
typ�w.

Doda� do siebie wyniki zapyta� mo�emy za pomoc� operatora UNION.
SELECT [Name]
FROM [SalesLT].[Product]
UNION
SELECT [Name]
FROM [SalesLT].[ProductCategory];	// Srednik po ostatnim zapytaniu !
ORDER BY 1;

Klauzula ORDER BY moze wystapic tylko w ostatnim zapytaniu . 

Operator UNION powoduje usuni�cie z wyniku powt�rzonych wierszy!

Jako �e nazwy kolumn z��czonych wynik�w zapyta� nie musz� by� takie same, w klauzuli
ORDER BY najcz�ciej u�ywa si� ich numer�w, a nie nazw.

Je�eli chcemy tylko z��czy� ze sob� wyniki zapyta�, bez eliminowania ewentualnych
duplikat�w, albo je�eli mamy pewno��, �e ��czone wyniki s� roz��czne6, powinni�my
u�y� operatora UNION ALL � takie ��czenie wynik�w zapyta�, jako niewymagaj�ce
wyszukiwania i usuwania powtarzaj�cych si� wierszy, jest znacznie szybsze.

Operator INTERSECT zwraca cz�� wsp�ln� wynik�w dw�ch zapyta�, a wi�c tylko te
wiersze, kt�re zosta�y zwr�cone przez oba zapytania.
SELECT [AddressID]
FROM [SalesLT].[Address]
INTERSECT
SELECT [CustomerID]
FROM [SalesLT].[Customer];

Chocia� standard SQL3 uwzgl�dnia operatory INTERSECT ALL i EXCEPT ALL, to jednak
�aden serwer bazodanowy ich nie implementuje. Spowodowane jest to tym, �e
usuwanie wierszy na podstawie nie pojedynczego ich wyst�pienia, ale wielokrotnego
powt�rzenia jest ma�o intuicyjne i prowadzi do b��d�w logicznych.

Operator EXCEPT zwraca te wiersze, kt�re znalaz�y si� wy��cznie w wyniku pierwszego
zapytania i nie by�o ich w wyniku drugiego zapytania.

SELECT [AddressID]
FROM [SalesLT].[Address]
EXCEPT
SELECT [CustomerID]
FROM [SalesLT].[Customer];

W przeciwie�stwie do sumy i opisanej powy�ej cz�ci wsp�lnej operator EXCEPT jest
asymetryczny � zmiana kolejno�ci zapyta� spowoduje zmian� wyniku.

Zapytania nie musz� odczytywa� danych bezpo�rednio z tabel � w wielu produkcyjnych
bazach danych bezpo�redni dost�p do tabel jest wr�cz niemo�liwy (ze
wzgl�d�w bezpiecze�stwa i dla poprawy wydajno�ci zapyta�), a u�ytkownicy odczytuj�
i modyfikuj� dane za po�rednictwem widok�w, procedur lub funkcji.

Funkcje tabelaryczne zwracaj� dane w postaci tabel, dlatego mo�emy je wywo�a� w klauzuli FROM . 

G��wna r�nica mi�dzy odczytywaniem danych poprzez widok a odczytywaniem
ich poprzez funkcj� tabelaryczn� polega na tym, �e widoku nie mo�na wywo�a�
z parametrami.
SELECT *
FROM [dbo].[ufnGetCustomerInformation](1);		// funkcja tabelaryczna . 

SELECT *
FROM [SalesLT].[vGetAllCategories];				// Widok.

Operator APPLY umo�liwia wywo�anie dla ka�dego wiersza pierwszej (lewej) tabeli
dowolnego wyra�enia zwracaj�cego dane w postaci tabelarycznej, np. podzapytania
albo funkcji tabelarycznej.

SELECT C.[CustomerID], F.*
FROM [SalesLT].[Customer] AS C
CROSS APPLY [dbo].[ufnGetCustomerInformation](C.[CustomerID]) AS F
WHERE C.Title = 'Ms.';

Operator CROSS APPLY odpowiada z��czeniu wewn�trznemu, a wi�c eliminuje z wyniku
zapytania te wiersze, dla kt�rych funkcja zwr�ci�a warto�ci NULL.

J�zyk SQL pozwala jednak na do��czenie do wyniku zapytania tych wierszy, dla kt�rych funkcja tabelaryczna
zwr�ci�a warto�� NULL, a wi�c uzyskanie efektu podobnego do z��czenia zewn�trznego.
W tym celu operator CROSS APPLY nale�y zast�pi� operatorem OUTER APPLY:

SELECT C.FirstName, C.[CustomerID], F.*
FROM [SalesLT].[Customer] AS C
OUTER APPLY [dbo].[udfLastOrders](C.[CustomerID],2) AS F;

////////////////////////////////////////Funkcje grupuj�ce
Grupowanie danych polega na ��czeniu wielu wierszy w jeden.
Charakterystyczn� cech� funkcji grupuj�cych jest operowanie na zbiorach, a nie
pojedynczych warto�ciach. Funkcje grupuj�ce zwracaj� pojedyncze (skalarne)
warto�ci, wi�c wywo�uje si� je w klauzuli SELECT, tak jak wcze�niej poznane funkcje
systemowe.

Funkcja COUNT() zwraca liczb� przekazanych jako argument wywo�ania warto�ci. U�ywa
si� jej do sprawdzenia liczebno�ci grupy lub policzenia wierszy tabeli.
Domy�lnie funkcje grupuj�ce s� wywo�ywane dla wszystkich warto�ci w grupie
z wyj�tkiem warto�ci NULL.

SELECT COUNT(DISTINCT CustomerID)	// Dostaniemy rozne id konsumentow .Piszac DISTINCT COUNT()... dostaniemy rozne wyniki zliczenia , a w zasadzie jeden - 33.
FROM [SalesLT].[SalesOrderHeader];
Funkcje grupuj�ce mog� by� te� wywo�ywane tylko dla warto�ci niepowtarzaj�cych
si� w grupie.

Funkcja COUNT() mo�e by� wywo�ana z * jako argumentem � zwraca wtedy liczb�
wierszy tabeli lub grupy.Wyj�tkowo�� sk�adni COUNT(*) polega na tym, �e zliczane s� nie tylko duplikaty
wierszy, lecz tak�e puste wiersze, czyli funkcja COUNT() wywo�ana z * jako jedyna
funkcja grupuj�ca uwzgl�dnia warto�� NULL. Z tego powodu symbolu * nie mo�na poprzedzi�
s�owem kluczowym DISTINCT. 

Funkcje SUM() i AVG()
Argumentami funkcji SUM() i AVG() mog� by� tylko liczby,funkcje te ignoruj� warto�� NULL.
SELECT SUM([ListPrice]), AVG([ListPrice])
FROM [SalesLT].[Product];

Funkcje MIN() i MAX()
Argumentami funkcji MIN() i MAX() mog� by� opr�cz danych liczbowych dane daty
i czasu oraz tekstowe.

CHECKSUM_AGG(), kt�rej argumentem musz� by� liczby ca�kowite,
zwraca sum� kontroln� warto�ci w grupie (ta funkcja jest u�ywana g��wnie
do por�wnywania grup, np. sprawdzenia, czy nie zmieni�y si� ceny produkt�w):
SELECT CHECKSUM_AGG([SalesOrderID]), CHECKSUM_AGG(CAST([UnitPrice] AS INT))
FROM [SalesLT].[SalesOrderDetail];

COUNT_BIG() od funkcji COUNT() r�ni si� tylko typem zwracanych
warto�ci � w jej przypadku liczba wierszy w grupie jest zwracana jako dane
typu BIGINT.

STDEV() zwraca odchylenie standardowe warto�ci w grupie.

VAR() zwraca wariancj� warto�ci w grupie.

Funkcje grupuj�ce mog� by� cz�ci� dowolnych wyra�e�,
o ile tylko te wyra�enia s� poprawne sk�adniowo:
SELECT MAX([ListPrice]) - MIN( [ListPrice]),
MAX([ListPrice]) - AVG( [ListPrice])
FROM [SalesLT].[Product];

Argumentami funkcji grupuj�cych r�wnie� mog� by� wyra�enia. Na przyk�ad mo�emy
policzy� �redni� z cen brutto produkt�w (cen pomno�onych przez 1,23):
SELECT AVG([ListPrice]*1.23)
FROM [SalesLT].[Product];

Zagnie�d�anie funkcji grupuj�cych
Standard SQL3 nie zezwala na zagnie�d�anie funkcji grupuj�cych, tak wi�c argumentem
funkcji grupuj�cej nie mo�e by� wynik innej funkcji grupuj�cej:
SELECT AVG(SUM([ListPrice]))
FROM [SalesLT].[Product];

Funkcje grupuj�ce mog� by� wywo�ywane dla okre�lonych grup, a nie tylko dla ca�ych
tabel. Podzia� wierszy na logiczne grupy umo�liwia w�a�nie klauzula GROUP BY.

Na przyk�ad �eby odczyta� �redni� cen� i liczb� towar�w nale��cych do poszczeg�lnych
kategorii, nale�y pogrupowa� wiersze na podstawie identyfikatora lub nazwy
kategorii i wyliczy� �redni� dla ka�dej grupy.
SELECT AVG([ListPrice]) AS �rednia,
COUNT([ProductID]) AS Liczba
FROM [SalesLT].[Product]
GROUP BY [ProductCategoryID];

Je�eli zapytanie zawiera klauzul� GROUP BY,
w klauzuli SELECT dopuszczalne s� wy��cznie funkcje grupuj�ce oraz nazwy kolumn
lub wyra�enia u�yte do pogrupowania danych, czyli wyst�puj�ce w klauzuli GROUP BY.
SELECT [ProductCategoryID],AVG([ListPrice]), [Name]
FROM [SalesLT].[Product]
GROUP BY [ProductCategoryID]; 	// nie zadzia�a . 


SELECT LEFT([Color],1), COUNT(*)	// Wypisze tylko pierwsze litery kolorow i wzgledem tych pierwszych liter odbedzie sie grupowanie .
FROM [SalesLT].[Product]
GROUP BY LEFT([Color],1);

Klauzula GROUP BY umo�liwia r�wnie� tworzenie podgrup. Przypu��my, �e chcemy
pozna� liczb� oraz �redni� cen� produkt�w z poszczeg�lnych kategorii z rozbiciem na
kolory tych produkt�w. W tym celu musimy w klauzuli GROUP BY umie�ci� nazw� dodatkowej
kolumny:
SELECT C.Name, P.Color, COUNT(*) AS Liczba, AVG(ListPrice) AS �rednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY C.Name, P.Color
ORDER BY C.Name;

Kolejno�� wykonywania klauzuli
1. Jako pierwsza wykonywana jest klauzula FROM. Je�eli zapytanie odwo�uje si�
do wielu tabel, s� one kolejno ze sob� z��czane.
2. Otrzymany w ten spos�b zbi�r po�redni jest filtrowany na podstawie warunku
logicznego umieszczonego w klauzuli WHERE. Tylko te wiersze, dla kt�rych jest
on prawdziwy, trafiaj� do kolejnego zbioru po�redniego.
3. Nast�pnie wykonywana jest klauzula GROUP BY, czyli grupowane s� tylko
przefiltrowane wiersze.
4. Po zgrupowaniu wykonywana jest klauzula SELECT.
5. W dalszej kolejno�ci serwer sortuje wiersze, czyli wykonywana jest
klauzula ORDER BY.
6. Na ko�cu, podczas wykonywania klauzuli TOP, liczba wierszy wyniku
zapytania zostaje ograniczona.

!W klauzuli WHERE nie mo�na umie�ci� funkcji grupuj�cych
gdy� podczas wykonywania tej klauzuli dane nie s� jeszcze pogrupowane.
!Wiersze wyeliminowane w klauzuli WHERE nie zostan� pogrupowane . 
!Dane s� najpierw grupowane, a potem sortowane, czyli w klauzuli
ORDER BY mo�emy umie�ci� tylko kolumny lub wyra�enia u�yte do grupowania
b�d� funkcje grupuj�ce.

Operatory CUBE i ROLLUP maj� ograniczon� funkcjonalno�� � te same rezultaty,
ale szybciej i z pe�n� mo�liwo�ci� kontrolowania tworzonych podsumowa� oferuje
operator GROUPING SETS. Z tych powod�w operatory CUBE i ROLLUP nie powinny by�
u�ywane w nowych aplikacjach.

Mo�emy doda� do wyniku zapytania sumy po�rednie � s�u�y do tego operator ROLLUP.
Operator ROLLUP doda� podsumowania dla grup utworzonych na podstawie warto�ci
pierwszej z kolumn wymienionych w klauzuli GROUP BY. Dodane przez niego wiersze
zawieraj� warto�ci NULL w kolumnach u�ytych do grupowania, natomiast w ostatniej
kolumnie tych wierszy znajdziemy sumy po�rednie : 

SELECT C.Name, P.Color, COUNT(*) AS Liczba, SUM(ListPrice) AS �rednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY ROLLUP (C.Name, P.Color)
ORDER BY C.Name;
------------------------------------------------------------
Name 			Color 		Liczba 		�rednia
Mountain Bikes 	Black 		16 			27404,84
Mountain Bikes 	Silver 		16			26462,84
Mountain Bikes 	NULL 		32 			53867,68
Mountain Frames Black 		14 			9391,99
Mountain Frames Silver 		14 			9599,11
Mountain Frames NULL 		28 			18991,10
Panniers 		Grey 		1 			125,00
Panniers 		NULL 		1 			125,00

Dzi�ki operatorowi CUBE mo�emy unikn�� pisania wielu
wersji tego samego zapytania � jego dzia�anie polega bowiem na dodaniu do wyniku
zapytania podsumowa� dla wszystkich mo�liwych kombinacji grup i podgrup:

SELECT C.Name, P.Color, COUNT(*) AS Liczba, SUM(ListPrice) AS �rednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;
------------------------------------------------------------
Name Color Liczba �rednia
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

Dodatkowe dziesi�� wierszy dodanych
przez operator CUBE zawiera sumy po�rednie policzone dla kolor�w, np. drugi wiersz
zawiera liczb� i sum� cen wszystkich czarnych produkt�w, niezale�nie od kategorii,
do jakiej one nale��. Dodane przez operator CUBE wiersze z podsumowaniami mo�na
rozpozna� po warto�ciach NULL wyst�puj�cych w kolumnach, wed�ug kt�rych pogrupowane
zosta�y dane:
1. Warto�� NULL w kolumnie Color oznacza podsumowanie dla koloru.
2. Warto�� NULL w kolumnie Name � podsumowanie dla kategorii.
3. Warto�� NULL w obu u�ytych do grupowania kolumnach oznacza podsumowanie
ca�ego zapytania.

Oznaczanie dodatkowych grup za pomoc� warto�ci NULL jest niejednoznaczne � gdyby
w u�ytych do grupowania kolumnach wyst�powa�a warto�� nieokre�lona, wiersze z warto�ci�
NULL by�yby nie do odr�nienia od wierszy zawieraj�cych sumy po�rednie.
Serwer SQL rozwi�zuje ten problem za pomoc�:
1. Funkcji GROUPING(), kt�ra zwraca 1, je�eli dany wiersz zawiera podsumowania
dodane do wyniku przez operatory CUBE lub ROLLUP, i 0, je�eli dany wiersz
zawiera warto�ci wyliczone dla danej grupy:

SELECT C.Name, GROUPING(C.Name) AS ByName,
P.Color, GROUPING(P.Color) AS ByColor,
AVG(ListPrice) AS �rednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;

2. Funkcji GROUPING_ID(), kt�ra zwraca numer poziomu podsumowania, przy
czym 0 oznacza wiersz zawieraj�cy warto�ci wyliczone dla grupy, a najwi�kszy
numer � wiersz zawieraj�cy podsumowanie ca�ego zapytania:
SELECT C.Name, GROUPING_ID(C.Name,P.Color) AS GroupLevel,
P.Color, AVG(ListPrice) AS �rednia
FROM [SalesLT].[Product] AS P
JOIN [SalesLT].[ProductCategory] AS C
ON P.ProductCategoryID=C.ProductCategoryID
GROUP BY CUBE (C.Name, P.Color)
ORDER BY C.Name;

Mo�liwo�� zdefiniowania wielu metod grupowania tych samych danych daje nam
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

Powy�sza instrukcja jest r�wnowa�na tej : 
SELECT a, b, c, SUM(x) AS sumx
FROM #T
GROUP BY
GROUPING SETS (a, (b), (a, b, c));	// Poszczeg�lne metody grupowania danych s� uj�te w nawiasy i oddzielone przecinkami . 	

Podsumowuj�c � klauzula GROUP BY umo�liwia wskazanie jednego porz�dku grupowania,
a operator GROUPING SETS rozszerza jej funkcjonalno��, umo�liwiaj�c zdefiniowanie
w jednym zapytaniu wielu r�nych porz�dk�w grupowania.

Serwer SQL pozwala na przekszta�canie wierszy w kolumny i odwrotnie, czyli na
prac� z tabelami przestawnymi. Pierwsza operacja pozwala poprawi� czytelno��
wynik�w zapyta�, grupuj�cych dane (zmniejszaj�c liczb� wierszy, poprawiamy czytelno��
raport�w), druga � dostosowa� dane pochodz�ce z arkuszy kalkulacyjnych do
struktury tabel bazodanowych.

Serwery bazodanowe pozwalaj� okre�li� dodatkowy porz�dek grupowania w klauzuli
OVER. Zdefiniowane w tej klauzuli grupy s� nazywane partycjami i mog� by� u�yte do
wywo�ania funkcji grupuj�cych oraz funkcji rankingu, okienkowych i analitycznych.

































 */
