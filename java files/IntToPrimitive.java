class IntToPrimitive 
{
    public static void main(String[] arg)
    {
        int a=65;       
        System.out.println("primitive int to other primitive types:");
        System.out.println("int value:    " + a);
        System.out.println("byte value:   " + (byte)a);
        System.out.println("short value:  " + (short)a);
        System.out.println("long value:   " + (long)a);
        System.out.println("char value:  " + (char)a);
        System.out.println("float value:  " + (float)a);
        System.out.println("double value: " + (double)a + "\n");
        System.out.println("Integer object to other primitive types:");
        Integer obj = new Integer(a);
        System.out.println("byte value:   " + obj.byteValue());
        System.out.println("int value:    " + obj.intValue());
        System.out.println("short value:  " + obj.shortValue());
        System.out.println("long value:   " + obj.longValue());
        System.out.println("float value:  " + obj.floatValue());
        System.out.println("double value: " + obj.doubleValue());
    }
}