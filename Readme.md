# Event Organization
Naš projekat predstavlja sponu između dvije vrste korisnika:
* kompanija koja nudi usluge
* korisnik koji konzumira usluge(fizičko lice ili ipak druga kompanija)

## Komponente Aplikacije
Kreirat ćemo aplikaciju koja će posjedovati sljedeće funkcionalnosti:
* login 
* register 
* dashboard - kojem se pristupa nakon uspješne authentifikacije
* logout
* nivoe pristupa

## User Management
Kako se radi o jednostavnoj aplikaciji koja je sama sebi dovoljna 
mehanizam authentifikacije i authorizacije će biti implementiran unutar
same aplikacije.
Korisnik će imati mogućnost da se registruje kao neko ko želi nuditi 
usluge ili konzumirati usluge koje nude drugi.

Aplikacije će imati integrisan User Management System.

## Nivoi Pristupa
Imat ćemo nekoliko privilegija, a samim tim i nivoa pristupa:
1. client
2. manager
3. administrator

Dashboard će izgledati drugačije u zavisnosti od toga ko se uloguje
u aplikaciju(client, manager ili administrator).

### Administrator
Administrator će imati nekoliko opcija na Dashboardu:
* Home
* Event
* User's Administration   ***
* Service Types
* Discount Rules
* Credentials 

### Client 
Client ima samo nekoliko opcija:
* Home
* Event
* Credentials
Ono što klijent može praviti jesu novi zahtjevi za organizacijom nekog eventa.

### Manager 
Manager ima nekoliko dodatnih opcija u odnosu na samog klijenta:
* Home
* Event
* Service Types **
* Discount Rules **
* Credentials

#### Conclusion
1. Administrator - posjeduje sve mogućnosti koje aplikacija nudi
2. Manager - posjeduje sve mogućnosti izuzev User's Administration
3. Client - posjeduje samo mogućnost kreiranja zahtjeva za organizovanjem nekog eventa.


### Izrada Zadatka
#### Korištene Tehnologije
* MySQL relaciona baza sa tabelama
  * authenticationModel
  * privilege
  * country
  * town
  * address
  * event
  * event_cost
  * service_type
  * discount_rule
* Aplikativni Server(GlassFish, Payara, WildFly, TomEE itd..) 
  * konfigurisan ConnectionPool(tricky**)
    * JDBC Connection Pool - eventPool
    * JDBC Resource - JNDI name: jdbc/event
    * dodati driver MySQL u GlassFish 6
*  JPA ORM Object Relation Mapping (Hibernate, EclipseLink, MyBatis, Spring Data JPA...)
   * persistence.xml
* EJB Enterprise Java Bean - koji će imati neku logiku naše aplikacije.
  * Local ***
  * Remote - nekada davno desktop app 
* Druga podjela EJB
  *  Stateless ***
  *  Stateful
## Instalacija

Upute za instalaciju i pokretanje projekta:

```bash
git clone https://github.com/emirPuskaITAkademija/EventOrganization.git