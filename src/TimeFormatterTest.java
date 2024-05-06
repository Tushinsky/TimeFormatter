import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeFormatterTest {

    @Test
    public void exampleTests() {
//        assertEquals("1 second", TimeFormatter.formatDuration(1));
//        assertEquals("35 seconds", TimeFormatter.formatDuration(35));
//        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
//        assertEquals("1 minute and 1 second", TimeFormatter.formatDuration(61));
//        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
//        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
//        assertEquals("now", TimeFormatter.formatDuration(0));
    }
}
