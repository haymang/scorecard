package scorecard_class;

class Class7(){  

	var totalMarksGradeA = 0;
	var totalMarksGradeB = 0;
	var totalMarksGradeC = 0;

	var totalStudentsGradeA = 0;
	var totalStudentsGradeB = 0;
	var totalStudentsGradeC = 0;

	var studentsAboveAvg = 0;
	var studentsBelowAvg = 0;
	
	var averageGradeA = 0.0;
	var averageGradeB = 0.0;
	var averageGradeC = 0.0;

	
	def Average(marks:Int,count:Int):Double = {
			return marks/count;
	}
}