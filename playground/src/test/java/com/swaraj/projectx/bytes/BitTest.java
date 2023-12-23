package com.swaraj.projectx.bytes;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitTest {
    @Test
    void leftShiftOperator() throws IOException {
        //left shift x by n positions <=> x * 2n

        long value = 10L;
        System.out.println("Long.toBinaryString(value) = " + Long.toBinaryString(value));

        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(value);
        byte[] array = buffer.array();

        long leftShiftBy2bit = value << 2;
        System.out.println("Long.toBinaryString(leftShiftBy2bit) = " + Long.toBinaryString(leftShiftBy2bit));

        long unchanged= leftShiftBy2bit << 0;

        assertEquals(40L, leftShiftBy2bit);
        assertEquals(leftShiftBy2bit, unchanged);
    }
}
