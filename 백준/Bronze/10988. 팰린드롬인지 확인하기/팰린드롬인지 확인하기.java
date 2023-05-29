import java.io.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine();

        for(int i=0; i<st.length()/2; i++){
            if(st.charAt(i) != st.charAt(st.length()-1-i)) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");

    }
}
