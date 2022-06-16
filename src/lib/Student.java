package lib;

import java.util.ArrayList;
/**
 * Identify the relationship between mentor and mentees, implemented
 * with ArrayList as the way to store multiple mentees data
 * 
 * @author P2523401
 *
 */
public class Student {
	
	//Fields
	/**
	 * @param studentID
	 * @param mentor
	 * @param Array<Student> mentee
	 */
	private String studentID; // store the student numbers
	private Student mentor;
	private ArrayList<Student> mentee;
	
	//Constructors
	/**
	 * 
	 * full overload tree
	 * default student number "P0000000"
	 */
	public Student() {
		this("P0000000");
	}
	
	/**
	 * create student with the given student ID
	 * @param studentID
	 */
	public Student(String studentID) {
		this(studentID, null);
	}
	
	/**
	 * create a rule to store mentor
	 * @param studentID
	 * @param mentor
	 */
	public Student(String studentID, Student mentor) {
		this(studentID, mentor, null);
	}
	
	/*
	 * 
	 * Output order as {studentID, mentor, mentee} 
	 */
	public Student(String studentID, Student mentor, ArrayList<Student> mentee) {
		setStudentID(studentID);
		setMentor(mentor);
		setMentee(mentee);
	}
	
	//Methods
	/**
	 * 
	 * @return mentor
	 */
	public Student getMentor() {
		return mentor;
	}
	
	/**
	 * 
	 * @param mentor
	 * set getMentor = null, remove this mentor if it's already assigned as mentor
	 * if mentor is set to null, return
	 */
	public void setMentor(Student mentor) {
		if (getMentor()!=null)this.mentor.getMentee().remove(this); //remove this mentor if it's already assigned as mentor
		this.mentor = mentor;
		if (this.mentor == null)return; //if mentor is set to null, then return
		this.mentor.getMentee().add(this);
	}
	
	/** Returns mentee to the ArrayList
	 * 
	 * @return mentee
	 */
	public ArrayList<Student> getMentee() {
		return mentee;
	}
	
	/**Create an empty array list if no mentees are passed in the constructor
	 * 
	 * @param mentee
	 * 
	 */
	public void setMentee(ArrayList<Student> mentee) {
		//Ternary expression
		this.mentee = (mentee==null)?new ArrayList<Student>():mentee; //create an empty array list if no mentees are passed in the constructor
	}

	/**Returns studentID
	 * 
	 * @return studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**Creates new student ID
	 * 
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**Boolean check to verify if the student is a mentor 
	 * 
	 * 
	 */
	public boolean isMentor() {
		return getMentee().size()>0; //if more then 0 mentee, this student must be a mentor
	}
	
	/**
	 * 
	 * @return getMentor if it's not null
	 */
	public boolean isMentee() {
		return getMentor()!=null;
	}
	
	/**
	 * 
	 * Remove mentor by reusing setMontor and assign value to null
	 */
	
	public void removeMentor() {
		removeMentor(null);
	}
	
	/**
	 * 
	 * @param tree
	 */
	public void removeMentor(Tree tree) {
		setMentor(tree);
	}
	
	/**
	 *  Remove all mentees and set value to null
	 * 
	 */
	public void removeAllMentees() {
		removeAllMentees(null);
	}
	
	/**
	 *  Remove all mentees
	 * 
	 * @param tree
	 */
	public void removeAllMentees(Tree tree) {
		ArrayList<Student> a1 = new ArrayList<>(getMentee());
		for(Student s: a1)
			s.removeMentor(tree);
	}
	
	/** Returns a textual representation of the search result
	 * 
	 * @return the search result
	 */	
    @Override
    public String toString() {
        return "Student:[" +
                "StudentID=" + getStudentID() +
                ", Mentor=" + getMentor() + 
                "]";
    }
}