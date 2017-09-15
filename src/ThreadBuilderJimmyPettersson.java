import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by kottejimmy on 9/8/2017.
 */
public class ThreadBuilderJimmyPettersson implements Runnable   {

    private ProcessBuilderJimmyPettersson MTP;
    private String command;


    public ThreadBuilderJimmyPettersson(String command, ProcessBuilderJimmyPettersson MTP) {
        this.command = command;
        this.MTP = MTP;
    }



    @Override
    public void run()   {

        ProcessBuilder pb = new ProcessBuilder(command);
        // ProcessBuilder creates a process corresponding to the input command
        // now start the process
        BufferedReader br = null;
        try

        {
            Process proc = pb.start();
            // obtain the input and output streams
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            // read what the process returned
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch(java.io.IOException ioe)
        {

            MTP.addToErrorLog(command);
            System.err.println(ioe);
        } finally

        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}



