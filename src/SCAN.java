import java.util.Collections;
import java.util.Vector;

public class SCAN {

    public void scanExec(int[] requests, int head, int size, int diskSize , String direction) {
        int seek_count = 0;
        int distance, cur_track;
        Vector<Integer> left = new Vector<>(),
                        right = new Vector<>();
        Vector<Integer> seek_sequence = new Vector<>();

        if (direction.equals("left"))
            left.add(0);

        else if (direction.equals("right"))
            right.add(diskSize - 1);

        for (int i = 0; i < size; i++)
        {
            if (requests[i] < head)
                left.add(requests[i]);
            if (requests[i] > head)
                right.add(requests[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int run = 2;
        while (run-- >0)
        {
            if (direction.equals("left"))
            {
                for (int i = left.size() - 1; i >= 0; i--)
                {
                    cur_track = left.get(i);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - head);
                    seek_count += distance;
                    head = cur_track;
                }
                direction = "right";
            }
            else if (direction.equals("right"))
            {
                for (int i = 0; i < right.size(); i++)
                {
                    cur_track = right.get(i);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - head);
                    seek_count += distance;
                    head = cur_track;
                }
                direction = "left";
            }
        }

        System.out.println("Total number of seek operations = " + seek_count );
        System.out.println("Seek Sequence is: ");

        for (int i = 0; i < seek_sequence.size(); i++)
        {
            System.out.println(seek_sequence.get(i));
        }

    }
}
