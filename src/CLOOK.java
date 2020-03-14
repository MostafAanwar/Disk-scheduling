import java.util.Collections;
import java.util.Vector;

public class CLOOK {
    public void cLookExec(int[] requests, int head, int size) {
        int seek_count = 0;
        int distance, cur_track;
        Vector<Integer> left = new Vector<>(),
                right = new Vector<>();
        Vector<Integer> seek_sequence = new Vector<>();
        for (int i = 0; size > i; i++) {
            if ( head > requests[i])
                left.add(requests[i]);
            if ( head < requests[i])
                right.add(requests[i]);
        }
        Collections.sort(left);
        Collections.sort(right);
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);
            seek_sequence.add(cur_track);
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }
        seek_count += Math.abs(head - left.get(0));
        head = left.get(0);
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);
            seek_sequence.add(cur_track);
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }

        System.out.println("Total number of seek operations = " + seek_count);
        System.out.println("Seek Sequence is: ");
        for (int i = 0; i < seek_sequence.size(); i++) {
            System.out.println(seek_sequence.get(i));
        }

    }
}
