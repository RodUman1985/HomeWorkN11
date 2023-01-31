public   class  Calculator {
    public static int  calc(String stad){
        String[] arr = stad.split(" ");
        int a=Integer.parseInt(arr[0]);
        int b=Integer.parseInt(arr[2]);
        String c=arr[1];
        switch (c){
            case "-":
                return a-b;
            case "+":
                return a+b;

        }
        return -1;
    }
}