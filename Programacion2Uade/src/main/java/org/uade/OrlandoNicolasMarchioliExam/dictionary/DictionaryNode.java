package org.uade.OrlandoNicolasMarchioliExam.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DictionaryNode {

    private int key;
    private int value;
    private DictionaryNode next;

}
