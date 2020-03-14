public class SSTF {

    public static void calculateDifference(int queue[],int head, NODE diff[])
    {
        for (int i = 0; i < diff.length; i++)
            diff[i].distance = Math.abs(queue[i] - head);
    }

    public static int findMin(NODE diff[])
    {
        int index = -1, minimum = Integer.MAX_VALUE;

        for (int i = 0; i < diff.length; i++) {
            if (!diff[i].accessed && minimum > diff[i].distance) {
                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }

    public void sstfExec(int[] requests, int head, int size) {
        if (requests.length == 0)
            return;
        NODE diff[] = new NODE[requests.length];

        for (int i = 0; i < diff.length; i++) {
            diff[i] = new NODE();
        }
        int seek_count = 0;

        int[] seek_sequence = new int[requests.length + 1];

        for (int i = 0; i < requests.length; i++) {

            seek_sequence[i] = head;
            calculateDifference(requests, head, diff);
            int index = findMin(diff);
            diff[index].accessed = true;
            seek_count += diff[index].distance;
            head = requests[index];
        }

        seek_sequence[seek_sequence.length - 1] = head;
        System.out.println("Total number of seek operations = " + seek_count);
        System.out.println("Seek Sequence is");

        for (int i = 0; i < seek_sequence.length; i++)
            System.out.println(seek_sequence[i]);
    }
}
