package lib;
/**
 *  Create an invisible student to use the name as the head
 *  Extension of Student Class to create a dummy head
 *  @author P2523401
 */
public class Tree extends Student{

	/**
	 *	Define a dummy head 
	 */
	public Tree(){
		super("HEAD");
	}
	/**
	 * Search a mentess in the tree
	 * @param id
	 * @return
	 */
    public Student search(String id){
        return searchMentees(this, id);
    }

    /**
     * Check if the mentor has mentee(s) contains to search for
     * 
     * @param mentor
     * @param id
     * @return
     */
    public static Student searchMentees(Student mentor, String id){
        for (Student CurrentStudent : mentor.getMentee()){              	// Search all mentees
            if (CurrentStudent.getStudentID().equals(id))               	// Are they the student we're looking for?
                return CurrentStudent;                                  	// Then return them

            if (CurrentStudent.isMentor()) {                           		// Otherwise see if they have mentees to search through
                Student secondResult = searchMentees(CurrentStudent, id);   // and search through them
                if (secondResult != null) return secondResult;        		// If the student we're looking for was found in their mentees, return them
            }
        }
        return null;                                                 		// No matching student was found, return null.
    }
    
    /** Returns a textual representation of getStudentID
     * 
     *  @return Student ID
     */
    @Override
    public String toString() {
    	return getStudentID();
    }
}
