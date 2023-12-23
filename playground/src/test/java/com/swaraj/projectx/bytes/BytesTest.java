package com.swaraj.projectx.bytes;

import org.apache.logging.log4j.util.PropertySource;
import org.assertj.core.internal.Comparables;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BytesTest {

    @Test
    void bytesTest() throws IOException {
        int value = 23456;
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(value);
        byte[] array = buffer.array();
        System.out.println("array = " + array);
        System.out.println("\"asasasas\".hashCode() = " + "asasasas".hashCode());
    }
}
