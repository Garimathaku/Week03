package com.day1;

//Node class Movie
class Movie{
    String movieTitle;
    String director;
    int releaseYear;
    double rating;
    Movie next;
    Movie previous;
    //constructor
    Movie(String movieTitle,String director,int releaseYear,double rating){
        this.movieTitle=movieTitle;
        this.director=director;
        this.releaseYear=releaseYear;
        this.rating=rating;
        this.next=null;
        this.previous= null;
    }

}
//class MovieManagement
class MovieManagement{
    private Movie head;
    private Movie tail;

    public MovieManagement(){
        head=null;
        tail=null;
    }
    //Add  movie at the beginning
    public void addAtBeginning(String movieTitle,String director,int releaseYear,double rating){
        Movie movie=new Movie(movieTitle,director,releaseYear,rating);
        if(head==null){
            head=tail=movie;
        }else{
            movie.next=head;
            head.previous=movie;
            head=movie;

        }
    }
    //Add movie at the end
    public void addAtEnd(String movieTitle,String director,int releaseYear,double rating){
        Movie movie=new Movie(movieTitle,director,releaseYear,rating);
        if(tail==null){
            head=tail=movie;
        }else{
            tail.next=movie;
            movie.previous=tail;
            tail=movie;
        }
    }
    //add movie at Position
    public void addAtPosition(String movieTitle,String director,int releaseYear,double rating,int position){
        if(position<=0){
            addAtBeginning(movieTitle,director,releaseYear,rating);
            return;
        }
        Movie movie= new Movie(movieTitle,director,releaseYear,rating);
        Movie temp=head;
        int count=0;

        while(temp!=null&&count<position-1){
            temp=temp.next;
            count++;
        }
        if(temp==null){
            addAtEnd(movieTitle,director,releaseYear,rating);
        }else{
            movie.next=temp.next;
            movie.previous=temp;

            if(temp.next!=null){
                temp.next.previous=movie;
            }
            temp.next=movie;

            if(temp==tail){
                tail=movie;
            }
        }
    }
    //method to remove movie by title;
    public  void removeMovieByTitle(String movieTitle){
        Movie temp=head;

        while(temp!=null){
            if(temp.movieTitle==movieTitle){
                if(temp.previous!=null){
                    temp.previous.next=temp.next;
                }else{
                    head=temp.next;
                }
                if(temp.next!=null){
                    temp.next.previous=temp.previous;
                }else{
                    tail=temp.previous;
                }
                System.out.println("Movie: "+ movieTitle+ "removed successfully");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie"+ movieTitle+ "not found");
    }
    //method to search by director
    public void searchByDirector(String director){
        Movie temp=head;
        boolean found=false;

        while(temp!=null){
            if(temp.director==director){
                System.out.println("Title: "+ temp.movieTitle+ ", Year: "+temp.releaseYear+ ", Rating: "+temp.rating);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("No movies found director by "+ director);


        }
    }
    //method to search by rating
    public void searchByRating(double minRating){
        Movie temp=head;
        boolean found=false;

        while(temp!=null){
            if(temp.rating>=minRating){
                System.out.println("Title: "+ temp.movieTitle+",Director: "+ temp.director+ ", year: "+ temp.releaseYear);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("No movies found with rating>="+ minRating+ ".");
        }
    }
    //method to display in forward order
    public void displayForward(){
        Movie temp=head;

        if(temp==null){
            System.out.println("No movies to display");
            return;
        }
        System.out.println("Movies in forward order: ");
        while(temp!=null){
            System.out.println("Title: "+temp.movieTitle+ ", Director: "+temp.director+ ", Year: "+temp.releaseYear+", Rating:"+temp.rating );
            temp=temp.next;
        }
    }
    //method to display in reverse order
    public void displayReverse(){
        Movie temp=tail;
        if(temp==null){
            System.out.println("No movies to display");
            return;
        }

        System.out.println("movies in reverse order: ");
        while(temp!=null){
            System.out.println("Title: " + temp.movieTitle + ", Director: " + temp.director
                    + ", Year: " + temp.releaseYear + ", Rating: " + temp.rating);
            temp=temp.previous;
        }
    }
    //method to update the rating
    public void updateRating(String movieTitle,double newRating){
        Movie temp=head;

        while(temp!=null){
            if(temp.movieTitle==movieTitle){
                temp.rating=newRating;
                System.out.println("Rating of movie " + movieTitle + " updated to " + newRating + ".");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie " + movieTitle + " not found.");
    }
}
//class MovieManagement
public class MovieManagementSystem {
    public static void main(String[]args){
        MovieManagement movies=new MovieManagement();
        movies.addAtEnd("Movie1","XYZ",2012,5);
        movies.addAtEnd("Movie2","ABC",2023,6);
        movies.addAtBeginning("Movie3","UJY",2011,4);
        movies.addAtBeginning("Movie4","POI",2024,7);
//call the method
        movies.displayForward();
        System.out.println();

        movies.displayReverse();
        System.out.println();

        movies.searchByDirector("ABC");
        System.out.println();

        movies.searchByRating(6);
        System.out.println();

        movies.updateRating("Movie1",5);
        System.out.println();

        movies.removeMovieByTitle("Movie3");
        System.out.println();
    }
}
