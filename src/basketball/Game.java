
package basketball;

/** Game class: represents the game and its attributes
 *
 * written by Cole Petersen
 */

import java.util.Scanner;
import java.util.Random;

public class Game {
    
    int periods;
    int PeriodTime;
    int GameTime;
    int OvertimeTime;
    int PeriodsLeft;
    double AvgPPM;
    int AvgScore;
    boolean overtime;
    
    public Game(int periods, int PeriodTime, int OvertimeTime, double AvgPPM){
        this.periods = periods;
        this.PeriodTime = PeriodTime;
        this.GameTime = this.periods * this.PeriodTime;
        this.OvertimeTime = OvertimeTime;
        this.PeriodsLeft = periods;
        this.AvgPPM = AvgPPM;
        this.AvgScore = (int) (this.AvgPPM * this.GameTime);
        this.overtime = false;
        
    }
    
    public void ChangeGame(){
        
        String input;
        boolean exit = false;
        
        while(!exit){
            System.out.println("Current game: " + this.periods + " periods, " + 
                              this.PeriodTime + " minutes per period, " + 
                              this.OvertimeTime + " minute overtime.");
            
            System.out.println("1. Change periods");
            System.out.println("2. Change period time");
            System.out.println("3. Change overtime time");
            System.out.println("4. Change points per minute");
            System.out.println("5. Exit");

            Scanner read2 = new Scanner(System.in);
            input = read2.nextLine();
            switch (input) {
                case "1":
                    this.ChangePeriods();
                    break;
                case "2":
                    this.ChangePeriodTime();
                    break;
                case "3":
                    this.ChangeOvertimeTime();
                    break;
                case "4":
                    this.ChangePPM();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }
    }
    
    public void ChangePeriods(){
        String input2;
        boolean exit2 = false;
        System.out.println("Current periods: " + this.periods);
        while(!exit2){
            System.out.print("New periods (1, 2, or 4): ");
            Scanner read3 = new Scanner(System.in);
            input2 = read3.nextLine();
            switch (input2) {
                case "1":
                    this.periods = 1;
                    exit2 = true;
                    break;
                case "2":
                    this.periods = 2;
                    exit2 = true;
                    break;
                case "4":
                    this.periods = 4;
                    exit2 = true;
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
            this.GameTime = this.periods * this.PeriodTime;
        }
    }
    
    public void ChangePeriodTime(){
        String input2;
        int input2int;
        boolean exit2 = false;
        System.out.println("Current period time: " + this.PeriodTime);
        while(!exit2){
            System.out.print("New period time (1-60): ");
            Scanner read3 = new Scanner(System.in);
            input2 = read3.nextLine();
            input2int = Integer.parseInt(input2);
            if(input2int >= 1 && input2int <= 60){
                this.PeriodTime = input2int;
                this.GameTime = this.periods * this.PeriodTime;
                exit2 = true;
            }
            else{
                System.out.println("Error.");
            }
        }
    }
    
    public void ChangeOvertimeTime(){
        String input;
        int inputint;
        boolean exit = false;
        System.out.println("Current overtime time: " + this.OvertimeTime);
        while(!exit){
            System.out.print("New overtime time (1-60): ");
            Scanner read = new Scanner(System.in);
            input = read.nextLine();
            inputint = Integer.parseInt(input);
            if(inputint >= 1 && inputint <= 60){
                this.OvertimeTime = inputint;
                exit = true;
            }
            else{
                System.out.println("Error.");
            }
        }
    }
    
    public void ChangePPM(){
        String input;
        double inputdbl;
        boolean exit = false;
        System.out.println("Current average points per team per minute: "
                          + this.AvgPPM);
        while(!exit){
            System.out.println("Average average points per team per minute is"
                              + " around 1.8. Between 1.5 and 2 recommended."
                              + "\nMinimum actual points per minute will be"
                              + " 0.");
            System.out.print("New points per team per minute: (0-5): ");
            Scanner read = new Scanner(System.in);
            input = read.nextLine();
            inputdbl = Double.parseDouble(input);
            if(inputdbl >= 0 && inputdbl <= 200){
                this.AvgPPM = inputdbl;
                this.AvgScore = (int) 
                                this.AvgPPM * this.GameTime;
                exit = true;
            }
            else{
                System.out.println("Error.");
            }
        }
        
    }
    
    public void PlayGame(){
        
        String input;
        
        Team Team1 = new Team("a", 80, 70);
        Team Team2 = new Team("b", 55, 85);
        
        Team1.ExpPts = ((Team1.ORate - Team2.DRate)/2) + this.AvgScore;
        Team1.PPM = Team1.ExpPts / (this.GameTime);
        Team2.ExpPts = ((Team2.ORate - Team1.DRate)/2) + this.AvgScore;
        Team2.PPM = Team2.ExpPts / (this.GameTime);
        
        
        Team1.score = 0;
        Team2.score = 0;
        
        boolean exit = false;
        
        System.out.println("Current teams: ");
        System.out.println(Team1.name + ": Offense: " + 
                          Team1.ORate + ", Defense: " + 
                          Team1.DRate + ".");
        System.out.println(Team2.name + ": Offense: " + 
                          Team2.ORate + ", Defense: " + 
                          Team2.DRate + ".");
        System.out.println("Current game: " + this.periods + " periods, " + 
                          this.PeriodTime + " minutes per period, " + 
                          this.OvertimeTime + " minute overtime.");
        
        while(!exit){
            
            System.out.println("1. Play period");
            System.out.println("2. Play whole game");
            System.out.println("3. Exit");

            Scanner read2 = new Scanner(System.in);
            input = read2.nextLine();
            switch (input) {
                case "1":
                    this.PlayPeriod(Team1, Team2);
                    break;
                case "2":
                    this.PlayWholeGame(Team1, Team2);
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
            if(PeriodsLeft == 0){
                exit = true;
            }
            
        }
        
    }
    
    public void PlayWholeGame(Team Team1, Team Team2){
        
        Random random = new Random();
        
        Team1.score = (int) 
                      ((10 * random.nextGaussian() + Team1.ExpPts)
                      * this.PeriodsLeft/this.periods);

        Team2.score = (int) 
                      ((10 * random.nextGaussian() + Team2.ExpPts)
                      * this.PeriodsLeft/this.periods);
        
        System.out.println("Game over.");
        
        this.PeriodsLeft = 0;
        
        System.out.println(Team1.score);
        System.out.println(Team2.score);
        
        
        
    }
    
    public void PlayPeriod(Team Team1, Team Team2){
        
        this.PeriodsLeft -= 1;
        
        ChangeScore(Team1);
        ChangeScore(Team2);
        
        switch(PeriodsLeft){
            case(0):
                if(Team1.score != Team2.score){
                    System.out.println("Game over.");
                }
                else{
                    this.overtime = true;
                    while(Team1.score == Team2.score){
                        this.PlayOvertime();
                    }
                    this.overtime = false;
                }
                break;
            case(1):
                if(this.periods == 2){
                    System.out.println("Halftime.");
                }
                else if(this.periods == 4){
                    System.out.println("After three quarters.");
                }
                break;
            case(2):
                System.out.println("Halftime.");
                break;
            case(3):
                System.out.println("After one quarter.");
                break;
            default:
                System.out.println("Error.");
                break;
        }
        
        System.out.println(Team1.name + " " + Team1.score);
        System.out.println(Team2.name + " " + Team2.score);
        
    }
    
    void PlayOvertime(){
        
    }
    
    void ChangeScore(Team team){
        
        Random random = new Random();
        
        int time = this.PeriodTime;
        
        if(this.overtime){
            time = this.OvertimeTime;
        }
        
        
        int Pscore = (int) 
                     ((10 * random.nextGaussian() + team.ExpPts) 
                     / this.periods);
        if(Pscore < 0){
            Pscore = 0;
        }
        team.score += Pscore;
    }
    
}
