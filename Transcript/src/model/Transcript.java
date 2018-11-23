package model;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    /**
     * INVARIANT: course list and grade list are of same size
     * each course has a grade associated, with matching indices
     */

    private String sname;
    private int sid;
    private ArrayList<String> coursename;
    private ArrayList<Double> gradelist;

    public Transcript(String name, int uid) {
            sname = name;
            sid = uid;
            coursename = new ArrayList<String>();
            gradelist = new ArrayList<Double>();
    }

    public String getStudentName() {return sname;}

    public int getStudentID() {return sid;}

    public ArrayList<String> getCoursename() {return coursename;}

    public ArrayList<Double> getGradelist() {return gradelist;}

    //TODO: Design specification for this method
    //REQUIRES: should be between 0.0 and 4.0, and course should be not be null
    //MODIFIES: this
    //EFFECTS: add the course and grade to the transcript if its not there, do nothing if its there
    public void addGrade(String course, double grade){
        if (!coursename.contains(course)) {
            coursename.add(course);
            gradelist.add(grade);
        }
    }

    //TODO: Design specification for this method
    // This method should return course name and grade in some consistent String format
    //REQUIRES: a course the student has already taken
    //MODIFIES: nothing
    //EFFECTS: return course name and grade in some consistent string format
    public String getCourseAndGrade(String course){
        int where = coursename.indexOf(course);
        String output = String.format("%s: %d", course, gradelist.get(where));
        return output;
    }

    //TODO: Design specification for this method
    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: print out all the courses and grades in the transcript in some consis. format
    public void printTranscript(){
        System.out.print(sname + ": ");
        for (int i = 0; i < coursename.size(); i++){
            System.out.print(coursename.get(i) + ": ");
            System.out.print(gradelist.get(i) + ", ");
        }
        System.out.println(getGPA());
    }

    //TODO: Design specification for this method
    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: print out the average grades of the transcript and return 0.0 if its empty
    public double getGPA(){
        double GPA = 0;
        for (int i = 0; i < gradelist.size(); i++) {
            GPA += gradelist.get(i);
        }
        double result = GPA/gradelist.size();
        return result;
    }


    public boolean hasCourse(String name){
        if (coursename.contains(name)) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {return gradelist.size();}
}

