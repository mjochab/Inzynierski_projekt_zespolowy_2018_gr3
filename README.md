# Inzynierski_projekt_zespolowy_2018_gr3

**Celem programu** jest stworzenie biura podróży jako wyszukiwarki ofert wycieczek, turnusów, lotów które będą wprowadzone za pośrednictwem biura turystycznego i firmy lotniczej, a odbiorcą będzie klient wyszukujący odpowiedniej dla siebie wycieczki, turnusu czy też samodzielnego lotu. Założenie projektu jest stworzyć funkcyjny serwis biura podróży do którego będą mieli dostęp klienci, pracownicy biura turystycznego, pracownicy linii lotniczych, oraz agenci. Każdy z nich będzie miał swoje role w programie. Zarządzać całym programem będzie Administrator (biuro podróży). 




**Opis uprawnień:**

**Administrator:**
Ma możliwość zarządzania całą aplikacją. Może dodawać klientów do systemu, zarządzać nimi (zmieniać im rolę czy też ich usuwać). Może dodawać firmy lotnicze, agentów. Administrator pełni funkcję biura podróży. Może zarządzać lotami, turnusami, wycieczkami. Dodawać je, usuwać. 

**Agencja:**
Pracownik agencji posiada możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się okienko, na którym może wykonywać przydzielone zadania. Agent ma możliwość podglądu biletów udostępnionych przez firmę lotniczą i biuro turystyczne odpowiednio co do lotów, wycieczek i turnusów i ma możliwość rezerwowania biletów i generowania ich do PDF dla klientów, za co Agent otrzymuję zarobioną prowizję za sprzedane bilety którą może podejrzeć sobie w menu „Program partnerski”. 


**Biuro turystyczne:**
Biuro turystyczne w aplikacji powinno posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się okienko na którym może wykonywać przydzielone zadania. Biuro turystyczne ma możliwość zarządzania turnusami i wycieczkami. Może je dodawać, jak i usuwać. 


**Firma lotnicza:** 
Firma lotnicza po zalogowaniu się do aplikacji ma możliwość zarządzania lotami (dodawanie ich i usuwanie) i podglądu aktualnie dostępnych biletów na loty.


**Klient:**
Klient w aplikacji po poprawnym zalogowaniu ma możliwość przejrzenia dostępnych biletów na lot (jeśli go interesuję sam przelot a wycieczkę ma zapewnioną samodzielnie) lub też wybrania wycieczki/turnusu przygotowanego przez biuro turystyczne. Ma możliwość rezerwacji oraz wygenerowania biletu do PDF.  


**Zastosowane technologie:**

**JavaFX** - rozszerza potencjał platformy Java, pozwalając programistom na używanie bibliotek środowiska Java w aplikacjach JavaFX. W ten sposób programiści mogą poszerzyć swoje możliwości względem platformy Java i skorzystać z technologii prezentacji, jaką oferuje JavaFX, umożliwiając konstruowanie środowisk o atrakcyjnej szacie graficznej. Użytkownicy mogą uruchamiać aplikacje JavaFX w przeglądarce lub przeciągać je na pulpit. Umożliwia programistom integrację grafiki wektorowej, animacji, sieciowych zasobów dźwiękowych oraz wideo w procesie tworzenia bogatych, interaktywnych i złożonych aplikacji. Rozszerza technologię Java, umożliwiając korzystanie z dowolnej biblioteki Java w aplikacjach JavaFX.


**Gradle** - jest narzędziem służącym do budowania projektów. Umożliwia pisanie skryptów. Gradle pozwala na tworzenie zależności między zadaniami (taskami).


**Hibernate** - jest open sourcowym projektem, którego celem było stworzenie nowego podejścia do łączenia się z bazą danych oraz wykonywania na niej operacji minimalizując tym samym ilość pisanego kodu. Szeroki wachlarz jego możliwości sprawia, że jest on bardzo często wykorzystywany w dużych aplikacjach webowych opartych na relacyjnych bazach danych (SQL), w których możemy w pełni wykorzystać potencjał tego frameworka. Najbardziej charakterystyczną cechą, dzięki której Hibernate zyskuje cały czas na popularności jest wykorzystywany przez niego standard JPA, czyli model mapowania obiektowo-relacyjnego.


**MySQL** – Oprogramowanie bazodanowe typu open source. Jest ono dostępne bezpłatnie na licencji GPL, dzięki czemu mamy wolność do uruchamiania aplikacji w dowolnym celu, analizowania jej i dostosowywania do własnych potrzeb, a także do rozpowszechniania. Serwer MySQL dostępny jest dla wszystkich popularnych platform systemowych i różnorakich architektur procesorów. 


## Diagramy UML: 


**Diagram przypadków użycia** ![diagram1](https://i.imgur.com/oNqJFPP.png)

**Diagram aktywności** ![diagram2](https://imgur.com/iOiEn95.png)

**Diagram sekwencji** ![diagram3](https://imgur.com/40jS2BW.png)

**Diagram klas** ![diagram4](https://i.imgur.com/bQ5STKv.png)
