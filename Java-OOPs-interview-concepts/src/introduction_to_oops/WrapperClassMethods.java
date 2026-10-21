package introduction_to_oops;

/*
 * ============================================================================
 *  WrapperClassMethods.java
 * ============================================================================
 *  A complete, runnable reference showing EVERY (non-deprecated) public
 *  constant and method of the 8 Java wrapper classes, each with an example:
 *
 *      Byte | Short | Integer | Long | Float | Double | Character | Boolean
 *
 *
 *  Notes
 *   - The public constructors (new Integer(5), etc.) are deprecated for
 *     removal since Java 9, so they are intentionally NOT used. Use
 *     valueOf(...) or autoboxing instead.
 *   - Every example prints:   <expression>  ->  <result>
 * ============================================================================
 */
public class WrapperClassMethods {

    // ------------------------------------------------------------------
    // Small helpers for pretty printing
    // ------------------------------------------------------------------
    private static void title(String text) {
        String line = "=".repeat(70);
        System.out.println("\n" + line);
        System.out.println("  " + text);
        System.out.println(line);
    }

    private static void section(String text) {
        System.out.println("\n--- " + text + " ---");
    }

    private static void p(String expression, Object result) {
        System.out.printf("  %-52s -> %s%n", expression, result);
    }

    // ------------------------------------------------------------------
    // main
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        if (args.length == 0) {
            byteDemo();
            shortDemo();
            integerDemo();
            longDemo();
            floatDemo();
            doubleDemo();
            characterDemo();
            booleanDemo();
            return;
        }
        for (String name : args) {
            switch (name.toLowerCase()) {
                case "byte":      byteDemo();      break;
                case "short":     shortDemo();     break;
                case "integer":
                case "int":       integerDemo();   break;
                case "long":      longDemo();      break;
                case "float":     floatDemo();     break;
                case "double":    doubleDemo();    break;
                case "character":
                case "char":      characterDemo(); break;
                case "boolean":   booleanDemo();   break;
                default: System.out.println("Unknown wrapper class: " + name);
            }
        }
    }

    // ======================================================================
    //  1. BYTE  (primitive: byte, 8-bit signed, -128 .. 127)
    // ======================================================================
    static void byteDemo() {
        title("1. Byte  (primitive: byte)");

        section("Constants");
        p("Byte.MIN_VALUE", Byte.MIN_VALUE);
        p("Byte.MAX_VALUE", Byte.MAX_VALUE);
        p("Byte.SIZE (bits)", Byte.SIZE);
        p("Byte.BYTES", Byte.BYTES);
        p("Byte.TYPE", Byte.TYPE);

        section("Creating objects");
        p("Byte.valueOf((byte) 10)", Byte.valueOf((byte) 10));
        p("Byte.valueOf(\"25\")", Byte.valueOf("25"));
        p("Byte.valueOf(\"1A\", 16)  [hex string]", Byte.valueOf("1A", 16));
        Byte autoBoxed = 50;                       // autoboxing
        p("Byte autoBoxed = 50;  (autoboxing)", autoBoxed);
        byte unboxed = autoBoxed;                  // unboxing
        p("byte unboxed = autoBoxed;  (unboxing)", unboxed);

        section("Parsing / decoding Strings");
        p("Byte.parseByte(\"100\")", Byte.parseByte("100"));
        p("Byte.parseByte(\"-1010\", 2)  [binary]", Byte.parseByte("-1010", 2));
        p("Byte.decode(\"0x10\")  [hex]", Byte.decode("0x10"));
        p("Byte.decode(\"010\")   [octal]", Byte.decode("010"));
        p("Byte.decode(\"#7F\")   [hex]", Byte.decode("#7F"));

        section("Converting to String");
        Byte b = 65;
        p("b.toString()", b.toString());
        p("Byte.toString((byte) 99)", Byte.toString((byte) 99));

        section("Conversion to other number types (Number methods)");
        p("b.byteValue()", b.byteValue());
        p("b.shortValue()", b.shortValue());
        p("b.intValue()", b.intValue());
        p("b.longValue()", b.longValue());
        p("b.floatValue()", b.floatValue());
        p("b.doubleValue()", b.doubleValue());

        section("Comparison");
        Byte x = 10, y = 20;
        p("x.compareTo(y)   [x=10, y=20]", x.compareTo(y));
        p("Byte.compare((byte) 30, (byte) 20)", Byte.compare((byte) 30, (byte) 20));
        p("x.equals(10)  [Integer, not Byte]", x.equals(10));
        p("x.equals((byte) 10)", x.equals((byte) 10));

        section("Hash code");
        p("x.hashCode()", x.hashCode());
        p("Byte.hashCode((byte) 10)", Byte.hashCode((byte) 10));

        section("Unsigned conversion");
        byte negative = (byte) 200;               // stored as -56
        p("(byte) 200  (stored value)", negative);
        p("Byte.toUnsignedInt((byte) 200)", Byte.toUnsignedInt(negative));
        p("Byte.toUnsignedLong((byte) 200)", Byte.toUnsignedLong(negative));
    }

    // ======================================================================
    //  2. SHORT  (primitive: short, 16-bit signed, -32768 .. 32767)
    // ======================================================================
    static void shortDemo() {
        title("2. Short  (primitive: short)");

        section("Constants");
        p("Short.MIN_VALUE", Short.MIN_VALUE);
        p("Short.MAX_VALUE", Short.MAX_VALUE);
        p("Short.SIZE (bits)", Short.SIZE);
        p("Short.BYTES", Short.BYTES);
        p("Short.TYPE", Short.TYPE);

        section("Creating objects");
        p("Short.valueOf((short) 1000)", Short.valueOf((short) 1000));
        p("Short.valueOf(\"2500\")", Short.valueOf("2500"));
        p("Short.valueOf(\"FF\", 16)", Short.valueOf("FF", 16));
        Short autoBoxed = 123;
        p("Short autoBoxed = 123;  (autoboxing)", autoBoxed);

        section("Parsing / decoding Strings");
        p("Short.parseShort(\"3000\")", Short.parseShort("3000"));
        p("Short.parseShort(\"-777\", 8)  [octal]", Short.parseShort("-777", 8));
        p("Short.decode(\"0xFF\")", Short.decode("0xFF"));
        p("Short.decode(\"-010\")  [octal]", Short.decode("-010"));

        section("Converting to String");
        Short s = 321;
        p("s.toString()", s.toString());
        p("Short.toString((short) -45)", Short.toString((short) -45));

        section("Conversion to other number types");
        p("s.byteValue()  [321 overflows a byte]", s.byteValue());
        p("s.shortValue()", s.shortValue());
        p("s.intValue()", s.intValue());
        p("s.longValue()", s.longValue());
        p("s.floatValue()", s.floatValue());
        p("s.doubleValue()", s.doubleValue());

        section("Comparison");
        Short a = 100, c = 200;
        p("a.compareTo(c)   [a=100, c=200]", a.compareTo(c));
        p("Short.compare((short) 5, (short) 5)", Short.compare((short) 5, (short) 5));
        p("a.equals((short) 100)", a.equals((short) 100));
        p("a.equals(100)  [Integer, not Short]", a.equals(100));

        section("Hash code");
        p("a.hashCode()", a.hashCode());
        p("Short.hashCode((short) 100)", Short.hashCode((short) 100));

        section("Byte order and unsigned conversion");
        p("Short.reverseBytes((short) 0x1234) as hex",
                Integer.toHexString(Short.reverseBytes((short) 0x1234) & 0xFFFF));
        p("Short.toUnsignedInt((short) -1)", Short.toUnsignedInt((short) -1));
        p("Short.toUnsignedLong((short) -1)", Short.toUnsignedLong((short) -1));
    }

    // ======================================================================
    //  3. INTEGER  (primitive: int, 32-bit signed)
    // ======================================================================
    static void integerDemo() {
        title("3. Integer  (primitive: int)");

        section("Constants");
        p("Integer.MIN_VALUE", Integer.MIN_VALUE);
        p("Integer.MAX_VALUE", Integer.MAX_VALUE);
        p("Integer.SIZE (bits)", Integer.SIZE);
        p("Integer.BYTES", Integer.BYTES);
        p("Integer.TYPE", Integer.TYPE);

        section("Creating objects");
        p("Integer.valueOf(100)", Integer.valueOf(100));
        p("Integer.valueOf(\"200\")", Integer.valueOf("200"));
        p("Integer.valueOf(\"FF\", 16)", Integer.valueOf("FF", 16));
        Integer autoBoxed = 77;
        p("Integer autoBoxed = 77;  (autoboxing)", autoBoxed);
        int unboxed = autoBoxed;
        p("int unboxed = autoBoxed;  (unboxing)", unboxed);

        section("Parsing / decoding Strings");
        p("Integer.parseInt(\"1234\")", Integer.parseInt("1234"));
        p("Integer.parseInt(\"-1010\", 2)  [binary]", Integer.parseInt("-1010", 2));
        p("Integer.parseInt(\"7F\", 16)    [hex]", Integer.parseInt("7F", 16));
        p("Integer.parseUnsignedInt(\"4294967295\")", Integer.parseUnsignedInt("4294967295"));
        p("Integer.parseUnsignedInt(\"FFFFFFFF\", 16)", Integer.parseUnsignedInt("FFFFFFFF", 16));
        p("Integer.decode(\"0x1F\")", Integer.decode("0x1F"));
        p("Integer.decode(\"017\")  [octal]", Integer.decode("017"));
        p("Integer.decode(\"-#A\")  [hex]", Integer.decode("-#A"));

        section("Converting to String");
        Integer n = 255;
        p("n.toString()", n.toString());
        p("Integer.toString(255)", Integer.toString(255));
        p("Integer.toString(255, 2)   [radix 2]", Integer.toString(255, 2));
        p("Integer.toString(255, 36)  [radix 36]", Integer.toString(255, 36));
        p("Integer.toBinaryString(10)", Integer.toBinaryString(10));
        p("Integer.toOctalString(64)", Integer.toOctalString(64));
        p("Integer.toHexString(255)", Integer.toHexString(255));
        p("Integer.toUnsignedString(-1)", Integer.toUnsignedString(-1));
        p("Integer.toUnsignedString(-1, 16)", Integer.toUnsignedString(-1, 16));
        p("Integer.toUnsignedLong(-1)", Integer.toUnsignedLong(-1));

        section("Conversion to other number types");
        p("n.byteValue()  [255 overflows a byte]", n.byteValue());
        p("n.shortValue()", n.shortValue());
        p("n.intValue()", n.intValue());
        p("n.longValue()", n.longValue());
        p("n.floatValue()", n.floatValue());
        p("n.doubleValue()", n.doubleValue());

        section("Comparison");
        Integer a = 10, b = 20;
        p("a.compareTo(b)   [a=10, b=20]", a.compareTo(b));
        p("Integer.compare(30, 20)", Integer.compare(30, 20));
        p("Integer.compareUnsigned(-1, 1)", Integer.compareUnsigned(-1, 1));
        p("a.equals(10)", a.equals(10));
        p("a.equals(10L)  [Long, not Integer]", a.equals(10L));

        section("Math helpers");
        p("Integer.sum(5, 7)", Integer.sum(5, 7));
        p("Integer.max(5, 7)", Integer.max(5, 7));
        p("Integer.min(5, 7)", Integer.min(5, 7));
        p("Integer.signum(-42)", Integer.signum(-42));
        p("Integer.divideUnsigned(-1, 2)", Integer.divideUnsigned(-1, 2));
        p("Integer.remainderUnsigned(-1, 10)", Integer.remainderUnsigned(-1, 10));

        section("Bit manipulation");
        p("Integer.bitCount(255)", Integer.bitCount(255));
        p("Integer.highestOneBit(100)", Integer.highestOneBit(100));
        p("Integer.lowestOneBit(100)", Integer.lowestOneBit(100));
        p("Integer.numberOfLeadingZeros(1)", Integer.numberOfLeadingZeros(1));
        p("Integer.numberOfTrailingZeros(8)", Integer.numberOfTrailingZeros(8));
        p("Integer.reverse(1)", Integer.reverse(1));
        p("Integer.reverseBytes(0x01020304) as hex",
                Integer.toHexString(Integer.reverseBytes(0x01020304)));
        p("Integer.rotateLeft(1, 4)", Integer.rotateLeft(1, 4));
        p("Integer.rotateRight(16, 4)", Integer.rotateRight(16, 4));

        section("System properties");
        System.setProperty("demo.int", "42");
        System.setProperty("demo.hex", "0x2A");
        p("Integer.getInteger(\"demo.int\")", Integer.getInteger("demo.int"));
        p("Integer.getInteger(\"demo.hex\")", Integer.getInteger("demo.hex"));
        p("Integer.getInteger(\"missing\", 99)  [default int]", Integer.getInteger("missing", 99));
        p("Integer.getInteger(\"missing\", Integer.valueOf(7))", Integer.getInteger("missing", Integer.valueOf(7)));

        section("Hash code");
        p("a.hashCode()", a.hashCode());
        p("Integer.hashCode(10)", Integer.hashCode(10));
    }

    // ======================================================================
    //  4. LONG  (primitive: long, 64-bit signed)
    // ======================================================================
    static void longDemo() {
        title("4. Long  (primitive: long)");

        section("Constants");
        p("Long.MIN_VALUE", Long.MIN_VALUE);
        p("Long.MAX_VALUE", Long.MAX_VALUE);
        p("Long.SIZE (bits)", Long.SIZE);
        p("Long.BYTES", Long.BYTES);
        p("Long.TYPE", Long.TYPE);

        section("Creating objects");
        p("Long.valueOf(100L)", Long.valueOf(100L));
        p("Long.valueOf(\"9876543210\")", Long.valueOf("9876543210"));
        p("Long.valueOf(\"FFFF\", 16)", Long.valueOf("FFFF", 16));
        Long autoBoxed = 5000000000L;
        p("Long autoBoxed = 5000000000L;  (autoboxing)", autoBoxed);

        section("Parsing / decoding Strings");
        p("Long.parseLong(\"123456789012\")", Long.parseLong("123456789012"));
        p("Long.parseLong(\"-1010\", 2)", Long.parseLong("-1010", 2));
        p("Long.parseUnsignedLong(\"18446744073709551615\")", Long.parseUnsignedLong("18446744073709551615"));
        p("Long.parseUnsignedLong(\"FFFFFFFFFFFFFFFF\", 16)", Long.parseUnsignedLong("FFFFFFFFFFFFFFFF", 16));
        p("Long.decode(\"0xFFFF\")", Long.decode("0xFFFF"));
        p("Long.decode(\"0777\")  [octal]", Long.decode("0777"));

        section("Converting to String");
        Long n = 1234567890123L;
        p("n.toString()", n.toString());
        p("Long.toString(255L)", Long.toString(255L));
        p("Long.toString(255L, 2)", Long.toString(255L, 2));
        p("Long.toBinaryString(10L)", Long.toBinaryString(10L));
        p("Long.toOctalString(64L)", Long.toOctalString(64L));
        p("Long.toHexString(255L)", Long.toHexString(255L));
        p("Long.toUnsignedString(-1L)", Long.toUnsignedString(-1L));
        p("Long.toUnsignedString(-1L, 16)", Long.toUnsignedString(-1L, 16));

        section("Conversion to other number types");
        p("n.byteValue()", n.byteValue());
        p("n.shortValue()", n.shortValue());
        p("n.intValue()  [overflows an int]", n.intValue());
        p("n.longValue()", n.longValue());
        p("n.floatValue()", n.floatValue());
        p("n.doubleValue()", n.doubleValue());

        section("Comparison");
        Long a = 10L, b = 20L;
        p("a.compareTo(b)   [a=10, b=20]", a.compareTo(b));
        p("Long.compare(30L, 20L)", Long.compare(30L, 20L));
        p("Long.compareUnsigned(-1L, 1L)", Long.compareUnsigned(-1L, 1L));
        p("a.equals(10L)", a.equals(10L));
        p("a.equals(10)  [Integer, not Long]", a.equals(10));

        section("Math helpers");
        p("Long.sum(5L, 7L)", Long.sum(5L, 7L));
        p("Long.max(5L, 7L)", Long.max(5L, 7L));
        p("Long.min(5L, 7L)", Long.min(5L, 7L));
        p("Long.signum(-42L)", Long.signum(-42L));
        p("Long.divideUnsigned(-1L, 2L)", Long.divideUnsigned(-1L, 2L));
        p("Long.remainderUnsigned(-1L, 10L)", Long.remainderUnsigned(-1L, 10L));

        section("Bit manipulation");
        p("Long.bitCount(255L)", Long.bitCount(255L));
        p("Long.highestOneBit(100L)", Long.highestOneBit(100L));
        p("Long.lowestOneBit(100L)", Long.lowestOneBit(100L));
        p("Long.numberOfLeadingZeros(1L)", Long.numberOfLeadingZeros(1L));
        p("Long.numberOfTrailingZeros(8L)", Long.numberOfTrailingZeros(8L));
        p("Long.reverse(1L)", Long.reverse(1L));
        p("Long.reverseBytes(1L)", Long.reverseBytes(1L));
        p("Long.rotateLeft(1L, 40)", Long.rotateLeft(1L, 40));
        p("Long.rotateRight(1L << 40, 40)", Long.rotateRight(1L << 40, 40));

        section("System properties");
        System.setProperty("demo.long", "9999999999");
        p("Long.getLong(\"demo.long\")", Long.getLong("demo.long"));
        p("Long.getLong(\"missing\", 5L)  [default long]", Long.getLong("missing", 5L));
        p("Long.getLong(\"missing\", Long.valueOf(8L))", Long.getLong("missing", Long.valueOf(8L)));

        section("Hash code");
        p("a.hashCode()", a.hashCode());
        p("Long.hashCode(10L)", Long.hashCode(10L));
    }

    // ======================================================================
    //  5. FLOAT  (primitive: float, 32-bit IEEE 754)
    // ======================================================================
    static void floatDemo() {
        title("5. Float  (primitive: float)");

        section("Constants");
        p("Float.MAX_VALUE", Float.MAX_VALUE);
        p("Float.MIN_VALUE  (smallest positive)", Float.MIN_VALUE);
        p("Float.MIN_NORMAL", Float.MIN_NORMAL);
        p("Float.POSITIVE_INFINITY", Float.POSITIVE_INFINITY);
        p("Float.NEGATIVE_INFINITY", Float.NEGATIVE_INFINITY);
        p("Float.NaN", Float.NaN);
        p("Float.MAX_EXPONENT", Float.MAX_EXPONENT);
        p("Float.MIN_EXPONENT", Float.MIN_EXPONENT);
        p("Float.SIZE (bits)", Float.SIZE);
        p("Float.BYTES", Float.BYTES);
        p("Float.TYPE", Float.TYPE);

        section("Creating objects");
        p("Float.valueOf(3.14f)", Float.valueOf(3.14f));
        p("Float.valueOf(\"2.718\")", Float.valueOf("2.718"));
        Float autoBoxed = 9.5f;
        p("Float autoBoxed = 9.5f;  (autoboxing)", autoBoxed);

        section("Parsing Strings");
        p("Float.parseFloat(\"123.45\")", Float.parseFloat("123.45"));
        p("Float.parseFloat(\"1.5e3\")  [scientific]", Float.parseFloat("1.5e3"));

        section("Converting to String");
        Float f = 12.5f;
        p("f.toString()", f.toString());
        p("Float.toString(0.1f)", Float.toString(0.1f));
        p("Float.toHexString(1.0f)", Float.toHexString(1.0f));

        section("Special-value checks (NaN / Infinity)");
        float nan = 0.0f / 0.0f;
        float inf = 1.0f / 0.0f;
        p("Float.isNaN(nan)", Float.isNaN(nan));
        p("Float.valueOf(nan).isNaN()  [instance]", Float.valueOf(nan).isNaN());
        p("Float.isInfinite(inf)", Float.isInfinite(inf));
        p("Float.valueOf(inf).isInfinite()  [instance]", Float.valueOf(inf).isInfinite());
        p("Float.isFinite(1.5f)", Float.isFinite(1.5f));
        p("Float.isFinite(inf)", Float.isFinite(inf));
        p("nan == nan   (always false!)", nan == nan);
        p("Float.valueOf(nan).equals(nan)  (true)", Float.valueOf(nan).equals(nan));

        section("Conversion to other number types");
        Float g = 7.89f;
        p("g.byteValue()", g.byteValue());
        p("g.shortValue()", g.shortValue());
        p("g.intValue()  [truncates]", g.intValue());
        p("g.longValue()", g.longValue());
        p("g.floatValue()", g.floatValue());
        p("g.doubleValue()", g.doubleValue());

        section("Comparison");
        Float a = 1.5f, b = 2.5f;
        p("a.compareTo(b)   [a=1.5, b=2.5]", a.compareTo(b));
        p("Float.compare(3.0f, 2.0f)", Float.compare(3.0f, 2.0f));
        p("Float.compare(0.0f, -0.0f)", Float.compare(0.0f, -0.0f));
        p("a.equals(1.5f)", a.equals(1.5f));

        section("Math helpers");
        p("Float.sum(1.5f, 2.5f)", Float.sum(1.5f, 2.5f));
        p("Float.max(1.5f, 2.5f)", Float.max(1.5f, 2.5f));
        p("Float.min(1.5f, 2.5f)", Float.min(1.5f, 2.5f));

        section("Bit representation");
        p("Float.floatToIntBits(1.0f) as hex", Integer.toHexString(Float.floatToIntBits(1.0f)));
        p("Float.floatToRawIntBits(1.0f) as hex", Integer.toHexString(Float.floatToRawIntBits(1.0f)));
        p("Float.intBitsToFloat(0x40490fdb)  [~PI]", Float.intBitsToFloat(0x40490fdb));

        section("Hash code");
        p("a.hashCode()", a.hashCode());
        p("Float.hashCode(1.5f)", Float.hashCode(1.5f));
    }

    // ======================================================================
    //  6. DOUBLE  (primitive: double, 64-bit IEEE 754)
    // ======================================================================
    static void doubleDemo() {
        title("6. Double  (primitive: double)");

        section("Constants");
        p("Double.MAX_VALUE", Double.MAX_VALUE);
        p("Double.MIN_VALUE  (smallest positive)", Double.MIN_VALUE);
        p("Double.MIN_NORMAL", Double.MIN_NORMAL);
        p("Double.POSITIVE_INFINITY", Double.POSITIVE_INFINITY);
        p("Double.NEGATIVE_INFINITY", Double.NEGATIVE_INFINITY);
        p("Double.NaN", Double.NaN);
        p("Double.MAX_EXPONENT", Double.MAX_EXPONENT);
        p("Double.MIN_EXPONENT", Double.MIN_EXPONENT);
        p("Double.SIZE (bits)", Double.SIZE);
        p("Double.BYTES", Double.BYTES);
        p("Double.TYPE", Double.TYPE);

        section("Creating objects");
        p("Double.valueOf(3.14159)", Double.valueOf(3.14159));
        p("Double.valueOf(\"2.71828\")", Double.valueOf("2.71828"));
        Double autoBoxed = 99.99;
        p("Double autoBoxed = 99.99;  (autoboxing)", autoBoxed);

        section("Parsing Strings");
        p("Double.parseDouble(\"123.456\")", Double.parseDouble("123.456"));
        p("Double.parseDouble(\"1.5e10\")  [scientific]", Double.parseDouble("1.5e10"));

        section("Converting to String");
        Double d = 12.5;
        p("d.toString()", d.toString());
        p("Double.toString(0.1)", Double.toString(0.1));
        p("Double.toHexString(1.0)", Double.toHexString(1.0));

        section("Special-value checks (NaN / Infinity)");
        double nan = 0.0 / 0.0;
        double inf = 1.0 / 0.0;
        p("Double.isNaN(nan)", Double.isNaN(nan));
        p("Double.valueOf(nan).isNaN()  [instance]", Double.valueOf(nan).isNaN());
        p("Double.isInfinite(inf)", Double.isInfinite(inf));
        p("Double.valueOf(inf).isInfinite()  [instance]", Double.valueOf(inf).isInfinite());
        p("Double.isFinite(1.5)", Double.isFinite(1.5));
        p("Double.isFinite(inf)", Double.isFinite(inf));
        p("nan == nan   (always false!)", nan == nan);
        p("Double.valueOf(nan).equals(nan)  (true)", Double.valueOf(nan).equals(nan));

        section("Conversion to other number types");
        Double g = 7.89;
        p("g.byteValue()", g.byteValue());
        p("g.shortValue()", g.shortValue());
        p("g.intValue()  [truncates]", g.intValue());
        p("g.longValue()", g.longValue());
        p("g.floatValue()", g.floatValue());
        p("g.doubleValue()", g.doubleValue());

        section("Comparison");
        Double a = 1.5, b = 2.5;
        p("a.compareTo(b)   [a=1.5, b=2.5]", a.compareTo(b));
        p("Double.compare(3.0, 2.0)", Double.compare(3.0, 2.0));
        p("Double.compare(0.0, -0.0)", Double.compare(0.0, -0.0));
        p("a.equals(1.5)", a.equals(1.5));

        section("Math helpers");
        p("Double.sum(1.5, 2.5)", Double.sum(1.5, 2.5));
        p("Double.max(1.5, 2.5)", Double.max(1.5, 2.5));
        p("Double.min(1.5, 2.5)", Double.min(1.5, 2.5));

        section("Bit representation");
        p("Double.doubleToLongBits(1.0) as hex", Long.toHexString(Double.doubleToLongBits(1.0)));
        p("Double.doubleToRawLongBits(1.0) as hex", Long.toHexString(Double.doubleToRawLongBits(1.0)));
        p("Double.longBitsToDouble(0x400921FB54442D18L)  [PI]", Double.longBitsToDouble(0x400921FB54442D18L));

        section("Hash code");
        p("a.hashCode()", a.hashCode());
        p("Double.hashCode(1.5)", Double.hashCode(1.5));
    }

    // ======================================================================
    //  7. CHARACTER  (primitive: char, 16-bit unsigned UTF-16 code unit)
    // ======================================================================
    static void characterDemo() {
        title("7. Character  (primitive: char)");

        section("Constants");
        p("(int) Character.MIN_VALUE", (int) Character.MIN_VALUE);
        p("(int) Character.MAX_VALUE", (int) Character.MAX_VALUE);
        p("Character.MIN_RADIX", Character.MIN_RADIX);
        p("Character.MAX_RADIX", Character.MAX_RADIX);
        p("Character.SIZE (bits)", Character.SIZE);
        p("Character.BYTES", Character.BYTES);
        p("Character.TYPE", Character.TYPE);
        p("Character.MIN_CODE_POINT (hex)", Integer.toHexString(Character.MIN_CODE_POINT));
        p("Character.MAX_CODE_POINT (hex)", Integer.toHexString(Character.MAX_CODE_POINT));
        p("Character.MIN_SUPPLEMENTARY_CODE_POINT (hex)", Integer.toHexString(Character.MIN_SUPPLEMENTARY_CODE_POINT));

        section("Creating objects / basic methods");
        Character ch = Character.valueOf('A');
        p("Character.valueOf('A')", ch);
        Character autoBoxed = 'z';
        p("Character autoBoxed = 'z';  (autoboxing)", autoBoxed);
        p("ch.charValue()", ch.charValue());
        p("ch.toString()", ch.toString());
        p("Character.toString('Q')", Character.toString('Q'));

        section("Comparison and hash code");
        Character a = 'a', b = 'b';
        p("a.compareTo(b)   [a='a', b='b']", a.compareTo(b));
        p("Character.compare('z', 'a')", Character.compare('z', 'a'));
        p("a.equals('a')", a.equals('a'));
        p("a.hashCode()", a.hashCode());
        p("Character.hashCode('a')", Character.hashCode('a'));

        section("Character testing (is...)");
        p("Character.isDigit('7')", Character.isDigit('7'));
        p("Character.isLetter('x')", Character.isLetter('x'));
        p("Character.isLetterOrDigit('_')", Character.isLetterOrDigit('_'));
        p("Character.isAlphabetic('k')", Character.isAlphabetic('k'));
        p("Character.isUpperCase('A')", Character.isUpperCase('A'));
        p("Character.isLowerCase('A')", Character.isLowerCase('A'));
        p("Character.isTitleCase('\\u01C5')  [Dz]", Character.isTitleCase('\u01C5'));
        p("Character.isWhitespace(' ')", Character.isWhitespace(' '));
        p("Character.isWhitespace('\\t')", Character.isWhitespace('\t'));
        p("Character.isSpaceChar('\\u00A0')  [no-break space]", Character.isSpaceChar('\u00A0'));
        p("Character.isISOControl('\\n')", Character.isISOControl('\n'));
        p("Character.isDefined('A')", Character.isDefined('A'));
        p("Character.isMirrored('(')", Character.isMirrored('('));
        p("Character.isIdeographic(0x4E2D)  [Chinese]", Character.isIdeographic(0x4E2D));

        section("Identifier checks");
        p("Character.isJavaIdentifierStart('$')", Character.isJavaIdentifierStart('$'));
        p("Character.isJavaIdentifierStart('1')", Character.isJavaIdentifierStart('1'));
        p("Character.isJavaIdentifierPart('1')", Character.isJavaIdentifierPart('1'));
        p("Character.isUnicodeIdentifierStart('a')", Character.isUnicodeIdentifierStart('a'));
        p("Character.isUnicodeIdentifierPart('9')", Character.isUnicodeIdentifierPart('9'));
        p("Character.isIdentifierIgnorable('\\u0000')", Character.isIdentifierIgnorable('\u0000'));

        section("Case conversion");
        p("Character.toUpperCase('b')", Character.toUpperCase('b'));
        p("Character.toLowerCase('B')", Character.toLowerCase('B'));
        p("Character.toTitleCase('b')", Character.toTitleCase('b'));
        p("Character.toUpperCase(0x61)  [int code point]", Character.toUpperCase(0x61));

        section("Digits and numeric values");
        p("Character.digit('7', 10)", Character.digit('7', 10));
        p("Character.digit('F', 16)", Character.digit('F', 16));
        p("Character.digit('Z', 10)  [invalid -> -1]", Character.digit('Z', 10));
        p("Character.forDigit(11, 16)", Character.forDigit(11, 16));
        p("Character.getNumericValue('9')", Character.getNumericValue('9'));
        p("Character.getNumericValue('a')  [letters = 10..35]", Character.getNumericValue('a'));
        p("Character.getNumericValue('\\u2164')  [Roman V]", Character.getNumericValue('\u2164'));

        section("Type, name and direction");
        p("Character.getType('A') == UPPERCASE_LETTER",
                Character.getType('A') == Character.UPPERCASE_LETTER);
        p("Character.getType('a') == LOWERCASE_LETTER",
                Character.getType('a') == Character.LOWERCASE_LETTER);
        p("Character.getType('5') == DECIMAL_DIGIT_NUMBER",
                Character.getType('5') == Character.DECIMAL_DIGIT_NUMBER);
        p("Character.getDirectionality('A') == LEFT_TO_RIGHT",
                Character.getDirectionality('A') == Character.DIRECTIONALITY_LEFT_TO_RIGHT);
        p("Character.getName('A')", Character.getName('A'));
        p("Character.UnicodeBlock.of('A')", Character.UnicodeBlock.of('A'));
        p("Character.UnicodeScript.of('A')", Character.UnicodeScript.of('A'));
        p("Character.reverseBytes('\\u0102') as hex",
                Integer.toHexString(Character.reverseBytes('\u0102')));

        section("Surrogates and code points (emoji, rare scripts)");
        String emoji = "\uD83D\uDE00";   // U+1F600 grinning face
        p("emoji.length()  (UTF-16 units)", emoji.length());
        p("Character.isSurrogate('\\uD83D')", Character.isSurrogate('\uD83D'));
        p("Character.isHighSurrogate('\\uD83D')", Character.isHighSurrogate('\uD83D'));
        p("Character.isLowSurrogate('\\uDE00')", Character.isLowSurrogate('\uDE00'));
        p("Character.isSurrogatePair('\\uD83D', '\\uDE00')", Character.isSurrogatePair('\uD83D', '\uDE00'));
        p("Character.isSupplementaryCodePoint(0x1F600)", Character.isSupplementaryCodePoint(0x1F600));
        p("Character.isBmpCodePoint(0x41)", Character.isBmpCodePoint(0x41));
        p("Character.isValidCodePoint(0x110000)", Character.isValidCodePoint(0x110000));
        p("Character.charCount(0x1F600)", Character.charCount(0x1F600));
        p("Character.toCodePoint('\\uD83D', '\\uDE00') hex",
                Integer.toHexString(Character.toCodePoint('\uD83D', '\uDE00')));
        p("Character.highSurrogate(0x1F600) as hex",
                Integer.toHexString(Character.highSurrogate(0x1F600)));
        p("Character.lowSurrogate(0x1F600) as hex",
                Integer.toHexString(Character.lowSurrogate(0x1F600)));
        p("Character.codePointAt(emoji, 0) hex", Integer.toHexString(Character.codePointAt(emoji, 0)));
        p("Character.codePointAt(char[], 0) hex",
                Integer.toHexString(Character.codePointAt(emoji.toCharArray(), 0)));
        p("Character.codePointBefore(emoji, 2) hex", Integer.toHexString(Character.codePointBefore(emoji, 2)));
        p("Character.codePointCount(emoji, 0, 2)", Character.codePointCount(emoji, 0, emoji.length()));
        p("Character.offsetByCodePoints(\"a\"+emoji+\"b\", 0, 2)",
                Character.offsetByCodePoints("a" + emoji + "b", 0, 2));
        p("Character.toChars(0x1F600).length", Character.toChars(0x1F600).length);
    }

    // ======================================================================
    //  8. BOOLEAN  (primitive: boolean)
    // ======================================================================
    static void booleanDemo() {
        title("8. Boolean  (primitive: boolean)");

        section("Constants");
        p("Boolean.TRUE", Boolean.TRUE);
        p("Boolean.FALSE", Boolean.FALSE);
        p("Boolean.TYPE", Boolean.TYPE);

        section("Creating objects");
        p("Boolean.valueOf(true)", Boolean.valueOf(true));
        p("Boolean.valueOf(\"true\")", Boolean.valueOf("true"));
        p("Boolean.valueOf(\"TRUE\")  [case-insensitive]", Boolean.valueOf("TRUE"));
        p("Boolean.valueOf(\"yes\")   [anything else = false]", Boolean.valueOf("yes"));
        p("Boolean.valueOf((String) null)", Boolean.valueOf((String) null));
        Boolean autoBoxed = true;
        p("Boolean autoBoxed = true;  (autoboxing)", autoBoxed);

        section("Parsing Strings");
        p("Boolean.parseBoolean(\"true\")", Boolean.parseBoolean("true"));
        p("Boolean.parseBoolean(\"False\")", Boolean.parseBoolean("False"));
        p("Boolean.parseBoolean(\"1\")  [not 'true' -> false]", Boolean.parseBoolean("1"));

        section("Converting to value / String");
        Boolean flag = Boolean.TRUE;
        p("flag.booleanValue()", flag.booleanValue());
        p("flag.toString()", flag.toString());
        p("Boolean.toString(false)", Boolean.toString(false));

        section("Comparison");
        p("flag.compareTo(Boolean.FALSE)", flag.compareTo(Boolean.FALSE));
        p("Boolean.compare(false, true)", Boolean.compare(false, true));
        p("Boolean.compare(true, true)", Boolean.compare(true, true));
        p("flag.equals(true)", flag.equals(true));
        p("flag.equals(\"true\")", flag.equals("true"));

        section("Hash code");
        p("Boolean.TRUE.hashCode()", Boolean.TRUE.hashCode());
        p("Boolean.FALSE.hashCode()", Boolean.FALSE.hashCode());
        p("Boolean.hashCode(true)", Boolean.hashCode(true));

        section("Logical operations");
        p("Boolean.logicalAnd(true, false)", Boolean.logicalAnd(true, false));
        p("Boolean.logicalOr(true, false)", Boolean.logicalOr(true, false));
        p("Boolean.logicalXor(true, true)", Boolean.logicalXor(true, true));
        p("Boolean.logicalXor(true, false)", Boolean.logicalXor(true, false));

        section("System properties");
        System.setProperty("demo.flag", "true");
        p("Boolean.getBoolean(\"demo.flag\")", Boolean.getBoolean("demo.flag"));
        p("Boolean.getBoolean(\"missing.flag\")", Boolean.getBoolean("missing.flag"));
    }
}