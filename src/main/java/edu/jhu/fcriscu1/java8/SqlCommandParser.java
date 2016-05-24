package edu.jhu.fcriscu1.java8;

import autovalue.shaded.com.google.common.common.collect.Lists;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * Created by fcriscuolo on 5/3/16.
 */
public class SqlCommandParser {
   static  List<String>  goodList = Lists.newArrayList("select","distinct(patid)",
            "from", "encounter", "where");
    static List<String> badList = Lists.newArrayList("insert","update","delete");
     static String testQuery = "select distinct(patid)\n" +
            "from \"encounter\"\n" +
            "where facilityid in ('3','9') and encounterid in\n" +
            "(select procedures.encounterid\n" +
            "from \"procedures\", \"encounter\", \"demographic\"\n" +
            "where encounter.patid = procedures.patid and procedures.patid = demographic.patid\n" +
            "and px in ('38.93', '36556', '36558', '36559', '36561', '36563', '36565',\n" +
            " '36566', '36569', '36571', '75998', '76937', '77001') and facilityid in ('3','9')\n" +
            " and encounter.enc_type = 'AV' and encounter.admit_date > procedures.admit_date\n" +
            " and procedures.admit_date > (birth_date + 6573))";

    static Splitter  blankSplitter = Splitter.on(" ");
    public static void main(String[] args) {
        int expectedCount = 5;
        long goodCount = 0;
        String s2 = testQuery.toLowerCase().replaceAll("\n"," ").replaceAll("\"","");
        List<String> sub = blankSplitter.splitToList(s2).subList(0,expectedCount);
        goodCount = blankSplitter.splitToList( s2).subList(0,expectedCount).stream()
              .filter((w)-> goodList.contains(w))
             .count();
         long badCount = blankSplitter.splitToList( s2).stream()
                 .filter((w)-> badList.contains(w))
                 .count();

        if (goodCount == goodList.size() && badCount == 0){
            System.out.println("The SQL command is valid");
        } else {
            System.out.println("The SQL command: " +testQuery +" is invalid\n"
            +"goodCount = " +goodCount +" badCount = " +badCount);
        }
    }
}
