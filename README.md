Zadatak:  Aplikaciju za Auto servise.

- Tehnologije: Springboot, Thymeleaf, PostgresSQl baza (tocno te tehnologije, bez javascripta)

U aplikaciji treba moći:

1.  Dodavati/brisati/editirati klijente. 
     - Osim forme za editiranje podataka klijenta, treba napraviti i prikaz detalja klijenta, koji nije u obliku forme, vec samo tekstualno prikazani podaci (moze kao tablica da bi sve bilo lijepo poravnato)
            :
        - OIB
        - Ime i Prezime
        - Adresa (Ulica i  broj, poštanski broj , Grad, Država) 
            (hint: pokušajte to napraviti kao Embedable, )
            https://en.wikibooks.org/wiki/Java_Persistence/Embeddables#Example_of_an_embedded_relationship_annotations
        - Lista automobila
        - Nakon sto se unese novi klijent ili editira postojeci, treba prikazati stranicu sa detaljima klijenta.
        Naslov iznad forme neka bude "Uređivanje klijenta"
        
    - Napraviti stranicu sa izlistom klijenata
        - U listi su prezimena i imena klijenata, abecedno po prezimenu
        - klik na ime vodi na stranicu s detaljima klijenta
        - pored imena klijenta su buttoni  "Uredi" (vodi na formu za editiranje klijenta) i "Obriši" (briše klijenta i sve njegove automobile)
        - ispod liste button za dodavanje novog klijenta
        pored  pojedinog klijenta, buttoni za )
       
 
2. Dodavanje automobila

    - Na prikazu detalja klijenta (definirano u tocki 1) treba prikazati i listu automobila koje  klijent posjeduje i servisira. Ispod liste (koja ce inicijalno biti prazna) treba biti button "Dodaj automobil", a klik na taj biuton otvara novu stranicu (formu ) za unos podataka automobla.
    - Automobil mora imati sljedeće podatke
        - Klijent kojem pripada (dropdown lista, inicijalno odabran onaj klijent s cijih detalja je klinuto na "Dodaj automobi", ali moze se promjeniti)
        - Tip automobila (tipove automobila ne morate spremati u bazu, dovoljno je imati enum sa listom tipova (dodajte 10-ak komada))
            enum vrijednosti za tip automobila neka budu skraceni nazivi, npr: TOYOTA_AURIS, s time da ima property-e manufacturer i model koji imaju gettere/settere a u ovom slucaju bi vrijednosti bile za manufacturer "Toyota" a za model "Auris"
        - Godina proizvodnje 
        - Registracijska oznaka
        - Boja
    - Naslov iznad forme neka bude "Uređivanje automobila" 
    - Kada se doda automobil (submita se forma), neka se vraća  na stranicu detalja klijenta za kojeg smo dodali taj automobil.
    Tada se na toj stranici, u listi automobila klijenta treba vidjeti unešeni automobil. 
    - Na toj listi  automobila ispisivati proizvođača i model (iz onog enuma za tip automobila), to neka ujedno bude i link na stranicu sa detaljima automobila. Pokraj tog linka dodati dva buttona: "Uredi" i "Obriši". Uredi otvara formu za editiranje podataka automobila, a Briši ga briše. 
    - RELACIJU AUTOMOBIL-KLIJENT NAPRAVITE BIDIRECTIONAL (DA KLIJENT ENTITY IMA LISTU AUTOMOBILA A AUTOMOBIL IMA REFERENCU NA KLIJENTA KOJEM PRIPADA)


3. Dodavanje servisa
    - Na stranici detalja automobila (definiranoj u točki 2) uz podatke o automobilu treba dodati i listu napravljenih servisa. Ispod liste (koja je inicijalno prazna) imamo button "Dodaj servis info"
    - Klik na taj button otvara formu za dodavanje Servisa koji treba imati sljedeće podatke:
        - Datum i vrijeme servisa
        - Ime i prezime radnika koji je napravio servis
        - Opis radova
        - Cijena
        - Informacija da li je plaćeno ili ne (checkbox)
    - Naslov iznad forme neka bude "Servis za automobil XXXXX , YYYYY". XXXXX neka bude tip automobila (proizvođać i model), a YYYYY ime i prezime klijenta
    - Nakon submita forme treba se vratiti na stranicu detalja automobila.
    - Dodani servis se treba prikazati na toj stranici u listi servisa. Za svaki servis u listi ispisati Datum i vrijeme kad je napravljen i ime radika koji je obavio servis. Svaki taj item u listi ujedno je i link na stranicu detalja servisa gdje se ispisutu svi podaci o servisu (tablica s tekstom)
    - Pokraj linka treba dodati buttone "Uredi" (vodi na edit formu za servis) i "Obriši" (briše servis iz baze)
    - RELACIJU SERVIS-AUTOMOBIL NAPRAVITE BIDIRECTIONAL (DA AUTOMOBIL ENTITY IMA LISTU SERVVISA A SERVIS IMA REFERENCU NA AUTOMOBIL ZA KOJI JE NAPRAVLJEN)
4. Napravity Homepage na kojem će se prikazati zadnjih 10 napravljeni servisa (po vremenu, najnoviji na vrhu)

5. (OPCIONALNO) Na svim stranicama includati na vrhu  header sa glavnom  navigacijom (potrazite kako se to radi sa thymeleafom, hint --> th:include)
