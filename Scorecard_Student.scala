package scorecard_student;

import scala.collection.mutable.ArrayBuffer;

class Student(){ 

	var studentID = 0;
	var subject1 = 0;
	var subject2 = 0;
	var subject3 = 0;
	var subject4 = 0;

	var totalMarksPerStudent = 0;
	var gradePerStudent = "";
	var averageCompare = "";

	



	def GrandTotal():Int = {
		 totalMarksPerStudent =  subject1 + subject2 + subject3 + subject4;
			return totalMarksPerStudent;
	}

	def Grade():String = {
			if(totalMarksPerStudent>=340){
			  println(totalMarksPerStudent)
				gradePerStudent =  "A";
				return gradePerStudent;
			}
			else if(300 <= totalMarksPerStudent && totalMarksPerStudent < 340){
				gradePerStudent =  "B";
				return gradePerStudent;
			}
			else
				gradePerStudent = "C";
			return gradePerStudent;
	}

	
}


