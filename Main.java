package package123;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
class Task4{
	private String q;
	private List<String> options;
	private int rightanswer;
	public Task4(String q,List<String> options,int rightanswer) {
		this.q=q;
		this.options=options;
		this.rightanswer=rightanswer;
	}
	public String getQ() {
		return q;
	}
	
	public List<String> getOptions(){
		return options;
	}
	public int getRightAnswer()
	{
		return rightanswer;
	}
	
}
public class Main{
	private List<Task4> q1;
	private int currentQuestionIndex;
	private int score;
	private Timer t;
	private Scanner sc;
	public Main() {
		q1=new ArrayList<>();
		currentQuestionIndex=0;
		score=0;
		t=new Timer();
		sc=new Scanner(System.in);
	}
	public void addQuestion(Task4 q) {
		q1.add(q);
	}
	public void startQuiz() {
		System.out.println("Welcome!!!!");
		t.schedule(new QuizTimerTask(),3,800000);
		while(currentQuestionIndex < q1.size()) {
			Task4 currentQuestion=q1.get(currentQuestionIndex);
			displayQuestion(currentQuestion);
			int userChoice=getUserChoice();
			if(userChoice==currentQuestion.getRightAnswer()) {
				System.out.println("Correct");
				score++;
			} else {
				System.out.println("Incorrect");
			}
			currentQuestionIndex++;
		}
		displayResult();
	}
	private void displayQuestion(Task4 q1) {
		System.out.println(q1.getQ());
		List<String> options=q1.getOptions();
		for(int i=0;i<options.size();i++) {
			System.out.println((i+1)+"." +options.get(i));
		}
	}
	private int getUserChoice() {
		System.out.println("Enter your choice (1-" +q1.get(currentQuestionIndex).getOptions().size()+"): ");
		return sc.nextInt();
	}
	private void displayResult() {
		System.out.println("Quiz completed!");
		System.out.println("Score is " +score+"/"+q1.size());
	}
	private class QuizTimerTask extends TimerTask{
		private int secondsleft=10;
		public void run() {
			if(secondsleft>0) {
				System.out.println("Time remaining:  "+secondsleft);
				secondsleft--;
			}
			else {
				System.out.println("Time is up!!!");
				currentQuestionIndex++;
			}
		}
	}
	public static void main(String args[]) {
		Main quiz=new Main();
		quiz.addQuestion(new Task4("1.What is the capital of India?",List.of("Mumbai","Delhi","Kerela"),2));
		quiz.addQuestion(new Task4("2.What is symbol of mercury?",List.of("Hg","Au","Ag"),1));
		quiz.addQuestion(new Task4("3.What is the capital of France?",List.of("Berlin","Madrid","Paris"),3));
		quiz.startQuiz();
	}
}

