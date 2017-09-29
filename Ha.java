import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * @author dasham
 */
public class Ha {
    public static void main(String[] args) throws IOException{


//        String sc = new Scanner(new File("input.txt")).useDelimiter("\\Z").next();
//        System.setOut(new PrintStream("output.txt"));
//        System.out.println(sc.replace("\n"," "));
//        System.out.println();

        Scanner sc = new Scanner(new File("input.txt"));
        System.setOut(new PrintStream("output.txt"));



        HashSet<String> skip = new HashSet(Arrays.asList("a", "in", "at", "to", "on", "not", "for", "s","'s","'d","'re","is",
                "are","am","has","I","we","you"));

       // System.out.println(sc.nextLine());
        String cur;

        Hashtable<String, Integer> dict = new Hashtable();
        while(sc.hasNext()) {

//            cur = sc.next().toLowerCase().replaceAll("[.,]", "").trim();
//           // System.out.println(cur+"-curr ");
//            if (skip.contains(cur)) {
//                System.out.println(cur + "-skip ");
//            continue;}
//                else {
//                if (dict.containsKey(cur)) {
//                    dict.put(cur, dict.get(cur) + 1);
//
//
//                } else {
//                    if (cur.endsWith("s")){
//                        if (dict.containsKey(cur.substring(0, cur.length() - 2)))
//                            dict.put(cur.substring(0, cur.length() - 2), dict.get(cur.substring(0, cur.length() - 2) + 1));}
//                        else {
//                            String nov = cur.concat("s");
//                            if (dict.containsKey(nov)) dict.put(cur, dict.get(nov) + 1);
//                            else dict.put(cur,1);
//                        }
//                }
//        }

            cur = sc.next().toLowerCase().replaceAll("[.,]", "").trim();
            if (!skip.contains(cur)) {
                if (dict.containsKey(cur)) dict.put(cur,dict.get(cur)+1);
                else {  String nov = cur + "s";
                if (dict.containsKey(nov)) dict.put(cur,dict.get(nov)+1);
                else if (cur.endsWith("s")){
                    String newStr = cur.substring(0, cur.length()-1);
                    if (dict.containsKey(newStr)) dict.put(newStr,dict.get(newStr)+1);
                else dict.put(cur,1);} else dict.put(cur,1);
                }


                }
            }



//        for(Map.Entry<String, Integer> m : dict.entrySet()){
//            if (m.getValue()>1) System.out.printf("<\"%s\", %d>\n",m.getKey(),m.getValue());
//        }

        ArrayList<String> keys = new ArrayList(dict.keySet());
        Collections.sort(keys);
        String newLine = "";

        for(String s:keys){

            if (dict.get(s)>1){ System.out.printf(newLine+"<\"%s\", %d>",s,dict.get(s));
            newLine = "\n";}
        }


     // System.out.println(dict.toString());

    }

}
