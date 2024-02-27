package Time;

import java.io.Serializable;
import java.util.GregorianCalendar;


public class Time implements Serializable {   
    private static final long serialVersionUID = 11L;
    
    private int hours;
    private int minutes;
    private int seconds;
    private String time;
    private int day;
    private int month;
    private int year;
    private String date;

    private final GregorianCalendar calendar = new GregorianCalendar();
    
    //  DEFAILT CONSTRUCTOR  //
    public Time() {
    }
    
    public void setTime() {
        long currentTimeMillis = System.currentTimeMillis();
        
        long totalSeconds = currentTimeMillis / 1000;
        this.seconds = (int) totalSeconds % 60;
        
        long totalMinutes = totalSeconds / 60;
        this.minutes = (int) totalMinutes % 60;
        
        long totalHours = totalMinutes / 60;
        this.hours = (int) (totalHours % 24) + 8;
        
        this.time = this.hours+":"+this.minutes+":"+this.seconds;
    }
    
    public String getTime() {
        setTime();
        return time;
    }
    
    public void setDate() {
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH) + 1;
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.date = this.day+"/"+this.month+"/"+this.year;
    }
    
    public String getDate() {
        setDate();
        return date;
    }
}
