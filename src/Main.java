import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This models the execution of processes on a CPU.
 *
 * @author "Anna Brötzner, Malmö university"
 * @since 1.0
 */

public class Main {
    public static void main(String[] args) {
        List<Process> allProcesses = new ArrayList<>();
        allProcesses = loadProcesses("data/processes.txt");

        run(allProcesses);
    }

    public static void run(List<Process> listOfProcesses) {
        int n = listOfProcesses.size();
        List<Process> queue = new ArrayList<>();
        int index = 0;

        Process pNext = new Process();
        int completed = 0;
        int time = 0;

        while(completed < n) {
            // add the processes that arrive now to the process list
            while (index < n && listOfProcesses.get(index).arrivalTime <= time) {
                queue.add(listOfProcesses.get(index));
                index++;
            }

            /** To do:
             * Among all processes in the queue, find the process that shall be executed next
             * according to the chosen scheduling scheme.
             * Do this for all scheduling algorithms.
             */

            // During this time step, the process is executed
            /** To do:
             * Execute the process you have found.
             */
            time++;

            // All other processes need to wait
            /** To do:
             * Set the other processes into waiting state.
             */

            /** To do:
             * If the process is finished, mark it as completed.
             *
             * Make sure to not mix this up with time++, in order to set the correct timestamp for finishing a process.
             * E.g., a process that starts at time 0 and needs 2 time periods to execute shall finish at time 2.
             *
             */
        }
    }

    // To import processes from file
    /** To do:
     * If you implement priority scheduling, adapt this
     * to fit the format of data/prioritized_processes.txt
     * each line contains 4 parameters, separated by semicolons:
     * id; arrivalTime; burstTime; priority
     */
    private static List<Process> loadProcesses(String path) {
        List<Process> processes = new ArrayList<>();
        Process process;
        String id;
        int arrivalTime;
        int burstTime;

        try {
            File fileObject = new File(path);
            Scanner sc = new Scanner(fileObject);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                data = data.replaceAll("\\s", "");
                String[] fields = data.split(";");
                if (fields.length >= 3) {
                    id = fields[0];
                    arrivalTime = Integer.parseInt(fields[1]);
                    burstTime = Integer.parseInt(fields[2]);
                    process = new Process(id, arrivalTime, burstTime);
                    processes.add(process);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found error.");
            e.printStackTrace();
        }

        return processes;
    }

    /** To do:
     * Your task is to implement the following 4 functions
     *
     */

    // First-Come First-Served
    private static Process fcfs(List<Process> queue) {
        Process pNext = new Process();
        // add your code here
        return pNext;
    }

    // Shortest Job Next
    private static Process sjn(List<Process> queue) {
        Process pNext = new Process();
        // add your code here
        return pNext;
    }

    // Shortest Remaining Time
    private static Process srt(List<Process> queue) {
        Process pNext = new Process();
        // add your code here
        return pNext;
    }

    // Round Robin
    private static Process rr(List<Process> queue) {
        Process pNext = new Process();
        // add your code here
        return pNext;
    }

    /** To do:
     * For VG, implement Priority Scheduling also
     *
     * Add a comment here if you have implemented this function and want to be evaluated for VG
     */

    // Priority Scheduling
    private static Process ps(List<Process> queue) {
        Process pNext = new Process();
        // add your code here
        return pNext;
    }
}