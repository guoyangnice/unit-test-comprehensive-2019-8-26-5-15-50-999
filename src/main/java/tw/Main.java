package tw;

import java.io.IOException;
import java.util.Arrays;
import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {
	
    private static final int RUN_TIMES = 6;
    private static int[] finalAnswer;
    private static int length = 4;
    private static int sameA = 0;
    private static int positionB = 0;
    

    public static void main(String[] args) throws Exception {
    	//��ȡ�����մ�
    	getRandomAnswer();
    	//�����
        generateAnswerAndCompare();
    }
    
    /**
     * ��ȡ�����մ�
     */
    public static void getRandomAnswer() {
    	finalAnswer = new int[length];
    	//�������մ�
    	for(int i = 0;i<length;i++){
    		finalAnswer[i]=(int)(Math.random()*10); 
              for(int j = 0;j<i;j++){
                 if(finalAnswer[j]==finalAnswer[i]){
                     i--;
                 }
              }
        }
    	System.out.println("�������յĴ𰸣�");
    	for(int i = 0;i<length;i++){
            System.out.print(finalAnswer[i]+" ");
        }
    	
    	System.out.println();
    }
    
    /**
     * ��ȡ�²�𰸲��Ա�
     * @throws IOException 
     */
    public static void generateAnswerAndCompare() throws IOException {
    	for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
            System.out.println(input);
            int myAnswer[] = new int[length];
            String[] s = input.split(" ");
            Arrays.toString(s);
            //���ַ�������תΪ����
            for(int j = 0 ;j < s.length;j++) {
            	myAnswer[j] = Integer.parseInt(s[j]);
            	//System.out.println(myAnswer[j]);
            }
            if(CheckNumber.isValid(myAnswer)) {
            	for(int j = 0; j < myAnswer.length;j++) {
            		if(myAnswer[j] == finalAnswer[j]) {
            			sameA ++;
            		}
            		for(int k = 0; k < finalAnswer.length;k++) {
            			if(myAnswer[j] == finalAnswer[k]) {
            				positionB ++;
            			}
            		}
            	}
            }
            
            System.out.println("���ָ��Աȣ�");
            System.out.println(sameA+"A"+positionB+"B");
            sameA = 0;
            positionB = 0;
            if(i==5) {
            	System.out.println("game over");
            }
        }
    }
}
