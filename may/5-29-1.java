public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =0;
        while(sc.hasNextInt()) {
            n = sc.nextInt();

            if (n > 1000) {
                n = 1000;
            }
            List<Integer> li = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                li.add(i);
            }
            int tem = 0;
            while (li.size() > 1) {
                tem = (tem + 2) % li.size();
                li.remove(tem);
            }
            System.out.println(li.get(0));
        }

    }
