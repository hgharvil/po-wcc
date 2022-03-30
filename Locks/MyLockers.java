public class MyLockers {
    private boolean[] booleanArray = new boolean[100];

    public void show() {
        for (int i = 1; i - 1 < booleanArray.length; i++) {
            if (!booleanArray[i - 1])
                System.out.println("Locker " + i + ": closed");
            else {
                System.out.println("Locker " + i + ": open");
            }
        }
    }

    public void openAll() {
        for (int i = 1; i - 1 < booleanArray.length; i++) {
            booleanArray[i - 1] = true;
        }
    }

    public void close(int pass) {
        for (int i = 1; i - 1 < booleanArray.length; i++) {
            if (i % pass == 0) {
                booleanArray[i - 1] = false;
            }
        }
    }

    public void toogle(int pass) {
        for (int i = 1; i - 1 < booleanArray.length; i++) {
            if (i % pass == 0) {
                if (booleanArray[i - 1] == false) {
                    booleanArray[i - 1] = true;
                } else {
                    booleanArray[i - 1] = false;
                }
            }
        }

    }

    public void greatToogle(int pass) {
        while (pass <= booleanArray.length) {
            for (int i = 1; i - 1 < booleanArray.length; i++) {
                if (i % pass == 0) {
                    if (booleanArray[i - 1] == false){
                        booleanArray[i - 1] = true;
                    }else
                        booleanArray[i - 1] = false;
                }
            }
            pass++;
        }
    }

    public int openCount(){
        int aux = 0;
        for(boolean i : booleanArray){
            if(i) aux++;
        }
        return aux;
    }

    public static void main(String[] args) {
        MyLockers lockers = new MyLockers();
        lockers.openAll();
        lockers.close(2);
        // lockers.toogle(3);
        lockers.greatToogle(3);

        // lockers.show();
        System.out.println("Open lockers: "+lockers.openCount());

    }
}
