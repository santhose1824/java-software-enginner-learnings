public class TypeConversionDemo {

    public static void main(String[] args) {

        // ---------- 1. Type CONVERSION (widening / implicit) ----------
        // Conditions: 1) the two types are compatible
        //             2) destination type is greater than (or equal to) source type
        int   i = 67;
        float f = i;          // int -> float (automatic)
        double d = f;         // float -> double
        long  l = i;          // int -> long
        System.out.println("int -> float  : " + f);
        System.out.println("float -> double: " + d);
        System.out.println("int -> long   : " + l);

        // Java also converts an integer literal constant to byte/short/char automatically
        byte  b1 = 10;        // 10 is an int literal, but fits in a byte
        short s1 = 200;
        char  c1 = 65;        // 65 -> 'A'
        System.out.println("char c1 = 65 -> " + c1);

        // ---------- 2. Type CASTING (narrowing / explicit) ----------
        // Float -> int is not automatic, we must cast
        int num = (int) 67.9f;            // decimal part is dropped (not rounded)
        System.out.println("(int) 67.9f = " + num);

        // ---------- 3. Narrowing with overflow (modulo) ----------
        int a = 257;
        byte b = (byte) a;                // 257 % 256 = 1
        System.out.println("(byte) 257 = " + b);

        int big = 130;
        System.out.println("(byte) 130 = " + (byte) big);   // 130 - 256 = -126

        // ---------- 4. Automatic type promotion in expressions ----------
        // Case 2: byte * byte / byte -> everything is promoted to int
        byte x = 40;
        byte y = 50;
        byte z = 100;
        int result = (x * y) / z;         // (40*50)/100 -> 2000/100 = 20 (2000 would not fit in a byte)
        System.out.println("(40 * 50) / 100 = " + result);

        // Case 3: b = b * 10  -> compile error, because b * 10 is an int
        byte bb = 50;
        // bb = bb * 10;                  // ERROR: incompatible types: possible lossy conversion from int to byte
        bb = (byte) (bb * 10);            // fix: explicit cast (500 % 256 = 244 -> -12)
        System.out.println("bb after cast = " + bb);
        bb *= 1;                          // compound assignment (*=) has an IMPLICIT cast - no error
        byte cc = 50;
        cc *= 10;                         // legal! same as cc = (byte)(cc * 10)
        System.out.println("cc *= 10 -> " + cc);

        // ---------- 5. Promotion rules with mixed types ----------
        byte  bt = 42;
        char  ch = 'a';
        short sh = 1024;
        int   in = 50000;
        float fl = 5.67f;
        double db = 0.1234;

        // (fl * bt)  -> float
        // (in / ch)  -> int
        // (db - sh)  -> double
        double answer = (fl * bt) + (in / ch) - (db - sh);
        System.out.println("answer = " + answer);

        // Rules:
        //  1. byte, short, char  -> int  (in any expression)
        //  2. if any operand is long   -> whole expression is long
        //  3. if any operand is float  -> whole expression is float
        //  4. if any operand is double -> whole expression is double
        System.out.println("byte + byte   = " + ((Object) (bt + bt)).getClass().getSimpleName());
        System.out.println("int  + long   = " + ((Object) (in + 5L)).getClass().getSimpleName());
        System.out.println("int  + float  = " + ((Object) (in + 5f)).getClass().getSimpleName());
        System.out.println("float+ double = " + ((Object) (fl + db)).getClass().getSimpleName());
        System.out.println("char + int    = " + ((Object) (ch + 1)).getClass().getSimpleName());

        // ---------- 6. Order of widening ----------
        // byte -> short -> int -> long -> float -> double
        //           char -> int
        // (long -> float is allowed even though both are... long is 8 bytes, float 4: some precision may be lost)
        long  bigLong = 123456789123456789L;
        float asFloat = bigLong;                       // allowed, but loses precision
        System.out.println("long -> float = " + (long) asFloat);
    }
}
