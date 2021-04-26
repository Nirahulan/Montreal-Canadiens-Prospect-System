/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadiensprospectsdbms;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nirahulan.P
 */
public class CanadiensProspectsDBMS {

    /**
     * @param args the command line arguments
     */
   Scanner scan = new Scanner(System.in);

public void UserOptions(){
    System.out.println("Enter 1 to provide the league names ");
     System.out.println("Enter 2 to provide the forwards and their respective teams");
      System.out.println("Enter 3 to see which forward has the most goals ");
       System.out.println("Enter 4 to see the most amount of goals by a deffenseman   ");
        System.out.println("Enter 5 to Highest Save percentage by a goalie");
         System.out.println("Enter 6 to see the Lowest +/- from a Defender ");
           System.out.println("Enter 7 forward with lowest +/- from a forward  ");
           System.out.println("Enter 8 to provide the players first and last name whose place of birth Contains the province Ontario");
            System.out.println("Enter 9 to forward with most goals  ");
             System.out.println("Enter 10 players draft year in ascending order");
             
//             System.out.println("Enter here");
//int i = scan.nextInt();
}

public void leaugeName() throws SQLException{
           Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            
        ResultSet r = myStatement.executeQuery("select * from league");
     
        while(r.next()){
            System.out.println(r.getString("leaugeName"));
        }
    }  catch (ClassNotFoundException ex) {
           Logger.getLogger(CanadiensProspectsDBMS.class.getName()).log(Level.SEVERE, null, ex);
       }

}
public void querry(int i){
       
             if(i==1){
           Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select * from league");
              while (rs.next()) {
        String leagueName = rs.getString("leagueName");

                  System.out.println(leagueName);
      }
          
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
    
             }
             //
    if(i==2){
            Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select * from player");
              while (rs.next()) {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
       String teamName= rs.getString("playerTeamName");
        

                  System.out.println(firstName +" "+lastName+" "+teamName);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
}
    


    if (i==3){
                    Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT forwardFirstName , forwardLastName , goals FROM forward order by goals desc");
              while (rs.next()) {
        String firstName = rs.getString("forwardFirstName");
        String lastName = rs.getString("forwardLastName");
         int points = rs.getInt("Goals");     

                  System.out.println(firstName +" "+lastName +" "+points);
      }
          
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
    }
        if(i==4){
                       Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT defensemanFirstName , defensemanLastName , goals  FROM defenseman order by goals desc");
              while (rs.next()) {
        String firstName = rs.getString("defensemanFirstName");
        String lastName = rs.getString("defensemanLastName");
         int points = rs.getInt("Goals");     
        

                  System.out.println(firstName +" "+lastName +" "+points);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
        
    } 
    if(i==5){
                       Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT  goalieFirstName,  goalieLastName , savePercentage  FROM goalie order by  savePercentage desc");
              while (rs.next()) {
        String firstName = rs.getString("goalieFirstName");
        String lastName = rs.getString("goalieLastName");
         float points = rs.getFloat("savePercentage");     
        

                  System.out.println(firstName +" "+lastName +" "+points);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
}
    if (i==6){
        //select min(plusMinus) as lowest_plusMinus from defenseman ;
                    Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select min(plusMinus) as lowest_plusMinus from defenseman");
              while (rs.next()) {
       
             int points = rs.getInt("lowest_plusMinus");
        

                  System.out.println( "lowest plusMinus = " + points);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
        
    }
        if(i==7){
                     Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select forwardFirstName , forwardLastName ,  plusMinus from forward order by  plusMinus desc");
              while (rs.next()) {
        String firstName = rs.getString("forwardFirstName");
        String lastName = rs.getString("forwardLastName");
         int points = rs.getInt("plusMinus");     
        

                  System.out.println(firstName +" "+lastName +" "+points);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
    } 
    if(i==8){
    
                     Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select firstName, lastName from player where placeOfBirth like '%Ontario'");
              while (rs.next()) {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
             

                  System.out.println(firstName +" "+lastName);
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
}
    if (i==9){
                           Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select forwardFirstName,forwardLastName,max(goals) as most_goals from forward;");
              while (rs.next()) {
        String firstName = rs.getString("forwardFirstName");
        String lastName = rs.getString("forwardLastName");
        int points = rs.getInt("most_goals");     
        

                  System.out.println(firstName +" "+lastName+" scored "+points + " goals");
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
    }
    if(i==10){
        
                               Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MontrealCanadiensProspects.db");
         Statement myStatement = c.createStatement();
            ResultSet rs = myStatement.executeQuery("select firstName, lastName ,draftYear from player order by draftYear asc");
              while (rs.next()) {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        int points = rs.getInt("draftYear");     
        

                  System.out.println(firstName +" "+lastName+"  "+points );
      }
           // leaugeName();
              }catch (Exception e) {
            System.err.println("Problem Encountered");
       }
    }
    if(i>10 || i<1){
        System.out.println("Please enter a number between 1 and 10");
    }   
 
}
    public int getUserInput(){
         int i = scan.nextInt();
    return i;}
    
    public static void main(String[] args) {
        // TODO code application logic here
          
               CanadiensProspectsDBMS obj = new CanadiensProspectsDBMS();
       obj.UserOptions();
       System.out.println("Enter here");
          for(;;){
               System.out.println("                ");
                System.out.println("                ");
              obj.UserOptions();
              System.out.println("Enter here");
           
       int i = obj.getUserInput();
       obj.querry(i);
        }

    }
    
}
