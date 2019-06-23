package test.main.java.ua.lviv.iot.TextEditor;

import main.java.ua.lviv.iot.TextEditor.StringProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.LinkedList;
import java.util.List;

public class StringProcessorTest {

    private StringProcessor sp = new StringProcessor();

    private String testString;

    private StringBuilder expected;

    private StringBuilder actual;

    @Before
    public void setUp() throws Exception {

        expected = new StringBuilder();

        actual = new StringBuilder();

        testString =
                 " Ja-va is $the-best programming $language"
                + " I $like-play $computer-games"
                + " Lon-don is the $capital of $Great-Bri-tain"
                + " The $bo-ok is o-n the $ta-ble";

        expected.append("$thebest$likeplay$computergames$GreatBri$book$table");
        sp.setUserInput(testString);

    }

    @Test
    public void testProccesText(){
        actual = sp.processText();

        Assertions.assertEquals(expected.toString(), actual.toString());

        sp.showResults();
    }

    @Test
    public void noMatch() {

        sp.setUserInput("");

        actual = sp.processText();

        Assertions.assertNotEquals(expected, actual);

        sp.showResults();

    }

}