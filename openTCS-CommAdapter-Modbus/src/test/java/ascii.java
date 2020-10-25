/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */

public class ascii {
    public static void main(String[] args) {
        int a = 0x30;
        byte[] b = {49};
        String s = null;
        try {

        s = new String(b, "ISO8859-1");
        } catch ( Exception e ) {

        }
//		String s = new String(new byte[]{'A', 'B', 'C'}, "US-ASCII");
//		System.out.println(b & 0xFF);
        System.out.printf("%s \n", s);
//		System.out.println(Byte.toString(b));
        System.out.printf("%x \n", a);
        System.out.printf("%d \n", a);
    }

}
