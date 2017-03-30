
package basketball;

/** Team class: represents teams and their attributes
 *
 * written by Cole Petersen
 */

public class Team {
    
    String name;
    int ORate;
    int DRate;
    double ExpPts;
    int score;
    double PPM;
    
    public Team(String name, int ORate, int DRate){
        this.name = name;
        this.ORate = ORate;
        this.DRate = DRate;
        this.score = 0;
        
    }
    
}
