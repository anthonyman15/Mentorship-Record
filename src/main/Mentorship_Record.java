package main;

import java.util.ArrayList;
import lib.*;

/**Mentorship Record
 * 
 * Demonstrates creating and operating on a mentorship demonstration
 * 
 *  • Assign student mentors to mentees. (COMPLETE)
 *  • Let the user search for a mentee determine if the mentor has been assigned (COMPLETE)
 *	• Find a mentor for a given mentee (COMPLETE)
 *	• Let the user search for a mentor (COMPLETE)
 *	• Find all the mentees for the given mentor (COMPLETE)
 *	• Reassign mentors (COMPLETE)
 *	• Reassign mentees (COMPLETE)
 *	• Remove mentors (COMPLETE)
 *	• Remove mentees at any level of study (COMPLETE)
 * 
 * @author P2523401
 *
 */

public class Mentorship_Record {

	public static void main(String[] args) {
		/**
		 * student ID provided from given specification
		 * check attached documentation for diagrammatic illustration
		 */
		Tree tree = new Tree(); 							//dummy head
		Student stid1 = new Student("P2531111", tree); 		//level 6
		Student stid2 = new Student("P2531120", stid1); 	//level 5
		Student stid3 = new Student("P2532211", stid1); 	//level 5
		Student stid4 = new Student("P2530001", tree); 		//level 6
		Student stid5 = new Student("P2534141", stid4); 	//level 5
		Student stid6 = new Student("P2530230", stid4); 	//level 5, not yet allocate
		Student stid7 = new Student("P2530201", stid2); 	//level 4
		Student stid8 = new Student("P2530150", stid3); 	//level 4
		Student stid9 = new Student("P2530190", stid3);		//level 4
		Student stid10 = new Student("P2530210", stid3);	//level 4
		Student stid11 = new Student("P2530229", stid5);	//level 4
		Student stid12 = new Student("P2530250", stid5);	//level 4
		
		// search entire tree for a student and display the student related mentor
		Student searchResult = tree.search("P2534141");
		System.out.println(searchResult); //print search result
		
		/**
		 * Determine if the student rule
		 * if isMentor and isMentee are true, this student is a mentor also a mentee
		 * if isMentor is true and isMentee is false, this student is a mentor but is not yet allocate
		 * if isMentor is false and isMentee is true, this student is a mentee, not a mentor
		 * else, invalid input
		 */
		// determine if it has mentee(s), if it has, then it is a mentor
		boolean isMentor = searchResult.isMentor(); 
		// determine if it has mentor, if it has, then it is a mentee
		boolean isMentee = searchResult.isMentee();
		
		// if the student is mentor, output true, otherwise false
		System.out.println(isMentor);
		// if the student is mentee, output tree, otherwise false
		System.out.println(isMentee);
		
		// determine mentor
		Student mentor = searchResult.getMentor();
		System.out.println(mentor);
		// determine mentee(s)
		ArrayList<Student> mentees = searchResult.getMentee();
		System.out.println(mentees);
		
		// reassign mentor, reassign mentee, automatically updates the mentee when reassigning mentor
		searchResult.setMentor(stid1);
		System.out.println(searchResult);
		// check assigned mentee(s) is also related to the mentor after reassigning mentor
		System.out.println(stid12);
		
		// display all mentees
		System.out.println(mentees);
		
		// remove mentee from the mentor, input student now has no mentor
		searchResult.removeMentor(tree);
		System.out.println(searchResult);
		
		// Before removed mentee has changed to new assigned mentor
		System.out.println(stid5);
		searchResult.setMentor(stid1);
		// After removed mentee and reassign to new mentor
		System.out.println(stid5);
		
		// remove all assigned mentees off stid5 and reassign back to the Root
		searchResult.removeAllMentees(tree);
		// to verify that stid10 is no longer mentee of stid5
		System.out.println(stid10);
		System.out.println(searchResult);		
	}

}

