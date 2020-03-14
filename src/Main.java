import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the head: ");
        int head = in.nextInt();
        System.out.print("Enter number of requests: ");
        int size = in.nextInt();
        System.out.println("Enter the requests: ");
        int requests[] = new int[size];
        for(int i = 0 ; i < size ; i++){
            requests[i] = in.nextInt();
        }
        int choice = 1;
        while (choice != 0){
            System.out.println("choose which disk scheduling technique you want to execute [0 to exit]: ");
            System.out.println("1: FCFS");
            System.out.println("2: SSTF");
            System.out.println("3: SCAN");
            System.out.println("4: C-SCAN");
            System.out.println("5: C-LOOk");
            choice = in.nextInt();
            if(choice == 1){
                FCFS fcfs = new FCFS();
                fcfs.fcfsExec(requests,head,size);
            }
            else if(choice == 2){
                SSTF sstf = new SSTF();
                sstf.sstfExec(requests,head,size);
            }
            else if(choice == 3){
                SCAN scan = new SCAN();
                System.out.print("Enter disk size: ");
                int diskSize = in.nextInt();
                System.out.print("Enter the direction: ");
                String direction = in.next();

                scan.scanExec(requests,head,size,diskSize,direction);
            }
            else if(choice == 4){
                CSCAN cScan = new CSCAN();
                System.out.print("Enter disk size: ");
                int diskSize = in.nextInt();
                cScan.cScanExec(requests,head,size,diskSize);
            }
            else if(choice == 5){
                CLOOK cLook = new CLOOK();
                cLook.cLookExec(requests,head,size);
            }
            else if(choice == 0){
                System. exit(0);
            }
        }
    }
}
