/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author raya
 */
public class Staff extends User{
    public String courseID;
    public String salary;
    
    public Staff(String ID) {
        super(ID);
    }
    
    /**
     *
     * @param member contains user Information
     * @param courseCode // A Foreign Key to Courses Table
     * @param salary    // Determines how much this staff member earns per month
     */
    public Staff(User member,String courseCode, String salary) {
        super(member);
        this.courseID = courseCode;
        this.salary = salary;
    }

    Staff(String userID, String firstName, String lastName, Date birthDate, String gender, String salary) {
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.gender     = gender;
        this.birthDate  = birthDate;
        this.gender     = gender;
        this.salary     = salary;

    }
    
    Staff(String CourseID, String salary, String userID, String firstName, String lastName, Date birthDate, String gender) {
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.gender     = gender;
        this.birthDate  = birthDate;
        this.gender     = gender;
        this.salary     = salary;
    }
    
    Staff(String userID, String firstName, String lastName, Date birthDate, String gender) {
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.gender     = gender;
        this.birthDate  = birthDate;
        this.gender     = gender;
    }
    

    public boolean addStaff(){
        if(this.userID.startsWith("2"))
            return DB.addAdmin(this);
        return DB.addInstructor(this);
        
    }
    public boolean updateStaff(){
        if (this.userID.startsWith("2"))
            return DB.updateAdmin(this);
        return DB.updateInstructor(this);
    }
    
    public static boolean deleteInstructor(String courseID){
        return DB.deleteInstructorFromActivity(courseID);
    }
    
    public boolean fillStaffInfo(String StaffID){
        this.userID = StaffID;
        return fillStaffInfo();
    }
    public boolean fillStaffInfo(){
        if(this.userID.startsWith("2"))
            return DB.getAdminInfo(this);
        return DB.getInstructorInfo(this);
    }
    public static Staff[] getInstructors(){
        return DB.getInstructors();
    }
    public static Staff[] getAdmins(){
        return DB.getAdmins();
    }
    
    public static Staff[] getInstructors(String courseID){
        return DB.getInstructorsInfoFromCourseID(courseID);
    }
    public static Staff getInstructorName(String instructorID){
        return DB.getInstructorsNameFromInstructorID(instructorID);
    }
    


    
    
    
}
