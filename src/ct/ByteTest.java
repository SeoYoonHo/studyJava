package ct;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteTest {
    public static void main(String[] args) {
        String str = "12바1234";
        byte[] rrr = new byte[20];
        Arrays.fill(rrr, (byte) 0x20);

        byte[] strBytes = str.getBytes ();

        String hexDump = formatHexDump(strBytes);

        System.out.println(hexDump);
        System.out.println(new String(strBytes, StandardCharsets.UTF_8));
    }

    public static String formatHexDump(byte[] array) {
        final int width = 16;
        int offset = 0;
        int length = array.length;

        StringBuilder builder = new StringBuilder();

        for (int rowOffset = offset; rowOffset < offset + length; rowOffset += width) {
            builder.append(String.format("%06d:  ", rowOffset));

            for (int index = 0; index < width; index++) {
                if (rowOffset + index < array.length) {
                    builder.append(String.format("%02x ", array[rowOffset + index]));
                } else {
                    builder.append("   ");
                }
            }

            if (rowOffset < array.length) {
                int asciiWidth = Math.min(width, array.length - rowOffset);
                builder.append("  |  ");
                try {
                    builder.append(new String(array, rowOffset, asciiWidth, "UTF-8").replaceAll("\r\n", " ")
                                                                                    .replaceAll("\n", " "));
                } catch (UnsupportedEncodingException ignored) {
                    //If UTF-8 isn't available as an encoding then what can we do?!
                }
            }

            builder.append(String.format("%n"));
        }

        return builder.toString();
    }
}
