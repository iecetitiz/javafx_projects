package com.example.favoritemoviesapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class FilmData {
    private static FilmData instance = new FilmData();
    //private oldugu icin kimse bu sekliyle instance'a erisemez su an
    //bu sinif kendi icinde bir nesne uretiyor ve bu nesneye erismek isteyen insanlar sadece getInstance() methoduyla erisebilsin
    //yani ben bu nesneye sadece ve sadece getInstance() methoduyla erisebilirim artik
    //ve bi sinif ismiyle bir nesne yaratilamasin, bunun icin de constructoru private yapicam
     //bu sinifin amaci tek bir nesne uzerinden calismayi saglamak oldugu icin
    //bu class'in nesne uretme ozelligini kaldirmam gerek

    public static FilmData getInstance() { //bu nesneyi kullanmak isteyenler getInstance()'i kullansin
        return instance;
    }
    private DateTimeFormatter formatter; //aldigim tarihleri formatli bir sekilde yazdirmak istedigim icin kullaniyorum
    private ObservableList<Film> filmListesi; //bu bir interface

    private FilmData() { //artik her zaman bana ayni nesneyi vermek zorunda, cunku private yaptim
    formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }


    //uygulama acildiginda tum filmler dosyadan alinir ve observable list'e getirilir
    public void dosyadanFilmleriGetir() {
        //Dosya icerigi su sekilde olacak:
        //Baslik \t Detay \t Cikis Tarihi

        filmListesi = FXCollections.observableArrayList(); //Bu su an arraylistle ayni sey

        //try icine aldigimda kapatmama da gerek kalmadigini soyledi bunun videolarini da izlemem lazim
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\iecet\\JavaFX_Projects\\FavoriteMoviesApp\\src\\main\\resources\\com\\example\\favoritemoviesapp\\filmler.txt"))) {
            String tekFilmSatir;
            while((tekFilmSatir = reader.readLine()) != null) {
                String[] filmParcalari = tekFilmSatir.split("\t");
                String filmBaslik = filmParcalari[0];
                String filmDetay = filmParcalari[1];
                String filmBitisTarihi = filmParcalari[2];

                //Film constructoru localdate bekliyor ama ben yukarda Stringlere parcaladim, o yuzden simdi parse edicem
                LocalDate bitis = LocalDate.parse(filmBitisTarihi, formatter);

                Film okunanfilm = new Film(filmBaslik, filmDetay, bitis);
                filmListesi.add(okunanfilm);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //uygulama acildiginda tum filmler dosyadan alinir ve observable list'e getirilir
    //bu method calistirildiginda var olan listeyi alip dosyama yazdiracak
    public void dosyayaFilmleriYaz() {
        try(BufferedWriter yazici = new BufferedWriter(new FileWriter("C:\\Users\\iecet\\JavaFX_Projects\\FavoriteMoviesApp\\src\\main\\resources\\com\\example\\favoritemoviesapp\\filmler.txt"))) {
            Iterator<Film>  iterator = filmListesi.iterator(); //Iterator benim listlerde dolasmak icin kullandigim bir yapi
            while(iterator.hasNext()) { //butun listeyi bastan sona geziyorum, filmListimde 10 tne film varsa 10 kez while donecek
                Film oankiFilm = iterator.next();
                yazici.write(String.format("%s\t%s\t%s", oankiFilm.getName(), oankiFilm.getDetails(), oankiFilm.getDate().format(formatter)));
                yazici.newLine();//bir alt satira gecipmesini istiyorum
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void filmEkle(Film eklenecekFilm) {
        filmListesi.add(eklenecekFilm);
    }

    public void filmSil(Film silinecekFilm) {
        filmListesi.remove(silinecekFilm);
    }
}
