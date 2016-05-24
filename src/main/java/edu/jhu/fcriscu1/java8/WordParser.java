package edu.jhu.fcriscu1.java8;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by fcriscuolo on 5/2/16.
 */
public class WordParser {
    public static void main(String args[]) {
        if (args.length == 1) {
            String stringToExamine = args[0];
            //print each word in order
            BreakIterator boundary = BreakIterator.getWordInstance();
            boundary.setText(stringToExamine);
            printEachForward(boundary, stringToExamine);
            //print each sentence in reverse order
            boundary = BreakIterator.getSentenceInstance(Locale.US);
            boundary.setText(stringToExamine);
            printEachBackward(boundary, stringToExamine);
            printFirst(boundary, stringToExamine);
            printLast(boundary, stringToExamine);
        }
    }

    public static void printEachForward(BreakIterator boundary, String source) {

        int start = boundary.first();
        for (int end = boundary.next();
             end != BreakIterator.DONE;
             start = end, end = boundary.next()) {
            System.out.println(source.substring(start,end));
        }
    }

    public static void printEachBackward(BreakIterator boundary, String source) {
        int end = boundary.last();
        for (int start = boundary.previous();
             start != BreakIterator.DONE;
             end = start, start = boundary.previous()) {
            System.out.println(source.substring(start,end));
        }
    }
    public static void printFirst(BreakIterator boundary, String source) {
        int start = boundary.first();
        int end = boundary.next();
        System.out.println(source.substring(start,end));
    }
    public static void printLast(BreakIterator boundary, String source) {
        int end = boundary.last();
        int start = boundary.previous();
        System.out.println(source.substring(start,end));
    }

    public static void printAt(BreakIterator boundary, int pos, String source) {
        int end = boundary.following(pos);
        int start = boundary.previous();
        System.out.println(source.substring(start,end));
    }
    public static int nextWordStartAfter(int pos, String text) {
        BreakIterator wb = BreakIterator.getWordInstance();
        wb.setText(text);
        int last = wb.following(pos);
        int current = wb.next();
        while (current != BreakIterator.DONE) {
            for (int p = last; p < current; p++) {
                if (Character.isLetter(text.codePointAt(p)))
                    return last;
            }
            last = current;
            current = wb.next();
        }
        return BreakIterator.DONE;
    }


}
