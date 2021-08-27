package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movieList.txt");
        Scanner movieScan = new Scanner(file);

        int movieListCount = 0;       //to count movie numbers
        String[] movieName = new  String[100];    //to get movies name into a string
        while (movieScan.hasNextLine()){
            movieListCount++;
            movieName[movieListCount] = movieScan.nextLine();
        }
        int movieIndex =(int)(Math.random()*movieListCount+1);  //generate random number to pick random movie

        int movieLength = movieName[movieIndex].length();   //length of the random movie

        String myMovie = "";   //string only contains "_____..."
        String wrongLetters = "";
        int i,chance = 0,point = 0,spaceCount = 0;
        boolean ok;
        for(i=0;i<movieLength;i++)
        {
            if(movieName[movieIndex].charAt(i) == ' ')
            {
                myMovie += ' ';
                spaceCount++;
            }
            else
                myMovie += '_';
        }

        point = spaceCount;
        Scanner inputScan = new Scanner(System.in);
        char input;

        while (chance <10 && point < movieLength){
            System.out.println("You are guessing : "+myMovie);
            System.out.println("You have guessed ("+chance+") wrong letters :"+wrongLetters);
            System.out.print("Guess a letter : ");
            ok = false;
            input = inputScan.next().charAt(0);
            for(i=0;i<movieLength; i++) {
                if (movieName[movieIndex].charAt(i) == input) {
                    ok = true;
                    if(myMovie.charAt(i) == '_')
                        point++;
                    myMovie = myMovie.substring(0,i)+input+myMovie.substring(i+1,movieLength);
                }
            }
            if(!ok)
            {
                chance++;
                wrongLetters += (" " + input);
            }
        }
        if(chance < 10)
            System.out.println("You Win!\nYou have guessed '"+myMovie+"' correctly.");
        else
            System.out.println("You Loss!");
    }
}
