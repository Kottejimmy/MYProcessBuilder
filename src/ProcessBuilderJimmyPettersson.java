
//This program is originally from the book Operating System //Concepts in Java,
// (Silberschatz) 7th Edition.
import java.io.*;
import java.util.*;

public class ProcessBuilderJimmyPettersson {

private  ArrayList<String> errorLog;

public ProcessBuilderJimmyPettersson(){
    errorLog = new ArrayList<>();
}

    public static void main(String[] args) throws java.io.IOException {
        ProcessBuilderJimmyPettersson MP = new ProcessBuilderJimmyPettersson();
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n***** Welcome to the Java Command Shell *****");
        System.out.println("If you want to exit the shell, type END and press RETURN.\n");
        // we break out with ‘END’
        while (true) {
            // show the Java shell prompt and read what command they entered
            System.out.print("jsh>");
            commandLine = console.readLine();
            // if user entered a return, just loop again
            if (commandLine.equals("")) {
                continue;
            }
            if (commandLine.toLowerCase().equals("end")) { //User wants to end shell
                System.out.println("\n***** Command Shell Terminated. See you next time. BYE for now. *****\n");
                System.exit(0);
            }
            if (commandLine.toLowerCase().equals("showerrlog")) { //shows errorlog
                MP.printErrorLog();
            }
            else
                {
                Thread a = new Thread(new ThreadBuilderJimmyPettersson(commandLine, MP));
                a.start();

            }

        }
    }

    public void addToErrorLog (String error){
        errorLog.add(error);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    }

    private  void printErrorLog (){
        int i = 0;
        System.out.println("The following commands could not execute properly:");
        while (i<errorLog.size()){
            System.out.println((i+1)+":"+errorLog.get(i));
            i++;
        }
    }

}
