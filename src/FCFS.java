public class FCFS {

    static void fcfsExec(int trackArray[], int head, int size){
        int seekCount = 0;
        int distance, currentTrack;
        for (int i = 0; i < size; i++)
        {
            currentTrack = trackArray[i];
            distance = Math.abs(currentTrack - head);
            seekCount += distance;

            head = currentTrack;
        }

        System.out.println("Total number of seek operations = " + seekCount);
        System.out.println("Seek Sequence is");

        for (int i = 0; i < size; i++)
        {
            System.out.println(trackArray[i]);
        }
    }
}
