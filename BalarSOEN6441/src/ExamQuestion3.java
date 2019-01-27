package soen6441;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import soen6441.Course.Program;

public class ExamQuestion3 {

	// Subtask a)
	private static CompletionStage<Integer> addCredits (List<Course> courses) {
		return ExamTask.replaceWithYourSolution();
	}
 		
 	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 3!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a) -- see method addCredits above
		final CompletionStage<Integer> futureSum = addCredits(courses);
		
		// Subtask b)
		ExamTask.replaceWithYourSolution();
		
		// Subtask c)
		// final CompletionStage<Boolean> futureStatus = addCredits(courses).??? 
		
		System.out.println("Goodbye, SOEN6411 Exam Question 3!");
	}
}
