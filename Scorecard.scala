import scorecard_student._;
import scorecard_class._;
import scala.io._;
import scala.collection.mutable.ArrayBuffer;


object Scorecard {
	def main(args: Array[String]){

		val fileContent = Source.fromFile("C:/Users/hayma/Desktop/test.txt");
		val lines = try fileContent.mkString finally fileContent.close;


				val rows = lines.split("-|,| ");

				val objStudent = new Student();
				val objClass = new Class7();

				var id = new ArrayBuffer[Int]();
				var sub1 = new ArrayBuffer[Int]();
				var sub2 = new ArrayBuffer[Int]();
				var sub3 = new ArrayBuffer[Int]();
				var sub4 = new ArrayBuffer[Int]();

				var totalMarksPerStudent = new ArrayBuffer[Int]();
				var gradePerStudent = new ArrayBuffer[String]();
				var averageCompare = new ArrayBuffer[String]();


				for(i <-rows.indices by 9){
					objStudent.studentID = rows(i).toInt;
					id.append(objStudent.studentID);

					objStudent.subject1 = rows(i+2).toInt;
					sub1.append(objStudent.subject1);

					objStudent.subject2 = rows(i+4).toInt;
					sub2.append(objStudent.subject2);

					objStudent.subject3 = rows(i+6).toInt;
					sub3.append(objStudent.subject3);

					objStudent.subject4 = rows(i+8).toInt; 
					sub4.append(objStudent.subject4);

					totalMarksPerStudent.append(objStudent.GrandTotal());
					gradePerStudent.append(objStudent.Grade());

				}

				for (i <- id.indices) {
					if(gradePerStudent(i).equals("A")){
						objClass.totalMarksGradeA = objClass.totalMarksGradeA + totalMarksPerStudent(i);
						objClass.totalStudentsGradeA += 1;

					}

					else if(gradePerStudent(i).equals("B")){
						objClass.totalMarksGradeB = objClass.totalMarksGradeB + totalMarksPerStudent(i);
						objClass.totalStudentsGradeB += 1;

					}

					else{
						objClass.totalMarksGradeC = objClass.totalMarksGradeC + totalMarksPerStudent(i);
						objClass.totalStudentsGradeC += 1;

					}
				}

				objClass.averageGradeA = objClass.Average(objClass.totalMarksGradeA, objClass.totalStudentsGradeA);
				objClass.averageGradeB = objClass.Average(objClass.totalMarksGradeB, objClass.totalStudentsGradeB);
				objClass.averageGradeC = objClass.Average(objClass.totalMarksGradeC, objClass.totalStudentsGradeC);


				for (i <- id.indices) {

					if(gradePerStudent(i).equals("A")){
						if(objClass.averageGradeA <= totalMarksPerStudent(i)){
							objStudent.averageCompare = "Above";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsAboveAvg += 1;
						}
						else{
							objStudent.averageCompare = "Below";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsBelowAvg += 1;
						}
					}
					else if(gradePerStudent(i).equals("B")){
						if(objClass.averageGradeB <= totalMarksPerStudent(i)){
							objStudent.averageCompare = "Above";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsAboveAvg += 1;
						}
						else{
							objStudent.averageCompare = "Below";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsBelowAvg += 1;
						}
					}
					else{
						if(objClass.averageGradeC <= totalMarksPerStudent(i)){
							objStudent.averageCompare = "Above";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsAboveAvg += 1;
						}
						else{
							objStudent.averageCompare = "Below";
							averageCompare.append(objStudent.averageCompare);
							objClass.studentsBelowAvg += 1;
						}
					}
				}

				println("ID Subject1 Subject2 Subject3 Subject4 Grand-Total Grade Average-Compare");

				for(i <- id.indices){
					println("|"+id(i)+"|"+sub1(i)+"|"+sub2(i)+"|"+sub3(i)+"|"+sub4(i)+"|"+totalMarksPerStudent(i)+"|"+gradePerStudent(i)+"|"+averageCompare(i)+"|");
				}

				println("Grade Report");
				println("Number of students in A Grade :: "+objClass.totalStudentsGradeA);
				println("Number of students in B Grade :: "+objClass.totalStudentsGradeB);
				println("Number of students in C Grade :: "+objClass.totalStudentsGradeC);
				println("Number of students above their grade average :: "+objClass.studentsAboveAvg);
				println("Number of students below their grade average :: "+objClass.studentsBelowAvg);

	}
}