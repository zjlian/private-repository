package std;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public final class stdio {

    // force Unicode UTF-8 encoding; otherwise it's system dependent
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with StdIn
    private static final Locale LOCALE = Locale.US;

    // send output here
    private static PrintWriter out;

    // the default token separator; we maintain the invariant that this value
    // is held by the scanner's delimiter between calls
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    // makes whitespace significant
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    // used to read the entire input
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    /*** end: section (1 of 2) of code duplicated from In to StdIn. */

    private static Scanner scanner;
 

    // this is called before invoking any methods
    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    // don't instantiate
    private stdio() { }

   /**
     * Closes standard output.
     */
    public static void close() {
        out.close();
    }

   /**
     * Terminates the current line by printing the line-separator string.
     */
    public static void println() {
        out.println();
    }

   /**
     * Prints an object to this output stream and then terminates the line.
     *
     * @param x the object to print
     */
    public static void println(Object x) {
        out.println(x);
    }

   /**
     * Prints a boolean to standard output and then terminates the line.
     *
     * @param x the boolean to print
     */
    public static void println(boolean x) {
        out.println(x);
    }

   /**
     * Prints a character to standard output and then terminates the line.
     *
     * @param x the character to print
     */
    public static void println(char x) {
        out.println(x);
    }

   /**
     * Prints a double to standard output and then terminates the line.
     *
     * @param x the double to print
     */
    public static void println(double x) {
        out.println(x);
    }

   /**
     * Prints an integer to standard output and then terminates the line.
     *
     * @param x the integer to print
     */
    public static void println(float x) {
        out.println(x);
    }

   /**
     * Prints an integer to standard output and then terminates the line.
     *
     * @param x the integer to print
     */
    public static void println(int x) {
        out.println(x);
    }

   /**
     * Prints a long to standard output and then terminates the line.
     *
     * @param x the long to print
     */
    public static void println(long x) {
        out.println(x);
    }

   /**
     * Prints a short integer to standard output and then terminates the line.
     *
     * @param x the short to print
     */
    public static void println(short x) {
        out.println(x);
    }

   /**
     * Prints a byte to standard output and then terminates the line.
     * <p>
     * To write binary data, see {@link Binarystdio}.
     *
     * @param x the byte to print
     */
    public static void println(byte x) {
        out.println(x);
    }

   /**
     * Flushes standard output.
     */
    public static void print() {
        out.flush();
    }

   /**
     * Prints an object to standard output and flushes standard output.
     * 
     * @param x the object to print
     */
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a boolean to standard output and flushes standard output.
     * 
     * @param x the boolean to print
     */
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a character to standard output and flushes standard output.
     * 
     * @param x the character to print
     */
    public static void print(char x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a double to standard output and flushes standard output.
     * 
     * @param x the double to print
     */
    public static void print(double x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a float to standard output and flushes standard output.
     * 
     * @param x the float to print
     */
    public static void print(float x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints an integer to standard output and flushes standard output.
     * 
     * @param x the integer to print
     */
    public static void print(int x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a long integer to standard output and flushes standard output.
     * 
     * @param x the long integer to print
     */
    public static void print(long x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a short integer to standard output and flushes standard output.
     * 
     * @param x the short integer to print
     */
    public static void print(short x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a byte to standard output and flushes standard output.
     *
     * @param x the byte to print
     */
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }

   /**
     * Prints a formatted string to standard output, using the specified format
     * string and arguments, and then flushes standard output.
     *
     *
     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
     * @param args   the arguments accompanying the format string
     */
    public static void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }

   /**
     * Prints a formatted string to standard output, using the locale and
     * the specified format string and arguments; then flushes standard output.
     *
     * @param locale the locale
     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
     * @param args   the arguments accompanying the format string
     */
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }


    /*@StdOut*/
    /**
     * Returns true if standard input is empty (except possibly for whitespace).
     * Use this method to know whether the next call to {@link #readString()}, 
     * {@link #readDouble()}, etc will succeed.
     *
     * @return {@code true} if standard input is empty (except possibly
     *         for whitespace); {@code false} otherwise
     */
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

   /**
     * Returns true if standard input has a next line.
     * Use this method to know whether the
     * next call to {@link #readLine()} will succeed.
     * This method is functionally equivalent to {@link #hasNextChar()}.
     *
     * @return {@code true} if standard input has more input (including whitespace);
     *         {@code false} otherwise
     */
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Returns true if standard input has more inputy (including whitespace).
     * Use this method to know whether the next call to {@link #readChar()} will succeed.
     * This method is functionally equivalent to {@link #hasNextLine()}.
     *
     * @return {@code true} if standard input has more input (including whitespace);
     *         {@code false} otherwise
     */
    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }


   /**
     * Reads and returns the next line, excluding the line separator if present.
     *
     * @return the next line, excluding the line separator if present;
     *         {@code null} if no such line
     */
    public static String readLine() {
        String line;
        try {
            line = scanner.nextLine();
        }
        catch (NoSuchElementException e) {
            line = null;
        }
        return line;
    }

    /**
     * Reads and returns the next character.
     *
     * @return the next {@code char}
     * @throws NoSuchElementException if standard input is empty
     */
    public static char readChar() {
        try {
            scanner.useDelimiter(EMPTY_PATTERN);
            String ch = scanner.next();
            assert ch.length() == 1 : "Internal (Std)In.readChar() error!"
                + " Please contact the authors.";
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return ch.charAt(0);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'char' value from standard input, but there are no more tokens available");
        }
    }  


   /**
     * Reads and returns the remainder of the input, as a string.
     *
     * @return the remainder of the input, as a string
     * @throws NoSuchElementException if standard input is empty
     */
    public static String readAll() {
        if (!scanner.hasNextLine())
            return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimeter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }


   /**
     * Reads the next token  and returns the {@code String}.
     *
     * @return the next {@code String}
     * @throws NoSuchElementException if standard input is empty
     */
    public static String readString() {
        try {
            return scanner.next();
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'String' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Reads the next token from standard input, parses it as an integer, and returns the integer.
     *
     * @return the next integer on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as an {@code int}
     */
    public static int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from standard input, but there are no more tokens available");
        }

    }

   /**
     * Reads the next token from standard input, parses it as a double, and returns the double.
     *
     * @return the next double on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code double}
     */
    public static double readDouble() {
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'double' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'double' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Reads the next token from standard input, parses it as a float, and returns the float.
     *
     * @return the next float on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code float}
     */
    public static float readFloat() {
        try {
            return scanner.nextFloat();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'float' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'float' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Reads the next token from standard input, parses it as a long integer, and returns the long integer.
     *
     * @return the next long integer on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code long}
     */
    public static long readLong() {
        try {
            return scanner.nextLong();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'long' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'long' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Reads the next token from standard input, parses it as a short integer, and returns the short integer.
     *
     * @return the next short integer on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code short}
     */
    public static short readShort() {
        try {
            return scanner.nextShort();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'short' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'short' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Reads the next token from standard input, parses it as a byte, and returns the byte.
     *
     * @return the next byte on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code byte}
     */
    public static byte readByte() {
        try {
            return scanner.nextByte();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'byte' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'byte' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads the next token from standard input, parses it as a boolean,
     * and returns the boolean.
     *
     * @return the next boolean on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code boolean}:
     *    {@code true} or {@code 1} for true, and {@code false} or {@code 0} for false,
     *    ignoring case
     */
    public static boolean readBoolean() {
        try {
            String token = readString();
            if ("true".equalsIgnoreCase(token))  return true;
            if ("false".equalsIgnoreCase(token)) return false;
            if ("1".equals(token))               return true;
            if ("0".equals(token))               return false;
            throw new InputMismatchException("attempts to read a 'boolean' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'boolean' value from standard input, but there are no more tokens available");
        }

    }

    /**
     * Reads all remaining tokens from standard input and returns them as an array of strings.
     *
     * @return all remaining tokens on standard input, as an array of strings
     */
    public static String[] readAllStrings() {
        // we could use readAll.trim().split(), but that's not consistent
        // because trim() uses characters 0x00..0x20 as whitespace
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;

        // don't include first token if it is leading whitespace
        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }

    /**
     * Reads all remaining lines from standard input and returns them as an array of strings.
     * @return all remaining lines on standard input, as an array of strings
     */
    public static String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<String>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Reads all remaining tokens from standard input, parses them as integers, and returns
     * them as an array of integers.
     * @return all remaining integers on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as an {@code int}
     */
    public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }
    /**
     * @myFunc
     * 
    public static int[] readInts() {
    	Queue<Integer> q = new Queue<Integer>(50);
    	while(!stdio.isEmpty()) {
    		q.enqueue(stdio.readInt());
    	}
    	int N = q.length();
    	int[] a = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		a[i] = q.dequeue();
    	}
    	
    	return a;
    }*/

    /**
     * Reads all remaining tokens from standard input, parses them as longs, and returns
     * them as an array of longs.
     * @return all remaining longs on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code long}
     */
    public static long[] readAllLongs() {
        String[] fields = readAllStrings();
        long[] vals = new long[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Long.parseLong(fields[i]);
        return vals;
    }

    /**
     * Reads all remaining tokens from standard input, parses them as doubles, and returns
     * them as an array of doubles.
     * @return all remaining doubles on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code double}
     */
    public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }
    
    //// end: section (2 of 2) of code duplicated from In to StdIn
    
    
    // do this once when StdIn is initialized
    static {
        resync();
    }

    /**
     * If StdIn changes, use this to reinitialize the scanner.
     */
    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }
    
    private static void setScanner(Scanner scanner) {
        stdio.scanner = scanner;
        stdio.scanner.useLocale(LOCALE);
    }
   /**
     * Unit tests some of the methods in {@code stdio}.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // write to stdio
        stdio.println("Test");
        stdio.println(17);
        stdio.println(true);
        stdio.printf("%.6f\n", 1.0/7.0);
        
        stdio.print("Type a string: ");
        String s = stdio.readString();
        stdio.println("Your string was: " + s);
        stdio.println();

        stdio.print("Type an int: ");
        int a = stdio.readInt();
        stdio.println("Your int was: " + a);
        stdio.println();

        stdio.print("Type a boolean: ");
        boolean b = stdio.readBoolean();
        stdio.println("Your boolean was: " + b);
        stdio.println();

        stdio.print("Type a double: ");
        double c = stdio.readDouble();
        stdio.println("Your double was: " + c);
        stdio.println();
    }

}