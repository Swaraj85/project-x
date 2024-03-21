package com.swaraj.projectx.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
class Book {
    private String title;
    private int isbnNumber;
}
